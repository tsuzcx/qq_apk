package com.tencent.mm.plugin.offline.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.offline.c.c;
import com.tencent.mm.plugin.offline.c.d;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.e;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.Map;
import org.json.JSONObject;

public final class s
  extends m
{
  public p Mzo;
  public ae Mzp;
  public e Mzq;
  public e Mzr;
  public String Mzs;
  
  public s(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(269122);
    this.Mzo = new p(System.currentTimeMillis(), paramInt1);
    setRequestData(this.Mzo.Kvm);
    this.Mzp = new ae(null, 8);
    this.Mzp.Vym = true;
    Map localMap = this.Mzp.Kvm;
    localMap.put("event_id", String.valueOf(paramInt2));
    localMap.put("event_feature", paramString);
    localMap.put("is_first_show", String.valueOf(paramInt3));
    localMap.put("is_new_authcodes", d.gxe());
    paramString = c.MDa;
    paramString = c.gwy();
    if (paramString != null)
    {
      localMap.put("prefer_bind_serial", paramString.field_bindSerial);
      localMap.put("prefer_bank_type", paramString.field_bankcardType);
    }
    addRequestData(localMap);
    setWXRequestData(this.Mzp.VmJ);
    Log.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "do offline user bind query");
    AppMethodBeat.o(269122);
  }
  
  public s(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(269124);
    this.Mzo = new p(System.currentTimeMillis(), paramInt1);
    setRequestData(this.Mzo.Kvm);
    this.Mzp = new ae(null, 8);
    this.Mzp.Vym = true;
    Map localMap = this.Mzp.Kvm;
    localMap.put("event_id", String.valueOf(paramInt2));
    localMap.put("event_feature", paramString1);
    localMap.put("package", paramString3);
    localMap.put("appId", paramString2);
    localMap.put("is_new_authcodes", d.gxe());
    paramString1 = c.MDa;
    paramString1 = c.gwy();
    if (paramString1 != null)
    {
      localMap.put("prefer_bind_serial", paramString1.field_bindSerial);
      localMap.put("prefer_bank_type", paramString1.field_bankcardType);
    }
    addRequestData(localMap);
    setWXRequestData(this.Mzp.VmJ);
    Log.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "do offline user bind query");
    AppMethodBeat.o(269124);
  }
  
  public s(String paramString)
  {
    AppMethodBeat.i(269121);
    this.Mzo = new p(System.currentTimeMillis(), 13);
    setRequestData(this.Mzo.Kvm);
    this.Mzp = new ae(null, 8);
    this.Mzp.Vym = true;
    Map localMap = this.Mzp.Kvm;
    localMap.put("event_id", "0");
    localMap.put("event_feature", paramString);
    localMap.put("is_new_authcodes", d.gxe());
    paramString = c.MDa;
    paramString = c.gwy();
    if (paramString != null)
    {
      localMap.put("prefer_bind_serial", paramString.field_bindSerial);
      localMap.put("prefer_bank_type", paramString.field_bankcardType);
    }
    addRequestData(localMap);
    setWXRequestData(this.Mzp.VmJ);
    Log.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "do offline user bind query");
    AppMethodBeat.o(269121);
  }
  
  private static e bC(JSONObject paramJSONObject)
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
          locale.g(1000, i, paramJSONObject, 2);
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
        locale.g(1000, 2, paramJSONObject, 2);
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
    paramString = paramJSONObject.optJSONObject("jump_info");
    if (paramString != null)
    {
      h.baF();
      h.baE().ban().set(at.a.adhQ, paramString.toString());
    }
    while (paramInt != 0)
    {
      AppMethodBeat.o(66316);
      return;
      h.baF();
      h.baE().ban().set(at.a.adhQ, "");
    }
    paramString = paramJSONObject.optJSONObject("queryuser_resp");
    this.Mzq = bC(paramString);
    this.Mzo.onGYNetEnd(this.Mzq.errCode, this.Mzq.errMsg, paramString);
    paramJSONObject = paramJSONObject.optJSONObject("bindquerynew_resp");
    this.Mzr = bC(paramJSONObject);
    this.Mzp.onGYNetEnd(this.Mzr.errCode, this.Mzr.errMsg, paramJSONObject);
    if (paramString != null)
    {
      paramJSONObject = paramString.optString("card_list");
      if (paramJSONObject != null) {
        d.aQM(paramJSONObject);
      }
      Log.d("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "card_list: %s", new Object[] { paramJSONObject });
      paramJSONObject = paramString.optJSONObject("prefer_card");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optString("bind_serial");
        if (!Util.isNullOrNil(paramJSONObject))
        {
          com.tencent.mm.plugin.wallet.model.p.ifO();
          com.tencent.mm.plugin.wallet.model.p.ifP();
          am.bgJ(paramJSONObject);
          paramJSONObject = c.MDa;
          if (c.gwz())
          {
            paramJSONObject = c.MDa;
            c.reload();
          }
        }
      }
      this.Mzs = paramString.optString("prefer_card_changed_wording");
    }
    AppMethodBeat.o(66316);
  }
  
  public final boolean shouldResolveJsonWhenError()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.s
 * JD-Core Version:    0.7.0.1
 */