package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends m
{
  public h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(72310);
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
    AppMethodBeat.o(72310);
  }
  
  public final int getTenpayCgicmd()
  {
    return 66;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72311);
    ad.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    AppMethodBeat.o(72311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.h
 * JD-Core Version:    0.7.0.1
 */