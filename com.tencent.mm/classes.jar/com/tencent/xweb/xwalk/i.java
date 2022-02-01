package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebStorage;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkCoreWrapper;

public final class i
  implements IWebStorage
{
  public final void deleteOrigin(String paramString)
  {
    AppMethodBeat.i(154295);
    Object localObject = XWalkCoreWrapper.invokeRuntimeChannel(80006, new Object[] { paramString });
    Log.i("XWStorage", "delete origin(" + paramString + ") result is " + localObject);
    AppMethodBeat.o(154295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.i
 * JD-Core Version:    0.7.0.1
 */