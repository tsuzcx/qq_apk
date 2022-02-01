package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class aj
  extends m
{
  private long huV;
  public String jGj;
  public String zWO;
  public String zWP;
  public String zWQ;
  public String zWR;
  public int zWS;
  public int zWT;
  
  public aj()
  {
    AppMethodBeat.i(69963);
    setRequestData(null);
    AppMethodBeat.o(69963);
  }
  
  public static boolean a(boolean paramBoolean, com.tencent.mm.wallet_core.d.i parami)
  {
    AppMethodBeat.i(69965);
    g.afC();
    long l = ((Long)g.afB().afk().get(ae.a.Fni, Long.valueOf(0L))).longValue();
    if ((paramBoolean) || (l < System.currentTimeMillis()))
    {
      ad.i("MicroMsg.NetSceneTransferWording", "do scene: %d, force: %B", new Object[] { Long.valueOf(l), Boolean.valueOf(paramBoolean) });
      if (parami != null) {
        parami.a(new aj(), false, 1);
      }
      for (;;)
      {
        AppMethodBeat.o(69965);
        return true;
        g.afC();
        g.afA().gcy.a(new aj(), 0);
      }
    }
    ad.d("MicroMsg.NetSceneTransferWording", "not time");
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
    ad.i("MicroMsg.NetSceneTransferWording", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ad.d("MicroMsg.NetSceneTransferWording", "json: %s", new Object[] { paramJSONObject });
    this.jGj = paramJSONObject.optString("delay_confirm_wording");
    this.zWO = paramJSONObject.optString("delay_confirm_switch_wording");
    this.zWP = paramJSONObject.optString("delay_confirm_switch_remind_wording");
    this.zWQ = paramJSONObject.optString("delay_confirm_desc_url");
    this.zWS = paramJSONObject.optInt("delay_confirm_desc_url_flag", 0);
    this.huV = (paramJSONObject.optLong("expire_time", 0L) * 1000L);
    this.zWT = paramJSONObject.optInt("delay_confirm_switch_flag", 0);
    g.afC();
    paramString = g.afB().afk();
    if (!bt.isNullOrNil(this.jGj)) {
      paramString.set(ae.a.Fnf, this.jGj);
    }
    if (!bt.isNullOrNil(this.zWO)) {
      paramString.set(ae.a.Fng, this.zWO);
    }
    if (!bt.isNullOrNil(this.zWP)) {
      paramString.set(ae.a.Fnh, this.zWP);
    }
    if (!bt.isNullOrNil(this.zWQ)) {}
    try
    {
      this.zWR = URLDecoder.decode(this.zWQ, "UTF-8");
      if (!bt.isNullOrNil(this.zWR)) {
        paramString.set(ae.a.Fnj, this.zWR);
      }
      paramString.set(ae.a.Fnk, Integer.valueOf(this.zWS));
      paramString.set(ae.a.Fni, Long.valueOf(this.huV));
      paramString.set(ae.a.Fnl, Integer.valueOf(this.zWT));
      if (this.zWT == 0)
      {
        ad.i("MicroMsg.NetSceneTransferWording", "do reset oplog");
        paramJSONObject = new bra();
        paramJSONObject.vJA = 0;
        ((k)g.ab(k.class)).apL().c(new j.a(205, paramJSONObject));
        paramString.set(147457, Long.valueOf(((Long)paramString.get(147457, Long.valueOf(0L))).longValue() & 0xFFFFFFEF & 0xFFFFFFDF));
      }
      AppMethodBeat.o(69964);
      return;
    }
    catch (UnsupportedEncodingException paramJSONObject)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneTransferWording", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.aj
 * JD-Core Version:    0.7.0.1
 */