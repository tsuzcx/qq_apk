package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class e
  extends m
{
  public String title;
  public String uef;
  public String ueg;
  public String ueh;
  public String uei;
  public int uej;
  public long uek;
  
  public final int getFuncId()
  {
    return 1614;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1614;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/realnamegetduty";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46647);
    ab.i("MicroMsg.NetSceneRealnameGetDuty", "errCode=" + paramInt + ";errMsg=" + paramString);
    if ((paramInt == 0) && (paramJSONObject != null))
    {
      this.uef = paramJSONObject.optString("agreed_flag", "0");
      this.title = paramJSONObject.optString("title", "");
      this.ueg = paramJSONObject.optString("service_protocol_wording", "");
      this.ueh = paramJSONObject.optString("service_protocol_url", "");
      this.uei = paramJSONObject.optString("button_wording", "");
      this.uek = paramJSONObject.optLong("delay_expired_time", 0L);
      if (this.uek > 0L)
      {
        g.RM();
        g.RL().Ru().set(ac.a.yCp, Long.valueOf(System.currentTimeMillis() + this.uek * 1000L));
      }
    }
    AppMethodBeat.o(46647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.e
 * JD-Core Version:    0.7.0.1
 */