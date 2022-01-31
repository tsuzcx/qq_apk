package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends a
{
  public String desc;
  public double kNS;
  public String qkd;
  public String qke;
  public int scene;
  public int timestamp;
  public String username;
  
  public d(String paramString)
  {
    AppMethodBeat.i(48531);
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_url", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(48531);
  }
  
  public final int cTa()
  {
    return 24;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48532);
    ab.d("MicroMsg.NetScenePayURemittanceGetUsername", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(48532);
      return;
    }
    this.username = paramJSONObject.optString("user_name");
    this.qkd = paramJSONObject.optString("true_name");
    this.kNS = (paramJSONObject.optDouble("fee") / 100.0D);
    this.desc = paramJSONObject.optString("desc");
    this.scene = paramJSONObject.optInt("scene");
    this.qke = paramJSONObject.optString("transfer_qrcode_id");
    this.timestamp = paramJSONObject.optInt("time_stamp");
    AppMethodBeat.o(48532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.a.d
 * JD-Core Version:    0.7.0.1
 */