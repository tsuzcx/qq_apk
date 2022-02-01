package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.agg;

public final class s$c
  extends l.e
  implements l.c
{
  public agg DJl;
  
  public s$c()
  {
    AppMethodBeat.i(149122);
    this.DJl = new agg();
    AppMethodBeat.o(149122);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149123);
    this.DJl = ((agg)new agg().parseFrom(paramArrayOfByte));
    l.a(this, this.DJl.getBaseResponse());
    int i = this.DJl.getBaseResponse().Ret;
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