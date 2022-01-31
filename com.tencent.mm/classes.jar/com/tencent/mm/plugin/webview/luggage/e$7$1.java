package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class e$7$1
  extends c
{
  e$7$1(e.7 param7) {}
  
  public final String name()
  {
    return "onGetKeyboardHeight";
  }
  
  public final JSONObject tY()
  {
    AppMethodBeat.i(6014);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("height", 0);
      label22:
      AppMethodBeat.o(6014);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label22;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.7.1
 * JD-Core Version:    0.7.0.1
 */