package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cae;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bk;

public final class c$a
  extends k.d
  implements k.b
{
  public cae prI = new cae();
  
  public final byte[] HG()
  {
    this.spM = y.cph();
    this.prI.sBt = new bmk().bs(bk.crT());
    this.prI.tEX = k.a(this);
    this.spL = this.prI.sBt.tFM.toByteArray();
    return this.prI.toByteArray();
  }
  
  public final int HH()
  {
    return 627;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.c.a
 * JD-Core Version:    0.7.0.1
 */