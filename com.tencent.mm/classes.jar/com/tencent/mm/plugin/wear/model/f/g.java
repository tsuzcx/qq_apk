package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.eem;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bv;
import java.io.IOException;

public final class g
  extends b
{
  private bv dCi;
  
  public g(bv parambv)
  {
    this.dCi = parambv;
  }
  
  public final String getName()
  {
    return "WearLuckyCreateTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30127);
    eem localeem = new eem();
    Object localObject = this.dCi.field_content;
    String str;
    if (localObject != null)
    {
      localObject = k.b.aB((String)localObject, this.dCi.field_reserved);
      if ((localObject == null) || (!((k.b)localObject).hEl.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))) {
        break label244;
      }
      localeem.FSD = this.dCi.field_msgId;
      localeem.HGP = this.dCi.field_talker;
      if (this.dCi.field_isSend != 1) {
        break label220;
      }
      localObject = ((k.b)localObject).hEf;
      localeem.Title = h.aGM(this.dCi.field_talker);
      if (!x.wb(this.dCi.field_talker)) {
        break label228;
      }
      str = d(this.dCi.field_talker, this.dCi);
    }
    for (localeem.hFS = String.format(ak.getContext().getString(2131761701), new Object[] { h.aGM(str), Character.valueOf('​'), localObject });; localeem.hFS = ((String)localObject))
    {
      try
      {
        com.tencent.mm.plugin.wear.model.a.eOh();
        r.a(20014, localeem.toByteArray(), true);
        com.tencent.mm.plugin.wear.model.c.a.iT(10, 0);
        com.tencent.mm.plugin.wear.model.c.a.Wz(10);
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
      ae.w("MicroMsg.Wear.WearLuckyCreateTask", "xml is null!");
      AppMethodBeat.o(30127);
      return;
      localObject = ((k.b)localObject).hEe;
      break;
    }
    label244:
    ae.i("MicroMsg.Wear.WearLuckyCreateTask", "biz c2c message, do not send to watch!");
    AppMethodBeat.o(30127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.g
 * JD-Core Version:    0.7.0.1
 */