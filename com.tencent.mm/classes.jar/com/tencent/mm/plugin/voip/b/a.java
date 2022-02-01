package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.f.b.a.re;
import com.tencent.mm.plugin.voip.c.g;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/report/VoipFeatureReport;", "", "()V", "audioDeviceChange", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "", "", "Lkotlin/collections/ArrayList;", "getAudioDeviceChange", "()Ljava/util/ArrayList;", "setAudioDeviceChange", "(Ljava/util/ArrayList;)V", "decodeChangeLists", "getDecodeChangeLists", "doubleLinkSwitch", "getDoubleLinkSwitch", "()Ljava/lang/Long;", "setDoubleLinkSwitch", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "encodeChangeLists", "getEncodeChangeLists", "encodeSizeChangeLists", "", "getEncodeSizeChangeLists", "fullViewChangeLists", "getFullViewChangeLists", "mBatteryCost", "getMBatteryCost", "()J", "setMBatteryCost", "(J)V", "mCameraStatus", "getMCameraStatus", "()I", "setMCameraStatus", "(I)V", "mCloseReason", "Lcom/tencent/mm/plugin/voip/report/VoipFeatureReport$VoipCloseReason;", "getMCloseReason", "()Lcom/tencent/mm/plugin/voip/report/VoipFeatureReport$VoipCloseReason;", "setMCloseReason", "(Lcom/tencent/mm/plugin/voip/report/VoipFeatureReport$VoipCloseReason;)V", "mPreviewSize", "getMPreviewSize", "()Ljava/lang/String;", "setMPreviewSize", "(Ljava/lang/String;)V", "mUseFaceBeauty", "getMUseFaceBeauty", "setMUseFaceBeauty", "mUseRemovePreviewCallback", "mUseRgb2Yuv", "mUseSTFilter", "getMUseSTFilter", "setMUseSTFilter", "mUseSurfaceEncode", "maxBatteryTemperate", "getMaxBatteryTemperate", "()Lkotlin/Pair;", "setMaxBatteryTemperate", "(Lkotlin/Pair;)V", "minBatteryTemperate", "getMinBatteryTemperate", "setMinBatteryTemperate", "miniViewChangeLists", "getMiniViewChangeLists", "renderType", "release", "", "reportFeature", "mTotalTime", "mVoipType", "transAudioDeviceChange", "transBatteryTemperateJson", "transDecodeChangeJson", "transDoubleLinkJson", "transEncodeChangeJson", "transEncodeSizeChange", "transFullViewJson", "transMiniViewJson", "VoipCloseReason", "plugin-voip_release"})
public final class a
{
  private static final ArrayList<o<Integer, Long>> NSQ;
  private static final ArrayList<o<Integer, Long>> NSR;
  private static final ArrayList<o<Long, Long>> NSS;
  private static final ArrayList<o<Long, Long>> NST;
  private static final ArrayList<o<String, Long>> NSU;
  private static Long NSV;
  private static ArrayList<o<Integer, Long>> NTc;
  private static o<Integer, Long> NTd;
  private static o<Integer, Long> NTe;
  public static final a NTi;
  private static long PVB;
  private static int PWH;
  private static int QQO;
  private static String QQP;
  private static int QQQ;
  private static int QQR;
  private static int QQS;
  private static int Qdq;
  private static a Qdr;
  private static int ksr;
  
  static
  {
    int j = 1;
    AppMethodBeat.i(235995);
    NTi = new a();
    NSQ = new ArrayList();
    NSR = new ArrayList();
    NSS = new ArrayList();
    NST = new ArrayList();
    NSU = new ArrayList();
    Qdr = a.NTj;
    QQP = "0";
    NTc = new ArrayList();
    if (g.gCD())
    {
      i = 1;
      ksr = i;
      if (!g.gCF()) {
        break label139;
      }
      i = 1;
      label108:
      QQQ = i;
      g localg = g.NXO;
      if (!g.gCH()) {
        break label144;
      }
    }
    label139:
    label144:
    for (int i = j;; i = 0)
    {
      QQR = i;
      AppMethodBeat.o(235995);
      return;
      i = 0;
      break;
      i = 0;
      break label108;
    }
  }
  
  public static void XV(long paramLong)
  {
    PVB = paramLong;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(293146);
    p.k(parama, "<set-?>");
    Qdr = parama;
    AppMethodBeat.o(293146);
  }
  
  public static void aY(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(293148);
    re localre = new re();
    localre.SF(paramLong2);
    localre.SM(paramLong1);
    Object localObject1 = new i();
    Object localObject2 = NSV;
    if (localObject2 != null)
    {
      paramLong1 = ((Number)localObject2).longValue();
      ((i)localObject1).al("doubleLinkSwitch", 1);
      ((i)localObject1).s("currentTimes", paramLong1);
    }
    localObject1 = ((i)localObject1).toString();
    p.j(localObject1, "json.toString()");
    localre.abf(n.l((String)localObject1, ",", ";", false));
    localre.abg(QQP);
    localre.SN(QQQ);
    localre.TN(QQR);
    localre.Wr(PWH);
    localre.XP(Qdq);
    localObject1 = new i();
    localObject2 = NSQ;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (o)((Iterator)localObject2).next();
        switch (((Number)((o)localObject3).Mx).intValue())
        {
        default: 
          break;
        case 1: 
          ((i)localObject1).s("transToHard", ((Number)((o)localObject3).My).longValue());
          break;
        case 2: 
          ((i)localObject1).s("transToSoft", ((Number)((o)localObject3).My).longValue());
        }
      }
    }
    localObject1 = ((i)localObject1).toString();
    p.j(localObject1, "json.toString()");
    localre.abh(n.l((String)localObject1, ",", ";", false));
    localObject1 = new i();
    localObject2 = NSR;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (o)((Iterator)localObject2).next();
        switch (((Number)((o)localObject3).Mx).intValue())
        {
        default: 
          break;
        case 1: 
          ((i)localObject1).s("transToHard", ((Number)((o)localObject3).My).longValue());
          break;
        case 2: 
          ((i)localObject1).s("transToSoft", ((Number)((o)localObject3).My).longValue());
        }
      }
    }
    localObject1 = ((i)localObject1).toString();
    p.j(localObject1, "json.toString()");
    localre.abi(n.l((String)localObject1, ",", ";", false));
    localObject1 = new i();
    localObject2 = NSS;
    i locali;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (o)((Iterator)localObject2).next();
        locali = new i();
        locali.s("cost", ((Number)((o)localObject3).Mx).longValue());
        locali.s("currentTimes", ((Number)((o)localObject3).My).longValue());
        ((i)localObject1).g("transToMini", locali.toString());
      }
    }
    localObject1 = ((i)localObject1).toString();
    p.j(localObject1, "json.toString()");
    localre.abj(n.l((String)localObject1, ",", ";", false));
    localObject1 = new i();
    localObject2 = NST;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (o)((Iterator)localObject2).next();
        locali = new i();
        locali.s("cost", ((Number)((o)localObject3).Mx).longValue());
        locali.s("currentTimes", ((Number)((o)localObject3).My).longValue());
        ((i)localObject1).g("transToFull", locali.toString());
      }
    }
    localObject1 = ((i)localObject1).toString();
    p.j(localObject1, "json.toString()");
    localre.abk(n.l((String)localObject1, ",", ";", false));
    localre.XQ(PVB);
    localre.XR(QQS);
    localObject1 = new i();
    localObject2 = NTc;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (o)((Iterator)localObject2).next();
        locali = new i();
        locali.al("device", ((Number)((o)localObject3).Mx).intValue());
        locali.s("currentTimes", ((Number)((o)localObject3).My).longValue());
        ((i)localObject1).g("audioDeviceSwitch", locali.toString());
      }
    }
    localObject1 = ((i)localObject1).toString();
    p.j(localObject1, "json.toString()");
    localre.ady(n.l((String)localObject1, ",", ";", false));
    localre.XS(QQO);
    localre.XT(Qdr.ordinal());
    localObject1 = new i();
    localObject2 = NSU;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (o)((Iterator)localObject2).next();
        locali = new i();
        locali.g("encodeSize", ((o)localObject3).Mx);
        locali.s("currentTimes", ((Number)((o)localObject3).My).longValue());
        ((i)localObject1).g("encodeSizeChange", locali.toString());
      }
    }
    localObject1 = ((i)localObject1).toString();
    p.j(localObject1, "json.toString()");
    localre.adz(n.l((String)localObject1, ",", ";", false));
    localObject1 = new i();
    localObject2 = NTd;
    if (localObject2 != null)
    {
      localObject3 = new i();
      ((i)localObject3).al("temperate", ((Number)((o)localObject2).Mx).intValue());
      ((i)localObject3).s("currentTimes", ((Number)((o)localObject2).My).longValue());
      ((i)localObject1).g("minBatteryTemp", ((i)localObject3).toString());
    }
    localObject2 = NTe;
    if (localObject2 != null)
    {
      localObject3 = new i();
      ((i)localObject3).al("temperate", ((Number)((o)localObject2).Mx).intValue());
      ((i)localObject3).s("currentTimes", ((Number)((o)localObject2).My).longValue());
      ((i)localObject1).g("maxBatteryTemp", ((i)localObject3).toString());
    }
    localObject1 = ((i)localObject1).toString();
    p.j(localObject1, "json.toString()");
    localre.adA(n.l((String)localObject1, ",", ";", false));
    localre.bpa();
    release();
    AppMethodBeat.o(293148);
  }
  
  public static void alR(int paramInt)
  {
    PWH = paramInt;
  }
  
  public static void arD(int paramInt)
  {
    Qdq = paramInt;
  }
  
  public static void b(o<Integer, Long> paramo)
  {
    NTd = paramo;
  }
  
  public static void bIE(String paramString)
  {
    AppMethodBeat.i(293147);
    p.k(paramString, "<set-?>");
    QQP = paramString;
    AppMethodBeat.o(293147);
  }
  
  public static void c(o<Integer, Long> paramo)
  {
    NTe = paramo;
  }
  
  public static ArrayList<o<Integer, Long>> gBA()
  {
    return NSR;
  }
  
  public static ArrayList<o<Long, Long>> gBB()
  {
    return NSS;
  }
  
  public static ArrayList<o<Long, Long>> gBC()
  {
    return NST;
  }
  
  public static ArrayList<o<String, Long>> gBD()
  {
    return NSU;
  }
  
  public static ArrayList<o<Integer, Long>> gBF()
  {
    return NTc;
  }
  
  public static ArrayList<o<Integer, Long>> gBz()
  {
    return NSQ;
  }
  
  public static void gEH()
  {
    QQO = 1;
  }
  
  public static void n(Long paramLong)
  {
    NSV = paramLong;
  }
  
  public static void release()
  {
    AppMethodBeat.i(235993);
    NSQ.clear();
    NSR.clear();
    NSS.clear();
    NST.clear();
    NSU.clear();
    NTc.clear();
    PVB = 0L;
    PWH = 0;
    Qdq = 0;
    Qdr = a.NTj;
    QQO = 0;
    QQP = "";
    NSV = null;
    AppMethodBeat.o(235993);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/report/VoipFeatureReport$VoipCloseReason;", "", "(Ljava/lang/String;I)V", "UNKOWN", "HANGUP", "CANCEL", "SHUTDOWN", "ERROR", "PHONE_INTERRUPTER", "NO_RESP", "REJECT", "plugin-voip_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(241778);
      a locala1 = new a("UNKOWN", 0);
      NTj = locala1;
      a locala2 = new a("HANGUP", 1);
      NTk = locala2;
      a locala3 = new a("CANCEL", 2);
      NTl = locala3;
      a locala4 = new a("SHUTDOWN", 3);
      NTm = locala4;
      a locala5 = new a("ERROR", 4);
      NTn = locala5;
      a locala6 = new a("PHONE_INTERRUPTER", 5);
      NTo = locala6;
      a locala7 = new a("NO_RESP", 6);
      NTp = locala7;
      a locala8 = new a("REJECT", 7);
      NTq = locala8;
      NTr = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8 };
      AppMethodBeat.o(241778);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.a
 * JD-Core Version:    0.7.0.1
 */