package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
final class n$3
  implements View.OnTouchListener
{
  n$3(n paramn) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(82693);
    p.g(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      paramView = this.JzC;
      if (paramView.JjT != -3) {
        break label46;
      }
      paramView.JzA.hideVKB();
    }
    for (;;)
    {
      AppMethodBeat.o(82693);
      return true;
      label46:
      if ((paramView.getSayFooter().giw()) && (paramView.bJw())) {
        paramView.getSayFooter().fjJ();
      } else {
        paramView.hide();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.3
 * JD-Core Version:    0.7.0.1
 */