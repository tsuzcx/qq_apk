package com.tencent.mm.plugin.wallet.bind.a;

import android.content.Context;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends j
{
  public boolean cdd = false;
  public ArrayList<Bankcard> qgr = null;
  public boolean qjs = true;
  public String qjt;
  public String qju;
  private String qjv;
  public String token;
  
  public c(String paramString, PayInfo paramPayInfo)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    a(paramPayInfo, localHashMap1, localHashMap2);
    g.DQ();
    paramPayInfo = new o(bk.a((Integer)g.DP().Dz().get(9, null), 0));
    this.qjv = paramString;
    localHashMap1.put("import_code", paramString);
    localHashMap1.put("qqid", paramPayInfo.toString());
    D(localHashMap1);
    aC(localHashMap2);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramInt != 0) {
      return;
    }
    this.qgr = new ArrayList();
    for (;;)
    {
      try
      {
        this.cdd = "1".equals(paramJSONObject.optString("is_reg", "0"));
        this.token = paramJSONObject.optString("token", "");
        paramString = paramJSONObject.getJSONArray("Array");
        int j = paramString.length();
        paramInt = 0;
        if (paramInt >= j) {
          break label409;
        }
        JSONObject localJSONObject = paramString.getJSONObject(paramInt);
        paramJSONObject = d.bUV().am(localJSONObject);
        if (paramJSONObject == null) {
          break label452;
        }
        if (2 != localJSONObject.optInt("bank_acc_type", 2)) {
          break label459;
        }
        i = 1;
        if (i != 0) {
          paramJSONObject.field_cardType |= Bankcard.qtm;
        }
        paramJSONObject.field_bankcardTail = localJSONObject.optString("bank_tail");
        paramJSONObject.qtu = ("************" + paramJSONObject.field_bankcardTail);
        paramJSONObject.field_trueName = localJSONObject.optString("true_name");
        paramJSONObject.qtt = localJSONObject.optString("cre_id");
        paramJSONObject.qsL = localJSONObject.optInt("cre_type", -1);
        paramJSONObject.qtG = this.qjv;
        if (1 != localJSONObject.optInt("samecardexist", 0)) {
          break label465;
        }
        bool = true;
        paramJSONObject.bre = bool;
        if (paramJSONObject.bUQ())
        {
          paramJSONObject.field_desc = paramJSONObject.field_bankName;
          localJSONObject = localJSONObject.optJSONObject("bankappservice");
          if (localJSONObject != null)
          {
            this.qjt = localJSONObject.optString("username");
            this.qju = localJSONObject.optString("app_recommend_desc");
          }
          this.qgr.add(paramJSONObject);
          break label452;
        }
        if (paramJSONObject.bUS())
        {
          paramJSONObject.field_desc = ae.getContext().getString(a.i.wallet_credit_card_desc, new Object[] { paramJSONObject.field_bankName, paramJSONObject.field_bankcardTail });
          continue;
        }
        if (!paramJSONObject.bUP()) {
          break label375;
        }
      }
      catch (JSONException paramString)
      {
        y.printErrStackTrace("MicroMsg.NetSceneTenpayQueryBindBankcard", paramString, "", new Object[0]);
        return;
      }
      paramJSONObject.field_desc = ae.getContext().getString(a.i.wallet_wxcredit_card_desc, new Object[] { paramJSONObject.field_bankName, paramJSONObject.field_bankcardTail });
      continue;
      label375:
      paramJSONObject.field_desc = ae.getContext().getString(a.i.wallet_deposit_card_desc, new Object[] { paramJSONObject.field_bankName, paramJSONObject.field_bankcardTail });
      continue;
      label409:
      y.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "got data---isReg:" + this.cdd + ",bankcard.size:" + this.qgr.size());
      return;
      label452:
      paramInt += 1;
      continue;
      label459:
      int i = 0;
      continue;
      label465:
      boolean bool = false;
    }
  }
  
  public final int aEC()
  {
    return 37;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.a.c
 * JD-Core Version:    0.7.0.1
 */