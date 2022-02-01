package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class h$a
{
  public String doh;
  public boolean nsQ;
  public int ntx;
  public String nty;
  public String zRV;
  public boolean zSj;
  
  public static a atJ(String paramString)
  {
    AppMethodBeat.i(69543);
    a locala = new a();
    try
    {
      paramString = new JSONObject(paramString);
      locala.ntx = paramString.optInt("ret_code");
      locala.nty = paramString.optString("ret_msg");
      locala.nsQ = paramString.optBoolean("is_show");
      locala.zSj = paramString.optBoolean("is_open");
      locala.zRV = paramString.optString("entrance_name");
      locala.doh = paramString.optString("wording");
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
  
  public final String eaA()
  {
    AppMethodBeat.i(69542);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("ret_code", this.ntx);
      ((JSONObject)localObject).put("ret_msg", this.nty);
      ((JSONObject)localObject).put("is_show", this.nsQ);
      ((JSONObject)localObject).put("is_open", this.zSj);
      ((JSONObject)localObject).put("entrance_name", this.zRV);
      ((JSONObject)localObject).put("wording", this.doh);
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
    String str = "MobileRemitSwitchConfig{ret_code=" + this.ntx + ", ret_msg='" + this.nty + '\'' + ", is_show=" + this.nsQ + ", is_open=" + this.zSj + ", entrance_name='" + this.zRV + '\'' + ", wording='" + this.doh + '\'' + '}';
    AppMethodBeat.o(69541);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.h.a
 * JD-Core Version:    0.7.0.1
 */