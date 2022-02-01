package com.tencent.mm.plugin.wallet_payu.bind.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.e.a.a
{
  public String AiX;
  public String AyH;
  public String AyR;
  public String AyS;
  public String AyT;
  public String dCQ;
  public String description;
  public String pin;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(71973);
    this.AyR = paramString1;
    this.AiX = paramString2;
    this.dCQ = paramString3;
    this.AyS = paramString4;
    this.AyT = paramString5;
    this.description = paramString6;
    this.AyH = paramString7;
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
    setRequestData(localHashMap);
    AppMethodBeat.o(71973);
  }
  
  public final int ebo()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.a
 * JD-Core Version:    0.7.0.1
 */