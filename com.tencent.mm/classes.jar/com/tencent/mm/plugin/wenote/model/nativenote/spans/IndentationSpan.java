package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.LeadingMarginSpan.Standard;

public class IndentationSpan
  extends LeadingMarginSpan.Standard
  implements f<Integer>, g<Integer>
{
  private final boolean qTe;
  private final int qTg;
  
  private IndentationSpan(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.qTg = paramInt;
    this.qTe = paramBoolean;
  }
  
  public int getLeadingMargin(boolean paramBoolean)
  {
    if (this.qTe) {
      return 0;
    }
    return this.qTg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.IndentationSpan
 * JD-Core Version:    0.7.0.1
 */