package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends m
{
  public static String plG = "";
  public static String pln = "";
  private int cnK;
  private String kNv;
  public String plH;
  public String plI;
  public String plJ;
  final Map<String, String> plK;
  public int pld;
  public String ple;
  
  public n(String paramString, int paramInt)
  {
    AppMethodBeat.i(43411);
    this.cnK = -1;
    this.kNv = "";
    this.pld = -1;
    this.ple = "";
    this.plH = "";
    this.plI = "";
    this.plJ = "";
    this.plK = new HashMap();
    this.plK.put("device_id", q.LK());
    this.plK.put("timestamp", paramString);
    this.plK.put("scene", String.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(q.LK());
    localStringBuilder.append("&");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    this.plK.put("sign", ag.cE(paramString));
    paramString = this.plK;
    localStringBuilder = new StringBuilder();
    g.RM();
    paramString.put("code_ver", g.RL().Ru().get(ac.a.yxv, ""));
    setRequestData(this.plK);
    AppMethodBeat.o(43411);
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
    AppMethodBeat.i(43412);
    if (paramJSONObject != null)
    {
      pln = paramJSONObject.optString("limit_fee");
      plG = paramJSONObject.optString("is_show_order_detail");
      paramString = paramJSONObject.optString("pay_amount");
      String str1 = paramJSONObject.optString("pay_number");
      String str2 = paramJSONObject.optString("card_logos");
      k.bYF();
      k.aT(196629, pln);
      k.bYF();
      k.aT(196641, plG);
      k.bYF();
      k.aT(196645, paramString);
      k.bYF();
      k.aT(196646, str1);
      a.Wv(str2);
      this.cnK = paramJSONObject.optInt("retcode");
      this.kNv = paramJSONObject.optString("retmsg");
      this.pld = paramJSONObject.optInt("wx_error_type");
      this.ple = paramJSONObject.optString("wx_error_msg");
      this.plH = paramJSONObject.optString("get_code_flag");
      this.plI = paramJSONObject.optString("micropay_pause_flag");
      this.plJ = paramJSONObject.optString("micropay_pause_word");
    }
    AppMethodBeat.o(43412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.n
 * JD-Core Version:    0.7.0.1
 */