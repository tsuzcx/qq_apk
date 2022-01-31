package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.ah;

final class MultiTouchImageView$1
  implements Runnable
{
  MultiTouchImageView$1(MultiTouchImageView paramMultiTouchImageView, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.vad, (float)(l - this.eow));
    float f2 = this.vae;
    float f3 = this.vaf;
    this.vag.k(f2 + f3 * f1, this.bAT, this.bAU);
    if (f1 < this.vad) {
      this.vag.mHandler.post(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MultiTouchImageView.1
 * JD-Core Version:    0.7.0.1
 */