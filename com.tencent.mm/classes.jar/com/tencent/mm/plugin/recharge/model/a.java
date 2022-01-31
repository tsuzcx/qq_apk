package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static final int[] pUH = { -1, -1 };
  public static final int[] pUI = { -2, -2 };
  public int cpG;
  public String name;
  public String pUJ;
  public String pUK;
  public int[] pUL = pUH;
  
  public a(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, "", paramInt);
  }
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.pUJ = paramString1;
    this.name = paramString2;
    this.pUK = paramString3;
    this.cpG = paramInt;
  }
  
  public static a ao(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(44182);
    String str1 = paramJSONObject.optString("name");
    String str2 = paramJSONObject.optString("record");
    paramJSONObject = paramJSONObject.optString("location");
    if (!bo.isNullOrNil(str2))
    {
      paramJSONObject = new a(str2, str1, paramJSONObject, 2);
      AppMethodBeat.o(44182);
      return paramJSONObject;
    }
    AppMethodBeat.o(44182);
    return null;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(44181);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("record", bo.bf(this.pUJ, ""));
      localJSONObject.put("name", bo.bf(this.name, ""));
      localJSONObject.put("location", bo.bf(this.pUK, ""));
      AppMethodBeat.o(44181);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      ab.printErrStackTrace("MicroMsg.MallInputRecord", localJSONException, "", new Object[0]);
      AppMethodBeat.o(44181);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.a
 * JD-Core Version:    0.7.0.1
 */