package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x
  extends j
{
  public JSONObject gff;
  public String qrd = "";
  
  public x(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, String paramString6, int paramInt1, int paramInt2)
  {
    this.qrd = paramString1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("activity_id", paramString1);
    localHashMap.put("award_id", paramString2);
    localHashMap.put("send_record_id", paramString3);
    localHashMap.put("user_record_id", paramString4);
    localHashMap.put("activity_mch_id", String.valueOf(paramLong1));
    localHashMap.put("activity_type", String.valueOf(paramLong2));
    localHashMap.put("bank_type", paramString5);
    localHashMap.put("bank_serial", paramString6);
    localHashMap.put("bindbankscene", String.valueOf(paramInt1));
    localHashMap.put("realname_scene", String.valueOf(paramInt2));
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1773;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneTenpayQueryBindPayaward", "errcode %s errmsg %s json %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
    this.gff = paramJSONObject;
  }
  
  public final int aEC()
  {
    return 1773;
  }
  
  public final boolean bqd()
  {
    return false;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/querybindcardaward";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.x
 * JD-Core Version:    0.7.0.1
 */