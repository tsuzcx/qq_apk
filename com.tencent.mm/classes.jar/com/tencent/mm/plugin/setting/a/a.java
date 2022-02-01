package com.tencent.mm.plugin.setting.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.at;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/setting/report/FindMoreSettingReport;", "", "()V", "TAG", "", "reportFinderLiveSwitch", "", "switch", "", "reportNearby3TabSwitch", "reportNearbyPersonSwitch", "reportSwitch", "entranceId", "", "settingEvent", "plugin-setting_release"})
public final class a
{
  public static final a JdX;
  
  static
  {
    AppMethodBeat.i(263811);
    JdX = new a();
    AppMethodBeat.o(263811);
  }
  
  public static void at(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(263810);
    at localat = new at();
    localat.cI(paramLong1);
    localat.cJ(paramLong2);
    localat.agQ();
    localat.bpa();
    Log.i("FindMoreSettingReport", "reportSwitch " + localat.agI());
    AppMethodBeat.o(263810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.a.a
 * JD-Core Version:    0.7.0.1
 */