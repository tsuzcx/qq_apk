package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends m
{
  public boolean COb;
  public String dwj;
  
  public c(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(190046);
    this.dwj = null;
    this.COb = false;
    HashMap localHashMap = new HashMap();
    localHashMap.put("flag", String.valueOf(paramInt1));
    localHashMap.put("passwd", paramString1);
    localHashMap.put("req_key", paramString3);
    localHashMap.put("verify_code", paramString2);
    localHashMap.put("pay_scene", String.valueOf(paramInt2));
    localHashMap.put("ignore_bind", paramString4);
    if ("0".equals(paramString4)) {
      this.COb = true;
    }
    setRequestData(localHashMap);
    paramString1 = new HashMap();
    if (z.fVT())
    {
      paramString1.put("uuid_for_bindcard", z.getBindCardUuid());
      paramString1.put("bindcard_scene", z.fVU());
    }
    setWXRequestData(paramString1);
    AppMethodBeat.o(190046);
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
    AppMethodBeat.i(68393);
    ae.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(68393);
      return;
    }
    this.dwj = paramJSONObject.optString("req_key");
    AppMethodBeat.o(68393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.c
 * JD-Core Version:    0.7.0.1
 */