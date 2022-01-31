package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public int qtY;
  public String qtZ;
  public String qub;
  public String quc;
  public String qud;
  public String que;
  
  public static f Qn(String paramString)
  {
    if (!bk.bl(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        f localf = new f();
        localf.qtY = paramString.optInt("menu_jump_type", -1);
        localf.qtZ = paramString.optString("menu_jump_url", "");
        localf.qub = paramString.optString("menu_username", "");
        localf.quc = paramString.optString("menu_path", "");
        localf.qud = paramString.optString("menu_title", "");
        localf.que = paramString.optString("menu_icon_url", "");
        y.i("BindCardMenu", "parse bind card menu, type: %s, title: %s", new Object[] { Integer.valueOf(localf.qtY), localf.qud });
        return localf;
      }
      catch (JSONException paramString)
      {
        y.printErrStackTrace("BindCardMenu", paramString, "", new Object[0]);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.f
 * JD-Core Version:    0.7.0.1
 */