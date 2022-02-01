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
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.g.a.mz.a;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qc.a;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qd.a;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.g.a.qk.a;
import com.tencent.mm.g.a.qv;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.g.a.td;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.memory.e.a;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.model.cc;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.n;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.z;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bi.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public final class af
  implements com.tencent.mm.model.aw, com.tencent.mm.plugin.sns.c.k
{
  private static n.a appForegroundListener;
  private static Point gxV;
  public static boolean wGN;
  private static int wGO;
  private static int wGP;
  private static int wGT;
  private static int wGU;
  private static com.tencent.mm.sdk.platformtools.ap wHD;
  private static int wHE;
  private static int wHF;
  private static String wHu;
  protected static HashMap<Integer, h.b> wHv;
  private com.tencent.mm.storagebase.h gda;
  private com.tencent.mm.sdk.platformtools.ap handler;
  private byte[] lock;
  private boolean qmV;
  private com.tencent.mm.sdk.b.c tTG;
  private ExecutorService vNk;
  private ExecutorService wGQ;
  private ExecutorService wGR;
  private ExecutorService wGS;
  private u wGV;
  private com.tencent.mm.plugin.sns.storage.q wGW;
  private com.tencent.mm.plugin.sns.storage.f wGX;
  private com.tencent.mm.plugin.sns.storage.d wGY;
  private com.tencent.mm.plugin.sns.storage.ab wGZ;
  private com.tencent.mm.plugin.sns.lucky.a.j wHA;
  private com.tencent.mm.plugin.sns.lucky.a.d wHB;
  private com.tencent.mm.plugin.sns.lucky.a.l wHC;
  private n wHG;
  private com.tencent.mm.plugin.sns.k wHH;
  private com.tencent.mm.plugin.sns.e wHI;
  private com.tencent.mm.plugin.sns.q wHJ;
  private com.tencent.mm.plugin.sns.h wHK;
  private com.tencent.mm.plugin.sns.g wHL;
  private com.tencent.mm.plugin.sns.m wHM;
  private com.tencent.mm.plugin.sns.j wHN;
  private com.tencent.mm.plugin.sns.b wHO;
  private com.tencent.mm.plugin.sns.c wHP;
  private com.tencent.mm.plugin.sns.f wHQ;
  private com.tencent.mm.sdk.b.c wHR;
  private com.tencent.mm.sdk.b.c wHS;
  private com.tencent.mm.sdk.b.c wHT;
  private com.tencent.mm.sdk.b.c wHU;
  private com.tencent.mm.sdk.b.c wHV;
  private com.tencent.mm.sdk.b.c wHW;
  private com.tencent.mm.sdk.b.c wHX;
  private com.tencent.mm.sdk.b.c wHY;
  private com.tencent.mm.sdk.b.c wHZ;
  private f wHa;
  private com.tencent.mm.plugin.sns.storage.o wHb;
  private com.tencent.mm.plugin.sns.storage.k wHc;
  private w wHd;
  private com.tencent.mm.plugin.sns.storage.m wHe;
  private ad wHf;
  private am.a wHg;
  private b wHh;
  private az wHi;
  private com.tencent.mm.plugin.sns.ui.am wHj;
  private com.tencent.mm.plugin.sns.i.c wHk;
  private com.tencent.mm.plugin.sns.i.g wHl;
  private ar wHm;
  private s wHn;
  private com.tencent.mm.plugin.sns.a.b.k wHo;
  private ao wHp;
  private boolean wHq;
  private z wHr;
  private boolean wHs;
  private byte[] wHt;
  private com.tencent.mm.plugin.sns.d wHw;
  private com.tencent.mm.plugin.sns.h.a wHx;
  private au wHy;
  private com.tencent.mm.plugin.sns.lucky.a.f wHz;
  private com.tencent.mm.sdk.b.c wIa;
  private com.tencent.mm.sdk.b.c wIb;
  private com.tencent.mm.sdk.b.c wIc;
  private com.tencent.mm.sdk.b.c wId;
  private com.tencent.mm.sdk.b.c wIe;
  private com.tencent.mm.sdk.b.c wIf;
  private com.tencent.mm.sdk.b.c wIg;
  private com.tencent.mm.sdk.b.c wIh;
  private com.tencent.mm.sdk.b.c wIi;
  private com.tencent.mm.sdk.b.c wIj;
  private boolean wIk;
  private com.tencent.mm.sdk.b.c wIl;
  private com.tencent.mm.sdk.b.c wIm;
  
  static
  {
    AppMethodBeat.i(95843);
    wGN = true;
    wGO = 0;
    wGP = 0;
    wHu = "";
    wHv = new HashMap();
    wHE = 103;
    wHF = com.tencent.mm.cd.a.fromDPToPix(com.tencent.mm.sdk.platformtools.aj.getContext(), 130);
    gxV = new Point();
    wHv.put(Integer.valueOf("CanvasInfo".hashCode()), new af.1());
    wHv.put(Integer.valueOf("UxCanvasInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.ab.SQL_CREATE;
      }
    });
    wHv.put(Integer.valueOf("SNSMEDIA_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return u.SQL_CREATE;
      }
    });
    wHv.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.q.SQL_CREATE;
      }
    });
    wHv.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.q.SQL_CREATE;
      }
    });
    wHv.put(Integer.valueOf("ADSNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.f.SQL_CREATE;
      }
    });
    wHv.put(Integer.valueOf("SNSEXT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.o.SQL_CREATE;
      }
    });
    wHv.put(Integer.valueOf("SNSCOMMENT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.k.SQL_CREATE;
      }
    });
    wHv.put(Integer.valueOf("SNSTAGINFO_TABLE".hashCode()), new af.38());
    wHv.put(Integer.valueOf("SNSKVREPORT_TABLE".hashCode()), new af.2());
    wHv.put(Integer.valueOf("SNSDRAFT_TABLE".hashCode()), new h.b()
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
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          if (!com.tencent.mm.kernel.a.aeC())
          {
            paramAnonymousString = new qb();
            paramAnonymousString.dvF.state = 0;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
            paramAnonymousString = new vv();
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(176255);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(176254);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          if (!com.tencent.mm.kernel.a.aeC())
          {
            paramAnonymousString = new qb();
            paramAnonymousString.dvF.state = 1;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
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
    this.handler = new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper());
    this.wHp = new ao();
    this.qmV = false;
    this.wHq = true;
    this.lock = new byte[0];
    this.wHr = new z();
    this.wHs = false;
    this.wHt = new byte[0];
    this.wHz = new com.tencent.mm.plugin.sns.lucky.a.f();
    this.wHA = new com.tencent.mm.plugin.sns.lucky.a.j();
    this.wHB = new com.tencent.mm.plugin.sns.lucky.a.d();
    this.wHC = new com.tencent.mm.plugin.sns.lucky.a.l();
    this.wHR = new af.8(this);
    this.wHS = new af.9(this);
    this.wHT = new af.10(this);
    this.wHU = new af.11(this);
    this.wHV = new af.13(this);
    this.wHW = new com.tencent.mm.sdk.b.c() {};
    this.wHX = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(mz paramAnonymousmz)
      {
        AppMethodBeat.i(176261);
        Object localObject2 = paramAnonymousmz.dsd.dlQ;
        com.tencent.mm.plugin.sns.storage.q localq = af.dtu();
        paramAnonymousmz = af.afg();
        long l1 = paramAnonymousmz.rb(-1L);
        try
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            long l2 = ((Long)((Iterator)localObject2).next()).longValue();
            p localp = localq.Ne((int)l2);
            if (localp != null)
            {
              localp.field_localFlag |= 0x40;
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsInfoStorage", "snsInfoId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
              localq.b((int)l2, localp);
            }
          }
          paramAnonymousmz.mX(l1);
        }
        finally
        {
          paramAnonymousmz.mX(l1);
          AppMethodBeat.o(176261);
        }
        AppMethodBeat.o(176261);
        return false;
      }
    };
    this.wHY = new com.tencent.mm.sdk.b.c() {};
    this.wHZ = new af.17(this);
    this.wIa = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(qc paramAnonymousqc)
      {
        AppMethodBeat.i(176263);
        try
        {
          SnsAdClick localSnsAdClick = paramAnonymousqc.dvG.dvH;
          paramAnonymousqc = af.dtx().sY(localSnsAdClick.dze);
          if (paramAnonymousqc == null)
          {
            AppMethodBeat.o(176263);
            return false;
          }
          p localp = paramAnonymousqc.dxE();
          String str;
          Object localObject;
          label76:
          com.tencent.mm.plugin.sns.a.b.a locala;
          if (localSnsAdClick.dep == 2)
          {
            paramAnonymousqc = localp.dxv();
            if (paramAnonymousqc == null) {
              break label450;
            }
            str = paramAnonymousqc.wSu;
            localObject = com.tencent.mm.plugin.sns.waid.g.aqU(str);
            if (localObject != null) {
              break label275;
            }
            localObject = "";
            locala = new com.tencent.mm.plugin.sns.a.b.a();
            locala.wwL = com.tencent.mm.plugin.sns.data.j.i(localp);
            locala.wwM = com.tencent.mm.plugin.sns.data.j.j(localp);
            locala.wwN = ((int)localSnsAdClick.htf);
            if (localSnsAdClick.dep != 2) {
              break label283;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCore", "at_friend_detail report ad click, exposureTime=" + localSnsAdClick.hte + ", clkPos=" + localSnsAdClick.hsX + ", pkg=" + str + ", waid=" + (String)localObject);
            paramAnonymousqc = new com.tencent.mm.plugin.sns.a.b.e(localSnsAdClick.dze, paramAnonymousqc.dAM, localSnsAdClick.hsX, localSnsAdClick.hsY, localSnsAdClick.hsW, "", localp.dyj(), localp.dxy().xns, localSnsAdClick.htd, localp.dyh().dxC(), localp.dyh().dxD(), localSnsAdClick.hte, str, (String)localObject, locala);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(paramAnonymousqc, 0);
          }
          for (;;)
          {
            AppMethodBeat.o(176263);
            return true;
            paramAnonymousqc = localp.dxu();
            break;
            label275:
            localObject = ((com.tencent.mm.plugin.sns.waid.h)localObject).xZu;
            break label76;
            label283:
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCore", "report ad click, exposureTime=" + localSnsAdClick.hte + ", clkPos=" + localSnsAdClick.hsX + ", source=" + localSnsAdClick.dep + ", pkg=" + str + ", waid=" + (String)localObject);
            paramAnonymousqc = new com.tencent.mm.plugin.sns.a.b.e(localSnsAdClick.dze, paramAnonymousqc.dAM, localSnsAdClick.hsX, localSnsAdClick.hsY, localSnsAdClick.hsW, "", localp.dyj(), localp.dxy().xns, localSnsAdClick.htd, localp.dyh().dxA(), localp.dyh().dxB(), localSnsAdClick.hte, str, (String)localObject, locala);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(paramAnonymousqc, 0);
          }
          label450:
          return false;
        }
        catch (Exception paramAnonymousqc)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousqc, "report ad click error", new Object[0]);
          AppMethodBeat.o(176263);
        }
      }
    };
    this.wIb = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(qd paramAnonymousqd)
      {
        AppMethodBeat.i(176264);
        SnsAdClick localSnsAdClick;
        Object localObject1;
        try
        {
          localSnsAdClick = paramAnonymousqd.dvI.dvH;
          localObject1 = af.dtx().sY(localSnsAdClick.dze);
          if (localObject1 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.sns.storage.e)localObject1).dxE();
            if (localSnsAdClick.dep == 2)
            {
              localObject1 = ((p)localObject2).dxv();
              if (localObject1 == null) {
                break label227;
              }
              if (localSnsAdClick.dep != 2) {
                break label204;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCore", "at_friend_detail report ad h5 load");
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.h.vKh.f(16972, new Object[] { Long.valueOf(localSnsAdClick.dze), Integer.valueOf(localSnsAdClick.hsW), ((com.tencent.mm.plugin.sns.storage.a)localObject1).dvK, Integer.valueOf(((p)localObject2).dyi()), ((p)localObject2).dxy().xns, paramAnonymousqd.dvI.url, Integer.valueOf(paramAnonymousqd.dvI.dvJ), Integer.valueOf(paramAnonymousqd.dvI.errorCode), Long.valueOf(paramAnonymousqd.dvI.timestamp) });
              AppMethodBeat.o(176264);
              return true;
              localObject1 = ((p)localObject2).dxu();
              break;
              label204:
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCore", "report ad h5 load");
            }
          }
          label227:
          localObject1 = af.dtu().th(localSnsAdClick.dze);
        }
        catch (Exception paramAnonymousqd)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousqd, "report load ad h5 error", new Object[0]);
          AppMethodBeat.o(176264);
          return false;
        }
        Object localObject2 = new StringBuilder("report ad h5, AdSnsInfo==null, uxInfo=").append(paramAnonymousqd.dvI.dvK).append(", snsInfo==null?");
        boolean bool;
        String str;
        int i;
        if (localObject1 == null)
        {
          bool = true;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCore", bool);
          if (localObject1 == null) {
            break label450;
          }
          str = paramAnonymousqd.dvI.dvK;
          i = ((p)localObject1).dyi();
          localObject1 = ((p)localObject1).dxy();
          if (localObject1 != null) {
            break label442;
          }
          localObject1 = "";
          break label569;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(16972, new Object[] { Long.valueOf(localSnsAdClick.dze), Integer.valueOf(localSnsAdClick.hsW), str, Integer.valueOf(i), localObject2, paramAnonymousqd.dvI.url, Integer.valueOf(paramAnonymousqd.dvI.dvJ), Integer.valueOf(paramAnonymousqd.dvI.errorCode), Long.valueOf(paramAnonymousqd.dvI.timestamp) });
          AppMethodBeat.o(176264);
          return true;
          bool = false;
          break;
          label442:
          localObject1 = ((TimeLineObject)localObject1).xns;
          break label569;
          label450:
          localObject1 = paramAnonymousqd.dvI.dvK;
          com.tencent.mm.plugin.report.service.h.vKh.f(16972, new Object[] { Long.valueOf(localSnsAdClick.dze), Integer.valueOf(localSnsAdClick.hsW), localObject1, Integer.valueOf(0), "", paramAnonymousqd.dvI.url, Integer.valueOf(paramAnonymousqd.dvI.dvJ), Integer.valueOf(paramAnonymousqd.dvI.errorCode), Long.valueOf(paramAnonymousqd.dvI.timestamp) });
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
    this.wIc = new af.20(this);
    this.wId = new af.21(this);
    this.wIe = new com.tencent.mm.sdk.b.c() {};
    this.wIf = new com.tencent.mm.sdk.b.c() {};
    this.wIg = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(qk paramAnonymousqk)
      {
        AppMethodBeat.i(176265);
        SnsAdClick localSnsAdClick = paramAnonymousqk.dvZ.dvH;
        try
        {
          if (paramAnonymousqk.dvZ.dwa != 1) {
            break label259;
          }
          if (localSnsAdClick.hsZ != 1) {
            break label365;
          }
          locale = af.dtx().sY(localSnsAdClick.dze);
          if ((locale == null) || (!locale.dvv())) {
            break label266;
          }
          localObject2 = af.dto();
          j = 14647;
          localObject1 = new Object[7];
          localObject1[0] = Long.valueOf(localSnsAdClick.dze);
          localObject1[1] = locale.dxu().dvK;
          localObject1[2] = Integer.valueOf(localSnsAdClick.hsW);
          localObject1[3] = Long.valueOf(localSnsAdClick.startTime);
          localObject1[4] = Long.valueOf(System.currentTimeMillis());
          i = locale.dxw();
          paramAnonymousqk = (qk)localObject1;
        }
        catch (Exception paramAnonymousqk)
        {
          for (;;)
          {
            com.tencent.mm.plugin.sns.storage.e locale;
            int j;
            com.tencent.mm.plugin.sns.a.b.k localk;
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousqk, "report ad click error", new Object[0]);
            continue;
            Object localObject1 = paramAnonymousqk.dvZ.dvK;
            paramAnonymousqk = (qk)localObject1;
            if (localObject1 == null) {
              paramAnonymousqk = "";
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCore", "ReportSnsEvent, AdSnsInfo==null, uxInfo=".concat(String.valueOf(paramAnonymousqk)));
            boolean bool = false;
            continue;
            af.dto().f(12013, new Object[] { localObject1 });
            continue;
            int i = -1;
            localObject1 = paramAnonymousqk;
            Object localObject2 = paramAnonymousqk;
            paramAnonymousqk = (qk)localObject1;
            localObject1 = localObject2;
            localObject2 = localk;
          }
        }
        paramAnonymousqk[5] = Integer.valueOf(i);
        localObject1[6] = "";
        ((com.tencent.mm.plugin.sns.a.b.k)localObject2).f(j, (Object[])localObject1);
        paramAnonymousqk = com.tencent.mm.modelsns.d.oF(750);
        paramAnonymousqk.zi(localSnsAdClick.dze).zi(locale.dxu().dvK).oH(localSnsAdClick.hsW).zi(localSnsAdClick.startTime).zi(System.currentTimeMillis());
        paramAnonymousqk.aBj();
        for (;;)
        {
          label259:
          AppMethodBeat.o(176265);
          return false;
          label266:
          localk = af.dto();
          j = 13155;
          paramAnonymousqk = new Object[7];
          paramAnonymousqk[0] = Long.valueOf(localSnsAdClick.dze);
          paramAnonymousqk[1] = locale.dxu().dvK;
          paramAnonymousqk[2] = Integer.valueOf(localSnsAdClick.hsW);
          paramAnonymousqk[3] = Long.valueOf(localSnsAdClick.startTime);
          paramAnonymousqk[4] = Long.valueOf(System.currentTimeMillis());
          if (locale == null) {
            break label753;
          }
          i = locale.dxw();
          localObject1 = paramAnonymousqk;
          localObject2 = paramAnonymousqk;
          paramAnonymousqk = (qk)localObject1;
          localObject1 = localObject2;
          localObject2 = localk;
          break;
          label365:
          localObject1 = af.dtx().sY(localSnsAdClick.dze);
          if (localObject1 == null) {
            break label693;
          }
          paramAnonymousqk = ((com.tencent.mm.plugin.sns.storage.e)localObject1).dxu().dvK;
          bool = ((com.tencent.mm.plugin.sns.storage.e)localObject1).dvv();
          localObject1 = com.tencent.mm.plugin.sns.a.b.h.a(localSnsAdClick.dze, new Object[] { localSnsAdClick, paramAnonymousqk, Integer.valueOf(localSnsAdClick.hsW), Long.valueOf(localSnsAdClick.startTime), Long.valueOf(System.currentTimeMillis()) });
          localObject1 = (String)localObject1 + String.format(",%s", new Object[] { localSnsAdClick.hta });
          localObject1 = (String)localObject1 + String.format(",%s", new Object[] { System.currentTimeMillis() - localSnsAdClick.startTime - localSnsAdClick.htc });
          if (!bool) {
            break label732;
          }
          af.dto().f(14643, new Object[] { localObject1 });
          localObject1 = com.tencent.mm.modelsns.d.oF(733);
          ((com.tencent.mm.modelsns.d)localObject1).zi(localSnsAdClick.dze).zi(paramAnonymousqk).oH(localSnsAdClick.hsW).zi(localSnsAdClick.startTime).zi(System.currentTimeMillis());
          ((com.tencent.mm.modelsns.d)localObject1).aBj();
        }
      }
    };
    this.wIh = new af.26(this);
    this.wIi = new af.27(this);
    this.wIj = new af.28(this);
    this.wIk = false;
    this.tTG = new com.tencent.mm.sdk.b.c() {};
    this.wIl = new af.31(this);
    this.wIm = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCore", "snscore create! " + Thread.currentThread().getId());
    if (this.wGR == null) {
      this.wGR = com.tencent.e.h.Iye.a("SnsCore_CDNDownload_handler", 6, 6, new LinkedBlockingQueue());
    }
    if (this.vNk == null) {
      this.vNk = com.tencent.e.h.Iye.a("SnsCore_thumbDecode_handler", 6, 6, new LinkedBlockingQueue());
    }
    if (this.wGQ == null) {
      this.wGQ = com.tencent.e.h.Iye.aNX("SnsCore#File");
    }
    if (this.wGS == null) {
      this.wGS = com.tencent.e.h.Iye.aNX("SnsCore#Task");
    }
    if ((((ActivityManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("activity")).getLargeMemoryClass() > 256) && (Build.VERSION.SDK_INT != 24)) {
      int i = Build.VERSION.SDK_INT;
    }
    AppMethodBeat.o(95798);
  }
  
  public static com.tencent.mm.storagebase.h afg()
  {
    AppMethodBeat.i(95795);
    com.tencent.mm.storagebase.h localh = dtc().gda;
    AppMethodBeat.o(95795);
    return localh;
  }
  
  public static Point cPz()
  {
    AppMethodBeat.i(95830);
    if (gxV.x == 0)
    {
      localObject = (WindowManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
      gxV.x = localDisplayMetrics.widthPixels;
      gxV.y = localDisplayMetrics.heightPixels;
    }
    Object localObject = gxV;
    AppMethodBeat.o(95830);
    return localObject;
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(95835);
    com.tencent.mm.vfs.i.aMF(((com.tencent.mm.plugin.sns.c.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.c.c.class)).getAccSnsPath());
    com.tencent.mm.vfs.i.aMF(((com.tencent.mm.plugin.sns.c.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.c.c.class)).getAccSnsTmpPath());
    com.tencent.mm.vfs.i.aMT(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.dxm());
    AppMethodBeat.o(95835);
  }
  
  public static com.tencent.mm.sdk.platformtools.ap czA()
  {
    AppMethodBeat.i(95804);
    com.tencent.mm.sdk.platformtools.ap localap = dtc().handler;
    AppMethodBeat.o(95804);
    return localap;
  }
  
  public static com.tencent.mm.sdk.platformtools.ap dhI()
  {
    AppMethodBeat.i(95799);
    if (wHD == null) {
      wHD = new com.tencent.mm.sdk.platformtools.ap("MicroMsg.SnsCore#WorkingHandler");
    }
    com.tencent.mm.sdk.platformtools.ap localap = wHD;
    AppMethodBeat.o(95799);
    return localap;
  }
  
  public static w dtA()
  {
    AppMethodBeat.i(95826);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wHd == null)
    {
      dtc().wHd = new w(dtc().gda);
      com.tencent.mm.plugin.sns.c.o.wzJ = dtc().wHd;
    }
    w localw = dtc().wHd;
    AppMethodBeat.o(95826);
    return localw;
  }
  
  public static com.tencent.mm.plugin.sns.storage.m dtB()
  {
    AppMethodBeat.i(176273);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wHe == null) {
      dtc().wHe = new com.tencent.mm.plugin.sns.storage.m(dtc().gda);
    }
    com.tencent.mm.plugin.sns.storage.m localm = dtc().wHe;
    AppMethodBeat.o(176273);
    return localm;
  }
  
  public static com.tencent.mm.plugin.sns.ui.am dtC()
  {
    AppMethodBeat.i(95827);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wHj == null) {
      dtc().wHj = new com.tencent.mm.plugin.sns.ui.am();
    }
    com.tencent.mm.plugin.sns.ui.am localam = dtc().wHj;
    AppMethodBeat.o(95827);
    return localam;
  }
  
  public static ar dtD()
  {
    AppMethodBeat.i(179093);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wHm == null) {
      dtc().wHm = new ar();
    }
    ar localar = dtc().wHm;
    AppMethodBeat.o(179093);
    return localar;
  }
  
  public static int dtE()
  {
    AppMethodBeat.i(95828);
    int i = (cPz().x - com.tencent.mm.cd.a.fromDPToPix(com.tencent.mm.sdk.platformtools.aj.getContext(), wHE)) / 3;
    wGT = i;
    if (i > wHF) {}
    for (i = wHF;; i = wGT)
    {
      wGT = i;
      if (i > 10) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCore", "can not get multiThumbDisplaySize or the multiThumbDisplaySize < 10");
      AppMethodBeat.o(95828);
      return 150;
    }
    i = wGT;
    AppMethodBeat.o(95828);
    return i;
  }
  
  public static int dtF()
  {
    AppMethodBeat.i(95829);
    if (wGU <= 0)
    {
      wGU = 200;
      wGU = com.tencent.mm.cd.a.fromDPToPix(com.tencent.mm.sdk.platformtools.aj.getContext(), wGU);
    }
    int i = wGU;
    AppMethodBeat.o(95829);
    return i;
  }
  
  public static boolean dtG()
  {
    AppMethodBeat.i(95831);
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.aw.s(com.tencent.mm.sdk.platformtools.aj.getContext(), "sp_sns_dynswitch_stg", 4);
    boolean bool;
    if (localSharedPreferences.contains("st_sw_use_vcodec_img"))
    {
      bool = localSharedPreferences.getBoolean("st_sw_use_vcodec_img", false);
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SnsCore", "isUseVCodecImg: %b (set statically outside)", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(95831);
      return bool;
      bool = localSharedPreferences.getBoolean("sw_use_vcodec_img", false);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsCore", "isUseVCodecImg: %b", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static boolean dtH()
  {
    AppMethodBeat.i(187327);
    boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwH, false);
    AppMethodBeat.o(187327);
    return bool;
  }
  
  public static boolean dtI()
  {
    AppMethodBeat.i(187328);
    boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwG, false);
    AppMethodBeat.o(187328);
    return bool;
  }
  
  public static boolean dtJ()
  {
    AppMethodBeat.i(95832);
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.aw.s(com.tencent.mm.sdk.platformtools.aj.getContext(), "sp_sns_dynswitch_stg", 4);
    boolean bool;
    if (localSharedPreferences.contains("st_sw_use_wxpc_img"))
    {
      bool = localSharedPreferences.getBoolean("st_sw_use_wxpc_img", false);
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SnsCore", "isUseWxpcImg: %b (set statically outside)", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(95832);
      return bool;
      bool = localSharedPreferences.getBoolean("sw_use_wxpc_img", false);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsCore", "isUseWxpcImg: %b", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static String dtK()
  {
    AppMethodBeat.i(95839);
    if (bt.isNullOrNil(wHu))
    {
      localObject = bi.eGt().iterator();
      while (((Iterator)localObject).hasNext())
      {
        bi.a locala = (bi.a)((Iterator)localObject).next();
        if (com.tencent.mm.loader.j.b.aib().equals(locala.EWM)) {
          wHu = locala.EWN;
        }
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCore", "get filesys " + wHu);
    }
    Object localObject = bt.by(wHu, "");
    AppMethodBeat.o(95839);
    return localObject;
  }
  
  public static String dta()
  {
    AppMethodBeat.i(95793);
    com.tencent.mm.kernel.g.afC();
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(2, null);
    AppMethodBeat.o(95793);
    return str;
  }
  
  public static int dtb()
  {
    AppMethodBeat.i(95794);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz();
    int i = com.tencent.mm.kernel.a.getUin();
    AppMethodBeat.o(95794);
    return i;
  }
  
  private static af dtc()
  {
    AppMethodBeat.i(95796);
    Object localObject1 = (af)com.tencent.mm.model.t.ap(af.class);
    if (!((af)localObject1).wHs) {}
    com.tencent.mm.model.b localb;
    for (;;)
    {
      Object localObject5;
      Object localObject4;
      synchronized (((af)localObject1).wHt)
      {
        if (!((af)localObject1).wHs)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCore", "onAccInit because bug!");
          ((af)localObject1).onAccountPostReset(true);
        }
        if (!((af)localObject1).qmV) {
          break label1583;
        }
        synchronized (((af)localObject1).lock)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCore", "getCore need reset DB now " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + localObject1.hashCode());
          if (!((af)localObject1).qmV) {
            break label1580;
          }
          ((af)localObject1).wHq = false;
          localObject5 = ((af)localObject1).wHr;
          localObject4 = wHv;
          if (((z)localObject5).xjs)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TrimSnsDb", "pass hasTrim");
            if (((af)localObject1).gda != null) {
              break;
            }
            ((af)localObject1).gda = new com.tencent.mm.storagebase.h();
            com.tencent.mm.kernel.g.afC();
            localObject4 = com.tencent.mm.kernel.g.afB().cachePath;
            localObject4 = (String)localObject4 + "SnsMicroMsg.db";
            if (((af)localObject1).gda.b((String)localObject4, wHv, true)) {
              break;
            }
            localObject1 = new SQLiteException("sns db init failed");
            AppMethodBeat.o(95796);
            throw ((Throwable)localObject1);
          }
        }
      }
      com.tencent.mm.kernel.g.afC();
      if (com.tencent.mm.kernel.g.afz().aeI())
      {
        int i = bt.getInt(com.tencent.mm.m.g.Zd().getValue("AndroidCleanSnsDb"), 0);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TrimSnsDb", "pass dynamic? ".concat(String.valueOf(i)));
        if (i <= 0)
        {
          com.tencent.mm.kernel.g.afC();
          String str = com.tencent.mm.kernel.g.afB().cachePath;
          if (com.tencent.mm.vfs.i.eK(str + "SnsMicroMsg2.db.ini"))
          {
            z.aqk(str);
            com.tencent.mm.vfs.i.deleteFile(str + "SnsMicroMsg2.db.ini");
          }
          Object localObject6 = com.tencent.mm.sdk.platformtools.aj.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.eFD(), 0);
          if (bt.lZ(((SharedPreferences)localObject6).getLong("check_trim_time", 0L)) < 604800L)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TrimSnsDb", "trim sns pass because time short");
          }
          else
          {
            ((SharedPreferences)localObject6).edit().putLong("check_trim_time", bt.aGK()).commit();
            ((z)localObject5).xjs = true;
            long l1 = System.currentTimeMillis();
            i = com.tencent.mm.q.a.aac();
            if ((i == 1) || (i == 2))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TrimSnsDb", "trim sns error space dangerous");
            }
            else if (com.tencent.mm.vfs.i.eK(str + "sns_mark.ini"))
            {
              if (bt.vM(com.tencent.mm.vfs.i.aMO(str + "sns_mark.ini")) < 2592000000L)
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TrimSnsDb", "mark file exist and return");
                z.aqk(str);
              }
              else
              {
                com.tencent.mm.vfs.i.deleteFile(str + "sns_mark.ini");
              }
            }
            else
            {
              long l2 = com.tencent.mm.vfs.i.aMN(str + "SnsMicroMsg.db");
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TrimSnsDb", "trim sns ".concat(String.valueOf(l2)));
              if (l2 < 52428800L)
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TrimSnsDb", "trim sns free pass: " + (System.currentTimeMillis() - l1));
              }
              else
              {
                com.tencent.mm.vfs.i.aMR(str + "sns_mark.ini");
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
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TrimSnsDb", "copysns insert all %d passed ret:".concat(String.valueOf(i)), new Object[] { Long.valueOf(l3) });
                  ((com.tencent.mm.storagebase.h)localObject6).closeDB();
                  ((com.tencent.mm.storagebase.h)localObject5).closeDB();
                  if (i >= 0)
                  {
                    com.tencent.mm.kernel.g.afC();
                    localObject4 = com.tencent.mm.kernel.g.afB().cachePath;
                    com.tencent.mm.vfs.i.deleteFile((String)localObject4 + "SnsMicroMsg.db");
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TrimSnsDb", "rename file ".concat(String.valueOf(com.tencent.mm.vfs.i.aQ((String)localObject4, "SnsMicroMsg2.db", "SnsMicroMsg.db"))));
                    com.tencent.mm.vfs.i.deleteFile((String)localObject4 + "SnsMicroMsg.db-shm");
                    com.tencent.mm.vfs.i.deleteFile((String)localObject4 + "SnsMicroMsg.db-wal");
                    com.tencent.mm.vfs.i.deleteFile((String)localObject4 + "SnsMicroMsg.db.ini");
                    com.tencent.mm.vfs.i.lC("SnsMicroMsg2.db.ini", "SnsMicroMsg.db.ini");
                    com.tencent.mm.vfs.i.deleteFile((String)localObject4 + "SnsMicroMsg2.db.ini");
                    com.tencent.mm.vfs.i.deleteFile((String)localObject4 + "SnsMicroMsg2.db");
                    com.tencent.mm.vfs.i.deleteFile((String)localObject4 + "sns_mark.ini");
                  }
                  l2 = System.currentTimeMillis() - l2;
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TrimSnsDb", "copysns data ret=%d all: %d copytime %d ", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l2 - l3) });
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TrimSnsDb", "trim sns done pass: " + (System.currentTimeMillis() - l1));
                  break;
                  l3 = System.currentTimeMillis();
                  z.a((com.tencent.mm.storagebase.h)localObject6, (com.tencent.mm.storagebase.h)localObject5, "snsExtInfo3");
                  boolean bool = ((com.tencent.mm.storagebase.h)localObject5).execSQL("", "insert into " + "snsExtInfo3" + " select * from old." + "snsExtInfo3");
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TrimSnsDb", "copysns ret_ext:" + bool + " passed " + (System.currentTimeMillis() - l3));
                  z.a((com.tencent.mm.storagebase.h)localObject6, (com.tencent.mm.storagebase.h)localObject5, "SnsComment");
                  bool = ((com.tencent.mm.storagebase.h)localObject5).execSQL("", "insert into " + "SnsComment" + " select * from old." + "SnsComment");
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TrimSnsDb", "copysns ret_msg:" + bool + " passed " + (System.currentTimeMillis() - l3));
                  z.a((com.tencent.mm.storagebase.h)localObject6, (com.tencent.mm.storagebase.h)localObject5, "SnsInfo");
                  bool = ((com.tencent.mm.storagebase.h)localObject5).execSQL("", "insert into " + "SnsInfo" + " select * from old." + "SnsInfo" + " where  (sourceType & 2 != 0 ) " + com.tencent.mm.plugin.sns.storage.q.xiR + " limit 200");
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TrimSnsDb", "copysns ret_sns:" + bool + " passed " + (System.currentTimeMillis() - l3));
                  bool = ((com.tencent.mm.storagebase.h)localObject5).execSQL("", "update snsExtinfo3 set md5 = '', faults = '';");
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TrimSnsDb", "update ext info  passed  %s  updateRet %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l3), Boolean.valueOf(bool) });
                  ((com.tencent.mm.storagebase.h)localObject5).execSQL("", "DETACH DATABASE old");
                }
              }
            }
          }
        }
      }
    }
    localb.qmV = false;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCore", "resetdb done");
    label1580:
    label1583:
    AppMethodBeat.o(95796);
    return localb;
  }
  
  public static boolean dtd()
  {
    AppMethodBeat.i(95797);
    dtc();
    if (!com.tencent.mm.kernel.g.afz().aeI())
    {
      AppMethodBeat.o(95797);
      return true;
    }
    AppMethodBeat.o(95797);
    return false;
  }
  
  public static ExecutorService dte()
  {
    AppMethodBeat.i(179089);
    ExecutorService localExecutorService = dtc().wGR;
    AppMethodBeat.o(179089);
    return localExecutorService;
  }
  
  public static ExecutorService dtf()
  {
    AppMethodBeat.i(179090);
    ExecutorService localExecutorService = dtc().vNk;
    AppMethodBeat.o(179090);
    return localExecutorService;
  }
  
  protected static ExecutorService dtg()
  {
    AppMethodBeat.i(179091);
    ExecutorService localExecutorService = dtc().wGQ;
    AppMethodBeat.o(179091);
    return localExecutorService;
  }
  
  public static ExecutorService dth()
  {
    AppMethodBeat.i(179092);
    ExecutorService localExecutorService = dtc().wGS;
    AppMethodBeat.o(179092);
    return localExecutorService;
  }
  
  public static bg dti()
  {
    AppMethodBeat.i(95808);
    com.tencent.mm.kernel.g.afC();
    bg localbg = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM();
    AppMethodBeat.o(95808);
    return localbg;
  }
  
  public static u dtj()
  {
    AppMethodBeat.i(95809);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wGV == null) {
      dtc().wGV = new u(dtc().gda);
    }
    u localu = dtc().wGV;
    AppMethodBeat.o(95809);
    return localu;
  }
  
  public static am.a dtk()
  {
    AppMethodBeat.i(95810);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wHg == null)
    {
      dtc().wHg = new am.a();
      com.tencent.mm.plugin.sns.c.o.wzL = dtc().wHg;
    }
    am.a locala = dtc().wHg;
    AppMethodBeat.o(95810);
    return locala;
  }
  
  public static com.tencent.mm.plugin.sns.i.c dtl()
  {
    AppMethodBeat.i(95811);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wHk == null) {
      dtc().wHk = new com.tencent.mm.plugin.sns.i.c();
    }
    com.tencent.mm.plugin.sns.i.c localc = dtc().wHk;
    AppMethodBeat.o(95811);
    return localc;
  }
  
  public static com.tencent.mm.plugin.sns.i.g dtm()
  {
    AppMethodBeat.i(95812);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wHl == null) {
      dtc().wHl = new com.tencent.mm.plugin.sns.i.g();
    }
    com.tencent.mm.plugin.sns.i.g localg = dtc().wHl;
    AppMethodBeat.o(95812);
    return localg;
  }
  
  public static s dtn()
  {
    AppMethodBeat.i(95813);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wHn == null) {
      dtc().wHn = new s(dtc().gda);
    }
    s locals = dtc().wHn;
    AppMethodBeat.o(95813);
    return locals;
  }
  
  public static com.tencent.mm.plugin.sns.a.b.k dto()
  {
    AppMethodBeat.i(95814);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wHo == null) {
      dtc().wHo = new com.tencent.mm.plugin.sns.a.b.k();
    }
    com.tencent.mm.plugin.sns.a.b.k localk = dtc().wHo;
    AppMethodBeat.o(95814);
    return localk;
  }
  
  public static b dtp()
  {
    AppMethodBeat.i(95815);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wHh == null) {
      dtc().wHh = new b();
    }
    b localb = dtc().wHh;
    AppMethodBeat.o(95815);
    return localb;
  }
  
  public static az dtq()
  {
    AppMethodBeat.i(95816);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wHi == null)
    {
      dtc().wHi = new az();
      com.tencent.mm.plugin.sns.c.o.wzF = dtc().wHi;
    }
    az localaz = dtc().wHi;
    AppMethodBeat.o(95816);
    return localaz;
  }
  
  public static f dtr()
  {
    AppMethodBeat.i(95817);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wHa == null)
    {
      dtc().wHa = new f();
      com.tencent.mm.plugin.sns.c.o.wzG = dtc().wHa;
    }
    f localf = dtc().wHa;
    AppMethodBeat.o(95817);
    return localf;
  }
  
  public static au dts()
  {
    AppMethodBeat.i(95818);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wHy == null) {
      dtc().wHy = new au();
    }
    au localau = dtc().wHy;
    AppMethodBeat.o(95818);
    return localau;
  }
  
  public static ad dtt()
  {
    AppMethodBeat.i(95819);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wHf == null)
    {
      localObject = dtc();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.afC();
      ((af)localObject).wHf = new ad(com.tencent.mm.kernel.g.afB().cachePath + "snsAsyncQueue.data");
    }
    Object localObject = dtc().wHf;
    AppMethodBeat.o(95819);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.sns.storage.q dtu()
  {
    AppMethodBeat.i(95820);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wGW == null)
    {
      dtc().wGW = new com.tencent.mm.plugin.sns.storage.q(dtc().gda);
      com.tencent.mm.plugin.sns.c.o.wzM = dtc().wGW;
    }
    com.tencent.mm.plugin.sns.storage.q localq = dtc().wGW;
    AppMethodBeat.o(95820);
    return localq;
  }
  
  public static com.tencent.mm.plugin.sns.storage.d dtv()
  {
    AppMethodBeat.i(95821);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wGY == null) {
      dtc().wGY = new com.tencent.mm.plugin.sns.storage.d(dtc().gda);
    }
    com.tencent.mm.plugin.sns.storage.d locald = dtc().wGY;
    AppMethodBeat.o(95821);
    return locald;
  }
  
  public static com.tencent.mm.plugin.sns.storage.ab dtw()
  {
    AppMethodBeat.i(95822);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wGZ == null) {
      dtc().wGZ = new com.tencent.mm.plugin.sns.storage.ab(dtc().gda);
    }
    com.tencent.mm.plugin.sns.storage.ab localab = dtc().wGZ;
    AppMethodBeat.o(95822);
    return localab;
  }
  
  public static com.tencent.mm.plugin.sns.storage.f dtx()
  {
    AppMethodBeat.i(95823);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wGX == null) {
      dtc().wGX = new com.tencent.mm.plugin.sns.storage.f(dtc().gda);
    }
    com.tencent.mm.plugin.sns.storage.f localf = dtc().wGX;
    AppMethodBeat.o(95823);
    return localf;
  }
  
  public static com.tencent.mm.plugin.sns.storage.o dty()
  {
    AppMethodBeat.i(95824);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wHb == null)
    {
      dtc().wHb = new com.tencent.mm.plugin.sns.storage.o(dtc().gda, new ah());
      com.tencent.mm.plugin.sns.c.o.wzH = dtc().wHb;
    }
    com.tencent.mm.plugin.sns.storage.o localo = dtc().wHb;
    AppMethodBeat.o(95824);
    return localo;
  }
  
  public static com.tencent.mm.plugin.sns.storage.k dtz()
  {
    AppMethodBeat.i(95825);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dtc().wHc == null)
    {
      dtc().wHc = new com.tencent.mm.plugin.sns.storage.k(dtc().gda);
      com.tencent.mm.plugin.sns.c.o.wzI = dtc().wHc;
    }
    com.tencent.mm.plugin.sns.storage.k localk = dtc().wHc;
    AppMethodBeat.o(95825);
    return localk;
  }
  
  public static void f(Point paramPoint)
  {
    gxV = paramPoint;
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(95792);
    com.tencent.mm.kernel.g.afz().aeD();
    com.tencent.mm.kernel.g.afC();
    String str = com.tencent.mm.kernel.g.afB().gcW;
    AppMethodBeat.o(95792);
    return str;
  }
  
  public static String getAccSnsPath()
  {
    AppMethodBeat.i(95805);
    String str = ((com.tencent.mm.plugin.sns.c.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.c.c.class)).getAccSnsPath();
    AppMethodBeat.o(95805);
    return str;
  }
  
  public static String getAccSnsTmpPath()
  {
    AppMethodBeat.i(95806);
    String str = ((com.tencent.mm.plugin.sns.c.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.c.c.class)).getAccSnsTmpPath();
    AppMethodBeat.o(95806);
    return str;
  }
  
  public static String getSnsAdPath()
  {
    AppMethodBeat.i(95807);
    String str = ((com.tencent.mm.plugin.sns.c.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.c.c.class)).getSnsAdPath();
    AppMethodBeat.o(95807);
    return str;
  }
  
  public final void a(com.tencent.mm.model.au paramau)
  {
    AppMethodBeat.i(95837);
    t.a(paramau);
    AppMethodBeat.o(95837);
  }
  
  public final void b(com.tencent.mm.model.au paramau)
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCore", "onAccountPostReset " + Thread.currentThread().getId() + " isAccInit: " + this.wHs);
    if (this.wHs)
    {
      AppMethodBeat.o(95834);
      return;
    }
    this.wHs = true;
    this.qmV = true;
    checkDir();
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("NewYearSNSCtrl2016", this.wHz, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("NewYearSNSTips2016", this.wHA, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("NewYearSNSAmountLevelCtrl2016", this.wHB, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("SnsAd", this.wHC, true);
    com.tencent.mm.plugin.sns.c.o.wzF = dtq();
    com.tencent.mm.plugin.sns.c.o.wzG = dtr();
    com.tencent.mm.plugin.sns.c.o.wzH = dty();
    com.tencent.mm.plugin.sns.c.o.wzI = dtz();
    com.tencent.mm.plugin.sns.c.o.wzJ = dtA();
    com.tencent.mm.plugin.sns.c.o.wzL = dtk();
    com.tencent.mm.plugin.sns.c.o.wzK = this;
    com.tencent.mm.plugin.sns.c.o.wzM = dtu();
    com.tencent.mm.sdk.b.a.ESL.c(this.wIi);
    com.tencent.mm.sdk.b.a.ESL.c(this.wIj);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHV);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHT);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHU);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHW);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHX);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHY);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHZ);
    com.tencent.mm.sdk.b.a.ESL.c(this.wIa);
    com.tencent.mm.sdk.b.a.ESL.c(this.wIc);
    com.tencent.mm.sdk.b.a.ESL.c(this.wId);
    com.tencent.mm.sdk.b.a.ESL.c(this.wIe);
    com.tencent.mm.sdk.b.a.ESL.c(this.wIm);
    appForegroundListener.alive();
    this.wHG = new n();
    this.wHH = new com.tencent.mm.plugin.sns.k();
    this.wHI = new com.tencent.mm.plugin.sns.e();
    this.wHJ = new com.tencent.mm.plugin.sns.q();
    this.wHK = new com.tencent.mm.plugin.sns.h();
    this.wHL = new com.tencent.mm.plugin.sns.g();
    this.wHM = new com.tencent.mm.plugin.sns.m();
    this.wHN = new com.tencent.mm.plugin.sns.j();
    this.wHO = new com.tencent.mm.plugin.sns.b();
    this.wHP = new com.tencent.mm.plugin.sns.c();
    this.wHQ = new com.tencent.mm.plugin.sns.f();
    com.tencent.mm.sdk.b.a.ESL.c(this.wIh);
    com.tencent.mm.sdk.b.a.ESL.c(this.wIg);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHJ);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHG);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHH);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHI);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHK);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHL);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHM);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHN);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHO);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHP);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHQ);
    com.tencent.mm.sdk.b.a.ESL.c(this.tTG);
    this.wHw = new com.tencent.mm.plugin.sns.d();
    com.tencent.mm.sdk.b.a.ESL.c(this.wHw);
    com.tencent.mm.sdk.b.a.ESL.c(this.wIl);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHR);
    com.tencent.mm.sdk.b.a.ESL.c(this.wHS);
    com.tencent.mm.sdk.b.a.ESL.c(this.wIf);
    com.tencent.mm.sdk.b.a.ESL.c(this.wIb);
    Object localObject1 = dto();
    com.tencent.mm.plugin.sns.a.b.k.wyB = com.tencent.mm.m.g.Zd().getInt("MMUxAdLog2GSendSize", 20480);
    com.tencent.mm.plugin.sns.a.b.k.wyC = com.tencent.mm.m.g.Zd().getInt("MMUxAdLog3GSendSize", 30720);
    com.tencent.mm.plugin.sns.a.b.k.wyD = com.tencent.mm.m.g.Zd().getInt("MMUxAdLogWifiSendSize", 51200);
    com.tencent.mm.plugin.sns.a.b.k.wyE = com.tencent.mm.m.g.Zd().getInt("MMUxAdLogMinRandTime", 60);
    com.tencent.mm.plugin.sns.a.b.k.wyF = com.tencent.mm.m.g.Zd().getInt("MMUxAdLogMaxRandTime", 1800);
    com.tencent.mm.plugin.sns.a.b.k.wyG = com.tencent.mm.m.g.Zd().getInt("MMUxAdLogMaxExceptionTime", 43200);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsLogMgr", "init " + com.tencent.mm.plugin.sns.a.b.k.wyB + ";" + com.tencent.mm.plugin.sns.a.b.k.wyC + ";" + com.tencent.mm.plugin.sns.a.b.k.wyD + ";" + com.tencent.mm.plugin.sns.a.b.k.wyE + ";" + com.tencent.mm.plugin.sns.a.b.k.wyF + ";" + com.tencent.mm.plugin.sns.a.b.k.wyG);
    if (com.tencent.mm.plugin.sns.a.b.k.wyF - com.tencent.mm.plugin.sns.a.b.k.wyE < 0) {
      com.tencent.mm.plugin.sns.a.b.k.wyF = com.tencent.mm.plugin.sns.a.b.k.wyE;
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1802, (com.tencent.mm.al.g)localObject1);
    localObject1 = dtq();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(207, (com.tencent.mm.al.g)localObject1);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(209, (com.tencent.mm.al.g)localObject1);
    localObject1 = this.wHp;
    com.tencent.mm.sdk.b.a.ESL.c(((ao)localObject1).wJc);
    com.tencent.mm.sdk.b.a.ESL.c(((ao)localObject1).wJd);
    com.tencent.mm.sdk.b.a.ESL.c(((ao)localObject1).wJe);
    this.wHx = new com.tencent.mm.plugin.sns.h.a();
    ap.init();
    localObject1 = com.tencent.mm.modelsns.e.htu;
    com.tencent.mm.modelsns.e.aBk();
    if (com.tencent.mm.memory.l.apa())
    {
      localObject1 = com.tencent.mm.memory.c.gDM;
      localObject2 = com.tencent.mm.memory.c.gDM;
      localObject2.getClass();
      ((com.tencent.mm.memory.c)localObject1).a(new e.a((com.tencent.mm.memory.c)localObject2)
      {
        final int wIn;
        
        public final long aoV()
        {
          return 10485760L;
        }
        
        public final int aoW()
        {
          return -1;
        }
      });
    }
    localObject1 = com.tencent.mm.memory.o.gEi;
    Object localObject2 = com.tencent.mm.memory.o.gEi;
    localObject2.getClass();
    ((com.tencent.mm.memory.o)localObject1).a(new e.a((com.tencent.mm.memory.o)localObject2)
    {
      public final long aoV()
      {
        return -1L;
      }
      
      public final int aoW()
      {
        return 3;
      }
    });
    localObject1 = com.tencent.mm.memory.g.gDT;
    localObject2 = com.tencent.mm.memory.g.gDT;
    localObject2.getClass();
    ((com.tencent.mm.memory.g)localObject1).a(new e.a((com.tencent.mm.memory.g)localObject2)
    {
      public final long aoV()
      {
        return 0L;
      }
      
      public final int aoW()
      {
        return 5;
      }
    });
    dts();
    com.tencent.mm.plugin.sns.g.a.init();
    try
    {
      localObject1 = ax.aFC("TrackDataSource");
      if (!bt.isNullOrNil(((ax)localObject1).getString("path", "")))
      {
        com.tencent.mm.plugin.report.service.h.vKh.dB(150, 74);
        com.tencent.mm.plugin.report.service.h.vKh.f(17832, new Object[] { Integer.valueOf(((ax)localObject1).getInt("type", 0)), ((ax)localObject1).getString("path", ""), Long.valueOf(((ax)localObject1).getLong("ts", 0L)), ((ax)localObject1).getString("media-url", ""), ((ax)localObject1).getString("thumb-url", ""), Long.valueOf(((ax)localObject1).getLong("prepare-ts", 0L)), ((ax)localObject1).getString("prepare-path", "") });
        ((ax)localObject1).putInt("type", 0);
        ((ax)localObject1).putString("path", "");
        ((ax)localObject1).putLong("ts", 0L);
        ((ax)localObject1).putString("media-url", "");
        ((ax)localObject1).putString("thumb-url", "");
        ((ax)localObject1).putLong("prepare-ts", 0L);
        ((ax)localObject1).commit();
      }
      AppMethodBeat.o(95834);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SnsCore", localThrowable, "videoCrashKvReport", new Object[0]);
      AppMethodBeat.o(95834);
    }
  }
  
  /* Error */
  public final void onAccountRelease()
  {
    // Byte code:
    //   0: ldc_w 1733
    //   3: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 1545	com/tencent/mm/plugin/sns/model/af:dto	()Lcom/tencent/mm/plugin/sns/a/b/k;
    //   9: astore_1
    //   10: invokestatic 977	com/tencent/mm/kernel/g:afC	()Lcom/tencent/mm/kernel/g;
    //   13: pop
    //   14: invokestatic 1588	com/tencent/mm/kernel/g:afA	()Lcom/tencent/mm/kernel/b;
    //   17: getfield 1594	com/tencent/mm/kernel/b:gcy	Lcom/tencent/mm/al/q;
    //   20: sipush 1802
    //   23: aload_1
    //   24: invokevirtual 1735	com/tencent/mm/al/q:b	(ILcom/tencent/mm/al/g;)V
    //   27: aload_0
    //   28: getfield 323	com/tencent/mm/plugin/sns/model/af:wHp	Lcom/tencent/mm/plugin/sns/model/ao;
    //   31: astore_1
    //   32: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   35: aload_1
    //   36: getfield 1602	com/tencent/mm/plugin/sns/model/ao:wJc	Lcom/tencent/mm/sdk/b/c;
    //   39: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   42: pop
    //   43: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   46: aload_1
    //   47: getfield 1605	com/tencent/mm/plugin/sns/model/ao:wJd	Lcom/tencent/mm/sdk/b/c;
    //   50: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   53: pop
    //   54: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   57: aload_1
    //   58: getfield 1608	com/tencent/mm/plugin/sns/model/ao:wJe	Lcom/tencent/mm/sdk/b/c;
    //   61: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   64: pop
    //   65: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   68: aload_0
    //   69: getfield 434	com/tencent/mm/plugin/sns/model/af:wIi	Lcom/tencent/mm/sdk/b/c;
    //   72: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   75: pop
    //   76: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   79: aload_0
    //   80: getfield 439	com/tencent/mm/plugin/sns/model/af:wIj	Lcom/tencent/mm/sdk/b/c;
    //   83: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   86: pop
    //   87: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   90: aload_0
    //   91: getfield 429	com/tencent/mm/plugin/sns/model/af:wIh	Lcom/tencent/mm/sdk/b/c;
    //   94: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   97: pop
    //   98: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   101: aload_0
    //   102: getfield 424	com/tencent/mm/plugin/sns/model/af:wIg	Lcom/tencent/mm/sdk/b/c;
    //   105: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   108: pop
    //   109: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   112: aload_0
    //   113: getfield 385	com/tencent/mm/plugin/sns/model/af:wHV	Lcom/tencent/mm/sdk/b/c;
    //   116: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   119: pop
    //   120: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   123: aload_0
    //   124: getfield 375	com/tencent/mm/plugin/sns/model/af:wHT	Lcom/tencent/mm/sdk/b/c;
    //   127: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   130: pop
    //   131: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   134: aload_0
    //   135: getfield 380	com/tencent/mm/plugin/sns/model/af:wHU	Lcom/tencent/mm/sdk/b/c;
    //   138: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   141: pop
    //   142: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   145: aload_0
    //   146: getfield 388	com/tencent/mm/plugin/sns/model/af:wHW	Lcom/tencent/mm/sdk/b/c;
    //   149: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   152: pop
    //   153: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   156: aload_0
    //   157: getfield 391	com/tencent/mm/plugin/sns/model/af:wHX	Lcom/tencent/mm/sdk/b/c;
    //   160: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   163: pop
    //   164: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   167: aload_0
    //   168: getfield 394	com/tencent/mm/plugin/sns/model/af:wHY	Lcom/tencent/mm/sdk/b/c;
    //   171: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   174: pop
    //   175: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   178: aload_0
    //   179: getfield 1503	com/tencent/mm/plugin/sns/model/af:wHJ	Lcom/tencent/mm/plugin/sns/q;
    //   182: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   185: pop
    //   186: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   189: aload_0
    //   190: getfield 1508	com/tencent/mm/plugin/sns/model/af:wHK	Lcom/tencent/mm/plugin/sns/h;
    //   193: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   196: pop
    //   197: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   200: aload_0
    //   201: getfield 402	com/tencent/mm/plugin/sns/model/af:wIa	Lcom/tencent/mm/sdk/b/c;
    //   204: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   207: pop
    //   208: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   211: aload_0
    //   212: getfield 410	com/tencent/mm/plugin/sns/model/af:wIc	Lcom/tencent/mm/sdk/b/c;
    //   215: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   218: pop
    //   219: getstatic 299	com/tencent/mm/plugin/sns/model/af:appForegroundListener	Lcom/tencent/mm/app/n$a;
    //   222: invokevirtual 1740	com/tencent/mm/app/n$a:dead	()V
    //   225: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   228: aload_0
    //   229: getfield 1488	com/tencent/mm/plugin/sns/model/af:wHG	Lcom/tencent/mm/plugin/sns/n;
    //   232: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   235: pop
    //   236: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   239: aload_0
    //   240: getfield 1493	com/tencent/mm/plugin/sns/model/af:wHH	Lcom/tencent/mm/plugin/sns/k;
    //   243: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   246: pop
    //   247: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   250: aload_0
    //   251: getfield 1498	com/tencent/mm/plugin/sns/model/af:wHI	Lcom/tencent/mm/plugin/sns/e;
    //   254: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   257: pop
    //   258: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   261: aload_0
    //   262: getfield 1513	com/tencent/mm/plugin/sns/model/af:wHL	Lcom/tencent/mm/plugin/sns/g;
    //   265: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   268: pop
    //   269: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   272: aload_0
    //   273: getfield 1518	com/tencent/mm/plugin/sns/model/af:wHM	Lcom/tencent/mm/plugin/sns/m;
    //   276: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   279: pop
    //   280: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   283: aload_0
    //   284: getfield 1523	com/tencent/mm/plugin/sns/model/af:wHN	Lcom/tencent/mm/plugin/sns/j;
    //   287: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   290: pop
    //   291: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   294: aload_0
    //   295: getfield 1528	com/tencent/mm/plugin/sns/model/af:wHO	Lcom/tencent/mm/plugin/sns/b;
    //   298: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   301: pop
    //   302: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   305: aload_0
    //   306: getfield 1533	com/tencent/mm/plugin/sns/model/af:wHP	Lcom/tencent/mm/plugin/sns/c;
    //   309: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   312: pop
    //   313: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   316: aload_0
    //   317: getfield 1538	com/tencent/mm/plugin/sns/model/af:wHQ	Lcom/tencent/mm/plugin/sns/f;
    //   320: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   323: pop
    //   324: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   327: aload_0
    //   328: getfield 399	com/tencent/mm/plugin/sns/model/af:wHZ	Lcom/tencent/mm/sdk/b/c;
    //   331: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   334: pop
    //   335: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   338: aload_0
    //   339: getfield 1543	com/tencent/mm/plugin/sns/model/af:wHw	Lcom/tencent/mm/plugin/sns/d;
    //   342: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   345: pop
    //   346: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   349: aload_0
    //   350: getfield 415	com/tencent/mm/plugin/sns/model/af:wId	Lcom/tencent/mm/sdk/b/c;
    //   353: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   356: pop
    //   357: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   360: aload_0
    //   361: getfield 418	com/tencent/mm/plugin/sns/model/af:wIe	Lcom/tencent/mm/sdk/b/c;
    //   364: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   367: pop
    //   368: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   371: aload_0
    //   372: getfield 444	com/tencent/mm/plugin/sns/model/af:tTG	Lcom/tencent/mm/sdk/b/c;
    //   375: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   378: pop
    //   379: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   382: aload_0
    //   383: getfield 449	com/tencent/mm/plugin/sns/model/af:wIl	Lcom/tencent/mm/sdk/b/c;
    //   386: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   389: pop
    //   390: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   393: aload_0
    //   394: getfield 421	com/tencent/mm/plugin/sns/model/af:wIf	Lcom/tencent/mm/sdk/b/c;
    //   397: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   400: pop
    //   401: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   404: aload_0
    //   405: getfield 365	com/tencent/mm/plugin/sns/model/af:wHR	Lcom/tencent/mm/sdk/b/c;
    //   408: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   411: pop
    //   412: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   415: aload_0
    //   416: getfield 370	com/tencent/mm/plugin/sns/model/af:wHS	Lcom/tencent/mm/sdk/b/c;
    //   419: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   422: pop
    //   423: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   426: aload_0
    //   427: getfield 452	com/tencent/mm/plugin/sns/model/af:wIm	Lcom/tencent/mm/sdk/b/c;
    //   430: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   433: pop
    //   434: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   437: aload_0
    //   438: getfield 405	com/tencent/mm/plugin/sns/model/af:wIb	Lcom/tencent/mm/sdk/b/c;
    //   441: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   444: pop
    //   445: getstatic 1746	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a$e:wUX	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a;
    //   448: astore_1
    //   449: aload_1
    //   450: getfield 1751	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:wUQ	Z
    //   453: ifeq +27 -> 480
    //   456: ldc_w 1753
    //   459: ldc_w 1755
    //   462: invokestatic 1757	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: invokestatic 230	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   468: aload_1
    //   469: getfield 1761	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:wUP	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a$a;
    //   472: invokevirtual 1765	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   475: aload_1
    //   476: iconst_0
    //   477: putfield 1751	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:wUQ	Z
    //   480: invokestatic 1771	com/tencent/mm/plugin/downloader/model/f:bQt	()Lcom/tencent/mm/plugin/downloader/model/f;
    //   483: pop
    //   484: aload_1
    //   485: getfield 1775	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:wUU	Lcom/tencent/mm/plugin/downloader/model/m;
    //   488: invokestatic 1780	com/tencent/mm/plugin/downloader/model/c:b	(Lcom/tencent/mm/plugin/downloader/model/m;)V
    //   491: ldc_w 1437
    //   494: invokestatic 667	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   497: checkcast 1437	com/tencent/mm/plugin/messenger/foundation/a/q
    //   500: invokeinterface 1441 1 0
    //   505: ldc_w 1443
    //   508: aload_0
    //   509: getfield 343	com/tencent/mm/plugin/sns/model/af:wHz	Lcom/tencent/mm/plugin/sns/lucky/a/f;
    //   512: iconst_1
    //   513: invokevirtual 1782	com/tencent/mm/model/cc:b	(Ljava/lang/String;Lcom/tencent/mm/model/cc$a;Z)V
    //   516: ldc_w 1437
    //   519: invokestatic 667	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   522: checkcast 1437	com/tencent/mm/plugin/messenger/foundation/a/q
    //   525: invokeinterface 1441 1 0
    //   530: ldc_w 1450
    //   533: aload_0
    //   534: getfield 348	com/tencent/mm/plugin/sns/model/af:wHA	Lcom/tencent/mm/plugin/sns/lucky/a/j;
    //   537: iconst_1
    //   538: invokevirtual 1782	com/tencent/mm/model/cc:b	(Ljava/lang/String;Lcom/tencent/mm/model/cc$a;Z)V
    //   541: ldc_w 1437
    //   544: invokestatic 667	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   547: checkcast 1437	com/tencent/mm/plugin/messenger/foundation/a/q
    //   550: invokeinterface 1441 1 0
    //   555: ldc_w 1452
    //   558: aload_0
    //   559: getfield 353	com/tencent/mm/plugin/sns/model/af:wHB	Lcom/tencent/mm/plugin/sns/lucky/a/d;
    //   562: iconst_1
    //   563: invokevirtual 1782	com/tencent/mm/model/cc:b	(Ljava/lang/String;Lcom/tencent/mm/model/cc$a;Z)V
    //   566: ldc_w 1437
    //   569: invokestatic 667	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   572: checkcast 1437	com/tencent/mm/plugin/messenger/foundation/a/q
    //   575: invokeinterface 1441 1 0
    //   580: ldc_w 1454
    //   583: aload_0
    //   584: getfield 358	com/tencent/mm/plugin/sns/model/af:wHC	Lcom/tencent/mm/plugin/sns/lucky/a/l;
    //   587: iconst_1
    //   588: invokevirtual 1782	com/tencent/mm/model/cc:b	(Ljava/lang/String;Lcom/tencent/mm/model/cc$a;Z)V
    //   591: invokestatic 1456	com/tencent/mm/plugin/sns/model/af:dtq	()Lcom/tencent/mm/plugin/sns/model/az;
    //   594: astore_1
    //   595: invokestatic 977	com/tencent/mm/kernel/g:afC	()Lcom/tencent/mm/kernel/g;
    //   598: pop
    //   599: invokestatic 1588	com/tencent/mm/kernel/g:afA	()Lcom/tencent/mm/kernel/b;
    //   602: getfield 1594	com/tencent/mm/kernel/b:gcy	Lcom/tencent/mm/al/q;
    //   605: sipush 207
    //   608: aload_1
    //   609: invokevirtual 1735	com/tencent/mm/al/q:b	(ILcom/tencent/mm/al/g;)V
    //   612: invokestatic 977	com/tencent/mm/kernel/g:afC	()Lcom/tencent/mm/kernel/g;
    //   615: pop
    //   616: invokestatic 1588	com/tencent/mm/kernel/g:afA	()Lcom/tencent/mm/kernel/b;
    //   619: getfield 1594	com/tencent/mm/kernel/b:gcy	Lcom/tencent/mm/al/q;
    //   622: sipush 209
    //   625: aload_1
    //   626: invokevirtual 1735	com/tencent/mm/al/q:b	(ILcom/tencent/mm/al/g;)V
    //   629: ldc 2
    //   631: invokestatic 1005	com/tencent/mm/model/t:ap	(Ljava/lang/Class;)Lcom/tencent/mm/model/aw;
    //   634: checkcast 2	com/tencent/mm/plugin/sns/model/af
    //   637: astore_1
    //   638: aload_1
    //   639: ifnull +99 -> 738
    //   642: ldc_w 454
    //   645: ldc_w 1784
    //   648: invokestatic 1786	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   651: aload_1
    //   652: getfield 554	com/tencent/mm/plugin/sns/model/af:gda	Lcom/tencent/mm/storagebase/h;
    //   655: ifnull +15 -> 670
    //   658: aload_1
    //   659: getfield 554	com/tencent/mm/plugin/sns/model/af:gda	Lcom/tencent/mm/storagebase/h;
    //   662: invokevirtual 1157	com/tencent/mm/storagebase/h:closeDB	()V
    //   665: aload_1
    //   666: aconst_null
    //   667: putfield 554	com/tencent/mm/plugin/sns/model/af:gda	Lcom/tencent/mm/storagebase/h;
    //   670: aload_1
    //   671: getfield 486	com/tencent/mm/plugin/sns/model/af:wGR	Ljava/util/concurrent/ExecutorService;
    //   674: ifnull +13 -> 687
    //   677: aload_1
    //   678: getfield 486	com/tencent/mm/plugin/sns/model/af:wGR	Ljava/util/concurrent/ExecutorService;
    //   681: invokeinterface 1790 1 0
    //   686: pop
    //   687: aload_1
    //   688: getfield 505	com/tencent/mm/plugin/sns/model/af:vNk	Ljava/util/concurrent/ExecutorService;
    //   691: ifnull +13 -> 704
    //   694: aload_1
    //   695: getfield 505	com/tencent/mm/plugin/sns/model/af:vNk	Ljava/util/concurrent/ExecutorService;
    //   698: invokeinterface 1790 1 0
    //   703: pop
    //   704: aload_1
    //   705: getfield 509	com/tencent/mm/plugin/sns/model/af:wGQ	Ljava/util/concurrent/ExecutorService;
    //   708: ifnull +13 -> 721
    //   711: aload_1
    //   712: getfield 509	com/tencent/mm/plugin/sns/model/af:wGQ	Ljava/util/concurrent/ExecutorService;
    //   715: invokeinterface 1790 1 0
    //   720: pop
    //   721: aload_1
    //   722: getfield 517	com/tencent/mm/plugin/sns/model/af:wGS	Ljava/util/concurrent/ExecutorService;
    //   725: ifnull +13 -> 738
    //   728: aload_1
    //   729: getfield 517	com/tencent/mm/plugin/sns/model/af:wGS	Ljava/util/concurrent/ExecutorService;
    //   732: invokeinterface 1790 1 0
    //   737: pop
    //   738: aload_0
    //   739: getfield 1613	com/tencent/mm/plugin/sns/model/af:wHx	Lcom/tencent/mm/plugin/sns/h/a;
    //   742: astore_1
    //   743: invokestatic 1792	com/tencent/mm/plugin/sns/model/af:dtp	()Lcom/tencent/mm/plugin/sns/model/b;
    //   746: aload_1
    //   747: invokevirtual 1795	com/tencent/mm/plugin/sns/model/b:b	(Lcom/tencent/mm/plugin/sns/model/b$b;)V
    //   750: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   753: aload_1
    //   754: getfield 1798	com/tencent/mm/plugin/sns/h/a:wBV	Lcom/tencent/mm/sdk/b/c;
    //   757: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   760: pop
    //   761: invokestatic 1801	com/tencent/mm/plugin/sns/model/ap:NX	()V
    //   764: getstatic 1664	com/tencent/mm/memory/g:gDT	Lcom/tencent/mm/memory/g;
    //   767: invokevirtual 1804	com/tencent/mm/memory/g:aoS	()V
    //   770: getstatic 1638	com/tencent/mm/memory/c:gDM	Lcom/tencent/mm/memory/c;
    //   773: invokevirtual 1805	com/tencent/mm/memory/c:aoS	()V
    //   776: getstatic 1654	com/tencent/mm/memory/o:gEi	Lcom/tencent/mm/memory/o;
    //   779: invokevirtual 1806	com/tencent/mm/memory/o:aoS	()V
    //   782: invokestatic 1670	com/tencent/mm/plugin/sns/model/af:dts	()Lcom/tencent/mm/plugin/sns/model/au;
    //   785: astore_1
    //   786: aload_1
    //   787: aconst_null
    //   788: putfield 1810	com/tencent/mm/plugin/sns/model/au:wKl	Lcom/tencent/mm/plugin/sns/model/bb;
    //   791: aload_1
    //   792: getfield 1814	com/tencent/mm/plugin/sns/model/au:wKo	Ljava/util/LinkedList;
    //   795: astore_2
    //   796: aload_2
    //   797: monitorenter
    //   798: aload_1
    //   799: getfield 1814	com/tencent/mm/plugin/sns/model/au:wKo	Ljava/util/LinkedList;
    //   802: invokevirtual 1819	java/util/LinkedList:clear	()V
    //   805: aload_2
    //   806: monitorexit
    //   807: aload_1
    //   808: getfield 1823	com/tencent/mm/plugin/sns/model/au:wKn	Ljava/util/Map;
    //   811: invokeinterface 1826 1 0
    //   816: aload_1
    //   817: getfield 1829	com/tencent/mm/plugin/sns/model/au:wKm	Ljava/util/LinkedList;
    //   820: invokevirtual 1819	java/util/LinkedList:clear	()V
    //   823: aload_1
    //   824: getfield 1832	com/tencent/mm/plugin/sns/model/au:qYh	Ljava/util/LinkedList;
    //   827: astore_2
    //   828: aload_2
    //   829: monitorenter
    //   830: aload_1
    //   831: getfield 1832	com/tencent/mm/plugin/sns/model/au:qYh	Ljava/util/LinkedList;
    //   834: invokevirtual 1819	java/util/LinkedList:clear	()V
    //   837: aload_2
    //   838: monitorexit
    //   839: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   842: aload_1
    //   843: getfield 1835	com/tencent/mm/plugin/sns/model/au:wKr	Lcom/tencent/mm/sdk/b/c;
    //   846: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   849: pop
    //   850: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   853: aload_1
    //   854: getfield 1836	com/tencent/mm/plugin/sns/model/au:wJd	Lcom/tencent/mm/sdk/b/c;
    //   857: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   860: pop
    //   861: getstatic 1474	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   864: aload_1
    //   865: getfield 1837	com/tencent/mm/plugin/sns/model/au:wJe	Lcom/tencent/mm/sdk/b/c;
    //   868: invokevirtual 1737	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   871: pop
    //   872: invokestatic 1840	com/tencent/mm/plugin/sns/g/a:destroy	()V
    //   875: ldc_w 1733
    //   878: invokestatic 302	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   881: return
    //   882: astore_2
    //   883: ldc_w 1753
    //   886: ldc_w 1842
    //   889: iconst_1
    //   890: anewarray 4	java/lang/Object
    //   893: dup
    //   894: iconst_0
    //   895: aload_2
    //   896: invokevirtual 1845	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   899: aastore
    //   900: invokestatic 1847	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   903: goto -423 -> 480
    //   906: astore_1
    //   907: aload_2
    //   908: monitorexit
    //   909: ldc_w 1733
    //   912: invokestatic 302	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   915: aload_1
    //   916: athrow
    //   917: astore_1
    //   918: aload_2
    //   919: monitorexit
    //   920: ldc_w 1733
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