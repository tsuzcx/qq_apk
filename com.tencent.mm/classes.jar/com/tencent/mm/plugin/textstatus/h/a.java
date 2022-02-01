package com.tencent.mm.plugin.textstatus.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ml;
import com.tencent.mm.f.b.a.mp;
import com.tencent.mm.f.b.a.mq;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.secdata.g;
import com.tencent.mm.plugin.textstatus.a.q;
import com.tencent.mm.plugin.textstatus.a.t;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.am;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/report/TextStatusReporter;", "", "()V", "TAG", "", "getExposeDataFromMem", "Lcom/tencent/mm/plugin/textstatus/proto/TextStateCardExposeData;", "postReport", "", "cliPostID", "exitScene", "", "exitTopicID", "exitTextStatusID", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "postReportByTextStatusDoWhatActivity", "param", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "postReportByTextStatusEditActivity", "finishByPost", "", "postData", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostReportData;", "postReportImp", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostReportData;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "report22208", "action", "actionResult", "sessionId", "btnStyle", "report22210", "userName", "scene", "report22216", "context", "Landroid/content/Context;", "infoSet", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "report22662", "source", "", "hasMoreFriendsButton", "moreFriendButtonNum", "report22663", "iconId", "sameStatusUsersCount", "toUserName", "uvPerIcon", "report22895", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "tryReport22895", "updateExposeDataToMem", "exposedData", "plugin-textstatus_release"})
public final class a
{
  public static final a MGJ;
  
  static
  {
    AppMethodBeat.i(233833);
    MGJ = new a();
    AppMethodBeat.o(233833);
  }
  
  public static void Sb(long paramLong)
  {
    AppMethodBeat.i(233829);
    mp localmp = new mp();
    localmp.yi(paramLong);
    localmp.bpa();
    a((com.tencent.mm.plugin.report.a)localmp);
    AppMethodBeat.o(233829);
  }
  
  public static void a(Context paramContext, long paramLong, String paramString, com.tencent.mm.plugin.textstatus.g.e.a parama)
  {
    long l2 = 1L;
    AppMethodBeat.i(292831);
    p.k(paramContext, "context");
    p.k(paramString, "actionResult");
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
    localObject = (com.tencent.mm.plugin.textstatus.proto.f)com.tencent.mm.plugin.secdata.ui.a.a.a(paramContext, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
    if (localObject == null)
    {
      Log.e("MicroMsg.TextStatus.tsReport", "report null err :" + paramContext.getClass().getSimpleName());
      localObject = new com.tencent.mm.plugin.textstatus.proto.f();
    }
    for (int i = 0;; i = 1)
    {
      if (parama == null) {
        paramContext = com.tencent.mm.plugin.textstatus.b.f.MAm;
      }
      for (paramContext = com.tencent.mm.plugin.textstatus.b.f.bep(((com.tencent.mm.plugin.textstatus.proto.f)localObject).username);; paramContext = parama)
      {
        if (paramContext == null) {
          paramContext = new com.tencent.mm.plugin.textstatus.g.e.a();
        }
        for (;;)
        {
          parama = new ml();
          parama.CO(((com.tencent.mm.plugin.textstatus.proto.f)localObject).sessionId);
          TextStatusTopicInfo localTextStatusTopicInfo = paramContext.glY();
          parama.CP(localTextStatusTopicInfo.topicId);
          parama.CQ(paramContext.field_StatusID);
          parama.CR(paramContext.field_IconID);
          parama.CS(localTextStatusTopicInfo.sourceId);
          parama.CT(localTextStatusTopicInfo.sourceActivityId);
          parama.CU(localTextStatusTopicInfo.sourceName);
          parama.CV(((com.tencent.mm.plugin.textstatus.proto.f)localObject).MEV);
          parama.CW(((com.tencent.mm.plugin.textstatus.proto.f)localObject).MEW);
          parama.xP(((com.tencent.mm.plugin.textstatus.proto.f)localObject).MEX);
          parama.xQ(((com.tencent.mm.plugin.textstatus.proto.f)localObject).MEY);
          parama.CX(((com.tencent.mm.plugin.textstatus.proto.f)localObject).username);
          if (p.h(com.tencent.mm.plugin.auth.a.a.crN(), ((com.tencent.mm.plugin.textstatus.proto.f)localObject).username))
          {
            l1 = 1L;
            parama.xR(l1);
            parama.xS(((com.tencent.mm.plugin.textstatus.proto.f)localObject).MEZ);
            if (((com.tencent.mm.plugin.textstatus.proto.f)localObject).MFa <= 0) {
              break label471;
            }
          }
          label471:
          for (long l1 = l2;; l1 = 0L)
          {
            parama.xT(l1);
            parama.xU(((com.tencent.mm.plugin.textstatus.proto.f)localObject).MFb);
            parama.xV(paramLong);
            parama.CY(paramString);
            if (i == 0)
            {
              paramContext = parama.ahi();
              parama.CY(paramContext + "_error");
            }
            parama.xW(cm.bfD());
            parama.nQ(((com.tencent.mm.plugin.textstatus.proto.f)localObject).MFc);
            parama.CZ(((com.tencent.mm.plugin.textstatus.proto.f)localObject).lVU);
            parama.xX(((com.tencent.mm.plugin.textstatus.proto.f)localObject).MFd);
            parama.xY(((com.tencent.mm.plugin.textstatus.proto.f)localObject).MFe);
            parama.xZ(((com.tencent.mm.plugin.textstatus.proto.f)localObject).MFf);
            parama.bpa();
            a((com.tencent.mm.plugin.report.a)parama);
            AppMethodBeat.o(292831);
            return;
            l1 = 2L;
            break;
          }
        }
      }
    }
  }
  
  public static void a(com.tencent.mm.plugin.report.a parama)
  {
    AppMethodBeat.i(233799);
    int i = parama.getId();
    parama = parama.agI();
    p.j(parama, "struct.toShowString()");
    Log.i("MicroMsg.TextStatus.tsReport", "report%s %s", new Object[] { Integer.valueOf(i), n.l(parama, "\r\n", " ", false) });
    AppMethodBeat.o(233799);
  }
  
  private static void a(am paramam, final Long paramLong, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(233827);
    com.tencent.e.h.ZvG.be((Runnable)new c(paramam, paramLong, paramString1, paramString2));
    AppMethodBeat.o(233827);
  }
  
  public static void a(com.tencent.mm.plugin.textstatus.proto.f paramf)
  {
    AppMethodBeat.i(233808);
    p.k(paramf, "exposedData");
    try
    {
      ((g)com.tencent.mm.kernel.h.ag(g.class)).updateOnlyMemory(9, "TextStatusCardExposed", (com.tencent.mm.cd.a)paramf);
      AppMethodBeat.o(233808);
      return;
    }
    catch (Throwable paramf)
    {
      AppMethodBeat.o(233808);
    }
  }
  
  public static void a(String paramString1, final Long paramLong, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(233822);
    if (paramString1 != null)
    {
      ((g)com.tencent.mm.kernel.h.ag(g.class)).getWithoutClear(8, "StatusTextPost_".concat(String.valueOf(paramString1)), am.class, (com.tencent.mm.plugin.secdata.i)new a(paramString1, paramLong, paramString2, paramString3));
      AppMethodBeat.o(233822);
      return;
    }
    Log.i("MicroMsg.TextStatus.tsReport", "postReport: cliPostID is null");
    AppMethodBeat.o(233822);
  }
  
  public static void a(boolean paramBoolean, am paramam)
  {
    AppMethodBeat.i(233821);
    if (paramam != null)
    {
      if (paramBoolean)
      {
        ((g)com.tencent.mm.kernel.h.ag(g.class)).updateWithSave(8, "StatusTextPost_" + paramam.MFV, (com.tencent.mm.cd.a)paramam, (com.tencent.mm.plugin.secdata.i)new a.b(paramBoolean, paramam));
        AppMethodBeat.o(233821);
        return;
      }
      a(paramam, Long.valueOf(3L), "", "");
      AppMethodBeat.o(233821);
      return;
    }
    Log.e("MicroMsg.TextStatus.tsReport", "postReportByTextStatusEditActivity: postData is null, ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(233821);
  }
  
  public static void d(q paramq)
  {
    AppMethodBeat.i(233818);
    if (paramq != null)
    {
      mq localmq = new mq();
      localmq.Dh(Util.nullAs(paramq.sessionId, ""));
      localmq.Di(String.valueOf(paramq.enterTime));
      localmq.yj(paramq.MEC);
      localmq.yk(paramq.enterTime);
      localmq.yl(3L);
      localmq.ym(cm.bfE());
      localmq.nU(paramq.MED);
      localmq.nV(paramq.MEE);
      if (t.gln()) {}
      for (long l = 0L;; l = 1L)
      {
        localmq.yI(l);
        localmq.bpa();
        a((com.tencent.mm.plugin.report.a)localmq);
        AppMethodBeat.o(233818);
        return;
      }
    }
    Log.e("MicroMsg.TextStatus.tsReport", "postReportByTextStatusDoWhatActivity: param is null");
    AppMethodBeat.o(233818);
  }
  
  public static com.tencent.mm.plugin.textstatus.proto.f gmn()
  {
    AppMethodBeat.i(233811);
    try
    {
      com.tencent.mm.plugin.textstatus.proto.f localf = (com.tencent.mm.plugin.textstatus.proto.f)((g)com.tencent.mm.kernel.h.ag(g.class)).getOnlyMemory(9, "TextStatusCardExposed");
      AppMethodBeat.o(233811);
      return localf;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "action", "", "success", "", "info", "Lcom/tencent/mm/plugin/secdata/model/SecReportDataInfo;", "kotlin.jvm.PlatformType", "data", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostReportData;", "onActionDone", "com/tencent/mm/plugin/textstatus/report/TextStatusReporter$postReport$1$1"})
  static final class a<T extends com.tencent.mm.cd.a>
    implements com.tencent.mm.plugin.secdata.i<am>
  {
    a(String paramString1, Long paramLong, String paramString2, String paramString3) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(am paramam, Long paramLong, String paramString1, String paramString2) {}
    
    public final void run()
    {
      long l2 = 0L;
      AppMethodBeat.i(235823);
      mq localmq = new mq();
      localmq.Dh(Util.nullAs(this.MGQ.sessionId, ""));
      localmq.yj(this.MGQ.MEC);
      localmq.Di(Util.nullAs(this.MGQ.MFV, ""));
      localmq.yk(this.MGQ.enterTime);
      Object localObject = paramLong;
      label163:
      String str;
      if (localObject != null)
      {
        l1 = ((Long)localObject).longValue();
        localmq.yl(l1);
        localmq.ym(cm.bfE());
        localmq.Dk(Util.nullAs(paramString1, ""));
        localmq.Dl(Util.nullAs(paramString2, ""));
        localObject = new StringBuilder();
        Iterator localIterator = this.MGQ.MFY.iterator();
        if (!localIterator.hasNext()) {
          break label233;
        }
        str = (String)localIterator.next();
        if (((CharSequence)localObject).length() <= 0) {
          break label228;
        }
      }
      label228:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          ((StringBuilder)localObject).append(";");
        }
        ((StringBuilder)localObject).append(str);
        break label163;
        l1 = 0L;
        break;
      }
      label233:
      localmq.Dj(((StringBuilder)localObject).toString());
      localmq.yn(this.MGQ.MGb);
      localmq.yo(this.MGQ.MGc);
      localmq.yp(this.MGQ.MGd);
      localmq.yq(this.MGQ.MGe);
      localmq.yr(this.MGQ.MGf);
      localmq.Dm(Util.nullAs(this.MGQ.MGg, ""));
      localmq.Dn(Util.nullAs(this.MGQ.MGh, ""));
      localmq.Do(Util.nullAs(this.MGQ.sourceName, ""));
      localmq.Dp(Util.nullAs(this.MGQ.sourceIcon, ""));
      localmq.ys(this.MGQ.MGi);
      localmq.yt(this.MGQ.MGj);
      localmq.yu(this.MGQ.MGk);
      localmq.yv(this.MGQ.MGl);
      localmq.yw(this.MGQ.MGm);
      localmq.yx(this.MGQ.MGn);
      localmq.yy(this.MGQ.MGo);
      localmq.yz(this.MGQ.MGp);
      localmq.yA(this.MGQ.MGq);
      localmq.yB(this.MGQ.MGr);
      localmq.yC(this.MGQ.MGs);
      localmq.yD(this.MGQ.MGt);
      localmq.yE(this.MGQ.MGu);
      localmq.yF(this.MGQ.MGv);
      localmq.yG(this.MGQ.MGw);
      localmq.yH(this.MGQ.MGx);
      localmq.nU(this.MGQ.MED);
      localmq.nV(this.MGQ.MEE);
      if (t.gln()) {}
      for (long l1 = l2;; l1 = 1L)
      {
        localmq.yI(l1);
        localmq.yJ(this.MGQ.MGA);
        localmq.yK(this.MGQ.MGB);
        localmq.Dq(this.MGQ.MGD);
        localmq.Dr(this.MGQ.MGE);
        localmq.yL(this.MGQ.MGy);
        localmq.Ds(this.MGQ.MGz);
        localmq.Dt(this.MGQ.MGF);
        localmq.bpa();
        localObject = a.MGJ;
        a.c((com.tencent.mm.plugin.report.a)localmq);
        AppMethodBeat.o(235823);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.a
 * JD-Core Version:    0.7.0.1
 */