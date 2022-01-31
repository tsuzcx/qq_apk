package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;

class c
  implements ValueCallback<IX5JsValue>
{
  c(JsContext paramJsContext, ValueCallback paramValueCallback) {}
  
  public void a(IX5JsValue paramIX5JsValue)
  {
    AppMethodBeat.i(63909);
    ValueCallback localValueCallback = this.a;
    if (paramIX5JsValue == null) {}
    for (paramIX5JsValue = null;; paramIX5JsValue = new JsValue(this.b, paramIX5JsValue))
    {
      localValueCallback.onReceiveValue(paramIX5JsValue);
      AppMethodBeat.o(63909);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.c
 * JD-Core Version:    0.7.0.1
 */