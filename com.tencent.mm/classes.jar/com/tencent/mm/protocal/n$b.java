package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.lb;

public final class n$b
  extends l.e
  implements l.c
{
  public lb CqB;
  
  public n$b()
  {
    AppMethodBeat.i(134236);
    this.CqB = new lb();
    AppMethodBeat.o(134236);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134237);
    this.CqB = ((lb)new lb().parseFrom(paramArrayOfByte));
    l.a(this, this.CqB.getBaseResponse());
    int i = this.CqB.getBaseResponse().Ret;
    AppMethodBeat.o(134237);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.n.b
 * JD-Core Version:    0.7.0.1
 */