package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.xweb.internal.IWebStorage;

public final class i
  implements IWebStorage
{
  public final void deleteOrigin(String paramString)
  {
    AppMethodBeat.i(153897);
    WebStorage.getInstance().deleteOrigin(paramString);
    AppMethodBeat.o(153897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.i
 * JD-Core Version:    0.7.0.1
 */