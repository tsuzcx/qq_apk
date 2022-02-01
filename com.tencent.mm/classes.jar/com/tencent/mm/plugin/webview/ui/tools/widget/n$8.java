package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$8", "Landroid/view/View$OnTouchListener;", "onTouch", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-webview_release"})
public final class n$8
  implements View.OnTouchListener
{
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(175690);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    p.h(paramView, "view");
    p.h(paramMotionEvent, "event");
    if ((paramView.getId() == 2131302503) && (n.b(this.EJN).getLineCount() >= 5))
    {
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      if (paramMotionEvent.getAction() == 1) {
        paramView.getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(175690);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.8
 * JD-Core Version:    0.7.0.1
 */