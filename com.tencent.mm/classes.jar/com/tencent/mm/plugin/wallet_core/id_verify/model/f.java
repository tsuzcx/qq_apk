package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends m
{
  public int OHJ;
  public String cpm;
  public String desc;
  public String title;
  
  public f(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, RealNameBundle paramRealNameBundle)
  {
    AppMethodBeat.i(174504);
    HashMap localHashMap = new HashMap();
    localHashMap.put("flag", "1");
    localHashMap.put("passwd", paramString1);
    localHashMap.put("token", paramString2);
    localHashMap.put("face_token", paramString3);
    localHashMap.put("realname_scene", String.valueOf(paramInt));
    localHashMap.put("session_id", paramString4);
    Log.i("MicroMsg.NetSceneRealNameReg", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramRealNameBundle != null) {
      paramRealNameBundle.aS(localHashMap);
    }
    setRequestData(localHashMap);
    AppMethodBeat.o(174504);
  }
  
  public final int getFuncId()
  {
    return 1648;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1648;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/realnamereg";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70144);
    Log.i("MicroMsg.NetSceneRealNameReg", "errCode=" + paramString + ";errMsg=" + paramString);
    this.title = paramJSONObject.optString("title");
    this.desc = paramJSONObject.optString("desc");
    this.cpm = paramJSONObject.optString("page");
    this.OHJ = paramJSONObject.optInt("err_jump_page");
    AppMethodBeat.o(70144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.f
 * JD-Core Version:    0.7.0.1
 */