package com.tencent.mm.plugin.updater.model;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/updater/model/UpdaterConfig;", "", "()V", "UpdaterConfigName", "", "getUpdaterCacheFolder", "getUpdaterSharePreference", "Landroid/content/SharedPreferences;", "plugin-updater_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d TWN;
  
  static
  {
    AppMethodBeat.i(265961);
    TWN = new d();
    AppMethodBeat.o(265961);
  }
  
  public static SharedPreferences hQd()
  {
    AppMethodBeat.i(265951);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("UpdaterConfigSharedPreferences", 0);
    s.s(localSharedPreferences, "getContext().getSharedPr…me, Context.MODE_PRIVATE)");
    AppMethodBeat.o(265951);
    return localSharedPreferences;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.d
 * JD-Core Version:    0.7.0.1
 */