package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public int HWi;
  public String HWj;
  public String HWk;
  public String HWl;
  public String HWm;
  public String HWn;
  
  public static f aVf(String paramString)
  {
    AppMethodBeat.i(70237);
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        f localf = new f();
        localf.HWi = paramString.optInt("menu_jump_type", -1);
        localf.HWj = paramString.optString("menu_jump_url", "");
        localf.HWk = paramString.optString("menu_username", "");
        localf.HWl = paramString.optString("menu_path", "");
        localf.HWm = paramString.optString("menu_title", "");
        localf.HWn = paramString.optString("menu_icon_url", "");
        Log.i("BindCardMenu", "parse bind card menu, type: %s, title: %s", new Object[] { Integer.valueOf(localf.HWi), localf.HWm });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.f
 * JD-Core Version:    0.7.0.1
 */