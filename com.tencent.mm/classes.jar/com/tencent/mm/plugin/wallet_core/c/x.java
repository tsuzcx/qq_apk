package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.aa;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x
  extends m
{
  public String VxV;
  private int scene;
  public String token;
  
  public x(String paramString1, int paramInt, String paramString2)
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
    if (aa.jOO())
    {
      paramString1.put("uuid_for_bindcard", aa.getBindCardUuid());
      paramString1.put("bindcard_scene", aa.jOP());
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
    Log.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if ((this.scene == 6) || (this.scene == 8) || (this.scene == 18) || (this.scene == 1))
    {
      this.token = paramJSONObject.optString("usertoken");
      this.VxV = paramJSONObject.optString("token_type");
    }
    AppMethodBeat.o(69938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.x
 * JD-Core Version:    0.7.0.1
 */