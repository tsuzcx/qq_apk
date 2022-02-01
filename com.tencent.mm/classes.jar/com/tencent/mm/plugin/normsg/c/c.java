package com.tencent.mm.plugin.normsg.c;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;
import java.util.WeakHashMap;

public final class c
{
  private static final Map<View, Class<? extends b>> ugC;
  private static final Map<View, Boolean> ugD;
  
  static
  {
    AppMethodBeat.i(149088);
    ugC = new WeakHashMap();
    ugD = new WeakHashMap();
    AppMethodBeat.o(149088);
  }
  
  public static void a(View paramView, Class<? extends b> paramClass)
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
    Object localObject2 = h.b(paramView, "getListenerInfo", null, new Object[0]);
    if (localObject2 != null)
    {
      ??? = (View.OnTouchListener)h.d(localObject2, "mOnTouchListener");
      localObject2 = (View.OnClickListener)h.d(localObject2, "mOnClickListener");
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
        synchronized (ugC)
        {
          do
          {
            ugC.put(paramView, paramClass);
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
      localObject2 = null;
      ??? = null;
    }
  }
  
  static final class a
    implements View.OnClickListener
  {
    private final View.OnClickListener ugE;
    
    a(View.OnClickListener paramOnClickListener)
    {
      this.ugE = paramOnClickListener;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149085);
      synchronized (c.ugC)
      {
        if (!c.ugC.containsKey(paramView))
        {
          if (this.ugE != null) {
            this.ugE.onClick(paramView);
          }
          AppMethodBeat.o(149085);
          return;
        }
      }
      for (;;)
      {
        synchronized (c.Xu())
        {
          for (;;)
          {
            if (!c.Xu().containsKey(paramView))
            {
              Class localClass = (Class)c.ugC.get(paramView);
              if (localClass != null) {}
              try
              {
                a.ESL.l((b)localClass.newInstance());
                break;
                paramView = finally;
                AppMethodBeat.o(149085);
                throw paramView;
              }
              catch (Throwable localThrowable)
              {
                for (;;)
                {
                  ad.printErrStackTrace("MicroMsg.CBCH", localThrowable, "failure to instantiate event class: " + localClass.getName(), new Object[0]);
                }
              }
            }
          }
        }
        c.Xu().remove(paramView);
      }
    }
  }
  
  static final class b
    implements View.OnTouchListener
  {
    private final View.OnTouchListener ugF;
    
    b(View.OnTouchListener paramOnTouchListener)
    {
      this.ugF = paramOnTouchListener;
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(149086);
      for (;;)
      {
        synchronized (c.ugC)
        {
          if (!c.ugC.containsKey(paramView))
          {
            if (this.ugF == null) {
              break;
            }
            boolean bool = this.ugF.onTouch(paramView, paramMotionEvent);
            AppMethodBeat.o(149086);
            return bool;
          }
        }
        synchronized (c.Xu())
        {
          c.Xu().put(paramView, Boolean.TRUE);
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
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.c
 * JD-Core Version:    0.7.0.1
 */