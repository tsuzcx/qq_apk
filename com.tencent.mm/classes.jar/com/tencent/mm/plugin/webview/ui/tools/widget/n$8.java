package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$8", "Landroid/view/View$OnTouchListener;", "onTouch", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-webview_release"})
public final class n$8
  implements View.OnTouchListener
{
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(175690);
    k.h(paramView, "view");
    k.h(paramMotionEvent, "event");
    if ((paramView.getId() == 2131302503) && (n.b(this.Bvo).getLineCount() >= 5))
    {
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      if (paramMotionEvent.getAction() == 1) {
        paramView.getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    AppMethodBeat.o(175690);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.8
 * JD-Core Version:    0.7.0.1
 */