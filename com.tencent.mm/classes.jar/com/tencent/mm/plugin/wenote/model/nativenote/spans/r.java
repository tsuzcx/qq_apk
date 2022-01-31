package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  implements ParagraphStyle
{
  public final q vAS;
  public final ParagraphStyle vBy;
  
  public r(q paramq, ParagraphStyle paramParagraphStyle)
  {
    this.vAS = paramq;
    this.vBy = paramParagraphStyle;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(26969);
    String str = this.vAS.name() + " - " + this.vBy.getClass().getSimpleName();
    AppMethodBeat.o(26969);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.r
 * JD-Core Version:    0.7.0.1
 */