package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static final int[] npt = { -1, -1 };
  public static final int[] npu = { -2, -2 };
  public int bIl;
  public String name;
  public String npv;
  public String npw;
  public int[] npx = npt;
  
  public a(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, "", paramInt);
  }
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.npv = paramString1;
    this.name = paramString2;
    this.npw = paramString3;
    this.bIl = paramInt;
  }
  
  public static a ag(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("name");
    String str2 = paramJSONObject.optString("record");
    paramJSONObject = paramJSONObject.optString("location");
    if (!bk.bl(str2)) {
      return new a(str2, str1, paramJSONObject, 2);
    }
    return null;
  }
  
  public final JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("record", bk.aM(this.npv, ""));
      localJSONObject.put("name", bk.aM(this.name, ""));
      localJSONObject.put("location", bk.aM(this.npw, ""));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      y.printErrStackTrace("MicroMsg.MallInputRecord", localJSONException, "", new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.a
 * JD-Core Version:    0.7.0.1
 */