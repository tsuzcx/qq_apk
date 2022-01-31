package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class t
  extends j
{
  public t(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("receiver_user_name", paramString1);
    localHashMap.put("transfer_qrcode_id", paramString2);
    D(localHashMap);
  }
  
  public t(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("receiver_user_name", paramString1);
    localHashMap.put("transfer_qrcode_id", paramString2);
    localHashMap.put("rcvr_ticket", paramString3);
    localHashMap.put("receiver_openid", paramString4);
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1535;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("MicroMsg.NetSenceTenPayBase", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0) {}
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/transfersendcancelf2f";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.t
 * JD-Core Version:    0.7.0.1
 */