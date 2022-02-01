package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/model/RadarKvStatReport;", "", "()V", "TAG", "", "enterStartAt", "", "kRadarEnterKey", "kRadarID", "memberCount", "", "memberTotalCount", "searchCount", "searchStartAt", "searchTotalDuring", "FoundFirstFriendTimeSpent", "", "fFoundFirstFriendTimeSpent", "", "FoundFriendsCnt", "nFoundFriendsCnt", "RadarAddFriendStat", "nUserCount", "nTouchTotalCnt", "fTimeSpent", "nFoundFriendsTotalCnt", "fStayTimeSpent", "current", "enterReset", "radarEnter", "radarQuit", "radarReceiveMember", "count", "radarSearchStart", "radarSearchStop", "reportRadarEnterIDKey", "searchReset", "plugin-radar_release"})
public final class d
{
  public static int ByA = 0;
  public static long ByB = 0L;
  public static long ByC = 0L;
  public static long ByD = 0L;
  public static int ByE = 0;
  private static final long ByF = 759L;
  private static final long ByG = 0L;
  public static final d ByH;
  public static final String TAG = "MicroMsg.RadarKvStatReport";
  public static int dRN;
  
  static
  {
    AppMethodBeat.i(138548);
    ByH = new d();
    TAG = "MicroMsg.RadarKvStatReport";
    ByF = 759L;
    AppMethodBeat.o(138548);
  }
  
  public static void eHg()
  {
    AppMethodBeat.i(138545);
    dRN = 0;
    ByD = 0L;
    ByD = System.currentTimeMillis();
    AppMethodBeat.o(138545);
  }
  
  public static void eHh()
  {
    AppMethodBeat.i(138546);
    ByE = 0;
    ByC = 0L;
    ByA = 0;
    ByB = 0L;
    ByC = System.currentTimeMillis();
    h.CyF.idkeyStat(ByF, ByG, 1L, false);
    AppMethodBeat.o(138546);
  }
  
  public static long eHi()
  {
    AppMethodBeat.i(258704);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(258704);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.d
 * JD-Core Version:    0.7.0.1
 */