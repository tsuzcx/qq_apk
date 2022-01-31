package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bgb;

public final class s$b
  extends l.e
  implements l.c
{
  public bgb wiL;
  
  public s$b()
  {
    AppMethodBeat.i(58854);
    this.wiL = new bgb();
    AppMethodBeat.o(58854);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58855);
    this.wiL = ((bgb)new bgb().parseFrom(paramArrayOfByte));
    l.a(this, this.wiL.getBaseResponse());
    int i = this.wiL.getBaseResponse().Ret;
    AppMethodBeat.o(58855);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000000027;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.s.b
 * JD-Core Version:    0.7.0.1
 */