package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public class nr$e
{
  private String a;
  private long b;
  
  private JSONObject a()
  {
    AppMethodBeat.i(149539);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", this.a);
      localJSONObject.put("time", this.b);
      AppMethodBeat.o(149539);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(149539);
    }
    return null;
  }
  
  private static e b(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(149540);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(149540);
      return null;
    }
    e locale = new e();
    locale.a = paramJSONObject.optString("name");
    locale.b = paramJSONObject.optLong("time");
    AppMethodBeat.o(149540);
    return locale;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(149538);
    if (paramObject == this)
    {
      AppMethodBeat.o(149538);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(149538);
      return false;
    }
    paramObject = (e)paramObject;
    boolean bool = StringUtil.isEqual(this.a, paramObject.a);
    AppMethodBeat.o(149538);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(149537);
    if (this.a == null)
    {
      i = super.hashCode();
      AppMethodBeat.o(149537);
      return i;
    }
    int i = this.a.hashCode();
    AppMethodBeat.o(149537);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nr.e
 * JD-Core Version:    0.7.0.1
 */