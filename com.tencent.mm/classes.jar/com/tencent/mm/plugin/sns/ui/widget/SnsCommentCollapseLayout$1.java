package com.tencent.mm.plugin.sns.ui.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SnsCommentCollapseLayout$1
  implements View.OnTouchListener
{
  SnsCommentCollapseLayout$1(SnsCommentCollapseLayout paramSnsCommentCollapseLayout) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(100506);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/sns/ui/widget/SnsCommentCollapseLayout$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    if (paramMotionEvent.getAction() == 0) {
      paramView.setTag(2131306044, new int[] { (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY() });
    }
    a.a(false, this, "com/tencent/mm/plugin/sns/ui/widget/SnsCommentCollapseLayout$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(100506);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout.1
 * JD-Core Version:    0.7.0.1
 */