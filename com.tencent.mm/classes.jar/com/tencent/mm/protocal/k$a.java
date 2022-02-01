package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ac;

public final class k$a
  extends l.d
  implements l.b
{
  public hu DIM;
  public byte[] DIN;
  public byte[] DIO;
  
  public k$a()
  {
    AppMethodBeat.i(32080);
    this.DIM = new hu();
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
    this.DIM.setBaseRequest(l.a(this));
    ac.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", new Object[] { this.DIN, Integer.valueOf(this.DIM.DVc), this.DIM.DVd, this.DIM.DVe, this.DIM.DVf, Integer.valueOf(this.DIM.Scene), Long.valueOf(this.DIM.ndf), this.DIM.DVg, this.DIM.DVh });
    byte[] arrayOfByte = this.DIM.toByteArray();
    AppMethodBeat.o(32081);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.k.a
 * JD-Core Version:    0.7.0.1
 */