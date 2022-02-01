package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cue;

public final class z$b
  extends l.e
  implements l.c
{
  public cue DJA;
  
  public z$b()
  {
    AppMethodBeat.i(152474);
    this.DJA = new cue();
    AppMethodBeat.o(152474);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152475);
    this.DJA = ((cue)new cue().parseFrom(paramArrayOfByte));
    l.a(this, this.DJA.getBaseResponse());
    int i = this.DJA.getBaseResponse().Ret;
    AppMethodBeat.o(152475);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.z.b
 * JD-Core Version:    0.7.0.1
 */