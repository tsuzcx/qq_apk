package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends j
{
  public static String mKW = "";
  public static String mLp = "";
  private int iHq = -1;
  private String iHr = "";
  public int mKM = -1;
  public String mKN = "";
  public String mLq = "";
  public String mLr = "";
  public String mLs = "";
  final Map<String, String> mLt = new HashMap();
  
  public n(String paramString, int paramInt)
  {
    this.mLt.put("device_id", q.zg());
    this.mLt.put("timestamp", paramString);
    this.mLt.put("scene", String.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(q.zg());
    localStringBuilder.append("&");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    this.mLt.put("sign", ad.bB(paramString));
    paramString = this.mLt;
    localStringBuilder = new StringBuilder();
    g.DQ();
    paramString.put("code_ver", g.DP().Dz().get(ac.a.unE, ""));
    D(this.mLt);
  }
  
  public final int HH()
  {
    return 568;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      mKW = paramJSONObject.optString("limit_fee");
      mLp = paramJSONObject.optString("is_show_order_detail");
      paramString = paramJSONObject.optString("pay_amount");
      String str1 = paramJSONObject.optString("pay_number");
      String str2 = paramJSONObject.optString("card_logos");
      k.bpX();
      k.ax(196629, mKW);
      k.bpX();
      k.ax(196641, mLp);
      k.bpX();
      k.ax(196645, paramString);
      k.bpX();
      k.ax(196646, str1);
      a.Kt(str2);
      this.iHq = paramJSONObject.optInt("retcode");
      this.iHr = paramJSONObject.optString("retmsg");
      this.mKM = paramJSONObject.optInt("wx_error_type");
      this.mKN = paramJSONObject.optString("wx_error_msg");
      this.mLq = paramJSONObject.optString("get_code_flag");
      this.mLr = paramJSONObject.optString("micropay_pause_flag");
      this.mLs = paramJSONObject.optString("micropay_pause_word");
    }
  }
  
  public final int aEC()
  {
    return 49;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlinequeryuser";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.n
 * JD-Core Version:    0.7.0.1
 */