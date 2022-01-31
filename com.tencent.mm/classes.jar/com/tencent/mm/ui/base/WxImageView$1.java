package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class WxImageView$1
  implements Runnable
{
  WxImageView$1(WxImageView paramWxImageView, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public final void run()
  {
    AppMethodBeat.i(107097);
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.zot, (float)(l - this.fET));
    float f2 = this.zou;
    float f3 = this.zov;
    this.zqk.k(f2 + f3 * f1, this.cdQ, this.cdR);
    if (f1 < this.zot) {
      this.zqk.mHandler.post(this);
    }
    AppMethodBeat.o(107097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.WxImageView.1
 * JD-Core Version:    0.7.0.1
 */