package com.tencent.mm.plugin.radar.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/model/RadarKvStatReport;", "", "()V", "TAG", "", "enterStartAt", "", "kRadarEnterKey", "kRadarID", "memberCount", "", "memberTotalCount", "searchCount", "searchStartAt", "searchTotalDuring", "FoundFirstFriendTimeSpent", "", "fFoundFirstFriendTimeSpent", "", "FoundFriendsCnt", "nFoundFriendsCnt", "RadarAddFriendStat", "nUserCount", "nTouchTotalCnt", "fTimeSpent", "nFoundFriendsTotalCnt", "fStayTimeSpent", "current", "enterReset", "radarEnter", "radarQuit", "radarReceiveMember", "count", "radarSearchStart", "radarSearchStop", "reportRadarEnterIDKey", "searchReset", "plugin-radar_release"})
public final class d
{
  public static final String TAG = "MicroMsg.RadarKvStatReport";
  public static int czr = 0;
  public static int pQh = 0;
  public static long pQi = 0L;
  public static long pQj = 0L;
  public static long pQk = 0L;
  public static int pQl = 0;
  private static final long pQm = 759L;
  private static final long pQn = 0L;
  public static final d pQo;
  
  static
  {
    AppMethodBeat.i(102903);
    pQo = new d();
    TAG = "MicroMsg.RadarKvStatReport";
    pQm = 759L;
    AppMethodBeat.o(102903);
  }
  
  public static void ceJ()
  {
    AppMethodBeat.i(102900);
    czr = 0;
    pQk = 0L;
    pQk = System.currentTimeMillis();
    AppMethodBeat.o(102900);
  }
  
  public static void ceK()
  {
    AppMethodBeat.i(102901);
    pQl = 0;
    pQj = 0L;
    pQh = 0;
    pQi = 0L;
    pQj = System.currentTimeMillis();
    h.qsU.idkeyStat(pQm, pQn, 1L, false);
    AppMethodBeat.o(102901);
  }
  
  public static long ceL()
  {
    AppMethodBeat.i(156805);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(156805);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.d
 * JD-Core Version:    0.7.0.1
 */