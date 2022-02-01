package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.xweb.z;

final class g$1
  extends z
{
  g$1(WebResourceError paramWebResourceError) {}
  
  public final CharSequence getDescription()
  {
    AppMethodBeat.i(209563);
    CharSequence localCharSequence = this.aagl.getDescription();
    AppMethodBeat.o(209563);
    return localCharSequence;
  }
  
  public final int getErrorCode()
  {
    AppMethodBeat.i(209560);
    int i = this.aagl.getErrorCode();
    AppMethodBeat.o(209560);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.g.1
 * JD-Core Version:    0.7.0.1
 */