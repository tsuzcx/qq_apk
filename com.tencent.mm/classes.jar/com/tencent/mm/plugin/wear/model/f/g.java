package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.fjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import java.io.IOException;

public final class g
  extends b
{
  private ca fNz;
  
  public g(ca paramca)
  {
    this.fNz = paramca;
  }
  
  protected final void gOA()
  {
    AppMethodBeat.i(30127);
    fjl localfjl = new fjl();
    Object localObject = this.fNz.field_content;
    String str;
    if (localObject != null)
    {
      localObject = k.b.aG((String)localObject, this.fNz.field_reserved);
      if ((localObject == null) || (!((k.b)localObject).lnH.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))) {
        break label245;
      }
      localfjl.RNj = this.fNz.field_msgId;
      localfjl.Ueg = this.fNz.field_talker;
      if (this.fNz.field_isSend != 1) {
        break label221;
      }
      localObject = ((k.b)localObject).lnB;
      localfjl.fwr = h.bhV(this.fNz.field_talker);
      if (!ab.Lj(this.fNz.field_talker)) {
        break label229;
      }
      str = d(this.fNz.field_talker, this.fNz);
    }
    for (localfjl.lpy = String.format(MMApplicationContext.getContext().getString(R.l.eNt), new Object[] { h.bhV(str), Character.valueOf('​'), localObject });; localfjl.lpy = ((String)localObject))
    {
      try
      {
        com.tencent.mm.plugin.wear.model.a.gOx();
        r.a(20014, localfjl.toByteArray(), true);
        com.tencent.mm.plugin.wear.model.c.a.lp(10, 0);
        com.tencent.mm.plugin.wear.model.c.a.amT(10);
        AppMethodBeat.o(30127);
        return;
      }
      catch (IOException localIOException)
      {
        label221:
        label229:
        AppMethodBeat.o(30127);
        return;
      }
      Log.w("MicroMsg.Wear.WearLuckyCreateTask", "xml is null!");
      AppMethodBeat.o(30127);
      return;
      localObject = ((k.b)localObject).lnA;
      break;
    }
    label245:
    Log.i("MicroMsg.Wear.WearLuckyCreateTask", "biz c2c message, do not send to watch!");
    AppMethodBeat.o(30127);
  }
  
  public final String getName()
  {
    return "WearLuckyCreateTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.g
 * JD-Core Version:    0.7.0.1
 */