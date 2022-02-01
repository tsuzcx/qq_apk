package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$8", "Landroid/view/View$OnTouchListener;", "onTouch", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-webview_release"})
public final class n$8
  implements View.OnTouchListener
{
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(175690);
    p.k(paramView, "view");
    p.k(paramMotionEvent, "event");
    if ((paramView.getId() == c.f.mp_video_comment_et) && (n.b(this.QxO).getLineCount() >= 5))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.8
 * JD-Core Version:    0.7.0.1
 */