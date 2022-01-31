package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SphereImageView$1
  extends Handler
{
  SphereImageView$1(SphereImageView paramSphereImageView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(145403);
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(145403);
      return;
    }
    paramMessage = (SphereImageView.c)paramMessage.obj;
    float f1 = paramMessage.rBw;
    float f2 = paramMessage.rBv;
    float f3 = f1 - SphereImageView.b(this.rBr);
    float f4 = f2 - SphereImageView.c(this.rBr);
    paramMessage = SphereImageView.d(this.rBr);
    paramMessage.rBG += f4 * 1.5F;
    paramMessage = SphereImageView.d(this.rBr);
    paramMessage.rBF += f3 * 1.5F / 2.0F;
    if (SphereImageView.d(this.rBr).rBF < -50.0F) {
      SphereImageView.d(this.rBr).rBF = -50.0F;
    }
    for (;;)
    {
      SphereImageView.a(this.rBr, f1);
      SphereImageView.b(this.rBr, f2);
      if ((Math.abs(f4) <= 0.01F) && (Math.abs(f3) <= 0.01F)) {
        break;
      }
      long l = System.currentTimeMillis();
      this.rBr.rzX.requestRender();
      if (((Math.abs(f4) <= 0.1F) && (Math.abs(f3) <= 0.1F)) || (l - SphereImageView.e(this.rBr) <= 500L) || (this.rBr.rBq == null)) {
        break;
      }
      this.rBr.rBq.crv();
      SphereImageView.a(this.rBr, l);
      break;
      if (SphereImageView.d(this.rBr).rBF > 50.0F) {
        SphereImageView.d(this.rBr).rBF = 50.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.1
 * JD-Core Version:    0.7.0.1
 */