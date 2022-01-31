package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.e.c;
import org.json.JSONObject;

final class e$8$1
  extends c
{
  e$8$1(e.8 param8) {}
  
  public final String name()
  {
    return "onGetKeyboardHeight";
  }
  
  public final JSONObject pV()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("height", this.rce.rcd);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.8.1
 * JD-Core Version:    0.7.0.1
 */