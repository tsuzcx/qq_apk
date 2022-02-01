package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.bvr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class aj
  extends m
{
  public String Bpi;
  public String Bpj;
  public String Bpk;
  public String Bpl;
  public int Bpm;
  public int Bpn;
  private long hVx;
  public String kgH;
  
  public aj()
  {
    AppMethodBeat.i(69963);
    setRequestData(null);
    AppMethodBeat.o(69963);
  }
  
  public static boolean a(boolean paramBoolean, com.tencent.mm.wallet_core.d.i parami)
  {
    AppMethodBeat.i(69965);
    g.agS();
    long l = ((Long)g.agR().agA().get(ah.a.GKX, Long.valueOf(0L))).longValue();
    if ((paramBoolean) || (l < System.currentTimeMillis()))
    {
      ac.i("MicroMsg.NetSceneTransferWording", "do scene: %d, force: %B", new Object[] { Long.valueOf(l), Boolean.valueOf(paramBoolean) });
      if (parami != null) {
        parami.a(new aj(), false, 1);
      }
      for (;;)
      {
        AppMethodBeat.o(69965);
        return true;
        g.agS();
        g.agQ().ghe.a(new aj(), 0);
      }
    }
    ac.d("MicroMsg.NetSceneTransferWording", "not time");
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
    ac.i("MicroMsg.NetSceneTransferWording", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ac.d("MicroMsg.NetSceneTransferWording", "json: %s", new Object[] { paramJSONObject });
    this.kgH = paramJSONObject.optString("delay_confirm_wording");
    this.Bpi = paramJSONObject.optString("delay_confirm_switch_wording");
    this.Bpj = paramJSONObject.optString("delay_confirm_switch_remind_wording");
    this.Bpk = paramJSONObject.optString("delay_confirm_desc_url");
    this.Bpm = paramJSONObject.optInt("delay_confirm_desc_url_flag", 0);
    this.hVx = (paramJSONObject.optLong("expire_time", 0L) * 1000L);
    this.Bpn = paramJSONObject.optInt("delay_confirm_switch_flag", 0);
    g.agS();
    paramString = g.agR().agA();
    if (!bs.isNullOrNil(this.kgH)) {
      paramString.set(ah.a.GKU, this.kgH);
    }
    if (!bs.isNullOrNil(this.Bpi)) {
      paramString.set(ah.a.GKV, this.Bpi);
    }
    if (!bs.isNullOrNil(this.Bpj)) {
      paramString.set(ah.a.GKW, this.Bpj);
    }
    if (!bs.isNullOrNil(this.Bpk)) {}
    try
    {
      this.Bpl = URLDecoder.decode(this.Bpk, "UTF-8");
      if (!bs.isNullOrNil(this.Bpl)) {
        paramString.set(ah.a.GKY, this.Bpl);
      }
      paramString.set(ah.a.GKZ, Integer.valueOf(this.Bpm));
      paramString.set(ah.a.GKX, Long.valueOf(this.hVx));
      paramString.set(ah.a.GLa, Integer.valueOf(this.Bpn));
      if (this.Bpn == 0)
      {
        ac.i("MicroMsg.NetSceneTransferWording", "do reset oplog");
        paramJSONObject = new bvr();
        paramJSONObject.wTE = 0;
        ((k)g.ab(k.class)).awA().c(new j.a(205, paramJSONObject));
        paramString.set(147457, Long.valueOf(((Long)paramString.get(147457, Long.valueOf(0L))).longValue() & 0xFFFFFFEF & 0xFFFFFFDF));
      }
      AppMethodBeat.o(69964);
      return;
    }
    catch (UnsupportedEncodingException paramJSONObject)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneTransferWording", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.aj
 * JD-Core Version:    0.7.0.1
 */