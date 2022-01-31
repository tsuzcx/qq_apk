package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends m
{
  public a(int paramInt)
  {
    AppMethodBeat.i(46634);
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(46634);
  }
  
  public final int getFuncId()
  {
    return 1584;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1584;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/realnamesetduty";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46635);
    ab.i("MicroMsg.NetSceneAgreeDisclaimer", "errCode = " + paramInt + ";errMsg = " + paramString);
    AppMethodBeat.o(46635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.a
 * JD-Core Version:    0.7.0.1
 */