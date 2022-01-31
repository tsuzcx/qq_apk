package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class f
  extends m
{
  private int cCD;
  public String cLV;
  public String cLW;
  public String cLX;
  public String cLY;
  public String cLZ;
  public String errMsg;
  private String mReqKey;
  public Orders qrf;
  private int scene;
  public int tVC;
  public com.tencent.mm.plugin.wallet.pay.a.d tVD;
  
  public f(PayInfo paramPayInfo, int paramInt)
  {
    AppMethodBeat.i(45938);
    this.qrf = null;
    this.mReqKey = null;
    this.tVC = 0;
    this.tVD = null;
    this.scene = 0;
    this.cCD = 0;
    HashMap localHashMap1;
    HashMap localHashMap2;
    if (paramPayInfo == null)
    {
      ab.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "error payinfo is null %s", new Object[] { bo.dtY().toString() });
      this.mReqKey = "";
      this.scene = paramInt;
      localHashMap1 = new HashMap();
      localHashMap2 = new HashMap();
      localHashMap1.put("support_cardtag3", "1");
      localHashMap1.put("req_key", this.mReqKey);
      localHashMap1.put("bind_query_scene", String.valueOf(paramInt));
      localHashMap1.put("is_merge", "1");
      Object localObject = (l)g.E(l.class);
      localHashMap1.put("is_root", "0");
      if ((localObject == null) || ((!((l)localObject).bzb()) && (!((l)localObject).bzo()))) {
        break label273;
      }
      localHashMap1.put("is_device_open_touch", "1");
      localObject = ((l)localObject).bzj();
      if (localObject != null) {
        localHashMap1.putAll((Map)localObject);
      }
      ab.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is true");
    }
    for (;;)
    {
      if (paramPayInfo != null) {
        this.cCD = paramPayInfo.cCD;
      }
      setPayInfo(paramPayInfo, localHashMap1, localHashMap2);
      setRequestData(localHashMap1);
      setWXRequestData(localHashMap2);
      AppMethodBeat.o(45938);
      return;
      this.mReqKey = paramPayInfo.cnI;
      break;
      label273:
      localHashMap1.put("is_device_open_touch", "0");
      ab.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "is_device_open_touch is false");
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
    AppMethodBeat.i(45940);
    for (;;)
    {
      try
      {
        this.errMsg = paramString;
        this.qrf = Orders.au(paramJSONObject);
        if (this.qrf != null) {
          this.qrf.cnI = this.mReqKey;
        }
        long l = paramJSONObject.optJSONObject("bindqueryresp").optLong("time_stamp");
        if (l > 0L)
        {
          w.setTimeStamp(String.valueOf(l));
          paramString = paramJSONObject.optJSONObject("query_order_info");
          if (paramString != null)
          {
            ab.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "get query_order_info");
            t.cTN().ulY = (paramString.optInt("query_order_time", 5) * 1000);
            t.cTN().mRetryCount = paramString.optInt("query_order_count", 0);
            t.cTN().ulZ = paramString.optString("default_query_order_wording", "");
          }
          paramString = paramJSONObject.optString("pay_remind_wording");
          t.cTN().uma = paramString;
          ah.a(paramJSONObject.optJSONObject("bindqueryresp"), this.cCD, false);
          paramString = (l)g.E(l.class);
          if (paramString == null) {
            break label863;
          }
          ab.i("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is not null");
          paramString.bzc();
          paramInt = t.cTN().cUr();
          if (paramInt != 0) {
            break label791;
          }
          if (paramString.bza())
          {
            paramString.hH(t.cTN().cUp());
            paramString.hI(false);
            if (paramJSONObject.has("real_name_info"))
            {
              paramString = paramJSONObject.optJSONObject("real_name_info");
              this.cLV = paramString.optString("guide_flag");
              this.cLW = paramString.optString("guide_wording");
              this.cLX = paramString.optString("left_button_wording");
              this.cLY = paramString.optString("right_button_wording");
              this.cLZ = paramString.optString("upload_credit_url");
              this.tVC = paramString.optInt("guide_type", 0);
            }
            if (paramJSONObject.has("user_notify_info"))
            {
              paramString = paramJSONObject.optJSONObject("user_notify_info");
              if (paramString != null) {
                break label874;
              }
              paramString = null;
              this.tVD = paramString;
            }
            if (paramJSONObject.has("cashier_switch_info"))
            {
              paramString = paramJSONObject.optJSONObject("cashier_switch_info");
              ((b)g.E(b.class)).kindaCacheServiceSetBool("NEW_CASHIER_APP_PAY_SWTICH_KEY", paramString.optBoolean("app"));
              ((b)g.E(b.class)).kindaCacheServiceSetBool("NEW_CASHIER_JSAPI_PAY_SWTICH_KEY", paramString.optBoolean("jsapi"));
              ((b)g.E(b.class)).kindaCacheServiceSetBool("NEW_CASHIER_TINYAPP_PAY_SWTICH_KEY", paramString.optBoolean("tinyapp"));
              ((b)g.E(b.class)).kindaCacheServiceSetBool("NEW_CASHIER_NATIVE_PAY_SWTICH_KEY", paramString.optBoolean("native"));
              ((b)g.E(b.class)).kindaCacheServiceSetBool("NEW_CASHIER_OFFLINE_PAY_SWTICH_KEY", paramString.optBoolean("offline"));
              ((b)g.E(b.class)).kindaCacheServiceSetBool("NEW_CASHIER_HONGBAO_PAY_SWTICH_KEY", paramString.optBoolean("hongbao"));
              ((b)g.E(b.class)).kindaCacheServiceSetBool("NEW_CASHIER_TRANSFER_PAY_SWTICH_KEY", paramString.optBoolean("transfer"));
              ((b)g.E(b.class)).kindaCacheServiceSetBool("NEW_CASHIER_QRCODE_RECEIVE_PAY_SWTICH_KEY", paramString.optBoolean("qrcode_receive"));
              ((b)g.E(b.class)).kindaCacheServiceSetBool("NEW_CASHIER_REWARD_CODE_PAY_SWTICH_KEY", paramString.optBoolean("reward_code"));
              ((b)g.E(b.class)).kindaCacheServiceSetBool("NEW_CASHIER_GROUP_CHAT_RECEIVE_PAY_SWTICH_KEY", paramString.optBoolean("group_chat_receive"));
              ((b)g.E(b.class)).kindaCacheServiceSetBool("NEW_CASHIER_F2F_HONGBAO_PAY_SWTICH_KEY", paramString.optBoolean("f2f_hongbao"));
              ((b)g.E(b.class)).kindaCacheServiceSetBool("NEW_CASHIER_TRANSFER2BANK_PAY_SWTICH_KEY", paramString.optBoolean("transfer2bank"));
              ((b)g.E(b.class)).kindaCacheServiceSetBool("NEW_CASHIER_H5_PAY_SWTICH_KEY", paramString.optBoolean("h5"));
              ((b)g.E(b.class)).kindaCacheServiceSetBool("NEW_CASHIER_MOBILE_FEE_PAY_SWTICH_KEY", paramString.optBoolean("mobile_fee"));
              ((b)g.E(b.class)).kindaCacheServiceSetBool("NEW_CASHIER_EMPTY_PREPAY_ID_PAY_SWTICH_KEY", paramString.optBoolean("empty_prepay_id"));
            }
            AppMethodBeat.o(45940);
          }
        }
        else
        {
          ab.w("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "no time_stamp in qrcodeusebindquery.");
          continue;
        }
        if (!paramString.bzn()) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "hy: " + paramString.toString());
        AppMethodBeat.o(45940);
        return;
      }
      paramString.hI(t.cTN().cUp());
      paramString.hH(false);
      continue;
      label791:
      if ((paramInt == 1) && (paramString.bza()))
      {
        paramString.hH(t.cTN().cUp());
        paramString.hI(false);
      }
      else if ((paramInt == 2) && (paramString.bzn()))
      {
        paramString.hI(t.cTN().cUp());
        paramString.hH(false);
        continue;
        label863:
        ab.e("MicroMsg.NetSceneTenpayQueryOrderInfoByQRCode", "IFingerPrintMgr is null");
        continue;
        label874:
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
          paramString = new com.tencent.mm.plugin.wallet.pay.a.d();
          paramString.tVm = paramInt;
          paramString.tVn = str1;
          paramString.opC = str2;
          paramString.opD = str3;
          paramString.tVo = str4;
        }
      }
    }
  }
  
  public void onGYNetEnd2(com.tencent.mm.wallet_core.c.d paramd, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(45939);
    super.onGYNetEnd2(paramd, paramJSONObject);
    int i = this.cCD;
    paramJSONObject = this.mReqKey;
    int j = paramd.errCode;
    ab.v("Micromsg.WalletPayLinkReport", "kvQrcode scene %s reqKey %s errcode %s", new Object[] { Integer.valueOf(i), paramJSONObject, Integer.valueOf(j) });
    h.qsU.e(15000, new Object[] { Integer.valueOf(i), paramJSONObject, Integer.valueOf(j) });
    AppMethodBeat.o(45939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.c.f
 * JD-Core Version:    0.7.0.1
 */