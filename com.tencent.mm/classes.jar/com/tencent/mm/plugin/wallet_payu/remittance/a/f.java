package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends a
{
  public f(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(72176);
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString1);
    localHashMap.put("total_fee", String.valueOf(paramInt1));
    localHashMap.put("fee_type", paramString2);
    localHashMap.put("receiver_name", paramString3);
    localHashMap.put("invalid_time", String.valueOf(paramInt2));
    setRequestData(localHashMap);
    AppMethodBeat.o(72176);
  }
  
  public final int fPU()
  {
    return 26;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72177);
    Log.d("MicroMsg.NetScenePayURemitttanceRetry", "errCode " + paramInt + " errMsg: " + paramString);
    AppMethodBeat.o(72177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.a.f
 * JD-Core Version:    0.7.0.1
 */