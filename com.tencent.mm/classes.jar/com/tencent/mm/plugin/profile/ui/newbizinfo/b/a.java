package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class a
{
  public String aVr;
  public String krI;
  public String naf;
  public int nag;
  public String userName;
  
  public static a ad(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.BizAccount", "json is null, err");
      return null;
    }
    a locala = new a();
    try
    {
      locala.userName = paramJSONObject.optString("UserName");
      locala.aVr = paramJSONObject.optString("NickName");
      locala.krI = paramJSONObject.optString("HeadImgUrl");
      locala.naf = paramJSONObject.optString("FriendSubscribeDesc");
      locala.nag = paramJSONObject.optInt("IsSubscribed");
      return locala;
    }
    catch (Exception paramJSONObject)
    {
      y.b("MicroMsg.BizAccount", "", new Object[] { paramJSONObject });
    }
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.a
 * JD-Core Version:    0.7.0.1
 */