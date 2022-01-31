package com.tencent.mm.plugin.sns.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.d;

final class SnsAdNativeLandingPagesUI$15$1$1
  implements Runnable
{
  SnsAdNativeLandingPagesUI$15$1$1(SnsAdNativeLandingPagesUI.15.1 param1, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(38641);
    if (this.rNb != null) {}
    for (Bitmap localBitmap = this.rNb; localBitmap != null; localBitmap = d.eH(SnsAdNativeLandingPagesUI.e(this.rNc.rNa.rMW)))
    {
      SnsAdNativeLandingPagesUI.e(this.rNc.rNa.rMW).setVisibility(4);
      SnsAdNativeLandingPagesUI.b(this.rNc.rNa.rMW).setAlpha(1.0F);
      SnsAdNativeLandingPagesUI.g(this.rNc.rNa.rMW).setImageBitmap(localBitmap);
      SnsAdNativeLandingPagesUI.h(this.rNc.rNa.rMW);
      AppMethodBeat.o(38641);
      return;
    }
    SnsAdNativeLandingPagesUI.b(this.rNc.rNa.rMW).setAlpha(1.0F);
    AppMethodBeat.o(38641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.15.1.1
 * JD-Core Version:    0.7.0.1
 */