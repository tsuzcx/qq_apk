package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.LeadingMarginSpan.Standard;

public class IndentationSpan
  extends LeadingMarginSpan.Standard
  implements f<Integer>, g<Integer>
{
  private final boolean rKu;
  private final int rKv;
  
  private IndentationSpan(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.rKv = paramInt;
    this.rKu = paramBoolean;
  }
  
  public int getLeadingMargin(boolean paramBoolean)
  {
    if (this.rKu) {
      return 0;
    }
    return this.rKv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.IndentationSpan
 * JD-Core Version:    0.7.0.1
 */