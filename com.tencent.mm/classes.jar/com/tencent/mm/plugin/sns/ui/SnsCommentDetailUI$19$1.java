package com.tencent.mm.plugin.sns.ui;

final class SnsCommentDetailUI$19$1
  implements Runnable
{
  SnsCommentDetailUI$19$1(SnsCommentDetailUI.19 param19, boolean paramBoolean) {}
  
  public final void run()
  {
    if ((this.emz) && (!this.oWX.oWW.isFinishing()) && (this.oWX.oWW.oWT < 5)) {
      this.oWX.oWW.bIB();
    }
    SnsCommentDetailUI localSnsCommentDetailUI = this.oWX.oWW;
    localSnsCommentDetailUI.oWT += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.19.1
 * JD-Core Version:    0.7.0.1
 */