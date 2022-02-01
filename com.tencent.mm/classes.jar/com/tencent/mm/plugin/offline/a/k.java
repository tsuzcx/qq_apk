package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends m
{
  public String MyP;
  private String MyQ;
  private boolean MyR;
  public String hRk;
  
  public k(Bankcard paramBankcard, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(66296);
    this.MyP = "0";
    this.MyQ = "0";
    this.hRk = "";
    this.MyR = false;
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("oper", paramString2);
    if (paramString2.equals("changeto"))
    {
      if (!TextUtils.isEmpty(paramString3)) {
        break label169;
      }
      localHashMap.put("verify_code", "");
    }
    for (;;)
    {
      localHashMap.put("chg_fee", String.valueOf(paramInt));
      localHashMap.put("bind_serialno", paramBankcard.field_bindSerial);
      localHashMap.put("bank_type", paramBankcard.field_bankcardType);
      localHashMap.put("card_tail", paramBankcard.field_bankcardTail);
      this.hRk = paramBankcard.field_mobile;
      setRequestData(localHashMap);
      AppMethodBeat.o(66296);
      return;
      label169:
      localHashMap.put("verify_code", paramString3);
    }
  }
  
  public final int getTenpayCgicmd()
  {
    return 50;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66297);
    if (paramJSONObject != null)
    {
      this.MyP = paramJSONObject.optString("verify_flag");
      this.MyQ = paramJSONObject.optString("limit_fee");
    }
    AppMethodBeat.o(66297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.k
 * JD-Core Version:    0.7.0.1
 */