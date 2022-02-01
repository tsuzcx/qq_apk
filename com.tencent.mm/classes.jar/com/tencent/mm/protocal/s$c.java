package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.afh;

public final class s$c
  extends l.e
  implements l.c
{
  public afh CqT;
  
  public s$c()
  {
    AppMethodBeat.i(149122);
    this.CqT = new afh();
    AppMethodBeat.o(149122);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149123);
    this.CqT = ((afh)new afh().parseFrom(paramArrayOfByte));
    l.a(this, this.CqT.getBaseResponse());
    int i = this.CqT.getBaseResponse().Ret;
    AppMethodBeat.o(149123);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.s.c
 * JD-Core Version:    0.7.0.1
 */