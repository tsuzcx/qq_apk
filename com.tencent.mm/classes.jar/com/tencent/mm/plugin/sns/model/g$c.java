package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$c
{
  public int code;
  public String id;
  public int reg;
  public boolean reh;
  
  public g$c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.id = paramString;
    this.code = paramInt1;
    this.reg = paramInt2;
    this.reh = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(36156);
    if ((paramObject != null) && (paramObject.hashCode() == this.code))
    {
      AppMethodBeat.o(36156);
      return true;
    }
    AppMethodBeat.o(36156);
    return false;
  }
  
  public final int hashCode()
  {
    return this.code;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g.c
 * JD-Core Version:    0.7.0.1
 */