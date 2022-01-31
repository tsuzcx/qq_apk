package com.tencent.mm.plugin.wepkg.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.Iterator;
import java.util.List;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(63501);
    Object localObject1 = ah.getContext().getSharedPreferences("we_pkg_sp", 0);
    long l1 = ((SharedPreferences)localObject1).getLong("clean_wepkg_time", 0L);
    Object localObject2;
    if (System.currentTimeMillis() - l1 > 86400000L)
    {
      i = 1;
      if (i == 0) {
        break label211;
      }
      ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg in one day");
      ((SharedPreferences)localObject1).edit().putLong("clean_wepkg_time", System.currentTimeMillis()).commit();
      localObject2 = new WepkgCrossProcessTask();
      ((WepkgCrossProcessTask)localObject2).vA = 2005;
      if (!ah.brt()) {
        break label195;
      }
      ((WepkgCrossProcessTask)localObject2).ata();
    }
    for (;;)
    {
      localObject2 = ((WepkgCrossProcessTask)localObject2).vGc;
      if (bo.es((List)localObject2)) {
        break label204;
      }
      ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "need to clean list.size:%s", new Object[] { Integer.valueOf(((List)localObject2).size()) });
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        WepkgVersion localWepkgVersion = (WepkgVersion)((Iterator)localObject2).next();
        if (localWepkgVersion != null) {
          b.ef(localWepkgVersion.ezY, 2);
        }
      }
      i = 0;
      break;
      label195:
      WepkgMainProcessService.b((WepkgMainProcessTask)localObject2);
    }
    label204:
    ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "no need to clean wepkg");
    label211:
    l1 = ((SharedPreferences)localObject1).getLong("clean_dirty_wepkg_time", 0L);
    if (System.currentTimeMillis() - l1 > 172800000L)
    {
      i = 1;
      if (i != 0)
      {
        ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "start clean dirty wepkg");
        ((SharedPreferences)localObject1).edit().putLong("clean_dirty_wepkg_time", System.currentTimeMillis()).commit();
        b.dkC();
      }
      l1 = ((SharedPreferences)localObject1).getLong("clean_extra_wepkg_time", 0L);
      if (System.currentTimeMillis() - l1 <= 3600000L) {
        break label405;
      }
    }
    label405:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label476;
      }
      ((SharedPreferences)localObject1).edit().putLong("clean_extra_wepkg_time", System.currentTimeMillis()).commit();
      long l2 = System.currentTimeMillis();
      l1 = b.a(this.vFN, new File(c.vFO));
      ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "local wepkg size: %d, cost time: %d", new Object[] { Long.valueOf(l1), Long.valueOf(System.currentTimeMillis() - l2) });
      localObject1 = f.dkq().dks();
      if (!bo.es((List)localObject1)) {
        break label489;
      }
      AppMethodBeat.o(63501);
      return;
      i = 0;
      break;
    }
    label476:
    label489:
    for (;;)
    {
      if ((l1 > 104857600L) && (((List)localObject1).size() > 0))
      {
        localObject2 = (String)((List)localObject1).remove(0);
        if (!bo.isNullOrNil((String)localObject2))
        {
          b.ef((String)localObject2, 2);
          l1 = b.a(this.vFN, new File(c.vFO));
        }
      }
      else
      {
        ab.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg finish!");
        AppMethodBeat.o(63501);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.b.1
 * JD-Core Version:    0.7.0.1
 */