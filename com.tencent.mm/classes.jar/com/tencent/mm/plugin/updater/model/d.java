package com.tencent.mm.plugin.updater.model;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/updater/model/UpdaterConfig;", "", "()V", "UpdaterConfigName", "", "getUpdaterCacheFolder", "getUpdaterSharePreference", "Landroid/content/SharedPreferences;", "plugin-updater_release"})
public final class d
{
  public static final d BWg;
  
  static
  {
    AppMethodBeat.i(197795);
    BWg = new d();
    AppMethodBeat.o(197795);
  }
  
  public static SharedPreferences evv()
  {
    AppMethodBeat.i(197794);
    SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("UpdaterConfigSharedPreferences", 0);
    p.g(localSharedPreferences, "MMApplicationContext.get…me, Context.MODE_PRIVATE)");
    AppMethodBeat.o(197794);
    return localSharedPreferences;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.d
 * JD-Core Version:    0.7.0.1
 */