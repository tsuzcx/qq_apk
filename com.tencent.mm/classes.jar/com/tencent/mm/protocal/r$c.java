package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.als;

public final class r$c
  extends l.e
  implements l.c
{
  public als KzX;
  
  public r$c()
  {
    AppMethodBeat.i(149116);
    this.KzX = new als();
    AppMethodBeat.o(149116);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149117);
    this.KzX = ((als)new als().parseFrom(paramArrayOfByte));
    l.a(this, this.KzX.getBaseResponse());
    int i = this.KzX.getBaseResponse().Ret;
    AppMethodBeat.o(149117);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.r.c
 * JD-Core Version:    0.7.0.1
 */