package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class ah
  extends m
{
  private long fSm;
  public String ucf;
  public String ucg;
  public String uch;
  public String uci;
  public String ucj;
  public int uck;
  public int ucl;
  
  public ah()
  {
    AppMethodBeat.i(46557);
    setRequestData(null);
    AppMethodBeat.o(46557);
  }
  
  public static boolean a(boolean paramBoolean, com.tencent.mm.wallet_core.d.i parami)
  {
    AppMethodBeat.i(46559);
    g.RM();
    long l = ((Long)g.RL().Ru().get(ac.a.yEC, Long.valueOf(0L))).longValue();
    if ((paramBoolean) || (l < System.currentTimeMillis()))
    {
      ab.i("MicroMsg.NetSceneTransferWording", "do scene: %d, force: %B", new Object[] { Long.valueOf(l), Boolean.valueOf(paramBoolean) });
      if (parami != null) {
        parami.a(new ah(), false, 1);
      }
      for (;;)
      {
        AppMethodBeat.o(46559);
        return true;
        g.RM();
        g.RK().eHt.a(new ah(), 0);
      }
    }
    ab.d("MicroMsg.NetSceneTransferWording", "not time");
    AppMethodBeat.o(46559);
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
    AppMethodBeat.i(46558);
    ab.i("MicroMsg.NetSceneTransferWording", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    ab.d("MicroMsg.NetSceneTransferWording", "json: %s", new Object[] { paramJSONObject });
    this.ucf = paramJSONObject.optString("delay_confirm_wording");
    this.ucg = paramJSONObject.optString("delay_confirm_switch_wording");
    this.uch = paramJSONObject.optString("delay_confirm_switch_remind_wording");
    this.uci = paramJSONObject.optString("delay_confirm_desc_url");
    this.uck = paramJSONObject.optInt("delay_confirm_desc_url_flag", 0);
    this.fSm = (paramJSONObject.optLong("expire_time", 0L) * 1000L);
    this.ucl = paramJSONObject.optInt("delay_confirm_switch_flag", 0);
    g.RM();
    paramString = g.RL().Ru();
    if (!bo.isNullOrNil(this.ucf)) {
      paramString.set(ac.a.yEz, this.ucf);
    }
    if (!bo.isNullOrNil(this.ucg)) {
      paramString.set(ac.a.yEA, this.ucg);
    }
    if (!bo.isNullOrNil(this.uch)) {
      paramString.set(ac.a.yEB, this.uch);
    }
    if (!bo.isNullOrNil(this.uci)) {}
    try
    {
      this.ucj = URLDecoder.decode(this.uci, "UTF-8");
      if (!bo.isNullOrNil(this.ucj)) {
        paramString.set(ac.a.yED, this.ucj);
      }
      paramString.set(ac.a.yEE, Integer.valueOf(this.uck));
      paramString.set(ac.a.yEC, Long.valueOf(this.fSm));
      paramString.set(ac.a.yEF, Integer.valueOf(this.ucl));
      if (this.ucl == 0)
      {
        ab.i("MicroMsg.NetSceneTransferWording", "do reset oplog");
        paramJSONObject = new bei();
        paramJSONObject.qsl = 0;
        ((j)g.E(j.class)).Yz().c(new j.a(205, paramJSONObject));
        paramString.set(147457, Long.valueOf(((Long)paramString.get(147457, Long.valueOf(0L))).longValue() & 0xFFFFFFEF & 0xFFFFFFDF));
      }
      AppMethodBeat.o(46558);
      return;
    }
    catch (UnsupportedEncodingException paramJSONObject)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneTransferWording", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ah
 * JD-Core Version:    0.7.0.1
 */