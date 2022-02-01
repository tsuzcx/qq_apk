package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class y
  extends m
{
  public String Vww;
  public int VxW;
  public String VxX;
  public String VxY;
  
  public y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69939);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString1);
    localHashMap.put("use_touch", "1");
    setRequestData(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("soter_req", paramString2);
    setWXRequestData(paramString1);
    AppMethodBeat.o(69939);
  }
  
  public y(String paramString1, String paramString2, byte paramByte)
  {
    AppMethodBeat.i(69940);
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("token", paramString2);
    setRequestData(localHashMap);
    setWXRequestData(new HashMap());
    AppMethodBeat.o(69940);
  }
  
  public y(String paramString1, String paramString2, char paramChar)
  {
    AppMethodBeat.i(69941);
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("token", paramString2);
    localHashMap.put("resend", "1");
    setRequestData(localHashMap);
    setWXRequestData(new HashMap());
    AppMethodBeat.o(69941);
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
  
  public final boolean ihL()
  {
    return this.VxW == 0;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69942);
    Log.d("Micromsg.NetSceneTenpayCheckPwdByToken", "errCode " + paramInt + " errMsg: " + paramString);
    this.Vww = paramJSONObject.optString("usertoken");
    this.VxW = paramJSONObject.optInt("is_free_sms");
    this.VxX = paramJSONObject.optString("mobile_no");
    this.VxY = paramJSONObject.optString("relation_key");
    AppMethodBeat.o(69942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.y
 * JD-Core Version:    0.7.0.1
 */