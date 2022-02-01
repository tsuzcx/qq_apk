package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ib;
import com.tencent.mm.sdk.platformtools.ae;

public final class k$a
  extends l.d
  implements l.b
{
  public ib FGr;
  public byte[] FGs;
  public byte[] FGt;
  
  public k$a()
  {
    AppMethodBeat.i(32080);
    this.FGr = new ib();
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
    this.FGr.setBaseRequest(l.a(this));
    ae.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", new Object[] { this.FGs, Integer.valueOf(this.FGr.FST), this.FGr.FSU, this.FGr.FSV, this.FGr.FSW, Integer.valueOf(this.FGr.Scene), Long.valueOf(this.FGr.nIX), this.FGr.FSX, this.FGr.FSY });
    byte[] arrayOfByte = this.FGr.toByteArray();
    AppMethodBeat.o(32081);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.k.a
 * JD-Core Version:    0.7.0.1
 */