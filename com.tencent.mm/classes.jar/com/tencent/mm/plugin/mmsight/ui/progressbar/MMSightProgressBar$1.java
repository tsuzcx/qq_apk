package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.os.Looper;
import android.os.Message;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

final class MMSightProgressBar$1
  extends ah
{
  MMSightProgressBar$1(MMSightProgressBar paramMMSightProgressBar, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 233) && (MMSightProgressBar.a(this.mrl)) && (MMSightProgressBar.b(this.mrl).size() > 0) && (MMSightProgressBar.b(this.mrl).size() < 5))
    {
      paramMessage = (a)MMSightProgressBar.b(this.mrl).get(MMSightProgressBar.b(this.mrl).size() - 1);
      int i = MMSightProgressBar.aRm()[MMSightProgressBar.b(this.mrl).size()];
      a locala = new a(MMSightProgressBar.b(this.mrl).size(), MMSightProgressBar.c(this.mrl), MMSightProgressBar.d(this.mrl), i);
      MMSightProgressBar.a(this.mrl, new b(paramMessage, locala, new MMSightProgressBar.1.1(this)));
      paramMessage = MMSightProgressBar.g(this.mrl);
      paramMessage.hsF = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
      paramMessage.hsF.addUpdateListener(new b.1(paramMessage));
      paramMessage.hsF.addListener(new b.2(paramMessage));
      paramMessage.hsF.setInterpolator(new AccelerateDecelerateInterpolator());
      paramMessage.hsF.setDuration(2000L);
      paramMessage.hsF.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar.1
 * JD-Core Version:    0.7.0.1
 */