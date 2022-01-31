package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class z
  extends m
{
  public String ubZ;
  
  public z(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(46542);
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("check_pwd_scene", String.valueOf(paramInt));
    localHashMap.put("package", URLEncoder.encode(paramString2));
    localHashMap.put("sign", paramString3);
    localHashMap.put("sign_type", paramString4);
    localHashMap.put("busi_id", paramString5);
    setRequestData(localHashMap);
    AppMethodBeat.o(46542);
  }
  
  public z(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7)
  {
    AppMethodBeat.i(46543);
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("check_pwd_scene", String.valueOf(paramInt1));
    localHashMap.put("package", URLEncoder.encode(paramString2));
    localHashMap.put("sign", paramString3);
    localHashMap.put("sign_type", paramString4);
    localHashMap.put("busi_id", paramString5);
    localHashMap.put("use_touch", String.valueOf(paramInt2));
    setRequestData(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("soter_req", paramString6);
    paramString1.put("fingerData", paramString7);
    setWXRequestData(paramString1);
    AppMethodBeat.o(46543);
  }
  
  public final boolean callbackUIWhenWalletError()
  {
    return true;
  }
  
  public final int getFuncId()
  {
    return 2704;
  }
  
  public final int getTenpayCgicmd()
  {
    return 2704;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/getpaypwdtoken";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46544);
    this.ubZ = paramJSONObject.optString("usertoken", "");
    AppMethodBeat.o(46544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.z
 * JD-Core Version:    0.7.0.1
 */