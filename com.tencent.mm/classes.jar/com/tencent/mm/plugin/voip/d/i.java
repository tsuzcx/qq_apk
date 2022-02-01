package com.tencent.mm.plugin.voip.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ut;
import com.tencent.mm.plugin.voip.video.a.d;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONArray;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/report/VoipVideoBackgroundReport;", "", "()V", "connectTime", "", "dialTime", "hangUpTime", "memberIdx", "roomId", "roomKey", "roomType", "doReport", "", "markConnect", "markHangUp", "markRoomInfo", "", "markStartVoIP", "isMultipleVoIP", "", "isCaller", "release", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  private static long Hnt;
  private static long JIt;
  public static final i UHA;
  private static long UHB;
  private static long UHC;
  private static long UHD;
  private static long UHE;
  private static long roomId;
  
  static
  {
    AppMethodBeat.i(292800);
    UHA = new i();
    AppMethodBeat.o(292800);
  }
  
  public static void Gy(boolean paramBoolean)
  {
    long l = 1L;
    AppMethodBeat.i(292763);
    UHB = 1L;
    if (paramBoolean) {}
    for (;;)
    {
      UHC = l;
      UHD = System.currentTimeMillis();
      AppMethodBeat.o(292763);
      return;
      l = 2L;
    }
  }
  
  public static void bi(int paramInt, long paramLong)
  {
    roomId = paramInt;
    Hnt = paramLong;
  }
  
  public static void cIX()
  {
    AppMethodBeat.i(292793);
    ut localut = new ut();
    localut.iWQ = roomId;
    localut.iWR = Hnt;
    localut.jHQ = UHB;
    localut.jHR = UHC;
    localut.jHS = UHD;
    localut.jHT = JIt;
    localut.jHU = UHE;
    Object localObject = d.UPM;
    localObject = d.icR();
    if ((((JSONArray)localObject).length() > 0) && (UHD > 0L))
    {
      localObject = ((JSONArray)localObject).toString();
      s.s(localObject, "usageDetails.toString()");
      localut.jHV = localut.F("Background_event", n.jP(n.m((String)localObject, ",", ";", false), 1024), true);
      localut.bMH();
    }
    roomId = 0L;
    Hnt = 0L;
    UHB = 0L;
    UHC = 0L;
    UHD = 0L;
    JIt = 0L;
    UHE = 0L;
    AppMethodBeat.o(292793);
  }
  
  public static void fRQ()
  {
    AppMethodBeat.i(292777);
    JIt = System.currentTimeMillis();
    AppMethodBeat.o(292777);
  }
  
  public static void iag()
  {
    AppMethodBeat.i(292782);
    UHE = System.currentTimeMillis();
    AppMethodBeat.o(292782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.d.i
 * JD-Core Version:    0.7.0.1
 */