package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.e.c;
import org.json.JSONObject;

final class e$23
  extends c
{
  e$23(e parame, String paramString) {}
  
  public final String name()
  {
    return "activity:state_change";
  }
  
  public final JSONObject pV()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", this.iRA);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.23
 * JD-Core Version:    0.7.0.1
 */