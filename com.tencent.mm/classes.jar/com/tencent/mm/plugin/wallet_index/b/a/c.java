package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import org.json.JSONObject;

public final class c
{
  String DHo;
  public String DHp;
  long DHq;
  int DHr;
  public String DHs;
  public String DHt;
  public String DHu;
  public String DHv;
  public String cff;
  String mPackageName;
  public String mToken;
  public String pMk;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(71806);
    this.DHo = paramString1;
    this.DHt = paramString2;
    paramString1 = new JSONObject(this.DHt);
    this.DHp = paramString1.optString("orderId");
    this.mPackageName = paramString1.optString("packageName");
    this.pMk = paramString1.optString("productId");
    this.DHq = paramString1.optLong("purchaseTime");
    this.DHr = paramString1.optInt("purchaseState");
    paramString2 = paramString1.optString("developerPayload");
    ArrayList localArrayList = aGw(paramString2);
    if (localArrayList.size() == 3)
    {
      this.DHs = ((String)localArrayList.get(0));
      this.DHv = ((String)localArrayList.get(1));
      this.DHu = ((String)localArrayList.get(2));
    }
    for (;;)
    {
      this.mToken = paramString1.optString("token", paramString1.optString("purchaseToken"));
      this.cff = paramString3;
      AppMethodBeat.o(71806);
      return;
      this.DHs = paramString2;
    }
  }
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.pMk = paramString1;
    this.DHs = paramString2;
    this.DHu = paramString3;
    this.DHv = paramString4;
  }
  
  private static ArrayList<String> aGw(String paramString)
  {
    AppMethodBeat.i(71807);
    ArrayList localArrayList = new ArrayList();
    while (paramString.indexOf("[#]") >= 0)
    {
      String str = paramString.substring(0, paramString.indexOf("[#]"));
      paramString = paramString.substring(str.length() + 3);
      localArrayList.add(str);
    }
    localArrayList.add(paramString);
    AppMethodBeat.o(71807);
    return localArrayList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(71808);
    String str = "PurchaseInfo(type:" + this.DHo + "):" + this.DHt;
    AppMethodBeat.o(71808);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.b.a.c
 * JD-Core Version:    0.7.0.1
 */