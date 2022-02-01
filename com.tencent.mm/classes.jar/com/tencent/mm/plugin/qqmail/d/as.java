package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as
  extends l
{
  public as() {}
  
  public as(l paraml)
  {
    AppMethodBeat.i(198637);
    if (paraml != null)
    {
      this.yFq = paraml.yFq;
      this.name = paraml.name;
      this.Bry = paraml.Bry;
      this.bNi = paraml.bNi;
      this.pinyin = paraml.pinyin;
    }
    AppMethodBeat.o(198637);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (this.bNi != ((as)paramObject).bNi) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.as
 * JD-Core Version:    0.7.0.1
 */