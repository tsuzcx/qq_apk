package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.StyleSpan;

public final class b
  extends e<Boolean, BoldSpan>
{
  public final boolean bH(Object paramObject)
  {
    return ((paramObject instanceof BoldSpan)) || (((paramObject instanceof StyleSpan)) && (((StyleSpan)paramObject).getStyle() == 1));
  }
  
  public final int ciY()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.b
 * JD-Core Version:    0.7.0.1
 */