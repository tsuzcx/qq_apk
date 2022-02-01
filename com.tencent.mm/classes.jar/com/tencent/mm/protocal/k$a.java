package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.hq;
import com.tencent.mm.sdk.platformtools.ad;

public final class k$a
  extends l.d
  implements l.b
{
  public hq Cqu;
  public byte[] Cqv;
  public byte[] Cqw;
  
  public k$a()
  {
    AppMethodBeat.i(32080);
    this.Cqu = new hq();
    AppMethodBeat.o(32080);
  }
  
  public final int getCmdId()
  {
    return 1000;
  }
  
  public final int getFuncId()
  {
    return 1000;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(32081);
    this.Cqu.setBaseRequest(l.a(this));
    ad.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", new Object[] { this.Cqv, Integer.valueOf(this.Cqu.CCF), this.Cqu.CCG, this.Cqu.CCH, this.Cqu.CCI, Integer.valueOf(this.Cqu.Scene), Long.valueOf(this.Cqu.mBe), this.Cqu.CCJ, this.Cqu.CCK });
    byte[] arrayOfByte = this.Cqu.toByteArray();
    AppMethodBeat.o(32081);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.k.a
 * JD-Core Version:    0.7.0.1
 */