package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/model/RadarKvStatReport;", "", "()V", "TAG", "", "enterStartAt", "", "kRadarEnterKey", "kRadarID", "memberCount", "", "memberTotalCount", "searchCount", "searchStartAt", "searchTotalDuring", "FoundFirstFriendTimeSpent", "", "fFoundFirstFriendTimeSpent", "", "FoundFriendsCnt", "nFoundFriendsCnt", "RadarAddFriendStat", "nUserCount", "nTouchTotalCnt", "fTimeSpent", "nFoundFriendsTotalCnt", "fStayTimeSpent", "current", "enterReset", "radarEnter", "radarQuit", "radarReceiveMember", "count", "radarSearchStart", "radarSearchStop", "reportRadarEnterIDKey", "searchReset", "plugin-radar_release"})
public final class d
{
  public static final String TAG = "MicroMsg.RadarKvStatReport";
  public static int dAb = 0;
  public static long xyA = 0L;
  public static long xyB = 0L;
  public static long xyC = 0L;
  public static int xyD = 0;
  private static final long xyE = 759L;
  private static final long xyF = 0L;
  public static final d xyG;
  public static int xyz;
  
  static
  {
    AppMethodBeat.i(138548);
    xyG = new d();
    TAG = "MicroMsg.RadarKvStatReport";
    xyE = 759L;
    AppMethodBeat.o(138548);
  }
  
  public static void dGs()
  {
    AppMethodBeat.i(138545);
    dAb = 0;
    xyC = 0L;
    xyC = System.currentTimeMillis();
    AppMethodBeat.o(138545);
  }
  
  public static void dGt()
  {
    AppMethodBeat.i(138546);
    xyD = 0;
    xyB = 0L;
    xyz = 0;
    xyA = 0L;
    xyB = System.currentTimeMillis();
    g.yxI.idkeyStat(xyE, xyF, 1L, false);
    AppMethodBeat.o(138546);
  }
  
  public static long dGu()
  {
    AppMethodBeat.i(224450);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(224450);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.d
 * JD-Core Version:    0.7.0.1
 */