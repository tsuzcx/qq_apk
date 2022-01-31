package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

class nr$b
{
  private boolean a = false;
  private long b = 0L;
  
  private JSONObject a()
  {
    AppMethodBeat.i(149523);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("success", this.a);
      localJSONObject.put("loadBeginTime", this.b);
      AppMethodBeat.o(149523);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(149523);
    }
    return null;
  }
  
  private static b b(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(149524);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(149524);
      return null;
    }
    b localb = new b();
    localb.a = paramJSONObject.optBoolean("success");
    localb.b = paramJSONObject.optLong("loadBeginTime");
    AppMethodBeat.o(149524);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nr.b
 * JD-Core Version:    0.7.0.1
 */