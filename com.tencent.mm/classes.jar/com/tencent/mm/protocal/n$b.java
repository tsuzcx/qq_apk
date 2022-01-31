package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.jt;

public final class n$b
  extends l.e
  implements l.c
{
  public jt wix;
  
  public n$b()
  {
    AppMethodBeat.i(123504);
    this.wix = new jt();
    AppMethodBeat.o(123504);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(123505);
    this.wix = ((jt)new jt().parseFrom(paramArrayOfByte));
    l.a(this, this.wix.getBaseResponse());
    int i = this.wix.getBaseResponse().Ret;
    AppMethodBeat.o(123505);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.n.b
 * JD-Core Version:    0.7.0.1
 */