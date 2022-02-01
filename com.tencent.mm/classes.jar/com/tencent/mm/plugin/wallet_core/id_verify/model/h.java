package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class h
  extends m
{
  public String CSL;
  public String CSM;
  public String CSN;
  public String CSO;
  public int CSP;
  public long CSQ;
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
      this.CSL = paramJSONObject.optString("agreed_flag", "0");
      this.title = paramJSONObject.optString("title", "");
      this.CSM = paramJSONObject.optString("service_protocol_wording", "");
      this.CSN = paramJSONObject.optString("service_protocol_url", "");
      this.CSO = paramJSONObject.optString("button_wording", "");
      this.CSQ = paramJSONObject.optLong("delay_expired_time", 0L);
      if (this.CSQ > 0L)
      {
        g.ajD();
        g.ajC().ajl().set(al.a.IuS, Long.valueOf(System.currentTimeMillis() + this.CSQ * 1000L));
      }
    }
    AppMethodBeat.o(70153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.h
 * JD-Core Version:    0.7.0.1
 */