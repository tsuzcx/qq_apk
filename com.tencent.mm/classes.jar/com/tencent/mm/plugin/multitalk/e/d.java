package com.tencent.mm.plugin.multitalk.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kk;
import com.tencent.mm.autogen.mmdata.rpt.kl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkFeatureReportHelper;", "", "()V", "CALL_STATE_CALL_FINISH", "", "CALL_STATE_HANGUP_BY_SELF", "CALL_STATE_MISS", "CALL_STATE_REJECT", "CALL_STATE_UNKNOWN", "SCREEN_ACTION_CLICK_DOODLE_BTN", "SCREEN_ACTION_CLICK_EXIT_BTN", "SCREEN_ACTION_CLICK_MUTE_BTN", "SCREEN_ACTION_CLICK_SCREEN_BTN", "SCREEN_ACTION_CLICK_SPEAKER_BTN", "SCREEN_ACTION_CLICK_START_SCREEN_BTN", "SCREEN_ACTION_SCREEN_ORI_CHANGE", "SCREEN_ACTION_WATCH_SCREEN", "SCREEN_USER_TYPE_OWNER", "SCREEN_USER_TYPE_VIEWER", "TAG", "", "cameraStatus", "Lcom/tencent/mm/plugin/multitalk/utils/MultitalkFeatureReportHelper$StatusHolder;", "clickScreenCastBtn", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "clickedScreenEntry", "", "isILink", "lastReportTime", "maxCameraNum", "maxMemberNum", "maxScreenCastNum", "memberUsernames", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "multitalkGroupId", "multitalkTalking", "openedCamera", "roomId", "roomKey", "screenBigStatus", "screenCastStatus", "sessionId", "startTalkingTime", "videoBigStatus", "markCameraStatus", "", "isOpen", "markScreenBig", "subscribe", "markStartMultitalk", "markStartScreenCast", "markVideoBig", "reportMultitalk", "reject", "missCall", "reportScreen", "action", "userType", "reset", "setGroupId", "groupId", "setRoomId", "setRoomKey", "updateGroupMember", "memberList", "", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", "updateOpenedVideoSize", "videoSize", "updateScreenCastNum", "screenCastNum", "StatusHolder", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static long Hnt;
  private static boolean LAA;
  private static final d.a LAB;
  private static final d.a LAC;
  private static final d.a LAD;
  private static final d.a LAE;
  private static final ArrayList<Long> LAF;
  public static final d LAq;
  private static long LAr;
  private static boolean LAs;
  private static String LAt;
  private static boolean LAu;
  private static final HashSet<String> LAv;
  private static int LAw;
  private static int LAx;
  private static int LAy;
  private static boolean LAz;
  private static long lastReportTime;
  private static long roomId;
  public static long sessionId;
  
  static
  {
    AppMethodBeat.i(284714);
    LAq = new d();
    LAt = "";
    LAv = new HashSet();
    LAB = new d.a();
    LAC = new d.a();
    LAD = new d.a();
    LAE = new d.a();
    LAF = new ArrayList();
    AppMethodBeat.o(284714);
  }
  
  public static void aE(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = -1;
    AppMethodBeat.i(284649);
    if (System.currentTimeMillis() - lastReportTime < 200L)
    {
      Log.w("MultitalkFeatureReportH", "has reported");
      AppMethodBeat.o(284649);
      return;
    }
    int i;
    kk localkk;
    int j;
    if (paramBoolean2)
    {
      i = 4;
      LAB.close();
      LAC.close();
      LAD.close();
      LAE.close();
      localkk = new kk();
      localkk.iWr = localkk.F("multiTalkGroupId", LAt, true);
      if (!LAs) {
        break label457;
      }
      j = 1;
      label98:
      localkk.iWs = j;
      localkk.iWt = localkk.F("memberUins", p.a((Iterable)LAv, (CharSequence)";", null, null, 0, null, null, 62), true);
      localkk.iWu = LAr;
      localkk.iWv = ((System.currentTimeMillis() - localkk.iWu) / 1000L);
      localkk.iWw = LAw;
      if (!LAz) {
        break label462;
      }
      j = 1;
      label181:
      localkk.iWx = j;
      localkk.iWy = LAx;
      j = k;
      if (LAA) {
        j = 1;
      }
      localkk.iWz = j;
      localkk.iWA = LAC.giQ();
      localkk.iWB = LAy;
      localkk.iWC = LAD.giQ();
      localkk.iWD = localkk.F("subscribeScreenCastOp", LAD.giR(), true);
      localkk.iWE = localkk.F("clickScreenCastBtnOp", p.a((Iterable)LAF, (CharSequence)";", null, null, 0, null, null, 62), true);
      localkk.iWF = LAB.giQ();
      localkk.iWG = localkk.F("openCameraOp", LAB.giR(), true);
      localkk.iWH = LAE.giQ();
      localkk.iWI = localkk.F("subscribeBigVideoOp", LAE.giR(), true);
      if (!LAs) {
        break label467;
      }
    }
    label457:
    label462:
    label467:
    for (long l = roomId;; l = Hnt)
    {
      localkk.iWJ = l;
      localkk.iWK = i;
      localkk.bMH();
      lastReportTime = System.currentTimeMillis();
      LAu = false;
      AppMethodBeat.o(284649);
      return;
      if ((paramBoolean1) && (LAu))
      {
        i = 1;
        break;
      }
      if ((paramBoolean1) && (!LAu))
      {
        i = 3;
        break;
      }
      if ((!paramBoolean1) && (LAu))
      {
        i = 2;
        break;
      }
      i = -1;
      break;
      j = -1;
      break label98;
      j = -1;
      break label181;
    }
  }
  
  public static void aNK(String paramString)
  {
    AppMethodBeat.i(284663);
    s.u(paramString, "groupId");
    LAt = paramString;
    AppMethodBeat.o(284663);
  }
  
  public static void acc(int paramInt)
  {
    AppMethodBeat.i(284672);
    LAw = Math.max(LAw, paramInt);
    AppMethodBeat.o(284672);
  }
  
  public static void acd(int paramInt)
  {
    AppMethodBeat.i(284677);
    LAy = Math.max(LAy, paramInt);
    AppMethodBeat.o(284677);
  }
  
  public static void jT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(284702);
    kl localkl;
    switch (paramInt1)
    {
    default: 
      localkl = new kl();
      if (LAs) {
        localkl.iWQ = roomId;
      }
      break;
    }
    for (;;)
    {
      localkl.iWM = 1;
      localkl.iWO = paramInt2;
      localkl.iWP = sessionId;
      localkl.iWL = localkl.F("MultitalkGroupId", LAt, true);
      localkl.iWN = paramInt1;
      localkl.bMH();
      AppMethodBeat.o(284702);
      return;
      LAA = true;
      LAF.add(Long.valueOf(System.currentTimeMillis()));
      break;
      LAC.giO();
      break;
      LAC.giP();
      break;
      localkl.iWR = Hnt;
    }
  }
  
  public static void jd(List<? extends MultiTalkGroupMember> paramList)
  {
    AppMethodBeat.i(284668);
    s.u(paramList, "memberList");
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      MultiTalkGroupMember localMultiTalkGroupMember = (MultiTalkGroupMember)localIterator.next();
      LAv.add(localMultiTalkGroupMember.ahhi);
    }
    LAx = Math.max(LAx, paramList.size());
    AppMethodBeat.o(284668);
  }
  
  public static void sx(long paramLong)
  {
    roomId = paramLong;
  }
  
  public static void sy(long paramLong)
  {
    Hnt = paramLong;
  }
  
  public static void zA(boolean paramBoolean)
  {
    AppMethodBeat.i(284689);
    if (paramBoolean)
    {
      LAB.giO();
      LAz = true;
      AppMethodBeat.o(284689);
      return;
    }
    LAB.giP();
    AppMethodBeat.o(284689);
  }
  
  public static void zB(boolean paramBoolean)
  {
    AppMethodBeat.i(284693);
    if (paramBoolean)
    {
      LAD.giO();
      AppMethodBeat.o(284693);
      return;
    }
    LAD.giP();
    AppMethodBeat.o(284693);
  }
  
  public static void zC(boolean paramBoolean)
  {
    AppMethodBeat.i(284697);
    if (paramBoolean)
    {
      LAE.giO();
      AppMethodBeat.o(284697);
      return;
    }
    LAE.giP();
    AppMethodBeat.o(284697);
  }
  
  public static void zz(boolean paramBoolean)
  {
    AppMethodBeat.i(284684);
    if (LAu) {
      Log.e("MultitalkFeatureReportH", "now is talking");
    }
    LAz = false;
    LAs = false;
    LAA = false;
    LAx = 0;
    LAw = 0;
    LAv.clear();
    LAF.clear();
    LAB.reset();
    LAC.reset();
    LAD.reset();
    LAE.reset();
    LAu = true;
    LAr = System.currentTimeMillis();
    LAs = paramBoolean;
    AppMethodBeat.o(284684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.e.d
 * JD-Core Version:    0.7.0.1
 */