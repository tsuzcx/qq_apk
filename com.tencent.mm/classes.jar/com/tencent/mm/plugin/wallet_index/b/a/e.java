package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import org.json.JSONObject;

public final class e
{
  String Wab;
  public String Wac;
  long Wad;
  int Wae;
  public String Waf;
  public String Wag;
  public String Wah;
  public String mOriginalJson;
  String mPackageName;
  public String mSignature;
  public String mToken;
  public String xOk;
  
  public e(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(71806);
    this.Wab = paramString1;
    this.mOriginalJson = paramString2;
    paramString1 = new JSONObject(this.mOriginalJson);
    this.Wac = paramString1.optString("orderId");
    this.mPackageName = paramString1.optString("packageName");
    this.xOk = paramString1.optString("productId");
    this.Wad = paramString1.optLong("purchaseTime");
    this.Wae = paramString1.optInt("purchaseState");
    paramString2 = paramString1.optString("developerPayload");
    ArrayList localArrayList = bhq(paramString2);
    if (localArrayList.size() == 3)
    {
      this.Waf = ((String)localArrayList.get(0));
      this.Wah = ((String)localArrayList.get(1));
      this.Wag = ((String)localArrayList.get(2));
    }
    for (;;)
    {
      this.mToken = paramString1.optString("token", paramString1.optString("purchaseToken"));
      this.mSignature = paramString3;
      AppMethodBeat.o(71806);
      return;
      this.Waf = paramString2;
    }
  }
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.xOk = paramString1;
    this.Waf = paramString2;
    this.Wag = paramString3;
    this.Wah = paramString4;
  }
  
  private static ArrayList<String> bhq(String paramString)
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
    String str = "PurchaseInfo(type:" + this.Wab + "):" + this.mOriginalJson;
    AppMethodBeat.o(71808);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.b.a.e
 * JD-Core Version:    0.7.0.1
 */