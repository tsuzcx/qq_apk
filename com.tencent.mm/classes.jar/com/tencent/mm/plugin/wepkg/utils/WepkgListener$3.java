package com.tencent.mm.plugin.wepkg.utils;

import android.os.Looper;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aee;
import com.tencent.mm.autogen.a.aee.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.wepkg.b.e;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.c.2;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.plugin.wepkg.model.k;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.HashSet;
import java.util.Set;

class WepkgListener$3
  extends IListener<aee>
{
  WepkgListener$3(c paramc, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(278664);
    this.__eventId = aee.class.getName().hashCode();
    AppMethodBeat.o(278664);
  }
  
  private boolean a(aee paramaee)
  {
    AppMethodBeat.i(110791);
    boolean bool = com.tencent.mm.plugin.game.commlib.a.fDT();
    Log.d("MicroMsg.Wepkg.WepkgListener", "wepkg notify event operation:%d", new Object[] { Integer.valueOf(paramaee.iiI.hAf) });
    int i;
    switch (paramaee.iiI.hAf)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      for (;;)
      {
        AppMethodBeat.o(110791);
        return false;
        if (bool)
        {
          AppMethodBeat.o(110791);
          return false;
        }
        com.tencent.mm.plugin.game.commlib.c.a.fEf().a("wepkg_download_retry", new a.a()
        {
          public final void dun()
          {
            AppMethodBeat.i(278660);
            d.dqg().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(278661);
                Object localObject = new WepkgCrossProcessTask();
                ((WepkgCrossProcessTask)localObject).bUl = 2003;
                if (MMApplicationContext.isMMProcess()) {
                  ((WepkgCrossProcessTask)localObject).asn();
                }
                for (;;)
                {
                  localObject = ((WepkgCrossProcessTask)localObject).XFY;
                  if ((localObject != null) && (!Util.isNullOrNil(((WepkgVersion)localObject).mtT))) {
                    k.iFv().dU(((WepkgVersion)localObject).mtT, true);
                  }
                  AppMethodBeat.o(278661);
                  return;
                  ((WepkgCrossProcessTask)localObject).cpB();
                }
              }
            });
            AppMethodBeat.o(278660);
          }
        });
        continue;
        if (bool)
        {
          AppMethodBeat.o(110791);
          return false;
        }
        Object localObject = paramaee.iiI.iiJ;
        i = paramaee.iiI.iiM;
        int j = paramaee.iiI.iiN;
        paramaee = new HashSet();
        if (!Util.isNullOrNil((String)localObject))
        {
          if (j != 0) {
            break label206;
          }
          paramaee.add(localObject);
        }
        for (;;)
        {
          WepkgVersionUpdater.a(paramaee, 1, i, false);
          break;
          if ((j == 1) && (j.bou((String)localObject) != null)) {
            paramaee.add(localObject);
          }
        }
        if (bool)
        {
          AppMethodBeat.o(110791);
          return false;
        }
        localObject = paramaee.iiI;
        com.tencent.mm.plugin.wepkg.b.f localf = com.tencent.mm.plugin.wepkg.b.f.iFe();
        paramaee = paramaee.iiI.iiJ;
        if ((!localf.rqI) || (Util.isNullOrNil(paramaee))) {
          bool = false;
        }
        for (;;)
        {
          ((aee.a)localObject).iiK = bool;
          break;
          paramaee = localf.boa(paramaee);
          if ((paramaee != null) && (paramaee.field_bigPackageReady) && (paramaee.field_preloadFilesReady)) {
            bool = true;
          } else {
            bool = false;
          }
        }
        if (MMApplicationContext.isMMProcess())
        {
          com.tencent.mm.plugin.wepkg.model.c.iFn().iFo();
          continue;
          if (bool)
          {
            AppMethodBeat.o(110791);
            return false;
          }
          localObject = j.bov(paramaee.iiI.iiJ);
          if (localObject != null)
          {
            paramaee.iiI.iiL = ((WepkgVersion)localObject).XGP;
            Log.i("MicroMsg.Wepkg.WepkgListener", "total download count:%s", new Object[] { Integer.valueOf(paramaee.iiI.iiL) });
          }
        }
      }
    case 5: 
      label206:
      if (bool)
      {
        AppMethodBeat.o(110791);
        return false;
      }
      if (Util.secondsToNow(Util.nullAsNil((Long)h.baE().ban().get(at.a.acSB, Long.valueOf(0L)))) > 60L) {
        h.baE().ban().set(at.a.acSB, Long.valueOf(Util.nowSecond()));
      }
      break;
    }
    for (bool = c.a(this.XGY, 1); (!bool) && (Util.secondsToNow(Util.nullAsNil((Long)h.baE().ban().get(at.a.acSA, Long.valueOf(0L)))) > 1800L); bool = false)
    {
      h.baE().ban().set(at.a.acSA, Long.valueOf(Util.nowSecond()));
      paramaee = new aee();
      paramaee.iiI.hAf = 0;
      paramaee.publish();
      break;
      if (Util.isNullOrNil(paramaee.iiI.iiJ))
      {
        paramaee = com.tencent.mm.plugin.wepkg.model.c.iFn();
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          d.dqg().postToWorker(new c.2(paramaee));
          break;
        }
        com.tencent.mm.plugin.wepkg.model.c.aS(null, 0, 7);
        break;
      }
      com.tencent.mm.plugin.wepkg.model.c.iFn().aR(paramaee.iiI.iiJ, 2, 7);
      break;
      ToolsProcessIPCService.a(null, c.a.class, null);
      break;
      i = paramaee.iiI.scene;
      paramaee = paramaee.iiI.iiO;
      if (Util.isNullOrNil(paramaee)) {
        break;
      }
      switch (i)
      {
      default: 
        break;
      case 0: 
        WepkgVersionUpdater.Y(paramaee, 4);
        break;
      case 1: 
        WepkgVersionUpdater.Y(paramaee, 3);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.WepkgListener.3
 * JD-Core Version:    0.7.0.1
 */