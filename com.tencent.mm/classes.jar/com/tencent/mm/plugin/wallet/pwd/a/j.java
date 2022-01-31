package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j
  extends m
{
  public j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46182);
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("new_passwd", paramString2);
    localHashMap.put("new_rpasswd", paramString2);
    setRequestData(localHashMap);
    AppMethodBeat.o(46182);
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
    AppMethodBeat.i(46183);
    ab.d("Micromsg.NetSceneTenpayChangePwd", "errCode " + paramInt + " errMsg: " + paramString);
    AppMethodBeat.o(46183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.j
 * JD-Core Version:    0.7.0.1
 */