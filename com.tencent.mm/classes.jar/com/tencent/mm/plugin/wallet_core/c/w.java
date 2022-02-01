package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class w
  extends m
{
  public String DgG;
  private int scene;
  public String token;
  
  public w(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(69937);
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("req_key", paramString2);
    if (paramInt == 6) {
      localHashMap.put("time_stamp", System.currentTimeMillis());
    }
    setRequestData(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("check_pwd_scene", String.valueOf(paramInt));
    if (z.fVT())
    {
      paramString1.put("uuid_for_bindcard", z.getBindCardUuid());
      paramString1.put("bindcard_scene", z.fVU());
    }
    setWXRequestData(paramString1);
    this.scene = paramInt;
    AppMethodBeat.o(69937);
  }
  
  public final int getFuncId()
  {
    return 476;
  }
  
  public final int getTenpayCgicmd()
  {
    return 18;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/checkpwd";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69938);
    ae.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if ((this.scene == 6) || (this.scene == 8) || (this.scene == 18) || (this.scene == 1))
    {
      this.token = paramJSONObject.optString("usertoken");
      this.DgG = paramJSONObject.optString("token_type");
    }
    AppMethodBeat.o(69938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.w
 * JD-Core Version:    0.7.0.1
 */