package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.lh;

public final class n$b
  extends l.e
  implements l.c
{
  public lh DIT;
  
  public n$b()
  {
    AppMethodBeat.i(134236);
    this.DIT = new lh();
    AppMethodBeat.o(134236);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134237);
    this.DIT = ((lh)new lh().parseFrom(paramArrayOfByte));
    l.a(this, this.DIT.getBaseResponse());
    int i = this.DIT.getBaseResponse().Ret;
    AppMethodBeat.o(134237);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.n.b
 * JD-Core Version:    0.7.0.1
 */