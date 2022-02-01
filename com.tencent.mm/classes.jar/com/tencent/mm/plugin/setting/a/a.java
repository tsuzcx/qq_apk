package com.tencent.mm.plugin.setting.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.al;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/setting/report/FindMoreSettingReport;", "", "()V", "TAG", "", "reportNearby3TabSwitch", "", "switch", "", "reportNearbyPersonSwitch", "reportNearbySwitch", "entranceId", "", "settingEvent", "plugin-setting_release"})
public final class a
{
  public static final a CYr;
  
  static
  {
    AppMethodBeat.i(256606);
    CYr = new a();
    AppMethodBeat.o(256606);
  }
  
  public static void ak(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(256605);
    al localal = new al();
    localal.cd(paramLong1);
    localal.ce(paramLong2);
    localal.acd();
    localal.bfK();
    Log.d("FindMoreSettingReport", "reportNearbySwitch " + localal.abW());
    AppMethodBeat.o(256605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.a.a
 * JD-Core Version:    0.7.0.1
 */