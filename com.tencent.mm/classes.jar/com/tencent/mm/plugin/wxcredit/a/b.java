package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends m
{
  public String name;
  public String token;
  public String vHx;
  public boolean vHy;
  
  public b(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(48655);
    this.vHy = true;
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("bank_type", paramString2);
    localHashMap.put("check_pwd_scene", String.valueOf(paramInt));
    setRequestData(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("check_pwd_scene", String.valueOf(paramInt));
    setWXRequestData(paramString1);
    AppMethodBeat.o(48655);
  }
  
  public final int getTenpayCgicmd()
  {
    return 63;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48656);
    ab.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(48656);
      return;
    }
    this.token = paramJSONObject.optString("session_key");
    if ("1".equals(paramJSONObject.optString("all_info")))
    {
      this.vHy = false;
      AppMethodBeat.o(48656);
      return;
    }
    this.vHy = true;
    this.name = paramJSONObject.optString("name");
    this.vHx = paramJSONObject.optString("cre_id");
    AppMethodBeat.o(48656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.b
 * JD-Core Version:    0.7.0.1
 */