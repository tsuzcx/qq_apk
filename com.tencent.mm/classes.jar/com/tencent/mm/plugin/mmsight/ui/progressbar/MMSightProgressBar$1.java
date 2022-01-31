package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.os.Looper;
import android.os.Message;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.List;

final class MMSightProgressBar$1
  extends ak
{
  MMSightProgressBar$1(MMSightProgressBar paramMMSightProgressBar, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(55335);
    if ((paramMessage.what == 233) && (MMSightProgressBar.a(this.oQZ)) && (MMSightProgressBar.b(this.oQZ).size() > 0) && (MMSightProgressBar.b(this.oQZ).size() < 5))
    {
      paramMessage = (a)MMSightProgressBar.b(this.oQZ).get(MMSightProgressBar.b(this.oQZ).size() - 1);
      int i = MMSightProgressBar.bxB()[MMSightProgressBar.b(this.oQZ).size()];
      a locala = new a(MMSightProgressBar.b(this.oQZ).size(), MMSightProgressBar.c(this.oQZ), MMSightProgressBar.d(this.oQZ), i);
      MMSightProgressBar.a(this.oQZ, new b(paramMessage, locala, new MMSightProgressBar.1.1(this)));
      paramMessage = MMSightProgressBar.g(this.oQZ);
      paramMessage.ggX = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
      paramMessage.ggX.addUpdateListener(new b.1(paramMessage));
      paramMessage.ggX.addListener(new b.2(paramMessage));
      paramMessage.ggX.setInterpolator(new AccelerateDecelerateInterpolator());
      paramMessage.ggX.setDuration(2000L);
      paramMessage.ggX.start();
    }
    AppMethodBeat.o(55335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar.1
 * JD-Core Version:    0.7.0.1
 */