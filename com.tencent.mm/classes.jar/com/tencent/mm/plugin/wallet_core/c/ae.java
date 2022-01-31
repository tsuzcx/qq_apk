package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.protocal.c.axp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.d.i;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class ae
  extends com.tencent.mm.wallet_core.tenpay.model.j
{
  private long eCv;
  public String qrh;
  public String qri;
  public String qrj;
  public String qrk;
  public String qrl;
  public int qrm;
  public int qrn;
  
  public ae()
  {
    D(null);
  }
  
  public static boolean a(boolean paramBoolean, i parami)
  {
    g.DQ();
    long l = ((Long)g.DP().Dz().get(ac.a.uuz, Long.valueOf(0L))).longValue();
    if ((paramBoolean) || (l < System.currentTimeMillis()))
    {
      y.i("MicroMsg.NetSceneTransferWording", "do scene: %d, force: %B", new Object[] { Long.valueOf(l), Boolean.valueOf(paramBoolean) });
      if (parami != null) {
        parami.a(new ae(), false, 1);
      }
      for (;;)
      {
        return true;
        g.DQ();
        g.DO().dJT.a(new ae(), 0);
      }
    }
    y.d("MicroMsg.NetSceneTransferWording", "not time");
    return false;
  }
  
  public final int HH()
  {
    return 1992;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.NetSceneTransferWording", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    y.d("MicroMsg.NetSceneTransferWording", "json: %s", new Object[] { paramJSONObject });
    this.qrh = paramJSONObject.optString("delay_confirm_wording");
    this.qri = paramJSONObject.optString("delay_confirm_switch_wording");
    this.qrj = paramJSONObject.optString("delay_confirm_switch_remind_wording");
    this.qrk = paramJSONObject.optString("delay_confirm_desc_url");
    this.qrm = paramJSONObject.optInt("delay_confirm_desc_url_flag", 0);
    this.eCv = (paramJSONObject.optLong("expire_time", 0L) * 1000L);
    this.qrn = paramJSONObject.optInt("delay_confirm_switch_flag", 0);
    g.DQ();
    paramString = g.DP().Dz();
    if (!bk.bl(this.qrh)) {
      paramString.c(ac.a.uuw, this.qrh);
    }
    if (!bk.bl(this.qri)) {
      paramString.c(ac.a.uux, this.qri);
    }
    if (!bk.bl(this.qrj)) {
      paramString.c(ac.a.uuy, this.qrj);
    }
    if (!bk.bl(this.qrk)) {}
    try
    {
      this.qrl = URLDecoder.decode(this.qrk, "UTF-8");
      if (!bk.bl(this.qrl)) {
        paramString.c(ac.a.uuA, this.qrl);
      }
      paramString.c(ac.a.uuB, Integer.valueOf(this.qrm));
      paramString.c(ac.a.uuz, Long.valueOf(this.eCv));
      paramString.c(ac.a.uuC, Integer.valueOf(this.qrn));
      if (this.qrn == 0)
      {
        y.i("MicroMsg.NetSceneTransferWording", "do reset oplog");
        paramJSONObject = new axp();
        paramJSONObject.nFj = 0;
        ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new i.a(205, paramJSONObject));
        paramString.o(147457, Long.valueOf(((Long)paramString.get(147457, Long.valueOf(0L))).longValue() & 0xFFFFFFEF & 0xFFFFFFDF));
      }
      return;
    }
    catch (UnsupportedEncodingException paramJSONObject)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.NetSceneTransferWording", paramJSONObject, "", new Object[0]);
      }
    }
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final boolean bqd()
  {
    return false;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/gettransferwording";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ae
 * JD-Core Version:    0.7.0.1
 */