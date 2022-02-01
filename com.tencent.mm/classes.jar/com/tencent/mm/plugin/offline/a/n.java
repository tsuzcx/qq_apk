package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends m
{
  public static String wNS = "";
  public static String wOl = "";
  private int dmy;
  private String phe;
  public int wNI;
  public String wNJ;
  public String wOm;
  public String wOn;
  public String wOo;
  final Map<String, String> wOp;
  
  public n(String paramString, int paramInt)
  {
    AppMethodBeat.i(66310);
    this.dmy = -1;
    this.phe = "";
    this.wNI = -1;
    this.wNJ = "";
    this.wOm = "";
    this.wOn = "";
    this.wOo = "";
    this.wOp = new HashMap();
    this.wOp.put("device_id", q.aaH());
    this.wOp.put("timestamp", paramString);
    this.wOp.put("scene", String.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(q.aaH());
    localStringBuilder.append("&");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    this.wOp.put("sign", com.tencent.mm.sdk.platformtools.aj.ej(paramString));
    paramString = this.wOp;
    localStringBuilder = new StringBuilder();
    g.ajS();
    paramString.put("code_ver", g.ajR().ajA().get(am.a.IKq, ""));
    setRequestData(this.wOp);
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
      wNS = paramJSONObject.optString("limit_fee");
      wOl = paramJSONObject.optString("is_show_order_detail");
      paramString = paramJSONObject.optString("pay_amount");
      String str1 = paramJSONObject.optString("pay_number");
      String str2 = paramJSONObject.optString("card_logos");
      k.dzG();
      k.bz(196629, wNS);
      k.dzG();
      k.bz(196641, wOl);
      k.dzG();
      k.bz(196645, paramString);
      k.dzG();
      k.bz(196646, str1);
      a.avc(str2);
      this.dmy = paramJSONObject.optInt("retcode");
      this.phe = paramJSONObject.optString("retmsg");
      this.wNI = paramJSONObject.optInt("wx_error_type");
      this.wNJ = paramJSONObject.optString("wx_error_msg");
      this.wOm = paramJSONObject.optString("get_code_flag");
      this.wOn = paramJSONObject.optString("micropay_pause_flag");
      this.wOo = paramJSONObject.optString("micropay_pause_word");
    }
    AppMethodBeat.o(66311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.n
 * JD-Core Version:    0.7.0.1
 */