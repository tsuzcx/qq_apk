package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import org.json.JSONObject;

public final class c
{
  String Pjj;
  public String Pjk;
  long Pjl;
  int Pjm;
  public String Pjn;
  public String Pjo;
  public String Pjp;
  public String mOriginalJson;
  String mPackageName;
  public String mSignature;
  public String mToken;
  public String uFI;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(71806);
    this.Pjj = paramString1;
    this.mOriginalJson = paramString2;
    paramString1 = new JSONObject(this.mOriginalJson);
    this.Pjk = paramString1.optString("orderId");
    this.mPackageName = paramString1.optString("packageName");
    this.uFI = paramString1.optString("productId");
    this.Pjl = paramString1.optLong("purchaseTime");
    this.Pjm = paramString1.optInt("purchaseState");
    paramString2 = paramString1.optString("developerPayload");
    ArrayList localArrayList = bhH(paramString2);
    if (localArrayList.size() == 3)
    {
      this.Pjn = ((String)localArrayList.get(0));
      this.Pjp = ((String)localArrayList.get(1));
      this.Pjo = ((String)localArrayList.get(2));
    }
    for (;;)
    {
      this.mToken = paramString1.optString("token", paramString1.optString("purchaseToken"));
      this.mSignature = paramString3;
      AppMethodBeat.o(71806);
      return;
      this.Pjn = paramString2;
    }
  }
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.uFI = paramString1;
    this.Pjn = paramString2;
    this.Pjo = paramString3;
    this.Pjp = paramString4;
  }
  
  private static ArrayList<String> bhH(String paramString)
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
    String str = "PurchaseInfo(type:" + this.Pjj + "):" + this.mOriginalJson;
    AppMethodBeat.o(71808);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.b.a.c
 * JD-Core Version:    0.7.0.1
 */