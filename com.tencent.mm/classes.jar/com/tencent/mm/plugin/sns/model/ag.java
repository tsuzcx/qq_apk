package com.tencent.mm.plugin.sns.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.bv;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.a.jn;
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.nq.a;
import com.tencent.mm.g.a.qv;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.g.a.qw.a;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qx.a;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.re.a;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.g.a.uf;
import com.tencent.mm.g.a.wz;
import com.tencent.mm.g.a.xn;
import com.tencent.mm.memory.e.a;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.model.av;
import com.tencent.mm.model.cd;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.sns.n;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.z;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bi.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storagebase.h.b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public final class ag
  implements com.tencent.mm.model.ax, com.tencent.mm.plugin.sns.b.k
{
  private static n.a appForegroundListener;
  private static Point hqz;
  private static String zjK;
  protected static HashMap<Integer, h.b> zjL;
  private static com.tencent.mm.sdk.platformtools.ap zjT;
  private static int zjU;
  private static int zjV;
  public static boolean zjc;
  private static int zjd;
  private static int zje;
  private static int zji;
  private static int zjj;
  private com.tencent.mm.storagebase.h gBq;
  private com.tencent.mm.sdk.platformtools.ap handler;
  private byte[] lock;
  private boolean rFO;
  private com.tencent.mm.sdk.b.c whK;
  private ExecutorService ylq;
  private com.tencent.mm.plugin.sns.h.g zjA;
  private at zjB;
  private aq zjC;
  private s zjD;
  private com.tencent.mm.plugin.sns.ad.d.k zjE;
  private ap zjF;
  private boolean zjG;
  private z zjH;
  private boolean zjI;
  private byte[] zjJ;
  private com.tencent.mm.plugin.sns.d zjM;
  private com.tencent.mm.plugin.sns.g.a zjN;
  private aw zjO;
  private com.tencent.mm.plugin.sns.lucky.a.f zjP;
  private com.tencent.mm.plugin.sns.lucky.a.j zjQ;
  private com.tencent.mm.plugin.sns.lucky.a.d zjR;
  private com.tencent.mm.plugin.sns.lucky.a.l zjS;
  private n zjW;
  private com.tencent.mm.plugin.sns.k zjX;
  private com.tencent.mm.plugin.sns.e zjY;
  private com.tencent.mm.plugin.sns.q zjZ;
  private ExecutorService zjf;
  private ExecutorService zjg;
  private ExecutorService zjh;
  private u zjk;
  private com.tencent.mm.plugin.sns.storage.q zjl;
  private com.tencent.mm.plugin.sns.storage.f zjm;
  private com.tencent.mm.plugin.sns.storage.d zjn;
  private ab zjo;
  private f zjp;
  private com.tencent.mm.plugin.sns.storage.o zjq;
  private com.tencent.mm.plugin.sns.storage.k zjr;
  private w zjs;
  private com.tencent.mm.plugin.sns.storage.m zjt;
  private ae zju;
  private an.a zjv;
  private b zjw;
  private bb zjx;
  private com.tencent.mm.plugin.sns.ui.ap zjy;
  private com.tencent.mm.plugin.sns.h.c zjz;
  private boolean zkA;
  private com.tencent.mm.sdk.b.c zkB;
  private com.tencent.mm.sdk.b.c zkC;
  private com.tencent.mm.plugin.sns.h zka;
  private com.tencent.mm.plugin.sns.g zkb;
  private com.tencent.mm.plugin.sns.m zkc;
  private com.tencent.mm.plugin.sns.j zkd;
  private com.tencent.mm.plugin.sns.b zke;
  private com.tencent.mm.plugin.sns.c zkf;
  private com.tencent.mm.plugin.sns.f zkg;
  private com.tencent.mm.sdk.b.c zkh;
  private com.tencent.mm.sdk.b.c zki;
  private com.tencent.mm.sdk.b.c zkj;
  private com.tencent.mm.sdk.b.c zkk;
  private com.tencent.mm.sdk.b.c zkl;
  private com.tencent.mm.sdk.b.c zkm;
  private com.tencent.mm.sdk.b.c zkn;
  private com.tencent.mm.sdk.b.c zko;
  private com.tencent.mm.sdk.b.c zkp;
  private com.tencent.mm.sdk.b.c zkq;
  private com.tencent.mm.sdk.b.c zkr;
  private com.tencent.mm.sdk.b.c zks;
  private com.tencent.mm.sdk.b.c zkt;
  private com.tencent.mm.sdk.b.c zku;
  private com.tencent.mm.sdk.b.c zkv;
  private com.tencent.mm.sdk.b.c zkw;
  private com.tencent.mm.sdk.b.c zkx;
  private com.tencent.mm.sdk.b.c zky;
  private com.tencent.mm.sdk.b.c zkz;
  
  static
  {
    AppMethodBeat.i(95843);
    zjc = true;
    zjd = 0;
    zje = 0;
    zjK = "";
    zjL = new HashMap();
    zjU = 103;
    zjV = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 130);
    hqz = new Point();
    zjL.put(Integer.valueOf("CanvasInfo".hashCode()), new ag.1());
    zjL.put(Integer.valueOf("UxCanvasInfo".hashCode()), new ag.12());
    zjL.put(Integer.valueOf("SNSMEDIA_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return u.SQL_CREATE;
      }
    });
    zjL.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.q.SQL_CREATE;
      }
    });
    zjL.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.q.SQL_CREATE;
      }
    });
    zjL.put(Integer.valueOf("ADSNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.f.SQL_CREATE;
      }
    });
    zjL.put(Integer.valueOf("SNSEXT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.o.SQL_CREATE;
      }
    });
    zjL.put(Integer.valueOf("SNSCOMMENT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.k.SQL_CREATE;
      }
    });
    zjL.put(Integer.valueOf("SNSTAGINFO_TABLE".hashCode()), new ag.38());
    zjL.put(Integer.valueOf("SNSKVREPORT_TABLE".hashCode()), new ag.2());
    zjL.put(Integer.valueOf("SNSDRAFT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.m.SQL_CREATE;
      }
    });
    appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(176255);
        if ((com.tencent.mm.kernel.g.ajx()) && (com.tencent.mm.kernel.g.ajA().gAD))
        {
          com.tencent.mm.kernel.g.ajA();
          if (!com.tencent.mm.kernel.a.aiE())
          {
            paramAnonymousString = new qv();
            paramAnonymousString.dFt.state = 0;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString);
            paramAnonymousString = new wz();
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(176255);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(176254);
        if ((com.tencent.mm.kernel.g.ajx()) && (com.tencent.mm.kernel.g.ajA().gAD))
        {
          com.tencent.mm.kernel.g.ajA();
          if (!com.tencent.mm.kernel.a.aiE())
          {
            paramAnonymousString = new qv();
            paramAnonymousString.dFt.state = 1;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(176254);
      }
    };
    AppMethodBeat.o(95843);
  }
  
  public ag()
  {
    AppMethodBeat.i(95798);
    this.handler = new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper());
    this.zjF = new ap();
    this.rFO = false;
    this.zjG = true;
    this.lock = new byte[0];
    this.zjH = new z();
    this.zjI = false;
    this.zjJ = new byte[0];
    this.zjP = new com.tencent.mm.plugin.sns.lucky.a.f();
    this.zjQ = new com.tencent.mm.plugin.sns.lucky.a.j();
    this.zjR = new com.tencent.mm.plugin.sns.lucky.a.d();
    this.zjS = new com.tencent.mm.plugin.sns.lucky.a.l();
    this.zkh = new ag.8(this);
    this.zki = new ag.9(this);
    this.zkj = new ag.10(this);
    this.zkk = new ag.11(this);
    this.zkl = new com.tencent.mm.sdk.b.c() {};
    this.zkm = new com.tencent.mm.sdk.b.c() {};
    this.zkn = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(nq paramAnonymousnq)
      {
        AppMethodBeat.i(176261);
        Object localObject2 = paramAnonymousnq.dBB.dvl;
        com.tencent.mm.plugin.sns.storage.q localq = ag.dUe();
        paramAnonymousnq = ag.getDataDB();
        long l1 = paramAnonymousnq.xO(-1L);
        try
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            long l2 = ((Long)((Iterator)localObject2).next()).longValue();
            p localp = localq.QP((int)l2);
            if (localp != null)
            {
              localp.field_localFlag |= 0x40;
              ad.d("MicroMsg.SnsInfoStorage", "snsInfoId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
              localq.b((int)l2, localp);
            }
          }
          paramAnonymousnq.sJ(l1);
        }
        finally
        {
          paramAnonymousnq.sJ(l1);
          AppMethodBeat.o(176261);
        }
        AppMethodBeat.o(176261);
        return false;
      }
    };
    this.zko = new com.tencent.mm.sdk.b.c() {};
    this.zkp = new ag.17(this);
    this.zkq = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(qw paramAnonymousqw)
      {
        AppMethodBeat.i(176263);
        try
        {
          SnsAdClick localSnsAdClick = paramAnonymousqw.dFu.dFv;
          paramAnonymousqw = ag.dUh().zZ(localSnsAdClick.dJc);
          if (paramAnonymousqw == null)
          {
            AppMethodBeat.o(176263);
            return false;
          }
          p localp = paramAnonymousqw.dYr();
          String str1;
          String str2;
          com.tencent.mm.plugin.sns.ad.d.a locala;
          if (localSnsAdClick.dnh == 2)
          {
            paramAnonymousqw = localp.dYi();
            if (paramAnonymousqw == null) {
              break label434;
            }
            str1 = paramAnonymousqw.zvb;
            str2 = com.tencent.mm.plugin.sns.waid.b.aBl(str1);
            locala = new com.tencent.mm.plugin.sns.ad.d.a();
            locala.yXB = com.tencent.mm.plugin.sns.data.j.j(localp);
            locala.yXC = com.tencent.mm.plugin.sns.data.j.k(localp);
            locala.yXD = ((int)localSnsAdClick.inb);
            if (localSnsAdClick.dnh != 2) {
              break label267;
            }
            ad.i("MicroMsg.SnsCore", "at_friend_detail report ad click, exposureTime=" + localSnsAdClick.ina + ", clkPos=" + localSnsAdClick.imT + ", pkg=" + str1 + ", waid=" + str2);
            paramAnonymousqw = new com.tencent.mm.plugin.sns.ad.d.e(localSnsAdClick.dJc, paramAnonymousqw.aQj, localSnsAdClick.imT, localSnsAdClick.imU, localSnsAdClick.imS, "", localp.dYW(), localp.dYl().zRz, localSnsAdClick.imZ, localp.dYU().dYp(), localp.dYU().dYq(), localSnsAdClick.ina, str1, str2, locala);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousqw, 0);
          }
          for (;;)
          {
            AppMethodBeat.o(176263);
            return true;
            paramAnonymousqw = localp.dRK();
            break;
            label267:
            ad.i("MicroMsg.SnsCore", "report ad click, exposureTime=" + localSnsAdClick.ina + ", clkPos=" + localSnsAdClick.imT + ", source=" + localSnsAdClick.dnh + ", pkg=" + str1 + ", waid=" + str2);
            paramAnonymousqw = new com.tencent.mm.plugin.sns.ad.d.e(localSnsAdClick.dJc, paramAnonymousqw.aQj, localSnsAdClick.imT, localSnsAdClick.imU, localSnsAdClick.imS, "", localp.dYW(), localp.dYl().zRz, localSnsAdClick.imZ, localp.dYU().dYn(), localp.dYU().dYo(), localSnsAdClick.ina, str1, str2, locala);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousqw, 0);
          }
          label434:
          return false;
        }
        catch (Exception paramAnonymousqw)
        {
          ad.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousqw, "report ad click error", new Object[0]);
          AppMethodBeat.o(176263);
        }
      }
    };
    this.zkr = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(qx paramAnonymousqx)
      {
        AppMethodBeat.i(176264);
        SnsAdClick localSnsAdClick;
        Object localObject1;
        try
        {
          localSnsAdClick = paramAnonymousqx.dFw.dFv;
          localObject1 = ag.dUh().zZ(localSnsAdClick.dJc);
          if (localObject1 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.sns.storage.e)localObject1).dYr();
            if (localSnsAdClick.dnh == 2)
            {
              localObject1 = ((p)localObject2).dYi();
              if (localObject1 == null) {
                break label227;
              }
              if (localSnsAdClick.dnh != 2) {
                break label204;
              }
              ad.i("MicroMsg.SnsCore", "at_friend_detail report ad h5 load");
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.g.yhR.f(16972, new Object[] { Long.valueOf(localSnsAdClick.dJc), Integer.valueOf(localSnsAdClick.imS), ((com.tencent.mm.plugin.sns.storage.a)localObject1).dFy, Integer.valueOf(((p)localObject2).dYV()), ((p)localObject2).dYl().zRz, paramAnonymousqx.dFw.url, Integer.valueOf(paramAnonymousqx.dFw.dFx), Integer.valueOf(paramAnonymousqx.dFw.errorCode), Long.valueOf(paramAnonymousqx.dFw.timestamp) });
              AppMethodBeat.o(176264);
              return true;
              localObject1 = ((p)localObject2).dRK();
              break;
              label204:
              ad.i("MicroMsg.SnsCore", "report ad h5 load");
            }
          }
          label227:
          localObject1 = ag.dUe().Ai(localSnsAdClick.dJc);
        }
        catch (Exception paramAnonymousqx)
        {
          ad.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousqx, "report load ad h5 error", new Object[0]);
          AppMethodBeat.o(176264);
          return false;
        }
        Object localObject2 = new StringBuilder("report ad h5, AdSnsInfo==null, uxInfo=").append(paramAnonymousqx.dFw.dFy).append(", snsInfo==null?");
        boolean bool;
        String str;
        int i;
        if (localObject1 == null)
        {
          bool = true;
          ad.i("MicroMsg.SnsCore", bool);
          if (localObject1 == null) {
            break label450;
          }
          str = paramAnonymousqx.dFw.dFy;
          i = ((p)localObject1).dYV();
          localObject1 = ((p)localObject1).dYl();
          if (localObject1 != null) {
            break label442;
          }
          localObject1 = "";
          break label569;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(16972, new Object[] { Long.valueOf(localSnsAdClick.dJc), Integer.valueOf(localSnsAdClick.imS), str, Integer.valueOf(i), localObject2, paramAnonymousqx.dFw.url, Integer.valueOf(paramAnonymousqx.dFw.dFx), Integer.valueOf(paramAnonymousqx.dFw.errorCode), Long.valueOf(paramAnonymousqx.dFw.timestamp) });
          AppMethodBeat.o(176264);
          return true;
          bool = false;
          break;
          label442:
          localObject1 = ((TimeLineObject)localObject1).zRz;
          break label569;
          label450:
          localObject1 = paramAnonymousqx.dFw.dFy;
          com.tencent.mm.plugin.report.service.g.yhR.f(16972, new Object[] { Long.valueOf(localSnsAdClick.dJc), Integer.valueOf(localSnsAdClick.imS), localObject1, Integer.valueOf(0), "", paramAnonymousqx.dFw.url, Integer.valueOf(paramAnonymousqx.dFw.dFx), Integer.valueOf(paramAnonymousqx.dFw.errorCode), Long.valueOf(paramAnonymousqx.dFw.timestamp) });
          AppMethodBeat.o(176264);
          return true;
          label569:
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
        }
      }
    };
    this.zks = new ag.20(this);
    this.zkt = new ag.21(this);
    this.zku = new com.tencent.mm.sdk.b.c() {};
    this.zkv = new com.tencent.mm.sdk.b.c() {};
    this.zkw = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(re paramAnonymousre)
      {
        AppMethodBeat.i(176265);
        SnsAdClick localSnsAdClick = paramAnonymousre.dFM.dFv;
        try
        {
          if (paramAnonymousre.dFM.dFN != 1) {
            break label259;
          }
          if (localSnsAdClick.imV != 1) {
            break label365;
          }
          locale = ag.dUh().zZ(localSnsAdClick.dJc);
          if ((locale == null) || (!locale.dWk())) {
            break label266;
          }
          localObject2 = ag.dTY();
          j = 14647;
          localObject1 = new Object[7];
          localObject1[0] = Long.valueOf(localSnsAdClick.dJc);
          localObject1[1] = locale.dRK().dFy;
          localObject1[2] = Integer.valueOf(localSnsAdClick.imS);
          localObject1[3] = Long.valueOf(localSnsAdClick.startTime);
          localObject1[4] = Long.valueOf(System.currentTimeMillis());
          i = locale.dYj();
          paramAnonymousre = (re)localObject1;
        }
        catch (Exception paramAnonymousre)
        {
          for (;;)
          {
            com.tencent.mm.plugin.sns.storage.e locale;
            int j;
            com.tencent.mm.plugin.sns.ad.d.k localk;
            ad.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousre, "report ad click error", new Object[0]);
            continue;
            Object localObject1 = paramAnonymousre.dFM.dFy;
            paramAnonymousre = (re)localObject1;
            if (localObject1 == null) {
              paramAnonymousre = "";
            }
            ad.i("MicroMsg.SnsCore", "ReportSnsEvent, AdSnsInfo==null, uxInfo=".concat(String.valueOf(paramAnonymousre)));
            boolean bool = false;
            continue;
            ag.dTY().f(12013, new Object[] { localObject1 });
            continue;
            int i = -1;
            localObject1 = paramAnonymousre;
            Object localObject2 = paramAnonymousre;
            paramAnonymousre = (re)localObject1;
            localObject1 = localObject2;
            localObject2 = localk;
          }
        }
        paramAnonymousre[5] = Integer.valueOf(i);
        localObject1[6] = "";
        ((com.tencent.mm.plugin.sns.ad.d.k)localObject2).f(j, (Object[])localObject1);
        paramAnonymousre = com.tencent.mm.modelsns.e.pW(750);
        paramAnonymousre.Gs(localSnsAdClick.dJc).Gs(locale.dRK().dFy).pY(localSnsAdClick.imS).Gs(localSnsAdClick.startTime).Gs(System.currentTimeMillis());
        paramAnonymousre.aLk();
        for (;;)
        {
          label259:
          AppMethodBeat.o(176265);
          return false;
          label266:
          localk = ag.dTY();
          j = 13155;
          paramAnonymousre = new Object[7];
          paramAnonymousre[0] = Long.valueOf(localSnsAdClick.dJc);
          paramAnonymousre[1] = locale.dRK().dFy;
          paramAnonymousre[2] = Integer.valueOf(localSnsAdClick.imS);
          paramAnonymousre[3] = Long.valueOf(localSnsAdClick.startTime);
          paramAnonymousre[4] = Long.valueOf(System.currentTimeMillis());
          if (locale == null) {
            break label753;
          }
          i = locale.dYj();
          localObject1 = paramAnonymousre;
          localObject2 = paramAnonymousre;
          paramAnonymousre = (re)localObject1;
          localObject1 = localObject2;
          localObject2 = localk;
          break;
          label365:
          localObject1 = ag.dUh().zZ(localSnsAdClick.dJc);
          if (localObject1 == null) {
            break label693;
          }
          paramAnonymousre = ((com.tencent.mm.plugin.sns.storage.e)localObject1).dRK().dFy;
          bool = ((com.tencent.mm.plugin.sns.storage.e)localObject1).dWk();
          localObject1 = com.tencent.mm.plugin.sns.ad.d.h.a(localSnsAdClick.dJc, new Object[] { localSnsAdClick, paramAnonymousre, Integer.valueOf(localSnsAdClick.imS), Long.valueOf(localSnsAdClick.startTime), Long.valueOf(System.currentTimeMillis()) });
          localObject1 = (String)localObject1 + String.format(",%s", new Object[] { localSnsAdClick.imW });
          localObject1 = (String)localObject1 + String.format(",%s", new Object[] { System.currentTimeMillis() - localSnsAdClick.startTime - localSnsAdClick.imY });
          if (!bool) {
            break label732;
          }
          ag.dTY().f(14643, new Object[] { localObject1 });
          localObject1 = com.tencent.mm.modelsns.e.pW(733);
          ((com.tencent.mm.modelsns.e)localObject1).Gs(localSnsAdClick.dJc).Gs(paramAnonymousre).pY(localSnsAdClick.imS).Gs(localSnsAdClick.startTime).Gs(System.currentTimeMillis());
          ((com.tencent.mm.modelsns.e)localObject1).aLk();
        }
      }
    };
    this.zkx = new ag.26(this);
    this.zky = new com.tencent.mm.sdk.b.c() {};
    this.zkz = new ag.28(this);
    this.zkA = false;
    this.whK = new com.tencent.mm.sdk.b.c() {};
    this.zkB = new ag.31(this);
    this.zkC = new com.tencent.mm.sdk.b.c() {};
    ad.i("MicroMsg.SnsCore", "snscore create! " + Thread.currentThread().getId());
    if (this.zjg == null) {
      this.zjg = com.tencent.e.h.LTJ.a("SnsCore_CDNDownload_handler", 6, 6, new LinkedBlockingQueue());
    }
    if (this.ylq == null) {
      this.ylq = com.tencent.e.h.LTJ.a("SnsCore_thumbDecode_handler", 6, 6, new LinkedBlockingQueue());
    }
    if (this.zjf == null) {
      this.zjf = com.tencent.e.h.LTJ.aZA("SnsCore#File");
    }
    if (this.zjh == null) {
      this.zjh = com.tencent.e.h.LTJ.aZA("SnsCore#Task");
    }
    if ((((ActivityManager)aj.getContext().getSystemService("activity")).getLargeMemoryClass() > 256) && (Build.VERSION.SDK_INT != 24)) {
      int i = Build.VERSION.SDK_INT;
    }
    AppMethodBeat.o(95798);
  }
  
  public static com.tencent.mm.sdk.platformtools.ap cVf()
  {
    AppMethodBeat.i(95804);
    com.tencent.mm.sdk.platformtools.ap localap = dTL().handler;
    AppMethodBeat.o(95804);
    return localap;
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(95835);
    com.tencent.mm.vfs.i.aYg(((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath());
    com.tencent.mm.vfs.i.aYg(((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsTmpPath());
    com.tencent.mm.vfs.i.aYu(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.dYb());
    AppMethodBeat.o(95835);
  }
  
  public static com.tencent.mm.sdk.platformtools.ap dFL()
  {
    AppMethodBeat.i(95799);
    if (zjT == null) {
      zjT = new com.tencent.mm.sdk.platformtools.ap("MicroMsg.SnsCore#WorkingHandler");
    }
    com.tencent.mm.sdk.platformtools.ap localap = zjT;
    AppMethodBeat.o(95799);
    return localap;
  }
  
  public static String dTJ()
  {
    AppMethodBeat.i(95793);
    com.tencent.mm.kernel.g.ajD();
    String str = (String)com.tencent.mm.kernel.g.ajC().ajl().get(2, null);
    AppMethodBeat.o(95793);
    return str;
  }
  
  public static int dTK()
  {
    AppMethodBeat.i(95794);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA();
    int i = com.tencent.mm.kernel.a.getUin();
    AppMethodBeat.o(95794);
    return i;
  }
  
  private static ag dTL()
  {
    AppMethodBeat.i(95796);
    ag localag = (ag)com.tencent.mm.model.t.ap(ag.class);
    if (!localag.zjI) {}
    synchronized (localag.zjJ)
    {
      if (!localag.zjI)
      {
        ad.i("MicroMsg.SnsCore", "onAccInit because bug!");
        localag.onAccountPostReset(true);
      }
      if (!localag.rFO) {}
    }
    Object localObject3;
    String str;
    long l1;
    for (;;)
    {
      synchronized (localag.lock)
      {
        ad.i("MicroMsg.SnsCore", "getCore need reset DB now " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + localag.hashCode());
        if (localag.rFO)
        {
          localag.zjG = false;
          localObject4 = localag.zjH;
          localObject3 = zjL;
          if (((z)localObject4).zNw)
          {
            ad.i("MicroMsg.TrimSnsDb", "pass hasTrim");
            if (localag.gBq == null)
            {
              localag.gBq = new com.tencent.mm.storagebase.h();
              com.tencent.mm.kernel.g.ajD();
              localObject3 = com.tencent.mm.kernel.g.ajC().cachePath;
              localObject3 = (String)localObject3 + "SnsMicroMsg.db";
              if (!localag.gBq.b((String)localObject3, zjL, true)) {
                dTM();
              }
            }
            localag.rFO = false;
            ad.i("MicroMsg.SnsCore", "resetdb done");
          }
        }
        else
        {
          AppMethodBeat.o(95796);
          return localag;
          localObject1 = finally;
          AppMethodBeat.o(95796);
          throw localObject1;
        }
        com.tencent.mm.kernel.g.ajD();
        if (!com.tencent.mm.kernel.g.ajA().aiK()) {
          continue;
        }
        i = bt.getInt(com.tencent.mm.n.g.acA().getValue("AndroidCleanSnsDb"), 0);
        ad.i("MicroMsg.TrimSnsDb", "pass dynamic? ".concat(String.valueOf(i)));
        if (i > 0) {
          continue;
        }
        com.tencent.mm.kernel.g.ajD();
        str = com.tencent.mm.kernel.g.ajC().cachePath;
        if (com.tencent.mm.vfs.i.fv(str + "SnsMicroMsg2.db.ini"))
        {
          z.aAA(str);
          com.tencent.mm.vfs.i.deleteFile(str + "SnsMicroMsg2.db.ini");
        }
        localObject5 = aj.getContext().getSharedPreferences(aj.fkC(), 0);
        if (bt.rM(((SharedPreferences)localObject5).getLong("check_trim_time", 0L)) < 604800L) {
          ad.i("MicroMsg.TrimSnsDb", "trim sns pass because time short");
        }
      }
      ((SharedPreferences)localObject5).edit().putLong("check_trim_time", bt.aQJ()).commit();
      ((z)localObject4).zNw = true;
      l1 = System.currentTimeMillis();
      i = com.tencent.mm.r.a.adB();
      if ((i == 1) || (i == 2))
      {
        ad.i("MicroMsg.TrimSnsDb", "trim sns error space dangerous");
      }
      else if (com.tencent.mm.vfs.i.fv(str + "sns_mark.ini"))
      {
        if (bt.Df(com.tencent.mm.vfs.i.aYp(str + "sns_mark.ini")) < 2592000000L)
        {
          ad.i("MicroMsg.TrimSnsDb", "mark file exist and return");
          z.aAA(str);
        }
        else
        {
          com.tencent.mm.vfs.i.deleteFile(str + "sns_mark.ini");
        }
      }
      else
      {
        l2 = com.tencent.mm.vfs.i.aYo(str + "SnsMicroMsg.db");
        ad.i("MicroMsg.TrimSnsDb", "trim sns ".concat(String.valueOf(l2)));
        if (l2 >= 52428800L) {
          break;
        }
        ad.i("MicroMsg.TrimSnsDb", "trim sns free pass: " + (System.currentTimeMillis() - l1));
      }
    }
    com.tencent.mm.vfs.i.aYs(str + "sns_mark.ini");
    Object localObject5 = str + "SnsMicroMsg2.db";
    Object localObject4 = new com.tencent.mm.storagebase.h();
    com.tencent.mm.model.b localb;
    if (!((com.tencent.mm.storagebase.h)localObject4).b((String)localObject5, null, false))
    {
      localb = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(95796);
      throw localb;
    }
    localObject5 = new com.tencent.mm.storagebase.h();
    if (!((com.tencent.mm.storagebase.h)localObject5).b(str + "SnsMicroMsg.db", (HashMap)localObject3, true))
    {
      localb = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(95796);
      throw localb;
    }
    long l2 = System.currentTimeMillis();
    if (!z.a((com.tencent.mm.storagebase.h)localObject5, (com.tencent.mm.storagebase.h)localObject4)) {}
    for (int i = -1;; i = 1)
    {
      long l3 = System.currentTimeMillis() - l2;
      ad.i("MicroMsg.TrimSnsDb", "copysns insert all %d passed ret:".concat(String.valueOf(i)), new Object[] { Long.valueOf(l3) });
      ((com.tencent.mm.storagebase.h)localObject5).closeDB();
      ((com.tencent.mm.storagebase.h)localObject4).closeDB();
      if (i >= 0)
      {
        com.tencent.mm.kernel.g.ajD();
        localObject3 = com.tencent.mm.kernel.g.ajC().cachePath;
        com.tencent.mm.vfs.i.deleteFile((String)localObject3 + "SnsMicroMsg.db");
        ad.i("MicroMsg.TrimSnsDb", "rename file ".concat(String.valueOf(com.tencent.mm.vfs.i.bb((String)localObject3, "SnsMicroMsg2.db", "SnsMicroMsg.db"))));
        com.tencent.mm.vfs.i.deleteFile((String)localObject3 + "SnsMicroMsg.db-shm");
        com.tencent.mm.vfs.i.deleteFile((String)localObject3 + "SnsMicroMsg.db-wal");
        com.tencent.mm.vfs.i.deleteFile((String)localObject3 + "SnsMicroMsg.db.ini");
        com.tencent.mm.vfs.i.mz("SnsMicroMsg2.db.ini", "SnsMicroMsg.db.ini");
        com.tencent.mm.vfs.i.deleteFile((String)localObject3 + "SnsMicroMsg2.db.ini");
        com.tencent.mm.vfs.i.deleteFile((String)localObject3 + "SnsMicroMsg2.db");
        com.tencent.mm.vfs.i.deleteFile((String)localObject3 + "sns_mark.ini");
      }
      l2 = System.currentTimeMillis() - l2;
      ad.i("MicroMsg.TrimSnsDb", "copysns data ret=%d all: %d copytime %d ", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l2 - l3) });
      ad.i("MicroMsg.TrimSnsDb", "trim sns done pass: " + (System.currentTimeMillis() - l1));
      break;
      l3 = System.currentTimeMillis();
      z.a((com.tencent.mm.storagebase.h)localObject5, (com.tencent.mm.storagebase.h)localObject4, "snsExtInfo3");
      boolean bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "insert into " + "snsExtInfo3" + " select * from old." + "snsExtInfo3");
      ad.i("MicroMsg.TrimSnsDb", "copysns ret_ext:" + bool + " passed " + (System.currentTimeMillis() - l3));
      z.a((com.tencent.mm.storagebase.h)localObject5, (com.tencent.mm.storagebase.h)localObject4, "SnsComment");
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "insert into " + "SnsComment" + " select * from old." + "SnsComment");
      ad.i("MicroMsg.TrimSnsDb", "copysns ret_msg:" + bool + " passed " + (System.currentTimeMillis() - l3));
      z.a((com.tencent.mm.storagebase.h)localObject5, (com.tencent.mm.storagebase.h)localObject4, "SnsInfo");
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "insert into " + "SnsInfo" + " select * from old." + "SnsInfo" + " where  (sourceType & 2 != 0 ) " + com.tencent.mm.plugin.sns.storage.q.zMV + " limit 200");
      ad.i("MicroMsg.TrimSnsDb", "copysns ret_sns:" + bool + " passed " + (System.currentTimeMillis() - l3));
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "update snsExtinfo3 set md5 = '', faults = '';");
      ad.i("MicroMsg.TrimSnsDb", "update ext info  passed  %s  updateRet %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l3), Boolean.valueOf(bool) });
      ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "DETACH DATABASE old");
    }
  }
  
  private static void dTM()
  {
    AppMethodBeat.i(197846);
    com.tencent.mm.kernel.g.ajD();
    String[] arrayOfString = new File(com.tencent.mm.kernel.g.ajC().cachePath).list();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        ad.i("MicroMsg.SnsCore", "removeDirtyDB file:%s", new Object[] { str });
        if ((str != null) && (str.contains("SnsMicroMsg")))
        {
          ad.i("MicroMsg.SnsCore", "removeDirtyDB will delete:%s", new Object[] { str });
          com.tencent.mm.vfs.i.deleteFile(str);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(197846);
  }
  
  public static boolean dTN()
  {
    AppMethodBeat.i(95797);
    dTL();
    if (!com.tencent.mm.kernel.g.ajA().aiK())
    {
      AppMethodBeat.o(95797);
      return true;
    }
    AppMethodBeat.o(95797);
    return false;
  }
  
  public static ExecutorService dTO()
  {
    AppMethodBeat.i(179089);
    ExecutorService localExecutorService = dTL().zjg;
    AppMethodBeat.o(179089);
    return localExecutorService;
  }
  
  public static ExecutorService dTP()
  {
    AppMethodBeat.i(179090);
    ExecutorService localExecutorService = dTL().ylq;
    AppMethodBeat.o(179090);
    return localExecutorService;
  }
  
  protected static ExecutorService dTQ()
  {
    AppMethodBeat.i(179091);
    ExecutorService localExecutorService = dTL().zjf;
    AppMethodBeat.o(179091);
    return localExecutorService;
  }
  
  public static ExecutorService dTR()
  {
    AppMethodBeat.i(179092);
    ExecutorService localExecutorService = dTL().zjh;
    AppMethodBeat.o(179092);
    return localExecutorService;
  }
  
  public static bp dTS()
  {
    AppMethodBeat.i(95808);
    com.tencent.mm.kernel.g.ajD();
    bp localbp = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp();
    AppMethodBeat.o(95808);
    return localbp;
  }
  
  public static u dTT()
  {
    AppMethodBeat.i(95809);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjk == null) {
      dTL().zjk = new u(dTL().gBq);
    }
    u localu = dTL().zjk;
    AppMethodBeat.o(95809);
    return localu;
  }
  
  public static an.a dTU()
  {
    AppMethodBeat.i(95810);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjv == null)
    {
      dTL().zjv = new an.a();
      com.tencent.mm.plugin.sns.b.o.zbX = dTL().zjv;
    }
    an.a locala = dTL().zjv;
    AppMethodBeat.o(95810);
    return locala;
  }
  
  public static com.tencent.mm.plugin.sns.h.c dTV()
  {
    AppMethodBeat.i(95811);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjz == null) {
      dTL().zjz = new com.tencent.mm.plugin.sns.h.c();
    }
    com.tencent.mm.plugin.sns.h.c localc = dTL().zjz;
    AppMethodBeat.o(95811);
    return localc;
  }
  
  public static com.tencent.mm.plugin.sns.h.g dTW()
  {
    AppMethodBeat.i(95812);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjA == null) {
      dTL().zjA = new com.tencent.mm.plugin.sns.h.g();
    }
    com.tencent.mm.plugin.sns.h.g localg = dTL().zjA;
    AppMethodBeat.o(95812);
    return localg;
  }
  
  public static s dTX()
  {
    AppMethodBeat.i(95813);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjD == null) {
      dTL().zjD = new s(dTL().gBq);
    }
    s locals = dTL().zjD;
    AppMethodBeat.o(95813);
    return locals;
  }
  
  public static com.tencent.mm.plugin.sns.ad.d.k dTY()
  {
    AppMethodBeat.i(95814);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjE == null) {
      dTL().zjE = new com.tencent.mm.plugin.sns.ad.d.k();
    }
    com.tencent.mm.plugin.sns.ad.d.k localk = dTL().zjE;
    AppMethodBeat.o(95814);
    return localk;
  }
  
  public static b dTZ()
  {
    AppMethodBeat.i(95815);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjw == null) {
      dTL().zjw = new b();
    }
    b localb = dTL().zjw;
    AppMethodBeat.o(95815);
    return localb;
  }
  
  public static bb dUa()
  {
    AppMethodBeat.i(95816);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjx == null)
    {
      dTL().zjx = new bb();
      com.tencent.mm.plugin.sns.b.o.zbR = dTL().zjx;
    }
    bb localbb = dTL().zjx;
    AppMethodBeat.o(95816);
    return localbb;
  }
  
  public static f dUb()
  {
    AppMethodBeat.i(95817);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjp == null)
    {
      dTL().zjp = new f();
      com.tencent.mm.plugin.sns.b.o.zbS = dTL().zjp;
    }
    f localf = dTL().zjp;
    AppMethodBeat.o(95817);
    return localf;
  }
  
  public static aw dUc()
  {
    AppMethodBeat.i(95818);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjO == null) {
      dTL().zjO = new aw();
    }
    aw localaw = dTL().zjO;
    AppMethodBeat.o(95818);
    return localaw;
  }
  
  public static ae dUd()
  {
    AppMethodBeat.i(95819);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zju == null)
    {
      localObject = dTL();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.ajD();
      ((ag)localObject).zju = new ae(com.tencent.mm.kernel.g.ajC().cachePath + "snsAsyncQueue.data");
    }
    Object localObject = dTL().zju;
    AppMethodBeat.o(95819);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.sns.storage.q dUe()
  {
    AppMethodBeat.i(95820);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjl == null)
    {
      dTL().zjl = new com.tencent.mm.plugin.sns.storage.q(dTL().gBq);
      com.tencent.mm.plugin.sns.b.o.zbY = dTL().zjl;
    }
    com.tencent.mm.plugin.sns.storage.q localq = dTL().zjl;
    AppMethodBeat.o(95820);
    return localq;
  }
  
  public static com.tencent.mm.plugin.sns.storage.d dUf()
  {
    AppMethodBeat.i(95821);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjn == null) {
      dTL().zjn = new com.tencent.mm.plugin.sns.storage.d(dTL().gBq);
    }
    com.tencent.mm.plugin.sns.storage.d locald = dTL().zjn;
    AppMethodBeat.o(95821);
    return locald;
  }
  
  public static ab dUg()
  {
    AppMethodBeat.i(95822);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjo == null) {
      dTL().zjo = new ab(dTL().gBq);
    }
    ab localab = dTL().zjo;
    AppMethodBeat.o(95822);
    return localab;
  }
  
  public static com.tencent.mm.plugin.sns.storage.f dUh()
  {
    AppMethodBeat.i(95823);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjm == null) {
      dTL().zjm = new com.tencent.mm.plugin.sns.storage.f(dTL().gBq);
    }
    com.tencent.mm.plugin.sns.storage.f localf = dTL().zjm;
    AppMethodBeat.o(95823);
    return localf;
  }
  
  public static com.tencent.mm.plugin.sns.storage.o dUi()
  {
    AppMethodBeat.i(95824);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjq == null)
    {
      dTL().zjq = new com.tencent.mm.plugin.sns.storage.o(dTL().gBq, new ai());
      com.tencent.mm.plugin.sns.b.o.zbT = dTL().zjq;
    }
    com.tencent.mm.plugin.sns.storage.o localo = dTL().zjq;
    AppMethodBeat.o(95824);
    return localo;
  }
  
  public static com.tencent.mm.plugin.sns.storage.k dUj()
  {
    AppMethodBeat.i(95825);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjr == null)
    {
      dTL().zjr = new com.tencent.mm.plugin.sns.storage.k(dTL().gBq);
      com.tencent.mm.plugin.sns.b.o.zbU = dTL().zjr;
    }
    com.tencent.mm.plugin.sns.storage.k localk = dTL().zjr;
    AppMethodBeat.o(95825);
    return localk;
  }
  
  public static w dUk()
  {
    AppMethodBeat.i(95826);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjs == null)
    {
      dTL().zjs = new w(dTL().gBq);
      com.tencent.mm.plugin.sns.b.o.zbV = dTL().zjs;
    }
    w localw = dTL().zjs;
    AppMethodBeat.o(95826);
    return localw;
  }
  
  public static com.tencent.mm.plugin.sns.storage.m dUl()
  {
    AppMethodBeat.i(176273);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjt == null) {
      dTL().zjt = new com.tencent.mm.plugin.sns.storage.m(dTL().gBq);
    }
    com.tencent.mm.plugin.sns.storage.m localm = dTL().zjt;
    AppMethodBeat.o(176273);
    return localm;
  }
  
  public static com.tencent.mm.plugin.sns.ui.ap dUm()
  {
    AppMethodBeat.i(95827);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjy == null) {
      dTL().zjy = new com.tencent.mm.plugin.sns.ui.ap();
    }
    com.tencent.mm.plugin.sns.ui.ap localap = dTL().zjy;
    AppMethodBeat.o(95827);
    return localap;
  }
  
  public static at dUn()
  {
    AppMethodBeat.i(179093);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjB == null) {
      dTL().zjB = new at();
    }
    at localat = dTL().zjB;
    AppMethodBeat.o(179093);
    return localat;
  }
  
  public static aq dUo()
  {
    AppMethodBeat.i(197847);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dTL().zjC == null) {
      dTL().zjC = new aq();
    }
    aq localaq = dTL().zjC;
    AppMethodBeat.o(197847);
    return localaq;
  }
  
  public static int dUp()
  {
    AppMethodBeat.i(95828);
    int i = (dmE().x - com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), zjU)) / 3;
    zji = i;
    if (i > zjV) {}
    for (i = zjV;; i = zji)
    {
      zji = i;
      if (i > 10) {
        break;
      }
      ad.e("MicroMsg.SnsCore", "can not get multiThumbDisplaySize or the multiThumbDisplaySize < 10");
      AppMethodBeat.o(95828);
      return 150;
    }
    i = zji;
    AppMethodBeat.o(95828);
    return i;
  }
  
  public static int dUq()
  {
    AppMethodBeat.i(95829);
    if (zjj <= 0)
    {
      zjj = 200;
      zjj = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), zjj);
    }
    int i = zjj;
    AppMethodBeat.o(95829);
    return i;
  }
  
  public static boolean dUr()
  {
    AppMethodBeat.i(95831);
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.aw.s(aj.getContext(), "sp_sns_dynswitch_stg", 4);
    boolean bool;
    if (localSharedPreferences.contains("st_sw_use_vcodec_img"))
    {
      bool = localSharedPreferences.getBoolean("st_sw_use_vcodec_img", false);
      ad.w("MicroMsg.SnsCore", "isUseVCodecImg: %b (set statically outside)", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(95831);
      return bool;
      bool = localSharedPreferences.getBoolean("sw_use_vcodec_img", false);
      ad.d("MicroMsg.SnsCore", "isUseVCodecImg: %b", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static boolean dUs()
  {
    AppMethodBeat.i(197848);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGv, false);
    AppMethodBeat.o(197848);
    return bool;
  }
  
  public static boolean dUt()
  {
    AppMethodBeat.i(197849);
    if (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(197849);
      return true;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGu, false);
    AppMethodBeat.o(197849);
    return bool;
  }
  
  public static boolean dUu()
  {
    AppMethodBeat.i(95832);
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.aw.s(aj.getContext(), "sp_sns_dynswitch_stg", 4);
    boolean bool;
    if (localSharedPreferences.contains("st_sw_use_wxpc_img"))
    {
      bool = localSharedPreferences.getBoolean("st_sw_use_wxpc_img", false);
      ad.w("MicroMsg.SnsCore", "isUseWxpcImg: %b (set statically outside)", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(95832);
      return bool;
      bool = localSharedPreferences.getBoolean("sw_use_wxpc_img", false);
      ad.d("MicroMsg.SnsCore", "isUseWxpcImg: %b", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static String dUv()
  {
    AppMethodBeat.i(95839);
    if (bt.isNullOrNil(zjK))
    {
      localObject = bi.fly().iterator();
      while (((Iterator)localObject).hasNext())
      {
        bi.a locala = (bi.a)((Iterator)localObject).next();
        if (com.tencent.mm.loader.j.b.arO().equals(locala.IfT)) {
          zjK = locala.IfU;
        }
      }
      ad.i("MicroMsg.SnsCore", "get filesys " + zjK);
    }
    Object localObject = bt.bI(zjK, "");
    AppMethodBeat.o(95839);
    return localObject;
  }
  
  public static Point dmE()
  {
    AppMethodBeat.i(95830);
    if (hqz.x == 0)
    {
      localObject = (WindowManager)aj.getContext().getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
      hqz.x = localDisplayMetrics.widthPixels;
      hqz.y = localDisplayMetrics.heightPixels;
    }
    Object localObject = hqz;
    AppMethodBeat.o(95830);
    return localObject;
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(95792);
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.kernel.g.ajD();
    String str = com.tencent.mm.kernel.g.ajC().gBm;
    AppMethodBeat.o(95792);
    return str;
  }
  
  public static String getAccSnsPath()
  {
    AppMethodBeat.i(95805);
    String str = ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath();
    AppMethodBeat.o(95805);
    return str;
  }
  
  public static String getAccSnsTmpPath()
  {
    AppMethodBeat.i(95806);
    String str = ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsTmpPath();
    AppMethodBeat.o(95806);
    return str;
  }
  
  public static com.tencent.mm.storagebase.h getDataDB()
  {
    AppMethodBeat.i(95795);
    com.tencent.mm.storagebase.h localh = dTL().gBq;
    AppMethodBeat.o(95795);
    return localh;
  }
  
  public static String getSnsAdPath()
  {
    AppMethodBeat.i(95807);
    String str = ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.b.c.class)).getSnsAdPath();
    AppMethodBeat.o(95807);
    return str;
  }
  
  public static void i(Point paramPoint)
  {
    hqz = paramPoint;
  }
  
  public final void a(av paramav)
  {
    AppMethodBeat.i(95837);
    t.a(paramav);
    AppMethodBeat.o(95837);
  }
  
  public final void b(av paramav)
  {
    AppMethodBeat.i(95838);
    t.b(paramav);
    AppMethodBeat.o(95838);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(95834);
    ad.i("MicroMsg.SnsCore", "onAccountPostReset " + Thread.currentThread().getId() + " isAccInit: " + this.zjI);
    if (this.zjI)
    {
      AppMethodBeat.o(95834);
      return;
    }
    this.zjI = true;
    this.rFO = true;
    checkDir();
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("NewYearSNSCtrl2016", this.zjP, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("NewYearSNSTips2016", this.zjQ, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("NewYearSNSAmountLevelCtrl2016", this.zjR, true);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("SnsAd", this.zjS, true);
    com.tencent.mm.plugin.sns.b.o.zbR = dUa();
    com.tencent.mm.plugin.sns.b.o.zbS = dUb();
    com.tencent.mm.plugin.sns.b.o.zbT = dUi();
    com.tencent.mm.plugin.sns.b.o.zbU = dUj();
    com.tencent.mm.plugin.sns.b.o.zbV = dUk();
    com.tencent.mm.plugin.sns.b.o.zbX = dTU();
    com.tencent.mm.plugin.sns.b.o.zbW = this;
    com.tencent.mm.plugin.sns.b.o.zbY = dUe();
    com.tencent.mm.sdk.b.a.IbL.c(this.zky);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkz);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkl);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkj);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkk);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkm);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkn);
    com.tencent.mm.sdk.b.a.IbL.c(this.zko);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkp);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkq);
    com.tencent.mm.sdk.b.a.IbL.c(this.zks);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkt);
    com.tencent.mm.sdk.b.a.IbL.c(this.zku);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkC);
    appForegroundListener.alive();
    this.zjW = new n();
    this.zjX = new com.tencent.mm.plugin.sns.k();
    this.zjY = new com.tencent.mm.plugin.sns.e();
    this.zjZ = new com.tencent.mm.plugin.sns.q();
    this.zka = new com.tencent.mm.plugin.sns.h();
    this.zkb = new com.tencent.mm.plugin.sns.g();
    this.zkc = new com.tencent.mm.plugin.sns.m();
    this.zkd = new com.tencent.mm.plugin.sns.j();
    this.zke = new com.tencent.mm.plugin.sns.b();
    this.zkf = new com.tencent.mm.plugin.sns.c();
    this.zkg = new com.tencent.mm.plugin.sns.f();
    com.tencent.mm.sdk.b.a.IbL.c(this.zkx);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkw);
    com.tencent.mm.sdk.b.a.IbL.c(this.zjZ);
    com.tencent.mm.sdk.b.a.IbL.c(this.zjW);
    com.tencent.mm.sdk.b.a.IbL.c(this.zjX);
    com.tencent.mm.sdk.b.a.IbL.c(this.zjY);
    com.tencent.mm.sdk.b.a.IbL.c(this.zka);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkb);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkc);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkd);
    com.tencent.mm.sdk.b.a.IbL.c(this.zke);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkf);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkg);
    com.tencent.mm.sdk.b.a.IbL.c(this.whK);
    this.zjM = new com.tencent.mm.plugin.sns.d();
    com.tencent.mm.sdk.b.a.IbL.c(this.zjM);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkB);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkh);
    com.tencent.mm.sdk.b.a.IbL.c(this.zki);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkv);
    com.tencent.mm.sdk.b.a.IbL.c(this.zkr);
    Object localObject1 = dTY();
    com.tencent.mm.plugin.sns.ad.d.k.yZr = com.tencent.mm.n.g.acA().getInt("MMUxAdLog2GSendSize", 20480);
    com.tencent.mm.plugin.sns.ad.d.k.yZs = com.tencent.mm.n.g.acA().getInt("MMUxAdLog3GSendSize", 30720);
    com.tencent.mm.plugin.sns.ad.d.k.yZt = com.tencent.mm.n.g.acA().getInt("MMUxAdLogWifiSendSize", 51200);
    com.tencent.mm.plugin.sns.ad.d.k.yZu = com.tencent.mm.n.g.acA().getInt("MMUxAdLogMinRandTime", 60);
    com.tencent.mm.plugin.sns.ad.d.k.yZv = com.tencent.mm.n.g.acA().getInt("MMUxAdLogMaxRandTime", 1800);
    com.tencent.mm.plugin.sns.ad.d.k.yZw = com.tencent.mm.n.g.acA().getInt("MMUxAdLogMaxExceptionTime", 43200);
    ad.i("MicroMsg.SnsLogMgr", "init " + com.tencent.mm.plugin.sns.ad.d.k.yZr + ";" + com.tencent.mm.plugin.sns.ad.d.k.yZs + ";" + com.tencent.mm.plugin.sns.ad.d.k.yZt + ";" + com.tencent.mm.plugin.sns.ad.d.k.yZu + ";" + com.tencent.mm.plugin.sns.ad.d.k.yZv + ";" + com.tencent.mm.plugin.sns.ad.d.k.yZw);
    if (com.tencent.mm.plugin.sns.ad.d.k.yZv - com.tencent.mm.plugin.sns.ad.d.k.yZu < 0) {
      com.tencent.mm.plugin.sns.ad.d.k.yZv = com.tencent.mm.plugin.sns.ad.d.k.yZu;
    }
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(1802, (com.tencent.mm.al.f)localObject1);
    localObject1 = dUa();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(207, (com.tencent.mm.al.f)localObject1);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(209, (com.tencent.mm.al.f)localObject1);
    localObject1 = this.zjF;
    com.tencent.mm.sdk.b.a.IbL.c(((ap)localObject1).zlt);
    com.tencent.mm.sdk.b.a.IbL.c(((ap)localObject1).zlu);
    com.tencent.mm.sdk.b.a.IbL.c(((ap)localObject1).zlv);
    this.zjN = new com.tencent.mm.plugin.sns.g.a();
    ar.init();
    localObject1 = com.tencent.mm.modelsns.f.inr;
    com.tencent.mm.modelsns.f.aLl();
    if (com.tencent.mm.memory.l.ayE())
    {
      localObject1 = com.tencent.mm.memory.c.hwv;
      localObject2 = com.tencent.mm.memory.c.hwv;
      localObject2.getClass();
      ((com.tencent.mm.memory.c)localObject1).a(new e.a((com.tencent.mm.memory.c)localObject2)
      {
        final int zkD;
        
        public final int ayA()
        {
          return -1;
        }
        
        public final long ayz()
        {
          return 10485760L;
        }
      });
    }
    localObject1 = com.tencent.mm.memory.o.hwR;
    Object localObject2 = com.tencent.mm.memory.o.hwR;
    localObject2.getClass();
    ((com.tencent.mm.memory.o)localObject1).a(new e.a((com.tencent.mm.memory.o)localObject2)
    {
      public final int ayA()
      {
        return 3;
      }
      
      public final long ayz()
      {
        return -1L;
      }
    });
    localObject1 = com.tencent.mm.memory.g.hwC;
    localObject2 = com.tencent.mm.memory.g.hwC;
    localObject2.getClass();
    ((com.tencent.mm.memory.g)localObject1).a(new e.a((com.tencent.mm.memory.g)localObject2)
    {
      public final int ayA()
      {
        return 5;
      }
      
      public final long ayz()
      {
        return 0L;
      }
    });
    dUc();
    com.tencent.mm.plugin.sns.f.a.init();
    try
    {
      localObject1 = com.tencent.mm.sdk.platformtools.ax.aQz("TrackDataSource");
      if (!bt.isNullOrNil(((com.tencent.mm.sdk.platformtools.ax)localObject1).getString("path", "")))
      {
        com.tencent.mm.plugin.report.service.g.yhR.dD(150, 74);
        com.tencent.mm.plugin.report.service.g.yhR.f(17832, new Object[] { Integer.valueOf(((com.tencent.mm.sdk.platformtools.ax)localObject1).getInt("type", 0)), ((com.tencent.mm.sdk.platformtools.ax)localObject1).getString("path", ""), Long.valueOf(((com.tencent.mm.sdk.platformtools.ax)localObject1).getLong("ts", 0L)), ((com.tencent.mm.sdk.platformtools.ax)localObject1).getString("media-url", ""), ((com.tencent.mm.sdk.platformtools.ax)localObject1).getString("thumb-url", ""), Long.valueOf(((com.tencent.mm.sdk.platformtools.ax)localObject1).getLong("prepare-ts", 0L)), ((com.tencent.mm.sdk.platformtools.ax)localObject1).getString("prepare-path", "") });
        ((com.tencent.mm.sdk.platformtools.ax)localObject1).putInt("type", 0);
        ((com.tencent.mm.sdk.platformtools.ax)localObject1).putString("path", "");
        ((com.tencent.mm.sdk.platformtools.ax)localObject1).putLong("ts", 0L);
        ((com.tencent.mm.sdk.platformtools.ax)localObject1).putString("media-url", "");
        ((com.tencent.mm.sdk.platformtools.ax)localObject1).putString("thumb-url", "");
        ((com.tencent.mm.sdk.platformtools.ax)localObject1).putLong("prepare-ts", 0L);
        ((com.tencent.mm.sdk.platformtools.ax)localObject1).commit();
      }
      AppMethodBeat.o(95834);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.SnsCore", localThrowable, "videoCrashKvReport", new Object[0]);
      AppMethodBeat.o(95834);
    }
  }
  
  /* Error */
  public final void onAccountRelease()
  {
    // Byte code:
    //   0: ldc_w 1760
    //   3: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 1571	com/tencent/mm/plugin/sns/model/ag:dTY	()Lcom/tencent/mm/plugin/sns/ad/d/k;
    //   9: astore_1
    //   10: invokestatic 666	com/tencent/mm/kernel/g:ajD	()Lcom/tencent/mm/kernel/g;
    //   13: pop
    //   14: invokestatic 1614	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   17: getfield 1620	com/tencent/mm/kernel/b:gAO	Lcom/tencent/mm/al/q;
    //   20: sipush 1802
    //   23: aload_1
    //   24: invokevirtual 1762	com/tencent/mm/al/q:b	(ILcom/tencent/mm/al/f;)V
    //   27: aload_0
    //   28: getfield 329	com/tencent/mm/plugin/sns/model/ag:zjF	Lcom/tencent/mm/plugin/sns/model/ap;
    //   31: astore_1
    //   32: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   35: aload_1
    //   36: getfield 1628	com/tencent/mm/plugin/sns/model/ap:zlt	Lcom/tencent/mm/sdk/b/c;
    //   39: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   42: pop
    //   43: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   46: aload_1
    //   47: getfield 1631	com/tencent/mm/plugin/sns/model/ap:zlu	Lcom/tencent/mm/sdk/b/c;
    //   50: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   53: pop
    //   54: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   57: aload_1
    //   58: getfield 1634	com/tencent/mm/plugin/sns/model/ap:zlv	Lcom/tencent/mm/sdk/b/c;
    //   61: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   64: pop
    //   65: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   68: aload_0
    //   69: getfield 436	com/tencent/mm/plugin/sns/model/ag:zky	Lcom/tencent/mm/sdk/b/c;
    //   72: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   75: pop
    //   76: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   79: aload_0
    //   80: getfield 441	com/tencent/mm/plugin/sns/model/ag:zkz	Lcom/tencent/mm/sdk/b/c;
    //   83: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   86: pop
    //   87: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   90: aload_0
    //   91: getfield 433	com/tencent/mm/plugin/sns/model/ag:zkx	Lcom/tencent/mm/sdk/b/c;
    //   94: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   97: pop
    //   98: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   101: aload_0
    //   102: getfield 428	com/tencent/mm/plugin/sns/model/ag:zkw	Lcom/tencent/mm/sdk/b/c;
    //   105: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   108: pop
    //   109: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   112: aload_0
    //   113: getfield 389	com/tencent/mm/plugin/sns/model/ag:zkl	Lcom/tencent/mm/sdk/b/c;
    //   116: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   119: pop
    //   120: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   123: aload_0
    //   124: getfield 381	com/tencent/mm/plugin/sns/model/ag:zkj	Lcom/tencent/mm/sdk/b/c;
    //   127: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   130: pop
    //   131: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   134: aload_0
    //   135: getfield 386	com/tencent/mm/plugin/sns/model/ag:zkk	Lcom/tencent/mm/sdk/b/c;
    //   138: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   141: pop
    //   142: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   145: aload_0
    //   146: getfield 392	com/tencent/mm/plugin/sns/model/ag:zkm	Lcom/tencent/mm/sdk/b/c;
    //   149: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   152: pop
    //   153: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   156: aload_0
    //   157: getfield 395	com/tencent/mm/plugin/sns/model/ag:zkn	Lcom/tencent/mm/sdk/b/c;
    //   160: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   163: pop
    //   164: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   167: aload_0
    //   168: getfield 398	com/tencent/mm/plugin/sns/model/ag:zko	Lcom/tencent/mm/sdk/b/c;
    //   171: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   174: pop
    //   175: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   178: aload_0
    //   179: getfield 1529	com/tencent/mm/plugin/sns/model/ag:zjZ	Lcom/tencent/mm/plugin/sns/q;
    //   182: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   185: pop
    //   186: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   189: aload_0
    //   190: getfield 1534	com/tencent/mm/plugin/sns/model/ag:zka	Lcom/tencent/mm/plugin/sns/h;
    //   193: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   196: pop
    //   197: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   200: aload_0
    //   201: getfield 406	com/tencent/mm/plugin/sns/model/ag:zkq	Lcom/tencent/mm/sdk/b/c;
    //   204: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   207: pop
    //   208: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   211: aload_0
    //   212: getfield 414	com/tencent/mm/plugin/sns/model/ag:zks	Lcom/tencent/mm/sdk/b/c;
    //   215: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   218: pop
    //   219: getstatic 305	com/tencent/mm/plugin/sns/model/ag:appForegroundListener	Lcom/tencent/mm/app/n$a;
    //   222: invokevirtual 1767	com/tencent/mm/app/n$a:dead	()V
    //   225: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   228: aload_0
    //   229: getfield 1514	com/tencent/mm/plugin/sns/model/ag:zjW	Lcom/tencent/mm/plugin/sns/n;
    //   232: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   235: pop
    //   236: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   239: aload_0
    //   240: getfield 1519	com/tencent/mm/plugin/sns/model/ag:zjX	Lcom/tencent/mm/plugin/sns/k;
    //   243: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   246: pop
    //   247: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   250: aload_0
    //   251: getfield 1524	com/tencent/mm/plugin/sns/model/ag:zjY	Lcom/tencent/mm/plugin/sns/e;
    //   254: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   257: pop
    //   258: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   261: aload_0
    //   262: getfield 1539	com/tencent/mm/plugin/sns/model/ag:zkb	Lcom/tencent/mm/plugin/sns/g;
    //   265: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   268: pop
    //   269: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   272: aload_0
    //   273: getfield 1544	com/tencent/mm/plugin/sns/model/ag:zkc	Lcom/tencent/mm/plugin/sns/m;
    //   276: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   279: pop
    //   280: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   283: aload_0
    //   284: getfield 1549	com/tencent/mm/plugin/sns/model/ag:zkd	Lcom/tencent/mm/plugin/sns/j;
    //   287: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   290: pop
    //   291: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   294: aload_0
    //   295: getfield 1554	com/tencent/mm/plugin/sns/model/ag:zke	Lcom/tencent/mm/plugin/sns/b;
    //   298: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   301: pop
    //   302: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   305: aload_0
    //   306: getfield 1559	com/tencent/mm/plugin/sns/model/ag:zkf	Lcom/tencent/mm/plugin/sns/c;
    //   309: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   312: pop
    //   313: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   316: aload_0
    //   317: getfield 1564	com/tencent/mm/plugin/sns/model/ag:zkg	Lcom/tencent/mm/plugin/sns/f;
    //   320: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   323: pop
    //   324: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   327: aload_0
    //   328: getfield 403	com/tencent/mm/plugin/sns/model/ag:zkp	Lcom/tencent/mm/sdk/b/c;
    //   331: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   334: pop
    //   335: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   338: aload_0
    //   339: getfield 1569	com/tencent/mm/plugin/sns/model/ag:zjM	Lcom/tencent/mm/plugin/sns/d;
    //   342: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   345: pop
    //   346: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   349: aload_0
    //   350: getfield 419	com/tencent/mm/plugin/sns/model/ag:zkt	Lcom/tencent/mm/sdk/b/c;
    //   353: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   356: pop
    //   357: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   360: aload_0
    //   361: getfield 422	com/tencent/mm/plugin/sns/model/ag:zku	Lcom/tencent/mm/sdk/b/c;
    //   364: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   367: pop
    //   368: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   371: aload_0
    //   372: getfield 446	com/tencent/mm/plugin/sns/model/ag:whK	Lcom/tencent/mm/sdk/b/c;
    //   375: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   378: pop
    //   379: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   382: aload_0
    //   383: getfield 451	com/tencent/mm/plugin/sns/model/ag:zkB	Lcom/tencent/mm/sdk/b/c;
    //   386: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   389: pop
    //   390: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   393: aload_0
    //   394: getfield 425	com/tencent/mm/plugin/sns/model/ag:zkv	Lcom/tencent/mm/sdk/b/c;
    //   397: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   400: pop
    //   401: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   404: aload_0
    //   405: getfield 371	com/tencent/mm/plugin/sns/model/ag:zkh	Lcom/tencent/mm/sdk/b/c;
    //   408: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   411: pop
    //   412: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   415: aload_0
    //   416: getfield 376	com/tencent/mm/plugin/sns/model/ag:zki	Lcom/tencent/mm/sdk/b/c;
    //   419: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   422: pop
    //   423: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   426: aload_0
    //   427: getfield 454	com/tencent/mm/plugin/sns/model/ag:zkC	Lcom/tencent/mm/sdk/b/c;
    //   430: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   433: pop
    //   434: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   437: aload_0
    //   438: getfield 409	com/tencent/mm/plugin/sns/model/ag:zkr	Lcom/tencent/mm/sdk/b/c;
    //   441: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   444: pop
    //   445: getstatic 1773	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a$e:zxS	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a;
    //   448: astore_1
    //   449: aload_1
    //   450: getfield 1778	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:zxL	Z
    //   453: ifeq +27 -> 480
    //   456: ldc_w 1780
    //   459: ldc_w 1782
    //   462: invokestatic 1784	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: invokestatic 234	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   468: aload_1
    //   469: getfield 1788	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:zxK	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a$a;
    //   472: invokevirtual 1792	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   475: aload_1
    //   476: iconst_0
    //   477: putfield 1778	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:zxL	Z
    //   480: invokestatic 1798	com/tencent/mm/plugin/downloader/model/f:ccl	()Lcom/tencent/mm/plugin/downloader/model/f;
    //   483: pop
    //   484: aload_1
    //   485: getfield 1802	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:zxP	Lcom/tencent/mm/plugin/downloader/model/m;
    //   488: invokestatic 1807	com/tencent/mm/plugin/downloader/model/c:b	(Lcom/tencent/mm/plugin/downloader/model/m;)V
    //   491: ldc_w 1463
    //   494: invokestatic 635	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   497: checkcast 1463	com/tencent/mm/plugin/messenger/foundation/a/r
    //   500: invokeinterface 1467 1 0
    //   505: ldc_w 1469
    //   508: aload_0
    //   509: getfield 349	com/tencent/mm/plugin/sns/model/ag:zjP	Lcom/tencent/mm/plugin/sns/lucky/a/f;
    //   512: iconst_1
    //   513: invokevirtual 1809	com/tencent/mm/model/cd:b	(Ljava/lang/String;Lcom/tencent/mm/model/cd$a;Z)V
    //   516: ldc_w 1463
    //   519: invokestatic 635	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   522: checkcast 1463	com/tencent/mm/plugin/messenger/foundation/a/r
    //   525: invokeinterface 1467 1 0
    //   530: ldc_w 1476
    //   533: aload_0
    //   534: getfield 354	com/tencent/mm/plugin/sns/model/ag:zjQ	Lcom/tencent/mm/plugin/sns/lucky/a/j;
    //   537: iconst_1
    //   538: invokevirtual 1809	com/tencent/mm/model/cd:b	(Ljava/lang/String;Lcom/tencent/mm/model/cd$a;Z)V
    //   541: ldc_w 1463
    //   544: invokestatic 635	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   547: checkcast 1463	com/tencent/mm/plugin/messenger/foundation/a/r
    //   550: invokeinterface 1467 1 0
    //   555: ldc_w 1478
    //   558: aload_0
    //   559: getfield 359	com/tencent/mm/plugin/sns/model/ag:zjR	Lcom/tencent/mm/plugin/sns/lucky/a/d;
    //   562: iconst_1
    //   563: invokevirtual 1809	com/tencent/mm/model/cd:b	(Ljava/lang/String;Lcom/tencent/mm/model/cd$a;Z)V
    //   566: ldc_w 1463
    //   569: invokestatic 635	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   572: checkcast 1463	com/tencent/mm/plugin/messenger/foundation/a/r
    //   575: invokeinterface 1467 1 0
    //   580: ldc_w 1480
    //   583: aload_0
    //   584: getfield 364	com/tencent/mm/plugin/sns/model/ag:zjS	Lcom/tencent/mm/plugin/sns/lucky/a/l;
    //   587: iconst_1
    //   588: invokevirtual 1809	com/tencent/mm/model/cd:b	(Ljava/lang/String;Lcom/tencent/mm/model/cd$a;Z)V
    //   591: invokestatic 1482	com/tencent/mm/plugin/sns/model/ag:dUa	()Lcom/tencent/mm/plugin/sns/model/bb;
    //   594: astore_1
    //   595: invokestatic 666	com/tencent/mm/kernel/g:ajD	()Lcom/tencent/mm/kernel/g;
    //   598: pop
    //   599: invokestatic 1614	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   602: getfield 1620	com/tencent/mm/kernel/b:gAO	Lcom/tencent/mm/al/q;
    //   605: sipush 207
    //   608: aload_1
    //   609: invokevirtual 1762	com/tencent/mm/al/q:b	(ILcom/tencent/mm/al/f;)V
    //   612: invokestatic 666	com/tencent/mm/kernel/g:ajD	()Lcom/tencent/mm/kernel/g;
    //   615: pop
    //   616: invokestatic 1614	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   619: getfield 1620	com/tencent/mm/kernel/b:gAO	Lcom/tencent/mm/al/q;
    //   622: sipush 209
    //   625: aload_1
    //   626: invokevirtual 1762	com/tencent/mm/al/q:b	(ILcom/tencent/mm/al/f;)V
    //   629: ldc 2
    //   631: invokestatic 700	com/tencent/mm/model/t:ap	(Ljava/lang/Class;)Lcom/tencent/mm/model/ax;
    //   634: checkcast 2	com/tencent/mm/plugin/sns/model/ag
    //   637: astore_1
    //   638: aload_1
    //   639: ifnull +99 -> 738
    //   642: ldc_w 456
    //   645: ldc_w 1811
    //   648: invokestatic 1813	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   651: aload_1
    //   652: getfield 724	com/tencent/mm/plugin/sns/model/ag:gBq	Lcom/tencent/mm/storagebase/h;
    //   655: ifnull +15 -> 670
    //   658: aload_1
    //   659: getfield 724	com/tencent/mm/plugin/sns/model/ag:gBq	Lcom/tencent/mm/storagebase/h;
    //   662: invokevirtual 875	com/tencent/mm/storagebase/h:closeDB	()V
    //   665: aload_1
    //   666: aconst_null
    //   667: putfield 724	com/tencent/mm/plugin/sns/model/ag:gBq	Lcom/tencent/mm/storagebase/h;
    //   670: aload_1
    //   671: getfield 488	com/tencent/mm/plugin/sns/model/ag:zjg	Ljava/util/concurrent/ExecutorService;
    //   674: ifnull +13 -> 687
    //   677: aload_1
    //   678: getfield 488	com/tencent/mm/plugin/sns/model/ag:zjg	Ljava/util/concurrent/ExecutorService;
    //   681: invokeinterface 1817 1 0
    //   686: pop
    //   687: aload_1
    //   688: getfield 507	com/tencent/mm/plugin/sns/model/ag:ylq	Ljava/util/concurrent/ExecutorService;
    //   691: ifnull +13 -> 704
    //   694: aload_1
    //   695: getfield 507	com/tencent/mm/plugin/sns/model/ag:ylq	Ljava/util/concurrent/ExecutorService;
    //   698: invokeinterface 1817 1 0
    //   703: pop
    //   704: aload_1
    //   705: getfield 511	com/tencent/mm/plugin/sns/model/ag:zjf	Ljava/util/concurrent/ExecutorService;
    //   708: ifnull +13 -> 721
    //   711: aload_1
    //   712: getfield 511	com/tencent/mm/plugin/sns/model/ag:zjf	Ljava/util/concurrent/ExecutorService;
    //   715: invokeinterface 1817 1 0
    //   720: pop
    //   721: aload_1
    //   722: getfield 519	com/tencent/mm/plugin/sns/model/ag:zjh	Ljava/util/concurrent/ExecutorService;
    //   725: ifnull +13 -> 738
    //   728: aload_1
    //   729: getfield 519	com/tencent/mm/plugin/sns/model/ag:zjh	Ljava/util/concurrent/ExecutorService;
    //   732: invokeinterface 1817 1 0
    //   737: pop
    //   738: aload_0
    //   739: getfield 1639	com/tencent/mm/plugin/sns/model/ag:zjN	Lcom/tencent/mm/plugin/sns/g/a;
    //   742: astore_1
    //   743: invokestatic 1819	com/tencent/mm/plugin/sns/model/ag:dTZ	()Lcom/tencent/mm/plugin/sns/model/b;
    //   746: aload_1
    //   747: invokevirtual 1822	com/tencent/mm/plugin/sns/model/b:b	(Lcom/tencent/mm/plugin/sns/model/b$b;)V
    //   750: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   753: aload_1
    //   754: getfield 1825	com/tencent/mm/plugin/sns/g/a:zek	Lcom/tencent/mm/sdk/b/c;
    //   757: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   760: pop
    //   761: invokestatic 1828	com/tencent/mm/plugin/sns/model/ar:unInit	()V
    //   764: getstatic 1690	com/tencent/mm/memory/g:hwC	Lcom/tencent/mm/memory/g;
    //   767: invokevirtual 1831	com/tencent/mm/memory/g:ayw	()V
    //   770: getstatic 1664	com/tencent/mm/memory/c:hwv	Lcom/tencent/mm/memory/c;
    //   773: invokevirtual 1832	com/tencent/mm/memory/c:ayw	()V
    //   776: getstatic 1680	com/tencent/mm/memory/o:hwR	Lcom/tencent/mm/memory/o;
    //   779: invokevirtual 1833	com/tencent/mm/memory/o:ayw	()V
    //   782: invokestatic 1696	com/tencent/mm/plugin/sns/model/ag:dUc	()Lcom/tencent/mm/plugin/sns/model/aw;
    //   785: astore_1
    //   786: aload_1
    //   787: aconst_null
    //   788: putfield 1837	com/tencent/mm/plugin/sns/model/aw:zmP	Lcom/tencent/mm/plugin/sns/model/bd;
    //   791: aload_1
    //   792: getfield 1841	com/tencent/mm/plugin/sns/model/aw:zmT	Ljava/util/LinkedList;
    //   795: astore_2
    //   796: aload_2
    //   797: monitorenter
    //   798: aload_1
    //   799: getfield 1841	com/tencent/mm/plugin/sns/model/aw:zmT	Ljava/util/LinkedList;
    //   802: invokevirtual 1846	java/util/LinkedList:clear	()V
    //   805: aload_2
    //   806: monitorexit
    //   807: aload_1
    //   808: getfield 1850	com/tencent/mm/plugin/sns/model/aw:zmR	Ljava/util/Map;
    //   811: invokeinterface 1853 1 0
    //   816: aload_1
    //   817: getfield 1856	com/tencent/mm/plugin/sns/model/aw:zmQ	Ljava/util/LinkedList;
    //   820: invokevirtual 1846	java/util/LinkedList:clear	()V
    //   823: aload_1
    //   824: getfield 1859	com/tencent/mm/plugin/sns/model/aw:zmS	Ljava/util/LinkedList;
    //   827: astore_2
    //   828: aload_2
    //   829: monitorenter
    //   830: aload_1
    //   831: getfield 1859	com/tencent/mm/plugin/sns/model/aw:zmS	Ljava/util/LinkedList;
    //   834: invokevirtual 1846	java/util/LinkedList:clear	()V
    //   837: aload_2
    //   838: monitorexit
    //   839: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   842: aload_1
    //   843: getfield 1862	com/tencent/mm/plugin/sns/model/aw:zmW	Lcom/tencent/mm/sdk/b/c;
    //   846: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   849: pop
    //   850: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   853: aload_1
    //   854: getfield 1863	com/tencent/mm/plugin/sns/model/aw:zlu	Lcom/tencent/mm/sdk/b/c;
    //   857: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   860: pop
    //   861: getstatic 1500	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   864: aload_1
    //   865: getfield 1864	com/tencent/mm/plugin/sns/model/aw:zlv	Lcom/tencent/mm/sdk/b/c;
    //   868: invokevirtual 1764	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   871: pop
    //   872: invokestatic 1867	com/tencent/mm/plugin/sns/f/a:destroy	()V
    //   875: ldc_w 1760
    //   878: invokestatic 308	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   881: return
    //   882: astore_2
    //   883: ldc_w 1780
    //   886: ldc_w 1869
    //   889: iconst_1
    //   890: anewarray 4	java/lang/Object
    //   893: dup
    //   894: iconst_0
    //   895: aload_2
    //   896: invokevirtual 1872	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   899: aastore
    //   900: invokestatic 1874	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   903: goto -423 -> 480
    //   906: astore_1
    //   907: aload_2
    //   908: monitorexit
    //   909: ldc_w 1760
    //   912: invokestatic 308	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   915: aload_1
    //   916: athrow
    //   917: astore_1
    //   918: aload_2
    //   919: monitorexit
    //   920: ldc_w 1760
    //   923: invokestatic 308	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   926: aload_1
    //   927: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	928	0	this	ag
    //   9	856	1	localObject1	Object
    //   906	10	1	localObject2	Object
    //   917	10	1	localObject3	Object
    //   882	37	2	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   456	480	882	java/lang/IllegalArgumentException
    //   798	807	906	finally
    //   907	909	906	finally
    //   830	839	917	finally
    //   918	920	917	finally
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(95836);
    checkDir();
    AppMethodBeat.o(95836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ag
 * JD-Core Version:    0.7.0.1
 */