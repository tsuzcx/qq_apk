package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.LeadingMarginSpan.Standard;

public class IndentationSpan
  extends LeadingMarginSpan.Standard
  implements f<Integer>, g<Integer>
{
  private final boolean pDM;
  private final int pDO;
  
  private IndentationSpan(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.pDO = paramInt;
    this.pDM = paramBoolean;
  }
  
  public int getLeadingMargin(boolean paramBoolean)
  {
    if (this.pDM) {
      return 0;
    }
    return this.pDO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.IndentationSpan
 * JD-Core Version:    0.7.0.1
 */