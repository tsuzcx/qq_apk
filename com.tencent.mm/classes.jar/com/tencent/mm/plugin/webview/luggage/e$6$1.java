package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class e$6$1
  extends c
{
  e$6$1(e.6 param6) {}
  
  public final String name()
  {
    return "onGetKeyboardHeight";
  }
  
  public final JSONObject tY()
  {
    AppMethodBeat.i(153088);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("height", this.uRS.uRR);
      label27:
      AppMethodBeat.o(153088);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.6.1
 * JD-Core Version:    0.7.0.1
 */