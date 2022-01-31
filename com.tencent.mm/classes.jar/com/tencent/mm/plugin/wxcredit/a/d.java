package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.wallet_core.tenpay.model.j
{
  public k rQJ;
  
  public d(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("bind_serialno", paramString1);
    localHashMap.put("bank_type", paramString2);
    localHashMap.put("query_method", "1");
    D(localHashMap);
    paramString1 = new HashMap();
    paramString1.put("banktype", paramString2);
    aC(paramString1);
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = true;
    y.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0) {
      return;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      String str;
      try
      {
        this.rQJ = new k();
        this.rQJ.rQN = paramJSONObject.optInt("credit_state");
        this.rQJ.rQI = (paramJSONObject.optInt("credit_amount") / 100.0D);
        this.rQJ.rQO = (paramJSONObject.optInt("credit_usable") / 100.0D);
        this.rQJ.rQP = (paramJSONObject.optInt("bill_amount") / 100.0D);
        this.rQJ.rQQ = paramJSONObject.optInt("bill_date");
        this.rQJ.rQR = (paramJSONObject.optInt("repay_amount") / 100.0D);
        this.rQJ.rQS = (paramJSONObject.optInt("repay_minimum") / 100.0D);
        paramString = this.rQJ;
        if (paramJSONObject.optInt("upgrade_amount") != 1) {
          break label505;
        }
        paramString.rQT = bool;
        this.rQJ.rQU = paramJSONObject.optInt("bill_month");
        this.rQJ.rQV = paramJSONObject.optString("repay_url");
        this.rQJ.rQW = paramJSONObject.optString("repay_lasttime");
        this.rQJ.rRa = paramJSONObject.optString("lasttime");
        paramString = paramJSONObject.getJSONArray("jump_url_array");
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label408;
        }
        int i = paramString.length();
        paramInt = 0;
        if (paramInt >= i) {
          break label408;
        }
        localJSONObject = paramString.getJSONObject(paramInt);
        str = localJSONObject.getString("jump_name");
        if ("account_rights_url".equals(str)) {
          this.rQJ.rQY = localJSONObject.getString("jump_url");
        } else if ("bill_url".equals(str)) {
          this.rQJ.rQZ = localJSONObject.getString("jump_url");
        }
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", paramString, "", new Object[0]);
        return;
      }
      if ("card_detail_url".equals(str))
      {
        this.rQJ.rQX = localJSONObject.getString("jump_url");
      }
      else if ("know_more_url".equals(str))
      {
        this.rQJ.rRb = localJSONObject.getString("jump_url");
        break label498;
        label408:
        paramString = paramJSONObject.getJSONObject("appservice");
        if (paramString == null) {
          break;
        }
        this.rQJ.rRc = new j();
        this.rQJ.rRc.rQM = paramString.getString("app_telephone");
        this.rQJ.rRc.nickname = paramString.getString("nickname");
        this.rQJ.rRc.username = paramString.getString("username");
        this.rQJ.rRc.url = paramString.getString("jump_url");
        return;
      }
      label498:
      paramInt += 1;
      continue;
      label505:
      bool = false;
    }
  }
  
  public final int aEC()
  {
    return 57;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.d
 * JD-Core Version:    0.7.0.1
 */