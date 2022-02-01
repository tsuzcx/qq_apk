package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cox;

public final class z$b
  extends l.e
  implements l.c
{
  public cox Cri;
  
  public z$b()
  {
    AppMethodBeat.i(152474);
    this.Cri = new cox();
    AppMethodBeat.o(152474);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152475);
    this.Cri = ((cox)new cox().parseFrom(paramArrayOfByte));
    l.a(this, this.Cri.getBaseResponse());
    int i = this.Cri.getBaseResponse().Ret;
    AppMethodBeat.o(152475);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.z.b
 * JD-Core Version:    0.7.0.1
 */