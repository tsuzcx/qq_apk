package com.tencent.mm.plugin.sns.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.ni;
import com.tencent.mm.g.a.ni.a;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.g.a.ql.a;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.g.a.qm.a;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.g.a.qt.a;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.g.a.tm;
import com.tencent.mm.g.a.wg;
import com.tencent.mm.g.a.wu;
import com.tencent.mm.memory.e.a;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.cc;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.n;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.z;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public final class af
  implements com.tencent.mm.model.aw, com.tencent.mm.plugin.sns.b.k
{
  private static n.a appForegroundListener;
  private static Point gYt;
  private static String xTP;
  protected static HashMap<Integer, h.b> xTQ;
  private static com.tencent.mm.sdk.platformtools.ao xTY;
  private static int xTZ;
  public static boolean xTh;
  private static int xTi;
  private static int xTj;
  private static int xTn;
  private static int xTo;
  private static int xUa;
  private com.tencent.mm.storagebase.h ghG;
  private com.tencent.mm.sdk.platformtools.ao handler;
  private byte[] lock;
  private boolean qVx;
  private com.tencent.mm.sdk.b.c vco;
  private ExecutorService wXF;
  private am.a xTA;
  private b xTB;
  private ba xTC;
  private com.tencent.mm.plugin.sns.ui.am xTD;
  private com.tencent.mm.plugin.sns.h.c xTE;
  private com.tencent.mm.plugin.sns.h.g xTF;
  private as xTG;
  private ap xTH;
  private s xTI;
  private com.tencent.mm.plugin.sns.ad.d.k xTJ;
  private ao xTK;
  private boolean xTL;
  private z xTM;
  private boolean xTN;
  private byte[] xTO;
  private com.tencent.mm.plugin.sns.d xTR;
  private com.tencent.mm.plugin.sns.g.a xTS;
  private av xTT;
  private com.tencent.mm.plugin.sns.lucky.a.f xTU;
  private com.tencent.mm.plugin.sns.lucky.a.j xTV;
  private com.tencent.mm.plugin.sns.lucky.a.d xTW;
  private com.tencent.mm.plugin.sns.lucky.a.l xTX;
  private ExecutorService xTk;
  private ExecutorService xTl;
  private ExecutorService xTm;
  private u xTp;
  private com.tencent.mm.plugin.sns.storage.q xTq;
  private com.tencent.mm.plugin.sns.storage.f xTr;
  private com.tencent.mm.plugin.sns.storage.d xTs;
  private ab xTt;
  private f xTu;
  private com.tencent.mm.plugin.sns.storage.o xTv;
  private com.tencent.mm.plugin.sns.storage.k xTw;
  private w xTx;
  private com.tencent.mm.plugin.sns.storage.m xTy;
  private ad xTz;
  private com.tencent.mm.sdk.b.c xUA;
  private com.tencent.mm.sdk.b.c xUB;
  private com.tencent.mm.sdk.b.c xUC;
  private com.tencent.mm.sdk.b.c xUD;
  private com.tencent.mm.sdk.b.c xUE;
  private boolean xUF;
  private com.tencent.mm.sdk.b.c xUG;
  private com.tencent.mm.sdk.b.c xUH;
  private n xUb;
  private com.tencent.mm.plugin.sns.k xUc;
  private com.tencent.mm.plugin.sns.e xUd;
  private com.tencent.mm.plugin.sns.q xUe;
  private com.tencent.mm.plugin.sns.h xUf;
  private com.tencent.mm.plugin.sns.g xUg;
  private com.tencent.mm.plugin.sns.m xUh;
  private com.tencent.mm.plugin.sns.j xUi;
  private com.tencent.mm.plugin.sns.b xUj;
  private com.tencent.mm.plugin.sns.c xUk;
  private com.tencent.mm.plugin.sns.f xUl;
  private com.tencent.mm.sdk.b.c xUm;
  private com.tencent.mm.sdk.b.c xUn;
  private com.tencent.mm.sdk.b.c xUo;
  private com.tencent.mm.sdk.b.c xUp;
  private com.tencent.mm.sdk.b.c xUq;
  private com.tencent.mm.sdk.b.c xUr;
  private com.tencent.mm.sdk.b.c xUs;
  private com.tencent.mm.sdk.b.c xUt;
  private com.tencent.mm.sdk.b.c xUu;
  private com.tencent.mm.sdk.b.c xUv;
  private com.tencent.mm.sdk.b.c xUw;
  private com.tencent.mm.sdk.b.c xUx;
  private com.tencent.mm.sdk.b.c xUy;
  private com.tencent.mm.sdk.b.c xUz;
  
  static
  {
    AppMethodBeat.i(95843);
    xTh = true;
    xTi = 0;
    xTj = 0;
    xTP = "";
    xTQ = new HashMap();
    xTZ = 103;
    xUa = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 130);
    gYt = new Point();
    xTQ.put(Integer.valueOf("CanvasInfo".hashCode()), new af.1());
    xTQ.put(Integer.valueOf("UxCanvasInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ab.SQL_CREATE;
      }
    });
    xTQ.put(Integer.valueOf("SNSMEDIA_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return u.SQL_CREATE;
      }
    });
    xTQ.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.q.SQL_CREATE;
      }
    });
    xTQ.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.q.SQL_CREATE;
      }
    });
    xTQ.put(Integer.valueOf("ADSNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.f.SQL_CREATE;
      }
    });
    xTQ.put(Integer.valueOf("SNSEXT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.o.SQL_CREATE;
      }
    });
    xTQ.put(Integer.valueOf("SNSCOMMENT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.k.SQL_CREATE;
      }
    });
    xTQ.put(Integer.valueOf("SNSTAGINFO_TABLE".hashCode()), new af.38());
    xTQ.put(Integer.valueOf("SNSKVREPORT_TABLE".hashCode()), new af.2());
    xTQ.put(Integer.valueOf("SNSDRAFT_TABLE".hashCode()), new h.b()
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
        if ((com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT))
        {
          com.tencent.mm.kernel.g.agP();
          if (!com.tencent.mm.kernel.a.afS())
          {
            paramAnonymousString = new qk();
            paramAnonymousString.dtr.state = 0;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString);
            paramAnonymousString = new wg();
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(176255);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(176254);
        if ((com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT))
        {
          com.tencent.mm.kernel.g.agP();
          if (!com.tencent.mm.kernel.a.afS())
          {
            paramAnonymousString = new qk();
            paramAnonymousString.dtr.state = 1;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(176254);
      }
    };
    AppMethodBeat.o(95843);
  }
  
  public af()
  {
    AppMethodBeat.i(95798);
    this.handler = new com.tencent.mm.sdk.platformtools.ao(Looper.getMainLooper());
    this.xTK = new ao();
    this.qVx = false;
    this.xTL = true;
    this.lock = new byte[0];
    this.xTM = new z();
    this.xTN = false;
    this.xTO = new byte[0];
    this.xTU = new com.tencent.mm.plugin.sns.lucky.a.f();
    this.xTV = new com.tencent.mm.plugin.sns.lucky.a.j();
    this.xTW = new com.tencent.mm.plugin.sns.lucky.a.d();
    this.xTX = new com.tencent.mm.plugin.sns.lucky.a.l();
    this.xUm = new af.8(this);
    this.xUn = new af.9(this);
    this.xUo = new af.10(this);
    this.xUp = new af.11(this);
    this.xUq = new af.13(this);
    this.xUr = new com.tencent.mm.sdk.b.c() {};
    this.xUs = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(ni paramAnonymousni)
      {
        AppMethodBeat.i(176261);
        Object localObject2 = paramAnonymousni.dpO.djy;
        com.tencent.mm.plugin.sns.storage.q localq = af.dHR();
        paramAnonymousni = af.agw();
        long l1 = paramAnonymousni.vE(-1L);
        try
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            long l2 = ((Long)((Iterator)localObject2).next()).longValue();
            p localp = localq.Ph((int)l2);
            if (localp != null)
            {
              localp.field_localFlag |= 0x40;
              ac.d("MicroMsg.SnsInfoStorage", "snsInfoId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
              localq.b((int)l2, localp);
            }
          }
          paramAnonymousni.qL(l1);
        }
        finally
        {
          paramAnonymousni.qL(l1);
          AppMethodBeat.o(176261);
        }
        AppMethodBeat.o(176261);
        return false;
      }
    };
    this.xUt = new com.tencent.mm.sdk.b.c() {};
    this.xUu = new af.17(this);
    this.xUv = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(ql paramAnonymousql)
      {
        AppMethodBeat.i(176263);
        try
        {
          SnsAdClick localSnsAdClick = paramAnonymousql.dtt.dtu;
          paramAnonymousql = af.dHU().xB(localSnsAdClick.dwQ);
          if (paramAnonymousql == null)
          {
            AppMethodBeat.o(176263);
            return false;
          }
          p localp = paramAnonymousql.dMb();
          String str;
          Object localObject;
          label76:
          com.tencent.mm.plugin.sns.ad.d.a locala;
          if (localSnsAdClick.dbL == 2)
          {
            paramAnonymousql = localp.dLS();
            if (paramAnonymousql == null) {
              break label450;
            }
            str = paramAnonymousql.yfa;
            localObject = com.tencent.mm.plugin.sns.waid.g.awd(str);
            if (localObject != null) {
              break label275;
            }
            localObject = "";
            locala = new com.tencent.mm.plugin.sns.ad.d.a();
            locala.xIm = com.tencent.mm.plugin.sns.data.j.i(localp);
            locala.xIn = com.tencent.mm.plugin.sns.data.j.j(localp);
            locala.xIo = ((int)localSnsAdClick.hTH);
            if (localSnsAdClick.dbL != 2) {
              break label283;
            }
            ac.i("MicroMsg.SnsCore", "at_friend_detail report ad click, exposureTime=" + localSnsAdClick.hTG + ", clkPos=" + localSnsAdClick.hTz + ", pkg=" + str + ", waid=" + (String)localObject);
            paramAnonymousql = new com.tencent.mm.plugin.sns.ad.d.e(localSnsAdClick.dwQ, paramAnonymousql.dyy, localSnsAdClick.hTz, localSnsAdClick.hTA, localSnsAdClick.hTy, "", localp.dMG(), localp.dLV().yAj, localSnsAdClick.hTF, localp.dME().dLZ(), localp.dME().dMa(), localSnsAdClick.hTG, str, (String)localObject, locala);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousql, 0);
          }
          for (;;)
          {
            AppMethodBeat.o(176263);
            return true;
            paramAnonymousql = localp.dFQ();
            break;
            label275:
            localObject = ((com.tencent.mm.plugin.sns.waid.h)localObject).zmu;
            break label76;
            label283:
            ac.i("MicroMsg.SnsCore", "report ad click, exposureTime=" + localSnsAdClick.hTG + ", clkPos=" + localSnsAdClick.hTz + ", source=" + localSnsAdClick.dbL + ", pkg=" + str + ", waid=" + (String)localObject);
            paramAnonymousql = new com.tencent.mm.plugin.sns.ad.d.e(localSnsAdClick.dwQ, paramAnonymousql.dyy, localSnsAdClick.hTz, localSnsAdClick.hTA, localSnsAdClick.hTy, "", localp.dMG(), localp.dLV().yAj, localSnsAdClick.hTF, localp.dME().dLX(), localp.dME().dLY(), localSnsAdClick.hTG, str, (String)localObject, locala);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousql, 0);
          }
          label450:
          return false;
        }
        catch (Exception paramAnonymousql)
        {
          ac.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousql, "report ad click error", new Object[0]);
          AppMethodBeat.o(176263);
        }
      }
    };
    this.xUw = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(qm paramAnonymousqm)
      {
        AppMethodBeat.i(176264);
        SnsAdClick localSnsAdClick;
        Object localObject1;
        try
        {
          localSnsAdClick = paramAnonymousqm.dtv.dtu;
          localObject1 = af.dHU().xB(localSnsAdClick.dwQ);
          if (localObject1 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.sns.storage.e)localObject1).dMb();
            if (localSnsAdClick.dbL == 2)
            {
              localObject1 = ((p)localObject2).dLS();
              if (localObject1 == null) {
                break label227;
              }
              if (localSnsAdClick.dbL != 2) {
                break label204;
              }
              ac.i("MicroMsg.SnsCore", "at_friend_detail report ad h5 load");
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.h.wUl.f(16972, new Object[] { Long.valueOf(localSnsAdClick.dwQ), Integer.valueOf(localSnsAdClick.hTy), ((com.tencent.mm.plugin.sns.storage.a)localObject1).dtx, Integer.valueOf(((p)localObject2).dMF()), ((p)localObject2).dLV().yAj, paramAnonymousqm.dtv.url, Integer.valueOf(paramAnonymousqm.dtv.dtw), Integer.valueOf(paramAnonymousqm.dtv.errorCode), Long.valueOf(paramAnonymousqm.dtv.timestamp) });
              AppMethodBeat.o(176264);
              return true;
              localObject1 = ((p)localObject2).dFQ();
              break;
              label204:
              ac.i("MicroMsg.SnsCore", "report ad h5 load");
            }
          }
          label227:
          localObject1 = af.dHR().xK(localSnsAdClick.dwQ);
        }
        catch (Exception paramAnonymousqm)
        {
          ac.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousqm, "report load ad h5 error", new Object[0]);
          AppMethodBeat.o(176264);
          return false;
        }
        Object localObject2 = new StringBuilder("report ad h5, AdSnsInfo==null, uxInfo=").append(paramAnonymousqm.dtv.dtx).append(", snsInfo==null?");
        boolean bool;
        String str;
        int i;
        if (localObject1 == null)
        {
          bool = true;
          ac.i("MicroMsg.SnsCore", bool);
          if (localObject1 == null) {
            break label450;
          }
          str = paramAnonymousqm.dtv.dtx;
          i = ((p)localObject1).dMF();
          localObject1 = ((p)localObject1).dLV();
          if (localObject1 != null) {
            break label442;
          }
          localObject1 = "";
          break label569;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(16972, new Object[] { Long.valueOf(localSnsAdClick.dwQ), Integer.valueOf(localSnsAdClick.hTy), str, Integer.valueOf(i), localObject2, paramAnonymousqm.dtv.url, Integer.valueOf(paramAnonymousqm.dtv.dtw), Integer.valueOf(paramAnonymousqm.dtv.errorCode), Long.valueOf(paramAnonymousqm.dtv.timestamp) });
          AppMethodBeat.o(176264);
          return true;
          bool = false;
          break;
          label442:
          localObject1 = ((TimeLineObject)localObject1).yAj;
          break label569;
          label450:
          localObject1 = paramAnonymousqm.dtv.dtx;
          com.tencent.mm.plugin.report.service.h.wUl.f(16972, new Object[] { Long.valueOf(localSnsAdClick.dwQ), Integer.valueOf(localSnsAdClick.hTy), localObject1, Integer.valueOf(0), "", paramAnonymousqm.dtv.url, Integer.valueOf(paramAnonymousqm.dtv.dtw), Integer.valueOf(paramAnonymousqm.dtv.errorCode), Long.valueOf(paramAnonymousqm.dtv.timestamp) });
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
    this.xUx = new af.20(this);
    this.xUy = new af.21(this);
    this.xUz = new com.tencent.mm.sdk.b.c() {};
    this.xUA = new com.tencent.mm.sdk.b.c() {};
    this.xUB = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(qt paramAnonymousqt)
      {
        AppMethodBeat.i(176265);
        SnsAdClick localSnsAdClick = paramAnonymousqt.dtM.dtu;
        try
        {
          if (paramAnonymousqt.dtM.dtN != 1) {
            break label259;
          }
          if (localSnsAdClick.hTB != 1) {
            break label365;
          }
          locale = af.dHU().xB(localSnsAdClick.dwQ);
          if ((locale == null) || (!locale.dJU())) {
            break label266;
          }
          localObject2 = af.dHL();
          j = 14647;
          localObject1 = new Object[7];
          localObject1[0] = Long.valueOf(localSnsAdClick.dwQ);
          localObject1[1] = locale.dFQ().dtx;
          localObject1[2] = Integer.valueOf(localSnsAdClick.hTy);
          localObject1[3] = Long.valueOf(localSnsAdClick.startTime);
          localObject1[4] = Long.valueOf(System.currentTimeMillis());
          i = locale.dLT();
          paramAnonymousqt = (qt)localObject1;
        }
        catch (Exception paramAnonymousqt)
        {
          for (;;)
          {
            com.tencent.mm.plugin.sns.storage.e locale;
            int j;
            com.tencent.mm.plugin.sns.ad.d.k localk;
            ac.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousqt, "report ad click error", new Object[0]);
            continue;
            Object localObject1 = paramAnonymousqt.dtM.dtx;
            paramAnonymousqt = (qt)localObject1;
            if (localObject1 == null) {
              paramAnonymousqt = "";
            }
            ac.i("MicroMsg.SnsCore", "ReportSnsEvent, AdSnsInfo==null, uxInfo=".concat(String.valueOf(paramAnonymousqt)));
            boolean bool = false;
            continue;
            af.dHL().f(12013, new Object[] { localObject1 });
            continue;
            int i = -1;
            localObject1 = paramAnonymousqt;
            Object localObject2 = paramAnonymousqt;
            paramAnonymousqt = (qt)localObject1;
            localObject1 = localObject2;
            localObject2 = localk;
          }
        }
        paramAnonymousqt[5] = Integer.valueOf(i);
        localObject1[6] = "";
        ((com.tencent.mm.plugin.sns.ad.d.k)localObject2).f(j, (Object[])localObject1);
        paramAnonymousqt = com.tencent.mm.modelsns.d.pt(750);
        paramAnonymousqt.Dn(localSnsAdClick.dwQ).Dn(locale.dFQ().dtx).pv(localSnsAdClick.hTy).Dn(localSnsAdClick.startTime).Dn(System.currentTimeMillis());
        paramAnonymousqt.aHZ();
        for (;;)
        {
          label259:
          AppMethodBeat.o(176265);
          return false;
          label266:
          localk = af.dHL();
          j = 13155;
          paramAnonymousqt = new Object[7];
          paramAnonymousqt[0] = Long.valueOf(localSnsAdClick.dwQ);
          paramAnonymousqt[1] = locale.dFQ().dtx;
          paramAnonymousqt[2] = Integer.valueOf(localSnsAdClick.hTy);
          paramAnonymousqt[3] = Long.valueOf(localSnsAdClick.startTime);
          paramAnonymousqt[4] = Long.valueOf(System.currentTimeMillis());
          if (locale == null) {
            break label753;
          }
          i = locale.dLT();
          localObject1 = paramAnonymousqt;
          localObject2 = paramAnonymousqt;
          paramAnonymousqt = (qt)localObject1;
          localObject1 = localObject2;
          localObject2 = localk;
          break;
          label365:
          localObject1 = af.dHU().xB(localSnsAdClick.dwQ);
          if (localObject1 == null) {
            break label693;
          }
          paramAnonymousqt = ((com.tencent.mm.plugin.sns.storage.e)localObject1).dFQ().dtx;
          bool = ((com.tencent.mm.plugin.sns.storage.e)localObject1).dJU();
          localObject1 = com.tencent.mm.plugin.sns.ad.d.h.a(localSnsAdClick.dwQ, new Object[] { localSnsAdClick, paramAnonymousqt, Integer.valueOf(localSnsAdClick.hTy), Long.valueOf(localSnsAdClick.startTime), Long.valueOf(System.currentTimeMillis()) });
          localObject1 = (String)localObject1 + String.format(",%s", new Object[] { localSnsAdClick.hTC });
          localObject1 = (String)localObject1 + String.format(",%s", new Object[] { System.currentTimeMillis() - localSnsAdClick.startTime - localSnsAdClick.hTE });
          if (!bool) {
            break label732;
          }
          af.dHL().f(14643, new Object[] { localObject1 });
          localObject1 = com.tencent.mm.modelsns.d.pt(733);
          ((com.tencent.mm.modelsns.d)localObject1).Dn(localSnsAdClick.dwQ).Dn(paramAnonymousqt).pv(localSnsAdClick.hTy).Dn(localSnsAdClick.startTime).Dn(System.currentTimeMillis());
          ((com.tencent.mm.modelsns.d)localObject1).aHZ();
        }
      }
    };
    this.xUC = new af.26(this);
    this.xUD = new af.27(this);
    this.xUE = new af.28(this);
    this.xUF = false;
    this.vco = new com.tencent.mm.sdk.b.c() {};
    this.xUG = new af.31(this);
    this.xUH = new com.tencent.mm.sdk.b.c() {};
    ac.i("MicroMsg.SnsCore", "snscore create! " + Thread.currentThread().getId());
    if (this.xTl == null) {
      this.xTl = com.tencent.e.h.JZN.a("SnsCore_CDNDownload_handler", 6, 6, new LinkedBlockingQueue());
    }
    if (this.wXF == null) {
      this.wXF = com.tencent.e.h.JZN.a("SnsCore_thumbDecode_handler", 6, 6, new LinkedBlockingQueue());
    }
    if (this.xTk == null) {
      this.xTk = com.tencent.e.h.JZN.aTA("SnsCore#File");
    }
    if (this.xTm == null) {
      this.xTm = com.tencent.e.h.JZN.aTA("SnsCore#Task");
    }
    if ((((ActivityManager)ai.getContext().getSystemService("activity")).getLargeMemoryClass() > 256) && (Build.VERSION.SDK_INT != 24)) {
      int i = Build.VERSION.SDK_INT;
    }
    AppMethodBeat.o(95798);
  }
  
  public static com.tencent.mm.storagebase.h agw()
  {
    AppMethodBeat.i(95795);
    com.tencent.mm.storagebase.h localh = dHz().ghG;
    AppMethodBeat.o(95795);
    return localh;
  }
  
  public static com.tencent.mm.sdk.platformtools.ao cMM()
  {
    AppMethodBeat.i(95804);
    com.tencent.mm.sdk.platformtools.ao localao = dHz().handler;
    AppMethodBeat.o(95804);
    return localao;
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(95835);
    com.tencent.mm.vfs.i.aSh(((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath());
    com.tencent.mm.vfs.i.aSh(((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsTmpPath());
    com.tencent.mm.vfs.i.aSv(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.dLL());
    AppMethodBeat.o(95835);
  }
  
  public static boolean dHA()
  {
    AppMethodBeat.i(95797);
    dHz();
    if (!com.tencent.mm.kernel.g.agP().afY())
    {
      AppMethodBeat.o(95797);
      return true;
    }
    AppMethodBeat.o(95797);
    return false;
  }
  
  public static ExecutorService dHB()
  {
    AppMethodBeat.i(179089);
    ExecutorService localExecutorService = dHz().xTl;
    AppMethodBeat.o(179089);
    return localExecutorService;
  }
  
  public static ExecutorService dHC()
  {
    AppMethodBeat.i(179090);
    ExecutorService localExecutorService = dHz().wXF;
    AppMethodBeat.o(179090);
    return localExecutorService;
  }
  
  protected static ExecutorService dHD()
  {
    AppMethodBeat.i(179091);
    ExecutorService localExecutorService = dHz().xTk;
    AppMethodBeat.o(179091);
    return localExecutorService;
  }
  
  public static ExecutorService dHE()
  {
    AppMethodBeat.i(179092);
    ExecutorService localExecutorService = dHz().xTm;
    AppMethodBeat.o(179092);
    return localExecutorService;
  }
  
  public static bj dHF()
  {
    AppMethodBeat.i(95808);
    com.tencent.mm.kernel.g.agS();
    bj localbj = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB();
    AppMethodBeat.o(95808);
    return localbj;
  }
  
  public static u dHG()
  {
    AppMethodBeat.i(95809);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTp == null) {
      dHz().xTp = new u(dHz().ghG);
    }
    u localu = dHz().xTp;
    AppMethodBeat.o(95809);
    return localu;
  }
  
  public static am.a dHH()
  {
    AppMethodBeat.i(95810);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTA == null)
    {
      dHz().xTA = new am.a();
      com.tencent.mm.plugin.sns.b.o.xMf = dHz().xTA;
    }
    am.a locala = dHz().xTA;
    AppMethodBeat.o(95810);
    return locala;
  }
  
  public static com.tencent.mm.plugin.sns.h.c dHI()
  {
    AppMethodBeat.i(95811);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTE == null) {
      dHz().xTE = new com.tencent.mm.plugin.sns.h.c();
    }
    com.tencent.mm.plugin.sns.h.c localc = dHz().xTE;
    AppMethodBeat.o(95811);
    return localc;
  }
  
  public static com.tencent.mm.plugin.sns.h.g dHJ()
  {
    AppMethodBeat.i(95812);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTF == null) {
      dHz().xTF = new com.tencent.mm.plugin.sns.h.g();
    }
    com.tencent.mm.plugin.sns.h.g localg = dHz().xTF;
    AppMethodBeat.o(95812);
    return localg;
  }
  
  public static s dHK()
  {
    AppMethodBeat.i(95813);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTI == null) {
      dHz().xTI = new s(dHz().ghG);
    }
    s locals = dHz().xTI;
    AppMethodBeat.o(95813);
    return locals;
  }
  
  public static com.tencent.mm.plugin.sns.ad.d.k dHL()
  {
    AppMethodBeat.i(95814);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTJ == null) {
      dHz().xTJ = new com.tencent.mm.plugin.sns.ad.d.k();
    }
    com.tencent.mm.plugin.sns.ad.d.k localk = dHz().xTJ;
    AppMethodBeat.o(95814);
    return localk;
  }
  
  public static b dHM()
  {
    AppMethodBeat.i(95815);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTB == null) {
      dHz().xTB = new b();
    }
    b localb = dHz().xTB;
    AppMethodBeat.o(95815);
    return localb;
  }
  
  public static ba dHN()
  {
    AppMethodBeat.i(95816);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTC == null)
    {
      dHz().xTC = new ba();
      com.tencent.mm.plugin.sns.b.o.xLZ = dHz().xTC;
    }
    ba localba = dHz().xTC;
    AppMethodBeat.o(95816);
    return localba;
  }
  
  public static f dHO()
  {
    AppMethodBeat.i(95817);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTu == null)
    {
      dHz().xTu = new f();
      com.tencent.mm.plugin.sns.b.o.xMa = dHz().xTu;
    }
    f localf = dHz().xTu;
    AppMethodBeat.o(95817);
    return localf;
  }
  
  public static av dHP()
  {
    AppMethodBeat.i(95818);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTT == null) {
      dHz().xTT = new av();
    }
    av localav = dHz().xTT;
    AppMethodBeat.o(95818);
    return localav;
  }
  
  public static ad dHQ()
  {
    AppMethodBeat.i(95819);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTz == null)
    {
      localObject = dHz();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agS();
      ((af)localObject).xTz = new ad(com.tencent.mm.kernel.g.agR().cachePath + "snsAsyncQueue.data");
    }
    Object localObject = dHz().xTz;
    AppMethodBeat.o(95819);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.sns.storage.q dHR()
  {
    AppMethodBeat.i(95820);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTq == null)
    {
      dHz().xTq = new com.tencent.mm.plugin.sns.storage.q(dHz().ghG);
      com.tencent.mm.plugin.sns.b.o.xMg = dHz().xTq;
    }
    com.tencent.mm.plugin.sns.storage.q localq = dHz().xTq;
    AppMethodBeat.o(95820);
    return localq;
  }
  
  public static com.tencent.mm.plugin.sns.storage.d dHS()
  {
    AppMethodBeat.i(95821);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTs == null) {
      dHz().xTs = new com.tencent.mm.plugin.sns.storage.d(dHz().ghG);
    }
    com.tencent.mm.plugin.sns.storage.d locald = dHz().xTs;
    AppMethodBeat.o(95821);
    return locald;
  }
  
  public static ab dHT()
  {
    AppMethodBeat.i(95822);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTt == null) {
      dHz().xTt = new ab(dHz().ghG);
    }
    ab localab = dHz().xTt;
    AppMethodBeat.o(95822);
    return localab;
  }
  
  public static com.tencent.mm.plugin.sns.storage.f dHU()
  {
    AppMethodBeat.i(95823);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTr == null) {
      dHz().xTr = new com.tencent.mm.plugin.sns.storage.f(dHz().ghG);
    }
    com.tencent.mm.plugin.sns.storage.f localf = dHz().xTr;
    AppMethodBeat.o(95823);
    return localf;
  }
  
  public static com.tencent.mm.plugin.sns.storage.o dHV()
  {
    AppMethodBeat.i(95824);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTv == null)
    {
      dHz().xTv = new com.tencent.mm.plugin.sns.storage.o(dHz().ghG, new ah());
      com.tencent.mm.plugin.sns.b.o.xMb = dHz().xTv;
    }
    com.tencent.mm.plugin.sns.storage.o localo = dHz().xTv;
    AppMethodBeat.o(95824);
    return localo;
  }
  
  public static com.tencent.mm.plugin.sns.storage.k dHW()
  {
    AppMethodBeat.i(95825);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTw == null)
    {
      dHz().xTw = new com.tencent.mm.plugin.sns.storage.k(dHz().ghG);
      com.tencent.mm.plugin.sns.b.o.xMc = dHz().xTw;
    }
    com.tencent.mm.plugin.sns.storage.k localk = dHz().xTw;
    AppMethodBeat.o(95825);
    return localk;
  }
  
  public static w dHX()
  {
    AppMethodBeat.i(95826);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTx == null)
    {
      dHz().xTx = new w(dHz().ghG);
      com.tencent.mm.plugin.sns.b.o.xMd = dHz().xTx;
    }
    w localw = dHz().xTx;
    AppMethodBeat.o(95826);
    return localw;
  }
  
  public static com.tencent.mm.plugin.sns.storage.m dHY()
  {
    AppMethodBeat.i(176273);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTy == null) {
      dHz().xTy = new com.tencent.mm.plugin.sns.storage.m(dHz().ghG);
    }
    com.tencent.mm.plugin.sns.storage.m localm = dHz().xTy;
    AppMethodBeat.o(176273);
    return localm;
  }
  
  public static com.tencent.mm.plugin.sns.ui.am dHZ()
  {
    AppMethodBeat.i(95827);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTD == null) {
      dHz().xTD = new com.tencent.mm.plugin.sns.ui.am();
    }
    com.tencent.mm.plugin.sns.ui.am localam = dHz().xTD;
    AppMethodBeat.o(95827);
    return localam;
  }
  
  public static String dHx()
  {
    AppMethodBeat.i(95793);
    com.tencent.mm.kernel.g.agS();
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(2, null);
    AppMethodBeat.o(95793);
    return str;
  }
  
  public static int dHy()
  {
    AppMethodBeat.i(95794);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP();
    int i = com.tencent.mm.kernel.a.getUin();
    AppMethodBeat.o(95794);
    return i;
  }
  
  private static af dHz()
  {
    AppMethodBeat.i(95796);
    Object localObject1 = (af)com.tencent.mm.model.t.ap(af.class);
    if (!((af)localObject1).xTN) {}
    com.tencent.mm.model.b localb;
    for (;;)
    {
      Object localObject5;
      Object localObject4;
      synchronized (((af)localObject1).xTO)
      {
        if (!((af)localObject1).xTN)
        {
          ac.i("MicroMsg.SnsCore", "onAccInit because bug!");
          ((af)localObject1).onAccountPostReset(true);
        }
        if (!((af)localObject1).qVx) {
          break label1583;
        }
        synchronized (((af)localObject1).lock)
        {
          ac.i("MicroMsg.SnsCore", "getCore need reset DB now " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + localObject1.hashCode());
          if (!((af)localObject1).qVx) {
            break label1580;
          }
          ((af)localObject1).xTL = false;
          localObject5 = ((af)localObject1).xTM;
          localObject4 = xTQ;
          if (((z)localObject5).ywj)
          {
            ac.i("MicroMsg.TrimSnsDb", "pass hasTrim");
            if (((af)localObject1).ghG != null) {
              break;
            }
            ((af)localObject1).ghG = new com.tencent.mm.storagebase.h();
            com.tencent.mm.kernel.g.agS();
            localObject4 = com.tencent.mm.kernel.g.agR().cachePath;
            localObject4 = (String)localObject4 + "SnsMicroMsg.db";
            if (((af)localObject1).ghG.b((String)localObject4, xTQ, true)) {
              break;
            }
            localObject1 = new SQLiteException("sns db init failed");
            AppMethodBeat.o(95796);
            throw ((Throwable)localObject1);
          }
        }
      }
      com.tencent.mm.kernel.g.agS();
      if (com.tencent.mm.kernel.g.agP().afY())
      {
        int i = bs.getInt(com.tencent.mm.m.g.ZY().getValue("AndroidCleanSnsDb"), 0);
        ac.i("MicroMsg.TrimSnsDb", "pass dynamic? ".concat(String.valueOf(i)));
        if (i <= 0)
        {
          com.tencent.mm.kernel.g.agS();
          String str = com.tencent.mm.kernel.g.agR().cachePath;
          if (com.tencent.mm.vfs.i.eA(str + "SnsMicroMsg2.db.ini"))
          {
            z.avt(str);
            com.tencent.mm.vfs.i.deleteFile(str + "SnsMicroMsg2.db.ini");
          }
          Object localObject6 = ai.getContext().getSharedPreferences(ai.eUX(), 0);
          if (bs.pN(((SharedPreferences)localObject6).getLong("check_trim_time", 0L)) < 604800L)
          {
            ac.i("MicroMsg.TrimSnsDb", "trim sns pass because time short");
          }
          else
          {
            ((SharedPreferences)localObject6).edit().putLong("check_trim_time", bs.aNx()).commit();
            ((z)localObject5).ywj = true;
            long l1 = System.currentTimeMillis();
            i = com.tencent.mm.q.a.aaY();
            if ((i == 1) || (i == 2))
            {
              ac.i("MicroMsg.TrimSnsDb", "trim sns error space dangerous");
            }
            else if (com.tencent.mm.vfs.i.eA(str + "sns_mark.ini"))
            {
              if (bs.Ap(com.tencent.mm.vfs.i.aSq(str + "sns_mark.ini")) < 2592000000L)
              {
                ac.i("MicroMsg.TrimSnsDb", "mark file exist and return");
                z.avt(str);
              }
              else
              {
                com.tencent.mm.vfs.i.deleteFile(str + "sns_mark.ini");
              }
            }
            else
            {
              long l2 = com.tencent.mm.vfs.i.aSp(str + "SnsMicroMsg.db");
              ac.i("MicroMsg.TrimSnsDb", "trim sns ".concat(String.valueOf(l2)));
              if (l2 < 52428800L)
              {
                ac.i("MicroMsg.TrimSnsDb", "trim sns free pass: " + (System.currentTimeMillis() - l1));
              }
              else
              {
                com.tencent.mm.vfs.i.aSt(str + "sns_mark.ini");
                localObject6 = str + "SnsMicroMsg2.db";
                localObject5 = new com.tencent.mm.storagebase.h();
                if (!((com.tencent.mm.storagebase.h)localObject5).b((String)localObject6, null, false))
                {
                  localb = new com.tencent.mm.model.b((byte)0);
                  AppMethodBeat.o(95796);
                  throw localb;
                }
                localObject6 = new com.tencent.mm.storagebase.h();
                if (!((com.tencent.mm.storagebase.h)localObject6).b(str + "SnsMicroMsg.db", (HashMap)localObject4, true))
                {
                  localb = new com.tencent.mm.model.b((byte)0);
                  AppMethodBeat.o(95796);
                  throw localb;
                }
                l2 = System.currentTimeMillis();
                if (!z.a((com.tencent.mm.storagebase.h)localObject6, (com.tencent.mm.storagebase.h)localObject5)) {}
                for (i = -1;; i = 1)
                {
                  long l3 = System.currentTimeMillis() - l2;
                  ac.i("MicroMsg.TrimSnsDb", "copysns insert all %d passed ret:".concat(String.valueOf(i)), new Object[] { Long.valueOf(l3) });
                  ((com.tencent.mm.storagebase.h)localObject6).closeDB();
                  ((com.tencent.mm.storagebase.h)localObject5).closeDB();
                  if (i >= 0)
                  {
                    com.tencent.mm.kernel.g.agS();
                    localObject4 = com.tencent.mm.kernel.g.agR().cachePath;
                    com.tencent.mm.vfs.i.deleteFile((String)localObject4 + "SnsMicroMsg.db");
                    ac.i("MicroMsg.TrimSnsDb", "rename file ".concat(String.valueOf(com.tencent.mm.vfs.i.aT((String)localObject4, "SnsMicroMsg2.db", "SnsMicroMsg.db"))));
                    com.tencent.mm.vfs.i.deleteFile((String)localObject4 + "SnsMicroMsg.db-shm");
                    com.tencent.mm.vfs.i.deleteFile((String)localObject4 + "SnsMicroMsg.db-wal");
                    com.tencent.mm.vfs.i.deleteFile((String)localObject4 + "SnsMicroMsg.db.ini");
                    com.tencent.mm.vfs.i.lZ("SnsMicroMsg2.db.ini", "SnsMicroMsg.db.ini");
                    com.tencent.mm.vfs.i.deleteFile((String)localObject4 + "SnsMicroMsg2.db.ini");
                    com.tencent.mm.vfs.i.deleteFile((String)localObject4 + "SnsMicroMsg2.db");
                    com.tencent.mm.vfs.i.deleteFile((String)localObject4 + "sns_mark.ini");
                  }
                  l2 = System.currentTimeMillis() - l2;
                  ac.i("MicroMsg.TrimSnsDb", "copysns data ret=%d all: %d copytime %d ", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l2 - l3) });
                  ac.i("MicroMsg.TrimSnsDb", "trim sns done pass: " + (System.currentTimeMillis() - l1));
                  break;
                  l3 = System.currentTimeMillis();
                  z.a((com.tencent.mm.storagebase.h)localObject6, (com.tencent.mm.storagebase.h)localObject5, "snsExtInfo3");
                  boolean bool = ((com.tencent.mm.storagebase.h)localObject5).execSQL("", "insert into " + "snsExtInfo3" + " select * from old." + "snsExtInfo3");
                  ac.i("MicroMsg.TrimSnsDb", "copysns ret_ext:" + bool + " passed " + (System.currentTimeMillis() - l3));
                  z.a((com.tencent.mm.storagebase.h)localObject6, (com.tencent.mm.storagebase.h)localObject5, "SnsComment");
                  bool = ((com.tencent.mm.storagebase.h)localObject5).execSQL("", "insert into " + "SnsComment" + " select * from old." + "SnsComment");
                  ac.i("MicroMsg.TrimSnsDb", "copysns ret_msg:" + bool + " passed " + (System.currentTimeMillis() - l3));
                  z.a((com.tencent.mm.storagebase.h)localObject6, (com.tencent.mm.storagebase.h)localObject5, "SnsInfo");
                  bool = ((com.tencent.mm.storagebase.h)localObject5).execSQL("", "insert into " + "SnsInfo" + " select * from old." + "SnsInfo" + " where  (sourceType & 2 != 0 ) " + com.tencent.mm.plugin.sns.storage.q.yvI + " limit 200");
                  ac.i("MicroMsg.TrimSnsDb", "copysns ret_sns:" + bool + " passed " + (System.currentTimeMillis() - l3));
                  bool = ((com.tencent.mm.storagebase.h)localObject5).execSQL("", "update snsExtinfo3 set md5 = '', faults = '';");
                  ac.i("MicroMsg.TrimSnsDb", "update ext info  passed  %s  updateRet %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l3), Boolean.valueOf(bool) });
                  ((com.tencent.mm.storagebase.h)localObject5).execSQL("", "DETACH DATABASE old");
                }
              }
            }
          }
        }
      }
    }
    localb.qVx = false;
    ac.i("MicroMsg.SnsCore", "resetdb done");
    label1580:
    label1583:
    AppMethodBeat.o(95796);
    return localb;
  }
  
  public static as dIa()
  {
    AppMethodBeat.i(179093);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTG == null) {
      dHz().xTG = new as();
    }
    as localas = dHz().xTG;
    AppMethodBeat.o(179093);
    return localas;
  }
  
  public static ap dIb()
  {
    AppMethodBeat.i(200114);
    com.tencent.mm.kernel.g.agP().afT();
    if (dHz().xTH == null) {
      dHz().xTH = new ap();
    }
    ap localap = dHz().xTH;
    AppMethodBeat.o(200114);
    return localap;
  }
  
  public static int dIc()
  {
    AppMethodBeat.i(95828);
    int i = (ddi().x - com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), xTZ)) / 3;
    xTn = i;
    if (i > xUa) {}
    for (i = xUa;; i = xTn)
    {
      xTn = i;
      if (i > 10) {
        break;
      }
      ac.e("MicroMsg.SnsCore", "can not get multiThumbDisplaySize or the multiThumbDisplaySize < 10");
      AppMethodBeat.o(95828);
      return 150;
    }
    i = xTn;
    AppMethodBeat.o(95828);
    return i;
  }
  
  public static int dId()
  {
    AppMethodBeat.i(95829);
    if (xTo <= 0)
    {
      xTo = 200;
      xTo = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), xTo);
    }
    int i = xTo;
    AppMethodBeat.o(95829);
    return i;
  }
  
  public static boolean dIe()
  {
    AppMethodBeat.i(95831);
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.av.s(ai.getContext(), "sp_sns_dynswitch_stg", 4);
    boolean bool;
    if (localSharedPreferences.contains("st_sw_use_vcodec_img"))
    {
      bool = localSharedPreferences.getBoolean("st_sw_use_vcodec_img", false);
      ac.w("MicroMsg.SnsCore", "isUseVCodecImg: %b (set statically outside)", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(95831);
      return bool;
      bool = localSharedPreferences.getBoolean("sw_use_vcodec_img", false);
      ac.d("MicroMsg.SnsCore", "isUseVCodecImg: %b", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static boolean dIf()
  {
    AppMethodBeat.i(200115);
    boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qaW, false);
    AppMethodBeat.o(200115);
    return bool;
  }
  
  public static boolean dIg()
  {
    AppMethodBeat.i(200116);
    boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qaV, false);
    AppMethodBeat.o(200116);
    return bool;
  }
  
  public static boolean dIh()
  {
    AppMethodBeat.i(95832);
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.av.s(ai.getContext(), "sp_sns_dynswitch_stg", 4);
    boolean bool;
    if (localSharedPreferences.contains("st_sw_use_wxpc_img"))
    {
      bool = localSharedPreferences.getBoolean("st_sw_use_wxpc_img", false);
      ac.w("MicroMsg.SnsCore", "isUseWxpcImg: %b (set statically outside)", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(95832);
      return bool;
      bool = localSharedPreferences.getBoolean("sw_use_wxpc_img", false);
      ac.d("MicroMsg.SnsCore", "isUseWxpcImg: %b", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static String dIi()
  {
    AppMethodBeat.i(95839);
    if (bs.isNullOrNil(xTP))
    {
      localObject = bh.eVO().iterator();
      while (((Iterator)localObject).hasNext())
      {
        bh.a locala = (bh.a)((Iterator)localObject).next();
        if (com.tencent.mm.loader.j.b.apb().equals(locala.GtY)) {
          xTP = locala.GtZ;
        }
      }
      ac.i("MicroMsg.SnsCore", "get filesys " + xTP);
    }
    Object localObject = bs.bG(xTP, "");
    AppMethodBeat.o(95839);
    return localObject;
  }
  
  public static Point ddi()
  {
    AppMethodBeat.i(95830);
    if (gYt.x == 0)
    {
      localObject = (WindowManager)ai.getContext().getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
      gYt.x = localDisplayMetrics.widthPixels;
      gYt.y = localDisplayMetrics.heightPixels;
    }
    Object localObject = gYt;
    AppMethodBeat.o(95830);
    return localObject;
  }
  
  public static com.tencent.mm.sdk.platformtools.ao dvq()
  {
    AppMethodBeat.i(95799);
    if (xTY == null) {
      xTY = new com.tencent.mm.sdk.platformtools.ao("MicroMsg.SnsCore#WorkingHandler");
    }
    com.tencent.mm.sdk.platformtools.ao localao = xTY;
    AppMethodBeat.o(95799);
    return localao;
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(95792);
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.kernel.g.agS();
    String str = com.tencent.mm.kernel.g.agR().ghC;
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
  
  public static String getSnsAdPath()
  {
    AppMethodBeat.i(95807);
    String str = ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.b.c.class)).getSnsAdPath();
    AppMethodBeat.o(95807);
    return str;
  }
  
  public static void h(Point paramPoint)
  {
    gYt = paramPoint;
  }
  
  public final void a(au paramau)
  {
    AppMethodBeat.i(95837);
    t.a(paramau);
    AppMethodBeat.o(95837);
  }
  
  public final void b(au paramau)
  {
    AppMethodBeat.i(95838);
    t.b(paramau);
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
    ac.i("MicroMsg.SnsCore", "onAccountPostReset " + Thread.currentThread().getId() + " isAccInit: " + this.xTN);
    if (this.xTN)
    {
      AppMethodBeat.o(95834);
      return;
    }
    this.xTN = true;
    this.qVx = true;
    checkDir();
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("NewYearSNSCtrl2016", this.xTU, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("NewYearSNSTips2016", this.xTV, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("NewYearSNSAmountLevelCtrl2016", this.xTW, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("SnsAd", this.xTX, true);
    com.tencent.mm.plugin.sns.b.o.xLZ = dHN();
    com.tencent.mm.plugin.sns.b.o.xMa = dHO();
    com.tencent.mm.plugin.sns.b.o.xMb = dHV();
    com.tencent.mm.plugin.sns.b.o.xMc = dHW();
    com.tencent.mm.plugin.sns.b.o.xMd = dHX();
    com.tencent.mm.plugin.sns.b.o.xMf = dHH();
    com.tencent.mm.plugin.sns.b.o.xMe = this;
    com.tencent.mm.plugin.sns.b.o.xMg = dHR();
    com.tencent.mm.sdk.b.a.GpY.c(this.xUD);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUE);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUq);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUo);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUp);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUr);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUs);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUt);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUu);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUv);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUx);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUy);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUz);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUH);
    appForegroundListener.alive();
    this.xUb = new n();
    this.xUc = new com.tencent.mm.plugin.sns.k();
    this.xUd = new com.tencent.mm.plugin.sns.e();
    this.xUe = new com.tencent.mm.plugin.sns.q();
    this.xUf = new com.tencent.mm.plugin.sns.h();
    this.xUg = new com.tencent.mm.plugin.sns.g();
    this.xUh = new com.tencent.mm.plugin.sns.m();
    this.xUi = new com.tencent.mm.plugin.sns.j();
    this.xUj = new com.tencent.mm.plugin.sns.b();
    this.xUk = new com.tencent.mm.plugin.sns.c();
    this.xUl = new com.tencent.mm.plugin.sns.f();
    com.tencent.mm.sdk.b.a.GpY.c(this.xUC);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUB);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUe);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUb);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUc);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUd);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUf);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUg);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUh);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUi);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUj);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUk);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUl);
    com.tencent.mm.sdk.b.a.GpY.c(this.vco);
    this.xTR = new com.tencent.mm.plugin.sns.d();
    com.tencent.mm.sdk.b.a.GpY.c(this.xTR);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUG);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUm);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUn);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUA);
    com.tencent.mm.sdk.b.a.GpY.c(this.xUw);
    Object localObject1 = dHL();
    com.tencent.mm.plugin.sns.ad.d.k.xKc = com.tencent.mm.m.g.ZY().getInt("MMUxAdLog2GSendSize", 20480);
    com.tencent.mm.plugin.sns.ad.d.k.xKd = com.tencent.mm.m.g.ZY().getInt("MMUxAdLog3GSendSize", 30720);
    com.tencent.mm.plugin.sns.ad.d.k.xKe = com.tencent.mm.m.g.ZY().getInt("MMUxAdLogWifiSendSize", 51200);
    com.tencent.mm.plugin.sns.ad.d.k.xKf = com.tencent.mm.m.g.ZY().getInt("MMUxAdLogMinRandTime", 60);
    com.tencent.mm.plugin.sns.ad.d.k.xKg = com.tencent.mm.m.g.ZY().getInt("MMUxAdLogMaxRandTime", 1800);
    com.tencent.mm.plugin.sns.ad.d.k.xKh = com.tencent.mm.m.g.ZY().getInt("MMUxAdLogMaxExceptionTime", 43200);
    ac.i("MicroMsg.SnsLogMgr", "init " + com.tencent.mm.plugin.sns.ad.d.k.xKc + ";" + com.tencent.mm.plugin.sns.ad.d.k.xKd + ";" + com.tencent.mm.plugin.sns.ad.d.k.xKe + ";" + com.tencent.mm.plugin.sns.ad.d.k.xKf + ";" + com.tencent.mm.plugin.sns.ad.d.k.xKg + ";" + com.tencent.mm.plugin.sns.ad.d.k.xKh);
    if (com.tencent.mm.plugin.sns.ad.d.k.xKg - com.tencent.mm.plugin.sns.ad.d.k.xKf < 0) {
      com.tencent.mm.plugin.sns.ad.d.k.xKg = com.tencent.mm.plugin.sns.ad.d.k.xKf;
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1802, (com.tencent.mm.ak.g)localObject1);
    localObject1 = dHN();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(207, (com.tencent.mm.ak.g)localObject1);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(209, (com.tencent.mm.ak.g)localObject1);
    localObject1 = this.xTK;
    com.tencent.mm.sdk.b.a.GpY.c(((ao)localObject1).xVx);
    com.tencent.mm.sdk.b.a.GpY.c(((ao)localObject1).xVy);
    com.tencent.mm.sdk.b.a.GpY.c(((ao)localObject1).xVz);
    this.xTS = new com.tencent.mm.plugin.sns.g.a();
    aq.init();
    localObject1 = com.tencent.mm.modelsns.e.hTW;
    com.tencent.mm.modelsns.e.aIa();
    if (com.tencent.mm.memory.l.avR())
    {
      localObject1 = com.tencent.mm.memory.c.hen;
      localObject2 = com.tencent.mm.memory.c.hen;
      localObject2.getClass();
      ((com.tencent.mm.memory.c)localObject1).a(new e.a((com.tencent.mm.memory.c)localObject2)
      {
        final int xUI;
        
        public final long avM()
        {
          return 10485760L;
        }
        
        public final int avN()
        {
          return -1;
        }
      });
    }
    localObject1 = com.tencent.mm.memory.o.heJ;
    Object localObject2 = com.tencent.mm.memory.o.heJ;
    localObject2.getClass();
    ((com.tencent.mm.memory.o)localObject1).a(new e.a((com.tencent.mm.memory.o)localObject2)
    {
      public final long avM()
      {
        return -1L;
      }
      
      public final int avN()
      {
        return 3;
      }
    });
    localObject1 = com.tencent.mm.memory.g.heu;
    localObject2 = com.tencent.mm.memory.g.heu;
    localObject2.getClass();
    ((com.tencent.mm.memory.g)localObject1).a(new e.a((com.tencent.mm.memory.g)localObject2)
    {
      public final long avM()
      {
        return 0L;
      }
      
      public final int avN()
      {
        return 5;
      }
    });
    dHP();
    com.tencent.mm.plugin.sns.f.a.init();
    try
    {
      localObject1 = com.tencent.mm.sdk.platformtools.aw.aKT("TrackDataSource");
      if (!bs.isNullOrNil(((com.tencent.mm.sdk.platformtools.aw)localObject1).getString("path", "")))
      {
        com.tencent.mm.plugin.report.service.h.wUl.dB(150, 74);
        com.tencent.mm.plugin.report.service.h.wUl.f(17832, new Object[] { Integer.valueOf(((com.tencent.mm.sdk.platformtools.aw)localObject1).getInt("type", 0)), ((com.tencent.mm.sdk.platformtools.aw)localObject1).getString("path", ""), Long.valueOf(((com.tencent.mm.sdk.platformtools.aw)localObject1).getLong("ts", 0L)), ((com.tencent.mm.sdk.platformtools.aw)localObject1).getString("media-url", ""), ((com.tencent.mm.sdk.platformtools.aw)localObject1).getString("thumb-url", ""), Long.valueOf(((com.tencent.mm.sdk.platformtools.aw)localObject1).getLong("prepare-ts", 0L)), ((com.tencent.mm.sdk.platformtools.aw)localObject1).getString("prepare-path", "") });
        ((com.tencent.mm.sdk.platformtools.aw)localObject1).putInt("type", 0);
        ((com.tencent.mm.sdk.platformtools.aw)localObject1).putString("path", "");
        ((com.tencent.mm.sdk.platformtools.aw)localObject1).putLong("ts", 0L);
        ((com.tencent.mm.sdk.platformtools.aw)localObject1).putString("media-url", "");
        ((com.tencent.mm.sdk.platformtools.aw)localObject1).putString("thumb-url", "");
        ((com.tencent.mm.sdk.platformtools.aw)localObject1).putLong("prepare-ts", 0L);
        ((com.tencent.mm.sdk.platformtools.aw)localObject1).commit();
      }
      AppMethodBeat.o(95834);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("MicroMsg.SnsCore", localThrowable, "videoCrashKvReport", new Object[0]);
      AppMethodBeat.o(95834);
    }
  }
  
  /* Error */
  public final void onAccountRelease()
  {
    // Byte code:
    //   0: ldc_w 1744
    //   3: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 1555	com/tencent/mm/plugin/sns/model/af:dHL	()Lcom/tencent/mm/plugin/sns/ad/d/k;
    //   9: astore_1
    //   10: invokestatic 686	com/tencent/mm/kernel/g:agS	()Lcom/tencent/mm/kernel/g;
    //   13: pop
    //   14: invokestatic 1598	com/tencent/mm/kernel/g:agQ	()Lcom/tencent/mm/kernel/b;
    //   17: getfield 1604	com/tencent/mm/kernel/b:ghe	Lcom/tencent/mm/ak/q;
    //   20: sipush 1802
    //   23: aload_1
    //   24: invokevirtual 1746	com/tencent/mm/ak/q:b	(ILcom/tencent/mm/ak/g;)V
    //   27: aload_0
    //   28: getfield 323	com/tencent/mm/plugin/sns/model/af:xTK	Lcom/tencent/mm/plugin/sns/model/ao;
    //   31: astore_1
    //   32: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   35: aload_1
    //   36: getfield 1612	com/tencent/mm/plugin/sns/model/ao:xVx	Lcom/tencent/mm/sdk/b/c;
    //   39: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   42: pop
    //   43: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   46: aload_1
    //   47: getfield 1615	com/tencent/mm/plugin/sns/model/ao:xVy	Lcom/tencent/mm/sdk/b/c;
    //   50: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   53: pop
    //   54: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   57: aload_1
    //   58: getfield 1618	com/tencent/mm/plugin/sns/model/ao:xVz	Lcom/tencent/mm/sdk/b/c;
    //   61: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   64: pop
    //   65: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   68: aload_0
    //   69: getfield 434	com/tencent/mm/plugin/sns/model/af:xUD	Lcom/tencent/mm/sdk/b/c;
    //   72: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   75: pop
    //   76: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   79: aload_0
    //   80: getfield 439	com/tencent/mm/plugin/sns/model/af:xUE	Lcom/tencent/mm/sdk/b/c;
    //   83: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   86: pop
    //   87: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   90: aload_0
    //   91: getfield 429	com/tencent/mm/plugin/sns/model/af:xUC	Lcom/tencent/mm/sdk/b/c;
    //   94: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   97: pop
    //   98: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   101: aload_0
    //   102: getfield 424	com/tencent/mm/plugin/sns/model/af:xUB	Lcom/tencent/mm/sdk/b/c;
    //   105: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   108: pop
    //   109: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   112: aload_0
    //   113: getfield 385	com/tencent/mm/plugin/sns/model/af:xUq	Lcom/tencent/mm/sdk/b/c;
    //   116: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   119: pop
    //   120: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   123: aload_0
    //   124: getfield 375	com/tencent/mm/plugin/sns/model/af:xUo	Lcom/tencent/mm/sdk/b/c;
    //   127: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   130: pop
    //   131: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   134: aload_0
    //   135: getfield 380	com/tencent/mm/plugin/sns/model/af:xUp	Lcom/tencent/mm/sdk/b/c;
    //   138: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   141: pop
    //   142: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   145: aload_0
    //   146: getfield 388	com/tencent/mm/plugin/sns/model/af:xUr	Lcom/tencent/mm/sdk/b/c;
    //   149: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   152: pop
    //   153: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   156: aload_0
    //   157: getfield 391	com/tencent/mm/plugin/sns/model/af:xUs	Lcom/tencent/mm/sdk/b/c;
    //   160: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   163: pop
    //   164: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   167: aload_0
    //   168: getfield 394	com/tencent/mm/plugin/sns/model/af:xUt	Lcom/tencent/mm/sdk/b/c;
    //   171: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   174: pop
    //   175: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   178: aload_0
    //   179: getfield 1513	com/tencent/mm/plugin/sns/model/af:xUe	Lcom/tencent/mm/plugin/sns/q;
    //   182: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   185: pop
    //   186: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   189: aload_0
    //   190: getfield 1518	com/tencent/mm/plugin/sns/model/af:xUf	Lcom/tencent/mm/plugin/sns/h;
    //   193: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   196: pop
    //   197: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   200: aload_0
    //   201: getfield 402	com/tencent/mm/plugin/sns/model/af:xUv	Lcom/tencent/mm/sdk/b/c;
    //   204: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   207: pop
    //   208: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   211: aload_0
    //   212: getfield 410	com/tencent/mm/plugin/sns/model/af:xUx	Lcom/tencent/mm/sdk/b/c;
    //   215: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   218: pop
    //   219: getstatic 299	com/tencent/mm/plugin/sns/model/af:appForegroundListener	Lcom/tencent/mm/app/n$a;
    //   222: invokevirtual 1751	com/tencent/mm/app/n$a:dead	()V
    //   225: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   228: aload_0
    //   229: getfield 1498	com/tencent/mm/plugin/sns/model/af:xUb	Lcom/tencent/mm/plugin/sns/n;
    //   232: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   235: pop
    //   236: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   239: aload_0
    //   240: getfield 1503	com/tencent/mm/plugin/sns/model/af:xUc	Lcom/tencent/mm/plugin/sns/k;
    //   243: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   246: pop
    //   247: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   250: aload_0
    //   251: getfield 1508	com/tencent/mm/plugin/sns/model/af:xUd	Lcom/tencent/mm/plugin/sns/e;
    //   254: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   257: pop
    //   258: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   261: aload_0
    //   262: getfield 1523	com/tencent/mm/plugin/sns/model/af:xUg	Lcom/tencent/mm/plugin/sns/g;
    //   265: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   268: pop
    //   269: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   272: aload_0
    //   273: getfield 1528	com/tencent/mm/plugin/sns/model/af:xUh	Lcom/tencent/mm/plugin/sns/m;
    //   276: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   279: pop
    //   280: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   283: aload_0
    //   284: getfield 1533	com/tencent/mm/plugin/sns/model/af:xUi	Lcom/tencent/mm/plugin/sns/j;
    //   287: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   290: pop
    //   291: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   294: aload_0
    //   295: getfield 1538	com/tencent/mm/plugin/sns/model/af:xUj	Lcom/tencent/mm/plugin/sns/b;
    //   298: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   301: pop
    //   302: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   305: aload_0
    //   306: getfield 1543	com/tencent/mm/plugin/sns/model/af:xUk	Lcom/tencent/mm/plugin/sns/c;
    //   309: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   312: pop
    //   313: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   316: aload_0
    //   317: getfield 1548	com/tencent/mm/plugin/sns/model/af:xUl	Lcom/tencent/mm/plugin/sns/f;
    //   320: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   323: pop
    //   324: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   327: aload_0
    //   328: getfield 399	com/tencent/mm/plugin/sns/model/af:xUu	Lcom/tencent/mm/sdk/b/c;
    //   331: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   334: pop
    //   335: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   338: aload_0
    //   339: getfield 1553	com/tencent/mm/plugin/sns/model/af:xTR	Lcom/tencent/mm/plugin/sns/d;
    //   342: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   345: pop
    //   346: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   349: aload_0
    //   350: getfield 415	com/tencent/mm/plugin/sns/model/af:xUy	Lcom/tencent/mm/sdk/b/c;
    //   353: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   356: pop
    //   357: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   360: aload_0
    //   361: getfield 418	com/tencent/mm/plugin/sns/model/af:xUz	Lcom/tencent/mm/sdk/b/c;
    //   364: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   367: pop
    //   368: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   371: aload_0
    //   372: getfield 444	com/tencent/mm/plugin/sns/model/af:vco	Lcom/tencent/mm/sdk/b/c;
    //   375: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   378: pop
    //   379: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   382: aload_0
    //   383: getfield 449	com/tencent/mm/plugin/sns/model/af:xUG	Lcom/tencent/mm/sdk/b/c;
    //   386: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   389: pop
    //   390: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   393: aload_0
    //   394: getfield 421	com/tencent/mm/plugin/sns/model/af:xUA	Lcom/tencent/mm/sdk/b/c;
    //   397: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   400: pop
    //   401: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   404: aload_0
    //   405: getfield 365	com/tencent/mm/plugin/sns/model/af:xUm	Lcom/tencent/mm/sdk/b/c;
    //   408: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   411: pop
    //   412: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   415: aload_0
    //   416: getfield 370	com/tencent/mm/plugin/sns/model/af:xUn	Lcom/tencent/mm/sdk/b/c;
    //   419: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   422: pop
    //   423: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   426: aload_0
    //   427: getfield 452	com/tencent/mm/plugin/sns/model/af:xUH	Lcom/tencent/mm/sdk/b/c;
    //   430: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   433: pop
    //   434: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   437: aload_0
    //   438: getfield 405	com/tencent/mm/plugin/sns/model/af:xUw	Lcom/tencent/mm/sdk/b/c;
    //   441: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   444: pop
    //   445: getstatic 1757	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a$e:yhL	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a;
    //   448: astore_1
    //   449: aload_1
    //   450: getfield 1762	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:yhE	Z
    //   453: ifeq +27 -> 480
    //   456: ldc_w 1764
    //   459: ldc_w 1766
    //   462: invokestatic 1768	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: invokestatic 230	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   468: aload_1
    //   469: getfield 1772	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:yhD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a$a;
    //   472: invokevirtual 1776	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   475: aload_1
    //   476: iconst_0
    //   477: putfield 1762	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:yhE	Z
    //   480: invokestatic 1782	com/tencent/mm/plugin/downloader/model/f:bXJ	()Lcom/tencent/mm/plugin/downloader/model/f;
    //   483: pop
    //   484: aload_1
    //   485: getfield 1786	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:yhI	Lcom/tencent/mm/plugin/downloader/model/m;
    //   488: invokestatic 1791	com/tencent/mm/plugin/downloader/model/c:b	(Lcom/tencent/mm/plugin/downloader/model/m;)V
    //   491: ldc_w 1447
    //   494: invokestatic 640	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   497: checkcast 1447	com/tencent/mm/plugin/messenger/foundation/a/q
    //   500: invokeinterface 1451 1 0
    //   505: ldc_w 1453
    //   508: aload_0
    //   509: getfield 343	com/tencent/mm/plugin/sns/model/af:xTU	Lcom/tencent/mm/plugin/sns/lucky/a/f;
    //   512: iconst_1
    //   513: invokevirtual 1793	com/tencent/mm/model/cc:b	(Ljava/lang/String;Lcom/tencent/mm/model/cc$a;Z)V
    //   516: ldc_w 1447
    //   519: invokestatic 640	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   522: checkcast 1447	com/tencent/mm/plugin/messenger/foundation/a/q
    //   525: invokeinterface 1451 1 0
    //   530: ldc_w 1460
    //   533: aload_0
    //   534: getfield 348	com/tencent/mm/plugin/sns/model/af:xTV	Lcom/tencent/mm/plugin/sns/lucky/a/j;
    //   537: iconst_1
    //   538: invokevirtual 1793	com/tencent/mm/model/cc:b	(Ljava/lang/String;Lcom/tencent/mm/model/cc$a;Z)V
    //   541: ldc_w 1447
    //   544: invokestatic 640	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   547: checkcast 1447	com/tencent/mm/plugin/messenger/foundation/a/q
    //   550: invokeinterface 1451 1 0
    //   555: ldc_w 1462
    //   558: aload_0
    //   559: getfield 353	com/tencent/mm/plugin/sns/model/af:xTW	Lcom/tencent/mm/plugin/sns/lucky/a/d;
    //   562: iconst_1
    //   563: invokevirtual 1793	com/tencent/mm/model/cc:b	(Ljava/lang/String;Lcom/tencent/mm/model/cc$a;Z)V
    //   566: ldc_w 1447
    //   569: invokestatic 640	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   572: checkcast 1447	com/tencent/mm/plugin/messenger/foundation/a/q
    //   575: invokeinterface 1451 1 0
    //   580: ldc_w 1464
    //   583: aload_0
    //   584: getfield 358	com/tencent/mm/plugin/sns/model/af:xTX	Lcom/tencent/mm/plugin/sns/lucky/a/l;
    //   587: iconst_1
    //   588: invokevirtual 1793	com/tencent/mm/model/cc:b	(Ljava/lang/String;Lcom/tencent/mm/model/cc$a;Z)V
    //   591: invokestatic 1466	com/tencent/mm/plugin/sns/model/af:dHN	()Lcom/tencent/mm/plugin/sns/model/ba;
    //   594: astore_1
    //   595: invokestatic 686	com/tencent/mm/kernel/g:agS	()Lcom/tencent/mm/kernel/g;
    //   598: pop
    //   599: invokestatic 1598	com/tencent/mm/kernel/g:agQ	()Lcom/tencent/mm/kernel/b;
    //   602: getfield 1604	com/tencent/mm/kernel/b:ghe	Lcom/tencent/mm/ak/q;
    //   605: sipush 207
    //   608: aload_1
    //   609: invokevirtual 1746	com/tencent/mm/ak/q:b	(ILcom/tencent/mm/ak/g;)V
    //   612: invokestatic 686	com/tencent/mm/kernel/g:agS	()Lcom/tencent/mm/kernel/g;
    //   615: pop
    //   616: invokestatic 1598	com/tencent/mm/kernel/g:agQ	()Lcom/tencent/mm/kernel/b;
    //   619: getfield 1604	com/tencent/mm/kernel/b:ghe	Lcom/tencent/mm/ak/q;
    //   622: sipush 209
    //   625: aload_1
    //   626: invokevirtual 1746	com/tencent/mm/ak/q:b	(ILcom/tencent/mm/ak/g;)V
    //   629: ldc 2
    //   631: invokestatic 932	com/tencent/mm/model/t:ap	(Ljava/lang/Class;)Lcom/tencent/mm/model/aw;
    //   634: checkcast 2	com/tencent/mm/plugin/sns/model/af
    //   637: astore_1
    //   638: aload_1
    //   639: ifnull +99 -> 738
    //   642: ldc_w 454
    //   645: ldc_w 1795
    //   648: invokestatic 1797	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   651: aload_1
    //   652: getfield 556	com/tencent/mm/plugin/sns/model/af:ghG	Lcom/tencent/mm/storagebase/h;
    //   655: ifnull +15 -> 670
    //   658: aload_1
    //   659: getfield 556	com/tencent/mm/plugin/sns/model/af:ghG	Lcom/tencent/mm/storagebase/h;
    //   662: invokevirtual 1098	com/tencent/mm/storagebase/h:closeDB	()V
    //   665: aload_1
    //   666: aconst_null
    //   667: putfield 556	com/tencent/mm/plugin/sns/model/af:ghG	Lcom/tencent/mm/storagebase/h;
    //   670: aload_1
    //   671: getfield 486	com/tencent/mm/plugin/sns/model/af:xTl	Ljava/util/concurrent/ExecutorService;
    //   674: ifnull +13 -> 687
    //   677: aload_1
    //   678: getfield 486	com/tencent/mm/plugin/sns/model/af:xTl	Ljava/util/concurrent/ExecutorService;
    //   681: invokeinterface 1801 1 0
    //   686: pop
    //   687: aload_1
    //   688: getfield 505	com/tencent/mm/plugin/sns/model/af:wXF	Ljava/util/concurrent/ExecutorService;
    //   691: ifnull +13 -> 704
    //   694: aload_1
    //   695: getfield 505	com/tencent/mm/plugin/sns/model/af:wXF	Ljava/util/concurrent/ExecutorService;
    //   698: invokeinterface 1801 1 0
    //   703: pop
    //   704: aload_1
    //   705: getfield 509	com/tencent/mm/plugin/sns/model/af:xTk	Ljava/util/concurrent/ExecutorService;
    //   708: ifnull +13 -> 721
    //   711: aload_1
    //   712: getfield 509	com/tencent/mm/plugin/sns/model/af:xTk	Ljava/util/concurrent/ExecutorService;
    //   715: invokeinterface 1801 1 0
    //   720: pop
    //   721: aload_1
    //   722: getfield 517	com/tencent/mm/plugin/sns/model/af:xTm	Ljava/util/concurrent/ExecutorService;
    //   725: ifnull +13 -> 738
    //   728: aload_1
    //   729: getfield 517	com/tencent/mm/plugin/sns/model/af:xTm	Ljava/util/concurrent/ExecutorService;
    //   732: invokeinterface 1801 1 0
    //   737: pop
    //   738: aload_0
    //   739: getfield 1623	com/tencent/mm/plugin/sns/model/af:xTS	Lcom/tencent/mm/plugin/sns/g/a;
    //   742: astore_1
    //   743: invokestatic 1803	com/tencent/mm/plugin/sns/model/af:dHM	()Lcom/tencent/mm/plugin/sns/model/b;
    //   746: aload_1
    //   747: invokevirtual 1806	com/tencent/mm/plugin/sns/model/b:b	(Lcom/tencent/mm/plugin/sns/model/b$b;)V
    //   750: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   753: aload_1
    //   754: getfield 1809	com/tencent/mm/plugin/sns/g/a:xOq	Lcom/tencent/mm/sdk/b/c;
    //   757: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   760: pop
    //   761: invokestatic 1812	com/tencent/mm/plugin/sns/model/aq:unInit	()V
    //   764: getstatic 1674	com/tencent/mm/memory/g:heu	Lcom/tencent/mm/memory/g;
    //   767: invokevirtual 1815	com/tencent/mm/memory/g:avJ	()V
    //   770: getstatic 1648	com/tencent/mm/memory/c:hen	Lcom/tencent/mm/memory/c;
    //   773: invokevirtual 1816	com/tencent/mm/memory/c:avJ	()V
    //   776: getstatic 1664	com/tencent/mm/memory/o:heJ	Lcom/tencent/mm/memory/o;
    //   779: invokevirtual 1817	com/tencent/mm/memory/o:avJ	()V
    //   782: invokestatic 1680	com/tencent/mm/plugin/sns/model/af:dHP	()Lcom/tencent/mm/plugin/sns/model/av;
    //   785: astore_1
    //   786: aload_1
    //   787: aconst_null
    //   788: putfield 1821	com/tencent/mm/plugin/sns/model/av:xWQ	Lcom/tencent/mm/plugin/sns/model/bc;
    //   791: aload_1
    //   792: getfield 1825	com/tencent/mm/plugin/sns/model/av:xWU	Ljava/util/LinkedList;
    //   795: astore_2
    //   796: aload_2
    //   797: monitorenter
    //   798: aload_1
    //   799: getfield 1825	com/tencent/mm/plugin/sns/model/av:xWU	Ljava/util/LinkedList;
    //   802: invokevirtual 1830	java/util/LinkedList:clear	()V
    //   805: aload_2
    //   806: monitorexit
    //   807: aload_1
    //   808: getfield 1834	com/tencent/mm/plugin/sns/model/av:xWS	Ljava/util/Map;
    //   811: invokeinterface 1837 1 0
    //   816: aload_1
    //   817: getfield 1840	com/tencent/mm/plugin/sns/model/av:xWR	Ljava/util/LinkedList;
    //   820: invokevirtual 1830	java/util/LinkedList:clear	()V
    //   823: aload_1
    //   824: getfield 1843	com/tencent/mm/plugin/sns/model/av:xWT	Ljava/util/LinkedList;
    //   827: astore_2
    //   828: aload_2
    //   829: monitorenter
    //   830: aload_1
    //   831: getfield 1843	com/tencent/mm/plugin/sns/model/av:xWT	Ljava/util/LinkedList;
    //   834: invokevirtual 1830	java/util/LinkedList:clear	()V
    //   837: aload_2
    //   838: monitorexit
    //   839: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   842: aload_1
    //   843: getfield 1846	com/tencent/mm/plugin/sns/model/av:xWX	Lcom/tencent/mm/sdk/b/c;
    //   846: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   849: pop
    //   850: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   853: aload_1
    //   854: getfield 1847	com/tencent/mm/plugin/sns/model/av:xVy	Lcom/tencent/mm/sdk/b/c;
    //   857: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   860: pop
    //   861: getstatic 1484	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   864: aload_1
    //   865: getfield 1848	com/tencent/mm/plugin/sns/model/av:xVz	Lcom/tencent/mm/sdk/b/c;
    //   868: invokevirtual 1748	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   871: pop
    //   872: invokestatic 1851	com/tencent/mm/plugin/sns/f/a:destroy	()V
    //   875: ldc_w 1744
    //   878: invokestatic 302	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   881: return
    //   882: astore_2
    //   883: ldc_w 1764
    //   886: ldc_w 1853
    //   889: iconst_1
    //   890: anewarray 4	java/lang/Object
    //   893: dup
    //   894: iconst_0
    //   895: aload_2
    //   896: invokevirtual 1856	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   899: aastore
    //   900: invokestatic 1858	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   903: goto -423 -> 480
    //   906: astore_1
    //   907: aload_2
    //   908: monitorexit
    //   909: ldc_w 1744
    //   912: invokestatic 302	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   915: aload_1
    //   916: athrow
    //   917: astore_1
    //   918: aload_2
    //   919: monitorexit
    //   920: ldc_w 1744
    //   923: invokestatic 302	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   926: aload_1
    //   927: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	928	0	this	af
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
 * Qualified Name:     com.tencent.mm.plugin.sns.model.af
 * JD-Core Version:    0.7.0.1
 */