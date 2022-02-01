package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.ecv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bu;
import java.io.IOException;

public final class g
  extends b
{
  private bu dBd;
  
  public g(bu parambu)
  {
    this.dBd = parambu;
  }
  
  public final String getName()
  {
    return "WearLuckyCreateTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30127);
    ecv localecv = new ecv();
    Object localObject = this.dBd.field_content;
    String str;
    if (localObject != null)
    {
      localObject = k.b.aA((String)localObject, this.dBd.field_reserved);
      if ((localObject == null) || (!((k.b)localObject).hBx.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))) {
        break label244;
      }
      localecv.FAf = this.dBd.field_msgId;
      localecv.Hnp = this.dBd.field_talker;
      if (this.dBd.field_isSend != 1) {
        break label220;
      }
      localObject = ((k.b)localObject).hBr;
      localecv.Title = h.aFs(this.dBd.field_talker);
      if (!w.vF(this.dBd.field_talker)) {
        break label228;
      }
      str = d(this.dBd.field_talker, this.dBd);
    }
    for (localecv.hDa = String.format(aj.getContext().getString(2131761701), new Object[] { h.aFs(str), Character.valueOf('​'), localObject });; localecv.hDa = ((String)localObject))
    {
      try
      {
        com.tencent.mm.plugin.wear.model.a.eKz();
        r.a(20014, localecv.toByteArray(), true);
        com.tencent.mm.plugin.wear.model.c.a.iP(10, 0);
        com.tencent.mm.plugin.wear.model.c.a.VS(10);
        AppMethodBeat.o(30127);
        return;
      }
      catch (IOException localIOException)
      {
        label220:
        label228:
        AppMethodBeat.o(30127);
        return;
      }
      ad.w("MicroMsg.Wear.WearLuckyCreateTask", "xml is null!");
      AppMethodBeat.o(30127);
      return;
      localObject = ((k.b)localObject).hBq;
      break;
    }
    label244:
    ad.i("MicroMsg.Wear.WearLuckyCreateTask", "biz c2c message, do not send to watch!");
    AppMethodBeat.o(30127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.g
 * JD-Core Version:    0.7.0.1
 */