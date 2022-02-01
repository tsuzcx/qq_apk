package com.tencent.mm.plugin.topstory.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dio;

public final class c
{
  public boolean rAJ;
  public long sFw;
  public dio zZN;
  public boolean zZO;
  
  public c(dio paramdio)
  {
    AppMethodBeat.i(91003);
    this.zZN = paramdio;
    this.sFw = System.currentTimeMillis();
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
    boolean bool = this.zZN.sVF.equals(paramObject.zZN.sVF);
    AppMethodBeat.o(91004);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.b.c
 * JD-Core Version:    0.7.0.1
 */