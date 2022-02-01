package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.gfz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import java.io.IOException;

public final class g
  extends b
{
  private cc hTm;
  
  public g(cc paramcc)
  {
    this.hTm = paramcc;
  }
  
  public final String getName()
  {
    return "WearLuckyCreateTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30127);
    gfz localgfz = new gfz();
    Object localObject = this.hTm.field_content;
    String str;
    if (localObject != null)
    {
      localObject = k.b.aP((String)localObject, this.hTm.field_reserved);
      if ((localObject == null) || (!((k.b)localObject).nSL.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))) {
        break label245;
      }
      localgfz.YKx = this.hTm.field_msgId;
      localgfz.abvu = this.hTm.field_talker;
      if (this.hTm.field_isSend != 1) {
        break label221;
      }
      localObject = ((k.b)localObject).nSF;
      localgfz.hAP = h.bhE(this.hTm.field_talker);
      if (!au.bwE(this.hTm.field_talker)) {
        break label229;
      }
      str = d(this.hTm.field_talker, this.hTm);
    }
    for (localgfz.nUB = String.format(MMApplicationContext.getContext().getString(R.l.gPG), new Object[] { h.bhE(str), Character.valueOf('​'), localObject });; localgfz.nUB = ((String)localObject))
    {
      try
      {
        com.tencent.mm.plugin.wear.model.a.inM();
        r.a(20014, localgfz.toByteArray(), true);
        com.tencent.mm.plugin.wear.model.c.a.kK(10, 0);
        com.tencent.mm.plugin.wear.model.c.a.asK(10);
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
      localObject = ((k.b)localObject).nSE;
      break;
    }
    label245:
    Log.i("MicroMsg.Wear.WearLuckyCreateTask", "biz c2c message, do not send to watch!");
    AppMethodBeat.o(30127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.g
 * JD-Core Version:    0.7.0.1
 */