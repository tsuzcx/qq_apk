package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dqa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class ak
  extends m
{
  public String Vyo;
  public String Vyp;
  public String Vyq;
  public String Vyr;
  public String Vys;
  public int Vyt;
  public int Vyu;
  private long ofU;
  public String rIB;
  
  public ak()
  {
    AppMethodBeat.i(69963);
    setRequestData(null);
    AppMethodBeat.o(69963);
  }
  
  public static boolean a(boolean paramBoolean, i parami)
  {
    AppMethodBeat.i(69965);
    h.baF();
    long l = ((Long)h.baE().ban().get(at.a.acPl, Long.valueOf(0L))).longValue();
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
        h.baF();
        h.baD().mCm.a(new ak(), 0);
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
    this.rIB = paramJSONObject.optString("delay_confirm_wording");
    this.Vyo = paramJSONObject.optString("delay_confirm_switch_wording");
    this.Vyp = paramJSONObject.optString("delay_confirm_switch_remind_wording");
    this.Vyq = paramJSONObject.optString("delay_confirm_switch_remind_half_page_wording");
    this.Vyr = paramJSONObject.optString("delay_confirm_desc_url");
    this.Vyt = paramJSONObject.optInt("delay_confirm_desc_url_flag", 0);
    this.ofU = (paramJSONObject.optLong("expire_time", 0L) * 1000L);
    this.Vyu = paramJSONObject.optInt("delay_confirm_switch_flag", 0);
    h.baF();
    paramString = h.baE().ban();
    if (!Util.isNullOrNil(this.rIB)) {
      paramString.set(at.a.acPh, this.rIB);
    }
    if (!Util.isNullOrNil(this.Vyo)) {
      paramString.set(at.a.acPi, this.Vyo);
    }
    if (!Util.isNullOrNil(this.Vyp)) {
      paramString.set(at.a.acPj, this.Vyp);
    }
    if (!Util.isNullOrNil(this.Vyq)) {
      paramString.set(at.a.acPk, this.Vyq);
    }
    if (!Util.isNullOrNil(this.Vyr)) {}
    try
    {
      this.Vys = URLDecoder.decode(this.Vyr, "UTF-8");
      if (!Util.isNullOrNil(this.Vys)) {
        paramString.set(at.a.acPm, this.Vys);
      }
      paramString.set(at.a.acPn, Integer.valueOf(this.Vyt));
      paramString.set(at.a.acPl, Long.valueOf(this.ofU));
      paramString.set(at.a.acPo, Integer.valueOf(this.Vyu));
      if (this.Vyu == 0)
      {
        Log.i("MicroMsg.NetSceneTransferWording", "do reset oplog");
        paramJSONObject = new dqa();
        paramJSONObject.OzH = 0;
        ((n)h.ax(n.class)).bzz().d(new k.a(205, paramJSONObject));
        paramString.B(147457, Long.valueOf(((Long)paramString.d(147457, Long.valueOf(0L))).longValue() & 0xFFFFFFEF & 0xFFFFFFDF));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ak
 * JD-Core Version:    0.7.0.1
 */