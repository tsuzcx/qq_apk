package com.tencent.mm.plugin.wallet_index.b.a;

import java.util.ArrayList;
import org.json.JSONObject;

public final class c
{
  public String fdD;
  public String iZD;
  String mPackageName;
  public String mSignature;
  String qKY;
  public String qKZ;
  long qLa;
  int qLb;
  public String qLc;
  public String qLd;
  public String qLe;
  public String qLf;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    this.qKY = paramString1;
    this.qLd = paramString2;
    paramString1 = new JSONObject(this.qLd);
    this.qKZ = paramString1.optString("orderId");
    this.mPackageName = paramString1.optString("packageName");
    this.iZD = paramString1.optString("productId");
    this.qLa = paramString1.optLong("purchaseTime");
    this.qLb = paramString1.optInt("purchaseState");
    paramString2 = paramString1.optString("developerPayload");
    ArrayList localArrayList = QT(paramString2);
    if (localArrayList.size() == 3)
    {
      this.qLc = ((String)localArrayList.get(0));
      this.qLf = ((String)localArrayList.get(1));
      this.qLe = ((String)localArrayList.get(2));
    }
    for (;;)
    {
      this.fdD = paramString1.optString("token", paramString1.optString("purchaseToken"));
      this.mSignature = paramString3;
      return;
      this.qLc = paramString2;
    }
  }
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.iZD = paramString1;
    this.qLc = paramString2;
    this.qLe = paramString3;
    this.qLf = paramString4;
  }
  
  private static ArrayList<String> QT(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramString.indexOf("[#]") >= 0)
    {
      String str = paramString.substring(0, paramString.indexOf("[#]"));
      paramString = paramString.substring(str.length() + 3);
      localArrayList.add(str);
    }
    localArrayList.add(paramString);
    return localArrayList;
  }
  
  public final String toString()
  {
    return "PurchaseInfo(type:" + this.qKY + "):" + this.qLd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.b.a.c
 * JD-Core Version:    0.7.0.1
 */