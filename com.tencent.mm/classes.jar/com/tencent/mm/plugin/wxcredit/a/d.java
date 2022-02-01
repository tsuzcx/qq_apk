package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends m
{
  public k EYQ;
  
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
    ae.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
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
        this.EYQ = new k();
        this.EYQ.EYU = paramJSONObject.optInt("credit_state");
        this.EYQ.EYP = (paramJSONObject.optInt("credit_amount") / 100.0D);
        this.EYQ.EYV = (paramJSONObject.optInt("credit_usable") / 100.0D);
        this.EYQ.EYW = (paramJSONObject.optInt("bill_amount") / 100.0D);
        this.EYQ.EYX = paramJSONObject.optInt("bill_date");
        this.EYQ.EYY = (paramJSONObject.optInt("repay_amount") / 100.0D);
        this.EYQ.EYZ = (paramJSONObject.optInt("repay_minimum") / 100.0D);
        paramString = this.EYQ;
        if (paramJSONObject.optInt("upgrade_amount") != 1) {
          break label525;
        }
        paramString.EZa = bool;
        this.EYQ.EZb = paramJSONObject.optInt("bill_month");
        this.EYQ.EZc = paramJSONObject.optString("repay_url");
        this.EYQ.EZd = paramJSONObject.optString("repay_lasttime");
        this.EYQ.EZg = paramJSONObject.optString("lasttime");
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
          this.EYQ.EZf = localJSONObject.getString("jump_url");
        } else if ("bill_url".equals(str)) {
          this.EYQ.yoI = localJSONObject.getString("jump_url");
        }
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", paramString, "", new Object[0]);
        AppMethodBeat.o(72304);
        return;
      }
      if ("card_detail_url".equals(str))
      {
        this.EYQ.EZe = localJSONObject.getString("jump_url");
      }
      else if ("know_more_url".equals(str))
      {
        this.EYQ.EZh = localJSONObject.getString("jump_url");
        break label518;
        label423:
        paramString = paramJSONObject.getJSONObject("appservice");
        if (paramString != null)
        {
          this.EYQ.EZi = new j();
          this.EYQ.EZi.EYT = paramString.getString("app_telephone");
          this.EYQ.EZi.nickname = paramString.getString("nickname");
          this.EYQ.EZi.username = paramString.getString("username");
          this.EYQ.EZi.url = paramString.getString("jump_url");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.d
 * JD-Core Version:    0.7.0.1
 */