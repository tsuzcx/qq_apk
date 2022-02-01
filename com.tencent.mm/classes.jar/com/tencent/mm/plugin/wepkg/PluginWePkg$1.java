package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.plugin.game.d.db;
import com.tencent.mm.plugin.game.d.ee;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class PluginWePkg$1
  implements com.tencent.mm.plugin.game.commlib.d.b
{
  PluginWePkg$1(PluginWePkg paramPluginWePkg) {}
  
  public final void agl()
  {
    AppMethodBeat.i(110517);
    d.bZb().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110516);
        Object localObject1 = b.a.cWM();
        if (localObject1 != null) {
          aj.getContext();
        }
        for (boolean bool1 = ((com.tencent.mm.plugin.game.api.b)localObject1).cWA();; bool1 = false)
        {
          int i;
          if ((u.aAr() & 0x800000) != 0L)
          {
            i = 1;
            if (i != 0) {
              break label191;
            }
          }
          Object localObject2;
          Object localObject3;
          label191:
          for (boolean bool2 = true;; bool2 = false)
          {
            ad.i("MicroMsg.WePkg.PluginWePkg", "shouldShowGame %s, openGameEntry %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if ((!bool1) || (i != 0)) {
              break label381;
            }
            if (a.tSI == null) {
              break label387;
            }
            if (a.tSI.uhE == null) {
              break label390;
            }
            localObject2 = a.tSI.uhE.uko;
            if (bt.hj((List)localObject2)) {
              break label390;
            }
            localObject1 = new ArrayList();
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (db)((Iterator)localObject2).next();
              if ((localObject3 != null) && (!bt.isNullOrNil(((db)localObject3).ufQ))) {
                ((List)localObject1).add(((db)localObject3).ufQ);
              }
            }
            i = 0;
            break;
          }
          for (;;)
          {
            localObject3 = a.cWS();
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ad.i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgIdsForAll size:%d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = new ArrayList();
            }
            ad.i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgIdsIfExists size:%d", new Object[] { Integer.valueOf(((List)localObject1).size()) });
            Object localObject4 = f.eXN().eXO();
            localObject3 = localObject4;
            if (localObject4 == null) {
              localObject3 = new ArrayList();
            }
            ad.i("MicroMsg.Wepkg.WepkgVersionUpdater", "localPkgIdList size:%d", new Object[] { Integer.valueOf(((List)localObject3).size()) });
            localObject4 = new HashSet();
            ((Set)localObject4).addAll((Collection)localObject3);
            ((Set)localObject4).retainAll((Collection)localObject1);
            ((Set)localObject4).addAll((Collection)localObject2);
            WepkgVersionUpdater.a((Set)localObject4, 2, true);
            label381:
            AppMethodBeat.o(110516);
            return;
            label387:
            a.cWO();
            label390:
            localObject1 = null;
          }
        }
      }
    });
    AppMethodBeat.o(110517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.PluginWePkg.1
 * JD-Core Version:    0.7.0.1
 */