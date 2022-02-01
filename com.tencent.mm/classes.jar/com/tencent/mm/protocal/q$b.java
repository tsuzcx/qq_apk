package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.xw;

public final class q$b
  extends l.e
  implements l.c
{
  public final xw FGI;
  
  public q$b()
  {
    AppMethodBeat.i(152470);
    this.FGI = new xw();
    AppMethodBeat.o(152470);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152471);
    this.FGI.parseFrom(paramArrayOfByte);
    int i = this.FGI.BaseResponse.Ret;
    AppMethodBeat.o(152471);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.q.b
 * JD-Core Version:    0.7.0.1
 */