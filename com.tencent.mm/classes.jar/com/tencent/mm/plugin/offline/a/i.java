package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i
  extends m
{
  public String czF;
  public String plm;
  private String pln;
  private boolean plo;
  
  public i(Bankcard paramBankcard, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(43397);
    this.plm = "0";
    this.pln = "0";
    this.czF = "";
    this.plo = false;
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
      this.czF = paramBankcard.field_mobile;
      setRequestData(localHashMap);
      AppMethodBeat.o(43397);
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
    AppMethodBeat.i(43398);
    if (paramJSONObject != null)
    {
      this.plm = paramJSONObject.optString("verify_flag");
      this.pln = paramJSONObject.optString("limit_fee");
    }
    AppMethodBeat.o(43398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.i
 * JD-Core Version:    0.7.0.1
 */