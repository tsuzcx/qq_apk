package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.g;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

final class Updater$3$1
  implements com.tencent.mm.am.h
{
  Updater$3$1(Updater.3 param3, g paramg) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(32746);
    bh.aZW().b(221, Updater.f(this.acoq.acop));
    Updater.a(this.acoq.acop, null);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (com.tencent.mm.modelsimple.s)paramp;
      String str;
      if (((crq)c.b.b(paramString.omC.otB)).vhJ == 0)
      {
        paramString = ((crr)c.c.b(paramString.omC.otC)).nUB;
        if (!Util.isNullOrNil(paramString))
        {
          paramString = XmlParser.parseXml(paramString, "resourcecontrolinfo", null);
          if (paramString != null)
          {
            paramp = (String)paramString.get(".resourcecontrolinfo.enableupdate");
            str = (String)paramString.get(".resourcecontrolinfo.expiredtime");
            Log.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate getDisableUpdateTime values[%s]", new Object[] { paramString });
            if (Util.getInt(paramp, 1) != 0) {}
          }
        }
      }
      for (long l1 = Util.getLong(str, 0L);; l1 = 0L)
      {
        long l2 = System.currentTimeMillis() / 1000L;
        if (l1 <= l2) {
          break;
        }
        Log.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 0L, 1L, true);
        AppMethodBeat.o(32746);
        return;
      }
    }
    Log.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService after checkcontrol");
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 59L, 1L, true);
    paramString = new Intent(this.acoq.acop.getContext(), UpdaterService.class);
    Updater.a(this.acoq.acop, paramString, this.mCr, this.acoq.acoo);
    paramString.putExtra("intent_extra_run_in_foreground", true);
    paramString.putExtra("intent_extra_download_mode", 2);
    com.tencent.mm.br.c.n(paramString, "sandbox");
    AppMethodBeat.o(32746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.Updater.3.1
 * JD-Core Version:    0.7.0.1
 */