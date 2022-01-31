package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class MMSightCircularProgressBar$1
  implements b.a
{
  MMSightCircularProgressBar$1(MMSightCircularProgressBar paramMMSightCircularProgressBar) {}
  
  public final void aw(float paramFloat)
  {
    MMSightCircularProgressBar.a(this.mou, paramFloat);
    this.mou.invalidate();
  }
  
  public final void onAnimationEnd()
  {
    y.i("MicroMsg.MMSightCircularProgressBar", "onAnimationEnd");
    ai.d(new MMSightCircularProgressBar.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.1
 * JD-Core Version:    0.7.0.1
 */