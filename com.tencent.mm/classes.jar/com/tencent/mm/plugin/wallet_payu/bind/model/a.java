package com.tencent.mm.plugin.wallet_payu.bind.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.wallet_core.d.a.a
{
  public String Wcu;
  public String Wcv;
  public String Wcw;
  public String Wcx;
  public String Wcy;
  public String Wcz;
  public String description;
  public String igz;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(71973);
    this.Wcu = paramString1;
    this.Wcv = paramString2;
    this.igz = paramString3;
    this.Wcw = paramString4;
    this.Wcx = paramString5;
    this.description = paramString6;
    this.Wcy = paramString7;
    this.Wcz = paramString8;
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
  
  public final int ihO()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.a
 * JD-Core Version:    0.7.0.1
 */