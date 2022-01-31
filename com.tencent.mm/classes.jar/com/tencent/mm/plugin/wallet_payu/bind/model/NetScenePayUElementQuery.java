package com.tencent.mm.plugin.wallet_payu.bind.model;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class NetScenePayUElementQuery
  extends a
{
  public String qMF;
  public NetScenePayUElementQuery.PayUBankcardElement qMH;
  
  public NetScenePayUElementQuery(String paramString)
  {
    this.qMF = paramString;
    HashMap localHashMap = new HashMap();
    localHashMap.put("card_number", paramString);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.qMH = new NetScenePayUElementQuery.PayUBankcardElement();
    this.qMH.qMI = paramJSONObject.optString("bin");
    this.qMH.mOX = paramJSONObject.optString("bank_name");
    this.qMH.qMJ = paramJSONObject.optString("issuer_type");
    this.qMH.cardType = paramJSONObject.optString("card_type");
    this.qMH.bRP = paramJSONObject.optString("payu_reference");
  }
  
  public final int bUM()
  {
    return 22;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery
 * JD-Core Version:    0.7.0.1
 */