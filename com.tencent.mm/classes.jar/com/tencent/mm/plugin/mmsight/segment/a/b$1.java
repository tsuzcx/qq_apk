package com.tencent.mm.plugin.mmsight.segment.a;

import com.tencent.mm.plugin.s.c;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements c
{
  b$1(b paramb) {}
  
  public final void F(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mnS.mnL = paramInt3;
    if (this.mnS.mnP != null) {
      this.mnS.mnP.O(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public final void aKN()
  {
    y.i("MicroMsg.MMSegmentVideoPlayer", "onSeekComplete, onSeekCompleteListener: %s", new Object[] { this.mnS.mnR });
    if (this.mnS.mnR != null) {
      this.mnS.mnR.bt(this.mnS.mnK);
    }
    while (!this.mnS.bSr) {
      return;
    }
    this.mnS.mnK.start();
  }
  
  public final void kA()
  {
    if (this.mnS.mnQ != null) {
      this.mnS.mnQ.bs(this.mnS.mnK);
    }
    if (this.mnS.bSr) {
      this.mnS.mnK.start();
    }
    this.mnS.PT = true;
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    if (this.mnS.mnO != null) {
      this.mnS.mnO.di(paramInt1, paramInt2);
    }
  }
  
  public final void ug()
  {
    if (this.mnS.eaP) {
      this.mnS.mnK.tP(this.mnS.mnM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.b.1
 * JD-Core Version:    0.7.0.1
 */