package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends j
{
  public f(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("bank_type", paramString1);
    localHashMap.put("bind_serial", paramString2);
    localHashMap.put("passwd", paramString3);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject) {}
  
  public final int aEC()
  {
    return 62;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.f
 * JD-Core Version:    0.7.0.1
 */