package com.tencent.mm.plugin.wallet.bind.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
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
  public boolean cLN;
  public ArrayList<Bankcard> tNG;
  public boolean tSs;
  public String tSt;
  public String tSu;
  private String tSv;
  public String token;
  
  public c(String paramString, PayInfo paramPayInfo)
  {
    AppMethodBeat.i(45728);
    this.tSs = true;
    this.tNG = null;
    this.cLN = false;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    setPayInfo(paramPayInfo, localHashMap1, localHashMap2);
    g.RM();
    paramPayInfo = new p(bo.a((Integer)g.RL().Ru().get(9, null), 0));
    this.tSv = paramString;
    localHashMap1.put("import_code", paramString);
    localHashMap1.put("qqid", paramPayInfo.toString());
    setRequestData(localHashMap1);
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(45728);
  }
  
  public final int getTenpayCgicmd()
  {
    return 37;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(45729);
    if (paramInt != 0)
    {
      AppMethodBeat.o(45729);
      return;
    }
    this.tNG = new ArrayList();
    for (;;)
    {
      try
      {
        this.cLN = "1".equals(paramJSONObject.optString("is_reg", "0"));
        this.token = paramJSONObject.optString("token", "");
        paramString = paramJSONObject.getJSONArray("Array");
        int j = paramString.length();
        paramInt = 0;
        if (paramInt >= j) {
          break label424;
        }
        JSONObject localJSONObject = paramString.getJSONObject(paramInt);
        paramJSONObject = f.cTl().aw(localJSONObject);
        if (paramJSONObject == null) {
          break label472;
        }
        if (2 != localJSONObject.optInt("bank_acc_type", 2)) {
          break label479;
        }
        i = 1;
        if (i != 0) {
          paramJSONObject.field_cardType |= Bankcard.ufz;
        }
        paramJSONObject.field_bankcardTail = localJSONObject.optString("bank_tail");
        paramJSONObject.ufI = ("************" + paramJSONObject.field_bankcardTail);
        paramJSONObject.field_trueName = localJSONObject.optString("true_name");
        paramJSONObject.ufH = localJSONObject.optString("cre_id");
        paramJSONObject.ueY = localJSONObject.optInt("cre_type", -1);
        paramJSONObject.ufU = this.tSv;
        if (1 != localJSONObject.optInt("samecardexist", 0)) {
          break label485;
        }
        bool = true;
        paramJSONObject.ufV = bool;
        if (paramJSONObject.cTf())
        {
          paramJSONObject.field_desc = paramJSONObject.field_bankName;
          localJSONObject = localJSONObject.optJSONObject("bankappservice");
          if (localJSONObject != null)
          {
            this.tSt = localJSONObject.optString("username");
            this.tSu = localJSONObject.optString("app_recommend_desc");
          }
          this.tNG.add(paramJSONObject);
          break label472;
        }
        if (paramJSONObject.cTh())
        {
          paramJSONObject.field_desc = ah.getContext().getString(2131305030, new Object[] { paramJSONObject.field_bankName, paramJSONObject.field_bankcardTail });
          continue;
        }
        if (!paramJSONObject.cTe()) {
          break label390;
        }
      }
      catch (JSONException paramString)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneTenpayQueryBindBankcard", paramString, "", new Object[0]);
        AppMethodBeat.o(45729);
        return;
      }
      paramJSONObject.field_desc = ah.getContext().getString(2131305778, new Object[] { paramJSONObject.field_bankName, paramJSONObject.field_bankcardTail });
      continue;
      label390:
      paramJSONObject.field_desc = ah.getContext().getString(2131305050, new Object[] { paramJSONObject.field_bankName, paramJSONObject.field_bankcardTail });
      continue;
      label424:
      ab.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "got data---isReg:" + this.cLN + ",bankcard.size:" + this.tNG.size());
      AppMethodBeat.o(45729);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.a.c
 * JD-Core Version:    0.7.0.1
 */