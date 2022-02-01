package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/model/RadarKvStatReport;", "", "()V", "TAG", "", "enterStartAt", "", "kRadarEnterKey", "kRadarID", "memberCount", "", "memberTotalCount", "searchCount", "searchStartAt", "searchTotalDuring", "FoundFirstFriendTimeSpent", "", "fFoundFirstFriendTimeSpent", "", "FoundFriendsCnt", "nFoundFriendsCnt", "RadarAddFriendStat", "nUserCount", "nTouchTotalCnt", "fTimeSpent", "nFoundFriendsTotalCnt", "fStayTimeSpent", "current", "enterReset", "radarEnter", "radarQuit", "radarReceiveMember", "count", "radarSearchStart", "radarSearchStop", "reportRadarEnterIDKey", "searchReset", "plugin-radar_release"})
public final class d
{
  public static final String TAG = "MicroMsg.RadarKvStatReport";
  public static int dpx = 0;
  public static int uSe = 0;
  public static long uSf = 0L;
  public static long uSg = 0L;
  public static long uSh = 0L;
  public static int uSi = 0;
  private static final long uSj = 759L;
  private static final long uSk = 0L;
  public static final d uSl;
  
  static
  {
    AppMethodBeat.i(138548);
    uSl = new d();
    TAG = "MicroMsg.RadarKvStatReport";
    uSj = 759L;
    AppMethodBeat.o(138548);
  }
  
  public static void deX()
  {
    AppMethodBeat.i(138545);
    dpx = 0;
    uSh = 0L;
    uSh = System.currentTimeMillis();
    AppMethodBeat.o(138545);
  }
  
  public static void deY()
  {
    AppMethodBeat.i(138546);
    uSi = 0;
    uSg = 0L;
    uSe = 0;
    uSf = 0L;
    uSg = System.currentTimeMillis();
    h.vKh.idkeyStat(uSj, uSk, 1L, false);
    AppMethodBeat.o(138546);
  }
  
  public static long deZ()
  {
    AppMethodBeat.i(205870);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(205870);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.d
 * JD-Core Version:    0.7.0.1
 */