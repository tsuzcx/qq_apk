package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public int BuV;
  public String BuW;
  public String BuX;
  public String BuY;
  public String BuZ;
  public String Bva;
  
  public static f aze(String paramString)
  {
    AppMethodBeat.i(70237);
    if (!bs.isNullOrNil(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        f localf = new f();
        localf.BuV = paramString.optInt("menu_jump_type", -1);
        localf.BuW = paramString.optString("menu_jump_url", "");
        localf.BuX = paramString.optString("menu_username", "");
        localf.BuY = paramString.optString("menu_path", "");
        localf.BuZ = paramString.optString("menu_title", "");
        localf.Bva = paramString.optString("menu_icon_url", "");
        ac.i("BindCardMenu", "parse bind card menu, type: %s, title: %s", new Object[] { Integer.valueOf(localf.BuV), localf.BuZ });
        AppMethodBeat.o(70237);
        return localf;
      }
      catch (JSONException paramString)
      {
        ac.printErrStackTrace("BindCardMenu", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(70237);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.f
 * JD-Core Version:    0.7.0.1
 */