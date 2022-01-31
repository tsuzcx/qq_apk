package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsCommentDetailUI$16
  implements Runnable
{
  SnsCommentDetailUI$16(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(38795);
    this.rPu.hideVKB();
    SnsCommentDetailUI.m(this.rPu).itemHeight = SnsCommentDetailUI.A(this.rPu);
    SnsCommentDetailUI.m(this.rPu).run();
    AppMethodBeat.o(38795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.16
 * JD-Core Version:    0.7.0.1
 */