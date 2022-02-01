package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public int VEc;
  public String VEd;
  public String VEe;
  public String VEf;
  public String VEg;
  public String VEh;
  
  public static f bgv(String paramString)
  {
    AppMethodBeat.i(70237);
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        f localf = new f();
        localf.VEc = paramString.optInt("menu_jump_type", -1);
        localf.VEd = paramString.optString("menu_jump_url", "");
        localf.VEe = paramString.optString("menu_username", "");
        localf.VEf = paramString.optString("menu_path", "");
        localf.VEg = paramString.optString("menu_title", "");
        localf.VEh = paramString.optString("menu_icon_url", "");
        Log.i("BindCardMenu", "parse bind card menu, type: %s, title: %s", new Object[] { Integer.valueOf(localf.VEc), localf.VEg });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.f
 * JD-Core Version:    0.7.0.1
 */