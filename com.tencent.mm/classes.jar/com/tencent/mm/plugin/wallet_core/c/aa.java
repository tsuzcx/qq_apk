package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aa
  extends m
{
  public JSONObject hxd;
  public String uca;
  
  public aa(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, String paramString6, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46545);
    this.uca = "";
    this.uca = paramString1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("activity_id", paramString1);
    localHashMap.put("award_id", paramString2);
    localHashMap.put("send_record_id", paramString3);
    localHashMap.put("user_record_id", paramString4);
    localHashMap.put("activity_mch_id", String.valueOf(paramLong1));
    localHashMap.put("activity_type", String.valueOf(paramLong2));
    localHashMap.put("bank_type", String.valueOf(paramString5));
    localHashMap.put("bank_serial", String.valueOf(paramString6));
    localHashMap.put("bindbankscene", String.valueOf(paramInt1));
    localHashMap.put("realname_scene", String.valueOf(paramInt2));
    setRequestData(localHashMap);
    AppMethodBeat.o(46545);
  }
  
  public final int getFuncId()
  {
    return 1773;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1773;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/querybindcardaward";
  }
  
  public final boolean isBlock()
  {
    return false;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46546);
    ab.i("MicroMsg.NetSceneTenpayQueryBindPayaward", "errcode %s errmsg %s json %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
    this.hxd = paramJSONObject;
    AppMethodBeat.o(46546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.aa
 * JD-Core Version:    0.7.0.1
 */