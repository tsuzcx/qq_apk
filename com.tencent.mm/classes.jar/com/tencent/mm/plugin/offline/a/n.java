package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends m
{
  public static String vsP = "";
  public static String vti = "";
  private int dae;
  private String oxf;
  public int vsF;
  public String vsG;
  public String vtj;
  public String vtk;
  public String vtl;
  final Map<String, String> vtm;
  
  public n(String paramString, int paramInt)
  {
    AppMethodBeat.i(66310);
    this.dae = -1;
    this.oxf = "";
    this.vsF = -1;
    this.vsG = "";
    this.vtj = "";
    this.vtk = "";
    this.vtl = "";
    this.vtm = new HashMap();
    this.vtm.put("device_id", q.XX());
    this.vtm.put("timestamp", paramString);
    this.vtm.put("scene", String.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(q.XX());
    localStringBuilder.append("&");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    this.vtm.put("sign", ah.dg(paramString));
    paramString = this.vtm;
    localStringBuilder = new StringBuilder();
    g.agS();
    paramString.put("code_ver", g.agR().agA().get(ah.a.GDD, ""));
    setRequestData(this.vtm);
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
      vsP = paramJSONObject.optString("limit_fee");
      vti = paramJSONObject.optString("is_show_order_detail");
      paramString = paramJSONObject.optString("pay_amount");
      String str1 = paramJSONObject.optString("pay_number");
      String str2 = paramJSONObject.optString("card_logos");
      k.dlZ();
      k.bu(196629, vsP);
      k.dlZ();
      k.bu(196641, vti);
      k.dlZ();
      k.bu(196645, paramString);
      k.dlZ();
      k.bu(196646, str1);
      a.aoN(str2);
      this.dae = paramJSONObject.optInt("retcode");
      this.oxf = paramJSONObject.optString("retmsg");
      this.vsF = paramJSONObject.optInt("wx_error_type");
      this.vsG = paramJSONObject.optString("wx_error_msg");
      this.vtj = paramJSONObject.optString("get_code_flag");
      this.vtk = paramJSONObject.optString("micropay_pause_flag");
      this.vtl = paramJSONObject.optString("micropay_pause_word");
    }
    AppMethodBeat.o(66311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.n
 * JD-Core Version:    0.7.0.1
 */