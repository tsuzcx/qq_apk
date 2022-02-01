package com.tencent.xweb.pinus;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.pinus.sdk.PSCoreWrapper;
import org.xwalk.core.Log;

public final class f
  implements IWebStorage
{
  public final void deleteOrigin(String paramString)
  {
    AppMethodBeat.i(213333);
    Object localObject = PSCoreWrapper.invokeRuntimeChannel(80006, new Object[] { paramString });
    Log.i("PinusStorage", "delete origin(" + paramString + ") result is " + localObject);
    AppMethodBeat.o(213333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.f
 * JD-Core Version:    0.7.0.1
 */