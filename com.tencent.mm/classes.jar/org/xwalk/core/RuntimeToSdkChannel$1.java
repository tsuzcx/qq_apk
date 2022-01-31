package org.xwalk.core;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RuntimeToSdkChannel$1
  implements ValueCallback
{
  public final void onReceiveValue(Object paramObject)
  {
    AppMethodBeat.i(85522);
    if ((paramObject == null) || (!(paramObject instanceof Object[])))
    {
      AppMethodBeat.o(85522);
      return;
    }
    paramObject = (Object[])paramObject;
    if (paramObject.length < 3)
    {
      AppMethodBeat.o(85522);
      return;
    }
    if (!(paramObject[0] instanceof String))
    {
      AppMethodBeat.o(85522);
      return;
    }
    paramObject[2] = RuntimeToSdkChannel.onRuntimeCalled((String)paramObject[0], paramObject[1]);
    AppMethodBeat.o(85522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.xwalk.core.RuntimeToSdkChannel.1
 * JD-Core Version:    0.7.0.1
 */