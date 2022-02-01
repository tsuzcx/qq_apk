package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s
  extends m
{
  public s(String paramString)
  {
    AppMethodBeat.i(69573);
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(69573);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69575);
    this.callback = paramf;
    int i = super.doScene(parame, paramf);
    AppMethodBeat.o(69575);
    return i;
  }
  
  public final int getFuncId()
  {
    return 1304;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/touchlockauthen";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69574);
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.toString();; paramJSONObject = "null")
    {
      ad.v("MicroMsg.NetSceneTouchLockVerifyByPwd", "alvinluo errCode: %d, errMsg: %s, json: %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
      AppMethodBeat.o(69574);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.s
 * JD-Core Version:    0.7.0.1
 */