package com.tencent.mm.plugin.setting.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.bf;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/report/FindMoreSettingReport;", "", "()V", "TAG", "", "reportFinderLiveSwitch", "", "switch", "", "reportNearby3TabSwitch", "reportNearbyPersonSwitch", "reportSwitch", "entranceId", "", "settingEvent", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Por;
  
  static
  {
    AppMethodBeat.i(298503);
    Por = new b();
    AppMethodBeat.o(298503);
  }
  
  public static void bd(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(298496);
    bf localbf = new bf();
    localbf.iqR = paramLong1;
    localbf.iqS = paramLong2;
    localbf.iqT = 1L;
    localbf.bMH();
    Log.i("FindMoreSettingReport", s.X("reportSwitch ", localbf.aIF()));
    AppMethodBeat.o(298496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.a.b
 * JD-Core Version:    0.7.0.1
 */