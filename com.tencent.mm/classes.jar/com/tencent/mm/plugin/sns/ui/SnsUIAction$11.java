package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMPullDownView.e;

final class SnsUIAction$11
  implements MMPullDownView.e
{
  SnsUIAction$11(SnsUIAction paramSnsUIAction) {}
  
  public final boolean bik()
  {
    AppMethodBeat.i(145648);
    ab.e("MicroMsg.SnsActivity", "bottomLoad  isAll:" + this.sbh.kyS);
    if (!this.sbh.kyS) {
      SnsUIAction.g(this.sbh);
    }
    AppMethodBeat.o(145648);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction.11
 * JD-Core Version:    0.7.0.1
 */