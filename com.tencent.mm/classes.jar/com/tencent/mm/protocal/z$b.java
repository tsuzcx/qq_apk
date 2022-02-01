package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.edl;
import com.tencent.mm.protocal.protobuf.jh;

public final class z$b
  extends l.e
  implements l.c
{
  public edl RCg;
  
  public z$b()
  {
    AppMethodBeat.i(152474);
    this.RCg = new edl();
    AppMethodBeat.o(152474);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152475);
    this.RCg = ((edl)new edl().parseFrom(paramArrayOfByte));
    l.a(this, this.RCg.getBaseResponse());
    int i = this.RCg.getBaseResponse().CqV;
    AppMethodBeat.o(152475);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.z.b
 * JD-Core Version:    0.7.0.1
 */