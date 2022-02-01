package com.tencent.mm.plugin.updater.model;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/updater/model/UpdaterConfig;", "", "()V", "UpdaterConfigName", "", "getUpdaterCacheFolder", "getUpdaterSharePreference", "Landroid/content/SharedPreferences;", "plugin-updater_release"})
public final class d
{
  public static final d GwL;
  
  static
  {
    AppMethodBeat.i(194766);
    GwL = new d();
    AppMethodBeat.o(194766);
  }
  
  public static SharedPreferences fAO()
  {
    AppMethodBeat.i(194765);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("UpdaterConfigSharedPreferences", 0);
    p.g(localSharedPreferences, "MMApplicationContext.get…me, Context.MODE_PRIVATE)");
    AppMethodBeat.o(194765);
    return localSharedPreferences;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.d
 * JD-Core Version:    0.7.0.1
 */