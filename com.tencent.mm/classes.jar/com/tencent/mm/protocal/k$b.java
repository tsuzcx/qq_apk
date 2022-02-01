package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.hw;
import com.tencent.mm.sdk.platformtools.ac;

public final class k$b
  extends l.e
  implements l.c
{
  public hw DIP;
  
  public k$b()
  {
    AppMethodBeat.i(32082);
    this.DIP = new hw();
    AppMethodBeat.o(32082);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(32083);
    this.DIP = ((hw)new hw().parseFrom(paramArrayOfByte));
    ac.d("MicroMsg.MMBakchatCreateQRcodeOffline.Resp", "Ret:%d, QRCodeBuffer:%s, QRCodeUrl:%s", new Object[] { Integer.valueOf(this.DIP.Ret), this.DIP.DVi, this.DIP.DVj });
    int i = this.DIP.Ret;
    AppMethodBeat.o(32083);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.k.b
 * JD-Core Version:    0.7.0.1
 */