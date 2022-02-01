package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ar
  extends k
{
  public ar() {}
  
  public ar(k paramk)
  {
    AppMethodBeat.i(267039);
    if (paramk != null)
    {
      this.KbS = paramk.KbS;
      this.name = paramk.name;
      this.NjF = paramk.NjF;
      this.dIL = paramk.dIL;
      this.pinyin = paramk.pinyin;
    }
    AppMethodBeat.o(267039);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (this.dIL != ((ar)paramObject).dIL) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.ar
 * JD-Core Version:    0.7.0.1
 */