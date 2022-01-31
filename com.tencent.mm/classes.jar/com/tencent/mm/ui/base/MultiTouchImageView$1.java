package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class MultiTouchImageView$1
  implements Runnable
{
  MultiTouchImageView$1(MultiTouchImageView paramMultiTouchImageView, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public final void run()
  {
    AppMethodBeat.i(106973);
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.zot, (float)(l - this.fET));
    float f2 = this.zou;
    float f3 = this.zov;
    this.zow.k(f2 + f3 * f1, this.cdQ, this.cdR);
    if (f1 < this.zot) {
      this.zow.mHandler.post(this);
    }
    AppMethodBeat.o(106973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MultiTouchImageView.1
 * JD-Core Version:    0.7.0.1
 */