package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

final class Updater$3$1
  implements f
{
  Updater$3$1(Updater.3 param3, e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(28933);
    aw.Rc().b(221, Updater.f(this.ylw.ylv));
    Updater.a(this.ylw.ylv, null);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (q)paramm;
      String str;
      if (((apk)paramString.fnd.fsV.fta).jKs == 0)
      {
        paramString = ((apl)paramString.fnd.fsW.fta).ntu;
        if (!bo.isNullOrNil(paramString))
        {
          paramString = br.F(paramString, "resourcecontrolinfo");
          if (paramString != null)
          {
            paramm = (String)paramString.get(".resourcecontrolinfo.enableupdate");
            str = (String)paramString.get(".resourcecontrolinfo.expiredtime");
            ab.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate getDisableUpdateTime values[%s]", new Object[] { paramString });
            if (bo.getInt(paramm, 1) != 0) {}
          }
        }
      }
      for (long l1 = bo.getLong(str, 0L);; l1 = 0L)
      {
        long l2 = System.currentTimeMillis() / 1000L;
        if (l1 <= l2) {
          break;
        }
        ab.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        h.qsU.idkeyStat(405L, 0L, 1L, true);
        AppMethodBeat.o(28933);
        return;
      }
    }
    ab.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService after checkcontrol");
    h.qsU.idkeyStat(405L, 59L, 1L, true);
    paramString = new Intent(this.ylw.ylv.getContext(), UpdaterService.class);
    Updater.a(this.ylw.ylv, paramString, this.eHz, this.ylw.ylu);
    paramString.putExtra("intent_extra_run_in_foreground", true);
    paramString.putExtra("intent_extra_download_mode", 2);
    d.j(paramString, "sandbox");
    AppMethodBeat.o(28933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.Updater.3.1
 * JD-Core Version:    0.7.0.1
 */