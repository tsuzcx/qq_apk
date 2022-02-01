package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends m
{
  public static String GCF = "";
  public static String GCZ = "";
  final Map<String, String> ECl;
  public int GCv;
  public String GCw;
  public String GDa;
  public String GDb;
  public String GDc;
  private int fwx;
  private String tVo;
  
  public n(String paramString, int paramInt)
  {
    AppMethodBeat.i(66310);
    this.fwx = -1;
    this.tVo = "";
    this.GCv = -1;
    this.GCw = "";
    this.GDa = "";
    this.GDb = "";
    this.GDc = "";
    this.ECl = new HashMap();
    this.ECl.put("device_id", q.auM());
    this.ECl.put("timestamp", paramString);
    this.ECl.put("scene", String.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(q.auM());
    localStringBuilder.append("&");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    this.ECl.put("sign", MD5Util.getMD5String(paramString));
    paramString = this.ECl;
    localStringBuilder = new StringBuilder();
    h.aHH();
    paramString.put("code_ver", h.aHG().aHp().get(ar.a.Vgm, ""));
    setRequestData(this.ECl);
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
      GCF = paramJSONObject.optString("limit_fee");
      GCZ = paramJSONObject.optString("is_show_order_detail");
      paramString = paramJSONObject.optString("pay_amount");
      String str1 = paramJSONObject.optString("pay_number");
      String str2 = paramJSONObject.optString("card_logos");
      k.fkT();
      k.bL(196629, GCF);
      k.fkT();
      k.bL(196641, GCZ);
      k.fkT();
      k.bL(196645, paramString);
      k.fkT();
      k.bL(196646, str1);
      a.aTK(str2);
      this.fwx = paramJSONObject.optInt("retcode");
      this.tVo = paramJSONObject.optString("retmsg");
      this.GCv = paramJSONObject.optInt("wx_error_type");
      this.GCw = paramJSONObject.optString("wx_error_msg");
      this.GDa = paramJSONObject.optString("get_code_flag");
      this.GDb = paramJSONObject.optString("micropay_pause_flag");
      this.GDc = paramJSONObject.optString("micropay_pause_word");
    }
    AppMethodBeat.o(66311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.n
 * JD-Core Version:    0.7.0.1
 */