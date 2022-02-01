package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class h$a
{
  public String HHX;
  public boolean HIl;
  public String dQx;
  public int pTZ;
  public boolean pTt;
  public String pUa;
  
  public static a aVa(String paramString)
  {
    AppMethodBeat.i(69543);
    a locala = new a();
    try
    {
      paramString = new JSONObject(paramString);
      locala.pTZ = paramString.optInt("ret_code");
      locala.pUa = paramString.optString("ret_msg");
      locala.pTt = paramString.optBoolean("is_show");
      locala.HIl = paramString.optBoolean("is_open");
      locala.HHX = paramString.optString("entrance_name");
      locala.dQx = paramString.optString("wording");
      AppMethodBeat.o(69543);
      return locala;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "createFromJSONObject() Exception:%s", new Object[] { paramString.getMessage() });
      }
    }
  }
  
  public final String fON()
  {
    AppMethodBeat.i(69542);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("ret_code", this.pTZ);
      ((JSONObject)localObject).put("ret_msg", this.pUa);
      ((JSONObject)localObject).put("is_show", this.pTt);
      ((JSONObject)localObject).put("is_open", this.HIl);
      ((JSONObject)localObject).put("entrance_name", this.HHX);
      ((JSONObject)localObject).put("wording", this.dQx);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(69542);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "MobileRemitSwitchConfig getJSONObjectString() Exception: %s", new Object[] { localJSONException.getMessage() });
      AppMethodBeat.o(69542);
    }
    return "";
  }
  
  public final String toString()
  {
    AppMethodBeat.i(69541);
    String str = "MobileRemitSwitchConfig{ret_code=" + this.pTZ + ", ret_msg='" + this.pUa + '\'' + ", is_show=" + this.pTt + ", is_open=" + this.HIl + ", entrance_name='" + this.HHX + '\'' + ", wording='" + this.dQx + '\'' + '}';
    AppMethodBeat.o(69541);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.h.a
 * JD-Core Version:    0.7.0.1
 */