package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.StyleSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends e<Boolean, BoldSpan>
{
  public final boolean cl(Object paramObject)
  {
    AppMethodBeat.i(26931);
    if (((paramObject instanceof BoldSpan)) || (((paramObject instanceof StyleSpan)) && (((StyleSpan)paramObject).getStyle() == 1)))
    {
      AppMethodBeat.o(26931);
      return true;
    }
    AppMethodBeat.o(26931);
    return false;
  }
  
  public final int djz()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.b
 * JD-Core Version:    0.7.0.1
 */