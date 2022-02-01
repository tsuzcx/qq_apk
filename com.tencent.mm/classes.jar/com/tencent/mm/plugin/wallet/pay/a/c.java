package com.tencent.mm.plugin.wallet.pay.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends m
{
  public String desc;
  public String uop;
  public double vAP;
  
  public c(String paramString)
  {
    AppMethodBeat.i(69262);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(69262);
  }
  
  public final int getFuncId()
  {
    return 1603;
  }
  
  public final int getTenpayCgicmd()
  {
    return 123;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/webankloanordershow";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69263);
    if (paramInt == 0)
    {
      this.uop = paramJSONObject.optString("fee_type");
      this.vAP = (paramJSONObject.optDouble("total_fee") / 100.0D);
      paramString = paramJSONObject.optJSONArray("Array");
      if ((paramString != null) && (paramString.length() > 0)) {
        this.desc = ((JSONObject)paramString.opt(0)).optString("desc");
      }
      com.tencent.mm.plugin.wallet_core.model.aj localaj = s.ecd();
      paramJSONObject = paramJSONObject.optJSONObject("bindqueryresp");
      localaj.Aib.clear();
      if (paramJSONObject == null)
      {
        ad.e("MicroMsg.WalletRepaymentBankcardMgr", "parse from json error,json is null");
        AppMethodBeat.o(69263);
        return;
      }
      JSONArray localJSONArray = paramJSONObject.optJSONArray("Array");
      if ((localJSONArray == null) || (localJSONArray.length() <= 0))
      {
        ad.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list is null");
        paramString = paramJSONObject.optJSONObject("user_info");
        if (paramString != null)
        {
          localaj.Aic = paramString.optString("last_card_bind_serialno");
          AppMethodBeat.o(69263);
        }
      }
      else
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          d locald = d.ebB();
          try
          {
            paramString = (JSONObject)localJSONArray.get(paramInt);
            if (paramString != null)
            {
              paramString = locald.aR(paramString);
              if (paramString.ebv())
              {
                paramString.field_desc = paramString.field_bankName;
                localaj.Aib.add(paramString);
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
              ad.printErrStackTrace("MicroMsg.WalletRepaymentBankcardMgr", paramString, "", new Object[0]);
              paramString = null;
              continue;
              if (paramString.ebx()) {
                paramString.field_desc = com.tencent.mm.sdk.platformtools.aj.getContext().getString(2131765222, new Object[] { paramString.field_bankName, paramString.field_bankcardTail });
              } else if (paramString.ebu()) {
                paramString.field_desc = com.tencent.mm.sdk.platformtools.aj.getContext().getString(2131765998, new Object[] { paramString.field_bankName, paramString.field_bankcardTail });
              } else {
                paramString.field_desc = com.tencent.mm.sdk.platformtools.aj.getContext().getString(2131765242, new Object[] { paramString.field_bankName, paramString.field_bankcardTail });
              }
            }
          }
        }
      }
      ad.e("MicroMsg.WalletRepaymentBankcardMgr", "user_info is null");
    }
    AppMethodBeat.o(69263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.c
 * JD-Core Version:    0.7.0.1
 */