package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.id;
import com.tencent.mm.sdk.platformtools.ad;

public final class k$b
  extends l.e
  implements l.c
{
  public id FnW;
  
  public k$b()
  {
    AppMethodBeat.i(32082);
    this.FnW = new id();
    AppMethodBeat.o(32082);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(32083);
    this.FnW = ((id)new id().parseFrom(paramArrayOfByte));
    ad.d("MicroMsg.MMBakchatCreateQRcodeOffline.Resp", "Ret:%d, QRCodeBuffer:%s, QRCodeUrl:%s", new Object[] { Integer.valueOf(this.FnW.Ret), this.FnW.FAD, this.FnW.FAE });
    int i = this.FnW.Ret;
    AppMethodBeat.o(32083);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.k.b
 * JD-Core Version:    0.7.0.1
 */