package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static final int[] BCV = { -1, -1 };
  public static final int[] BCW = { -2, -2 };
  public String BCX;
  public int[] BCY = BCV;
  public String ljO;
  public String name;
  public int sourceType;
  
  public a(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, "", paramInt);
  }
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.BCX = paramString1;
    this.name = paramString2;
    this.ljO = paramString3;
    this.sourceType = paramInt;
  }
  
  public static a bj(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67090);
    String str1 = paramJSONObject.optString("name");
    String str2 = paramJSONObject.optString("record");
    paramJSONObject = paramJSONObject.optString("location");
    if (!Util.isNullOrNil(str2))
    {
      paramJSONObject = new a(str2, str1, paramJSONObject, 2);
      AppMethodBeat.o(67090);
      return paramJSONObject;
    }
    AppMethodBeat.o(67090);
    return null;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(67089);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("record", Util.nullAs(this.BCX, ""));
      localJSONObject.put("name", Util.nullAs(this.name, ""));
      localJSONObject.put("location", Util.nullAs(this.ljO, ""));
      AppMethodBeat.o(67089);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace("MicroMsg.MallInputRecord", localJSONException, "", new Object[0]);
      AppMethodBeat.o(67089);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.a
 * JD-Core Version:    0.7.0.1
 */