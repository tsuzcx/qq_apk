package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends m
{
  public String BKj;
  public boolean BKk;
  public String name;
  public String token;
  
  public b(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(72299);
    this.BKk = true;
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("bank_type", paramString2);
    localHashMap.put("check_pwd_scene", String.valueOf(paramInt));
    setRequestData(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("check_pwd_scene", String.valueOf(paramInt));
    setWXRequestData(paramString1);
    AppMethodBeat.o(72299);
  }
  
  public final int getTenpayCgicmd()
  {
    return 63;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72300);
    ad.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(72300);
      return;
    }
    this.token = paramJSONObject.optString("session_key");
    if ("1".equals(paramJSONObject.optString("all_info")))
    {
      this.BKk = false;
      AppMethodBeat.o(72300);
      return;
    }
    this.BKk = true;
    this.name = paramJSONObject.optString("name");
    this.BKj = paramJSONObject.optString("cre_id");
    AppMethodBeat.o(72300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.b
 * JD-Core Version:    0.7.0.1
 */