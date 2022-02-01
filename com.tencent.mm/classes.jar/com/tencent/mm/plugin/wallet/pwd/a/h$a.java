package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class h$a
{
  public String CKD;
  public boolean CKR;
  public String dxD;
  public int ozR;
  public String ozS;
  public boolean ozk;
  
  public static a aEj(String paramString)
  {
    AppMethodBeat.i(69543);
    a locala = new a();
    try
    {
      paramString = new JSONObject(paramString);
      locala.ozR = paramString.optInt("ret_code");
      locala.ozS = paramString.optString("ret_msg");
      locala.ozk = paramString.optBoolean("is_show");
      locala.CKR = paramString.optBoolean("is_open");
      locala.CKD = paramString.optString("entrance_name");
      locala.dxD = paramString.optString("wording");
      AppMethodBeat.o(69543);
      return locala;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "createFromJSONObject() Exception:%s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final String eDW()
  {
    AppMethodBeat.i(69542);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("ret_code", this.ozR);
      ((JSONObject)localObject).put("ret_msg", this.ozS);
      ((JSONObject)localObject).put("is_show", this.ozk);
      ((JSONObject)localObject).put("is_open", this.CKR);
      ((JSONObject)localObject).put("entrance_name", this.CKD);
      ((JSONObject)localObject).put("wording", this.dxD);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(69542);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "MobileRemitSwitchConfig getJSONObjectString() Exception: %s", new Object[] { localJSONException.getMessage() });
      AppMethodBeat.o(69542);
    }
    return "";
  }
  
  public final String toString()
  {
    AppMethodBeat.i(69541);
    String str = "MobileRemitSwitchConfig{ret_code=" + this.ozR + ", ret_msg='" + this.ozS + '\'' + ", is_show=" + this.ozk + ", is_open=" + this.CKR + ", entrance_name='" + this.CKD + '\'' + ", wording='" + this.dxD + '\'' + '}';
    AppMethodBeat.o(69541);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.h.a
 * JD-Core Version:    0.7.0.1
 */