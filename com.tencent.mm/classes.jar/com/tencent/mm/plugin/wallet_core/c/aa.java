package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aa
  extends j
{
  public JSONObject gff;
  public String qrd = "";
  
  public aa(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
  {
    this.qrd = paramString1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("activity_id", paramString1);
    localHashMap.put("award_id", paramString2);
    localHashMap.put("send_record_id", paramString3);
    localHashMap.put("user_record_id", paramString4);
    localHashMap.put("req_key", paramString5);
    localHashMap.put("transaction_id", paramString6);
    localHashMap.put("activity_mch_id", String.valueOf(paramLong));
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1979;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneTenpayQueryPayaward", "errcode %s errmsg %s json %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
    this.gff = paramJSONObject;
  }
  
  public final int aEC()
  {
    return 1979;
  }
  
  public final boolean bqd()
  {
    return false;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/querypayaward";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.aa
 * JD-Core Version:    0.7.0.1
 */