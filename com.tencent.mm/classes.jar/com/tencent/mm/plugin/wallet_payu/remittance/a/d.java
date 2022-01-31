package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends a
{
  public String desc;
  public double iHP;
  public String nzb;
  public String nzc;
  public int scene;
  public int timestamp;
  public String username;
  
  public d(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_url", paramString);
    D(localHashMap);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.d("MicroMsg.NetScenePayURemittanceGetUsername", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0) {
      return;
    }
    this.username = paramJSONObject.optString("user_name");
    this.nzb = paramJSONObject.optString("true_name");
    this.iHP = (paramJSONObject.optDouble("fee") / 100.0D);
    this.desc = paramJSONObject.optString("desc");
    this.scene = paramJSONObject.optInt("scene");
    this.nzc = paramJSONObject.optString("transfer_qrcode_id");
    this.timestamp = paramJSONObject.optInt("time_stamp");
  }
  
  public final int bUM()
  {
    return 24;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.a.d
 * JD-Core Version:    0.7.0.1
 */