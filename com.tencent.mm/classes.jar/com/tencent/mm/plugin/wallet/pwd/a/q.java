package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q
  extends m
{
  public q(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69570);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("resetpwd_token", paramString2);
    localHashMap1.put("passwd", paramString1);
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(69570);
  }
  
  public final int getFuncId()
  {
    return 1371;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1371;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/resetpwdbytoken";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69571);
    ad.d("MicroMsg.NetSceneTenpayResetPwdByToken", " json %s", new Object[] { paramJSONObject.toString() });
    AppMethodBeat.o(69571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.q
 * JD-Core Version:    0.7.0.1
 */