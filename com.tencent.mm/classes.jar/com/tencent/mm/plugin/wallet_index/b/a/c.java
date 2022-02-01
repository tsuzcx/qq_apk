package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import org.json.JSONObject;

public final class c
{
  String DpI;
  public String DpJ;
  long DpK;
  int DpL;
  public String DpM;
  public String DpN;
  public String DpO;
  public String DpP;
  public String cff;
  String mPackageName;
  public String mToken;
  public String pFG;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(71806);
    this.DpI = paramString1;
    this.DpN = paramString2;
    paramString1 = new JSONObject(this.DpN);
    this.DpJ = paramString1.optString("orderId");
    this.mPackageName = paramString1.optString("packageName");
    this.pFG = paramString1.optString("productId");
    this.DpK = paramString1.optLong("purchaseTime");
    this.DpL = paramString1.optInt("purchaseState");
    paramString2 = paramString1.optString("developerPayload");
    ArrayList localArrayList = aFc(paramString2);
    if (localArrayList.size() == 3)
    {
      this.DpM = ((String)localArrayList.get(0));
      this.DpP = ((String)localArrayList.get(1));
      this.DpO = ((String)localArrayList.get(2));
    }
    for (;;)
    {
      this.mToken = paramString1.optString("token", paramString1.optString("purchaseToken"));
      this.cff = paramString3;
      AppMethodBeat.o(71806);
      return;
      this.DpM = paramString2;
    }
  }
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.pFG = paramString1;
    this.DpM = paramString2;
    this.DpO = paramString3;
    this.DpP = paramString4;
  }
  
  private static ArrayList<String> aFc(String paramString)
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
    String str = "PurchaseInfo(type:" + this.DpI + "):" + this.DpN;
    AppMethodBeat.o(71808);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.b.a.c
 * JD-Core Version:    0.7.0.1
 */