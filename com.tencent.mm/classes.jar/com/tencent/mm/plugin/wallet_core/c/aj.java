package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cah;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class aj
  extends m
{
  public String CPA;
  public String CPB;
  public int CPC;
  public int CPD;
  public String CPy;
  public String CPz;
  private long ioS;
  public String kBv;
  
  public aj()
  {
    AppMethodBeat.i(69963);
    setRequestData(null);
    AppMethodBeat.o(69963);
  }
  
  public static boolean a(boolean paramBoolean, i parami)
  {
    AppMethodBeat.i(69965);
    g.ajD();
    long l = ((Long)g.ajC().ajl().get(al.a.Ixp, Long.valueOf(0L))).longValue();
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
        g.ajD();
        g.ajB().gAO.a(new aj(), 0);
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
    this.kBv = paramJSONObject.optString("delay_confirm_wording");
    this.CPy = paramJSONObject.optString("delay_confirm_switch_wording");
    this.CPz = paramJSONObject.optString("delay_confirm_switch_remind_wording");
    this.CPA = paramJSONObject.optString("delay_confirm_desc_url");
    this.CPC = paramJSONObject.optInt("delay_confirm_desc_url_flag", 0);
    this.ioS = (paramJSONObject.optLong("expire_time", 0L) * 1000L);
    this.CPD = paramJSONObject.optInt("delay_confirm_switch_flag", 0);
    g.ajD();
    paramString = g.ajC().ajl();
    if (!bt.isNullOrNil(this.kBv)) {
      paramString.set(al.a.Ixm, this.kBv);
    }
    if (!bt.isNullOrNil(this.CPy)) {
      paramString.set(al.a.Ixn, this.CPy);
    }
    if (!bt.isNullOrNil(this.CPz)) {
      paramString.set(al.a.Ixo, this.CPz);
    }
    if (!bt.isNullOrNil(this.CPA)) {}
    try
    {
      this.CPB = URLDecoder.decode(this.CPA, "UTF-8");
      if (!bt.isNullOrNil(this.CPB)) {
        paramString.set(al.a.Ixq, this.CPB);
      }
      paramString.set(al.a.Ixr, Integer.valueOf(this.CPC));
      paramString.set(al.a.Ixp, Long.valueOf(this.ioS));
      paramString.set(al.a.Ixs, Integer.valueOf(this.CPD));
      if (this.CPD == 0)
      {
        ad.i("MicroMsg.NetSceneTransferWording", "do reset oplog");
        paramJSONObject = new cah();
        paramJSONObject.yho = 0;
        ((l)g.ab(l.class)).azo().c(new k.a(205, paramJSONObject));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.aj
 * JD-Core Version:    0.7.0.1
 */