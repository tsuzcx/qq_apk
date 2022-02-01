package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.io;
import com.tencent.mm.sdk.platformtools.Log;

public final class k$a
  extends l.d
  implements l.b
{
  public io KzC;
  public byte[] KzD;
  public byte[] KzE;
  
  public k$a()
  {
    AppMethodBeat.i(32080);
    this.KzC = new io();
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
    this.KzC.setBaseRequest(l.a(this));
    Log.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", new Object[] { this.KzD, Integer.valueOf(this.KzC.KMC), this.KzC.KMD, this.KzC.KME, this.KzC.KMF, Integer.valueOf(this.KzC.Scene), Long.valueOf(this.KzC.oTS), this.KzC.KMG, this.KzC.KMH });
    byte[] arrayOfByte = this.KzC.toByteArray();
    AppMethodBeat.o(32081);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.k.a
 * JD-Core Version:    0.7.0.1
 */