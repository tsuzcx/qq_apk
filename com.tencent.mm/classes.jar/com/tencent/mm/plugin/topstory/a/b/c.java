package com.tencent.mm.plugin.topstory.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dod;

public final class c
{
  public boolean BrA;
  public dod Brz;
  public boolean ssW;
  public long tCq;
  
  public c(dod paramdod)
  {
    AppMethodBeat.i(91003);
    this.Brz = paramdod;
    this.tCq = System.currentTimeMillis();
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
    boolean bool = this.Brz.tSk.equals(paramObject.Brz.tSk);
    AppMethodBeat.o(91004);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.b.c
 * JD-Core Version:    0.7.0.1
 */