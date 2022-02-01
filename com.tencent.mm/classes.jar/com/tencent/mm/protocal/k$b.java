package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.hs;
import com.tencent.mm.sdk.platformtools.ad;

public final class k$b
  extends l.e
  implements l.c
{
  public hs Cqx;
  
  public k$b()
  {
    AppMethodBeat.i(32082);
    this.Cqx = new hs();
    AppMethodBeat.o(32082);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(32083);
    this.Cqx = ((hs)new hs().parseFrom(paramArrayOfByte));
    ad.d("MicroMsg.MMBakchatCreateQRcodeOffline.Resp", "Ret:%d, QRCodeBuffer:%s, QRCodeUrl:%s", new Object[] { Integer.valueOf(this.Cqx.Ret), this.Cqx.CCL, this.Cqx.CCM });
    int i = this.Cqx.Ret;
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