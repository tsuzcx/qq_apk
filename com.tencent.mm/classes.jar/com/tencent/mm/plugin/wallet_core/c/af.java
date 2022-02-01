package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class af
  extends m
{
  public String DgU;
  public JSONObject kuc;
  
  public af(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
  {
    AppMethodBeat.i(69957);
    this.DgU = "";
    this.DgU = paramString1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("activity_id", paramString1);
    localHashMap.put("award_id", paramString2);
    localHashMap.put("send_record_id", paramString3);
    localHashMap.put("user_record_id", paramString4);
    localHashMap.put("req_key", paramString5);
    localHashMap.put("transaction_id", paramString6);
    localHashMap.put("activity_mch_id", String.valueOf(paramLong));
    setRequestData(localHashMap);
    AppMethodBeat.o(69957);
  }
  
  public final int getFuncId()
  {
    return 1979;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1979;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/querypayaward";
  }
  
  public final boolean isBlock()
  {
    return false;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69958);
    ae.i("MicroMsg.NetSceneTenpayQueryPayaward", "errcode %s errmsg %s json %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
    this.kuc = paramJSONObject;
    AppMethodBeat.o(69958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.af
 * JD-Core Version:    0.7.0.1
 */