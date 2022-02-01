package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fingerprint.c.a;
import com.tencent.mm.plugin.wallet.pay.a.d;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.e;
import com.tencent.mm.wallet_core.model.y;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class f
  extends m
{
  public Orders OsJ;
  public int VmW;
  public d VmX;
  public String errMsg;
  private int hUR;
  public String igC;
  public String igD;
  public String igE;
  public String igF;
  public String igG;
  private String mReqKey;
  private int scene;
  
  public f(PayInfo paramPayInfo, int paramInt)
  {
    AppMethodBeat.i(69281);
    this.OsJ = null;
    this.mReqKey = null;
    this.VmW = 0;
    this.VmX = null;
    this.scene = 0;
    this.hUR = 0;
    HashMap localHashMap1;
    HashMap localHashMap2;
    if (paramPayInfo == null)
    {
      Log.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "error payinfo is null %s", new Object[] { Util.getStack().toString() });
      this.mReqKey = "";
      this.scene = paramInt;
      localHashMap1 = new HashMap();
      localHashMap2 = new HashMap();
      localHashMap1.put("support_cardtag3", "1");
      localHashMap1.put("req_key", this.mReqKey);
      localHashMap1.put("bind_query_scene", String.valueOf(paramInt));
      localHashMap1.put("is_merge", "1");
      Object localObject = (a)com.tencent.mm.kernel.h.ax(a.class);
      if ((localObject == null) || (!((a)localObject).isRoot())) {
        break label288;
      }
      localHashMap1.put("is_root", "1");
      label175:
      if ((localObject == null) || ((!((a)localObject).ftw()) && (!((a)localObject).ftE()))) {
        break label302;
      }
      localHashMap1.put("is_device_open_touch", "1");
      localObject = ((a)localObject).ftA();
      if (localObject != null) {
        localHashMap1.putAll((Map)localObject);
      }
      Log.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is true");
    }
    for (;;)
    {
      if (paramPayInfo != null) {
        this.hUR = paramPayInfo.hUR;
      }
      setPayInfo(paramPayInfo, localHashMap1, localHashMap2);
      setRequestData(localHashMap1);
      setWXRequestData(localHashMap2);
      AppMethodBeat.o(69281);
      return;
      this.mReqKey = paramPayInfo.hAT;
      break;
      label288:
      localHashMap1.put("is_root", "0");
      break label175;
      label302:
      localHashMap1.put("is_device_open_touch", "0");
      Log.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is false");
    }
  }
  
  public int getFuncId()
  {
    return 1593;
  }
  
  public int getTenpayCgicmd()
  {
    return 112;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/qrcodeusebindquery";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69283);
    for (;;)
    {
      try
      {
        this.errMsg = paramString;
        this.OsJ = Orders.ce(paramJSONObject);
        if (this.OsJ != null) {
          this.OsJ.hAT = this.mReqKey;
        }
        long l = paramJSONObject.optJSONObject("bindqueryresp").optLong("time_stamp");
        if (l > 0L)
        {
          y.setTimeStamp(String.valueOf(l));
          paramString = paramJSONObject.optJSONObject("query_order_info");
          if (paramString != null)
          {
            Log.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "get query_order_info");
            u.iiC().VKo = (paramString.optInt("query_order_time", 5) * 1000);
            u.iiC().mRetryCount = paramString.optInt("query_order_count", 0);
            u.iiC().VKp = paramString.optString("default_query_order_wording", "");
          }
          paramString = paramJSONObject.optString("pay_remind_wording");
          u.iiC().VKq = paramString;
          ah.a(paramJSONObject.optJSONObject("bindqueryresp"), this.hUR, false, false);
          paramString = (a)com.tencent.mm.kernel.h.ax(a.class);
          if (paramString == null) {
            break label486;
          }
          Log.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is not null");
          paramString.ftx();
          paramInt = u.iiC().ijm();
          if (paramInt != 0) {
            break label414;
          }
          if (paramString.ftv())
          {
            paramString.vu(u.iiC().ijj());
            paramString.vv(false);
            if (paramJSONObject.has("real_name_info"))
            {
              paramString = paramJSONObject.optJSONObject("real_name_info");
              this.igC = paramString.optString("guide_flag");
              this.igD = paramString.optString("guide_wording");
              this.igE = paramString.optString("left_button_wording");
              this.igF = paramString.optString("right_button_wording");
              this.igG = paramString.optString("upload_credit_url");
              this.VmW = paramString.optInt("guide_type", 0);
            }
            if (paramJSONObject.has("user_notify_info"))
            {
              paramString = paramJSONObject.optJSONObject("user_notify_info");
              if (paramString != null) {
                break label497;
              }
              paramString = null;
              this.VmX = paramString;
            }
            AppMethodBeat.o(69283);
          }
        }
        else
        {
          Log.w("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "no time_stamp in qrcodeusebindquery.");
          continue;
        }
        if (!paramString.ftD()) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "hy: " + paramString.toString());
        AppMethodBeat.o(69283);
        return;
      }
      paramString.vv(u.iiC().ijj());
      paramString.vu(false);
      continue;
      label414:
      if ((paramInt == 1) && (paramString.ftv()))
      {
        paramString.vu(u.iiC().ijj());
        paramString.vv(false);
      }
      else if ((paramInt == 2) && (paramString.ftD()))
      {
        paramString.vv(u.iiC().ijj());
        paramString.vu(false);
        continue;
        label486:
        Log.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is null");
        continue;
        label497:
        paramInt = paramString.optInt("notify_flag", 0);
        paramJSONObject = paramString.optString("notify_wording", "");
        String str1 = paramString.optString("left_button_wording", "");
        String str2 = paramString.optString("right_button_wording", "");
        String str3 = paramString.optString("confirm_button_wording", "");
        if (paramInt == 0)
        {
          paramString = null;
        }
        else
        {
          paramString = new d();
          paramString.VmF = paramInt;
          paramString.VmG = paramJSONObject;
          paramString.rGU = str1;
          paramString.right_button_wording = str2;
          paramString.VmH = str3;
        }
      }
    }
  }
  
  public void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69282);
    super.onGYNetEnd2(parame, paramJSONObject);
    int i = this.hUR;
    paramJSONObject = this.mReqKey;
    int j = parame.errCode;
    Log.v("Micromsg.WalletPayLinkReport", "kvQrcode scene %s reqKey %s errcode %s", new Object[] { Integer.valueOf(i), paramJSONObject, Integer.valueOf(j) });
    com.tencent.mm.plugin.report.service.h.OAn.b(15000, new Object[] { Integer.valueOf(i), paramJSONObject, Integer.valueOf(j) });
    AppMethodBeat.o(69282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.c.f
 * JD-Core Version:    0.7.0.1
 */