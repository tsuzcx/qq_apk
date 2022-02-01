package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class ak
  extends m
{
  public String OIC;
  public String OID;
  public String OIE;
  public String OIF;
  public String OIG;
  public int OIH;
  public int OII;
  private long mcX;
  public String oFx;
  
  public ak()
  {
    AppMethodBeat.i(69963);
    setRequestData(null);
    AppMethodBeat.o(69963);
  }
  
  public static boolean a(boolean paramBoolean, i parami)
  {
    AppMethodBeat.i(69965);
    h.aHH();
    long l = ((Long)h.aHG().aHp().get(ar.a.VnQ, Long.valueOf(0L))).longValue();
    if ((paramBoolean) || (l < System.currentTimeMillis()))
    {
      Log.i("MicroMsg.NetSceneTransferWording", "do scene: %d, force: %B", new Object[] { Long.valueOf(l), Boolean.valueOf(paramBoolean) });
      if (parami != null) {
        parami.a(new ak(), false, 1);
      }
      for (;;)
      {
        AppMethodBeat.o(69965);
        return true;
        h.aHH();
        h.aHF().kcd.a(new ak(), 0);
      }
    }
    Log.d("MicroMsg.NetSceneTransferWording", "not time");
    AppMethodBeat.o(69965);
    return false;
  }
  
  public final int getFuncId()
  {
    return 1992;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/gettransferwording";
  }
  
  public final boolean isBlock()
  {
    return false;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69964);
    Log.i("MicroMsg.NetSceneTransferWording", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    Log.d("MicroMsg.NetSceneTransferWording", "json: %s", new Object[] { paramJSONObject });
    this.oFx = paramJSONObject.optString("delay_confirm_wording");
    this.OIC = paramJSONObject.optString("delay_confirm_switch_wording");
    this.OID = paramJSONObject.optString("delay_confirm_switch_remind_wording");
    this.OIE = paramJSONObject.optString("delay_confirm_switch_remind_half_page_wording");
    this.OIF = paramJSONObject.optString("delay_confirm_desc_url");
    this.OIH = paramJSONObject.optInt("delay_confirm_desc_url_flag", 0);
    this.mcX = (paramJSONObject.optLong("expire_time", 0L) * 1000L);
    this.OII = paramJSONObject.optInt("delay_confirm_switch_flag", 0);
    h.aHH();
    paramString = h.aHG().aHp();
    if (!Util.isNullOrNil(this.oFx)) {
      paramString.set(ar.a.VnM, this.oFx);
    }
    if (!Util.isNullOrNil(this.OIC)) {
      paramString.set(ar.a.VnN, this.OIC);
    }
    if (!Util.isNullOrNil(this.OID)) {
      paramString.set(ar.a.VnO, this.OID);
    }
    if (!Util.isNullOrNil(this.OIE)) {
      paramString.set(ar.a.VnP, this.OIE);
    }
    if (!Util.isNullOrNil(this.OIF)) {}
    try
    {
      this.OIG = URLDecoder.decode(this.OIF, "UTF-8");
      if (!Util.isNullOrNil(this.OIG)) {
        paramString.set(ar.a.VnR, this.OIG);
      }
      paramString.set(ar.a.VnS, Integer.valueOf(this.OIH));
      paramString.set(ar.a.VnQ, Long.valueOf(this.mcX));
      paramString.set(ar.a.VnT, Integer.valueOf(this.OII));
      if (this.OII == 0)
      {
        Log.i("MicroMsg.NetSceneTransferWording", "do reset oplog");
        paramJSONObject = new cyu();
        paramJSONObject.Iza = 0;
        ((n)h.ae(n.class)).bbK().d(new k.a(205, paramJSONObject));
        paramString.i(147457, Long.valueOf(((Long)paramString.b(147457, Long.valueOf(0L))).longValue() & 0xFFFFFFEF & 0xFFFFFFDF));
      }
      AppMethodBeat.o(69964);
      return;
    }
    catch (UnsupportedEncodingException paramJSONObject)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneTransferWording", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ak
 * JD-Core Version:    0.7.0.1
 */