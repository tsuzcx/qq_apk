package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bg.a;

final class SnsTimeLineUI$39
  implements bg.a
{
  SnsTimeLineUI$39(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void Q(String paramString, long paramLong)
  {
    AppMethodBeat.i(200569);
    ac.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onScreenShot， path = " + paramString + "， dateAdded = " + paramLong);
    SnsTimeLineUI.L(this.yTS);
    AppMethodBeat.o(200569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.39
 * JD-Core Version:    0.7.0.1
 */