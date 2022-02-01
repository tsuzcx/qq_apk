package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.kd;

public final class q$b
  extends l.e
  implements l.c
{
  public final abj Yym;
  
  public q$b()
  {
    AppMethodBeat.i(152470);
    this.Yym = new abj();
    AppMethodBeat.o(152470);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152471);
    this.Yym.parseFrom(paramArrayOfByte);
    int i = this.Yym.BaseResponse.Idd;
    AppMethodBeat.o(152471);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.q.b
 * JD-Core Version:    0.7.0.1
 */