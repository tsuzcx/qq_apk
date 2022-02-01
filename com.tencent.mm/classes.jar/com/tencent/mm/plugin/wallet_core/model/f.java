package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public int CVk;
  public String CVl;
  public String CVm;
  public String CVn;
  public String CVo;
  public String CVp;
  
  public static f aEm(String paramString)
  {
    AppMethodBeat.i(70237);
    if (!bt.isNullOrNil(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        f localf = new f();
        localf.CVk = paramString.optInt("menu_jump_type", -1);
        localf.CVl = paramString.optString("menu_jump_url", "");
        localf.CVm = paramString.optString("menu_username", "");
        localf.CVn = paramString.optString("menu_path", "");
        localf.CVo = paramString.optString("menu_title", "");
        localf.CVp = paramString.optString("menu_icon_url", "");
        ad.i("BindCardMenu", "parse bind card menu, type: %s, title: %s", new Object[] { Integer.valueOf(localf.CVk), localf.CVo });
        AppMethodBeat.o(70237);
        return localf;
      }
      catch (JSONException paramString)
      {
        ad.printErrStackTrace("BindCardMenu", paramString, "", new Object[0]);
      }
    }
    AppMethodBeat.o(70237);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.f
 * JD-Core Version:    0.7.0.1
 */