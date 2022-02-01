package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
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
  public static String AJR = "";
  public static String AJy = "";
  public String AJS;
  public String AJT;
  public String AJU;
  final Map<String, String> AJV;
  public int AJo;
  public String AJp;
  private int dDN;
  private String qwn;
  
  public n(String paramString, int paramInt)
  {
    AppMethodBeat.i(66310);
    this.dDN = -1;
    this.qwn = "";
    this.AJo = -1;
    this.AJp = "";
    this.AJS = "";
    this.AJT = "";
    this.AJU = "";
    this.AJV = new HashMap();
    this.AJV.put("device_id", q.aoG());
    this.AJV.put("timestamp", paramString);
    this.AJV.put("scene", String.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(q.aoG());
    localStringBuilder.append("&");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    this.AJV.put("sign", MD5Util.getMD5String(paramString));
    paramString = this.AJV;
    localStringBuilder = new StringBuilder();
    g.aAi();
    paramString.put("code_ver", g.aAh().azQ().get(ar.a.NSo, ""));
    setRequestData(this.AJV);
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
      AJy = paramJSONObject.optString("limit_fee");
      AJR = paramJSONObject.optString("is_show_order_detail");
      paramString = paramJSONObject.optString("pay_amount");
      String str1 = paramJSONObject.optString("pay_number");
      String str2 = paramJSONObject.optString("card_logos");
      k.ezn();
      k.bN(196629, AJy);
      k.ezn();
      k.bN(196641, AJR);
      k.ezn();
      k.bN(196645, paramString);
      k.ezn();
      k.bN(196646, str1);
      a.aJo(str2);
      this.dDN = paramJSONObject.optInt("retcode");
      this.qwn = paramJSONObject.optString("retmsg");
      this.AJo = paramJSONObject.optInt("wx_error_type");
      this.AJp = paramJSONObject.optString("wx_error_msg");
      this.AJS = paramJSONObject.optString("get_code_flag");
      this.AJT = paramJSONObject.optString("micropay_pause_flag");
      this.AJU = paramJSONObject.optString("micropay_pause_word");
    }
    AppMethodBeat.o(66311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.n
 * JD-Core Version:    0.7.0.1
 */