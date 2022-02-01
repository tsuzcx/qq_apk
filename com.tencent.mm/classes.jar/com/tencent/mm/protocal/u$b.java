package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bxt;

public final class u$b
  extends l.e
  implements l.c
{
  public bxt DJp;
  
  public u$b()
  {
    AppMethodBeat.i(133113);
    this.DJp = new bxt();
    AppMethodBeat.o(133113);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133114);
    this.DJp = ((bxt)new bxt().parseFrom(paramArrayOfByte));
    l.a(this, this.DJp.getBaseResponse());
    int i = this.DJp.getBaseResponse().Ret;
    AppMethodBeat.o(133114);
    return i;
  }
  
  public final int getCmdId()
  {
    return 1000000027;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.u.b
 * JD-Core Version:    0.7.0.1
 */