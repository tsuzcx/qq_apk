package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aql;
import com.tencent.mm.protocal.protobuf.kd;

public final class r$c
  extends l.e
  implements l.c
{
  public aql Yyq;
  
  public r$c()
  {
    AppMethodBeat.i(149116);
    this.Yyq = new aql();
    AppMethodBeat.o(149116);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149117);
    this.Yyq = ((aql)new aql().parseFrom(paramArrayOfByte));
    l.a(this, this.Yyq.getBaseResponse());
    int i = this.Yyq.getBaseResponse().Idd;
    AppMethodBeat.o(149117);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.r.c
 * JD-Core Version:    0.7.0.1
 */