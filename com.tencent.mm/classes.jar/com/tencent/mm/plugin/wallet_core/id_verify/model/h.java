package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class h
  extends m
{
  public String Aac;
  public String Aad;
  public String Aae;
  public String Aaf;
  public int Aag;
  public long Aah;
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
    ad.i("MicroMsg.NetSceneRealnameGetDuty", "errCode=" + paramInt + ";errMsg=" + paramString);
    if ((paramInt == 0) && (paramJSONObject != null))
    {
      this.Aac = paramJSONObject.optString("agreed_flag", "0");
      this.title = paramJSONObject.optString("title", "");
      this.Aad = paramJSONObject.optString("service_protocol_wording", "");
      this.Aae = paramJSONObject.optString("service_protocol_url", "");
      this.Aaf = paramJSONObject.optString("button_wording", "");
      this.Aah = paramJSONObject.optLong("delay_expired_time", 0L);
      if (this.Aah > 0L)
      {
        g.afC();
        g.afB().afk().set(ae.a.FkL, Long.valueOf(System.currentTimeMillis() + this.Aah * 1000L));
      }
    }
    AppMethodBeat.o(70153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.h
 * JD-Core Version:    0.7.0.1
 */