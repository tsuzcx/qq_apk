package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as
  extends l
{
  public as() {}
  
  public as(l paraml)
  {
    AppMethodBeat.i(217981);
    if (paraml != null)
    {
      this.vly = paraml.vly;
      this.name = paraml.name;
      this.xrw = paraml.xrw;
      this.xrv = paraml.xrv;
      this.pinyin = paraml.pinyin;
    }
    AppMethodBeat.o(217981);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (this.xrv != ((as)paramObject).xrv) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.as
 * JD-Core Version:    0.7.0.1
 */