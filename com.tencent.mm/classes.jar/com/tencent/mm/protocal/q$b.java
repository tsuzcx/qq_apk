package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.vk;

public final class q$b
  extends l.e
  implements l.c
{
  public final vk CqL;
  
  public q$b()
  {
    AppMethodBeat.i(152470);
    this.CqL = new vk();
    AppMethodBeat.o(152470);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152471);
    this.CqL.parseFrom(paramArrayOfByte);
    int i = this.CqL.BaseResponse.Ret;
    AppMethodBeat.o(152471);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.q.b
 * JD-Core Version:    0.7.0.1
 */