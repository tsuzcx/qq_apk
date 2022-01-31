package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.h;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkCoreWrapper;

public final class i
  implements h
{
  public final void deleteOrigin(String paramString)
  {
    AppMethodBeat.i(85247);
    Log.i("XWStorage", "delete origin ret is ".concat(String.valueOf(XWalkCoreWrapper.invokeRuntimeChannel(80006, new Object[] { paramString }))));
    AppMethodBeat.o(85247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.i
 * JD-Core Version:    0.7.0.1
 */