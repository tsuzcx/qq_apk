package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import org.json.JSONObject;

public final class c
{
  String BPq;
  public String BPr;
  long BPs;
  int BPt;
  public String BPu;
  public String BPv;
  public String BPw;
  public String BPx;
  public String bUS;
  String mPackageName;
  public String mToken;
  public String pbW;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(71806);
    this.BPq = paramString1;
    this.BPv = paramString2;
    paramString1 = new JSONObject(this.BPv);
    this.BPr = paramString1.optString("orderId");
    this.mPackageName = paramString1.optString("packageName");
    this.pbW = paramString1.optString("productId");
    this.BPs = paramString1.optLong("purchaseTime");
    this.BPt = paramString1.optInt("purchaseState");
    paramString2 = paramString1.optString("developerPayload");
    ArrayList localArrayList = azS(paramString2);
    if (localArrayList.size() == 3)
    {
      this.BPu = ((String)localArrayList.get(0));
      this.BPx = ((String)localArrayList.get(1));
      this.BPw = ((String)localArrayList.get(2));
    }
    for (;;)
    {
      this.mToken = paramString1.optString("token", paramString1.optString("purchaseToken"));
      this.bUS = paramString3;
      AppMethodBeat.o(71806);
      return;
      this.BPu = paramString2;
    }
  }
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.pbW = paramString1;
    this.BPu = paramString2;
    this.BPw = paramString3;
    this.BPx = paramString4;
  }
  
  private static ArrayList<String> azS(String paramString)
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
    String str = "PurchaseInfo(type:" + this.BPq + "):" + this.BPv;
    AppMethodBeat.o(71808);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.b.a.c
 * JD-Core Version:    0.7.0.1
 */