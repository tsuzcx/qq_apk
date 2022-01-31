package com.tencent.mm.plugin.report.b;

import com.tencent.mm.protocal.c.ast;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bk;

public final class b$a
  extends k.d
  implements k.b
{
  public ast nES = new ast();
  
  public final byte[] HG()
  {
    this.spM = y.cpi();
    this.nES.sBt = new bmk().bs(bk.crT());
    this.nES.tEX = k.a(this);
    return this.nES.toByteArray();
  }
  
  public final int HH()
  {
    return 694;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.b.a
 * JD-Core Version:    0.7.0.1
 */