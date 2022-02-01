package com.tencent.mm.plugin.wallet.bind.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
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
  public ArrayList<Bankcard> AYt;
  public boolean BeU;
  public String BeV;
  public String BeW;
  private String BeX;
  public boolean dAx;
  public String token;
  
  public c(String paramString, PayInfo paramPayInfo)
  {
    AppMethodBeat.i(69065);
    this.BeU = true;
    this.AYt = null;
    this.dAx = false;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    setPayInfo(paramPayInfo, localHashMap1, localHashMap2);
    g.agS();
    paramPayInfo = new p(bs.a((Integer)g.agR().agA().get(9, null), 0));
    this.BeX = paramString;
    localHashMap1.put("import_code", paramString);
    localHashMap1.put("qqid", paramPayInfo.toString());
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(69065);
  }
  
  public final int getTenpayCgicmd()
  {
    return 37;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69066);
    if (paramInt != 0)
    {
      AppMethodBeat.o(69066);
      return;
    }
    this.AYt = new ArrayList();
    for (;;)
    {
      try
      {
        this.dAx = "1".equals(paramJSONObject.optString("is_reg", "0"));
        this.token = paramJSONObject.optString("token", "");
        paramString = paramJSONObject.getJSONArray("Array");
        int j = paramString.length();
        paramInt = 0;
        if (paramInt >= j) {
          break label424;
        }
        JSONObject localJSONObject = paramString.getJSONObject(paramInt);
        paramJSONObject = d.eqX().aS(localJSONObject);
        if (paramJSONObject == null) {
          break label472;
        }
        if (2 != localJSONObject.optInt("bank_acc_type", 2)) {
          break label479;
        }
        i = 1;
        if (i != 0) {
          paramJSONObject.field_cardType |= Bankcard.Bub;
        }
        paramJSONObject.field_bankcardTail = localJSONObject.optString("bank_tail");
        paramJSONObject.Buk = ("************" + paramJSONObject.field_bankcardTail);
        paramJSONObject.field_trueName = localJSONObject.optString("true_name");
        paramJSONObject.Buj = localJSONObject.optString("cre_id");
        paramJSONObject.BtC = localJSONObject.optInt("cre_type", -1);
        paramJSONObject.Bux = this.BeX;
        if (1 != localJSONObject.optInt("samecardexist", 0)) {
          break label485;
        }
        bool = true;
        paramJSONObject.Buy = bool;
        if (paramJSONObject.eqR())
        {
          paramJSONObject.field_desc = paramJSONObject.field_bankName;
          localJSONObject = localJSONObject.optJSONObject("bankappservice");
          if (localJSONObject != null)
          {
            this.BeV = localJSONObject.optString("username");
            this.BeW = localJSONObject.optString("app_recommend_desc");
          }
          this.AYt.add(paramJSONObject);
          break label472;
        }
        if (paramJSONObject.eqT())
        {
          paramJSONObject.field_desc = ai.getContext().getString(2131765222, new Object[] { paramJSONObject.field_bankName, paramJSONObject.field_bankcardTail });
          continue;
        }
        if (!paramJSONObject.eqQ()) {
          break label390;
        }
      }
      catch (JSONException paramString)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneTenpayQueryBindBankcard", paramString, "", new Object[0]);
        AppMethodBeat.o(69066);
        return;
      }
      paramJSONObject.field_desc = ai.getContext().getString(2131765998, new Object[] { paramJSONObject.field_bankName, paramJSONObject.field_bankcardTail });
      continue;
      label390:
      paramJSONObject.field_desc = ai.getContext().getString(2131765242, new Object[] { paramJSONObject.field_bankName, paramJSONObject.field_bankcardTail });
      continue;
      label424:
      ac.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "got data---isReg:" + this.dAx + ",bankcard.size:" + this.AYt.size());
      AppMethodBeat.o(69066);
      return;
      label472:
      paramInt += 1;
      continue;
      label479:
      int i = 0;
      continue;
      label485:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.a.c
 * JD-Core Version:    0.7.0.1
 */