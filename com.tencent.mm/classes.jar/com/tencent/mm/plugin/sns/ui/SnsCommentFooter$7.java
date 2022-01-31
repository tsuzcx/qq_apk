package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;

final class SnsCommentFooter$7
  implements View.OnTouchListener
{
  SnsCommentFooter$7(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    SnsCommentFooter.n(this.oXQ);
    SnsCommentFooter.b(this.oXQ).setVisibility(8);
    SnsCommentFooter.b(this.oXQ).onPause();
    SnsCommentFooter.m(this.oXQ).setImageResource(i.e.chatting_setmode_biaoqing_btn);
    if (SnsCommentFooter.p(this.oXQ) != null) {
      SnsCommentFooter.p(this.oXQ).bIG();
    }
    SnsCommentFooter.a(this.oXQ, 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.7
 * JD-Core Version:    0.7.0.1
 */