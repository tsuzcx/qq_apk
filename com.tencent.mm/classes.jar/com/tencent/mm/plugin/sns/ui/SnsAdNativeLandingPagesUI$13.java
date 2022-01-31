package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.sdk.platformtools.ah;

final class SnsAdNativeLandingPagesUI$13
  implements AdLandingPagesProxy.a
{
  SnsAdNativeLandingPagesUI$13(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI) {}
  
  public final void U(Object paramObject)
  {
    SnsAdNativeLandingPagesUI.k(this.oUU).removeCallbacksAndMessages(null);
    SnsAdNativeLandingPagesUI.k(this.oUU).post(new SnsAdNativeLandingPagesUI.13.1(this, paramObject));
  }
  
  public final void e(int paramInt1, int paramInt2, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.13
 * JD-Core Version:    0.7.0.1
 */