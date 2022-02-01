package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.lr;

public final class n$b
  extends l.e
  implements l.c
{
  public lr Foa;
  
  public n$b()
  {
    AppMethodBeat.i(134236);
    this.Foa = new lr();
    AppMethodBeat.o(134236);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134237);
    this.Foa = ((lr)new lr().parseFrom(paramArrayOfByte));
    l.a(this, this.Foa.getBaseResponse());
    int i = this.Foa.getBaseResponse().Ret;
    AppMethodBeat.o(134237);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.n.b
 * JD-Core Version:    0.7.0.1
 */