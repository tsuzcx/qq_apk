package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as
  extends l
{
  public as() {}
  
  public as(l paraml)
  {
    AppMethodBeat.i(250129);
    if (paraml != null)
    {
      this.Ejj = paraml.Ejj;
      this.name = paraml.name;
      this.HlR = paraml.HlR;
      this.bPh = paraml.bPh;
      this.pinyin = paraml.pinyin;
    }
    AppMethodBeat.o(250129);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (this.bPh != ((as)paramObject).bPh) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.as
 * JD-Core Version:    0.7.0.1
 */