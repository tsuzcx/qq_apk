package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.StyleSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends e<Boolean, BoldSpan>
{
  public final int dxp()
  {
    return 0;
  }
  
  public final boolean eX(Object paramObject)
  {
    AppMethodBeat.i(30625);
    if (((paramObject instanceof BoldSpan)) || (((paramObject instanceof StyleSpan)) && (((StyleSpan)paramObject).getStyle() == 1)))
    {
      AppMethodBeat.o(30625);
      return true;
    }
    AppMethodBeat.o(30625);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.b
 * JD-Core Version:    0.7.0.1
 */