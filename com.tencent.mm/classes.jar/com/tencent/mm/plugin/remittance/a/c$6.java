package com.tencent.mm.plugin.remittance.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.remittance.model.f;
import com.tencent.mm.plugin.remittance.model.f.a;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.dab;
import com.tencent.mm.protocal.protobuf.dae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.aa;
import java.util.Iterator;
import java.util.LinkedList;

final class c$6
  implements Runnable
{
  c$6(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(273224);
    f localf = f.Iln;
    try
    {
      Object localObject = (String)((a)h.ag(a.class)).getWalletCacheStg().get(ar.a.VEn, null);
      if (!Util.isNullOrNil((String)localObject)) {
        localf.Ilm.parseFrom(Base64.decode((String)localObject, 0));
      }
      localObject = localf.Ilm.THA.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dab localdab = (dab)((Iterator)localObject).next();
        int j = (int)((localdab.THw - bq.beS()) / 1000L);
        int i = j;
        if (j < 0) {
          i = 0;
        }
        new f.a(i, localdab).start();
      }
      AppMethodBeat.o(273224);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MsgCheckTaskMgr", localException, "", new Object[0]);
      localf.Ilm.THA.clear();
      AppMethodBeat.o(273224);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.c.6
 * JD-Core Version:    0.7.0.1
 */