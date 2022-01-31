package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
{
  public int ugt;
  public String ugu;
  public String ugv;
  public String ugw;
  public String ugx;
  public String ugy;
  
  public static h aff(String paramString)
  {
    AppMethodBeat.i(46720);
    if (!bo.isNullOrNil(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        h localh = new h();
        localh.ugt = paramString.optInt("menu_jump_type", -1);
        localh.ugu = paramString.optString("menu_jump_url", "");
        localh.ugv = paramString.optString("menu_username", "");
        localh.ugw = paramString.optString("menu_path", "");
        localh.ugx = paramString.optString("menu_title", "");
        localh.ugy = paramString.optString("menu_icon_url", "");
        ab.i("BindCardMenu", "parse bind card menu, type: %s, title: %s", new Object[] { Integer.valueOf(localh.ugt), localh.ugx });
        AppMethodBeat.o(46720);
        return localh;
      }
      catch (JSONException paramString)
      {
        ab.printErrStackTrace("BindCardMenu", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(46720);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.h
 * JD-Core Version:    0.7.0.1
 */