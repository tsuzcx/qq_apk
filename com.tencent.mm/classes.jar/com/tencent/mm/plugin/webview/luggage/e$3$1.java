package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.e.c;
import org.json.JSONException;
import org.json.JSONObject;

final class e$3$1
  extends c
{
  e$3$1(e.3 param3, String paramString) {}
  
  public final String name()
  {
    return "onGetSmiley";
  }
  
  public final JSONObject pV()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("smiley", this.rcb);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.3.1
 * JD-Core Version:    0.7.0.1
 */