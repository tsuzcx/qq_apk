package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.LeadingMarginSpan.Standard;

public class IndentationSpan
  extends LeadingMarginSpan.Standard
  implements f<Integer>, g<Integer>
{
  private final boolean pxi;
  private final int pxk;
  
  private IndentationSpan(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.pxk = paramInt;
    this.pxi = paramBoolean;
  }
  
  public int getLeadingMargin(boolean paramBoolean)
  {
    if (this.pxi) {
      return 0;
    }
    return this.pxk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.IndentationSpan
 * JD-Core Version:    0.7.0.1
 */