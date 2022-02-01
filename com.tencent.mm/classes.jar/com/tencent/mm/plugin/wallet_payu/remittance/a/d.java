package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends a
{
  public String desc;
  public double paV;
  public int paX;
  public int scene;
  public String username;
  public String xYR;
  public String xYS;
  
  public d(String paramString)
  {
    AppMethodBeat.i(72172);
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_url", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(72172);
  }
  
  public final int eEK()
  {
    return 24;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72173);
    ad.d("MicroMsg.NetScenePayURemittanceGetUsername", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(72173);
      return;
    }
    this.username = paramJSONObject.optString("user_name");
    this.xYR = paramJSONObject.optString("true_name");
    this.paV = (paramJSONObject.optDouble("fee") / 100.0D);
    this.desc = paramJSONObject.optString("desc");
    this.scene = paramJSONObject.optInt("scene");
    this.xYS = paramJSONObject.optString("transfer_qrcode_id");
    this.paX = paramJSONObject.optInt("time_stamp");
    AppMethodBeat.o(72173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.a.d
 * JD-Core Version:    0.7.0.1
 */