package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.eyu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import java.io.IOException;

public final class g
  extends b
{
  private ca dTX;
  
  public g(ca paramca)
  {
    this.dTX = paramca;
  }
  
  public final String getName()
  {
    return "WearLuckyCreateTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30127);
    eyu localeyu = new eyu();
    Object localObject = this.dTX.field_content;
    String str;
    if (localObject != null)
    {
      localObject = k.b.aD((String)localObject, this.dTX.field_reserved);
      if ((localObject == null) || (!((k.b)localObject).iyr.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))) {
        break label244;
      }
      localeyu.KMm = this.dTX.field_msgId;
      localeyu.MRZ = this.dTX.field_talker;
      if (this.dTX.field_isSend != 1) {
        break label220;
      }
      localObject = ((k.b)localObject).iyl;
      localeyu.Title = h.aWo(this.dTX.field_talker);
      if (!ab.Eq(this.dTX.field_talker)) {
        break label228;
      }
      str = d(this.dTX.field_talker, this.dTX);
    }
    for (localeyu.iAc = String.format(MMApplicationContext.getContext().getString(2131763669), new Object[] { h.aWo(str), Character.valueOf('​'), localObject });; localeyu.iAc = ((String)localObject))
    {
      try
      {
        com.tencent.mm.plugin.wear.model.a.fVQ();
        r.a(20014, localeyu.toByteArray(), true);
        com.tencent.mm.plugin.wear.model.c.a.jZ(10, 0);
        com.tencent.mm.plugin.wear.model.c.a.aff(10);
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
      Log.w("MicroMsg.Wear.WearLuckyCreateTask", "xml is null!");
      AppMethodBeat.o(30127);
      return;
      localObject = ((k.b)localObject).iyk;
      break;
    }
    label244:
    Log.i("MicroMsg.Wear.WearLuckyCreateTask", "biz c2c message, do not send to watch!");
    AppMethodBeat.o(30127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.g
 * JD-Core Version:    0.7.0.1
 */