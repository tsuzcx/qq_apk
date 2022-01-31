package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends j
{
  public h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("verify_code", paramString1);
    localHashMap.put("session_key", paramString2);
    localHashMap.put("passwd", paramString3);
    localHashMap.put("bind_serialno", paramString4);
    localHashMap.put("bank_type", paramString5);
    D(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("banktype", paramString5);
    aC(paramString1);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
  }
  
  public final int aEC()
  {
    return 66;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.h
 * JD-Core Version:    0.7.0.1
 */