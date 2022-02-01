package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginWePkg
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.wepkg.a.a
{
  com.tencent.e.i.d EDf;
  private com.tencent.mm.plugin.wepkg.utils.c EDg;
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(214442);
    ad.i("MicroMsg.WePkg.PluginWePkg", "collectDatabaseFactory");
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
    AppMethodBeat.o(214442);
    return localHashMap;
  }
  
  public void configure(g paramg) {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(110518);
    if (paramg.akw())
    {
      ad.i("MicroMsg.WePkg.PluginWePkg", "PluginWePkg execute");
      com.tencent.mm.plugin.game.commlib.d.a.a(new PluginWePkg.1(this));
    }
    if ((paramg.xf(":tools")) || (paramg.xf(":toolsmp"))) {
      com.tencent.mm.plugin.game.commlib.c.a.cWX().a("preload_commlib", new PluginWePkg.2(this));
    }
    AppMethodBeat.o(110518);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(110519);
    ad.i("MicroMsg.WePkg.PluginWePkg", "onAccountInitialized");
    this.EDf = com.tencent.e.h.LTJ.q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214441);
        if (PluginWePkg.this.EDg == null) {
          PluginWePkg.access$002(PluginWePkg.this, new com.tencent.mm.plugin.wepkg.utils.c());
        }
        Object localObject = PluginWePkg.this.EDg;
        ad.i("MicroMsg.Wepkg.WepkgListener", "wepkg start listen");
        com.tencent.mm.sdk.b.a.IbL.c(((com.tencent.mm.plugin.wepkg.utils.c)localObject).EFU);
        com.tencent.mm.sdk.b.a.IbL.c(((com.tencent.mm.plugin.wepkg.utils.c)localObject).EFT);
        com.tencent.mm.plugin.wepkg.downloader.i.ccd();
        ((com.tencent.mm.plugin.wepkg.utils.c)localObject).appForegroundListener.alive();
        localObject = aj.getContext();
        if (localObject != null) {
          try
          {
            localObject = ((Context)localObject).getSharedPreferences("we_pkg_sp", 4);
            if (localObject == null)
            {
              ad.e("MicroMsg.Wepkg.WepkgListener", "sp is null");
              AppMethodBeat.o(214441);
              return;
            }
            if (((SharedPreferences)localObject).getBoolean("disable_we_pkg", false))
            {
              ad.i("MicroMsg.Wepkg.WepkgListener", "enable wepkg");
              ((SharedPreferences)localObject).edit().putBoolean("disable_we_pkg", false).commit();
            }
            ((SharedPreferences)localObject).edit().putInt("white_screen_times", 0).commit();
            AppMethodBeat.o(214441);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.Wepkg.WepkgListener", localException.getMessage());
          }
        }
        AppMethodBeat.o(214441);
      }
    }, 1000L);
    AppMethodBeat.o(110519);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(110520);
    ad.i("MicroMsg.WePkg.PluginWePkg", "onAccountRelease");
    if (this.EDf != null) {
      this.EDf.cancel(true);
    }
    if (this.EDg != null)
    {
      com.tencent.mm.plugin.wepkg.utils.c localc = this.EDg;
      ad.i("MicroMsg.Wepkg.WepkgListener", "wepkg stop listen");
      com.tencent.mm.sdk.b.a.IbL.d(localc.EFU);
      localc.appForegroundListener.dead();
      com.tencent.mm.sdk.b.a.IbL.d(localc.EFT);
      com.tencent.mm.plugin.wepkg.downloader.i.cce();
      com.tencent.mm.plugin.wepkg.utils.d.bBo();
      this.EDg = null;
    }
    AppMethodBeat.o(110520);
  }
  
  public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(214444);
    ad.i("MicroMsg.WePkg.PluginWePkg", "onDataBaseClosed");
    com.tencent.mm.plugin.wepkg.utils.b.EFS = false;
    AppMethodBeat.o(214444);
  }
  
  public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(214443);
    ad.i("MicroMsg.WePkg.PluginWePkg", "onDataBaseOpened");
    com.tencent.mm.plugin.wepkg.utils.b.EFS = true;
    AppMethodBeat.o(214443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.PluginWePkg
 * JD-Core Version:    0.7.0.1
 */