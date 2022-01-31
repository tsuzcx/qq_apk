package com.tencent.mm.plugin.sns.ui.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsCommentCollapseLayout$1
  implements View.OnTouchListener
{
  SnsCommentCollapseLayout$1(SnsCommentCollapseLayout paramSnsCommentCollapseLayout) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(40479);
    if (paramMotionEvent.getAction() == 0) {
      paramView.setTag(2131820681, new int[] { (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY() });
    }
    AppMethodBeat.o(40479);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout.1
 * JD-Core Version:    0.7.0.1
 */