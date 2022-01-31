package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

class nr$f
{
  private int a;
  
  private JSONObject a()
  {
    AppMethodBeat.i(149543);
    try
    {
      JSONObject localJSONObject = new JSONObject().put("wtc", this.a);
      AppMethodBeat.o(149543);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(149543);
    }
    return null;
  }
  
  private static f b(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(149544);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(149544);
      return null;
    }
    f localf = new f();
    localf.a = paramJSONObject.optInt("wtc");
    AppMethodBeat.o(149544);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nr.f
 * JD-Core Version:    0.7.0.1
 */