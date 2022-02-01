package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class h$a
{
  public String Vpa;
  public boolean Vpm;
  public boolean Vpn;
  public String Vpo;
  public String Vpp;
  public String Vpq;
  public String wording;
  public boolean wtT;
  public String wuA;
  public int wuz;
  
  public static a bgp(String paramString)
  {
    AppMethodBeat.i(69543);
    a locala = new a();
    try
    {
      paramString = new JSONObject(paramString);
      locala.wuz = paramString.optInt("ret_code");
      locala.wuA = paramString.optString("ret_msg");
      locala.wtT = paramString.optBoolean("is_show");
      locala.Vpm = paramString.optBoolean("is_open");
      locala.Vpa = paramString.optString("entrance_name");
      locala.wording = paramString.optString("wording");
      locala.Vpn = paramString.optBoolean("is_new_user");
      locala.Vpo = paramString.optString("compliance_item_wording");
      locala.Vpp = paramString.optString("compliance_item_title");
      locala.Vpq = paramString.optString("compliance_item_link");
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
  
  public final String igw()
  {
    AppMethodBeat.i(69542);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("ret_code", this.wuz);
      ((JSONObject)localObject).put("ret_msg", this.wuA);
      ((JSONObject)localObject).put("is_show", this.wtT);
      ((JSONObject)localObject).put("is_open", this.Vpm);
      ((JSONObject)localObject).put("entrance_name", this.Vpa);
      ((JSONObject)localObject).put("wording", this.wording);
      ((JSONObject)localObject).put("is_new_user", this.Vpn);
      ((JSONObject)localObject).put("compliance_item_wording", this.Vpo);
      ((JSONObject)localObject).put("compliance_item_title", this.Vpp);
      ((JSONObject)localObject).put("compliance_item_link", this.Vpq);
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
    String str = "MobileRemitSwitchConfig{ret_code=" + this.wuz + ", ret_msg='" + this.wuA + '\'' + ", is_show=" + this.wtT + ", is_open=" + this.Vpm + ", entrance_name='" + this.Vpa + '\'' + ", wording='" + this.wording + '\'' + ", is_new_user='" + this.Vpn + ", compliance_item_wording='" + this.Vpo + '\'' + ", compliance_item_title='" + this.Vpp + '\'' + ", compliance_item_link='" + this.Vpq + '\'' + '}';
    AppMethodBeat.o(69541);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.h.a
 * JD-Core Version:    0.7.0.1
 */