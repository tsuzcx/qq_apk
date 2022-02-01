package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cde;

public final class u$b
  extends l.e
  implements l.c
{
  public cde FGU;
  
  public u$b()
  {
    AppMethodBeat.i(133113);
    this.FGU = new cde();
    AppMethodBeat.o(133113);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133114);
    this.FGU = ((cde)new cde().parseFrom(paramArrayOfByte));
    l.a(this, this.FGU.getBaseResponse());
    int i = this.FGU.getBaseResponse().Ret;
    AppMethodBeat.o(133114);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000000027;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.u.b
 * JD-Core Version:    0.7.0.1
 */