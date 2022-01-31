package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class t
  extends m
{
  public t(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44767);
    HashMap localHashMap = new HashMap();
    localHashMap.put("receiver_user_name", paramString1);
    localHashMap.put("transfer_qrcode_id", paramString2);
    setRequestData(localHashMap);
    AppMethodBeat.o(44767);
  }
  
  public t(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(44768);
    HashMap localHashMap = new HashMap();
    localHashMap.put("receiver_user_name", paramString1);
    localHashMap.put("transfer_qrcode_id", paramString2);
    localHashMap.put("rcvr_ticket", paramString3);
    localHashMap.put("receiver_openid", paramString4);
    setRequestData(localHashMap);
    AppMethodBeat.o(44768);
  }
  
  public final int getFuncId()
  {
    return 1535;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/transfersendcancelf2f";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(44769);
    ab.d("MicroMsg.NetSenceTenPayBase", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(44769);
      return;
    }
    AppMethodBeat.o(44769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.t
 * JD-Core Version:    0.7.0.1
 */