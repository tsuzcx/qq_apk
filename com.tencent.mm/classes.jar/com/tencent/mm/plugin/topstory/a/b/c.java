package com.tencent.mm.plugin.topstory.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ddb;

public final class c
{
  public boolean qHI;
  public long rwE;
  public ddb yLU;
  public boolean yLV;
  
  public c(ddb paramddb)
  {
    AppMethodBeat.i(91003);
    this.yLU = paramddb;
    this.rwE = System.currentTimeMillis();
    AppMethodBeat.o(91003);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(91004);
    if (paramObject == null)
    {
      AppMethodBeat.o(91004);
      return false;
    }
    paramObject = (c)paramObject;
    boolean bool = this.yLU.rNP.equals(paramObject.yLU.rNP);
    AppMethodBeat.o(91004);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.b.c
 * JD-Core Version:    0.7.0.1
 */