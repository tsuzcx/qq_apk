package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gv;
import com.tencent.mm.sdk.platformtools.ab;

public final class k$b
  extends l.e
  implements l.c
{
  public gv wit;
  
  public k$b()
  {
    AppMethodBeat.i(28278);
    this.wit = new gv();
    AppMethodBeat.o(28278);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28279);
    this.wit = ((gv)new gv().parseFrom(paramArrayOfByte));
    ab.d("MicroMsg.MMBakchatCreateQRcodeOffline.Resp", "Ret:%d, QRCodeBuffer:%s, QRCodeUrl:%s", new Object[] { Integer.valueOf(this.wit.Ret), this.wit.wtg, this.wit.wth });
    int i = this.wit.Ret;
    AppMethodBeat.o(28279);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.k.b
 * JD-Core Version:    0.7.0.1
 */