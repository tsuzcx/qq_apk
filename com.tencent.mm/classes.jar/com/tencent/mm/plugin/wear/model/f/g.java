package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.dre;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bl;
import java.io.IOException;

public final class g
  extends b
{
  private bl drF;
  
  public g(bl parambl)
  {
    this.drF = parambl;
  }
  
  public final String getName()
  {
    return "WearLuckyCreateTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30127);
    dre localdre = new dre();
    Object localObject = this.drF.field_content;
    String str;
    if (localObject != null)
    {
      localObject = k.b.ar((String)localObject, this.drF.field_reserved);
      if ((localObject == null) || (!((k.b)localObject).gIO.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))) {
        break label244;
      }
      localdre.CCn = this.drF.field_msgId;
      localdre.Egc = this.drF.field_talker;
      if (this.drF.field_isSend != 1) {
        break label220;
      }
      localObject = ((k.b)localObject).gII;
      localdre.Title = h.auR(this.drF.field_talker);
      if (!w.pF(this.drF.field_talker)) {
        break label228;
      }
      str = d(this.drF.field_talker, this.drF);
    }
    for (localdre.gKr = String.format(aj.getContext().getString(2131761701), new Object[] { h.auR(str), Character.valueOf('​'), localObject });; localdre.gKr = ((String)localObject))
    {
      try
      {
        com.tencent.mm.plugin.wear.model.a.egZ();
        r.a(20014, localdre.toByteArray(), true);
        com.tencent.mm.plugin.wear.model.c.a.in(10, 0);
        com.tencent.mm.plugin.wear.model.c.a.RQ(10);
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
      localObject = ((k.b)localObject).gIH;
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