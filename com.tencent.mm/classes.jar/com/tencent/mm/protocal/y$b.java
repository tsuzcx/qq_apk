package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.hr;

public final class y$b
  extends l.e
  implements l.c
{
  public hr FoF;
  
  public y$b()
  {
    AppMethodBeat.i(134240);
    this.FoF = new hr();
    AppMethodBeat.o(134240);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134241);
    this.FoF = ((hr)new hr().parseFrom(paramArrayOfByte));
    l.a(this, this.FoF.getBaseResponse());
    int i = this.FoF.getBaseResponse().Ret;
    AppMethodBeat.o(134241);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.y.b
 * JD-Core Version:    0.7.0.1
 */