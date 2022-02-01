package com.tencent.mm.plugin.updater.model;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/updater/model/UpdaterConfig;", "", "()V", "UpdaterConfigName", "", "getUpdaterCacheFolder", "getUpdaterSharePreference", "Landroid/content/SharedPreferences;", "plugin-updater_release"})
public final class d
{
  public static final d Nke;
  
  static
  {
    AppMethodBeat.i(196052);
    Nke = new d();
    AppMethodBeat.o(196052);
  }
  
  public static SharedPreferences gsP()
  {
    AppMethodBeat.i(196050);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("UpdaterConfigSharedPreferences", 0);
    p.j(localSharedPreferences, "MMApplicationContext.get…me, Context.MODE_PRIVATE)");
    AppMethodBeat.o(196050);
    return localSharedPreferences;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.d
 * JD-Core Version:    0.7.0.1
 */