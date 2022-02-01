package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
final class n$3
  implements View.OnTouchListener
{
  n$3(n paramn) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(82693);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    p.g(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      paramView = this.Erx;
      if (paramView.Eex != -3) {
        break label93;
      }
      paramView.Erv.hideVKB();
    }
    for (;;)
    {
      a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(82693);
      return true;
      label93:
      if ((paramView.getSayFooter().eVD()) && (paramView.bni())) {
        paramView.getSayFooter().edA();
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