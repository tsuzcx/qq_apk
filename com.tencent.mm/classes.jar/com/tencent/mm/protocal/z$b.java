package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.exc;
import com.tencent.mm.protocal.protobuf.kd;

public final class z$b
  extends l.e
  implements l.c
{
  public exc YyI;
  
  public z$b()
  {
    AppMethodBeat.i(152474);
    this.YyI = new exc();
    AppMethodBeat.o(152474);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152475);
    this.YyI = ((exc)new exc().parseFrom(paramArrayOfByte));
    l.a(this, this.YyI.getBaseResponse());
    int i = this.YyI.getBaseResponse().Idd;
    AppMethodBeat.o(152475);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.z.b
 * JD-Core Version:    0.7.0.1
 */