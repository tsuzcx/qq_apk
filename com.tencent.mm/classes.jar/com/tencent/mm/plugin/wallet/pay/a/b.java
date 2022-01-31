package com.tencent.mm.plugin.wallet.pay.a;

import android.content.Context;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends j
{
  public String desc;
  public String mOZ;
  public double nyN;
  
  public b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString);
    D(localHashMap);
  }
  
  public final int HH()
  {
    return 1603;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    ad localad;
    if (paramInt == 0)
    {
      this.mOZ = paramJSONObject.optString("fee_type");
      this.nyN = (paramJSONObject.optDouble("total_fee") / 100.0D);
      paramString = paramJSONObject.optJSONArray("Array");
      if ((paramString != null) && (paramString.length() > 0)) {
        this.desc = ((JSONObject)paramString.opt(0)).optString("desc");
      }
      localad = o.bVt();
      paramJSONObject = paramJSONObject.optJSONObject("bindqueryresp");
      localad.qyY.clear();
      if (paramJSONObject == null) {
        y.e("MicroMsg.WalletRepaymentBankcardMgr", "parse from json error,json is null");
      }
    }
    else
    {
      return;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("Array");
    if ((localJSONArray == null) || (localJSONArray.length() <= 0))
    {
      y.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list is null");
      paramString = paramJSONObject.optJSONObject("user_info");
      if (paramString != null) {
        localad.qyZ = paramString.optString("last_card_bind_serialno");
      }
    }
    else
    {
      paramInt = 0;
      while (paramInt < localJSONArray.length())
      {
        d locald = d.bUV();
        try
        {
          paramString = (JSONObject)localJSONArray.get(paramInt);
          if (paramString != null)
          {
            paramString = locald.am(paramString);
            if (paramString.bUQ())
            {
              paramString.field_desc = paramString.field_bankName;
              localad.qyY.add(paramString);
            }
          }
          else
          {
            paramInt += 1;
          }
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.WalletRepaymentBankcardMgr", paramString, "", new Object[0]);
            paramString = null;
            continue;
            if (paramString.bUS()) {
              paramString.field_desc = ae.getContext().getString(a.i.wallet_credit_card_desc, new Object[] { paramString.field_bankName, paramString.field_bankcardTail });
            } else if (paramString.bUP()) {
              paramString.field_desc = ae.getContext().getString(a.i.wallet_wxcredit_card_desc, new Object[] { paramString.field_bankName, paramString.field_bankcardTail });
            } else {
              paramString.field_desc = ae.getContext().getString(a.i.wallet_deposit_card_desc, new Object[] { paramString.field_bankName, paramString.field_bankcardTail });
            }
          }
        }
      }
    }
    y.e("MicroMsg.WalletRepaymentBankcardMgr", "user_info is null");
  }
  
  public final int aEC()
  {
    return 123;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/webankloanordershow";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.b
 * JD-Core Version:    0.7.0.1
 */