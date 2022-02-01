package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebStorage;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkCoreWrapper;

public final class j
  implements IWebStorage
{
  public final void deleteOrigin(String paramString)
  {
    AppMethodBeat.i(154295);
    Log.i("XWStorage", "delete origin ret is ".concat(String.valueOf(XWalkCoreWrapper.invokeRuntimeChannel(80006, new Object[] { paramString }))));
    AppMethodBeat.o(154295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.j
 * JD-Core Version:    0.7.0.1
 */