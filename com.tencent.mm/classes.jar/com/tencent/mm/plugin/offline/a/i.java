package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i
  extends j
{
  public String bSe = "";
  public String mKV = "0";
  private String mKW = "0";
  private boolean mKX = false;
  
  public i(Bankcard paramBankcard, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("passwd", paramString1);
    localHashMap.put("oper", paramString2);
    if (paramString2.equals("changeto"))
    {
      if (!TextUtils.isEmpty(paramString3)) {
        break label159;
      }
      localHashMap.put("verify_code", "");
    }
    for (;;)
    {
      localHashMap.put("chg_fee", String.valueOf(paramInt));
      localHashMap.put("bind_serialno", paramBankcard.field_bindSerial);
      localHashMap.put("bank_type", paramBankcard.field_bankcardType);
      localHashMap.put("card_tail", paramBankcard.field_bankcardTail);
      this.bSe = paramBankcard.field_mobile;
      D(localHashMap);
      return;
      label159:
      localHashMap.put("verify_code", paramString3);
    }
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.mKV = paramJSONObject.optString("verify_flag");
      this.mKW = paramJSONObject.optString("limit_fee");
    }
  }
  
  public final int aEC()
  {
    return 50;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.i
 * JD-Core Version:    0.7.0.1
 */