package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import org.json.JSONObject;

public final class c
{
  String AwW;
  public String AwX;
  long AwY;
  int AwZ;
  public String Axa;
  public String Axb;
  public String Axc;
  public String Axd;
  public String bXk;
  String mPackageName;
  public String mToken;
  public String oyw;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(71806);
    this.AwW = paramString1;
    this.Axb = paramString2;
    paramString1 = new JSONObject(this.Axb);
    this.AwX = paramString1.optString("orderId");
    this.mPackageName = paramString1.optString("packageName");
    this.oyw = paramString1.optString("productId");
    this.AwY = paramString1.optLong("purchaseTime");
    this.AwZ = paramString1.optInt("purchaseState");
    paramString2 = paramString1.optString("developerPayload");
    ArrayList localArrayList = auB(paramString2);
    if (localArrayList.size() == 3)
    {
      this.Axa = ((String)localArrayList.get(0));
      this.Axd = ((String)localArrayList.get(1));
      this.Axc = ((String)localArrayList.get(2));
    }
    for (;;)
    {
      this.mToken = paramString1.optString("token", paramString1.optString("purchaseToken"));
      this.bXk = paramString3;
      AppMethodBeat.o(71806);
      return;
      this.Axa = paramString2;
    }
  }
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.oyw = paramString1;
    this.Axa = paramString2;
    this.Axc = paramString3;
    this.Axd = paramString4;
  }
  
  private static ArrayList<String> auB(String paramString)
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
    String str = "PurchaseInfo(type:" + this.AwW + "):" + this.Axb;
    AppMethodBeat.o(71808);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.b.a.c
 * JD-Core Version:    0.7.0.1
 */