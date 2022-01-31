package com.tencent.xweb.x5;

import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsContext.ExceptionHandler;
import com.tencent.smtt.sdk.JsError;
import com.tencent.xweb.d;
import org.xwalk.core.Log;

final class h$2
  implements JsContext.ExceptionHandler
{
  h$2(h paramh) {}
  
  public final void handleException(JsContext paramJsContext, JsError paramJsError)
  {
    if (paramJsError == null) {
      Log.i("MicroMsg.X5V8JsRuntime", "jsError is null.");
    }
    do
    {
      return;
      paramJsContext = paramJsError.getMessage();
      Log.e("MicroMsg.X5V8JsRuntime", String.format("handleException(%s)", new Object[] { paramJsContext }));
    } while (this.xkB.xkA == null);
    this.xkB.xkA.x(paramJsContext, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.x5.h.2
 * JD-Core Version:    0.7.0.1
 */