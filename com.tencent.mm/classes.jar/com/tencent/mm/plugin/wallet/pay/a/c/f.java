package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.pay.a.d;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class f
  extends m
{
  public int Dae;
  public d Daf;
  private int dDH;
  public String dOi;
  public String dOj;
  public String dOk;
  public String dOl;
  public String dOm;
  public String errMsg;
  private String mReqKey;
  private int scene;
  public Orders yvS;
  
  public f(PayInfo paramPayInfo, int paramInt)
  {
    AppMethodBeat.i(69281);
    this.yvS = null;
    this.mReqKey = null;
    this.Dae = 0;
    this.Daf = null;
    this.scene = 0;
    this.dDH = 0;
    HashMap localHashMap1;
    HashMap localHashMap2;
    if (paramPayInfo == null)
    {
      ae.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "error payinfo is null %s", new Object[] { bu.fpN().toString() });
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
      if ((localObject == null) || ((!((com.tencent.mm.plugin.fingerprint.d.a)localObject).cRZ()) && (!((com.tencent.mm.plugin.fingerprint.d.a)localObject).cSh()))) {
        break label273;
      }
      localHashMap1.put("is_device_open_touch", "1");
      localObject = ((com.tencent.mm.plugin.fingerprint.d.a)localObject).cSd();
      if (localObject != null) {
        localHashMap1.putAll((Map)localObject);
      }
      ae.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is true");
    }
    for (;;)
    {
      if (paramPayInfo != null) {
        this.dDH = paramPayInfo.dDH;
      }
      setPayInfo(paramPayInfo, localHashMap1, localHashMap2);
      setRequestData(localHashMap1);
      setWXRequestData(localHashMap2);
      AppMethodBeat.o(69281);
      return;
      this.mReqKey = paramPayInfo.dmw;
      break;
      label273:
      localHashMap1.put("is_device_open_touch", "0");
      ae.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is false");
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
        this.yvS = Orders.aY(paramJSONObject);
        if (this.yvS != null) {
          this.yvS.dmw = this.mReqKey;
        }
        long l = paramJSONObject.optJSONObject("bindqueryresp").optLong("time_stamp");
        if (l > 0L)
        {
          y.setTimeStamp(String.valueOf(l));
          paramString = paramJSONObject.optJSONObject("query_order_info");
          if (paramString != null)
          {
            ae.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "get query_order_info");
            t.eJf().DsK = (paramString.optInt("query_order_time", 5) * 1000);
            t.eJf().mRetryCount = paramString.optInt("query_order_count", 0);
            t.eJf().DsL = paramString.optString("default_query_order_wording", "");
          }
          paramString = paramJSONObject.optString("pay_remind_wording");
          t.eJf().DsM = paramString;
          ai.a(paramJSONObject.optJSONObject("bindqueryresp"), this.dDH, false, false);
          paramString = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
          if (paramString == null) {
            break label864;
          }
          ae.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is not null");
          paramString.cSa();
          paramInt = t.eJf().eJN();
          if (paramInt != 0) {
            break label792;
          }
          if (paramString.cRY())
          {
            paramString.mC(t.eJf().eJL());
            paramString.mD(false);
            if (paramJSONObject.has("real_name_info"))
            {
              paramString = paramJSONObject.optJSONObject("real_name_info");
              this.dOi = paramString.optString("guide_flag");
              this.dOj = paramString.optString("guide_wording");
              this.dOk = paramString.optString("left_button_wording");
              this.dOl = paramString.optString("right_button_wording");
              this.dOm = paramString.optString("upload_credit_url");
              this.Dae = paramString.optInt("guide_type", 0);
            }
            if (paramJSONObject.has("user_notify_info"))
            {
              paramString = paramJSONObject.optJSONObject("user_notify_info");
              if (paramString != null) {
                break label875;
              }
              paramString = null;
              this.Daf = paramString;
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
          ae.w("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "no time_stamp in qrcodeusebindquery.");
          continue;
        }
        if (!paramString.cSg()) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "hy: " + paramString.toString());
        AppMethodBeat.o(69283);
        return;
      }
      paramString.mD(t.eJf().eJL());
      paramString.mC(false);
      continue;
      label792:
      if ((paramInt == 1) && (paramString.cRY()))
      {
        paramString.mC(t.eJf().eJL());
        paramString.mD(false);
      }
      else if ((paramInt == 2) && (paramString.cSg()))
      {
        paramString.mD(t.eJf().eJL());
        paramString.mC(false);
        continue;
        label864:
        ae.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is null");
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
          paramString.CZN = paramInt;
          paramString.CZO = str1;
          paramString.kCZ = str2;
          paramString.kDa = str3;
          paramString.CZP = str4;
        }
      }
    }
  }
  
  public void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69282);
    super.onGYNetEnd2(parame, paramJSONObject);
    int i = this.dDH;
    paramJSONObject = this.mReqKey;
    int j = parame.errCode;
    ae.v("Micromsg.WalletPayLinkReport", "kvQrcode scene %s reqKey %s errcode %s", new Object[] { Integer.valueOf(i), paramJSONObject, Integer.valueOf(j) });
    com.tencent.mm.plugin.report.service.g.yxI.f(15000, new Object[] { Integer.valueOf(i), paramJSONObject, Integer.valueOf(j) });
    AppMethodBeat.o(69282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.c.f
 * JD-Core Version:    0.7.0.1
 */