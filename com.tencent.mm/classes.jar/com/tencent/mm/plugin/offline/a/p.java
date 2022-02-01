package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.offline.c.d;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p
  extends m
{
  public static String MyQ = "";
  public static String Mzk = "";
  final Map<String, String> Kvm;
  public int MyG;
  public String MyH;
  public String Mzl;
  public String Mzm;
  public String Mzn;
  private int hAV;
  private String wYI;
  
  public p(String paramString, int paramInt)
  {
    AppMethodBeat.i(66310);
    this.hAV = -1;
    this.wYI = "";
    this.MyG = -1;
    this.MyH = "";
    this.Mzl = "";
    this.Mzm = "";
    this.Mzn = "";
    this.Kvm = new HashMap();
    this.Kvm.put("device_id", q.aPg());
    this.Kvm.put("timestamp", paramString);
    this.Kvm.put("scene", String.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(q.aPg());
    localStringBuilder.append("&");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    this.Kvm.put("sign", MD5Util.getMD5String(paramString));
    paramString = this.Kvm;
    localStringBuilder = new StringBuilder();
    h.baF();
    paramString.put("code_ver", h.baE().ban().get(at.a.acHB, ""));
    setRequestData(this.Kvm);
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
      MyQ = paramJSONObject.optString("limit_fee");
      Mzk = paramJSONObject.optString("is_show_order_detail");
      paramString = paramJSONObject.optString("pay_amount");
      String str1 = paramJSONObject.optString("pay_number");
      String str2 = paramJSONObject.optString("card_logos");
      k.gvj();
      k.ct(196629, MyQ);
      k.gvj();
      k.ct(196641, Mzk);
      k.gvj();
      k.ct(196645, paramString);
      k.gvj();
      k.ct(196646, str1);
      d.aQP(str2);
      this.hAV = paramJSONObject.optInt("retcode");
      this.wYI = paramJSONObject.optString("retmsg");
      this.MyG = paramJSONObject.optInt("wx_error_type");
      this.MyH = paramJSONObject.optString("wx_error_msg");
      this.Mzl = paramJSONObject.optString("get_code_flag");
      this.Mzm = paramJSONObject.optString("micropay_pause_flag");
      this.Mzn = paramJSONObject.optString("micropay_pause_word");
    }
    AppMethodBeat.o(66311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.p
 * JD-Core Version:    0.7.0.1
 */