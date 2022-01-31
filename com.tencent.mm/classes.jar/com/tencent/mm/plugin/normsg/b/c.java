package com.tencent.mm.plugin.normsg.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import java.util.Map;
import java.util.WeakHashMap;

public final class c
{
  private static final Map<View, Class<? extends b>> phZ;
  private static final Map<View, Boolean> pia;
  
  static
  {
    AppMethodBeat.i(10435);
    phZ = new WeakHashMap();
    pia = new WeakHashMap();
    AppMethodBeat.o(10435);
  }
  
  public static void a(View paramView, Class<? extends b> paramClass)
  {
    AppMethodBeat.i(10434);
    if (paramView == null)
    {
      paramView = new IllegalArgumentException("target is null.");
      AppMethodBeat.o(10434);
      throw paramView;
    }
    if (paramClass == null)
    {
      paramView = new IllegalArgumentException("reportEventClass is null.");
      AppMethodBeat.o(10434);
      throw paramView;
    }
    Object localObject2 = h.b(paramView, "getListenerInfo", null, new Object[0]);
    if (localObject2 != null)
    {
      ??? = (View.OnTouchListener)h.g(localObject2, "mOnTouchListener");
      localObject2 = (View.OnClickListener)h.g(localObject2, "mOnClickListener");
    }
    for (;;)
    {
      if (??? == null) {
        paramView.setOnTouchListener(new c.b(null));
      }
      for (;;)
      {
        if (localObject2 == null) {
          paramView.setOnClickListener(new c.a(null));
        }
        synchronized (phZ)
        {
          do
          {
            phZ.put(paramView, paramClass);
            AppMethodBeat.o(10434);
            return;
            if ((??? instanceof c.b)) {
              break;
            }
            paramView.setOnTouchListener(new c.b((View.OnTouchListener)???));
            break;
          } while ((localObject2 instanceof c.a));
          paramView.setOnClickListener(new c.a((View.OnClickListener)localObject2));
        }
      }
      localObject2 = null;
      ??? = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.c
 * JD-Core Version:    0.7.0.1
 */