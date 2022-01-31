package com.tencent.mm.protocal;

import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.protocal.c.vo;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.protocal.c.vq;
import com.tencent.mm.sdk.platformtools.bk;

public final class p$a
  extends k.d
  implements k.b
{
  public final vp sqa = new vp();
  
  public p$a()
  {
    fn(0);
    this.sqa.sSR = new vo();
    this.sqa.sSR.sSP = new pm();
    this.sqa.sSQ = new vq();
  }
  
  public final byte[] HG()
  {
    this.spM = y.cph();
    this.sqa.sSR.tEX = k.a(this);
    this.sqa.sSQ.sBt = new bmk().bs(bk.crT());
    this.spL = this.sqa.sSQ.sBt.tFM.toByteArray();
    this.spK = new p.a.1(this, this);
    return this.sqa.toByteArray();
  }
  
  public final int HH()
  {
    return 722;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.p.a
 * JD-Core Version:    0.7.0.1
 */