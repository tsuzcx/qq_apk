package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class j
  extends m
{
  public j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69551);
    HashMap localHashMap = new HashMap();
    localHashMap.put("auth_token", paramString1);
    localHashMap.put("passwd", String.valueOf(paramString2));
    localHashMap.put("timestamp", System.currentTimeMillis());
    setRequestData(localHashMap);
    AppMethodBeat.o(69551);
  }
  
  public final int getFuncId()
  {
    return 2514;
  }
  
  public final int getTenpayCgicmd()
  {
    return 2514;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/resetpaypwdbyface";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69552);
    ad.i("MicroMsg.NetSceneResetPayPwdByFace", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", new Object[] { Integer.valueOf(paramInt), paramString, paramJSONObject });
    if (paramInt == 0)
    {
      paramJSONObject.optString("retcode");
      paramJSONObject.optString("retmsg");
    }
    AppMethodBeat.o(69552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.j
 * JD-Core Version:    0.7.0.1
 */