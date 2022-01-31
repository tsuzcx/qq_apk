package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p
  extends j
{
  public p(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_id", q.zg());
    localHashMap.put("passwd", paramString);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject) {}
  
  public final int aEC()
  {
    return 51;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.p
 * JD-Core Version:    0.7.0.1
 */