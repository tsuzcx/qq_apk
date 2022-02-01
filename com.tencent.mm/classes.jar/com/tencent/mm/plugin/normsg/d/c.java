package com.tencent.mm.plugin.normsg.d;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.WeakHashMap;

public final class c
{
  private static final Map<View, Class<? extends IEvent>> Gzn;
  private static final Map<View, Boolean> Gzo;
  
  static
  {
    AppMethodBeat.i(149088);
    Gzn = new WeakHashMap();
    Gzo = new WeakHashMap();
    AppMethodBeat.o(149088);
  }
  
  public static void a(View paramView, Class<? extends IEvent> paramClass)
  {
    AppMethodBeat.i(149087);
    if (paramView == null)
    {
      paramView = new IllegalArgumentException("target is null.");
      AppMethodBeat.o(149087);
      throw paramView;
    }
    if (paramClass == null)
    {
      paramView = new IllegalArgumentException("reportEventClass is null.");
      AppMethodBeat.o(149087);
      throw paramView;
    }
    Object localObject2 = i.b(paramView, "getListenerInfo", null, new Object[0]);
    if (localObject2 != null)
    {
      ??? = (View.OnTouchListener)i.g(localObject2, "mOnTouchListener");
      localObject2 = (View.OnClickListener)i.g(localObject2, "mOnClickListener");
    }
    for (;;)
    {
      if (??? == null) {
        paramView.setOnTouchListener(new b(null));
      }
      for (;;)
      {
        if (localObject2 == null) {
          paramView.setOnClickListener(new a(null));
        }
        synchronized (Gzn)
        {
          do
          {
            Gzn.put(paramView, paramClass);
            AppMethodBeat.o(149087);
            return;
            if ((??? instanceof b)) {
              break;
            }
            paramView.setOnTouchListener(new b((View.OnTouchListener)???));
            break;
          } while ((localObject2 instanceof a));
          paramView.setOnClickListener(new a((View.OnClickListener)localObject2));
        }
      }
    }
  }
  
  static final class a
    implements View.OnClickListener
  {
    private final View.OnClickListener Gzp;
    
    a(View.OnClickListener paramOnClickListener)
    {
      this.Gzp = paramOnClickListener;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149085);
      ??? = new b();
      ((b)???).bn(paramView);
      a.c("com/tencent/mm/plugin/normsg/utils/ClickBotCheckHelper$CheckerOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)???).aFi());
      synchronized (c.Gzn)
      {
        if (!c.Gzn.containsKey(paramView))
        {
          if (this.Gzp != null) {
            this.Gzp.onClick(paramView);
          }
          a.a(this, "com/tencent/mm/plugin/normsg/utils/ClickBotCheckHelper$CheckerOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(149085);
          return;
        }
      }
      for (;;)
      {
        synchronized (c.avo())
        {
          for (;;)
          {
            if (!c.avo().containsKey(paramView))
            {
              Class localClass = (Class)c.Gzn.get(paramView);
              if (localClass != null) {}
              try
              {
                EventCenter.instance.publish((IEvent)localClass.newInstance());
                break;
                paramView = finally;
                AppMethodBeat.o(149085);
                throw paramView;
              }
              catch (Throwable localThrowable)
              {
                for (;;)
                {
                  Log.printErrStackTrace("MicroMsg.CBCH", localThrowable, "failure to instantiate event class: " + localClass.getName(), new Object[0]);
                }
              }
            }
          }
        }
        c.avo().remove(paramView);
      }
    }
  }
  
  static final class b
    implements View.OnTouchListener
  {
    private final View.OnTouchListener Gzq;
    
    b(View.OnTouchListener paramOnTouchListener)
    {
      this.Gzq = paramOnTouchListener;
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(149086);
      for (;;)
      {
        synchronized (c.Gzn)
        {
          if (!c.Gzn.containsKey(paramView))
          {
            if (this.Gzq == null) {
              break;
            }
            boolean bool = this.Gzq.onTouch(paramView, paramMotionEvent);
            AppMethodBeat.o(149086);
            return bool;
          }
        }
        synchronized (c.avo())
        {
          c.avo().put(paramView, Boolean.TRUE);
          continue;
          paramView = finally;
          AppMethodBeat.o(149086);
          throw paramView;
        }
      }
      AppMethodBeat.o(149086);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.c
 * JD-Core Version:    0.7.0.1
 */