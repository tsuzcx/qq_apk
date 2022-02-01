package com.tencent.mm.plugin.textstatus.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.pr;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.secdata.g;
import com.tencent.mm.plugin.textstatus.a.w;
import com.tencent.mm.plugin.textstatus.proto.bh;
import com.tencent.mm.plugin.textstatus.proto.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/report/TextStatusReporter;", "", "()V", "TAG", "", "getExposeDataFromMem", "Lcom/tencent/mm/plugin/textstatus/proto/TextStateCardExposeData;", "post22219ByOtherActivity", "", "param", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "exitScene", "", "postReport", "cliPostID", "exitTopicID", "exitTextStatusID", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "postReportByTextStatusEditActivity", "finishByPost", "", "postData", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostReportData;", "postReportImp", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostReportData;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "report22208", "action", "actionResult", "sessionId", "btnStyle", "toStatusID", "report22210", "userName", "scene", "report22216", "context", "Landroid/content/Context;", "infoSet", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "cardLeaveMethod", "cardStayTime", "listPos", "report22662", "source", "", "hasMoreFriendsButton", "moreFriendButtonNum", "report22663", "iconId", "sameStatusUsersCount", "toUserName", "uvPerIcon", "sceneStayTime", "report22895", "report23836", "Action", "ActionResult", "NotificationSessionID", "EnterScene", "SessionID", "EnterPosition", "UnreadInteractCount", "UnreadMsgCount", "UnreadHelloToMeCount", "ToUserSessionID", "ToUserIconID", "ToUserSourceID", "ToUserHashTag", "ToUserStatusID", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "tryReport22895", "updateExposeDataToMem", "exposedData", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Trt;
  
  static
  {
    AppMethodBeat.i(289724);
    Trt = new b();
    AppMethodBeat.o(289724);
  }
  
  public static void a(com.tencent.mm.plugin.report.a parama)
  {
    AppMethodBeat.i(289651);
    int i = parama.getId();
    parama = parama.aIF();
    s.s(parama, "struct.toShowString()");
    Log.i("MicroMsg.TextStatus.tsReport", "report%s %s", new Object[] { Integer.valueOf(i), n.m(parama, "\r\n", " ", false) });
    AppMethodBeat.o(289651);
  }
  
  public static void a(w paramw, long paramLong)
  {
    AppMethodBeat.i(289679);
    if (paramw == null) {}
    for (paramw = null;; paramw = ah.aiuX)
    {
      if (paramw == null) {
        Log.e("MicroMsg.TextStatus.tsReport", "postReportByTextStatusDoWhatActivity: param is null");
      }
      AppMethodBeat.o(289679);
      return;
      pr localpr = new pr();
      localpr.wW(Util.nullAs(paramw.sessionId, ""));
      localpr.wX(String.valueOf(paramw.enterTime));
      localpr.izg = paramw.Toi;
      localpr.iuE = paramw.enterTime;
      localpr.jnz = paramLong;
      localpr.jkD = cn.bDw();
      localpr.joe = paramw.Toj;
      localpr.jof = paramw.Tok;
      localpr.jog = 0L;
      localpr.joa = paramw.Tol;
      localpr.joc = paramw.Tom;
      localpr.wY(paramw.Ton);
      localpr.joo = paramw.Tos;
      localpr.wZ(paramw.Tot);
      localpr.xa(paramw.Tou);
      localpr.xb(com.tencent.mm.plugin.textstatus.util.b.hKh().hKf());
      localpr.bMH();
      a((com.tencent.mm.plugin.report.a)localpr);
    }
  }
  
  private static final void a(bh parambh1, int paramInt, boolean paramBoolean, com.tencent.mm.plugin.secdata.a.b paramb, bh parambh2)
  {
    AppMethodBeat.i(289704);
    Log.i("MicroMsg.TextStatus.tsReport", "postReportByTextStatusEditActivity onActionDone " + paramInt + ' ' + paramBoolean + ' ' + parambh1.Tqq);
    AppMethodBeat.o(289704);
  }
  
  private static void a(bh parambh, Long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(289693);
    com.tencent.threadpool.h.ahAA.bm(new b..ExternalSyntheticLambda2(parambh, paramLong, paramString1, paramString2));
    AppMethodBeat.o(289693);
  }
  
  public static void a(p paramp)
  {
    AppMethodBeat.i(289669);
    s.u(paramp, "exposedData");
    try
    {
      ((g)com.tencent.mm.kernel.h.az(g.class)).updateOnlyMemory(9, "TextStatusCardExposed", (com.tencent.mm.bx.a)paramp);
      return;
    }
    finally
    {
      AppMethodBeat.o(289669);
    }
  }
  
  public static void a(String paramString1, Long paramLong, String paramString2, String paramString3)
  {
    AppMethodBeat.i(289687);
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = ah.aiuX)
    {
      if (paramString1 == null) {
        Log.i("MicroMsg.TextStatus.tsReport", "postReport: cliPostID is null");
      }
      AppMethodBeat.o(289687);
      return;
      ((g)com.tencent.mm.kernel.h.az(g.class)).getWithoutClear(8, s.X("StatusTextPost_", paramString1), bh.class, new b..ExternalSyntheticLambda1(paramString1, paramLong, paramString2, paramString3));
    }
  }
  
  private static final void a(String paramString1, Long paramLong, String paramString2, String paramString3, int paramInt, boolean paramBoolean, com.tencent.mm.plugin.secdata.a.b paramb, bh parambh)
  {
    AppMethodBeat.i(289709);
    Log.i("MicroMsg.TextStatus.tsReport", "postReport onActionDone " + paramInt + ' ' + paramBoolean + ' ' + paramString1);
    if (parambh == null) {}
    for (paramString2 = null;; paramString2 = ah.aiuX)
    {
      if (paramString2 == null) {
        Log.e("MicroMsg.TextStatus.tsReport", "postReport: postData is null, " + paramString1 + ", " + paramLong);
      }
      AppMethodBeat.o(289709);
      return;
      a(parambh, paramLong, paramString2, paramString3);
    }
  }
  
  public static void a(boolean paramBoolean, bh parambh)
  {
    AppMethodBeat.i(289684);
    if (parambh == null)
    {
      parambh = null;
      if (parambh == null) {
        Log.e("MicroMsg.TextStatus.tsReport", s.X("postReportByTextStatusEditActivity: postData is null, ", Boolean.valueOf(paramBoolean)));
      }
      AppMethodBeat.o(289684);
      return;
    }
    if (paramBoolean) {
      ((g)com.tencent.mm.kernel.h.az(g.class)).updateWithSave(8, s.X("StatusTextPost_", parambh.Tqq), (com.tencent.mm.bx.a)parambh, new b..ExternalSyntheticLambda0(parambh));
    }
    for (;;)
    {
      parambh = ah.aiuX;
      break;
      a(parambh, Long.valueOf(3L), "", "");
    }
  }
  
  private static final void b(bh parambh, Long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(289720);
    s.u(parambh, "$postData");
    pr localpr = new pr();
    localpr.wW(Util.nullAs(parambh.sessionId, ""));
    localpr.izg = parambh.Toi;
    localpr.wX(Util.nullAs(parambh.Tqq, ""));
    localpr.iuE = parambh.enterTime;
    long l;
    if (paramLong == null)
    {
      l = 0L;
      localpr.jnz = l;
      localpr.jkD = cn.bDw();
      localpr.jnA = localpr.F("ExitTopicID", Util.nullAs(paramString1, ""), true);
      localpr.jnB = localpr.F("ExitTextStatusID", Util.nullAs(paramString2, ""), true);
      paramLong = new StringBuilder();
      paramString1 = parambh.Tqs.iterator();
      label148:
      if (!paramString1.hasNext()) {
        break label219;
      }
      paramString2 = (String)paramString1.next();
      if (((CharSequence)paramLong).length() <= 0) {
        break label213;
      }
    }
    label213:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramLong.append(";");
      }
      paramLong.append(paramString2);
      break label148;
      l = paramLong.longValue();
      break;
    }
    label219:
    localpr.jny = localpr.F("StatusIcons", paramLong.toString(), true);
    localpr.jnC = parambh.Tqv;
    localpr.jnD = parambh.Tqw;
    localpr.jnE = parambh.Tqx;
    localpr.jnF = parambh.Tqy;
    localpr.jnG = parambh.Tqz;
    localpr.jmS = localpr.F("SourceID", Util.nullAs(parambh.TqA, ""), true);
    localpr.jmT = localpr.F("SourceActivityID", Util.nullAs(parambh.TqB, ""), true);
    localpr.jmU = localpr.F("SourceName", Util.nullAs(parambh.sourceName, ""), true);
    localpr.jnH = localpr.F("SourceIcon", Util.nullAs(parambh.sourceIcon, ""), true);
    localpr.jnI = parambh.TqC;
    localpr.jnJ = parambh.TqD;
    localpr.jnK = parambh.TqE;
    localpr.jnL = parambh.TqF;
    localpr.jnM = parambh.TqG;
    localpr.jnN = parambh.TqH;
    localpr.jnO = parambh.TqI;
    localpr.jnP = parambh.TqJ;
    localpr.jnS = parambh.TqK;
    localpr.jnT = parambh.TqL;
    localpr.jnU = parambh.TqM;
    localpr.jnV = parambh.TqN;
    localpr.jnW = parambh.TqO;
    localpr.jnX = parambh.TqP;
    localpr.jnY = parambh.TqQ;
    localpr.jnZ = parambh.TqR;
    localpr.joe = parambh.Toj;
    localpr.jof = parambh.Tok;
    localpr.jog = 0L;
    localpr.joh = parambh.TqU;
    localpr.joi = parambh.TqV;
    localpr.jnQ = parambh.Trl;
    localpr.joj = localpr.F("RefBackgroundUser", parambh.TqX, true);
    localpr.jok = localpr.F("RefBackgroundStatus", parambh.TqY, true);
    localpr.jol = parambh.TqS;
    localpr.jom = localpr.F("ImgVideoMd5Orig", parambh.TqT, true);
    localpr.jon = localpr.F("FinderPickerSessionId", parambh.TqZ, true);
    localpr.joa = parambh.Tra;
    localpr.joc = parambh.Trb;
    localpr.wY(parambh.Ton);
    localpr.joo = parambh.Trc;
    localpr.jop = parambh.Trd;
    localpr.joq = parambh.Tre;
    localpr.jor = parambh.Trf;
    localpr.jos = parambh.Trg;
    localpr.jot = parambh.Trh;
    localpr.jou = localpr.F("FinalEmoticon", parambh.Tri, true);
    localpr.jov = 2L;
    localpr.jow = 2L;
    localpr.wZ(parambh.Trj);
    localpr.xa(parambh.Trk);
    localpr.xb(com.tencent.mm.plugin.textstatus.util.b.hKh().hKf());
    localpr.bMH();
    a((com.tencent.mm.plugin.report.a)localpr);
    AppMethodBeat.o(289720);
  }
  
  public static p hHY()
  {
    AppMethodBeat.i(289672);
    try
    {
      p localp = (p)((g)com.tencent.mm.kernel.h.az(g.class)).getOnlyMemory(9, "TextStatusCardExposed");
      AppMethodBeat.o(289672);
      return localp;
    }
    finally
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.i.b
 * JD-Core Version:    0.7.0.1
 */