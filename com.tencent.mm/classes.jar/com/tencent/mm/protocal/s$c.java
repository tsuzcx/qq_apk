package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aiw;

public final class s$c
  extends l.e
  implements l.c
{
  public aiw Fos;
  
  public s$c()
  {
    AppMethodBeat.i(149122);
    this.Fos = new aiw();
    AppMethodBeat.o(149122);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149123);
    this.Fos = ((aiw)new aiw().parseFrom(paramArrayOfByte));
    l.a(this, this.Fos.getBaseResponse());
    int i = this.Fos.getBaseResponse().Ret;
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