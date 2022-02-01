package com.tencent.mm.plugin.textstatus.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/cgi/TextStatusOption;", "", "value", "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "TextStatusOptionNo", "TextStatusOptionBlur", "plugin-textstatus_release"})
public enum a
{
  public final long value;
  
  static
  {
    AppMethodBeat.i(216230);
    a locala1 = new a("TextStatusOptionNo", 0, 0L);
    FZu = locala1;
    a locala2 = new a("TextStatusOptionBlur", 1, 1L);
    FZv = locala2;
    FZw = new a[] { locala1, locala2 };
    AppMethodBeat.o(216230);
  }
  
  private a(long paramLong)
  {
    this.value = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.b.a
 * JD-Core Version:    0.7.0.1
 */