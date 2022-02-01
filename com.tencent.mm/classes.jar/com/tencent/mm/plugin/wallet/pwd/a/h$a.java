package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

public final class h$a
{
  public boolean BkD;
  public String Bkp;
  public String dlQ;
  public boolean nVQ;
  public int nWx;
  public String nWy;
  
  public static a azb(String paramString)
  {
    AppMethodBeat.i(69543);
    a locala = new a();
    try
    {
      paramString = new JSONObject(paramString);
      locala.nWx = paramString.optInt("ret_code");
      locala.nWy = paramString.optString("ret_msg");
      locala.nVQ = paramString.optBoolean("is_show");
      locala.BkD = paramString.optBoolean("is_open");
      locala.Bkp = paramString.optString("entrance_name");
      locala.dlQ = paramString.optString("wording");
      AppMethodBeat.o(69543);
      return locala;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "createFromJSONObject() Exception:%s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final String epW()
  {
    AppMethodBeat.i(69542);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("ret_code", this.nWx);
      ((JSONObject)localObject).put("ret_msg", this.nWy);
      ((JSONObject)localObject).put("is_show", this.nVQ);
      ((JSONObject)localObject).put("is_open", this.BkD);
      ((JSONObject)localObject).put("entrance_name", this.Bkp);
      ((JSONObject)localObject).put("wording", this.dlQ);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(69542);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      ac.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "MobileRemitSwitchConfig getJSONObjectString() Exception: %s", new Object[] { localJSONException.getMessage() });
      AppMethodBeat.o(69542);
    }
    return "";
  }
  
  public final String toString()
  {
    AppMethodBeat.i(69541);
    String str = "MobileRemitSwitchConfig{ret_code=" + this.nWx + ", ret_msg='" + this.nWy + '\'' + ", is_show=" + this.nVQ + ", is_open=" + this.BkD + ", entrance_name='" + this.Bkp + '\'' + ", wording='" + this.dlQ + '\'' + '}';
    AppMethodBeat.o(69541);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.h.a
 * JD-Core Version:    0.7.0.1
 */