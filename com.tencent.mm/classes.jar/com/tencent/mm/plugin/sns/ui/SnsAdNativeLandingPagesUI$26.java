package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.sdk.platformtools.ae;

final class SnsAdNativeLandingPagesUI$26
  implements AdLandingPagesProxy.e
{
  SnsAdNativeLandingPagesUI$26(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void be(Object paramObject) {}
  
  public final void h(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(219817);
    ae.i("MicroMsg.SnsAdNativeLandingPagesUI", "doUpdateUxInfoScene end, errType=" + paramInt1 + ", errNo=" + paramInt2 + ", newUxInfo=" + paramObject);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramObject instanceof String))) {
      SnsAdNativeLandingPagesUI.a(this.ApW, (String)paramObject);
    }
    AppMethodBeat.o(219817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.26
 * JD-Core Version:    0.7.0.1
 */