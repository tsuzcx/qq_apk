package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.a;
import com.tencent.mm.sdk.platformtools.y;

final class SnsAdNativeLandingPagesUI$9
  implements j.a
{
  SnsAdNativeLandingPagesUI$9(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI, View paramView) {}
  
  private void bIr()
  {
    if ((this.oUW != null) && (this.oUW.getParent() != null)) {
      ((ViewGroup)this.oUW.getParent()).removeView(this.oUW);
    }
    SnsAdNativeLandingPagesUI.M(this.oUU);
  }
  
  public final void bFq()
  {
    y.i("MicroMsg.SnsAdNativeLandingPagesUI", "onDismiss");
    bIr();
  }
  
  public final void bFr()
  {
    y.i("MicroMsg.SnsAdNativeLandingPagesUI", "onCancel");
    bIr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.9
 * JD-Core Version:    0.7.0.1
 */