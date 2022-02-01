package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.Map;
import org.json.JSONObject;

public final class q
  extends m
{
  public n GDd;
  public ae GDe;
  public e GDf;
  public e GDg;
  
  public q(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(273530);
    this.GDd = new n(System.currentTimeMillis(), paramInt1);
    setRequestData(this.GDd.ECl);
    this.GDe = new ae(null, 8);
    this.GDe.OIA = true;
    Map localMap = this.GDe.ECl;
    localMap.put("event_id", String.valueOf(paramInt2));
    localMap.put("event_feature", paramString);
    localMap.put("is_first_show", String.valueOf(paramInt3));
    addRequestData(localMap);
    setWXRequestData(this.GDe.Oxy);
    Log.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "do offline user bind query");
    AppMethodBeat.o(273530);
  }
  
  public q(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(273531);
    this.GDd = new n(System.currentTimeMillis(), paramInt1);
    setRequestData(this.GDd.ECl);
    this.GDe = new ae(null, 8);
    this.GDe.OIA = true;
    Map localMap = this.GDe.ECl;
    localMap.put("event_id", String.valueOf(paramInt2));
    localMap.put("event_feature", paramString1);
    localMap.put("package", paramString3);
    localMap.put("appId", paramString2);
    addRequestData(localMap);
    setWXRequestData(this.GDe.Oxy);
    Log.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "do offline user bind query");
    AppMethodBeat.o(273531);
  }
  
  public q(String paramString)
  {
    AppMethodBeat.i(273529);
    this.GDd = new n(System.currentTimeMillis(), 13);
    setRequestData(this.GDd.ECl);
    this.GDe = new ae(null, 8);
    this.GDe.OIA = true;
    Map localMap = this.GDe.ECl;
    localMap.put("event_id", "0");
    localMap.put("event_feature", paramString);
    addRequestData(localMap);
    setWXRequestData(this.GDe.Oxy);
    Log.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "do offline user bind query");
    AppMethodBeat.o(273529);
  }
  
  private static e bl(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66317);
    e locale = new e();
    locale.errMsg = MMApplicationContext.getContext().getString(a.i.wallet_data_err);
    String str = MMApplicationContext.getContext().getString(a.i.wallet_data_err);
    try
    {
      i = paramJSONObject.getInt("retcode");
      paramJSONObject = paramJSONObject.optString("retmsg");
      if (i != 0)
      {
        Log.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: resolve busi error: retCode is error");
        if (i != -10089)
        {
          locale.i(1000, i, paramJSONObject, 2);
          AppMethodBeat.o(66317);
          return locale;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        Log.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: json resolve error: error when resolving error code : " + paramJSONObject.toString());
        int i = -10089;
        paramJSONObject = str;
        continue;
        locale.i(1000, 2, paramJSONObject, 2);
        continue;
        Log.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: all's OK");
      }
    }
  }
  
  public static boolean isEnabled()
  {
    AppMethodBeat.i(66318);
    AppMethodBeat.o(66318);
    return true;
  }
  
  public final int getFuncId()
  {
    return 1742;
  }
  
  public final int getTenpayCgicmd()
  {
    return 1742;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/offlineuserbindquery";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66316);
    if (paramInt != 0)
    {
      AppMethodBeat.o(66316);
      return;
    }
    paramString = paramJSONObject.optJSONObject("queryuser_resp");
    this.GDf = bl(paramString);
    this.GDd.onGYNetEnd(this.GDf.errCode, this.GDf.errMsg, paramString);
    paramJSONObject = paramJSONObject.optJSONObject("bindquerynew_resp");
    this.GDg = bl(paramJSONObject);
    this.GDe.onGYNetEnd(this.GDg.errCode, this.GDg.errMsg, paramJSONObject);
    if (paramString != null)
    {
      paramString = paramString.optString("card_list");
      if (paramString != null) {
        a.aTH(paramString);
      }
      Log.d("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "card_list: %s", new Object[] { paramString });
    }
    AppMethodBeat.o(66316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.q
 * JD-Core Version:    0.7.0.1
 */