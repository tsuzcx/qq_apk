package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ib;
import com.tencent.mm.sdk.platformtools.ad;

public final class k$a
  extends l.d
  implements l.b
{
  public ib FnT;
  public byte[] FnU;
  public byte[] FnV;
  
  public k$a()
  {
    AppMethodBeat.i(32080);
    this.FnT = new ib();
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
    this.FnT.setBaseRequest(l.a(this));
    ad.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", new Object[] { this.FnU, Integer.valueOf(this.FnT.FAx), this.FnT.FAy, this.FnT.FAz, this.FnT.FAA, Integer.valueOf(this.FnT.Scene), Long.valueOf(this.FnT.nDC), this.FnT.FAB, this.FnT.FAC });
    byte[] arrayOfByte = this.FnT.toByteArray();
    AppMethodBeat.o(32081);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.k.a
 * JD-Core Version:    0.7.0.1
 */