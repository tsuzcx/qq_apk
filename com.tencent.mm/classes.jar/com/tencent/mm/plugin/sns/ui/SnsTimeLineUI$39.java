package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bh.a;

final class SnsTimeLineUI$39
  implements bh.a
{
  SnsTimeLineUI$39(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void X(String paramString, long paramLong)
  {
    AppMethodBeat.i(198434);
    ad.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onScreenShot， path = " + paramString + "， dateAdded = " + paramLong);
    SnsTimeLineUI.L(this.AlB);
    AppMethodBeat.o(198434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.39
 * JD-Core Version:    0.7.0.1
 */