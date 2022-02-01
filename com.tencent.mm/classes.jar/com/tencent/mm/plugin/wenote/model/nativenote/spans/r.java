package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  implements ParagraphStyle
{
  public final q BEH;
  public final ParagraphStyle oqv;
  
  public r(q paramq, ParagraphStyle paramParagraphStyle)
  {
    this.BEH = paramq;
    this.oqv = paramParagraphStyle;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(30663);
    String str = this.BEH.name() + " - " + this.oqv.getClass().getSimpleName();
    AppMethodBeat.o(30663);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.r
 * JD-Core Version:    0.7.0.1
 */