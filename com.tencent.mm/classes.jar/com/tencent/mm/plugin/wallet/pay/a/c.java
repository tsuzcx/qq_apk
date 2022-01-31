package com.tencent.mm.plugin.wallet.pay.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
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
  public String ppp;
  public double qjN;
  
  public c(String paramString)
  {
    AppMethodBeat.i(45919);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", paramString);
    setRequestData(localHashMap);
    AppMethodBeat.o(45919);
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
    AppMethodBeat.i(45920);
    if (paramInt == 0)
    {
      this.ppp = paramJSONObject.optString("fee_type");
      this.qjN = (paramJSONObject.optDouble("total_fee") / 100.0D);
      paramString = paramJSONObject.optJSONArray("Array");
      if ((paramString != null) && (paramString.length() > 0)) {
        this.desc = ((JSONObject)paramString.opt(0)).optString("desc");
      }
      aj localaj = t.cTO();
      paramJSONObject = paramJSONObject.optJSONObject("bindqueryresp");
      localaj.ulH.clear();
      if (paramJSONObject == null)
      {
        ab.e("MicroMsg.WalletRepaymentBankcardMgr", "parse from json error,json is null");
        AppMethodBeat.o(45920);
        return;
      }
      JSONArray localJSONArray = paramJSONObject.optJSONArray("Array");
      if ((localJSONArray == null) || (localJSONArray.length() <= 0))
      {
        ab.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list is null");
        paramString = paramJSONObject.optJSONObject("user_info");
        if (paramString != null)
        {
          localaj.ulI = paramString.optString("last_card_bind_serialno");
          AppMethodBeat.o(45920);
        }
      }
      else
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          f localf = f.cTl();
          try
          {
            paramString = (JSONObject)localJSONArray.get(paramInt);
            if (paramString != null)
            {
              paramString = localf.aw(paramString);
              if (paramString.cTf())
              {
                paramString.field_desc = paramString.field_bankName;
                localaj.ulH.add(paramString);
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
              ab.printErrStackTrace("MicroMsg.WalletRepaymentBankcardMgr", paramString, "", new Object[0]);
              paramString = null;
              continue;
              if (paramString.cTh()) {
                paramString.field_desc = ah.getContext().getString(2131305030, new Object[] { paramString.field_bankName, paramString.field_bankcardTail });
              } else if (paramString.cTe()) {
                paramString.field_desc = ah.getContext().getString(2131305778, new Object[] { paramString.field_bankName, paramString.field_bankcardTail });
              } else {
                paramString.field_desc = ah.getContext().getString(2131305050, new Object[] { paramString.field_bankName, paramString.field_bankcardTail });
              }
            }
          }
        }
      }
      ab.e("MicroMsg.WalletRepaymentBankcardMgr", "user_info is null");
    }
    AppMethodBeat.o(45920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a.c
 * JD-Core Version:    0.7.0.1
 */