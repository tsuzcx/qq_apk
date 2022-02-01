package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a
{
  public c(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(72170);
    HashMap localHashMap = new HashMap();
    localHashMap.put("req_key", paramString1);
    localHashMap.put("total_fee", String.valueOf(paramInt));
    localHashMap.put("fee_type", paramString2);
    localHashMap.put("to_customer_name", paramString3);
    setRequestData(localHashMap);
    AppMethodBeat.o(72170);
  }
  
  public final int eEK()
  {
    return 15;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72171);
    ad.d("MicroMsg.NetScenePayURemittanceConfirm", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(72171);
      return;
    }
    AppMethodBeat.o(72171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.a.c
 * JD-Core Version:    0.7.0.1
 */