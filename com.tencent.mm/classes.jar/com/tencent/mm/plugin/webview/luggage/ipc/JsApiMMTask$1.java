package com.tencent.mm.plugin.webview.luggage.ipc;

import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import org.json.JSONObject;

final class JsApiMMTask$1
  extends aw.a
{
  JsApiMMTask$1(JsApiMMTask paramJsApiMMTask) {}
  
  public final void e(String paramString, JSONObject paramJSONObject)
  {
    this.rdj.aox = paramString;
    if (paramJSONObject != null) {
      this.rdj.rdi = paramJSONObject.toString();
    }
    this.rdj.ahI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask.1
 * JD-Core Version:    0.7.0.1
 */