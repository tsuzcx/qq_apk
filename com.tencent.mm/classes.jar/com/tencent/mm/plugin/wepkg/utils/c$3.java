package com.tencent.mm.plugin.wepkg.utils;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.g.a.wi.a;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.b.2;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.Set;

final class c$3
  extends com.tencent.mm.sdk.b.c<wi>
{
  c$3(c paramc)
  {
    AppMethodBeat.i(141558);
    this.__eventId = wi.class.getName().hashCode();
    AppMethodBeat.o(141558);
  }
  
  private boolean a(wi paramwi)
  {
    AppMethodBeat.i(141559);
    if (ah.brt())
    {
      bool = com.tencent.mm.m.g.Nr().Nd();
      ab.d("MicroMsg.Wepkg.WepkgListener", "wepkg notify event operation:%d", new Object[] { Integer.valueOf(paramwi.cNO.coO) });
    }
    int i;
    switch (paramwi.cNO.coO)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      for (;;)
      {
        AppMethodBeat.o(141559);
        return false;
        bool = b.vGZ;
        break;
        if (bool)
        {
          AppMethodBeat.o(141559);
          return false;
        }
        d.aNS().ac(new c.3.1(this));
        continue;
        if (bool)
        {
          AppMethodBeat.o(141559);
          return false;
        }
        Object localObject = paramwi.cNO.cNP;
        i = paramwi.cNO.cNS;
        paramwi = new HashSet();
        if (!bo.isNullOrNil((String)localObject)) {
          paramwi.add(localObject);
        }
        WepkgVersionUpdater.a(paramwi, 1, i, false);
        continue;
        if (bool)
        {
          AppMethodBeat.o(141559);
          return false;
        }
        localObject = paramwi.cNO;
        com.tencent.mm.plugin.wepkg.b.f localf = com.tencent.mm.plugin.wepkg.b.f.dkq();
        paramwi = paramwi.cNO.cNP;
        if ((!localf.hsO) || (bo.isNullOrNil(paramwi))) {
          bool = false;
        }
        for (;;)
        {
          ((wi.a)localObject).cNQ = bool;
          break;
          paramwi = localf.ako(paramwi);
          if ((paramwi != null) && (paramwi.field_bigPackageReady) && (paramwi.field_preloadFilesReady)) {
            bool = true;
          } else {
            bool = false;
          }
        }
        if (ah.brt())
        {
          com.tencent.mm.plugin.wepkg.model.b.dkA().dkB();
          continue;
          if (bool)
          {
            AppMethodBeat.o(141559);
            return false;
          }
          localObject = h.akG(paramwi.cNO.cNP);
          if (localObject != null)
          {
            paramwi.cNO.cNR = ((WepkgVersion)localObject).vGT;
            ab.i("MicroMsg.Wepkg.WepkgListener", "total download count:%s", new Object[] { Integer.valueOf(paramwi.cNO.cNR) });
          }
        }
      }
    case 5: 
      if (bool)
      {
        AppMethodBeat.o(141559);
        return false;
      }
      if (bo.gz(bo.c((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yHn, Long.valueOf(0L)))) > 60L) {
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yHn, Long.valueOf(bo.aox()));
      }
      break;
    }
    for (boolean bool = c.a(this.vHc, 1); (!bool) && (bo.gz(bo.c((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yHm, Long.valueOf(0L)))) > 1800L); bool = false)
    {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yHm, Long.valueOf(bo.aox()));
      paramwi = new wi();
      paramwi.cNO.coO = 0;
      a.ymk.l(paramwi);
      break;
      if (bo.isNullOrNil(paramwi.cNO.cNP))
      {
        paramwi = com.tencent.mm.plugin.wepkg.model.b.dkA();
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          d.aNS().ac(new b.2(paramwi));
          break;
        }
        com.tencent.mm.plugin.wepkg.model.b.ef(null, 0);
        break;
      }
      com.tencent.mm.plugin.wepkg.model.b.dkA().ee(paramwi.cNO.cNP, 2);
      break;
      com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:tools", null, c.a.class, null);
      break;
      i = paramwi.cNO.scene;
      paramwi = paramwi.cNO.cNT;
      if (bo.es(paramwi)) {
        break;
      }
      switch (i)
      {
      default: 
        break;
      case 0: 
        WepkgVersionUpdater.q(paramwi, 4);
        break;
      case 1: 
        WepkgVersionUpdater.q(paramwi, 3);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.c.3
 * JD-Core Version:    0.7.0.1
 */