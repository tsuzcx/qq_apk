package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class o
  extends m
{
  public o(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46196);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("resetpwd_token", paramString2);
    localHashMap1.put("passwd", paramString1);
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(46196);
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
    AppMethodBeat.i(46197);
    ab.d("MicroMsg.NetSceneTenpayResetPwdByToken", " json %s", new Object[] { paramJSONObject.toString() });
    AppMethodBeat.o(46197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.o
 * JD-Core Version:    0.7.0.1
 */