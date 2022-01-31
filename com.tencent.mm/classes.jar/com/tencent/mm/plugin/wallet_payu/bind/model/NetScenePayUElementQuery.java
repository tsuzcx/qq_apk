package com.tencent.mm.plugin.wallet_payu.bind.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class NetScenePayUElementQuery
  extends a
{
  public String uBM;
  public NetScenePayUElementQuery.PayUBankcardElement uBO;
  
  public NetScenePayUElementQuery(String paramString)
  {
    AppMethodBeat.i(48335);
    this.uBM = paramString;
    HashMap localHashMap = new HashMap();
    localHashMap.put("card_number", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(48335);
  }
  
  public final int cTa()
  {
    return 22;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48336);
    this.uBO = new NetScenePayUElementQuery.PayUBankcardElement();
    this.uBO.uBP = paramJSONObject.optString("bin");
    this.uBO.ppn = paramJSONObject.optString("bank_name");
    this.uBO.uBQ = paramJSONObject.optString("issuer_type");
    this.uBO.cardType = paramJSONObject.optString("card_type");
    this.uBO.czq = paramJSONObject.optString("payu_reference");
    AppMethodBeat.o(48336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery
 * JD-Core Version:    0.7.0.1
 */