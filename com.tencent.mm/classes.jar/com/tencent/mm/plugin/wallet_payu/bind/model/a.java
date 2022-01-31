package com.tencent.mm.plugin.wallet_payu.bind.model;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public String cdi;
  public String description;
  public String pin;
  public String qME;
  public String qMF;
  public String qMG;
  public String qMu;
  public String qzS;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.qME = paramString1;
    this.qzS = paramString2;
    this.cdi = paramString3;
    this.qMF = paramString4;
    this.qMG = paramString5;
    this.description = paramString6;
    this.qMu = paramString7;
    this.pin = paramString8;
    HashMap localHashMap = new HashMap();
    localHashMap.put("bank_type", paramString1);
    localHashMap.put("information", paramString2);
    localHashMap.put("name_on_card", paramString3);
    localHashMap.put("card_number", paramString4);
    localHashMap.put("card_expiry", paramString5);
    localHashMap.put("description", paramString6);
    localHashMap.put("cvv", paramString7);
    localHashMap.put("pin", paramString8);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject) {}
  
  public final int bUM()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.a
 * JD-Core Version:    0.7.0.1
 */