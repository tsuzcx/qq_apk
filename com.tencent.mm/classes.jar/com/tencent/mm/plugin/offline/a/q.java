package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.Map;
import org.json.JSONObject;

public final class q
  extends m
{
  public n vtn;
  public ad vto;
  public e vtp;
  public e vtq;
  
  public q(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(174388);
    this.vtn = new n(System.currentTimeMillis(), paramInt1);
    setRequestData(this.vtn.vtm);
    this.vto = new ad(null, 8);
    this.vto.Bpe = true;
    Map localMap = this.vto.vtm;
    localMap.put("event_id", String.valueOf(paramInt2));
    localMap.put("event_feature", paramString);
    addRequestData(localMap);
    setWXRequestData(this.vto.BhX);
    ac.d("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "do offline user bind query");
    AppMethodBeat.o(174388);
  }
  
  private static e az(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66317);
    e locale = new e();
    locale.errMsg = ai.getContext().getString(2131765224);
    String str = ai.getContext().getString(2131765224);
    try
    {
      i = paramJSONObject.getInt("retcode");
      paramJSONObject = paramJSONObject.optString("retmsg");
      if (i != 0)
      {
        ac.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: resolve busi error: retCode is error");
        if (i != -10089)
        {
          locale.e(1000, i, paramJSONObject, 2);
          AppMethodBeat.o(66317);
          return locale;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        ac.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: json resolve error: error when resolving error code : " + paramJSONObject.toString());
        int i = -10089;
        paramJSONObject = str;
        continue;
        locale.e(1000, 2, paramJSONObject, 2);
        continue;
        ac.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: all's OK");
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
    this.vtp = az(paramString);
    this.vtn.onGYNetEnd(this.vtp.errCode, this.vtp.errMsg, paramString);
    paramJSONObject = paramJSONObject.optJSONObject("bindquerynew_resp");
    this.vtq = az(paramJSONObject);
    this.vto.onGYNetEnd(this.vtq.errCode, this.vtq.errMsg, paramJSONObject);
    if (paramString != null)
    {
      paramString = paramString.optString("card_list");
      if (paramString != null) {
        a.aoK(paramString);
      }
      ac.d("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "card_list: %s", new Object[] { paramString });
    }
    AppMethodBeat.o(66316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.q
 * JD-Core Version:    0.7.0.1
 */