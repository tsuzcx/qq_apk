package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q
  extends m
{
  public q(String paramString)
  {
    AppMethodBeat.i(46199);
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(46199);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(46201);
    this.callback = paramf;
    int i = super.doScene(parame, paramf);
    AppMethodBeat.o(46201);
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
    AppMethodBeat.i(46200);
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.toString();; paramJSONObject = "null")
    {
      ab.v("MicroMsg.NetSceneTouchLockVerifyByPwd", "alvinluo errCode: %d, errMsg: %s, json: %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
      AppMethodBeat.o(46200);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.q
 * JD-Core Version:    0.7.0.1
 */