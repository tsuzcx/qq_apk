package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class PluginWePkg$1$1
  implements Runnable
{
  PluginWePkg$1$1(PluginWePkg.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(63345);
    Object localObject1 = b.a.bEX();
    if (localObject1 != null) {
      ah.getContext();
    }
    for (boolean bool1 = ((b)localObject1).bEM();; bool1 = false)
    {
      int i;
      if ((r.Zs() & 0x800000) != 0L)
      {
        i = 1;
        if (i != 0) {
          break label281;
        }
      }
      label281:
      for (boolean bool2 = true;; bool2 = false)
      {
        ab.i("MicroMsg.WePkg.PluginWePkg", "shouldShowGame %s, openGameEntry %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((bool1) && (i == 0))
        {
          Object localObject2 = a.bFf();
          Object localObject3 = a.bFg();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new ArrayList();
          }
          ab.i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgIdsForAll size:%d", new Object[] { Integer.valueOf(((List)localObject1).size()) });
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = new ArrayList();
          }
          ab.i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgIdsIfExists size:%d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
          Object localObject4 = f.dkq().dkr();
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = new ArrayList();
          }
          ab.i("MicroMsg.Wepkg.WepkgVersionUpdater", "localPkgIdList size:%d", new Object[] { Integer.valueOf(((List)localObject3).size()) });
          localObject4 = new HashSet();
          ((Set)localObject4).addAll((Collection)localObject3);
          ((Set)localObject4).retainAll((Collection)localObject2);
          ((Set)localObject4).addAll((Collection)localObject1);
          WepkgVersionUpdater.a((Set)localObject4, 2, true);
        }
        AppMethodBeat.o(63345);
        return;
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.PluginWePkg.1.1
 * JD-Core Version:    0.7.0.1
 */