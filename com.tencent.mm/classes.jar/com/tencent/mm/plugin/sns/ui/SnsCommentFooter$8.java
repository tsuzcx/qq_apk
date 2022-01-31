package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsCommentFooter$8
  implements View.OnTouchListener
{
  SnsCommentFooter$8(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38886);
    SnsCommentFooter.l(this.rQk);
    SnsCommentFooter.m(this.rQk);
    SnsCommentFooter.k(this.rQk).setImageResource(2130838345);
    if (SnsCommentFooter.n(this.rQk) != null) {
      SnsCommentFooter.n(this.rQk).cvb();
    }
    SnsCommentFooter.a(this.rQk, 0);
    AppMethodBeat.o(38886);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.8
 * JD-Core Version:    0.7.0.1
 */