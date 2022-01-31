package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.wallet_core.c.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends com.tencent.mm.wallet_core.tenpay.model.m
  implements i
{
  public m(u paramu)
  {
    AppMethodBeat.i(46192);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("flag", paramu.flag);
    localHashMap1.put("passwd", paramu.gww);
    localHashMap1.put("rpasswd", paramu.gww);
    localHashMap1.put("verify_code", paramu.uld);
    localHashMap1.put("token", paramu.token);
    setPayInfo(paramu.pVo, localHashMap1, localHashMap2);
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(46192);
  }
  
  public final int getFuncId()
  {
    return 478;
  }
  
  public final int getTenpayCgicmd()
  {
    return 20;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/resetpwd";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.m
 * JD-Core Version:    0.7.0.1
 */