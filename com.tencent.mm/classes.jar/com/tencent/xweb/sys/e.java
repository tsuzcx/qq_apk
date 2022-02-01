package com.tencent.xweb.sys;

import android.webkit.WebStorage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebStorage;

public final class e
  implements IWebStorage
{
  public final void deleteOrigin(String paramString)
  {
    AppMethodBeat.i(212635);
    WebStorage.getInstance().deleteOrigin(paramString);
    AppMethodBeat.o(212635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.sys.e
 * JD-Core Version:    0.7.0.1
 */