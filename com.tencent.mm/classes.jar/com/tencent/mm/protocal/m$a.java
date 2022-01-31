package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.ia;
import com.tencent.mm.sdk.platformtools.bk;

public final class m$a
  extends k.d
  implements k.b
{
  public ia spS = new ia();
  
  public final byte[] HG()
  {
    this.spM = y.cph();
    this.spS.sBt = new bmk().bs(bk.crT());
    this.spS.tEX = k.a(this);
    return this.spS.toByteArray();
  }
  
  public final int HH()
  {
    return 145;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.m.a
 * JD-Core Version:    0.7.0.1
 */