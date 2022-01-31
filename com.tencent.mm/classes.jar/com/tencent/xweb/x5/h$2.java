package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsContext.ExceptionHandler;
import com.tencent.smtt.sdk.JsError;
import org.xwalk.core.Log;

final class h$2
  implements JsContext.ExceptionHandler
{
  h$2(h paramh) {}
  
  public final void handleException(JsContext paramJsContext, JsError paramJsError)
  {
    AppMethodBeat.i(84836);
    if (paramJsError == null)
    {
      Log.i("MicroMsg.X5V8JsRuntime", "jsError is null.");
      AppMethodBeat.o(84836);
      return;
    }
    Log.e("MicroMsg.X5V8JsRuntime", String.format("handleException(%s)", new Object[] { paramJsError.getMessage() }));
    AppMethodBeat.o(84836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.h.2
 * JD-Core Version:    0.7.0.1
 */