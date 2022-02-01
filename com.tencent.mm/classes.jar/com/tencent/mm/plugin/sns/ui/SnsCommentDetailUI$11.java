package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bg.a;

final class SnsCommentDetailUI$11
  implements bg.a
{
  SnsCommentDetailUI$11(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void Q(String paramString, long paramLong)
  {
    AppMethodBeat.i(200480);
    ac.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onScreenShot， path = " + paramString + "， dateAdded = " + paramLong);
    SnsCommentDetailUI.v(this.yKq);
    AppMethodBeat.o(200480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.11
 * JD-Core Version:    0.7.0.1
 */