package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.dwv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.bo;
import java.io.IOException;

public final class g
  extends b
{
  private bo dpq;
  
  public g(bo parambo)
  {
    this.dpq = parambo;
  }
  
  public final String getName()
  {
    return "WearLuckyCreateTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30127);
    dwv localdwv = new dwv();
    Object localObject = this.dpq.field_content;
    String str;
    if (localObject != null)
    {
      localObject = k.b.az((String)localObject, this.dpq.field_reserved);
      if ((localObject == null) || (!((k.b)localObject).hjo.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))) {
        break label244;
      }
      localdwv.DUK = this.dpq.field_msgId;
      localdwv.FDc = this.dpq.field_talker;
      if (this.dpq.field_isSend != 1) {
        break label220;
      }
      localObject = ((k.b)localObject).hji;
      localdwv.Title = h.aAi(this.dpq.field_talker);
      if (!w.sQ(this.dpq.field_talker)) {
        break label228;
      }
      str = d(this.dpq.field_talker, this.dpq);
    }
    for (localdwv.hkR = String.format(ai.getContext().getString(2131761701), new Object[] { h.aAi(str), Character.valueOf('​'), localObject });; localdwv.hkR = ((String)localObject))
    {
      try
      {
        com.tencent.mm.plugin.wear.model.a.ewt();
        r.a(20014, localdwv.toByteArray(), true);
        com.tencent.mm.plugin.wear.model.c.a.iC(10, 0);
        com.tencent.mm.plugin.wear.model.c.a.Ua(10);
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
      ac.w("MicroMsg.Wear.WearLuckyCreateTask", "xml is null!");
      AppMethodBeat.o(30127);
      return;
      localObject = ((k.b)localObject).hjh;
      break;
    }
    label244:
    ac.i("MicroMsg.Wear.WearLuckyCreateTask", "biz c2c message, do not send to watch!");
    AppMethodBeat.o(30127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.g
 * JD-Core Version:    0.7.0.1
 */