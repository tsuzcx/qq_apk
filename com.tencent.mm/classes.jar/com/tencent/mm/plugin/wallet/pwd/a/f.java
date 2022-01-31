package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends j
  implements g
{
  public f(p paramp)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("flag", paramp.flag);
    localHashMap1.put("passwd", paramp.feN);
    localHashMap1.put("rpasswd", paramp.feN);
    localHashMap1.put("verify_code", paramp.qyu);
    localHashMap1.put("token", paramp.token);
    a(paramp.nqa, localHashMap1, localHashMap2);
    D(localHashMap1);
    aC(localHashMap2);
  }
  
  public final int HH()
  {
    return 478;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject) {}
  
  public final int aEC()
  {
    return 20;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/resetpwd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.f
 * JD-Core Version:    0.7.0.1
 */