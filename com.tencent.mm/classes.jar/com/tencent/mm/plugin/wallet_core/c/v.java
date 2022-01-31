package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class v
  extends m
{
  public String ubO;
  public int ubP;
  public String ubQ;
  public String ubR;
  
  public v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46534);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString1);
    localHashMap.put("use_touch", "1");
    setRequestData(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("soter_req", paramString2);
    setWXRequestData(paramString1);
    AppMethodBeat.o(46534);
  }
  
  public v(String paramString1, String paramString2, byte paramByte)
  {
    AppMethodBeat.i(46535);
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("token", paramString2);
    setRequestData(localHashMap);
    setWXRequestData(new HashMap());
    AppMethodBeat.o(46535);
  }
  
  public v(String paramString1, String paramString2, char paramChar)
  {
    AppMethodBeat.i(46536);
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("token", paramString2);
    localHashMap.put("resend", "1");
    setRequestData(localHashMap);
    setWXRequestData(new HashMap());
    AppMethodBeat.o(46536);
  }
  
  public final boolean cSX()
  {
    return this.ubP == 0;
  }
  
  public final int getFuncId()
  {
    return 1515;
  }
  
  public final int getTenpayCgicmd()
  {
    return 100;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/getusertoken";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46537);
    ab.d("Micromsg.NetSceneTenpayCheckPwdByToken", "errCode " + paramInt + " errMsg: " + paramString);
    this.ubO = paramJSONObject.optString("usertoken");
    this.ubP = paramJSONObject.optInt("is_free_sms");
    this.ubQ = paramJSONObject.optString("mobile_no");
    this.ubR = paramJSONObject.optString("relation_key");
    AppMethodBeat.o(46537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.v
 * JD-Core Version:    0.7.0.1
 */