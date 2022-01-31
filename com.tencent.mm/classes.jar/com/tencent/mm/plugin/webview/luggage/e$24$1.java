package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class e$24$1
  extends c
{
  e$24$1(e.24 param24, String paramString) {}
  
  public final String name()
  {
    return "onGetSmiley";
  }
  
  public final JSONObject tY()
  {
    AppMethodBeat.i(153111);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("smiley", this.uRY);
      label24:
      AppMethodBeat.o(153111);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label24;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.24.1
 * JD-Core Version:    0.7.0.1
 */