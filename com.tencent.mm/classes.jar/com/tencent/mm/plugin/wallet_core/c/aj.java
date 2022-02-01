package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class aj
  extends m
{
  public String Dhc;
  public String Dhd;
  public String Dhe;
  public String Dhf;
  public int Dhg;
  public int Dhh;
  private long irN;
  public String kEK;
  
  public aj()
  {
    AppMethodBeat.i(69963);
    setRequestData(null);
    AppMethodBeat.o(69963);
  }
  
  public static boolean a(boolean paramBoolean, i parami)
  {
    AppMethodBeat.i(69965);
    g.ajS();
    long l = ((Long)g.ajR().ajA().get(am.a.IRN, Long.valueOf(0L))).longValue();
    if ((paramBoolean) || (l < System.currentTimeMillis()))
    {
      ae.i("MicroMsg.NetSceneTransferWording", "do scene: %d, force: %B", new Object[] { Long.valueOf(l), Boolean.valueOf(paramBoolean) });
      if (parami != null) {
        parami.a(new aj(), false, 1);
      }
      for (;;)
      {
        AppMethodBeat.o(69965);
        return true;
        g.ajS();
        g.ajQ().gDv.a(new aj(), 0);
      }
    }
    ae.d("MicroMsg.NetSceneTransferWording", "not time");
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
    ae.i("MicroMsg.NetSceneTransferWording", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ae.d("MicroMsg.NetSceneTransferWording", "json: %s", new Object[] { paramJSONObject });
    this.kEK = paramJSONObject.optString("delay_confirm_wording");
    this.Dhc = paramJSONObject.optString("delay_confirm_switch_wording");
    this.Dhd = paramJSONObject.optString("delay_confirm_switch_remind_wording");
    this.Dhe = paramJSONObject.optString("delay_confirm_desc_url");
    this.Dhg = paramJSONObject.optInt("delay_confirm_desc_url_flag", 0);
    this.irN = (paramJSONObject.optLong("expire_time", 0L) * 1000L);
    this.Dhh = paramJSONObject.optInt("delay_confirm_switch_flag", 0);
    g.ajS();
    paramString = g.ajR().ajA();
    if (!bu.isNullOrNil(this.kEK)) {
      paramString.set(am.a.IRK, this.kEK);
    }
    if (!bu.isNullOrNil(this.Dhc)) {
      paramString.set(am.a.IRL, this.Dhc);
    }
    if (!bu.isNullOrNil(this.Dhd)) {
      paramString.set(am.a.IRM, this.Dhd);
    }
    if (!bu.isNullOrNil(this.Dhe)) {}
    try
    {
      this.Dhf = URLDecoder.decode(this.Dhe, "UTF-8");
      if (!bu.isNullOrNil(this.Dhf)) {
        paramString.set(am.a.IRO, this.Dhf);
      }
      paramString.set(am.a.IRP, Integer.valueOf(this.Dhg));
      paramString.set(am.a.IRN, Long.valueOf(this.irN));
      paramString.set(am.a.IRQ, Integer.valueOf(this.Dhh));
      if (this.Dhh == 0)
      {
        ae.i("MicroMsg.NetSceneTransferWording", "do reset oplog");
        paramJSONObject = new cbb();
        paramJSONObject.yxf = 0;
        ((l)g.ab(l.class)).azE().d(new k.a(205, paramJSONObject));
        paramString.set(147457, Long.valueOf(((Long)paramString.get(147457, Long.valueOf(0L))).longValue() & 0xFFFFFFEF & 0xFFFFFFDF));
      }
      AppMethodBeat.o(69964);
      return;
    }
    catch (UnsupportedEncodingException paramJSONObject)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneTransferWording", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.aj
 * JD-Core Version:    0.7.0.1
 */