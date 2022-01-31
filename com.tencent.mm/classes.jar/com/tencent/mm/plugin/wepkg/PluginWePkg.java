package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.downloader.i;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public class PluginWePkg
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.wepkg.a.a
{
  private com.tencent.mm.plugin.wepkg.utils.c vEs;
  
  public void configure(g paramg) {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(63347);
    if (paramg.SD()) {
      com.tencent.mm.plugin.game.commlib.c.a.a(new PluginWePkg.1(this));
    }
    if (paramg.mI(":tools")) {
      try
      {
        b.bjT();
        AppMethodBeat.o(63347);
        return;
      }
      catch (Exception paramg)
      {
        ab.printErrStackTrace("MicroMsg.WePkg.PluginWePkg", paramg, "", new Object[0]);
        h.qsU.idkeyStat(859L, 19L, 1L, false);
      }
    }
    AppMethodBeat.o(63347);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(63348);
    if (this.vEs == null) {
      this.vEs = new com.tencent.mm.plugin.wepkg.utils.c();
    }
    paramc = this.vEs;
    ab.i("MicroMsg.Wepkg.WepkgListener", "wepkg start listen");
    com.tencent.mm.sdk.b.a.ymk.c(paramc.vHb);
    com.tencent.mm.sdk.b.a.ymk.c(paramc.vHa);
    i.bje();
    paramc.appForegroundListener.alive();
    paramc = ah.getContext();
    if (paramc != null) {
      try
      {
        paramc = paramc.getSharedPreferences("we_pkg_sp", 4);
        if (paramc == null)
        {
          ab.e("MicroMsg.Wepkg.WepkgListener", "sp is null");
          AppMethodBeat.o(63348);
          return;
        }
        if (paramc.getBoolean("disable_we_pkg", false))
        {
          ab.i("MicroMsg.Wepkg.WepkgListener", "enable wepkg");
          paramc.edit().putBoolean("disable_we_pkg", false).commit();
        }
        paramc.edit().putInt("white_screen_times", 0).commit();
        AppMethodBeat.o(63348);
        return;
      }
      catch (Exception paramc)
      {
        ab.e("MicroMsg.Wepkg.WepkgListener", paramc.getMessage());
      }
    }
    AppMethodBeat.o(63348);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63349);
    com.tencent.mm.plugin.wepkg.utils.c localc = this.vEs;
    ab.i("MicroMsg.Wepkg.WepkgListener", "wepkg stop listen");
    com.tencent.mm.sdk.b.a.ymk.d(localc.vHb);
    localc.appForegroundListener.dead();
    com.tencent.mm.sdk.b.a.ymk.d(localc.vHa);
    i.bjf();
    d.aNR();
    this.vEs = null;
    AppMethodBeat.o(63349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.PluginWePkg
 * JD-Core Version:    0.7.0.1
 */