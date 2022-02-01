package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends m
{
  public static String ujT = "";
  public static String ukm = "";
  private int dcG;
  private String nTK;
  public int ujJ;
  public String ujK;
  public String ukn;
  public String uko;
  public String ukp;
  final Map<String, String> ukq;
  
  public n(String paramString, int paramInt)
  {
    AppMethodBeat.i(66310);
    this.dcG = -1;
    this.nTK = "";
    this.ujJ = -1;
    this.ujK = "";
    this.ukn = "";
    this.uko = "";
    this.ukp = "";
    this.ukq = new HashMap();
    this.ukq.put("device_id", q.Xa());
    this.ukq.put("timestamp", paramString);
    this.ukq.put("scene", String.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(q.Xa());
    localStringBuilder.append("&");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    this.ukq.put("sign", ai.du(paramString));
    paramString = this.ukq;
    localStringBuilder = new StringBuilder();
    g.afC();
    paramString.put("code_ver", g.afB().afk().get(ae.a.FfP, ""));
    setRequestData(this.ukq);
    AppMethodBeat.o(66310);
  }
  
  public final int getFuncId()
  {
    return 568;
  }
  
  public final int getTenpayCgicmd()
  {
    return 49;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlinequeryuser";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66311);
    if (paramJSONObject != null)
    {
      ujT = paramJSONObject.optString("limit_fee");
      ukm = paramJSONObject.optString("is_show_order_detail");
      paramString = paramJSONObject.optString("pay_amount");
      String str1 = paramJSONObject.optString("pay_number");
      String str2 = paramJSONObject.optString("card_logos");
      k.cYr();
      k.bp(196629, ujT);
      k.cYr();
      k.bp(196641, ukm);
      k.cYr();
      k.bp(196645, paramString);
      k.cYr();
      k.bp(196646, str1);
      a.ajP(str2);
      this.dcG = paramJSONObject.optInt("retcode");
      this.nTK = paramJSONObject.optString("retmsg");
      this.ujJ = paramJSONObject.optInt("wx_error_type");
      this.ujK = paramJSONObject.optString("wx_error_msg");
      this.ukn = paramJSONObject.optString("get_code_flag");
      this.uko = paramJSONObject.optString("micropay_pause_flag");
      this.ukp = paramJSONObject.optString("micropay_pause_word");
    }
    AppMethodBeat.o(66311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.n
 * JD-Core Version:    0.7.0.1
 */