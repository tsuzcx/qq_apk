package com.tencent.mm.plugin.offline.a;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j
  extends com.tencent.mm.wallet_core.tenpay.model.j
{
  public j(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString);
    localHashMap.put("device_id", com.tencent.mm.compatible.e.q.zg());
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 566;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject) {}
  
  public final int aEC()
  {
    return 47;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlineclose";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.j
 * JD-Core Version:    0.7.0.1
 */