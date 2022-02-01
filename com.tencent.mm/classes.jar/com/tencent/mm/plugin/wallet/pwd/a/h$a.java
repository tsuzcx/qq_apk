package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class h$a
{
  public String Dcj;
  public boolean Dcx;
  public String dyI;
  public boolean oFM;
  public int oGt;
  public String oGu;
  
  public static a aFC(String paramString)
  {
    AppMethodBeat.i(69543);
    a locala = new a();
    try
    {
      paramString = new JSONObject(paramString);
      locala.oGt = paramString.optInt("ret_code");
      locala.oGu = paramString.optString("ret_msg");
      locala.oFM = paramString.optBoolean("is_show");
      locala.Dcx = paramString.optBoolean("is_open");
      locala.Dcj = paramString.optString("entrance_name");
      locala.dyI = paramString.optString("wording");
      AppMethodBeat.o(69543);
      return locala;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "createFromJSONObject() Exception:%s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final String eHD()
  {
    AppMethodBeat.i(69542);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("ret_code", this.oGt);
      ((JSONObject)localObject).put("ret_msg", this.oGu);
      ((JSONObject)localObject).put("is_show", this.oFM);
      ((JSONObject)localObject).put("is_open", this.Dcx);
      ((JSONObject)localObject).put("entrance_name", this.Dcj);
      ((JSONObject)localObject).put("wording", this.dyI);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(69542);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      ae.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "MobileRemitSwitchConfig getJSONObjectString() Exception: %s", new Object[] { localJSONException.getMessage() });
      AppMethodBeat.o(69542);
    }
    return "";
  }
  
  public final String toString()
  {
    AppMethodBeat.i(69541);
    String str = "MobileRemitSwitchConfig{ret_code=" + this.oGt + ", ret_msg='" + this.oGu + '\'' + ", is_show=" + this.oFM + ", is_open=" + this.Dcx + ", entrance_name='" + this.Dcj + '\'' + ", wording='" + this.dyI + '\'' + '}';
    AppMethodBeat.o(69541);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.h.a
 * JD-Core Version:    0.7.0.1
 */