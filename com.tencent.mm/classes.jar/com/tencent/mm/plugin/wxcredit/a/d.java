package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends m
{
  public k JPI;
  
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
    Log.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
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
        this.JPI = new k();
        this.JPI.JPM = paramJSONObject.optInt("credit_state");
        this.JPI.JPH = (paramJSONObject.optInt("credit_amount") / 100.0D);
        this.JPI.JPN = (paramJSONObject.optInt("credit_usable") / 100.0D);
        this.JPI.JPO = (paramJSONObject.optInt("bill_amount") / 100.0D);
        this.JPI.JPP = paramJSONObject.optInt("bill_date");
        this.JPI.JPQ = (paramJSONObject.optInt("repay_amount") / 100.0D);
        this.JPI.JPR = (paramJSONObject.optInt("repay_minimum") / 100.0D);
        paramString = this.JPI;
        if (paramJSONObject.optInt("upgrade_amount") != 1) {
          break label525;
        }
        paramString.JPS = bool;
        this.JPI.JPT = paramJSONObject.optInt("bill_month");
        this.JPI.JPU = paramJSONObject.optString("repay_url");
        this.JPI.JPV = paramJSONObject.optString("repay_lasttime");
        this.JPI.JPY = paramJSONObject.optString("lasttime");
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
          this.JPI.JPX = localJSONObject.getString("jump_url");
        } else if ("bill_url".equals(str)) {
          this.JPI.Cpy = localJSONObject.getString("jump_url");
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", paramString, "", new Object[0]);
        AppMethodBeat.o(72304);
        return;
      }
      if ("card_detail_url".equals(str))
      {
        this.JPI.JPW = localJSONObject.getString("jump_url");
      }
      else if ("know_more_url".equals(str))
      {
        this.JPI.JPZ = localJSONObject.getString("jump_url");
        break label518;
        label423:
        paramString = paramJSONObject.getJSONObject("appservice");
        if (paramString != null)
        {
          this.JPI.JQa = new j();
          this.JPI.JQa.JPL = paramString.getString("app_telephone");
          this.JPI.JQa.nickname = paramString.getString("nickname");
          this.JPI.JQa.username = paramString.getString("username");
          this.JPI.JQa.url = paramString.getString("jump_url");
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