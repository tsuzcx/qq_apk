package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.tenpay.model.j;
import org.json.JSONObject;

public final class e
  extends j
{
  public String qsh;
  public String qsi;
  public String qsj;
  public String qsk;
  public int qsl;
  public long qsm;
  public String title;
  
  public final int HH()
  {
    return 1614;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneRealnameGetDuty", "errCode=" + paramInt + ";errMsg=" + paramString);
    if ((paramInt == 0) && (paramJSONObject != null))
    {
      this.qsh = paramJSONObject.optString("agreed_flag", "0");
      this.title = paramJSONObject.optString("title", "");
      this.qsi = paramJSONObject.optString("service_protocol_wording", "");
      this.qsj = paramJSONObject.optString("service_protocol_url", "");
      this.qsk = paramJSONObject.optString("button_wording", "");
      this.qsm = paramJSONObject.optLong("delay_expired_time", 0L);
      if (this.qsm > 0L)
      {
        g.DQ();
        g.DP().Dz().c(ac.a.usp, Long.valueOf(System.currentTimeMillis() + this.qsm * 1000L));
      }
    }
  }
  
  public final int aEC()
  {
    return 1614;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/realnamegetduty";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.e
 * JD-Core Version:    0.7.0.1
 */