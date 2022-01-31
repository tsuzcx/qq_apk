package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class e$20
  extends c
{
  e$20(e parame, String paramString) {}
  
  public final String name()
  {
    return "activity:state_change";
  }
  
  public final JSONObject tY()
  {
    AppMethodBeat.i(6043);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", this.lai);
      label25:
      AppMethodBeat.o(6043);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.20
 * JD-Core Version:    0.7.0.1
 */