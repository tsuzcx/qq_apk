package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class z
  extends m
{
  public z(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67897);
    HashMap localHashMap = new HashMap();
    localHashMap.put("trans_id", paramString1);
    localHashMap.put("transfer_id", paramString2);
    localHashMap.put("receiver_name", paramString3);
    localHashMap.put("from", String.valueOf(paramInt2));
    localHashMap.put("invalid_time", String.valueOf(paramInt1));
    setRequestData(localHashMap);
    AppMethodBeat.o(67897);
  }
  
  public final int getFuncId()
  {
    return 1545;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/transferresendmsg";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67898);
    ac.d("Micromsg.NetSceneTenpayRemittanceResendMsg", "errCode " + paramInt + " errMsg: " + paramString);
    AppMethodBeat.o(67898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.z
 * JD-Core Version:    0.7.0.1
 */