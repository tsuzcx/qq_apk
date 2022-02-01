package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/model/RadarKvStatReport;", "", "()V", "TAG", "", "enterStartAt", "", "kRadarEnterKey", "kRadarID", "memberCount", "", "memberTotalCount", "searchCount", "searchStartAt", "searchTotalDuring", "FoundFirstFriendTimeSpent", "", "fFoundFirstFriendTimeSpent", "", "FoundFriendsCnt", "nFoundFriendsCnt", "RadarAddFriendStat", "nUserCount", "nTouchTotalCnt", "fTimeSpent", "nFoundFriendsTotalCnt", "fStayTimeSpent", "current", "enterReset", "radarEnter", "radarQuit", "radarReceiveMember", "count", "radarSearchStart", "radarSearchStop", "reportRadarEnterIDKey", "searchReset", "plugin-radar_release"})
public final class d
{
  public static final String TAG = "MicroMsg.RadarKvStatReport";
  public static int dyW = 0;
  public static int xiC = 0;
  public static long xiD = 0L;
  public static long xiE = 0L;
  public static long xiF = 0L;
  public static int xiG = 0;
  private static final long xiH = 759L;
  private static final long xiI = 0L;
  public static final d xiJ;
  
  static
  {
    AppMethodBeat.i(138548);
    xiJ = new d();
    TAG = "MicroMsg.RadarKvStatReport";
    xiH = 759L;
    AppMethodBeat.o(138548);
  }
  
  public static void dDb()
  {
    AppMethodBeat.i(138545);
    dyW = 0;
    xiF = 0L;
    xiF = System.currentTimeMillis();
    AppMethodBeat.o(138545);
  }
  
  public static void dDc()
  {
    AppMethodBeat.i(138546);
    xiG = 0;
    xiE = 0L;
    xiC = 0;
    xiD = 0L;
    xiE = System.currentTimeMillis();
    g.yhR.idkeyStat(xiH, xiI, 1L, false);
    AppMethodBeat.o(138546);
  }
  
  public static long dDd()
  {
    AppMethodBeat.i(221601);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(221601);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.d
 * JD-Core Version:    0.7.0.1
 */