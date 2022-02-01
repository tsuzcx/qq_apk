package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
final class n$3
  implements View.OnTouchListener
{
  n$3(n paramn) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(82693);
    k.g(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      paramView = this.CNx;
      if (paramView.CAP != -3) {
        break label46;
      }
      paramView.CNv.hideVKB();
    }
    for (;;)
    {
      AppMethodBeat.o(82693);
      return true;
      label46:
      if ((paramView.getSayFooter().eGD()) && (paramView.bjw())) {
        paramView.getSayFooter().dRi();
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