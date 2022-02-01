package com.tencent.mm.plugin.normsg.c;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;
import java.util.WeakHashMap;

public final class c
{
  private static final Map<View, Class<? extends com.tencent.mm.sdk.b.b>> wKD;
  private static final Map<View, Boolean> wKE;
  
  static
  {
    AppMethodBeat.i(149088);
    wKD = new WeakHashMap();
    wKE = new WeakHashMap();
    AppMethodBeat.o(149088);
  }
  
  public static void a(View paramView, Class<? extends com.tencent.mm.sdk.b.b> paramClass)
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
      ??? = (View.OnTouchListener)i.d(localObject2, "mOnTouchListener");
      localObject2 = (View.OnClickListener)i.d(localObject2, "mOnClickListener");
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
        synchronized (wKD)
        {
          do
          {
            wKD.put(paramView, paramClass);
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
    private final View.OnClickListener wKF;
    
    a(View.OnClickListener paramOnClickListener)
    {
      this.wKF = paramOnClickListener;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149085);
      ??? = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)???).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/normsg/utils/ClickBotCheckHelper$CheckerOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)???).ahF());
      synchronized (c.wKD)
      {
        if (!c.wKD.containsKey(paramView))
        {
          if (this.wKF != null) {
            this.wKF.onClick(paramView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/normsg/utils/ClickBotCheckHelper$CheckerOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(149085);
          return;
        }
      }
      for (;;)
      {
        synchronized (c.abc())
        {
          for (;;)
          {
            if (!c.abc().containsKey(paramView))
            {
              Class localClass = (Class)c.wKD.get(paramView);
              if (localClass != null) {}
              try
              {
                com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localClass.newInstance());
                break;
                paramView = finally;
                AppMethodBeat.o(149085);
                throw paramView;
              }
              catch (Throwable localThrowable)
              {
                for (;;)
                {
                  ae.printErrStackTrace("MicroMsg.CBCH", localThrowable, "failure to instantiate event class: " + localClass.getName(), new Object[0]);
                }
              }
            }
          }
        }
        c.abc().remove(paramView);
      }
    }
  }
  
  static final class b
    implements View.OnTouchListener
  {
    private final View.OnTouchListener wKG;
    
    b(View.OnTouchListener paramOnTouchListener)
    {
      this.wKG = paramOnTouchListener;
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(149086);
      ??? = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)???).bd(paramView);
      ((com.tencent.mm.hellhoundlib.b.b)???).bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/normsg/utils/ClickBotCheckHelper$CheckerOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)???).ahF());
      for (;;)
      {
        synchronized (c.wKD)
        {
          if (!c.wKD.containsKey(paramView))
          {
            if (this.wKG == null) {
              break;
            }
            boolean bool = this.wKG.onTouch(paramView, paramMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/normsg/utils/ClickBotCheckHelper$CheckerOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(149086);
            return bool;
          }
        }
        synchronized (c.abc())
        {
          c.abc().put(paramView, Boolean.TRUE);
          continue;
          paramView = finally;
          AppMethodBeat.o(149086);
          throw paramView;
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/normsg/utils/ClickBotCheckHelper$CheckerOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(149086);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.c
 * JD-Core Version:    0.7.0.1
 */