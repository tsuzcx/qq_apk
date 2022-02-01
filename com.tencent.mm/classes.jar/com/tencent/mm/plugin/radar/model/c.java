package com.tencent.mm.plugin.radar.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/model/RadarKvStatReport;", "", "()V", "TAG", "", "enterStartAt", "", "kRadarEnterKey", "kRadarID", "memberCount", "", "memberTotalCount", "searchCount", "searchStartAt", "searchTotalDuring", "FoundFirstFriendTimeSpent", "", "fFoundFirstFriendTimeSpent", "", "FoundFriendsCnt", "nFoundFriendsCnt", "RadarAddFriendStat", "nUserCount", "nTouchTotalCnt", "fTimeSpent", "nFoundFriendsTotalCnt", "fStayTimeSpent", "current", "enterReset", "radarEnter", "radarQuit", "radarReceiveMember", "count", "radarSearchStart", "radarSearchStop", "reportRadarEnterIDKey", "searchReset", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c NrL;
  public static int NrM;
  public static long NrN;
  public static long NrO;
  public static long NrP;
  public static int NrQ;
  private static final long NrR;
  private static final long NrS = 0L;
  public static final String TAG;
  public static int hQS;
  
  static
  {
    AppMethodBeat.i(138548);
    NrL = new c();
    TAG = "MicroMsg.RadarKvStatReport";
    NrR = 759L;
    AppMethodBeat.o(138548);
  }
  
  public static void gEW()
  {
    AppMethodBeat.i(138545);
    hQS = 0;
    NrP = 0L;
    NrP = System.currentTimeMillis();
    AppMethodBeat.o(138545);
  }
  
  public static void gEX()
  {
    AppMethodBeat.i(138546);
    NrQ = 0;
    NrO = 0L;
    NrM = 0;
    NrN = 0L;
    NrO = System.currentTimeMillis();
    h.OAn.idkeyStat(NrR, NrS, 1L, false);
    AppMethodBeat.o(138546);
  }
  
  public static long gEY()
  {
    AppMethodBeat.i(369741);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(369741);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.model.c
 * JD-Core Version:    0.7.0.1
 */