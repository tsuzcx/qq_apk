package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public int OOi;
  public String OOj;
  public String OOk;
  public String OOl;
  public String OOm;
  public String OOn;
  
  public static f bgO(String paramString)
  {
    AppMethodBeat.i(70237);
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        f localf = new f();
        localf.OOi = paramString.optInt("menu_jump_type", -1);
        localf.OOj = paramString.optString("menu_jump_url", "");
        localf.OOk = paramString.optString("menu_username", "");
        localf.OOl = paramString.optString("menu_path", "");
        localf.OOm = paramString.optString("menu_title", "");
        localf.OOn = paramString.optString("menu_icon_url", "");
        Log.i("BindCardMenu", "parse bind card menu, type: %s, title: %s", new Object[] { Integer.valueOf(localf.OOi), localf.OOm });
        AppMethodBeat.o(70237);
        return localf;
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("BindCardMenu", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(70237);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.f
 * JD-Core Version:    0.7.0.1
 */