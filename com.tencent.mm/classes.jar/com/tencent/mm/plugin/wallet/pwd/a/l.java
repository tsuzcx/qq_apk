package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class l
  extends m
{
  public l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69557);
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("new_passwd", paramString2);
    localHashMap.put("new_rpasswd", paramString2);
    setRequestData(localHashMap);
    AppMethodBeat.o(69557);
  }
  
  public final int getFuncId()
  {
    return 468;
  }
  
  public final int getTenpayCgicmd()
  {
    return 9;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/changepwd";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69558);
    ad.d("Micromsg.NetSceneTenpayChangePwd", "errCode " + paramInt + " errMsg: " + paramString);
    AppMethodBeat.o(69558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.l
 * JD-Core Version:    0.7.0.1
 */