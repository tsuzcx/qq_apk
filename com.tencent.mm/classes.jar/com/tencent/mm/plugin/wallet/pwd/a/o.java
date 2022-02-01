package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class o
  extends m
  implements j
{
  public o(u paramu)
  {
    AppMethodBeat.i(69566);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("flag", paramu.flag);
    localHashMap1.put("passwd", paramu.ijt);
    localHashMap1.put("rpasswd", paramu.ijt);
    localHashMap1.put("verify_code", paramu.Ahs);
    localHashMap1.put("token", paramu.token);
    setPayInfo(paramu.uXi, localHashMap1, localHashMap2);
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(69566);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.o
 * JD-Core Version:    0.7.0.1
 */