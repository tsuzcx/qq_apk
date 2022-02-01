package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class h
  extends m
{
  public String HTK;
  public String HTL;
  public String HTM;
  public String HTN;
  public int HTO;
  public long HTP;
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
    Log.i("MicroMsg.NetSceneRealnameGetDuty", "errCode=" + paramInt + ";errMsg=" + paramString);
    if ((paramInt == 0) && (paramJSONObject != null))
    {
      this.HTK = paramJSONObject.optString("agreed_flag", "0");
      this.title = paramJSONObject.optString("title", "");
      this.HTL = paramJSONObject.optString("service_protocol_wording", "");
      this.HTM = paramJSONObject.optString("service_protocol_url", "");
      this.HTN = paramJSONObject.optString("button_wording", "");
      this.HTP = paramJSONObject.optLong("delay_expired_time", 0L);
      if (this.HTP > 0L)
      {
        g.aAi();
        g.aAh().azQ().set(ar.a.NXr, Long.valueOf(System.currentTimeMillis() + this.HTP * 1000L));
      }
    }
    AppMethodBeat.o(70153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.h
 * JD-Core Version:    0.7.0.1
 */