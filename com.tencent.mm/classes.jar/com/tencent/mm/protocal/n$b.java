package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.mi;

public final class n$b
  extends l.e
  implements l.c
{
  public mi KzJ;
  
  public n$b()
  {
    AppMethodBeat.i(222855);
    this.KzJ = new mi();
    AppMethodBeat.o(222855);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(222856);
    this.KzJ = ((mi)new mi().parseFrom(paramArrayOfByte));
    l.a(this, this.KzJ.getBaseResponse());
    int i = this.KzJ.getBaseResponse().Ret;
    AppMethodBeat.o(222856);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.n.b
 * JD-Core Version:    0.7.0.1
 */