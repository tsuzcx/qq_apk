package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends m
{
  public static String wyA = "";
  public static String wyh = "";
  private int dlw;
  private String paA;
  public int wxX;
  public String wxY;
  public String wyB;
  public String wyC;
  public String wyD;
  final Map<String, String> wyE;
  
  public n(String paramString, int paramInt)
  {
    AppMethodBeat.i(66310);
    this.dlw = -1;
    this.paA = "";
    this.wxX = -1;
    this.wxY = "";
    this.wyB = "";
    this.wyC = "";
    this.wyD = "";
    this.wyE = new HashMap();
    this.wyE.put("device_id", q.aay());
    this.wyE.put("timestamp", paramString);
    this.wyE.put("scene", String.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(q.aay());
    localStringBuilder.append("&");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    this.wyE.put("sign", com.tencent.mm.sdk.platformtools.ai.ee(paramString));
    paramString = this.wyE;
    localStringBuilder = new StringBuilder();
    g.ajD();
    paramString.put("code_ver", g.ajC().ajl().get(al.a.IpW, ""));
    setRequestData(this.wyE);
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
      wyh = paramJSONObject.optString("limit_fee");
      wyA = paramJSONObject.optString("is_show_order_detail");
      paramString = paramJSONObject.optString("pay_amount");
      String str1 = paramJSONObject.optString("pay_number");
      String str2 = paramJSONObject.optString("card_logos");
      k.dwq();
      k.bz(196629, wyh);
      k.dwq();
      k.bz(196641, wyA);
      k.dwq();
      k.bz(196645, paramString);
      k.dwq();
      k.bz(196646, str1);
      a.atN(str2);
      this.dlw = paramJSONObject.optInt("retcode");
      this.paA = paramJSONObject.optString("retmsg");
      this.wxX = paramJSONObject.optInt("wx_error_type");
      this.wxY = paramJSONObject.optString("wx_error_msg");
      this.wyB = paramJSONObject.optString("get_code_flag");
      this.wyC = paramJSONObject.optString("micropay_pause_flag");
      this.wyD = paramJSONObject.optString("micropay_pause_word");
    }
    AppMethodBeat.o(66311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.n
 * JD-Core Version:    0.7.0.1
 */