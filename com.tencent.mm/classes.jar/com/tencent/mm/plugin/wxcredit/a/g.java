package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends m
{
  public String cCC;
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(48664);
    this.cCC = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("verify_code", paramString1);
    localHashMap.put("session_key", paramString2);
    localHashMap.put("passwd", paramString3);
    localHashMap.put("bind_serialno", paramString4);
    localHashMap.put("bank_type", paramString5);
    setRequestData(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("banktype", paramString5);
    setWXRequestData(paramString1);
    AppMethodBeat.o(48664);
  }
  
  public final int getTenpayCgicmd()
  {
    return 65;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48665);
    ab.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(48665);
      return;
    }
    this.cCC = paramJSONObject.optString("app_username");
    AppMethodBeat.o(48665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.g
 * JD-Core Version:    0.7.0.1
 */