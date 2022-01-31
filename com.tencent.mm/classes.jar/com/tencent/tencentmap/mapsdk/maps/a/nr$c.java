package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public class nr$c
{
  public String a;
  public long b;
  public String c;
  public String d;
  public int e;
  public int f;
  
  private JSONObject a()
  {
    AppMethodBeat.i(149529);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", this.a);
      localJSONObject.put("time", this.b);
      localJSONObject.put("expectMd5", this.c);
      localJSONObject.put("actualMd5", this.d);
      localJSONObject.put("localVer", this.e);
      localJSONObject.put("netError", this.f);
      AppMethodBeat.o(149529);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(149529);
    }
    return null;
  }
  
  private static c b(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(149530);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(149530);
      return null;
    }
    c localc = new c();
    localc.a = paramJSONObject.optString("name");
    localc.b = paramJSONObject.optLong("time");
    localc.c = paramJSONObject.optString("expectMd5");
    localc.d = paramJSONObject.optString("actualMd5");
    localc.e = paramJSONObject.optInt("localVer");
    localc.f = paramJSONObject.optInt("netError");
    AppMethodBeat.o(149530);
    return localc;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(149528);
    if (paramObject == this)
    {
      AppMethodBeat.o(149528);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(149528);
      return false;
    }
    paramObject = (c)paramObject;
    boolean bool = StringUtil.isEqual(this.a, paramObject.a);
    AppMethodBeat.o(149528);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(149527);
    if (this.a == null)
    {
      i = super.hashCode();
      AppMethodBeat.o(149527);
      return i;
    }
    int i = this.a.hashCode();
    AppMethodBeat.o(149527);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nr.c
 * JD-Core Version:    0.7.0.1
 */