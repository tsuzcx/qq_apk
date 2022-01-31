package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.cxa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bi;
import java.io.IOException;

public final class g
  extends b
{
  private bi cEE;
  
  public g(bi parambi)
  {
    this.cEE = parambi;
  }
  
  public final String getName()
  {
    return "WearLuckyCreateTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(26445);
    cxa localcxa = new cxa();
    Object localObject = this.cEE.field_content;
    String str;
    if (localObject != null)
    {
      localObject = j.b.ab((String)localObject, this.cEE.field_reserved);
      if ((localObject == null) || (!((j.b)localObject).fih.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))) {
        break label244;
      }
      localcxa.wsz = this.cEE.field_msgId;
      localcxa.xlH = this.cEE.field_talker;
      if (this.cEE.field_isSend != 1) {
        break label220;
      }
      localObject = ((j.b)localObject).fib;
      localcxa.Title = h.agg(this.cEE.field_talker);
      if (!t.lA(this.cEE.field_talker)) {
        break label228;
      }
      str = c(this.cEE.field_talker, this.cEE);
    }
    for (localcxa.ntu = String.format(ah.getContext().getString(2131301939), new Object[] { h.agg(str), Character.valueOf('​'), localObject });; localcxa.ntu = ((String)localObject))
    {
      try
      {
        com.tencent.mm.plugin.wear.model.a.cYy();
        r.a(20014, localcxa.toByteArray(), true);
        com.tencent.mm.plugin.wear.model.c.a.gD(10, 0);
        com.tencent.mm.plugin.wear.model.c.a.IR(10);
        AppMethodBeat.o(26445);
        return;
      }
      catch (IOException localIOException)
      {
        label220:
        label228:
        AppMethodBeat.o(26445);
        return;
      }
      ab.w("MicroMsg.Wear.WearLuckyCreateTask", "xml is null!");
      AppMethodBeat.o(26445);
      return;
      localObject = ((j.b)localObject).fia;
      break;
    }
    label244:
    ab.i("MicroMsg.Wear.WearLuckyCreateTask", "biz c2c message, do not send to watch!");
    AppMethodBeat.o(26445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.g
 * JD-Core Version:    0.7.0.1
 */