package com.tencent.mm.plugin.topstory.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.foh;

public final class c
{
  public long HBX;
  public foh TIW;
  public boolean TIX;
  public boolean lAr;
  
  public c(foh paramfoh)
  {
    AppMethodBeat.i(91003);
    this.TIW = paramfoh;
    this.HBX = System.currentTimeMillis();
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
    boolean bool = this.TIW.Ido.equals(paramObject.TIW.Ido);
    AppMethodBeat.o(91004);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.b.c
 * JD-Core Version:    0.7.0.1
 */