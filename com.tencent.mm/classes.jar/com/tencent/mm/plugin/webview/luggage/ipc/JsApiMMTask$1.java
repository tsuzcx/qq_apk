package com.tencent.mm.plugin.webview.luggage.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import org.json.JSONObject;

final class JsApiMMTask$1
  extends bh.a
{
  JsApiMMTask$1(JsApiMMTask paramJsApiMMTask) {}
  
  public final void c(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(6255);
    this.uTh.errMsg = paramString;
    if (paramJSONObject != null) {
      this.uTh.uTg = paramJSONObject.toString();
    }
    JsApiMMTask.a(this.uTh);
    AppMethodBeat.o(6255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask.1
 * JD-Core Version:    0.7.0.1
 */