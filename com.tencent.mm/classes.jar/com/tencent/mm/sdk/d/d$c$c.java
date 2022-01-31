package com.tencent.mm.sdk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$c$c
{
  boolean active;
  c yrG;
  c yrH;
  
  private d$c$c(d.c paramc) {}
  
  public final String toString()
  {
    AppMethodBeat.i(52455);
    StringBuilder localStringBuilder = new StringBuilder("state=").append(this.yrG.getName()).append(",active=").append(this.active).append(",parent=");
    if (this.yrH == null) {}
    for (String str = "null";; str = this.yrH.yrG.getName())
    {
      str = str;
      AppMethodBeat.o(52455);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.d.d.c.c
 * JD-Core Version:    0.7.0.1
 */