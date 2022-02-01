package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.iq;
import com.tencent.mm.sdk.platformtools.Log;

public final class k$b
  extends l.e
  implements l.c
{
  public iq KzF;
  
  public k$b()
  {
    AppMethodBeat.i(32082);
    this.KzF = new iq();
    AppMethodBeat.o(32082);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(32083);
    this.KzF = ((iq)new iq().parseFrom(paramArrayOfByte));
    Log.d("MicroMsg.MMBakchatCreateQRcodeOffline.Resp", "Ret:%d, QRCodeBuffer:%s, QRCodeUrl:%s", new Object[] { Integer.valueOf(this.KzF.Ret), this.KzF.KMI, this.KzF.KMJ });
    int i = this.KzF.Ret;
    AppMethodBeat.o(32083);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.k.b
 * JD-Core Version:    0.7.0.1
 */