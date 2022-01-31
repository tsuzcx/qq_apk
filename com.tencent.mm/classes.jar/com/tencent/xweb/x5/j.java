package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.xweb.c.h;

public final class j
  implements h
{
  public final void deleteOrigin(String paramString)
  {
    AppMethodBeat.i(84882);
    WebStorage.getInstance().deleteOrigin(paramString);
    AppMethodBeat.o(84882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.x5.j
 * JD-Core Version:    0.7.0.1
 */