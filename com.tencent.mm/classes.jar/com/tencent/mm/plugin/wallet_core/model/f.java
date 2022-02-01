package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public int DmQ;
  public String DmR;
  public String DmS;
  public String DmT;
  public String DmU;
  public String DmV;
  
  public static f aFG(String paramString)
  {
    AppMethodBeat.i(70237);
    if (!bu.isNullOrNil(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        f localf = new f();
        localf.DmQ = paramString.optInt("menu_jump_type", -1);
        localf.DmR = paramString.optString("menu_jump_url", "");
        localf.DmS = paramString.optString("menu_username", "");
        localf.DmT = paramString.optString("menu_path", "");
        localf.DmU = paramString.optString("menu_title", "");
        localf.DmV = paramString.optString("menu_icon_url", "");
        ae.i("BindCardMenu", "parse bind card menu, type: %s, title: %s", new Object[] { Integer.valueOf(localf.DmQ), localf.DmU });
        AppMethodBeat.o(70237);
        return localf;
      }
      catch (JSONException paramString)
      {
        ae.printErrStackTrace("BindCardMenu", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(70237);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.f
 * JD-Core Version:    0.7.0.1
 */