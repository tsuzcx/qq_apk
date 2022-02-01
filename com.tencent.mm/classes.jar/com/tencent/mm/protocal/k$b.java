package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.Log;

public final class k$b
  extends l.e
  implements l.c
{
  public jb YxY;
  
  public k$b()
  {
    AppMethodBeat.i(32082);
    this.YxY = new jb();
    AppMethodBeat.o(32082);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(32083);
    this.YxY = ((jb)new jb().parseFrom(paramArrayOfByte));
    Log.d("MicroMsg.MMBakchatCreateQRcodeOffline.Resp", "Ret:%d, QRCodeBuffer:%s, QRCodeUrl:%s", new Object[] { Integer.valueOf(this.YxY.Idd), this.YxY.YKQ, this.YxY.YKR });
    int i = this.YxY.Idd;
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