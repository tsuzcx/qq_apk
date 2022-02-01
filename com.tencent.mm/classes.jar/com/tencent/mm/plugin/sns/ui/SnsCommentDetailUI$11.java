package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bh.a;

final class SnsCommentDetailUI$11
  implements bh.a
{
  SnsCommentDetailUI$11(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void X(String paramString, long paramLong)
  {
    AppMethodBeat.i(198312);
    ad.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onScreenShot， path = " + paramString + "， dateAdded = " + paramLong);
    SnsCommentDetailUI.v(this.AbL);
    AppMethodBeat.o(198312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.11
 * JD-Core Version:    0.7.0.1
 */