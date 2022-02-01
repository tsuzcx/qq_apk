package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/model/RadarKvStatReport;", "", "()V", "TAG", "", "enterStartAt", "", "kRadarEnterKey", "kRadarID", "memberCount", "", "memberTotalCount", "searchCount", "searchStartAt", "searchTotalDuring", "FoundFirstFriendTimeSpent", "", "fFoundFirstFriendTimeSpent", "", "FoundFriendsCnt", "nFoundFriendsCnt", "RadarAddFriendStat", "nUserCount", "nTouchTotalCnt", "fTimeSpent", "nFoundFriendsTotalCnt", "fStayTimeSpent", "current", "enterReset", "radarEnter", "radarQuit", "radarReceiveMember", "count", "radarSearchStart", "radarSearchStop", "reportRadarEnterIDKey", "searchReset", "plugin-radar_release"})
public final class d
{
  public static final String TAG = "MicroMsg.RadarKvStatReport";
  public static int dni = 0;
  public static int waT = 0;
  public static long waU = 0L;
  public static long waV = 0L;
  public static long waW = 0L;
  public static int waX = 0;
  private static final long waY = 759L;
  private static final long waZ = 0L;
  public static final d wba;
  
  static
  {
    AppMethodBeat.i(138548);
    wba = new d();
    TAG = "MicroMsg.RadarKvStatReport";
    waY = 759L;
    AppMethodBeat.o(138548);
  }
  
  public static void dsE()
  {
    AppMethodBeat.i(138545);
    dni = 0;
    waW = 0L;
    waW = System.currentTimeMillis();
    AppMethodBeat.o(138545);
  }
  
  public static void dsF()
  {
    AppMethodBeat.i(138546);
    waX = 0;
    waV = 0L;
    waT = 0;
    waU = 0L;
    waV = System.currentTimeMillis();
    h.wUl.idkeyStat(waY, waZ, 1L, false);
    AppMethodBeat.o(138546);
  }
  
  public static long dsG()
  {
    AppMethodBeat.i(210330);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(210330);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.d
 * JD-Core Version:    0.7.0.1
 */