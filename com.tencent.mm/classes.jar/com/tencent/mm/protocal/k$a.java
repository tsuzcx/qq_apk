package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.id;
import com.tencent.mm.sdk.platformtools.Log;

public final class k$a
  extends l.d
  implements l.b
{
  public id RBs;
  public byte[] RBt;
  public byte[] RBu;
  
  public k$a()
  {
    AppMethodBeat.i(32080);
    this.RBs = new id();
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
    this.RBs.setBaseRequest(l.a(this));
    Log.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", new Object[] { this.RBt, Integer.valueOf(this.RBs.RNw), this.RBs.RNx, this.RBs.RNy, this.RBs.RNz, Integer.valueOf(this.RBs.CPw), Long.valueOf(this.RBs.rVQ), this.RBs.RNA, this.RBs.RNB });
    byte[] arrayOfByte = this.RBs.toByteArray();
    AppMethodBeat.o(32081);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.k.a
 * JD-Core Version:    0.7.0.1
 */