package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.fm;
import com.tencent.mm.sdk.platformtools.y;

public final class j$b
  extends k.e
  implements k.c
{
  public fm spD = new fm();
  
  public final int A(byte[] paramArrayOfByte)
  {
    this.spD = ((fm)new fm().aH(paramArrayOfByte));
    y.d("MicroMsg.MMBakchatCreateQRcodeOffline.Resp", "Ret:%d, QRCodeBuffer:%s, QRCodeUrl:%s", new Object[] { Integer.valueOf(this.spD.sze), this.spD.szf, this.spD.szg });
    return this.spD.sze;
  }
  
  public final int getCmdId()
  {
    return 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.j.b
 * JD-Core Version:    0.7.0.1
 */