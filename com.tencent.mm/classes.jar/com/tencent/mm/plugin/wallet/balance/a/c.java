package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends m
{
  public String cwk;
  
  public c(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(45221);
    this.cwk = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("flag", String.valueOf(paramInt1));
    localHashMap.put("passwd", paramString1);
    localHashMap.put("req_key", paramString3);
    localHashMap.put("verify_code", paramString2);
    localHashMap.put("pay_scene", String.valueOf(paramInt2));
    localHashMap.put("ignore_bind", paramString4);
    setRequestData(localHashMap);
    paramString1 = new HashMap();
    if (x.dSp())
    {
      paramString1.put("uuid_for_bindcard", x.dSr());
      paramString1.put("bindcard_scene", x.dSq());
    }
    setWXRequestData(paramString1);
    AppMethodBeat.o(45221);
  }
  
  public final int getFuncId()
  {
    return 1506;
  }
  
  public final int getTenpayCgicmd()
  {
    return 76;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/verifybind";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(45222);
    ab.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(45222);
      return;
    }
    this.cwk = paramJSONObject.optString("req_key");
    AppMethodBeat.o(45222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.c
 * JD-Core Version:    0.7.0.1
 */