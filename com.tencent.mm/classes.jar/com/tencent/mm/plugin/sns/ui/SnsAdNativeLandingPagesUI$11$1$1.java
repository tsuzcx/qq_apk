package com.tencent.mm.plugin.sns.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.c;

final class SnsAdNativeLandingPagesUI$11$1$1
  implements Runnable
{
  SnsAdNativeLandingPagesUI$11$1$1(SnsAdNativeLandingPagesUI.11.1 param1) {}
  
  public final void run()
  {
    Bitmap localBitmap = c.dz(SnsAdNativeLandingPagesUI.f(this.oUY.oUX.oUU));
    if (localBitmap != null)
    {
      SnsAdNativeLandingPagesUI.f(this.oUY.oUX.oUU).setVisibility(4);
      SnsAdNativeLandingPagesUI.c(this.oUY.oUX.oUU).setAlpha(1.0F);
      SnsAdNativeLandingPagesUI.g(this.oUY.oUX.oUU).setImageBitmap(localBitmap);
      SnsAdNativeLandingPagesUI.h(this.oUY.oUX.oUU);
      return;
    }
    SnsAdNativeLandingPagesUI.c(this.oUY.oUX.oUU).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.11.1.1
 * JD-Core Version:    0.7.0.1
 */