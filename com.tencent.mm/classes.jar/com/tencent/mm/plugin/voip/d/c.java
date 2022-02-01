package com.tencent.mm.plugin.voip.d;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.mmdata.rpt.qw;
import com.tencent.mm.plugin.ringtone.a.a;
import com.tencent.mm.plugin.voip.f.h;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/report/VoipFeatureReport;", "", "()V", "audioDeviceChange", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Pair;", "", "", "getAudioDeviceChange", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "setAudioDeviceChange", "(Ljava/util/concurrent/ConcurrentLinkedQueue;)V", "decodeChangeLists", "getDecodeChangeLists", "doubleLinkSwitch", "getDoubleLinkSwitch", "()Ljava/lang/Long;", "setDoubleLinkSwitch", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "encodeChangeLists", "getEncodeChangeLists", "encodeSizeChangeLists", "", "getEncodeSizeChangeLists", "fullViewChangeLists", "getFullViewChangeLists", "mBatteryCost", "getMBatteryCost", "()J", "setMBatteryCost", "(J)V", "mBeforeRingtoneVolume", "getMBeforeRingtoneVolume", "()I", "setMBeforeRingtoneVolume", "(I)V", "mCameraStatus", "getMCameraStatus", "setMCameraStatus", "mCloseReason", "Lcom/tencent/mm/plugin/voip/report/VoipFeatureReport$VoipCloseReason;", "getMCloseReason", "()Lcom/tencent/mm/plugin/voip/report/VoipFeatureReport$VoipCloseReason;", "setMCloseReason", "(Lcom/tencent/mm/plugin/voip/report/VoipFeatureReport$VoipCloseReason;)V", "mPlayDuration", "getMPlayDuration", "()Ljava/lang/String;", "setMPlayDuration", "(Ljava/lang/String;)V", "mPlayPersistentTime", "getMPlayPersistentTime", "setMPlayPersistentTime", "mPreviewSize", "getMPreviewSize", "setMPreviewSize", "mRingtoneCanPlay", "", "getMRingtoneCanPlay", "()Z", "setMRingtoneCanPlay", "(Z)V", "mRingtoneDiffSetting", "getMRingtoneDiffSetting", "setMRingtoneDiffSetting", "mRingtoneFinderObjectId", "getMRingtoneFinderObjectId", "setMRingtoneFinderObjectId", "mRingtoneInfoClick", "getMRingtoneInfoClick", "setMRingtoneInfoClick", "mRingtoneInfoIconShow", "getMRingtoneInfoIconShow", "setMRingtoneInfoIconShow", "mRingtoneMusicSid", "getMRingtoneMusicSid", "setMRingtoneMusicSid", "mRingtoneVolume", "getMRingtoneVolume", "()Lkotlin/Pair;", "setMRingtoneVolume", "(Lkotlin/Pair;)V", "mRoomId", "getMRoomId", "setMRoomId", "mRoomKey", "getMRoomKey", "setMRoomKey", "mUseFaceBeauty", "getMUseFaceBeauty", "setMUseFaceBeauty", "mUseRgb2Yuv", "mUseSTFilter", "getMUseSTFilter", "setMUseSTFilter", "mUseSurfaceEncode", "getMUseSurfaceEncode", "setMUseSurfaceEncode", "mUsername", "getMUsername", "setMUsername", "maxBatteryTemperate", "getMaxBatteryTemperate", "setMaxBatteryTemperate", "minBatteryTemperate", "getMinBatteryTemperate", "setMinBatteryTemperate", "miniViewChangeLists", "getMiniViewChangeLists", "roomInfo", "Landroidx/lifecycle/MutableLiveData;", "getRoomInfo", "()Landroidx/lifecycle/MutableLiveData;", "setRoomInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "dealCallingParam", "", "roomId", "roomKey", "toUsername", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;)V", "dealPlayReportInfo", "reportInfo", "Lcom/tencent/mm/plugin/ringtone/api/PlayerReportInfo;", "release", "reportFeature", "mTotalTime", "mVoipType", "transAudioDeviceChange", "transBatteryTemperateJson", "transDecodeChangeJson", "transDoubleLinkJson", "transEncodeChangeJson", "transEncodeSizeChange", "transFullViewJson", "transMiniViewJson", "transRingtoneSituationInfo", "transVoipInfo", "VoipCloseReason", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static int JMX;
  private static boolean OBM;
  private static int UGA;
  private static String UGB;
  private static boolean UGC;
  private static x<r<Integer, Long>> UGD;
  public static final c UGb;
  private static final ConcurrentLinkedQueue<r<Integer, Long>> UGc;
  private static final ConcurrentLinkedQueue<r<Integer, Long>> UGd;
  private static final ConcurrentLinkedQueue<r<Long, Long>> UGe;
  private static final ConcurrentLinkedQueue<r<Long, Long>> UGf;
  private static final ConcurrentLinkedQueue<r<String, Long>> UGg;
  private static Long UGh;
  private static long UGi;
  private static int UGj;
  private static int UGk;
  private static a UGl;
  private static int UGm;
  private static String UGn;
  private static ConcurrentLinkedQueue<r<Integer, Long>> UGo;
  private static r<Integer, Long> UGp;
  private static r<Integer, Long> UGq;
  private static int UGr;
  private static int UGs;
  private static long UGt;
  private static String UGu;
  private static String UGv;
  private static boolean UGw;
  private static boolean UGx;
  private static String UGy;
  private static r<Integer, Integer> UGz;
  private static String sWX;
  
  static
  {
    AppMethodBeat.i(292889);
    UGb = new c();
    UGc = new ConcurrentLinkedQueue();
    UGd = new ConcurrentLinkedQueue();
    UGe = new ConcurrentLinkedQueue();
    UGf = new ConcurrentLinkedQueue();
    UGg = new ConcurrentLinkedQueue();
    UGl = a.UGE;
    UGn = "0";
    UGo = new ConcurrentLinkedQueue();
    h localh = h.ULL;
    if (h.ibC()) {}
    for (int i = 1;; i = 0)
    {
      UGr = i;
      sWX = "";
      UGu = "";
      UGv = "";
      OBM = true;
      UGy = "";
      UGB = "";
      UGD = new x(null);
      AppMethodBeat.o(292889);
      return;
    }
  }
  
  public static final void a(a parama)
  {
    AppMethodBeat.i(292885);
    if ((s.p(UGv, "")) && (parama != null))
    {
      String str = String.valueOf(parama.OBI);
      s.u(str, "<set-?>");
      UGv = str;
      OBM = parama.OBM;
      str = parama.OBK;
      s.s(str, "it.mMusicSid");
      s.u(str, "<set-?>");
      UGB = str;
      str = parama.OBL;
      s.s(str, "it.mFinderObjectId");
      s.u(str, "<set-?>");
      UGy = str;
      str = String.valueOf(parama.OBJ);
      s.u(str, "<set-?>");
      UGu = str;
      UGx = parama.OBN;
      UGz = new r(Integer.valueOf(parama.mTx), Integer.valueOf(parama.OBO));
      UGA = parama.OBP;
    }
    AppMethodBeat.o(292885);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(292838);
    s.u(parama, "<set-?>");
    UGl = parama;
    AppMethodBeat.o(292838);
  }
  
  public static void a(Integer paramInteger, Long paramLong, String paramString)
  {
    AppMethodBeat.i(292881);
    if (paramInteger == null)
    {
      AppMethodBeat.o(292881);
      return;
    }
    JMX = paramInteger.intValue();
    if (paramLong == null)
    {
      AppMethodBeat.o(292881);
      return;
    }
    UGt = paramLong.longValue();
    if (paramString == null)
    {
      AppMethodBeat.o(292881);
      return;
    }
    sWX = paramString;
    UGD.t(new r(paramInteger, paramLong));
    AppMethodBeat.o(292881);
  }
  
  public static void aqD(int paramInt)
  {
    UGj = paramInt;
  }
  
  public static void aqE(int paramInt)
  {
    UGk = paramInt;
  }
  
  public static void aqF(int paramInt)
  {
    UGs = paramInt;
  }
  
  public static void bC(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(292879);
    qw localqw = new qw();
    localqw.jtU = paramLong2;
    localqw.ivc = paramLong1;
    Object localObject1 = new i();
    Object localObject2 = UGh;
    if (localObject2 != null)
    {
      paramLong1 = ((Number)localObject2).longValue();
      ((i)localObject1).au("doubleLinkSwitch", 1);
      ((i)localObject1).t("currentTimes", paramLong1);
    }
    localObject1 = ((i)localObject1).toString();
    s.s(localObject1, "json.toString()");
    localqw.jtW = localqw.F("doubleLinkStatus", n.m((String)localObject1, ",", ";", false), true);
    localqw.jtX = localqw.F("previewSize", UGn, true);
    localqw.jtY = 1L;
    localqw.jtZ = UGr;
    localqw.jua = UGj;
    localqw.jub = UGk;
    localObject1 = new i();
    localObject2 = UGc;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (r)((Iterator)localObject2).next();
        switch (((Number)((r)localObject3).bsC).intValue())
        {
        default: 
          break;
        case 1: 
          ((i)localObject1).t("transToHard", ((Number)((r)localObject3).bsD).longValue());
          break;
        case 2: 
          ((i)localObject1).t("transToSoft", ((Number)((r)localObject3).bsD).longValue());
        }
      }
    }
    localObject1 = ((i)localObject1).toString();
    s.s(localObject1, "json.toString()");
    localqw.juc = localqw.F("decodeChange", n.m((String)localObject1, ",", ";", false), true);
    localObject1 = new i();
    localObject2 = UGd;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (r)((Iterator)localObject2).next();
        switch (((Number)((r)localObject3).bsC).intValue())
        {
        default: 
          break;
        case 1: 
          ((i)localObject1).t("transToHard", ((Number)((r)localObject3).bsD).longValue());
          break;
        case 2: 
          ((i)localObject1).t("transToSoft", ((Number)((r)localObject3).bsD).longValue());
        }
      }
    }
    localObject1 = ((i)localObject1).toString();
    s.s(localObject1, "json.toString()");
    localqw.jud = localqw.F("encodeChange", n.m((String)localObject1, ",", ";", false), true);
    localObject1 = new i();
    localObject2 = UGe;
    i locali;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (r)((Iterator)localObject2).next();
        locali = new i();
        locali.t("cost", ((Number)((r)localObject3).bsC).longValue());
        locali.t("currentTimes", ((Number)((r)localObject3).bsD).longValue());
        ((i)localObject1).m("transToMini", locali.toString());
      }
    }
    localObject1 = ((i)localObject1).toString();
    s.s(localObject1, "json.toString()");
    localqw.jue = localqw.F("miniViewChange", n.m((String)localObject1, ",", ";", false), true);
    localObject1 = new i();
    localObject2 = UGf;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (r)((Iterator)localObject2).next();
        locali = new i();
        locali.t("cost", ((Number)((r)localObject3).bsC).longValue());
        locali.t("currentTimes", ((Number)((r)localObject3).bsD).longValue());
        ((i)localObject1).m("transToFull", locali.toString());
      }
    }
    localObject1 = ((i)localObject1).toString();
    s.s(localObject1, "json.toString()");
    localqw.juf = localqw.F("fullViewChange", n.m((String)localObject1, ",", ";", false), true);
    localqw.jug = UGi;
    localqw.juh = UGs;
    localObject1 = new i();
    localObject2 = UGo;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (r)((Iterator)localObject2).next();
        locali = new i();
        locali.au("device", ((Number)((r)localObject3).bsC).intValue());
        locali.t("currentTimes", ((Number)((r)localObject3).bsD).longValue());
        ((i)localObject1).m("audioDeviceSwitch", locali.toString());
      }
    }
    localObject1 = ((i)localObject1).toString();
    s.s(localObject1, "json.toString()");
    localqw.jui = localqw.F("audioDevicePlugChange", n.m((String)localObject1, ",", ";", false), true);
    localqw.iQN = UGm;
    localqw.juj = UGl.ordinal();
    localObject1 = new i();
    localObject2 = UGg;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (r)((Iterator)localObject2).next();
        locali = new i();
        locali.m("encodeSize", ((r)localObject3).bsC);
        locali.t("currentTimes", ((Number)((r)localObject3).bsD).longValue());
        ((i)localObject1).m("encodeSizeChange", locali.toString());
      }
    }
    localObject1 = ((i)localObject1).toString();
    s.s(localObject1, "json.toString()");
    localqw.juk = localqw.F("encodeSizeChange", n.m((String)localObject1, ",", ";", false), true);
    localObject1 = new i();
    localObject2 = UGp;
    if (localObject2 != null)
    {
      localObject3 = new i();
      ((i)localObject3).au("temperate", ((Number)((r)localObject2).bsC).intValue());
      ((i)localObject3).t("currentTimes", ((Number)((r)localObject2).bsD).longValue());
      ((i)localObject1).m("minBatteryTemp", ((i)localObject3).toString());
    }
    localObject2 = UGq;
    if (localObject2 != null)
    {
      localObject3 = new i();
      ((i)localObject3).au("temperate", ((Number)((r)localObject2).bsC).intValue());
      ((i)localObject3).t("currentTimes", ((Number)((r)localObject2).bsD).longValue());
      ((i)localObject1).m("maxBatteryTemp", ((i)localObject3).toString());
    }
    localObject1 = ((i)localObject1).toString();
    s.s(localObject1, "json.toString()");
    localqw.jul = localqw.F("batteryTemperate", n.m((String)localObject1, ",", ";", false), true);
    localObject2 = new i();
    Object localObject3 = new i();
    ((i)localObject3).m("playDuration", UGu);
    ((i)localObject3).m("playPersistent", UGv);
    ((i)localObject3).A("ringtoneInfoIconShow", UGC);
    ((i)localObject3).A("ringtoneInfoClick", UGw);
    ((i)localObject3).A("ringtoneCanPlay", OBM);
    ((i)localObject3).A("ringtoneDiffSetting", UGx);
    ((i)localObject3).m("rigntoneMusicSid", UGB);
    ((i)localObject3).m("ringtoneFinderObjectId", UGy);
    ((i)localObject3).au("ringtoneBeforeVolume", UGA);
    localObject1 = UGz;
    if (localObject1 == null)
    {
      localObject1 = null;
      ((i)localObject3).m("ringtoneVolume", localObject1);
      localObject1 = UGz;
      if (localObject1 != null) {
        break label1941;
      }
      localObject1 = null;
      label1549:
      ((i)localObject3).m("ringtoneStream", localObject1);
      ((i)localObject2).m("ringtoneUseInfo", ((i)localObject3).toString());
      localObject1 = ((i)localObject2).toString();
      s.s(localObject1, "json.toString()");
      localqw.jum = localqw.F("ringtoneUseInfo", n.m((String)localObject1, ",", ";", false), true);
      localObject1 = new i();
      localObject2 = new i();
      ((i)localObject2).t("roomKey", UGt);
      ((i)localObject2).au("roomId", JMX);
      ((i)localObject2).m("callName", sWX);
      ((i)localObject1).m("voipInfo", ((i)localObject2).toString());
      localObject1 = ((i)localObject1).toString();
      s.s(localObject1, "json.toString()");
      localqw.jtx = localqw.F("voipInfo", n.m((String)localObject1, ",", ";", false), true);
      localObject1 = d.UGN;
      localqw.jun = localqw.F("floatCardInfo", n.m(d.hZQ(), ",", ";", false), true);
      if (!h.ibz()) {
        break label1954;
      }
    }
    label1941:
    label1954:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localqw.juo = paramLong1;
      localObject1 = com.tencent.mm.plugin.voip.video.a.d.UPM;
      localqw.jup = localqw.F("virtualBackgroundInfo", com.tencent.mm.plugin.voip.video.a.d.icU(), true);
      localqw.bMH();
      UGc.clear();
      UGd.clear();
      UGe.clear();
      UGf.clear();
      UGg.clear();
      UGo.clear();
      UGi = 0L;
      UGj = 0;
      UGk = 0;
      UGl = a.UGE;
      UGm = 0;
      UGn = "";
      UGh = null;
      UGu = "";
      UGv = "";
      UGw = false;
      UGC = false;
      OBM = true;
      UGx = false;
      UGy = "";
      UGB = "";
      JMX = 0;
      UGt = 0L;
      sWX = "";
      UGD.t(null);
      AppMethodBeat.o(292879);
      return;
      localObject1 = (Integer)((r)localObject1).bsC;
      break;
      localObject1 = (Integer)((r)localObject1).bsD;
      break label1549;
    }
  }
  
  public static void bfL(String paramString)
  {
    AppMethodBeat.i(292845);
    s.u(paramString, "<set-?>");
    UGn = paramString;
    AppMethodBeat.o(292845);
  }
  
  public static ConcurrentLinkedQueue<r<Integer, Long>> hZD()
  {
    return UGc;
  }
  
  public static ConcurrentLinkedQueue<r<Integer, Long>> hZE()
  {
    return UGd;
  }
  
  public static ConcurrentLinkedQueue<r<Long, Long>> hZF()
  {
    return UGe;
  }
  
  public static ConcurrentLinkedQueue<r<Long, Long>> hZG()
  {
    return UGf;
  }
  
  public static ConcurrentLinkedQueue<r<String, Long>> hZH()
  {
    return UGg;
  }
  
  public static void hZI()
  {
    UGm = 1;
  }
  
  public static ConcurrentLinkedQueue<r<Integer, Long>> hZJ()
  {
    return UGo;
  }
  
  public static boolean hZK()
  {
    return UGw;
  }
  
  public static void hZL()
  {
    UGw = true;
  }
  
  public static void hZM()
  {
    UGC = true;
  }
  
  public static x<r<Integer, Long>> hZN()
  {
    return UGD;
  }
  
  public static void i(r<Integer, Long> paramr)
  {
    UGp = paramr;
  }
  
  public static void j(r<Integer, Long> paramr)
  {
    UGq = paramr;
  }
  
  public static void t(Long paramLong)
  {
    UGh = paramLong;
  }
  
  public static void wT(long paramLong)
  {
    UGi = paramLong;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/report/VoipFeatureReport$VoipCloseReason;", "", "(Ljava/lang/String;I)V", "UNKOWN", "HANGUP", "CANCEL", "SHUTDOWN", "ERROR", "PHONE_INTERRUPTER", "NO_RESP", "REJECT", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(292837);
      UGE = new a("UNKOWN", 0);
      UGF = new a("HANGUP", 1);
      UGG = new a("CANCEL", 2);
      UGH = new a("SHUTDOWN", 3);
      UGI = new a("ERROR", 4);
      UGJ = new a("PHONE_INTERRUPTER", 5);
      UGK = new a("NO_RESP", 6);
      UGL = new a("REJECT", 7);
      UGM = new a[] { UGE, UGF, UGG, UGH, UGI, UGJ, UGK, UGL };
      AppMethodBeat.o(292837);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.d.c
 * JD-Core Version:    0.7.0.1
 */