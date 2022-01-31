package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.fk;
import com.tencent.mm.sdk.platformtools.y;

public final class j$a
  extends k.d
  implements k.b
{
  public fk spB = new fk();
  public byte[] spC;
  
  public final byte[] HG()
  {
    this.spB.tEX = k.a(this);
    y.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", new Object[] { this.spC, Integer.valueOf(this.spB.syY), this.spB.syZ, this.spB.sza, this.spB.szb, Integer.valueOf(this.spB.pyo), Long.valueOf(this.spB.hQm), this.spB.szc, this.spB.szd });
    return this.spB.toByteArray();
  }
  
  public final int HH()
  {
    return 1000;
  }
  
  public final int getCmdId()
  {
    return 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.j.a
 * JD-Core Version:    0.7.0.1
 */