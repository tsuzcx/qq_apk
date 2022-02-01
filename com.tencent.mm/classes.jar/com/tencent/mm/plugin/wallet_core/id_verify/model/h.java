package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class h
  extends m
{
  public int BsA;
  public long BsB;
  public String Bsw;
  public String Bsx;
  public String Bsy;
  public String Bsz;
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
    ac.i("MicroMsg.NetSceneRealnameGetDuty", "errCode=" + paramInt + ";errMsg=" + paramString);
    if ((paramInt == 0) && (paramJSONObject != null))
    {
      this.Bsw = paramJSONObject.optString("agreed_flag", "0");
      this.title = paramJSONObject.optString("title", "");
      this.Bsx = paramJSONObject.optString("service_protocol_wording", "");
      this.Bsy = paramJSONObject.optString("service_protocol_url", "");
      this.Bsz = paramJSONObject.optString("button_wording", "");
      this.BsB = paramJSONObject.optLong("delay_expired_time", 0L);
      if (this.BsB > 0L)
      {
        g.agS();
        g.agR().agA().set(ah.a.GIA, Long.valueOf(System.currentTimeMillis() + this.BsB * 1000L));
      }
    }
    AppMethodBeat.o(70153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.h
 * JD-Core Version:    0.7.0.1
 */