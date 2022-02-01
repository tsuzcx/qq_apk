package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.alu;

public final class s$c
  extends l.e
  implements l.c
{
  public alu KAb;
  
  public s$c()
  {
    AppMethodBeat.i(149122);
    this.KAb = new alu();
    AppMethodBeat.o(149122);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149123);
    this.KAb = ((alu)new alu().parseFrom(paramArrayOfByte));
    l.a(this, this.KAb.getBaseResponse());
    int i = this.KAb.getBaseResponse().Ret;
    AppMethodBeat.o(149123);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.s.c
 * JD-Core Version:    0.7.0.1
 */