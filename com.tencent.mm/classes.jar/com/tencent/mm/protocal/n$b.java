package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.mz;

public final class n$b
  extends l.e
  implements l.c
{
  public mz Yyc;
  
  public n$b()
  {
    AppMethodBeat.i(257293);
    this.Yyc = new mz();
    AppMethodBeat.o(257293);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(257295);
    this.Yyc = ((mz)new mz().parseFrom(paramArrayOfByte));
    l.a(this, this.Yyc.getBaseResponse());
    int i = this.Yyc.getBaseResponse().Idd;
    AppMethodBeat.o(257295);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.n.b
 * JD-Core Version:    0.7.0.1
 */