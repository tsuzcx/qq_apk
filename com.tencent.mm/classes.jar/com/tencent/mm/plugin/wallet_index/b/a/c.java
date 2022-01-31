package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import org.json.JSONObject;

public final class c
{
  public String liu;
  String mPackageName;
  public String mSignature;
  public String mToken;
  public String uAa;
  public String uAb;
  String uzU;
  public String uzV;
  long uzW;
  int uzX;
  public String uzY;
  public String uzZ;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(48171);
    this.uzU = paramString1;
    this.uzZ = paramString2;
    paramString1 = new JSONObject(this.uzZ);
    this.uzV = paramString1.optString("orderId");
    this.mPackageName = paramString1.optString("packageName");
    this.liu = paramString1.optString("productId");
    this.uzW = paramString1.optLong("purchaseTime");
    this.uzX = paramString1.optInt("purchaseState");
    paramString2 = paramString1.optString("developerPayload");
    ArrayList localArrayList = afR(paramString2);
    if (localArrayList.size() == 3)
    {
      this.uzY = ((String)localArrayList.get(0));
      this.uAb = ((String)localArrayList.get(1));
      this.uAa = ((String)localArrayList.get(2));
    }
    for (;;)
    {
      this.mToken = paramString1.optString("token", paramString1.optString("purchaseToken"));
      this.mSignature = paramString3;
      AppMethodBeat.o(48171);
      return;
      this.uzY = paramString2;
    }
  }
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.liu = paramString1;
    this.uzY = paramString2;
    this.uAa = paramString3;
    this.uAb = paramString4;
  }
  
  private static ArrayList<String> afR(String paramString)
  {
    AppMethodBeat.i(48172);
    ArrayList localArrayList = new ArrayList();
    while (paramString.indexOf("[#]") >= 0)
    {
      String str = paramString.substring(0, paramString.indexOf("[#]"));
      paramString = paramString.substring(str.length() + 3);
      localArrayList.add(str);
    }
    localArrayList.add(paramString);
    AppMethodBeat.o(48172);
    return localArrayList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48173);
    String str = "PurchaseInfo(type:" + this.uzU + "):" + this.uzZ;
    AppMethodBeat.o(48173);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.b.a.c
 * JD-Core Version:    0.7.0.1
 */