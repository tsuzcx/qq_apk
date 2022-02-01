package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as
  extends l
{
  public as() {}
  
  public as(l paraml)
  {
    AppMethodBeat.i(215235);
    if (paraml != null)
    {
      this.uZn = paraml.uZn;
      this.name = paraml.name;
      this.xbF = paraml.xbF;
      this.xbE = paraml.xbE;
      this.pinyin = paraml.pinyin;
    }
    AppMethodBeat.o(215235);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (this.xbE != ((as)paramObject).xbE) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.as
 * JD-Core Version:    0.7.0.1
 */