package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
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
      paramView = this.Bvo;
      if (paramView.BiC != -3) {
        break label46;
      }
      paramView.Bvm.hideVKB();
    }
    for (;;)
    {
      AppMethodBeat.o(82693);
      return true;
      label46:
      if ((paramView.getSayFooter().erj()) && (paramView.bcB())) {
        paramView.getSayFooter().dCL();
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