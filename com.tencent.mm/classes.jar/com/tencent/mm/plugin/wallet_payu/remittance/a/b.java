package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends a
{
  public b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(72168);
    HashMap localHashMap = new HashMap();
    localHashMap.put("req_key", paramString1);
    localHashMap.put("total_fee", String.valueOf(paramInt));
    localHashMap.put("fee_type", paramString2);
    localHashMap.put("to_customer_name", paramString3);
    setRequestData(localHashMap);
    AppMethodBeat.o(72168);
  }
  
  public final int eqK()
  {
    return 16;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72169);
    ac.d("MicroMsg", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(72169);
      return;
    }
    AppMethodBeat.o(72169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.a.b
 * JD-Core Version:    0.7.0.1
 */