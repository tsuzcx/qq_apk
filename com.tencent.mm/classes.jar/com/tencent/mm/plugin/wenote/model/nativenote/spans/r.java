package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  implements ParagraphStyle
{
  public final q XBL;
  public final ParagraphStyle xCf;
  
  public r(q paramq, ParagraphStyle paramParagraphStyle)
  {
    this.XBL = paramq;
    this.xCf = paramParagraphStyle;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(30663);
    String str = this.XBL.name() + " - " + this.xCf.getClass().getSimpleName();
    AppMethodBeat.o(30663);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.r
 * JD-Core Version:    0.7.0.1
 */