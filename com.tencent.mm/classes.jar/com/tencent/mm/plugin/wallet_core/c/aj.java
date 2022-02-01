package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cqd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class aj
  extends m
{
  public int HQA;
  public String HQv;
  public String HQw;
  public String HQx;
  public String HQy;
  public int HQz;
  private long jmW;
  public String lJj;
  
  public aj()
  {
    AppMethodBeat.i(69963);
    setRequestData(null);
    AppMethodBeat.o(69963);
  }
  
  public static boolean a(boolean paramBoolean, i parami)
  {
    AppMethodBeat.i(69965);
    g.aAi();
    long l = ((Long)g.aAh().azQ().get(ar.a.NZP, Long.valueOf(0L))).longValue();
    if ((paramBoolean) || (l < System.currentTimeMillis()))
    {
      Log.i("MicroMsg.NetSceneTransferWording", "do scene: %d, force: %B", new Object[] { Long.valueOf(l), Boolean.valueOf(paramBoolean) });
      if (parami != null) {
        parami.a(new aj(), false, 1);
      }
      for (;;)
      {
        AppMethodBeat.o(69965);
        return true;
        g.aAi();
        g.aAg().hqi.a(new aj(), 0);
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
    this.lJj = paramJSONObject.optString("delay_confirm_wording");
    this.HQv = paramJSONObject.optString("delay_confirm_switch_wording");
    this.HQw = paramJSONObject.optString("delay_confirm_switch_remind_wording");
    this.HQx = paramJSONObject.optString("delay_confirm_desc_url");
    this.HQz = paramJSONObject.optInt("delay_confirm_desc_url_flag", 0);
    this.jmW = (paramJSONObject.optLong("expire_time", 0L) * 1000L);
    this.HQA = paramJSONObject.optInt("delay_confirm_switch_flag", 0);
    g.aAi();
    paramString = g.aAh().azQ();
    if (!Util.isNullOrNil(this.lJj)) {
      paramString.set(ar.a.NZM, this.lJj);
    }
    if (!Util.isNullOrNil(this.HQv)) {
      paramString.set(ar.a.NZN, this.HQv);
    }
    if (!Util.isNullOrNil(this.HQw)) {
      paramString.set(ar.a.NZO, this.HQw);
    }
    if (!Util.isNullOrNil(this.HQx)) {}
    try
    {
      this.HQy = URLDecoder.decode(this.HQx, "UTF-8");
      if (!Util.isNullOrNil(this.HQy)) {
        paramString.set(ar.a.NZQ, this.HQy);
      }
      paramString.set(ar.a.NZR, Integer.valueOf(this.HQz));
      paramString.set(ar.a.NZP, Long.valueOf(this.jmW));
      paramString.set(ar.a.NZS, Integer.valueOf(this.HQA));
      if (this.HQA == 0)
      {
        Log.i("MicroMsg.NetSceneTransferWording", "do reset oplog");
        paramJSONObject = new cqd();
        paramJSONObject.Cyb = 0;
        ((l)g.af(l.class)).aSM().d(new k.a(205, paramJSONObject));
        paramString.set(147457, Long.valueOf(((Long)paramString.get(147457, Long.valueOf(0L))).longValue() & 0xFFFFFFEF & 0xFFFFFFDF));
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
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.aj
 * JD-Core Version:    0.7.0.1
 */