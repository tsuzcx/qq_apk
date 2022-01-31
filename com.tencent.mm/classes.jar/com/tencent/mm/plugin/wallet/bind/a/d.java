package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends j
{
  public d(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("bank_type", paramString1);
    localHashMap.put("bind_serial", paramString2);
    localHashMap.put("passwd", paramString3);
    if (paramBoolean) {
      localHashMap.put("unbind_scene", "1");
    }
    D(localHashMap);
  }
  
  public d(String paramString1, String paramString2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("bank_type", paramString1);
    localHashMap.put("bind_serial", paramString2);
    localHashMap.put("expired_flag", "1");
    if (paramBoolean) {
      localHashMap.put("unbind_scene", "1");
    }
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 473;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject) {}
  
  public final int aEC()
  {
    return 14;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/unbind";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.a.d
 * JD-Core Version:    0.7.0.1
 */