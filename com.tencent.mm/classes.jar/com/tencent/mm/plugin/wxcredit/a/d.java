package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends m
{
  public k EGu;
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72303);
    HashMap localHashMap = new HashMap();
    localHashMap.put("bind_serialno", paramString1);
    localHashMap.put("bank_type", paramString2);
    localHashMap.put("query_method", "1");
    setRequestData(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("banktype", paramString2);
    setWXRequestData(paramString1);
    AppMethodBeat.o(72303);
  }
  
  public final int getTenpayCgicmd()
  {
    return 57;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = true;
    AppMethodBeat.i(72304);
    ad.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(72304);
      return;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      String str;
      try
      {
        this.EGu = new k();
        this.EGu.EGy = paramJSONObject.optInt("credit_state");
        this.EGu.EGt = (paramJSONObject.optInt("credit_amount") / 100.0D);
        this.EGu.EGz = (paramJSONObject.optInt("credit_usable") / 100.0D);
        this.EGu.EGA = (paramJSONObject.optInt("bill_amount") / 100.0D);
        this.EGu.EGB = paramJSONObject.optInt("bill_date");
        this.EGu.EGC = (paramJSONObject.optInt("repay_amount") / 100.0D);
        this.EGu.EGD = (paramJSONObject.optInt("repay_minimum") / 100.0D);
        paramString = this.EGu;
        if (paramJSONObject.optInt("upgrade_amount") != 1) {
          break label525;
        }
        paramString.EGE = bool;
        this.EGu.EGF = paramJSONObject.optInt("bill_month");
        this.EGu.EGG = paramJSONObject.optString("repay_url");
        this.EGu.EGH = paramJSONObject.optString("repay_lasttime");
        this.EGu.EGK = paramJSONObject.optString("lasttime");
        paramString = paramJSONObject.getJSONArray("jump_url_array");
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label423;
        }
        int i = paramString.length();
        paramInt = 0;
        if (paramInt >= i) {
          break label423;
        }
        localJSONObject = paramString.getJSONObject(paramInt);
        str = localJSONObject.getString("jump_name");
        if ("account_rights_url".equals(str)) {
          this.EGu.EGJ = localJSONObject.getString("jump_url");
        } else if ("bill_url".equals(str)) {
          this.EGu.xYQ = localJSONObject.getString("jump_url");
        }
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", paramString, "", new Object[0]);
        AppMethodBeat.o(72304);
        return;
      }
      if ("card_detail_url".equals(str))
      {
        this.EGu.EGI = localJSONObject.getString("jump_url");
      }
      else if ("know_more_url".equals(str))
      {
        this.EGu.EGL = localJSONObject.getString("jump_url");
        break label518;
        label423:
        paramString = paramJSONObject.getJSONObject("appservice");
        if (paramString != null)
        {
          this.EGu.EGM = new j();
          this.EGu.EGM.EGx = paramString.getString("app_telephone");
          this.EGu.EGM.nickname = paramString.getString("nickname");
          this.EGu.EGM.username = paramString.getString("username");
          this.EGu.EGM.url = paramString.getString("jump_url");
        }
        AppMethodBeat.o(72304);
        return;
      }
      label518:
      paramInt += 1;
      continue;
      label525:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.d
 * JD-Core Version:    0.7.0.1
 */