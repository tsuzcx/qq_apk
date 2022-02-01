package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class h
  extends m
{
  public String Dkr;
  public String Dks;
  public String Dkt;
  public String Dku;
  public int Dkv;
  public long Dkw;
  public String title;
  
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
    AppMethodBeat.i(70153);
    ae.i("MicroMsg.NetSceneRealnameGetDuty", "errCode=" + paramInt + ";errMsg=" + paramString);
    if ((paramInt == 0) && (paramJSONObject != null))
    {
      this.Dkr = paramJSONObject.optString("agreed_flag", "0");
      this.title = paramJSONObject.optString("title", "");
      this.Dks = paramJSONObject.optString("service_protocol_wording", "");
      this.Dkt = paramJSONObject.optString("service_protocol_url", "");
      this.Dku = paramJSONObject.optString("button_wording", "");
      this.Dkw = paramJSONObject.optLong("delay_expired_time", 0L);
      if (this.Dkw > 0L)
      {
        g.ajS();
        g.ajR().ajA().set(am.a.IPq, Long.valueOf(System.currentTimeMillis() + this.Dkw * 1000L));
      }
    }
    AppMethodBeat.o(70153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.h
 * JD-Core Version:    0.7.0.1
 */