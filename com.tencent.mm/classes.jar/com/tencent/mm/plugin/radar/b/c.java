package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/model/RadarKvStatReport;", "", "()V", "TAG", "", "enterStartAt", "", "kRadarEnterKey", "kRadarID", "memberCount", "", "memberTotalCount", "searchCount", "searchStartAt", "searchTotalDuring", "FoundFirstFriendTimeSpent", "", "fFoundFirstFriendTimeSpent", "", "FoundFriendsCnt", "nFoundFriendsCnt", "RadarAddFriendStat", "nUserCount", "nTouchTotalCnt", "fTimeSpent", "nFoundFriendsTotalCnt", "fStayTimeSpent", "current", "enterReset", "radarEnter", "radarQuit", "radarReceiveMember", "count", "radarSearchStart", "radarSearchStop", "reportRadarEnterIDKey", "searchReset", "plugin-radar_release"})
public final class c
{
  public static int HtX = 0;
  public static long HtY = 0L;
  public static long HtZ = 0L;
  public static long Hua = 0L;
  public static int Hub = 0;
  private static final long Huc = 759L;
  private static final long Hud = 0L;
  public static final c Hue;
  public static final String TAG = "MicroMsg.RadarKvStatReport";
  public static int fLk;
  
  static
  {
    AppMethodBeat.i(138548);
    Hue = new c();
    TAG = "MicroMsg.RadarKvStatReport";
    Huc = 759L;
    AppMethodBeat.o(138548);
  }
  
  public static void ftk()
  {
    AppMethodBeat.i(138545);
    fLk = 0;
    Hua = 0L;
    Hua = System.currentTimeMillis();
    AppMethodBeat.o(138545);
  }
  
  public static void ftl()
  {
    AppMethodBeat.i(138546);
    Hub = 0;
    HtZ = 0L;
    HtX = 0;
    HtY = 0L;
    HtZ = System.currentTimeMillis();
    h.IzE.idkeyStat(Huc, Hud, 1L, false);
    AppMethodBeat.o(138546);
  }
  
  public static long ftm()
  {
    AppMethodBeat.i(292944);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(292944);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.c
 * JD-Core Version:    0.7.0.1
 */