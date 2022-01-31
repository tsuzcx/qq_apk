package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;

public final class r
  implements ParagraphStyle
{
  public final ParagraphStyle rKU;
  public final q rKo;
  
  public r(q paramq, ParagraphStyle paramParagraphStyle)
  {
    this.rKo = paramq;
    this.rKU = paramParagraphStyle;
  }
  
  public final String toString()
  {
    return this.rKo.name() + " - " + this.rKU.getClass().getSimpleName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.r
 * JD-Core Version:    0.7.0.1
 */