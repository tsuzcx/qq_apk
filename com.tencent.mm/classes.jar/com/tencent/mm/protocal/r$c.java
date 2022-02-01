package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aff;

public final class r$c
  extends l.e
  implements l.c
{
  public aff CqP;
  
  public r$c()
  {
    AppMethodBeat.i(149116);
    this.CqP = new aff();
    AppMethodBeat.o(149116);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149117);
    this.CqP = ((aff)new aff().parseFrom(paramArrayOfByte));
    l.a(this, this.CqP.getBaseResponse());
    int i = this.CqP.getBaseResponse().Ret;
    AppMethodBeat.o(149117);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.r.c
 * JD-Core Version:    0.7.0.1
 */