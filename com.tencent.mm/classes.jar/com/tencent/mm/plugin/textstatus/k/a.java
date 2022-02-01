package com.tencent.mm.plugin.textstatus.k;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ol;
import com.tencent.mm.g.b.a.om;
import com.tencent.mm.g.b.a.on;
import com.tencent.mm.g.b.a.oo;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.f.f.d;
import com.tencent.mm.plugin.textstatus.g.w;
import com.tencent.mm.plugin.textstatus.g.y;
import com.tencent.mm.plugin.textstatus.g.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/report/TextStatusReporter;", "", "()V", "TAG", "", "postReport", "", "cliPostID", "exitScene", "", "exitTopicID", "exitTextStatusID", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "postReportByTextStatusDoWhatActivity", "param", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "postReportByTextStatusEditActivity", "finishByPost", "", "postData", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostReportData;", "postReportImp", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostReportData;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "report22208", "action", "actionResult", "report22210", "userName", "scene", "report22216", "exposedData", "Lcom/tencent/mm/plugin/textstatus/proto/TextStateCardExposeData;", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-textstatus_release"})
public final class a
{
  public static final a UsD;
  
  static
  {
    AppMethodBeat.i(258439);
    UsD = new a();
    AppMethodBeat.o(258439);
  }
  
  public static void a(long paramLong, String paramString, y paramy)
  {
    long l2 = 1L;
    AppMethodBeat.i(258431);
    p.h(paramString, "actionResult");
    p.h(paramy, "exposedData");
    Object localObject = f.FXJ;
    localObject = f.aTf(paramy.username);
    if (localObject == null)
    {
      AppMethodBeat.o(258431);
      return;
    }
    ol localol = new ol();
    localol.bwx(paramy.sessionId);
    w localw = ((com.tencent.mm.plugin.textstatus.f.f.a)localObject).fvU();
    localol.bwy(localw.GaI);
    localol.bwz(((com.tencent.mm.plugin.textstatus.f.f.a)localObject).field_StatusID);
    localol.bwA(((com.tencent.mm.plugin.textstatus.f.f.a)localObject).field_IconID);
    localol.bwB(localw.Gao);
    localol.bwC(localw.Gap);
    localol.bwD(localw.Gal);
    localol.bwE(paramy.UrU);
    localol.bwF(paramy.UrV);
    localol.Qw(paramy.UrW);
    localol.Qx(paramy.UrX);
    localol.bwG(paramy.username);
    if (p.j(com.tencent.mm.plugin.auth.a.a.ceA(), paramy.username))
    {
      l1 = 1L;
      localol.Qy(l1);
      localol.Qz(paramy.UrY);
      if (paramy.UrZ <= 0) {
        break label305;
      }
    }
    label305:
    for (long l1 = l2;; l1 = 0L)
    {
      localol.QA(l1);
      localol.QB(paramy.Usa);
      localol.QC(paramLong);
      localol.bwH(paramString);
      localol.QD(cl.aWz());
      localol.bfK();
      a((com.tencent.mm.plugin.report.a)localol);
      AppMethodBeat.o(258431);
      return;
      l1 = 2L;
      break;
    }
  }
  
  private static void a(com.tencent.mm.plugin.report.a parama)
  {
    AppMethodBeat.i(258428);
    int i = parama.getId();
    parama = parama.abW();
    p.g(parama, "struct.toShowString()");
    Log.i("MicroMsg.TxtStatus.tsReport", "report%s %s", new Object[] { Integer.valueOf(i), n.j(parama, "\r\n", " ", false) });
    AppMethodBeat.o(258428);
  }
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(258433);
    if (paramm != null)
    {
      on localon = new on();
      localon.bwK(Util.nullAs(paramm.sessionId, ""));
      localon.bwL(String.valueOf(paramm.enterTime));
      localon.QI(paramm.UrT);
      localon.QJ(paramm.enterTime);
      localon.QK(3L);
      localon.bfK();
      a((com.tencent.mm.plugin.report.a)localon);
      AppMethodBeat.o(258433);
      return;
    }
    Log.e("MicroMsg.TxtStatus.tsReport", "postReportByTextStatusDoWhatActivity: param is null");
    AppMethodBeat.o(258433);
  }
  
  private static void a(z paramz, final Long paramLong, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(258437);
    h.RTc.aX((Runnable)new c(paramz, paramLong, paramString1, paramString2));
    AppMethodBeat.o(258437);
  }
  
  public static void a(String paramString1, final Long paramLong, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(258435);
    if (paramString1 != null)
    {
      ((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.secdata.g.class)).getWithoutClear(8, "StatusTextPost_".concat(String.valueOf(paramString1)), z.class, (com.tencent.mm.plugin.secdata.i)new a(paramString1, paramLong, paramString2, paramString3));
      AppMethodBeat.o(258435);
      return;
    }
    Log.i("MicroMsg.TxtStatus.tsReport", "postReport: cliPostID is null");
    AppMethodBeat.o(258435);
  }
  
  public static void a(boolean paramBoolean, final z paramz)
  {
    AppMethodBeat.i(258434);
    if (paramz != null)
    {
      if (paramBoolean)
      {
        ((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.secdata.g.class)).updateWithSave(8, "StatusTextPost_" + paramz.Usb, (com.tencent.mm.bw.a)paramz, (com.tencent.mm.plugin.secdata.i)new b(paramBoolean, paramz));
        AppMethodBeat.o(258434);
        return;
      }
      a(paramz, Long.valueOf(3L), "", "");
      AppMethodBeat.o(258434);
      return;
    }
    Log.e("MicroMsg.TxtStatus.tsReport", "postReportByTextStatusEditActivity: postData is null, ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(258434);
  }
  
  public static void report22208(long paramLong, String paramString)
  {
    AppMethodBeat.i(258429);
    p.h(paramString, "actionResult");
    paramString = new oo().Rh(paramLong).bwT(paramString).Ri(cl.aWz());
    paramString.bfK();
    p.g(paramString, "it");
    a((com.tencent.mm.plugin.report.a)paramString);
    AppMethodBeat.o(258429);
  }
  
  public static void report22210(String paramString, long paramLong)
  {
    int i = 1;
    long l2 = 1L;
    AppMethodBeat.i(258438);
    p.h(paramString, "userName");
    Object localObject = f.FXJ;
    localObject = f.fvM().aTl(paramString);
    long l1;
    if (paramLong == 2L) {
      if (localObject != null)
      {
        l1 = 1L;
        paramString = new om().bwI(paramString).QE(paramLong);
        if (localObject == null) {
          break label274;
        }
      }
    }
    label268:
    label274:
    for (paramLong = l2;; paramLong = 0L)
    {
      paramString.QF(paramLong).QG(l1).QH(System.currentTimeMillis()).bwJ("").bfK();
      AppMethodBeat.o(258438);
      return;
      l1 = 0L;
      break;
      if (paramLong == 3L)
      {
        if (((CharSequence)paramString).length() == 0) {}
        for (;;)
        {
          if (i != 0) {
            break label268;
          }
          l1 = 1L;
          break;
          i = 0;
        }
      }
      if (paramLong == 4L)
      {
        if (((CharSequence)paramString).length() == 0) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label268;
          }
          l1 = 1L;
          break;
        }
      }
      if (paramLong == 5L)
      {
        l1 = 1L;
        break;
      }
      if (paramLong == 6L)
      {
        l1 = 1L;
        break;
      }
      if (paramLong == 7L)
      {
        l1 = 1L;
        break;
      }
      if (paramLong == 8L)
      {
        l1 = 1L;
        break;
      }
      if (paramLong == 9L)
      {
        l1 = 2L;
        break;
      }
      if (paramLong == 10L)
      {
        l1 = 1L;
        break;
      }
      l1 = 0L;
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "action", "", "success", "", "info", "Lcom/tencent/mm/plugin/secdata/model/SecReportDataInfo;", "kotlin.jvm.PlatformType", "data", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostReportData;", "onActionDone", "com/tencent/mm/plugin/textstatus/report/TextStatusReporter$postReport$1$1"})
  static final class a<T extends com.tencent.mm.bw.a>
    implements com.tencent.mm.plugin.secdata.i<z>
  {
    a(String paramString1, Long paramLong, String paramString2, String paramString3) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "action", "", "success", "", "info", "Lcom/tencent/mm/plugin/secdata/model/SecReportDataInfo;", "kotlin.jvm.PlatformType", "data", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostReportData;", "onActionDone", "com/tencent/mm/plugin/textstatus/report/TextStatusReporter$postReportByTextStatusEditActivity$1$1"})
  static final class b<T extends com.tencent.mm.bw.a>
    implements com.tencent.mm.plugin.secdata.i<z>
  {
    b(boolean paramBoolean, z paramz) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(z paramz, Long paramLong, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(258427);
      on localon = new on();
      localon.bwK(Util.nullAs(this.UsK.sessionId, ""));
      localon.QI(this.UsK.UrT);
      localon.bwL(Util.nullAs(this.UsK.Usb, ""));
      localon.QJ(this.UsK.enterTime);
      Object localObject = paramLong;
      long l;
      label160:
      String str;
      if (localObject != null)
      {
        l = ((Long)localObject).longValue();
        localon.QK(l);
        localon.QL(cl.aWA());
        localon.bwN(Util.nullAs(paramString1, ""));
        localon.bwO(Util.nullAs(paramString2, ""));
        localObject = new StringBuilder();
        Iterator localIterator = this.UsK.Usd.iterator();
        if (!localIterator.hasNext()) {
          break label230;
        }
        str = (String)localIterator.next();
        if (((CharSequence)localObject).length() <= 0) {
          break label225;
        }
      }
      label225:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          ((StringBuilder)localObject).append(";");
        }
        ((StringBuilder)localObject).append(str);
        break label160;
        l = 0L;
        break;
      }
      label230:
      localon.bwM(((StringBuilder)localObject).toString());
      localon.bwN(Util.nullAs(this.UsK.Use, ""));
      localon.bwO(Util.nullAs(this.UsK.Usf, ""));
      localon.QM(this.UsK.Usg);
      localon.QN(this.UsK.Ush);
      localon.QO(this.UsK.Usi);
      localon.QP(this.UsK.Usj);
      localon.QQ(this.UsK.Usk);
      localon.bwP(Util.nullAs(this.UsK.Usl, ""));
      localon.bwQ(Util.nullAs(this.UsK.Usm, ""));
      localon.bwR(Util.nullAs(this.UsK.iFo, ""));
      localon.bwS(Util.nullAs(this.UsK.iFp, ""));
      localon.QR(this.UsK.Usn);
      localon.QS(this.UsK.Uso);
      localon.QT(this.UsK.Usp);
      localon.QU(this.UsK.Usq);
      localon.QV(this.UsK.Usr);
      localon.QW(this.UsK.Uss);
      localon.QX(this.UsK.Ust);
      localon.QY(this.UsK.Usu);
      localon.QZ(this.UsK.Usv);
      localon.Ra(this.UsK.Usw);
      localon.Rb(this.UsK.Usx);
      localon.Rc(this.UsK.Usy);
      localon.Rd(this.UsK.Usz);
      localon.Re(this.UsK.UsA);
      localon.Rf(this.UsK.UsB);
      localon.Rg(this.UsK.UsC);
      localon.bfK();
      localObject = a.UsD;
      a.c((com.tencent.mm.plugin.report.a)localon);
      AppMethodBeat.o(258427);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.k.a
 * JD-Core Version:    0.7.0.1
 */