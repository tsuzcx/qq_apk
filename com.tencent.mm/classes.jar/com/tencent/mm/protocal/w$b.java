package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.gj;

public final class w$b
  extends l.e
  implements l.c
{
  public gj wiU;
  
  public w$b()
  {
    AppMethodBeat.i(154524);
    this.wiU = new gj();
    AppMethodBeat.o(154524);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(154525);
    this.wiU = ((gj)new gj().parseFrom(paramArrayOfByte));
    l.a(this, this.wiU.getBaseResponse());
    int i = this.wiU.getBaseResponse().Ret;
    AppMethodBeat.o(154525);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.w.b
 * JD-Core Version:    0.7.0.1
 */