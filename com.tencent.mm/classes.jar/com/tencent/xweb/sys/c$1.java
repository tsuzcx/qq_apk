package com.tencent.xweb.sys;

import android.webkit.WebResourceError;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ac;

final class c$1
  extends ac
{
  c$1(WebResourceError paramWebResourceError) {}
  
  public final CharSequence getDescription()
  {
    AppMethodBeat.i(212671);
    CharSequence localCharSequence = this.aimb.getDescription();
    AppMethodBeat.o(212671);
    return localCharSequence;
  }
  
  public final int getErrorCode()
  {
    AppMethodBeat.i(212669);
    int i = this.aimb.getErrorCode();
    AppMethodBeat.o(212669);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.sys.c.1
 * JD-Core Version:    0.7.0.1
 */