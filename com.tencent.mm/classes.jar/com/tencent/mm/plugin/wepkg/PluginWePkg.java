package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.downloader.i;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public class PluginWePkg
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.wepkg.a.a
{
  private com.tencent.mm.plugin.wepkg.utils.c rNO;
  
  public void configure(g paramg) {}
  
  public void execute(g paramg)
  {
    if (paramg.Ex()) {
      com.tencent.mm.plugin.game.commlib.c.a.a(new PluginWePkg.1(this));
    }
    if (paramg.gn(":tools")) {}
    try
    {
      b.aGq();
      return;
    }
    catch (Exception paramg)
    {
      y.printErrStackTrace("MicroMsg.WePkg.PluginWePkg", paramg, "", new Object[0]);
      h.nFQ.a(859L, 19L, 1L, false);
    }
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    if (this.rNO == null) {
      this.rNO = new com.tencent.mm.plugin.wepkg.utils.c();
    }
    paramc = this.rNO;
    y.i("MicroMsg.Wepkg.WepkgListener", "wepkg start listen");
    com.tencent.mm.sdk.b.a.udP.c(paramc.rQj);
    com.tencent.mm.sdk.b.a.udP.c(paramc.rQi);
    i.aFI();
    paramc = ae.getContext();
    if (paramc != null) {
      try
      {
        paramc = paramc.getSharedPreferences("we_pkg_sp", 4);
        if (paramc == null)
        {
          y.e("MicroMsg.Wepkg.WepkgListener", "sp is null");
          return;
        }
        if (paramc.getBoolean("disable_we_pkg", false))
        {
          y.i("MicroMsg.Wepkg.WepkgListener", "enable wepkg");
          paramc.edit().putBoolean("disable_we_pkg", false).commit();
        }
        paramc.edit().putInt("white_screen_times", 0).commit();
        return;
      }
      catch (Exception paramc)
      {
        y.e("MicroMsg.Wepkg.WepkgListener", paramc.getMessage());
      }
    }
  }
  
  public void onAccountRelease()
  {
    com.tencent.mm.plugin.wepkg.utils.c localc = this.rNO;
    y.i("MicroMsg.Wepkg.WepkgListener", "wepkg stop listen");
    com.tencent.mm.sdk.b.a.udP.d(localc.rQj);
    com.tencent.mm.sdk.b.a.udP.d(localc.rQi);
    i.aFJ();
    d.aqp();
    this.rNO = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.PluginWePkg
 * JD-Core Version:    0.7.0.1
 */