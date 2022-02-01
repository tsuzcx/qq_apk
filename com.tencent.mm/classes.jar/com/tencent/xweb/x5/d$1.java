package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.xweb.ac;

final class d$1
  extends ac
{
  d$1(WebResourceError paramWebResourceError) {}
  
  public final CharSequence getDescription()
  {
    AppMethodBeat.i(213117);
    CharSequence localCharSequence = this.aimY.getDescription();
    AppMethodBeat.o(213117);
    return localCharSequence;
  }
  
  public final int getErrorCode()
  {
    AppMethodBeat.i(213114);
    int i = this.aimY.getErrorCode();
    AppMethodBeat.o(213114);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.d.1
 * JD-Core Version:    0.7.0.1
 */