package com.tencent.mm.plugin.normsg.c;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;
import java.util.WeakHashMap;

public final class c
{
  private static final Map<View, Class<? extends com.tencent.mm.sdk.b.b>> wuT;
  private static final Map<View, Boolean> wuU;
  
  static
  {
    AppMethodBeat.i(149088);
    wuT = new WeakHashMap();
    wuU = new WeakHashMap();
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
        synchronized (wuT)
        {
          do
          {
            wuT.put(paramView, paramClass);
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
    private final View.OnClickListener wuV;
    
    a(View.OnClickListener paramOnClickListener)
    {
      this.wuV = paramOnClickListener;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149085);
      ??? = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)???).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/normsg/utils/ClickBotCheckHelper$CheckerOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)???).ahq());
      synchronized (c.wuT)
      {
        if (!c.wuT.containsKey(paramView))
        {
          if (this.wuV != null) {
            this.wuV.onClick(paramView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/normsg/utils/ClickBotCheckHelper$CheckerOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(149085);
          return;
        }
      }
      for (;;)
      {
        synchronized (c.aaT())
        {
          for (;;)
          {
            if (!c.aaT().containsKey(paramView))
            {
              Class localClass = (Class)c.wuT.get(paramView);
              if (localClass != null) {}
              try
              {
                com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localClass.newInstance());
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
        c.aaT().remove(paramView);
      }
    }
  }
  
  static final class b
    implements View.OnTouchListener
  {
    private final View.OnTouchListener wuW;
    
    b(View.OnTouchListener paramOnTouchListener)
    {
      this.wuW = paramOnTouchListener;
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(149086);
      ??? = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)???).bd(paramView);
      ((com.tencent.mm.hellhoundlib.b.b)???).bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/normsg/utils/ClickBotCheckHelper$CheckerOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)???).ahq());
      for (;;)
      {
        synchronized (c.wuT)
        {
          if (!c.wuT.containsKey(paramView))
          {
            if (this.wuW == null) {
              break;
            }
            boolean bool = this.wuW.onTouch(paramView, paramMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/normsg/utils/ClickBotCheckHelper$CheckerOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(149086);
            return bool;
          }
        }
        synchronized (c.aaT())
        {
          c.aaT().put(paramView, Boolean.TRUE);
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