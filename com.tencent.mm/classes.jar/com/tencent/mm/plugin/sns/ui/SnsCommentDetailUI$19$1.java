package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsCommentDetailUI$19$1
  implements Runnable
{
  SnsCommentDetailUI$19$1(SnsCommentDetailUI.19 param19, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(38798);
    if ((this.fCW) && (!this.rPv.rPu.isFinishing()) && (this.rPv.rPu.rPr < 5)) {
      this.rPv.rPu.cuW();
    }
    SnsCommentDetailUI localSnsCommentDetailUI = this.rPv.rPu;
    localSnsCommentDetailUI.rPr += 1;
    AppMethodBeat.o(38798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.19.1
 * JD-Core Version:    0.7.0.1
 */