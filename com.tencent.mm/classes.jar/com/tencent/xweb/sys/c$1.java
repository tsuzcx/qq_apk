package com.tencent.xweb.sys;

import android.webkit.WebResourceError;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.z;

final class c$1
  extends z
{
  c$1(WebResourceError paramWebResourceError) {}
  
  public final CharSequence getDescription()
  {
    AppMethodBeat.i(204956);
    CharSequence localCharSequence = this.aafg.getDescription();
    AppMethodBeat.o(204956);
    return localCharSequence;
  }
  
  public final int getErrorCode()
  {
    AppMethodBeat.i(204955);
    int i = this.aafg.getErrorCode();
    AppMethodBeat.o(204955);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.c.1
 * JD-Core Version:    0.7.0.1
 */