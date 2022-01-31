package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

final class SnsCommentFooter$6
  implements View.OnClickListener
{
  SnsCommentFooter$6(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void onClick(View paramView)
  {
    this.oXQ.setModeClick(true);
    y.i("MicroMsg.SnsCommentFooter", "state onClick" + SnsCommentFooter.k(this.oXQ));
    if (SnsCommentFooter.k(this.oXQ) == 0)
    {
      this.oXQ.bER.XM();
      SnsCommentFooter.d(this.oXQ).requestFocus();
      SnsCommentFooter.a(this.oXQ, 1);
      SnsCommentFooter.l(this.oXQ);
      SnsCommentFooter.m(this.oXQ).setImageResource(i.e.chatting_setmode_keyboard_btn);
      SnsCommentFooter.n(this.oXQ);
      return;
    }
    SnsCommentFooter.o(this.oXQ);
    SnsCommentFooter.n(this.oXQ);
    SnsCommentFooter.d(this.oXQ).requestFocus();
    this.oXQ.bER.showVKB();
    SnsCommentFooter.m(this.oXQ).setImageResource(i.e.chatting_setmode_biaoqing_btn);
    SnsCommentFooter.a(this.oXQ, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.6
 * JD-Core Version:    0.7.0.1
 */