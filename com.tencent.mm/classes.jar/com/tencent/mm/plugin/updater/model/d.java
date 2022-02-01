package com.tencent.mm.plugin.updater.model;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/updater/model/UpdaterConfig;", "", "()V", "UpdaterConfigName", "", "getUpdaterCacheFolder", "getUpdaterSharePreference", "Landroid/content/SharedPreferences;", "plugin-updater_release"})
public final class d
{
  public static final d BEI;
  
  static
  {
    AppMethodBeat.i(214582);
    BEI = new d();
    AppMethodBeat.o(214582);
  }
  
  public static SharedPreferences erO()
  {
    AppMethodBeat.i(214581);
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("UpdaterConfigSharedPreferences", 0);
    p.g(localSharedPreferences, "MMApplicationContext.get…me, Context.MODE_PRIVATE)");
    AppMethodBeat.o(214581);
    return localSharedPreferences;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.d
 * JD-Core Version:    0.7.0.1
 */