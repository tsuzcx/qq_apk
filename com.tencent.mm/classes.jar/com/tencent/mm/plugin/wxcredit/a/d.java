package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends m
{
  public k vHA;
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48659);
    HashMap localHashMap = new HashMap();
    localHashMap.put("bind_serialno", paramString1);
    localHashMap.put("bank_type", paramString2);
    localHashMap.put("query_method", "1");
    setRequestData(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("banktype", paramString2);
    setWXRequestData(paramString1);
    AppMethodBeat.o(48659);
  }
  
  public final int getTenpayCgicmd()
  {
    return 57;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = true;
    AppMethodBeat.i(48660);
    ab.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(48660);
      return;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      String str;
      try
      {
        this.vHA = new k();
        this.vHA.vHE = paramJSONObject.optInt("credit_state");
        this.vHA.vHz = (paramJSONObject.optInt("credit_amount") / 100.0D);
        this.vHA.vHF = (paramJSONObject.optInt("credit_usable") / 100.0D);
        this.vHA.vHG = (paramJSONObject.optInt("bill_amount") / 100.0D);
        this.vHA.vHH = paramJSONObject.optInt("bill_date");
        this.vHA.vHI = (paramJSONObject.optInt("repay_amount") / 100.0D);
        this.vHA.vHJ = (paramJSONObject.optInt("repay_minimum") / 100.0D);
        paramString = this.vHA;
        if (paramJSONObject.optInt("upgrade_amount") != 1) {
          break label525;
        }
        paramString.vHK = bool;
        this.vHA.vHL = paramJSONObject.optInt("bill_month");
        this.vHA.vHM = paramJSONObject.optString("repay_url");
        this.vHA.vHN = paramJSONObject.optString("repay_lasttime");
        this.vHA.vHQ = paramJSONObject.optString("lasttime");
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
          this.vHA.vHP = localJSONObject.getString("jump_url");
        } else if ("bill_url".equals(str)) {
          this.vHA.qkc = localJSONObject.getString("jump_url");
        }
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", paramString, "", new Object[0]);
        AppMethodBeat.o(48660);
        return;
      }
      if ("card_detail_url".equals(str))
      {
        this.vHA.vHO = localJSONObject.getString("jump_url");
      }
      else if ("know_more_url".equals(str))
      {
        this.vHA.vHR = localJSONObject.getString("jump_url");
        break label518;
        label423:
        paramString = paramJSONObject.getJSONObject("appservice");
        if (paramString != null)
        {
          this.vHA.vHS = new j();
          this.vHA.vHS.vHD = paramString.getString("app_telephone");
          this.vHA.vHS.nickname = paramString.getString("nickname");
          this.vHA.vHS.username = paramString.getString("username");
          this.vHA.vHS.url = paramString.getString("jump_url");
        }
        AppMethodBeat.o(48660);
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