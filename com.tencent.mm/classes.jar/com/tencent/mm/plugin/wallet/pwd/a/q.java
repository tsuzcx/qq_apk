package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q
  extends m
{
  public q(w paramw)
  {
    AppMethodBeat.i(69572);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("verify_code", paramw.VJo);
    localHashMap1.put("token", paramw.token);
    setPayInfo(paramw.Nxi, localHashMap1, localHashMap2);
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(69572);
  }
  
  public final int getFuncId()
  {
    return 470;
  }
  
  public final int getTenpayCgicmd()
  {
    return 11;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/resetpwdverify";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.q
 * JD-Core Version:    0.7.0.1
 */