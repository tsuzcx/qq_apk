package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

class nr$g
{
  private long a;
  private String b;
  private int c;
  
  private JSONObject a()
  {
    AppMethodBeat.i(149549);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("time", this.a);
      localJSONObject.put("tid", this.b);
      localJSONObject.put("netError", this.c);
      AppMethodBeat.o(149549);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(149549);
    }
    return null;
  }
  
  private static g b(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(149550);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(149550);
      return null;
    }
    g localg = new g();
    localg.a = paramJSONObject.optLong("time");
    localg.b = paramJSONObject.optString("tid");
    localg.c = paramJSONObject.optInt("netError");
    AppMethodBeat.o(149550);
    return localg;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(149548);
    if (paramObject == this)
    {
      AppMethodBeat.o(149548);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(149548);
      return false;
    }
    paramObject = (g)paramObject;
    boolean bool = StringUtil.isEqual(this.b, paramObject.b);
    AppMethodBeat.o(149548);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(149547);
    if (this.b == null)
    {
      i = super.hashCode();
      AppMethodBeat.o(149547);
      return i;
    }
    int i = this.b.hashCode();
    AppMethodBeat.o(149547);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nr.g
 * JD-Core Version:    0.7.0.1
 */