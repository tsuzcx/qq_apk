package com.tencent.mm.plugin.wallet_payu.bind.model;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public String bRP;
  public String qMK;
  
  public b(String paramString1, String paramString2)
  {
    this.qMK = paramString1;
    this.bRP = paramString2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("bind_serial", paramString1);
    localHashMap.put("payu_reference", paramString2);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject) {}
  
  public final int bUM()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.b
 * JD-Core Version:    0.7.0.1
 */