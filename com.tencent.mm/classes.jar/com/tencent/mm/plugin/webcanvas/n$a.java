package com.tencent.mm.plugin.webcanvas;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ab.c.a;
import com.tencent.mm.plugin.ab.f;
import com.tencent.mm.plugin.ab.f.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch", "com/tencent/mm/plugin/webcanvas/WebCanvasViewContext$elementId$1$2"})
final class n$a
  implements View.OnTouchListener
{
  n$a(n paramn) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(224759);
    c localc = this.IAT.IAS.fWl();
    Object localObject = this.IAT.IAS.lAN;
    p.g(paramMotionEvent, "event");
    p.h(localObject, "canvasId");
    p.h(paramMotionEvent, "touch");
    switch (paramMotionEvent.getAction())
    {
    default: 
      paramView = null;
    }
    for (;;)
    {
      if (paramView != null)
      {
        int i = paramMotionEvent.getActionIndex();
        localObject = new StringBuilder("\n                {\n                    target:\"").append((String)localObject).append("\",\n                    touches: [{\n                        identifier:").append(paramMotionEvent.getPointerId(i)).append(",\n                        clientX:");
        f.a locala = f.IBd;
        localObject = ((StringBuilder)localObject).append(f.a.d((Number)Float.valueOf(paramMotionEvent.getX()))).append(",\n                        clientY:");
        locala = f.IBd;
        c.a.a(localc, paramView, kotlin.n.n.buv(f.a.d((Number)Float.valueOf(paramMotionEvent.getY())) + "\n                    }]\n                }\n            "), null, 4);
      }
      AppMethodBeat.o(224759);
      return true;
      paramView = "touchend";
      continue;
      paramView = "touchstart";
      continue;
      paramView = "touchmove";
      continue;
      paramView = "touchcancel";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.n.a
 * JD-Core Version:    0.7.0.1
 */