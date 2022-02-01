package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.iz;
import com.tencent.mm.sdk.platformtools.Log;

public final class k$a
  extends l.d
  implements l.b
{
  public iz YxV;
  public byte[] YxW;
  public byte[] YxX;
  
  public k$a()
  {
    AppMethodBeat.i(32080);
    this.YxV = new iz();
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
    this.YxV.setBaseRequest(l.a(this));
    Log.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", new Object[] { this.YxW, Integer.valueOf(this.YxV.YKK), this.YxV.YKL, this.YxV.YKM, this.YxV.YKN, Integer.valueOf(this.YxV.IJG), Long.valueOf(this.YxV.vhg), this.YxV.YKO, this.YxV.YKP });
    byte[] arrayOfByte = this.YxV.toByteArray();
    AppMethodBeat.o(32081);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.k.a
 * JD-Core Version:    0.7.0.1
 */