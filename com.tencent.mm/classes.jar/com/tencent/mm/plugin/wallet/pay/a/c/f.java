package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.pay.a.d;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class f
  extends m
{
  public Orders CwO;
  public int HFS;
  public d HFT;
  private int dVv;
  public String egd;
  public String ege;
  public String egf;
  public String egg;
  public String egh;
  public String errMsg;
  private String mReqKey;
  private int scene;
  
  public f(PayInfo paramPayInfo, int paramInt)
  {
    AppMethodBeat.i(69281);
    this.CwO = null;
    this.mReqKey = null;
    this.HFS = 0;
    this.HFT = null;
    this.scene = 0;
    this.dVv = 0;
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
      Object localObject = (a)g.af(a.class);
      localHashMap1.put("is_root", "0");
      if ((localObject == null) || ((!((a)localObject).dJU()) && (!((a)localObject).dKc()))) {
        break label273;
      }
      localHashMap1.put("is_device_open_touch", "1");
      localObject = ((a)localObject).dJY();
      if (localObject != null) {
        localHashMap1.putAll((Map)localObject);
      }
      Log.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is true");
    }
    for (;;)
    {
      if (paramPayInfo != null) {
        this.dVv = paramPayInfo.dVv;
      }
      setPayInfo(paramPayInfo, localHashMap1, localHashMap2);
      setRequestData(localHashMap1);
      setWXRequestData(localHashMap2);
      AppMethodBeat.o(69281);
      return;
      this.mReqKey = paramPayInfo.dDL;
      break;
      label273:
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
        this.CwO = Orders.by(paramJSONObject);
        if (this.CwO != null) {
          this.CwO.dDL = this.mReqKey;
        }
        long l = paramJSONObject.optJSONObject("bindqueryresp").optLong("time_stamp");
        if (l > 0L)
        {
          y.setTimeStamp(String.valueOf(l));
          paramString = paramJSONObject.optJSONObject("query_order_info");
          if (paramString != null)
          {
            Log.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "get query_order_info");
            t.fQI().IbW = (paramString.optInt("query_order_time", 5) * 1000);
            t.fQI().mRetryCount = paramString.optInt("query_order_count", 0);
            t.fQI().IbX = paramString.optString("default_query_order_wording", "");
          }
          paramString = paramJSONObject.optString("pay_remind_wording");
          t.fQI().IbY = paramString;
          ai.a(paramJSONObject.optJSONObject("bindqueryresp"), this.dVv, false, false);
          paramString = (a)g.af(a.class);
          if (paramString == null) {
            break label486;
          }
          Log.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is not null");
          paramString.dJV();
          paramInt = t.fQI().fRq();
          if (paramInt != 0) {
            break label414;
          }
          if (paramString.dJT())
          {
            paramString.pj(t.fQI().fRo());
            paramString.pk(false);
            if (paramJSONObject.has("real_name_info"))
            {
              paramString = paramJSONObject.optJSONObject("real_name_info");
              this.egd = paramString.optString("guide_flag");
              this.ege = paramString.optString("guide_wording");
              this.egf = paramString.optString("left_button_wording");
              this.egg = paramString.optString("right_button_wording");
              this.egh = paramString.optString("upload_credit_url");
              this.HFS = paramString.optInt("guide_type", 0);
            }
            if (paramJSONObject.has("user_notify_info"))
            {
              paramString = paramJSONObject.optJSONObject("user_notify_info");
              if (paramString != null) {
                break label497;
              }
              paramString = null;
              this.HFT = paramString;
            }
            AppMethodBeat.o(69283);
          }
        }
        else
        {
          Log.w("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "no time_stamp in qrcodeusebindquery.");
          continue;
        }
        if (!paramString.dKb()) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "hy: " + paramString.toString());
        AppMethodBeat.o(69283);
        return;
      }
      paramString.pk(t.fQI().fRo());
      paramString.pj(false);
      continue;
      label414:
      if ((paramInt == 1) && (paramString.dJT()))
      {
        paramString.pj(t.fQI().fRo());
        paramString.pk(false);
      }
      else if ((paramInt == 2) && (paramString.dKb()))
      {
        paramString.pk(t.fQI().fRo());
        paramString.pj(false);
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
          paramString.HFB = paramInt;
          paramString.HFC = paramJSONObject;
          paramString.lHA = str1;
          paramString.lHB = str2;
          paramString.HFD = str3;
        }
      }
    }
  }
  
  public void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69282);
    super.onGYNetEnd2(parame, paramJSONObject);
    int i = this.dVv;
    paramJSONObject = this.mReqKey;
    int j = parame.errCode;
    Log.v("Micromsg.WalletPayLinkReport", "kvQrcode scene %s reqKey %s errcode %s", new Object[] { Integer.valueOf(i), paramJSONObject, Integer.valueOf(j) });
    h.CyF.a(15000, new Object[] { Integer.valueOf(i), paramJSONObject, Integer.valueOf(j) });
    AppMethodBeat.o(69282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.c.f
 * JD-Core Version:    0.7.0.1
 */