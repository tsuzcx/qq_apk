package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.Map;
import org.json.JSONObject;

public final class q
  extends m
{
  public n AJW;
  public ad AJX;
  public e AJY;
  public e AJZ;
  
  public q(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(213612);
    this.AJW = new n(System.currentTimeMillis(), paramInt1);
    setRequestData(this.AJW.AJV);
    this.AJX = new ad(null, 8);
    this.AJX.HQr = true;
    Map localMap = this.AJX.AJV;
    localMap.put("event_id", String.valueOf(paramInt2));
    localMap.put("event_feature", paramString);
    localMap.put("is_first_show", String.valueOf(paramInt3));
    addRequestData(localMap);
    setWXRequestData(this.AJX.HFF);
    Log.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "do offline user bind query");
    AppMethodBeat.o(213612);
  }
  
  public q(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(213613);
    this.AJW = new n(System.currentTimeMillis(), paramInt1);
    setRequestData(this.AJW.AJV);
    this.AJX = new ad(null, 8);
    this.AJX.HQr = true;
    Map localMap = this.AJX.AJV;
    localMap.put("event_id", String.valueOf(paramInt2));
    localMap.put("event_feature", paramString1);
    localMap.put("package", paramString3);
    localMap.put("appId", paramString2);
    addRequestData(localMap);
    setWXRequestData(this.AJX.HFF);
    Log.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "do offline user bind query");
    AppMethodBeat.o(213613);
  }
  
  public q(String paramString)
  {
    AppMethodBeat.i(213611);
    this.AJW = new n(System.currentTimeMillis(), 13);
    setRequestData(this.AJW.AJV);
    this.AJX = new ad(null, 8);
    this.AJX.HQr = true;
    Map localMap = this.AJX.AJV;
    localMap.put("event_id", "0");
    localMap.put("event_feature", paramString);
    addRequestData(localMap);
    setWXRequestData(this.AJX.HFF);
    Log.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "do offline user bind query");
    AppMethodBeat.o(213611);
  }
  
  private static e be(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66317);
    e locale = new e();
    locale.errMsg = MMApplicationContext.getContext().getString(2131767667);
    String str = MMApplicationContext.getContext().getString(2131767667);
    try
    {
      i = paramJSONObject.getInt("retcode");
      paramJSONObject = paramJSONObject.optString("retmsg");
      if (i != 0)
      {
        Log.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: resolve busi error: retCode is error");
        if (i != -10089)
        {
          locale.f(1000, i, paramJSONObject, 2);
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
        locale.f(1000, 2, paramJSONObject, 2);
        continue;
        Log.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: all's OK");
      }
    }
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
    this.AJY = be(paramString);
    this.AJW.onGYNetEnd(this.AJY.errCode, this.AJY.errMsg, paramString);
    paramJSONObject = paramJSONObject.optJSONObject("bindquerynew_resp");
    this.AJZ = be(paramJSONObject);
    this.AJX.onGYNetEnd(this.AJZ.errCode, this.AJZ.errMsg, paramJSONObject);
    if (paramString != null)
    {
      paramString = paramString.optString("card_list");
      if (paramString != null) {
        a.aJl(paramString);
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