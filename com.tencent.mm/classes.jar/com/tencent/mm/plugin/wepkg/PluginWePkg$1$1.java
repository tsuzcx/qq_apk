package com.tencent.mm.plugin.wepkg;

import com.tencent.mm.model.q;
import com.tencent.mm.plugin.game.a.a.a;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

final class PluginWePkg$1$1
  implements Runnable
{
  PluginWePkg$1$1(PluginWePkg.1 param1) {}
  
  public final void run()
  {
    Object localObject1 = a.a.aYi();
    if (localObject1 != null) {}
    for (boolean bool1 = ((com.tencent.mm.plugin.game.a.a)localObject1).aXZ();; bool1 = false)
    {
      int i;
      boolean bool2;
      label38:
      Object localObject2;
      Object localObject3;
      if ((q.Go() & 0x800000) != 0L)
      {
        i = 1;
        if (i != 0) {
          break label336;
        }
        bool2 = true;
        y.i("MicroMsg.WePkg.PluginWePkg", "shouldShowGame %s, openGameEntry %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((!bool1) || (i != 0)) {
          break label420;
        }
        localObject2 = com.tencent.mm.plugin.game.commlib.a.aYq();
        y.i("MicroMsg.Wepkg.WepkgVersionUpdater", "batch update wepkg begin");
        localObject1 = localObject2;
        if (bk.dk((List)localObject2)) {
          localObject1 = new ArrayList();
        }
        y.i("MicroMsg.Wepkg.WepkgVersionUpdater", "configPkgIdList size:%d", new Object[] { Integer.valueOf(((List)localObject1).size()) });
        localObject3 = com.tencent.mm.plugin.wepkg.b.d.cjN().cjO();
        localObject2 = localObject3;
        if (bk.dk((List)localObject3)) {
          localObject2 = new ArrayList();
        }
        y.i("MicroMsg.Wepkg.WepkgVersionUpdater", "localPkgIdList size:%d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
        localObject3 = new HashSet();
        ((Set)localObject3).addAll((Collection)localObject1);
        ((Set)localObject3).addAll((Collection)localObject2);
        ((Set)localObject3).add(a.cjz());
        if (((Set)localObject3).size() == 0) {
          break label420;
        }
        localObject1 = new LinkedList();
        localObject2 = ((Set)localObject3).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label383;
        }
        localObject3 = (String)((Iterator)localObject2).next();
        if (!bk.bl((String)localObject3))
        {
          qp localqp = new qp();
          localqp.kSE = ((String)localObject3);
          localqp.pyo = 2;
          WepkgVersion localWepkgVersion = f.Vj((String)localObject3);
          if (localWepkgVersion == null)
          {
            localqp.hQE = "";
            ((LinkedList)localObject1).add(localqp);
            continue;
            i = 0;
            break;
            label336:
            bool2 = false;
            break label38;
          }
          localqp.hQE = localWepkgVersion.version;
          long l = localWepkgVersion.rPX;
          if (com.tencent.mm.plugin.wepkg.utils.d.aqv() >= l)
          {
            ((LinkedList)localObject1).add(localqp);
            WepkgVersionUpdater.Vv((String)localObject3);
          }
        }
      }
      label383:
      if (!bk.dk((List)localObject1))
      {
        y.i("MicroMsg.Wepkg.WepkgVersionUpdater", "batch update wepkg size:%d", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) });
        WepkgVersionUpdater.b((LinkedList)localObject1, 0, true);
      }
      label420:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.PluginWePkg.1.1
 * JD-Core Version:    0.7.0.1
 */