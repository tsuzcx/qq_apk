package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.pay.a.d;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class f
  extends m
{
  public int CIy;
  public d CIz;
  private int dCC;
  public String dMS;
  public String dMT;
  public String dMU;
  public String dMV;
  public String dMW;
  public String errMsg;
  private String mReqKey;
  private int scene;
  public Orders ygb;
  
  public f(PayInfo paramPayInfo, int paramInt)
  {
    AppMethodBeat.i(69281);
    this.ygb = null;
    this.mReqKey = null;
    this.CIy = 0;
    this.CIz = null;
    this.scene = 0;
    this.dCC = 0;
    HashMap localHashMap1;
    HashMap localHashMap2;
    if (paramPayInfo == null)
    {
      ad.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "error payinfo is null %s", new Object[] { bt.flS().toString() });
      this.mReqKey = "";
      this.scene = paramInt;
      localHashMap1 = new HashMap();
      localHashMap2 = new HashMap();
      localHashMap1.put("support_cardtag3", "1");
      localHashMap1.put("req_key", this.mReqKey);
      localHashMap1.put("bind_query_scene", String.valueOf(paramInt));
      localHashMap1.put("is_merge", "1");
      Object localObject = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      localHashMap1.put("is_root", "0");
      if ((localObject == null) || ((!((com.tencent.mm.plugin.fingerprint.d.a)localObject).cPu()) && (!((com.tencent.mm.plugin.fingerprint.d.a)localObject).cPC()))) {
        break label273;
      }
      localHashMap1.put("is_device_open_touch", "1");
      localObject = ((com.tencent.mm.plugin.fingerprint.d.a)localObject).cPy();
      if (localObject != null) {
        localHashMap1.putAll((Map)localObject);
      }
      ad.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is true");
    }
    for (;;)
    {
      if (paramPayInfo != null) {
        this.dCC = paramPayInfo.dCC;
      }
      setPayInfo(paramPayInfo, localHashMap1, localHashMap2);
      setRequestData(localHashMap1);
      setWXRequestData(localHashMap2);
      AppMethodBeat.o(69281);
      return;
      this.mReqKey = paramPayInfo.dlu;
      break;
      label273:
      localHashMap1.put("is_device_open_touch", "0");
      ad.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is false");
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
        this.ygb = Orders.aY(paramJSONObject);
        if (this.ygb != null) {
          this.ygb.dlu = this.mReqKey;
        }
        long l = paramJSONObject.optJSONObject("bindqueryresp").optLong("time_stamp");
        if (l > 0L)
        {
          y.setTimeStamp(String.valueOf(l));
          paramString = paramJSONObject.optJSONObject("query_order_info");
          if (paramString != null)
          {
            ad.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "get query_order_info");
            t.eFy().Dbg = (paramString.optInt("query_order_time", 5) * 1000);
            t.eFy().mRetryCount = paramString.optInt("query_order_count", 0);
            t.eFy().Dbh = paramString.optString("default_query_order_wording", "");
          }
          paramString = paramJSONObject.optString("pay_remind_wording");
          t.eFy().Dbi = paramString;
          ai.a(paramJSONObject.optJSONObject("bindqueryresp"), this.dCC, false, false);
          paramString = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
          if (paramString == null) {
            break label864;
          }
          ad.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is not null");
          paramString.cPv();
          paramInt = t.eFy().eGg();
          if (paramInt != 0) {
            break label792;
          }
          if (paramString.cPt())
          {
            paramString.my(t.eFy().eGe());
            paramString.mz(false);
            if (paramJSONObject.has("real_name_info"))
            {
              paramString = paramJSONObject.optJSONObject("real_name_info");
              this.dMS = paramString.optString("guide_flag");
              this.dMT = paramString.optString("guide_wording");
              this.dMU = paramString.optString("left_button_wording");
              this.dMV = paramString.optString("right_button_wording");
              this.dMW = paramString.optString("upload_credit_url");
              this.CIy = paramString.optInt("guide_type", 0);
            }
            if (paramJSONObject.has("user_notify_info"))
            {
              paramString = paramJSONObject.optJSONObject("user_notify_info");
              if (paramString != null) {
                break label875;
              }
              paramString = null;
              this.CIz = paramString;
            }
            if (paramJSONObject.has("cashier_switch_info"))
            {
              paramString = paramJSONObject.optJSONObject("cashier_switch_info");
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_APP_PAY_SWTICH_KEY", paramString.optBoolean("app"));
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_JSAPI_PAY_SWTICH_KEY", paramString.optBoolean("jsapi"));
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_TINYAPP_PAY_SWTICH_KEY", paramString.optBoolean("tinyapp"));
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_NATIVE_PAY_SWTICH_KEY", paramString.optBoolean("native"));
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_OFFLINE_PAY_SWTICH_KEY", paramString.optBoolean("offline"));
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_HONGBAO_PAY_SWTICH_KEY", paramString.optBoolean("hongbao"));
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_TRANSFER_PAY_SWTICH_KEY", paramString.optBoolean("transfer"));
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY", paramString.optBoolean("qrcode_receive"));
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_REWARD_CODE_PAY_SWTICH_KEY", paramString.optBoolean("reward_code"));
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_GROUP_CHAT_RECEIVE_PAY_SWTICH_KEY", paramString.optBoolean("group_chat_receive"));
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_F2F_HONGBAO_PAY_SWTICH_KEY", paramString.optBoolean("f2f_hongbao"));
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_TRANSFER2BANK_PAY_SWTICH_KEY", paramString.optBoolean("transfer2bank"));
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_H5_PAY_SWTICH_KEY", paramString.optBoolean("h5"));
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_MOBILE_FEE_PAY_SWTICH_KEY", paramString.optBoolean("mobile_fee"));
              ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceSetBool("NEW_CASHIER_EMPTY_PREPAY_ID_PAY_SWTICH_KEY", paramString.optBoolean("empty_prepay_id"));
            }
            AppMethodBeat.o(69283);
          }
        }
        else
        {
          ad.w("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "no time_stamp in qrcodeusebindquery.");
          continue;
        }
        if (!paramString.cPB()) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "hy: " + paramString.toString());
        AppMethodBeat.o(69283);
        return;
      }
      paramString.mz(t.eFy().eGe());
      paramString.my(false);
      continue;
      label792:
      if ((paramInt == 1) && (paramString.cPt()))
      {
        paramString.my(t.eFy().eGe());
        paramString.mz(false);
      }
      else if ((paramInt == 2) && (paramString.cPB()))
      {
        paramString.mz(t.eFy().eGe());
        paramString.my(false);
        continue;
        label864:
        ad.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is null");
        continue;
        label875:
        paramInt = paramString.optInt("notify_flag", 0);
        String str1 = paramString.optString("notify_wording", "");
        String str2 = paramString.optString("left_button_wording", "");
        String str3 = paramString.optString("right_button_wording", "");
        String str4 = paramString.optString("confirm_button_wording", "");
        if (paramInt == 0)
        {
          paramString = null;
        }
        else
        {
          paramString = new d();
          paramString.CIh = paramInt;
          paramString.CIi = str1;
          paramString.kzK = str2;
          paramString.kzL = str3;
          paramString.CIj = str4;
        }
      }
    }
  }
  
  public void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69282);
    super.onGYNetEnd2(parame, paramJSONObject);
    int i = this.dCC;
    paramJSONObject = this.mReqKey;
    int j = parame.errCode;
    ad.v("Micromsg.WalletPayLinkReport", "kvQrcode scene %s reqKey %s errcode %s", new Object[] { Integer.valueOf(i), paramJSONObject, Integer.valueOf(j) });
    com.tencent.mm.plugin.report.service.g.yhR.f(15000, new Object[] { Integer.valueOf(i), paramJSONObject, Integer.valueOf(j) });
    AppMethodBeat.o(69282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.c.f
 * JD-Core Version:    0.7.0.1
 */