package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginWePkg
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.wepkg.a.a
{
  com.tencent.e.i.d EVB;
  private com.tencent.mm.plugin.wepkg.utils.c EVC;
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(209370);
    ae.i("MicroMsg.WePkg.PluginWePkg", "collectDatabaseFactory");
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("CHECK_WEPKG_VERSION".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wepkg.b.f.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("WEPKG_PRELOAD_FILES".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wepkg.b.d.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("WEPKG_DIFF_PACK".hashCode()), new PluginWePkg.6(this));
    AppMethodBeat.o(209370);
    return localHashMap;
  }
  
  public void configure(g paramg) {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(110518);
    if (paramg.akL())
    {
      ae.i("MicroMsg.WePkg.PluginWePkg", "PluginWePkg execute");
      com.tencent.mm.plugin.game.commlib.d.a.a(new PluginWePkg.1(this));
    }
    if ((paramg.xO(":tools")) || (paramg.xO(":toolsmp"))) {
      com.tencent.mm.plugin.game.commlib.c.a.cZE().a("preload_commlib", new PluginWePkg.2(this));
    }
    AppMethodBeat.o(110518);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(110519);
    ae.i("MicroMsg.WePkg.PluginWePkg", "onAccountInitialized");
    this.EVB = com.tencent.e.h.MqF.q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209369);
        if (PluginWePkg.this.EVC == null) {
          PluginWePkg.access$002(PluginWePkg.this, new com.tencent.mm.plugin.wepkg.utils.c());
        }
        Object localObject = PluginWePkg.this.EVC;
        ae.i("MicroMsg.Wepkg.WepkgListener", "wepkg start listen");
        com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.plugin.wepkg.utils.c)localObject).EYq);
        com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.plugin.wepkg.utils.c)localObject).EYp);
        com.tencent.mm.plugin.wepkg.downloader.i.cds();
        ((com.tencent.mm.plugin.wepkg.utils.c)localObject).appForegroundListener.alive();
        localObject = ak.getContext();
        if (localObject != null) {
          try
          {
            localObject = ((Context)localObject).getSharedPreferences("we_pkg_sp", 4);
            if (localObject == null)
            {
              ae.e("MicroMsg.Wepkg.WepkgListener", "sp is null");
              AppMethodBeat.o(209369);
              return;
            }
            if (((SharedPreferences)localObject).getBoolean("disable_we_pkg", false))
            {
              ae.i("MicroMsg.Wepkg.WepkgListener", "enable wepkg");
              ((SharedPreferences)localObject).edit().putBoolean("disable_we_pkg", false).commit();
            }
            ((SharedPreferences)localObject).edit().putInt("white_screen_times", 0).commit();
            AppMethodBeat.o(209369);
            return;
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.Wepkg.WepkgListener", localException.getMessage());
          }
        }
        AppMethodBeat.o(209369);
      }
    }, 1000L);
    AppMethodBeat.o(110519);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(110520);
    ae.i("MicroMsg.WePkg.PluginWePkg", "onAccountRelease");
    if (this.EVB != null) {
      this.EVB.cancel(true);
    }
    if (this.EVC != null)
    {
      com.tencent.mm.plugin.wepkg.utils.c localc = this.EVC;
      ae.i("MicroMsg.Wepkg.WepkgListener", "wepkg stop listen");
      com.tencent.mm.sdk.b.a.IvT.d(localc.EYq);
      localc.appForegroundListener.dead();
      com.tencent.mm.sdk.b.a.IvT.d(localc.EYp);
      com.tencent.mm.plugin.wepkg.downloader.i.cdt();
      com.tencent.mm.plugin.wepkg.utils.d.bCi();
      this.EVC = null;
    }
    AppMethodBeat.o(110520);
  }
  
  public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(209372);
    ae.i("MicroMsg.WePkg.PluginWePkg", "onDataBaseClosed");
    com.tencent.mm.plugin.wepkg.utils.b.EYo = false;
    AppMethodBeat.o(209372);
  }
  
  public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(209371);
    ae.i("MicroMsg.WePkg.PluginWePkg", "onDataBaseOpened");
    com.tencent.mm.plugin.wepkg.utils.b.EYo = true;
    AppMethodBeat.o(209371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.PluginWePkg
 * JD-Core Version:    0.7.0.1
 */