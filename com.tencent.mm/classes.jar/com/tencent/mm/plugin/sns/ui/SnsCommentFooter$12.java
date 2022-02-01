package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.i;

final class SnsCommentFooter$12
  implements View.OnTouchListener
{
  SnsCommentFooter$12(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(369913);
    this.RqJ.setToSendTextColor(true);
    SnsCommentFooter.m(this.RqJ);
    SnsCommentFooter.n(this.RqJ);
    SnsCommentFooter.l(this.RqJ).setImageResource(b.i.icons_outlined_emoji);
    if (SnsCommentFooter.p(this.RqJ) != null) {
      SnsCommentFooter.p(this.RqJ).hov();
    }
    SnsCommentFooter.a(this.RqJ, 0);
    AppMethodBeat.o(369913);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.12
 * JD-Core Version:    0.7.0.1
 */