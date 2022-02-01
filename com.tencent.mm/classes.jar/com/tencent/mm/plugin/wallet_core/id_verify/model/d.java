package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends m
{
  public d(int paramInt)
  {
    AppMethodBeat.i(70138);
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt));
    setRequestData(localHashMap);
    AppMethodBeat.o(70138);
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
    AppMethodBeat.i(70139);
    Log.i("MicroMsg.NetSceneAgreeDisclaimer", "errCode = " + paramInt + ";errMsg = " + paramString);
    AppMethodBeat.o(70139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.d
 * JD-Core Version:    0.7.0.1
 */