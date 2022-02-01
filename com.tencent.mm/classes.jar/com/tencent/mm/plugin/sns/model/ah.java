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
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.bv;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qx.a;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qy.a;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.g.a.rf.a;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.g.a.xd;
import com.tencent.mm.memory.e.a;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.n;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.z;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bj.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h.b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public final class ah
  implements az, com.tencent.mm.plugin.sns.b.k
{
  private static o.a appForegroundListener;
  private static Point htn;
  private static String zAZ;
  public static boolean zAr;
  private static int zAs;
  private static int zAt;
  private static int zAx;
  private static int zAy;
  protected static HashMap<Integer, h.b> zBa;
  private static com.tencent.mm.sdk.platformtools.aq zBi;
  private static int zBj;
  private static int zBk;
  private com.tencent.mm.storagebase.h gDX;
  private com.tencent.mm.sdk.platformtools.aq handler;
  private byte[] lock;
  private boolean rNZ;
  private com.tencent.mm.sdk.b.c wxo;
  private ExecutorService yBp;
  private com.tencent.mm.plugin.sns.storage.q zAA;
  private com.tencent.mm.plugin.sns.storage.f zAB;
  private com.tencent.mm.plugin.sns.storage.d zAC;
  private ab zAD;
  private g zAE;
  private com.tencent.mm.plugin.sns.storage.o zAF;
  private com.tencent.mm.plugin.sns.storage.k zAG;
  private w zAH;
  private com.tencent.mm.plugin.sns.storage.m zAI;
  private af zAJ;
  private ao.a zAK;
  private c zAL;
  private bc zAM;
  private ap zAN;
  private com.tencent.mm.plugin.sns.h.c zAO;
  private com.tencent.mm.plugin.sns.h.g zAP;
  private au zAQ;
  private ar zAR;
  private com.tencent.mm.plugin.sns.storage.s zAS;
  private com.tencent.mm.plugin.sns.ad.e.l zAT;
  private aq zAU;
  private boolean zAV;
  private z zAW;
  private boolean zAX;
  private byte[] zAY;
  private ExecutorService zAu;
  private ExecutorService zAv;
  private ExecutorService zAw;
  private com.tencent.mm.plugin.sns.storage.u zAz;
  private com.tencent.mm.sdk.b.c zBA;
  private com.tencent.mm.sdk.b.c zBB;
  private com.tencent.mm.sdk.b.c zBC;
  private com.tencent.mm.sdk.b.c zBD;
  private com.tencent.mm.sdk.b.c zBE;
  private com.tencent.mm.sdk.b.c zBF;
  private com.tencent.mm.sdk.b.c zBG;
  private com.tencent.mm.sdk.b.c zBH;
  private com.tencent.mm.sdk.b.c zBI;
  private com.tencent.mm.sdk.b.c zBJ;
  private com.tencent.mm.sdk.b.c zBK;
  private com.tencent.mm.sdk.b.c zBL;
  private com.tencent.mm.sdk.b.c zBM;
  private com.tencent.mm.sdk.b.c zBN;
  private com.tencent.mm.sdk.b.c zBO;
  private boolean zBP;
  private com.tencent.mm.sdk.b.c zBQ;
  private com.tencent.mm.sdk.b.c zBR;
  private com.tencent.mm.plugin.sns.d zBb;
  private com.tencent.mm.plugin.sns.g.a zBc;
  private ax zBd;
  private com.tencent.mm.plugin.sns.lucky.a.f zBe;
  private com.tencent.mm.plugin.sns.lucky.a.j zBf;
  private com.tencent.mm.plugin.sns.lucky.a.d zBg;
  private com.tencent.mm.plugin.sns.lucky.a.l zBh;
  private n zBl;
  private com.tencent.mm.plugin.sns.k zBm;
  private com.tencent.mm.plugin.sns.e zBn;
  private com.tencent.mm.plugin.sns.q zBo;
  private com.tencent.mm.plugin.sns.h zBp;
  private com.tencent.mm.plugin.sns.g zBq;
  private com.tencent.mm.plugin.sns.m zBr;
  private com.tencent.mm.plugin.sns.j zBs;
  private com.tencent.mm.plugin.sns.b zBt;
  private com.tencent.mm.plugin.sns.c zBu;
  private com.tencent.mm.plugin.sns.f zBv;
  private com.tencent.mm.sdk.b.c zBw;
  private com.tencent.mm.sdk.b.c zBx;
  private com.tencent.mm.sdk.b.c zBy;
  private com.tencent.mm.sdk.b.c zBz;
  
  static
  {
    AppMethodBeat.i(95843);
    zAr = true;
    zAs = 0;
    zAt = 0;
    zAZ = "";
    zBa = new HashMap();
    zBj = 103;
    zBk = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 130);
    htn = new Point();
    zBa.put(Integer.valueOf("CanvasInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.d.SQL_CREATE;
      }
    });
    zBa.put(Integer.valueOf("UxCanvasInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ab.SQL_CREATE;
      }
    });
    zBa.put(Integer.valueOf("SNSMEDIA_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.u.SQL_CREATE;
      }
    });
    zBa.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.q.SQL_CREATE;
      }
    });
    zBa.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.q.SQL_CREATE;
      }
    });
    zBa.put(Integer.valueOf("ADSNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.f.SQL_CREATE;
      }
    });
    zBa.put(Integer.valueOf("SNSEXT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.o.SQL_CREATE;
      }
    });
    zBa.put(Integer.valueOf("SNSCOMMENT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.k.SQL_CREATE;
      }
    });
    zBa.put(Integer.valueOf("SNSTAGINFO_TABLE".hashCode()), new ah.38());
    zBa.put(Integer.valueOf("SNSKVREPORT_TABLE".hashCode()), new ah.2());
    zBa.put(Integer.valueOf("SNSDRAFT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.m.SQL_CREATE;
      }
    });
    appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(176255);
        if ((com.tencent.mm.kernel.g.ajM()) && (com.tencent.mm.kernel.g.ajP().gDk))
        {
          com.tencent.mm.kernel.g.ajP();
          if (!com.tencent.mm.kernel.a.aiT())
          {
            paramAnonymousString = new qw();
            paramAnonymousString.dGy.state = 0;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString);
            paramAnonymousString = new xd();
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(176255);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(176254);
        if ((com.tencent.mm.kernel.g.ajM()) && (com.tencent.mm.kernel.g.ajP().gDk))
        {
          com.tencent.mm.kernel.g.ajP();
          if (!com.tencent.mm.kernel.a.aiT())
          {
            paramAnonymousString = new qw();
            paramAnonymousString.dGy.state = 1;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(176254);
      }
    };
    AppMethodBeat.o(95843);
  }
  
  public ah()
  {
    AppMethodBeat.i(95798);
    this.handler = new com.tencent.mm.sdk.platformtools.aq(Looper.getMainLooper());
    this.zAU = new aq();
    this.rNZ = false;
    this.zAV = true;
    this.lock = new byte[0];
    this.zAW = new z();
    this.zAX = false;
    this.zAY = new byte[0];
    this.zBe = new com.tencent.mm.plugin.sns.lucky.a.f();
    this.zBf = new com.tencent.mm.plugin.sns.lucky.a.j();
    this.zBg = new com.tencent.mm.plugin.sns.lucky.a.d();
    this.zBh = new com.tencent.mm.plugin.sns.lucky.a.l();
    this.zBw = new ah.8(this);
    this.zBx = new ah.9(this);
    this.zBy = new ah.10(this);
    this.zBz = new ah.11(this);
    this.zBA = new ah.13(this);
    this.zBB = new com.tencent.mm.sdk.b.c() {};
    this.zBC = new ah.15(this);
    this.zBD = new ah.16(this);
    this.zBE = new ah.17(this);
    this.zBF = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(qx paramAnonymousqx)
      {
        AppMethodBeat.i(176263);
        try
        {
          SnsAdClick localSnsAdClick = paramAnonymousqx.dGz.dGA;
          paramAnonymousqx = ah.dXH().Ax(localSnsAdClick.dKq);
          if (paramAnonymousqx == null)
          {
            AppMethodBeat.o(176263);
            return false;
          }
          p localp = paramAnonymousqx.ebV();
          String str1;
          String str2;
          com.tencent.mm.plugin.sns.ad.e.a locala;
          if (localSnsAdClick.doj == 2)
          {
            paramAnonymousqx = localp.ebM();
            if (paramAnonymousqx == null) {
              break label434;
            }
            str1 = paramAnonymousqx.zMw;
            str2 = com.tencent.mm.plugin.sns.waid.b.aCC(str1);
            locala = new com.tencent.mm.plugin.sns.ad.e.a();
            locala.zod = com.tencent.mm.plugin.sns.data.k.k(localp);
            locala.zoe = com.tencent.mm.plugin.sns.data.k.l(localp);
            locala.zof = ((int)localSnsAdClick.ipV);
            if (localSnsAdClick.doj != 2) {
              break label267;
            }
            ae.i("MicroMsg.SnsCore", "at_friend_detail report ad click, exposureTime=" + localSnsAdClick.ipU + ", clkPos=" + localSnsAdClick.ipN + ", pkg=" + str1 + ", waid=" + str2);
            paramAnonymousqx = new com.tencent.mm.plugin.sns.ad.e.e(localSnsAdClick.dKq, paramAnonymousqx.aQj, localSnsAdClick.ipN, localSnsAdClick.ipO, localSnsAdClick.ipM, "", localp.ecA(), localp.ebP().AiG, localSnsAdClick.ipT, localp.ecy().ebT(), localp.ecy().ebU(), localSnsAdClick.ipU, str1, str2, locala);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousqx, 0);
          }
          for (;;)
          {
            AppMethodBeat.o(176263);
            return true;
            paramAnonymousqx = localp.dVi();
            break;
            label267:
            ae.i("MicroMsg.SnsCore", "report ad click, exposureTime=" + localSnsAdClick.ipU + ", clkPos=" + localSnsAdClick.ipN + ", source=" + localSnsAdClick.doj + ", pkg=" + str1 + ", waid=" + str2);
            paramAnonymousqx = new com.tencent.mm.plugin.sns.ad.e.e(localSnsAdClick.dKq, paramAnonymousqx.aQj, localSnsAdClick.ipN, localSnsAdClick.ipO, localSnsAdClick.ipM, "", localp.ecA(), localp.ebP().AiG, localSnsAdClick.ipT, localp.ecy().ebR(), localp.ecy().ebS(), localSnsAdClick.ipU, str1, str2, locala);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousqx, 0);
          }
          label434:
          return false;
        }
        catch (Exception paramAnonymousqx)
        {
          ae.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousqx, "report ad click error", new Object[0]);
          AppMethodBeat.o(176263);
        }
      }
    };
    this.zBG = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(qy paramAnonymousqy)
      {
        AppMethodBeat.i(176264);
        SnsAdClick localSnsAdClick;
        Object localObject1;
        try
        {
          localSnsAdClick = paramAnonymousqy.dGB.dGA;
          localObject1 = ah.dXH().Ax(localSnsAdClick.dKq);
          if (localObject1 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.sns.storage.e)localObject1).ebV();
            if (localSnsAdClick.doj == 2)
            {
              localObject1 = ((p)localObject2).ebM();
              if (localObject1 == null) {
                break label227;
              }
              if (localSnsAdClick.doj != 2) {
                break label204;
              }
              ae.i("MicroMsg.SnsCore", "at_friend_detail report ad h5 load");
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.g.yxI.f(16972, new Object[] { Long.valueOf(localSnsAdClick.dKq), Integer.valueOf(localSnsAdClick.ipM), ((com.tencent.mm.plugin.sns.storage.a)localObject1).dGD, Integer.valueOf(((p)localObject2).ecz()), ((p)localObject2).ebP().AiG, paramAnonymousqy.dGB.url, Integer.valueOf(paramAnonymousqy.dGB.dGC), Integer.valueOf(paramAnonymousqy.dGB.errorCode), Long.valueOf(paramAnonymousqy.dGB.timestamp) });
              AppMethodBeat.o(176264);
              return true;
              localObject1 = ((p)localObject2).dVi();
              break;
              label204:
              ae.i("MicroMsg.SnsCore", "report ad h5 load");
            }
          }
          label227:
          localObject1 = ah.dXE().AG(localSnsAdClick.dKq);
        }
        catch (Exception paramAnonymousqy)
        {
          ae.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousqy, "report load ad h5 error", new Object[0]);
          AppMethodBeat.o(176264);
          return false;
        }
        Object localObject2 = new StringBuilder("report ad h5, AdSnsInfo==null, uxInfo=").append(paramAnonymousqy.dGB.dGD).append(", snsInfo==null?");
        boolean bool;
        String str;
        int i;
        if (localObject1 == null)
        {
          bool = true;
          ae.i("MicroMsg.SnsCore", bool);
          if (localObject1 == null) {
            break label450;
          }
          str = paramAnonymousqy.dGB.dGD;
          i = ((p)localObject1).ecz();
          localObject1 = ((p)localObject1).ebP();
          if (localObject1 != null) {
            break label442;
          }
          localObject1 = "";
          break label569;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(16972, new Object[] { Long.valueOf(localSnsAdClick.dKq), Integer.valueOf(localSnsAdClick.ipM), str, Integer.valueOf(i), localObject2, paramAnonymousqy.dGB.url, Integer.valueOf(paramAnonymousqy.dGB.dGC), Integer.valueOf(paramAnonymousqy.dGB.errorCode), Long.valueOf(paramAnonymousqy.dGB.timestamp) });
          AppMethodBeat.o(176264);
          return true;
          bool = false;
          break;
          label442:
          localObject1 = ((TimeLineObject)localObject1).AiG;
          break label569;
          label450:
          localObject1 = paramAnonymousqy.dGB.dGD;
          com.tencent.mm.plugin.report.service.g.yxI.f(16972, new Object[] { Long.valueOf(localSnsAdClick.dKq), Integer.valueOf(localSnsAdClick.ipM), localObject1, Integer.valueOf(0), "", paramAnonymousqy.dGB.url, Integer.valueOf(paramAnonymousqy.dGB.dGC), Integer.valueOf(paramAnonymousqy.dGB.errorCode), Long.valueOf(paramAnonymousqy.dGB.timestamp) });
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
    this.zBH = new ah.20(this);
    this.zBI = new ah.21(this);
    this.zBJ = new com.tencent.mm.sdk.b.c() {};
    this.zBK = new com.tencent.mm.sdk.b.c() {};
    this.zBL = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(rf paramAnonymousrf)
      {
        AppMethodBeat.i(176265);
        SnsAdClick localSnsAdClick = paramAnonymousrf.dGR.dGA;
        try
        {
          if (paramAnonymousrf.dGR.dGS != 1) {
            break label259;
          }
          if (localSnsAdClick.ipP != 1) {
            break label365;
          }
          locale = ah.dXH().Ax(localSnsAdClick.dKq);
          if ((locale == null) || (!locale.dZL())) {
            break label266;
          }
          localObject2 = ah.dXy();
          j = 14647;
          localObject1 = new Object[7];
          localObject1[0] = Long.valueOf(localSnsAdClick.dKq);
          localObject1[1] = locale.dVi().dGD;
          localObject1[2] = Integer.valueOf(localSnsAdClick.ipM);
          localObject1[3] = Long.valueOf(localSnsAdClick.startTime);
          localObject1[4] = Long.valueOf(System.currentTimeMillis());
          i = locale.ebN();
          paramAnonymousrf = (rf)localObject1;
        }
        catch (Exception paramAnonymousrf)
        {
          for (;;)
          {
            com.tencent.mm.plugin.sns.storage.e locale;
            int j;
            com.tencent.mm.plugin.sns.ad.e.l locall;
            ae.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousrf, "report ad click error", new Object[0]);
            continue;
            Object localObject1 = paramAnonymousrf.dGR.dGD;
            paramAnonymousrf = (rf)localObject1;
            if (localObject1 == null) {
              paramAnonymousrf = "";
            }
            ae.i("MicroMsg.SnsCore", "ReportSnsEvent, AdSnsInfo==null, uxInfo=".concat(String.valueOf(paramAnonymousrf)));
            boolean bool = false;
            continue;
            ah.dXy().f(12013, new Object[] { localObject1 });
            continue;
            int i = -1;
            localObject1 = paramAnonymousrf;
            Object localObject2 = paramAnonymousrf;
            paramAnonymousrf = (rf)localObject1;
            localObject1 = localObject2;
            localObject2 = locall;
          }
        }
        paramAnonymousrf[5] = Integer.valueOf(i);
        localObject1[6] = "";
        ((com.tencent.mm.plugin.sns.ad.e.l)localObject2).f(j, (Object[])localObject1);
        paramAnonymousrf = com.tencent.mm.modelsns.e.pZ(750);
        paramAnonymousrf.GU(localSnsAdClick.dKq).GU(locale.dVi().dGD).qb(localSnsAdClick.ipM).GU(localSnsAdClick.startTime).GU(System.currentTimeMillis());
        paramAnonymousrf.aLH();
        for (;;)
        {
          label259:
          AppMethodBeat.o(176265);
          return false;
          label266:
          locall = ah.dXy();
          j = 13155;
          paramAnonymousrf = new Object[7];
          paramAnonymousrf[0] = Long.valueOf(localSnsAdClick.dKq);
          paramAnonymousrf[1] = locale.dVi().dGD;
          paramAnonymousrf[2] = Integer.valueOf(localSnsAdClick.ipM);
          paramAnonymousrf[3] = Long.valueOf(localSnsAdClick.startTime);
          paramAnonymousrf[4] = Long.valueOf(System.currentTimeMillis());
          if (locale == null) {
            break label753;
          }
          i = locale.ebN();
          localObject1 = paramAnonymousrf;
          localObject2 = paramAnonymousrf;
          paramAnonymousrf = (rf)localObject1;
          localObject1 = localObject2;
          localObject2 = locall;
          break;
          label365:
          localObject1 = ah.dXH().Ax(localSnsAdClick.dKq);
          if (localObject1 == null) {
            break label693;
          }
          paramAnonymousrf = ((com.tencent.mm.plugin.sns.storage.e)localObject1).dVi().dGD;
          bool = ((com.tencent.mm.plugin.sns.storage.e)localObject1).dZL();
          localObject1 = com.tencent.mm.plugin.sns.ad.e.i.a(localSnsAdClick.dKq, new Object[] { localSnsAdClick, paramAnonymousrf, Integer.valueOf(localSnsAdClick.ipM), Long.valueOf(localSnsAdClick.startTime), Long.valueOf(System.currentTimeMillis()) });
          localObject1 = (String)localObject1 + String.format(",%s", new Object[] { localSnsAdClick.ipQ });
          localObject1 = (String)localObject1 + String.format(",%s", new Object[] { System.currentTimeMillis() - localSnsAdClick.startTime - localSnsAdClick.ipS });
          if (!bool) {
            break label732;
          }
          ah.dXy().f(14643, new Object[] { localObject1 });
          localObject1 = com.tencent.mm.modelsns.e.pZ(733);
          ((com.tencent.mm.modelsns.e)localObject1).GU(localSnsAdClick.dKq).GU(paramAnonymousrf).qb(localSnsAdClick.ipM).GU(localSnsAdClick.startTime).GU(System.currentTimeMillis());
          ((com.tencent.mm.modelsns.e)localObject1).aLH();
        }
      }
    };
    this.zBM = new ah.26(this);
    this.zBN = new com.tencent.mm.sdk.b.c() {};
    this.zBO = new ah.28(this);
    this.zBP = false;
    this.wxo = new com.tencent.mm.sdk.b.c() {};
    this.zBQ = new com.tencent.mm.sdk.b.c() {};
    this.zBR = new ah.32(this);
    ae.i("MicroMsg.SnsCore", "snscore create! " + Thread.currentThread().getId());
    if (this.zAv == null) {
      this.zAv = com.tencent.e.h.MqF.a("SnsCore_CDNDownload_handler", 6, 6, new LinkedBlockingQueue());
    }
    if (this.yBp == null) {
      this.yBp = com.tencent.e.h.MqF.a("SnsCore_thumbDecode_handler", 6, 6, new LinkedBlockingQueue());
    }
    if (this.zAu == null) {
      this.zAu = com.tencent.e.h.MqF.bbd("SnsCore#File");
    }
    if (this.zAw == null) {
      this.zAw = com.tencent.e.h.MqF.bbd("SnsCore#Task");
    }
    if ((((ActivityManager)ak.getContext().getSystemService("activity")).getLargeMemoryClass() > 256) && (Build.VERSION.SDK_INT != 24)) {
      int i = Build.VERSION.SDK_INT;
    }
    AppMethodBeat.o(95798);
  }
  
  public static com.tencent.mm.sdk.platformtools.aq cXK()
  {
    AppMethodBeat.i(95804);
    com.tencent.mm.sdk.platformtools.aq localaq = dXl().handler;
    AppMethodBeat.o(95804);
    return localaq;
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(95835);
    com.tencent.mm.vfs.o.aZI(((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath());
    com.tencent.mm.vfs.o.aZI(((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsTmpPath());
    com.tencent.mm.vfs.o.aZX(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.ebF());
    AppMethodBeat.o(95835);
  }
  
  public static com.tencent.mm.sdk.platformtools.aq dJc()
  {
    AppMethodBeat.i(95799);
    if (zBi == null) {
      zBi = new com.tencent.mm.sdk.platformtools.aq("MicroMsg.SnsCore#WorkingHandler");
    }
    com.tencent.mm.sdk.platformtools.aq localaq = zBi;
    AppMethodBeat.o(95799);
    return localaq;
  }
  
  public static bc dXA()
  {
    AppMethodBeat.i(95816);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAM == null)
    {
      dXl().zAM = new bc();
      com.tencent.mm.plugin.sns.b.o.zsu = dXl().zAM;
    }
    bc localbc = dXl().zAM;
    AppMethodBeat.o(95816);
    return localbc;
  }
  
  public static g dXB()
  {
    AppMethodBeat.i(95817);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAE == null)
    {
      dXl().zAE = new g();
      com.tencent.mm.plugin.sns.b.o.zsv = dXl().zAE;
    }
    g localg = dXl().zAE;
    AppMethodBeat.o(95817);
    return localg;
  }
  
  public static ax dXC()
  {
    AppMethodBeat.i(95818);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zBd == null) {
      dXl().zBd = new ax();
    }
    ax localax = dXl().zBd;
    AppMethodBeat.o(95818);
    return localax;
  }
  
  public static af dXD()
  {
    AppMethodBeat.i(95819);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAJ == null)
    {
      localObject = dXl();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.ajS();
      ((ah)localObject).zAJ = new af(com.tencent.mm.kernel.g.ajR().cachePath + "snsAsyncQueue.data");
    }
    Object localObject = dXl().zAJ;
    AppMethodBeat.o(95819);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.sns.storage.q dXE()
  {
    AppMethodBeat.i(95820);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAA == null)
    {
      dXl().zAA = new com.tencent.mm.plugin.sns.storage.q(dXl().gDX);
      com.tencent.mm.plugin.sns.b.o.zsB = dXl().zAA;
    }
    com.tencent.mm.plugin.sns.storage.q localq = dXl().zAA;
    AppMethodBeat.o(95820);
    return localq;
  }
  
  public static com.tencent.mm.plugin.sns.storage.d dXF()
  {
    AppMethodBeat.i(95821);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAC == null) {
      dXl().zAC = new com.tencent.mm.plugin.sns.storage.d(dXl().gDX);
    }
    com.tencent.mm.plugin.sns.storage.d locald = dXl().zAC;
    AppMethodBeat.o(95821);
    return locald;
  }
  
  public static ab dXG()
  {
    AppMethodBeat.i(95822);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAD == null) {
      dXl().zAD = new ab(dXl().gDX);
    }
    ab localab = dXl().zAD;
    AppMethodBeat.o(95822);
    return localab;
  }
  
  public static com.tencent.mm.plugin.sns.storage.f dXH()
  {
    AppMethodBeat.i(95823);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAB == null) {
      dXl().zAB = new com.tencent.mm.plugin.sns.storage.f(dXl().gDX);
    }
    com.tencent.mm.plugin.sns.storage.f localf = dXl().zAB;
    AppMethodBeat.o(95823);
    return localf;
  }
  
  public static com.tencent.mm.plugin.sns.storage.o dXI()
  {
    AppMethodBeat.i(95824);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAF == null)
    {
      dXl().zAF = new com.tencent.mm.plugin.sns.storage.o(dXl().gDX, new aj());
      com.tencent.mm.plugin.sns.b.o.zsw = dXl().zAF;
    }
    com.tencent.mm.plugin.sns.storage.o localo = dXl().zAF;
    AppMethodBeat.o(95824);
    return localo;
  }
  
  public static com.tencent.mm.plugin.sns.storage.k dXJ()
  {
    AppMethodBeat.i(95825);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAG == null)
    {
      dXl().zAG = new com.tencent.mm.plugin.sns.storage.k(dXl().gDX);
      com.tencent.mm.plugin.sns.b.o.zsx = dXl().zAG;
    }
    com.tencent.mm.plugin.sns.storage.k localk = dXl().zAG;
    AppMethodBeat.o(95825);
    return localk;
  }
  
  public static w dXK()
  {
    AppMethodBeat.i(95826);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAH == null)
    {
      dXl().zAH = new w(dXl().gDX);
      com.tencent.mm.plugin.sns.b.o.zsy = dXl().zAH;
    }
    w localw = dXl().zAH;
    AppMethodBeat.o(95826);
    return localw;
  }
  
  public static com.tencent.mm.plugin.sns.storage.m dXL()
  {
    AppMethodBeat.i(176273);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAI == null) {
      dXl().zAI = new com.tencent.mm.plugin.sns.storage.m(dXl().gDX);
    }
    com.tencent.mm.plugin.sns.storage.m localm = dXl().zAI;
    AppMethodBeat.o(176273);
    return localm;
  }
  
  public static ap dXM()
  {
    AppMethodBeat.i(95827);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAN == null) {
      dXl().zAN = new ap();
    }
    ap localap = dXl().zAN;
    AppMethodBeat.o(95827);
    return localap;
  }
  
  public static au dXN()
  {
    AppMethodBeat.i(179093);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAQ == null) {
      dXl().zAQ = new au();
    }
    au localau = dXl().zAQ;
    AppMethodBeat.o(179093);
    return localau;
  }
  
  public static ar dXO()
  {
    AppMethodBeat.i(219340);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAR == null) {
      dXl().zAR = new ar();
    }
    ar localar = dXl().zAR;
    AppMethodBeat.o(219340);
    return localar;
  }
  
  public static int dXP()
  {
    AppMethodBeat.i(95828);
    int i = (dpC().x - com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), zBj)) / 3;
    zAx = i;
    if (i > zBk) {}
    for (i = zBk;; i = zAx)
    {
      zAx = i;
      if (i > 10) {
        break;
      }
      ae.e("MicroMsg.SnsCore", "can not get multiThumbDisplaySize or the multiThumbDisplaySize < 10");
      AppMethodBeat.o(95828);
      return 150;
    }
    i = zAx;
    AppMethodBeat.o(95828);
    return i;
  }
  
  public static int dXQ()
  {
    AppMethodBeat.i(95829);
    if (zAy <= 0)
    {
      zAy = 200;
      zAy = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), zAy);
    }
    int i = zAy;
    AppMethodBeat.o(95829);
    return i;
  }
  
  public static boolean dXR()
  {
    AppMethodBeat.i(95831);
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.ax.r(ak.getContext(), "sp_sns_dynswitch_stg", 4);
    boolean bool;
    if (localSharedPreferences.contains("st_sw_use_vcodec_img"))
    {
      bool = localSharedPreferences.getBoolean("st_sw_use_vcodec_img", false);
      ae.w("MicroMsg.SnsCore", "isUseVCodecImg: %b (set statically outside)", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(95831);
      return bool;
      bool = localSharedPreferences.getBoolean("sw_use_vcodec_img", false);
      ae.d("MicroMsg.SnsCore", "isUseVCodecImg: %b", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static boolean dXS()
  {
    AppMethodBeat.i(219341);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOb, false);
    AppMethodBeat.o(219341);
    return bool;
  }
  
  public static boolean dXT()
  {
    AppMethodBeat.i(219342);
    if (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(219342);
      return true;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOa, false);
    AppMethodBeat.o(219342);
    return bool;
  }
  
  public static boolean dXU()
  {
    AppMethodBeat.i(95832);
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.ax.r(ak.getContext(), "sp_sns_dynswitch_stg", 4);
    boolean bool;
    if (localSharedPreferences.contains("st_sw_use_wxpc_img"))
    {
      bool = localSharedPreferences.getBoolean("st_sw_use_wxpc_img", false);
      ae.w("MicroMsg.SnsCore", "isUseWxpcImg: %b (set statically outside)", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(95832);
      return bool;
      bool = localSharedPreferences.getBoolean("sw_use_wxpc_img", false);
      ae.d("MicroMsg.SnsCore", "isUseWxpcImg: %b", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static String dXV()
  {
    AppMethodBeat.i(95839);
    if (bu.isNullOrNil(zAZ))
    {
      localObject = bj.fpt().iterator();
      while (((Iterator)localObject).hasNext())
      {
        bj.a locala = (bj.a)((Iterator)localObject).next();
        if (com.tencent.mm.loader.j.b.asd().equals(locala.IAe)) {
          zAZ = locala.IAf;
        }
      }
      ae.i("MicroMsg.SnsCore", "get filesys " + zAZ);
    }
    Object localObject = bu.bI(zAZ, "");
    AppMethodBeat.o(95839);
    return localObject;
  }
  
  public static String dXj()
  {
    AppMethodBeat.i(95793);
    com.tencent.mm.kernel.g.ajS();
    String str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(2, null);
    AppMethodBeat.o(95793);
    return str;
  }
  
  public static int dXk()
  {
    AppMethodBeat.i(95794);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP();
    int i = com.tencent.mm.kernel.a.getUin();
    AppMethodBeat.o(95794);
    return i;
  }
  
  private static ah dXl()
  {
    AppMethodBeat.i(95796);
    ah localah = (ah)com.tencent.mm.model.u.ap(ah.class);
    if (!localah.zAX) {}
    synchronized (localah.zAY)
    {
      if (!localah.zAX)
      {
        ae.i("MicroMsg.SnsCore", "onAccInit because bug!");
        localah.onAccountPostReset(true);
      }
      if (!localah.rNZ) {}
    }
    Object localObject3;
    boolean bool;
    String str;
    long l1;
    for (;;)
    {
      synchronized (localah.lock)
      {
        ae.i("MicroMsg.SnsCore", "getCore need reset DB now " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + localah.hashCode());
        if (localah.rNZ)
        {
          localah.zAV = false;
          localObject4 = localah.zAW;
          localObject3 = zBa;
          if (((z)localObject4).AeD)
          {
            ae.i("MicroMsg.TrimSnsDb", "pass hasTrim");
            if (localah.gDX == null)
            {
              localah.gDX = new com.tencent.mm.storagebase.h();
              com.tencent.mm.kernel.g.ajS();
              localObject3 = com.tencent.mm.kernel.g.ajR().cachePath;
              localObject3 = (String)localObject3 + "SnsMicroMsg.db";
              if (!localah.gDX.b((String)localObject3, zBa, true))
              {
                com.tencent.mm.plugin.report.service.g.yxI.dD(150, 82);
                dXm();
                localah.gDX = new com.tencent.mm.storagebase.h();
                bool = localah.gDX.b((String)localObject3, zBa, true);
                ae.i("MicroMsg.SnsCore", "one more time result:%s:", new Object[] { Boolean.valueOf(bool) });
                if (bool) {
                  com.tencent.mm.plugin.report.service.g.yxI.dD(150, 83);
                }
              }
            }
            localah.rNZ = false;
            ae.i("MicroMsg.SnsCore", "resetdb done");
          }
        }
        else
        {
          AppMethodBeat.o(95796);
          return localah;
          localObject1 = finally;
          AppMethodBeat.o(95796);
          throw localObject1;
        }
        com.tencent.mm.kernel.g.ajS();
        if (!com.tencent.mm.kernel.g.ajP().aiZ()) {
          continue;
        }
        i = bu.getInt(com.tencent.mm.n.g.acL().getValue("AndroidCleanSnsDb"), 0);
        ae.i("MicroMsg.TrimSnsDb", "pass dynamic? ".concat(String.valueOf(i)));
        if (i > 0) {
          continue;
        }
        com.tencent.mm.kernel.g.ajS();
        str = com.tencent.mm.kernel.g.ajR().cachePath;
        if (com.tencent.mm.vfs.o.fB(str + "SnsMicroMsg2.db.ini"))
        {
          z.aBR(str);
          com.tencent.mm.vfs.o.deleteFile(str + "SnsMicroMsg2.db.ini");
        }
        localObject5 = ak.getContext().getSharedPreferences(ak.fow(), 0);
        if (bu.rZ(((SharedPreferences)localObject5).getLong("check_trim_time", 0L)) < 604800L) {
          ae.i("MicroMsg.TrimSnsDb", "trim sns pass because time short");
        }
      }
      ((SharedPreferences)localObject5).edit().putLong("check_trim_time", bu.aRi()).commit();
      ((z)localObject4).AeD = true;
      l1 = System.currentTimeMillis();
      i = com.tencent.mm.q.a.adN();
      if ((i == 1) || (i == 2))
      {
        ae.i("MicroMsg.TrimSnsDb", "trim sns error space dangerous");
      }
      else if (com.tencent.mm.vfs.o.fB(str + "sns_mark.ini"))
      {
        if (bu.DD(com.tencent.mm.vfs.o.aZS(str + "sns_mark.ini")) < 2592000000L)
        {
          ae.i("MicroMsg.TrimSnsDb", "mark file exist and return");
          z.aBR(str);
        }
        else
        {
          com.tencent.mm.vfs.o.deleteFile(str + "sns_mark.ini");
        }
      }
      else
      {
        l2 = com.tencent.mm.vfs.o.aZR(str + "SnsMicroMsg.db");
        ae.i("MicroMsg.TrimSnsDb", "trim sns ".concat(String.valueOf(l2)));
        if (l2 >= 52428800L) {
          break;
        }
        ae.i("MicroMsg.TrimSnsDb", "trim sns free pass: " + (System.currentTimeMillis() - l1));
      }
    }
    com.tencent.mm.vfs.o.aZV(str + "sns_mark.ini");
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
      ae.i("MicroMsg.TrimSnsDb", "copysns insert all %d passed ret:".concat(String.valueOf(i)), new Object[] { Long.valueOf(l3) });
      ((com.tencent.mm.storagebase.h)localObject5).closeDB();
      ((com.tencent.mm.storagebase.h)localObject4).closeDB();
      if (i >= 0)
      {
        com.tencent.mm.kernel.g.ajS();
        localObject3 = com.tencent.mm.kernel.g.ajR().cachePath;
        com.tencent.mm.vfs.o.deleteFile((String)localObject3 + "SnsMicroMsg.db");
        ae.i("MicroMsg.TrimSnsDb", "rename file ".concat(String.valueOf(com.tencent.mm.vfs.o.bc((String)localObject3, "SnsMicroMsg2.db", "SnsMicroMsg.db"))));
        com.tencent.mm.vfs.o.deleteFile((String)localObject3 + "SnsMicroMsg.db-shm");
        com.tencent.mm.vfs.o.deleteFile((String)localObject3 + "SnsMicroMsg.db-wal");
        com.tencent.mm.vfs.o.deleteFile((String)localObject3 + "SnsMicroMsg.db.ini");
        com.tencent.mm.vfs.o.mF("SnsMicroMsg2.db.ini", "SnsMicroMsg.db.ini");
        com.tencent.mm.vfs.o.deleteFile((String)localObject3 + "SnsMicroMsg2.db.ini");
        com.tencent.mm.vfs.o.deleteFile((String)localObject3 + "SnsMicroMsg2.db");
        com.tencent.mm.vfs.o.deleteFile((String)localObject3 + "sns_mark.ini");
      }
      l2 = System.currentTimeMillis() - l2;
      ae.i("MicroMsg.TrimSnsDb", "copysns data ret=%d all: %d copytime %d ", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l2 - l3) });
      ae.i("MicroMsg.TrimSnsDb", "trim sns done pass: " + (System.currentTimeMillis() - l1));
      break;
      l3 = System.currentTimeMillis();
      z.a((com.tencent.mm.storagebase.h)localObject5, (com.tencent.mm.storagebase.h)localObject4, "snsExtInfo3");
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "insert into " + "snsExtInfo3" + " select * from old." + "snsExtInfo3");
      ae.i("MicroMsg.TrimSnsDb", "copysns ret_ext:" + bool + " passed " + (System.currentTimeMillis() - l3));
      z.a((com.tencent.mm.storagebase.h)localObject5, (com.tencent.mm.storagebase.h)localObject4, "SnsComment");
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "insert into " + "SnsComment" + " select * from old." + "SnsComment");
      ae.i("MicroMsg.TrimSnsDb", "copysns ret_msg:" + bool + " passed " + (System.currentTimeMillis() - l3));
      z.a((com.tencent.mm.storagebase.h)localObject5, (com.tencent.mm.storagebase.h)localObject4, "SnsInfo");
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "insert into " + "SnsInfo" + " select * from old." + "SnsInfo" + " where  (sourceType & 2 != 0 ) " + com.tencent.mm.plugin.sns.storage.q.Aec + " limit 200");
      ae.i("MicroMsg.TrimSnsDb", "copysns ret_sns:" + bool + " passed " + (System.currentTimeMillis() - l3));
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "update snsExtinfo3 set md5 = '', faults = '';");
      ae.i("MicroMsg.TrimSnsDb", "update ext info  passed  %s  updateRet %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l3), Boolean.valueOf(bool) });
      ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "DETACH DATABASE old");
    }
  }
  
  private static void dXm()
  {
    AppMethodBeat.i(219339);
    com.tencent.mm.kernel.g.ajS();
    String[] arrayOfString = new File(com.tencent.mm.kernel.g.ajR().cachePath).list();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        ae.i("MicroMsg.SnsCore", "removeDirtyDB file:%s", new Object[] { str });
        if ((str != null) && (str.contains("SnsMicroMsg")))
        {
          ae.i("MicroMsg.SnsCore", "removeDirtyDB will delete:%s", new Object[] { str });
          com.tencent.mm.vfs.o.deleteFile(str);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(219339);
  }
  
  public static boolean dXn()
  {
    AppMethodBeat.i(95797);
    dXl();
    if (!com.tencent.mm.kernel.g.ajP().aiZ())
    {
      AppMethodBeat.o(95797);
      return true;
    }
    AppMethodBeat.o(95797);
    return false;
  }
  
  public static ExecutorService dXo()
  {
    AppMethodBeat.i(179089);
    ExecutorService localExecutorService = dXl().zAv;
    AppMethodBeat.o(179089);
    return localExecutorService;
  }
  
  public static ExecutorService dXp()
  {
    AppMethodBeat.i(179090);
    ExecutorService localExecutorService = dXl().yBp;
    AppMethodBeat.o(179090);
    return localExecutorService;
  }
  
  protected static ExecutorService dXq()
  {
    AppMethodBeat.i(179091);
    ExecutorService localExecutorService = dXl().zAu;
    AppMethodBeat.o(179091);
    return localExecutorService;
  }
  
  public static ExecutorService dXr()
  {
    AppMethodBeat.i(179092);
    ExecutorService localExecutorService = dXl().zAw;
    AppMethodBeat.o(179092);
    return localExecutorService;
  }
  
  public static bq dXs()
  {
    AppMethodBeat.i(95808);
    com.tencent.mm.kernel.g.ajS();
    bq localbq = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF();
    AppMethodBeat.o(95808);
    return localbq;
  }
  
  public static com.tencent.mm.plugin.sns.storage.u dXt()
  {
    AppMethodBeat.i(95809);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAz == null) {
      dXl().zAz = new com.tencent.mm.plugin.sns.storage.u(dXl().gDX);
    }
    com.tencent.mm.plugin.sns.storage.u localu = dXl().zAz;
    AppMethodBeat.o(95809);
    return localu;
  }
  
  public static ao.a dXu()
  {
    AppMethodBeat.i(95810);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAK == null)
    {
      dXl().zAK = new ao.a();
      com.tencent.mm.plugin.sns.b.o.zsA = dXl().zAK;
    }
    ao.a locala = dXl().zAK;
    AppMethodBeat.o(95810);
    return locala;
  }
  
  public static com.tencent.mm.plugin.sns.h.c dXv()
  {
    AppMethodBeat.i(95811);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAO == null) {
      dXl().zAO = new com.tencent.mm.plugin.sns.h.c();
    }
    com.tencent.mm.plugin.sns.h.c localc = dXl().zAO;
    AppMethodBeat.o(95811);
    return localc;
  }
  
  public static com.tencent.mm.plugin.sns.h.g dXw()
  {
    AppMethodBeat.i(95812);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAP == null) {
      dXl().zAP = new com.tencent.mm.plugin.sns.h.g();
    }
    com.tencent.mm.plugin.sns.h.g localg = dXl().zAP;
    AppMethodBeat.o(95812);
    return localg;
  }
  
  public static com.tencent.mm.plugin.sns.storage.s dXx()
  {
    AppMethodBeat.i(95813);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAS == null) {
      dXl().zAS = new com.tencent.mm.plugin.sns.storage.s(dXl().gDX);
    }
    com.tencent.mm.plugin.sns.storage.s locals = dXl().zAS;
    AppMethodBeat.o(95813);
    return locals;
  }
  
  public static com.tencent.mm.plugin.sns.ad.e.l dXy()
  {
    AppMethodBeat.i(95814);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAT == null) {
      dXl().zAT = new com.tencent.mm.plugin.sns.ad.e.l();
    }
    com.tencent.mm.plugin.sns.ad.e.l locall = dXl().zAT;
    AppMethodBeat.o(95814);
    return locall;
  }
  
  public static c dXz()
  {
    AppMethodBeat.i(95815);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dXl().zAL == null) {
      dXl().zAL = new c();
    }
    c localc = dXl().zAL;
    AppMethodBeat.o(95815);
    return localc;
  }
  
  public static Point dpC()
  {
    AppMethodBeat.i(95830);
    if (htn.x == 0)
    {
      localObject = (WindowManager)ak.getContext().getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
      htn.x = localDisplayMetrics.widthPixels;
      htn.y = localDisplayMetrics.heightPixels;
    }
    Object localObject = htn;
    AppMethodBeat.o(95830);
    return localObject;
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(95792);
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.kernel.g.ajS();
    String str = com.tencent.mm.kernel.g.ajR().gDT;
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
    com.tencent.mm.storagebase.h localh = dXl().gDX;
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
  
  public static void j(Point paramPoint)
  {
    htn = paramPoint;
  }
  
  public final void a(com.tencent.mm.model.ax paramax)
  {
    AppMethodBeat.i(95837);
    u.a(paramax);
    AppMethodBeat.o(95837);
  }
  
  public final void b(com.tencent.mm.model.ax paramax)
  {
    AppMethodBeat.i(95838);
    u.b(paramax);
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
    ae.i("MicroMsg.SnsCore", "onAccountPostReset " + Thread.currentThread().getId() + " isAccInit: " + this.zAX);
    if (this.zAX)
    {
      AppMethodBeat.o(95834);
      return;
    }
    this.zAX = true;
    this.rNZ = true;
    checkDir();
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("NewYearSNSCtrl2016", this.zBe, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("NewYearSNSTips2016", this.zBf, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("NewYearSNSAmountLevelCtrl2016", this.zBg, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("SnsAd", this.zBh, true);
    com.tencent.mm.plugin.sns.b.o.zsu = dXA();
    com.tencent.mm.plugin.sns.b.o.zsv = dXB();
    com.tencent.mm.plugin.sns.b.o.zsw = dXI();
    com.tencent.mm.plugin.sns.b.o.zsx = dXJ();
    com.tencent.mm.plugin.sns.b.o.zsy = dXK();
    com.tencent.mm.plugin.sns.b.o.zsA = dXu();
    com.tencent.mm.plugin.sns.b.o.zsz = this;
    com.tencent.mm.plugin.sns.b.o.zsB = dXE();
    com.tencent.mm.sdk.b.a.IvT.c(this.zBN);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBO);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBA);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBy);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBz);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBB);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBC);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBD);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBE);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBF);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBH);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBI);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBJ);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBR);
    appForegroundListener.alive();
    this.zBl = new n();
    this.zBm = new com.tencent.mm.plugin.sns.k();
    this.zBn = new com.tencent.mm.plugin.sns.e();
    this.zBo = new com.tencent.mm.plugin.sns.q();
    this.zBp = new com.tencent.mm.plugin.sns.h();
    this.zBq = new com.tencent.mm.plugin.sns.g();
    this.zBr = new com.tencent.mm.plugin.sns.m();
    this.zBs = new com.tencent.mm.plugin.sns.j();
    this.zBt = new com.tencent.mm.plugin.sns.b();
    this.zBu = new com.tencent.mm.plugin.sns.c();
    this.zBv = new com.tencent.mm.plugin.sns.f();
    com.tencent.mm.sdk.b.a.IvT.c(this.zBM);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBL);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBo);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBl);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBm);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBn);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBp);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBq);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBr);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBs);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBt);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBu);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBv);
    com.tencent.mm.sdk.b.a.IvT.c(this.wxo);
    this.zBb = new com.tencent.mm.plugin.sns.d();
    com.tencent.mm.sdk.b.a.IvT.c(this.zBb);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBQ);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBw);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBx);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBK);
    com.tencent.mm.sdk.b.a.IvT.c(this.zBG);
    Object localObject1 = dXy();
    com.tencent.mm.plugin.sns.ad.e.l.zpS = com.tencent.mm.n.g.acL().getInt("MMUxAdLog2GSendSize", 20480);
    com.tencent.mm.plugin.sns.ad.e.l.zpT = com.tencent.mm.n.g.acL().getInt("MMUxAdLog3GSendSize", 30720);
    com.tencent.mm.plugin.sns.ad.e.l.zpU = com.tencent.mm.n.g.acL().getInt("MMUxAdLogWifiSendSize", 51200);
    com.tencent.mm.plugin.sns.ad.e.l.zpV = com.tencent.mm.n.g.acL().getInt("MMUxAdLogMinRandTime", 60);
    com.tencent.mm.plugin.sns.ad.e.l.zpW = com.tencent.mm.n.g.acL().getInt("MMUxAdLogMaxRandTime", 1800);
    com.tencent.mm.plugin.sns.ad.e.l.zpX = com.tencent.mm.n.g.acL().getInt("MMUxAdLogMaxExceptionTime", 43200);
    ae.i("MicroMsg.SnsLogMgr", "init " + com.tencent.mm.plugin.sns.ad.e.l.zpS + ";" + com.tencent.mm.plugin.sns.ad.e.l.zpT + ";" + com.tencent.mm.plugin.sns.ad.e.l.zpU + ";" + com.tencent.mm.plugin.sns.ad.e.l.zpV + ";" + com.tencent.mm.plugin.sns.ad.e.l.zpW + ";" + com.tencent.mm.plugin.sns.ad.e.l.zpX);
    if (com.tencent.mm.plugin.sns.ad.e.l.zpW - com.tencent.mm.plugin.sns.ad.e.l.zpV < 0) {
      com.tencent.mm.plugin.sns.ad.e.l.zpW = com.tencent.mm.plugin.sns.ad.e.l.zpV;
    }
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1802, (com.tencent.mm.ak.f)localObject1);
    localObject1 = dXA();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(207, (com.tencent.mm.ak.f)localObject1);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(209, (com.tencent.mm.ak.f)localObject1);
    localObject1 = this.zAU;
    com.tencent.mm.sdk.b.a.IvT.c(((aq)localObject1).zCI);
    com.tencent.mm.sdk.b.a.IvT.c(((aq)localObject1).zCJ);
    com.tencent.mm.sdk.b.a.IvT.c(((aq)localObject1).zCK);
    this.zBc = new com.tencent.mm.plugin.sns.g.a();
    as.init();
    localObject1 = com.tencent.mm.modelsns.f.iql;
    com.tencent.mm.modelsns.f.aLI();
    if (com.tencent.mm.memory.l.ayT())
    {
      localObject1 = com.tencent.mm.memory.c.hzj;
      localObject2 = com.tencent.mm.memory.c.hzj;
      localObject2.getClass();
      ((com.tencent.mm.memory.c)localObject1).a(new e.a((com.tencent.mm.memory.c)localObject2)
      {
        final int zBS;
        
        public final long ayO()
        {
          return 10485760L;
        }
        
        public final int ayP()
        {
          return -1;
        }
      });
    }
    localObject1 = com.tencent.mm.memory.o.hzF;
    Object localObject2 = com.tencent.mm.memory.o.hzF;
    localObject2.getClass();
    ((com.tencent.mm.memory.o)localObject1).a(new e.a((com.tencent.mm.memory.o)localObject2)
    {
      public final long ayO()
      {
        return -1L;
      }
      
      public final int ayP()
      {
        return 3;
      }
    });
    localObject1 = com.tencent.mm.memory.g.hzq;
    localObject2 = com.tencent.mm.memory.g.hzq;
    localObject2.getClass();
    ((com.tencent.mm.memory.g)localObject1).a(new e.a((com.tencent.mm.memory.g)localObject2)
    {
      public final long ayO()
      {
        return 0L;
      }
      
      public final int ayP()
      {
        return 5;
      }
    });
    dXC();
    com.tencent.mm.plugin.sns.f.a.init();
    try
    {
      localObject1 = ay.aRW("TrackDataSource");
      if (!bu.isNullOrNil(((ay)localObject1).getString("path", "")))
      {
        com.tencent.mm.plugin.report.service.g.yxI.dD(150, 74);
        com.tencent.mm.plugin.report.service.g.yxI.f(17832, new Object[] { Integer.valueOf(((ay)localObject1).getInt("type", 0)), ((ay)localObject1).getString("path", ""), Long.valueOf(((ay)localObject1).getLong("ts", 0L)), ((ay)localObject1).getString("media-url", ""), ((ay)localObject1).getString("thumb-url", ""), Long.valueOf(((ay)localObject1).getLong("prepare-ts", 0L)), ((ay)localObject1).getString("prepare-path", "") });
        ((ay)localObject1).putInt("type", 0);
        ((ay)localObject1).putString("path", "");
        ((ay)localObject1).putLong("ts", 0L);
        ((ay)localObject1).putString("media-url", "");
        ((ay)localObject1).putString("thumb-url", "");
        ((ay)localObject1).putLong("prepare-ts", 0L);
        ((ay)localObject1).commit();
      }
      AppMethodBeat.o(95834);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.SnsCore", localThrowable, "videoCrashKvReport", new Object[0]);
      AppMethodBeat.o(95834);
    }
  }
  
  /* Error */
  public final void onAccountRelease()
  {
    // Byte code:
    //   0: ldc_w 1759
    //   3: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 1580	com/tencent/mm/plugin/sns/model/ah:dXy	()Lcom/tencent/mm/plugin/sns/ad/e/l;
    //   9: astore_1
    //   10: invokestatic 708	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   13: pop
    //   14: invokestatic 1623	com/tencent/mm/kernel/g:ajQ	()Lcom/tencent/mm/kernel/b;
    //   17: getfield 1629	com/tencent/mm/kernel/b:gDv	Lcom/tencent/mm/ak/q;
    //   20: sipush 1802
    //   23: aload_1
    //   24: invokevirtual 1761	com/tencent/mm/ak/q:b	(ILcom/tencent/mm/ak/f;)V
    //   27: aload_0
    //   28: getfield 319	com/tencent/mm/plugin/sns/model/ah:zAU	Lcom/tencent/mm/plugin/sns/model/aq;
    //   31: astore_1
    //   32: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   35: aload_1
    //   36: getfield 1637	com/tencent/mm/plugin/sns/model/aq:zCI	Lcom/tencent/mm/sdk/b/c;
    //   39: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   42: pop
    //   43: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   46: aload_1
    //   47: getfield 1640	com/tencent/mm/plugin/sns/model/aq:zCJ	Lcom/tencent/mm/sdk/b/c;
    //   50: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   53: pop
    //   54: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   57: aload_1
    //   58: getfield 1643	com/tencent/mm/plugin/sns/model/aq:zCK	Lcom/tencent/mm/sdk/b/c;
    //   61: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   64: pop
    //   65: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   68: aload_0
    //   69: getfield 432	com/tencent/mm/plugin/sns/model/ah:zBN	Lcom/tencent/mm/sdk/b/c;
    //   72: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   75: pop
    //   76: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   79: aload_0
    //   80: getfield 437	com/tencent/mm/plugin/sns/model/ah:zBO	Lcom/tencent/mm/sdk/b/c;
    //   83: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   86: pop
    //   87: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   90: aload_0
    //   91: getfield 429	com/tencent/mm/plugin/sns/model/ah:zBM	Lcom/tencent/mm/sdk/b/c;
    //   94: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   97: pop
    //   98: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   101: aload_0
    //   102: getfield 424	com/tencent/mm/plugin/sns/model/ah:zBL	Lcom/tencent/mm/sdk/b/c;
    //   105: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   108: pop
    //   109: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   112: aload_0
    //   113: getfield 381	com/tencent/mm/plugin/sns/model/ah:zBA	Lcom/tencent/mm/sdk/b/c;
    //   116: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   119: pop
    //   120: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   123: aload_0
    //   124: getfield 371	com/tencent/mm/plugin/sns/model/ah:zBy	Lcom/tencent/mm/sdk/b/c;
    //   127: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   130: pop
    //   131: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   134: aload_0
    //   135: getfield 376	com/tencent/mm/plugin/sns/model/ah:zBz	Lcom/tencent/mm/sdk/b/c;
    //   138: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   141: pop
    //   142: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   145: aload_0
    //   146: getfield 384	com/tencent/mm/plugin/sns/model/ah:zBB	Lcom/tencent/mm/sdk/b/c;
    //   149: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   152: pop
    //   153: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   156: aload_0
    //   157: getfield 389	com/tencent/mm/plugin/sns/model/ah:zBC	Lcom/tencent/mm/sdk/b/c;
    //   160: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   163: pop
    //   164: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   167: aload_0
    //   168: getfield 394	com/tencent/mm/plugin/sns/model/ah:zBD	Lcom/tencent/mm/sdk/b/c;
    //   171: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   174: pop
    //   175: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   178: aload_0
    //   179: getfield 1538	com/tencent/mm/plugin/sns/model/ah:zBo	Lcom/tencent/mm/plugin/sns/q;
    //   182: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   185: pop
    //   186: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   189: aload_0
    //   190: getfield 1543	com/tencent/mm/plugin/sns/model/ah:zBp	Lcom/tencent/mm/plugin/sns/h;
    //   193: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   196: pop
    //   197: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   200: aload_0
    //   201: getfield 402	com/tencent/mm/plugin/sns/model/ah:zBF	Lcom/tencent/mm/sdk/b/c;
    //   204: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   207: pop
    //   208: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   211: aload_0
    //   212: getfield 410	com/tencent/mm/plugin/sns/model/ah:zBH	Lcom/tencent/mm/sdk/b/c;
    //   215: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   218: pop
    //   219: getstatic 295	com/tencent/mm/plugin/sns/model/ah:appForegroundListener	Lcom/tencent/mm/app/o$a;
    //   222: invokevirtual 1766	com/tencent/mm/app/o$a:dead	()V
    //   225: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   228: aload_0
    //   229: getfield 1523	com/tencent/mm/plugin/sns/model/ah:zBl	Lcom/tencent/mm/plugin/sns/n;
    //   232: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   235: pop
    //   236: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   239: aload_0
    //   240: getfield 1528	com/tencent/mm/plugin/sns/model/ah:zBm	Lcom/tencent/mm/plugin/sns/k;
    //   243: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   246: pop
    //   247: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   250: aload_0
    //   251: getfield 1533	com/tencent/mm/plugin/sns/model/ah:zBn	Lcom/tencent/mm/plugin/sns/e;
    //   254: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   257: pop
    //   258: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   261: aload_0
    //   262: getfield 1548	com/tencent/mm/plugin/sns/model/ah:zBq	Lcom/tencent/mm/plugin/sns/g;
    //   265: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   268: pop
    //   269: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   272: aload_0
    //   273: getfield 1553	com/tencent/mm/plugin/sns/model/ah:zBr	Lcom/tencent/mm/plugin/sns/m;
    //   276: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   279: pop
    //   280: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   283: aload_0
    //   284: getfield 1558	com/tencent/mm/plugin/sns/model/ah:zBs	Lcom/tencent/mm/plugin/sns/j;
    //   287: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   290: pop
    //   291: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   294: aload_0
    //   295: getfield 1563	com/tencent/mm/plugin/sns/model/ah:zBt	Lcom/tencent/mm/plugin/sns/b;
    //   298: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   301: pop
    //   302: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   305: aload_0
    //   306: getfield 1568	com/tencent/mm/plugin/sns/model/ah:zBu	Lcom/tencent/mm/plugin/sns/c;
    //   309: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   312: pop
    //   313: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   316: aload_0
    //   317: getfield 1573	com/tencent/mm/plugin/sns/model/ah:zBv	Lcom/tencent/mm/plugin/sns/f;
    //   320: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   323: pop
    //   324: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   327: aload_0
    //   328: getfield 399	com/tencent/mm/plugin/sns/model/ah:zBE	Lcom/tencent/mm/sdk/b/c;
    //   331: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   334: pop
    //   335: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   338: aload_0
    //   339: getfield 1578	com/tencent/mm/plugin/sns/model/ah:zBb	Lcom/tencent/mm/plugin/sns/d;
    //   342: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   345: pop
    //   346: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   349: aload_0
    //   350: getfield 415	com/tencent/mm/plugin/sns/model/ah:zBI	Lcom/tencent/mm/sdk/b/c;
    //   353: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   356: pop
    //   357: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   360: aload_0
    //   361: getfield 418	com/tencent/mm/plugin/sns/model/ah:zBJ	Lcom/tencent/mm/sdk/b/c;
    //   364: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   367: pop
    //   368: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   371: aload_0
    //   372: getfield 442	com/tencent/mm/plugin/sns/model/ah:wxo	Lcom/tencent/mm/sdk/b/c;
    //   375: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   378: pop
    //   379: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   382: aload_0
    //   383: getfield 445	com/tencent/mm/plugin/sns/model/ah:zBQ	Lcom/tencent/mm/sdk/b/c;
    //   386: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   389: pop
    //   390: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   393: aload_0
    //   394: getfield 421	com/tencent/mm/plugin/sns/model/ah:zBK	Lcom/tencent/mm/sdk/b/c;
    //   397: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   400: pop
    //   401: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   404: aload_0
    //   405: getfield 361	com/tencent/mm/plugin/sns/model/ah:zBw	Lcom/tencent/mm/sdk/b/c;
    //   408: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   411: pop
    //   412: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   415: aload_0
    //   416: getfield 366	com/tencent/mm/plugin/sns/model/ah:zBx	Lcom/tencent/mm/sdk/b/c;
    //   419: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   422: pop
    //   423: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   426: aload_0
    //   427: getfield 450	com/tencent/mm/plugin/sns/model/ah:zBR	Lcom/tencent/mm/sdk/b/c;
    //   430: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   433: pop
    //   434: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   437: aload_0
    //   438: getfield 405	com/tencent/mm/plugin/sns/model/ah:zBG	Lcom/tencent/mm/sdk/b/c;
    //   441: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   444: pop
    //   445: getstatic 1772	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a$e:zPr	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a;
    //   448: astore_1
    //   449: aload_1
    //   450: getfield 1777	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:zPk	Z
    //   453: ifeq +27 -> 480
    //   456: ldc_w 1779
    //   459: ldc_w 1781
    //   462: invokestatic 1783	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: invokestatic 228	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   468: aload_1
    //   469: getfield 1787	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:zPj	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a$a;
    //   472: invokevirtual 1791	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   475: aload_1
    //   476: iconst_0
    //   477: putfield 1777	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:zPk	Z
    //   480: invokestatic 1797	com/tencent/mm/plugin/downloader/model/f:cdA	()Lcom/tencent/mm/plugin/downloader/model/f;
    //   483: pop
    //   484: aload_1
    //   485: getfield 1801	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:zPo	Lcom/tencent/mm/plugin/downloader/model/m;
    //   488: invokestatic 1806	com/tencent/mm/plugin/downloader/model/c:b	(Lcom/tencent/mm/plugin/downloader/model/m;)V
    //   491: ldc_w 1472
    //   494: invokestatic 631	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   497: checkcast 1472	com/tencent/mm/plugin/messenger/foundation/a/s
    //   500: invokeinterface 1476 1 0
    //   505: ldc_w 1478
    //   508: aload_0
    //   509: getfield 339	com/tencent/mm/plugin/sns/model/ah:zBe	Lcom/tencent/mm/plugin/sns/lucky/a/f;
    //   512: iconst_1
    //   513: invokevirtual 1808	com/tencent/mm/model/cf:b	(Ljava/lang/String;Lcom/tencent/mm/model/cf$a;Z)V
    //   516: ldc_w 1472
    //   519: invokestatic 631	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   522: checkcast 1472	com/tencent/mm/plugin/messenger/foundation/a/s
    //   525: invokeinterface 1476 1 0
    //   530: ldc_w 1485
    //   533: aload_0
    //   534: getfield 344	com/tencent/mm/plugin/sns/model/ah:zBf	Lcom/tencent/mm/plugin/sns/lucky/a/j;
    //   537: iconst_1
    //   538: invokevirtual 1808	com/tencent/mm/model/cf:b	(Ljava/lang/String;Lcom/tencent/mm/model/cf$a;Z)V
    //   541: ldc_w 1472
    //   544: invokestatic 631	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   547: checkcast 1472	com/tencent/mm/plugin/messenger/foundation/a/s
    //   550: invokeinterface 1476 1 0
    //   555: ldc_w 1487
    //   558: aload_0
    //   559: getfield 349	com/tencent/mm/plugin/sns/model/ah:zBg	Lcom/tencent/mm/plugin/sns/lucky/a/d;
    //   562: iconst_1
    //   563: invokevirtual 1808	com/tencent/mm/model/cf:b	(Ljava/lang/String;Lcom/tencent/mm/model/cf$a;Z)V
    //   566: ldc_w 1472
    //   569: invokestatic 631	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   572: checkcast 1472	com/tencent/mm/plugin/messenger/foundation/a/s
    //   575: invokeinterface 1476 1 0
    //   580: ldc_w 1489
    //   583: aload_0
    //   584: getfield 354	com/tencent/mm/plugin/sns/model/ah:zBh	Lcom/tencent/mm/plugin/sns/lucky/a/l;
    //   587: iconst_1
    //   588: invokevirtual 1808	com/tencent/mm/model/cf:b	(Ljava/lang/String;Lcom/tencent/mm/model/cf$a;Z)V
    //   591: invokestatic 1491	com/tencent/mm/plugin/sns/model/ah:dXA	()Lcom/tencent/mm/plugin/sns/model/bc;
    //   594: astore_1
    //   595: invokestatic 708	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   598: pop
    //   599: invokestatic 1623	com/tencent/mm/kernel/g:ajQ	()Lcom/tencent/mm/kernel/b;
    //   602: getfield 1629	com/tencent/mm/kernel/b:gDv	Lcom/tencent/mm/ak/q;
    //   605: sipush 207
    //   608: aload_1
    //   609: invokevirtual 1761	com/tencent/mm/ak/q:b	(ILcom/tencent/mm/ak/f;)V
    //   612: invokestatic 708	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   615: pop
    //   616: invokestatic 1623	com/tencent/mm/kernel/g:ajQ	()Lcom/tencent/mm/kernel/b;
    //   619: getfield 1629	com/tencent/mm/kernel/b:gDv	Lcom/tencent/mm/ak/q;
    //   622: sipush 209
    //   625: aload_1
    //   626: invokevirtual 1761	com/tencent/mm/ak/q:b	(ILcom/tencent/mm/ak/f;)V
    //   629: ldc 2
    //   631: invokestatic 1090	com/tencent/mm/model/u:ap	(Ljava/lang/Class;)Lcom/tencent/mm/model/az;
    //   634: checkcast 2	com/tencent/mm/plugin/sns/model/ah
    //   637: astore_1
    //   638: aload_1
    //   639: ifnull +99 -> 738
    //   642: ldc_w 452
    //   645: ldc_w 1810
    //   648: invokestatic 1812	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   651: aload_1
    //   652: getfield 731	com/tencent/mm/plugin/sns/model/ah:gDX	Lcom/tencent/mm/storagebase/h;
    //   655: ifnull +15 -> 670
    //   658: aload_1
    //   659: getfield 731	com/tencent/mm/plugin/sns/model/ah:gDX	Lcom/tencent/mm/storagebase/h;
    //   662: invokevirtual 1251	com/tencent/mm/storagebase/h:closeDB	()V
    //   665: aload_1
    //   666: aconst_null
    //   667: putfield 731	com/tencent/mm/plugin/sns/model/ah:gDX	Lcom/tencent/mm/storagebase/h;
    //   670: aload_1
    //   671: getfield 484	com/tencent/mm/plugin/sns/model/ah:zAv	Ljava/util/concurrent/ExecutorService;
    //   674: ifnull +13 -> 687
    //   677: aload_1
    //   678: getfield 484	com/tencent/mm/plugin/sns/model/ah:zAv	Ljava/util/concurrent/ExecutorService;
    //   681: invokeinterface 1816 1 0
    //   686: pop
    //   687: aload_1
    //   688: getfield 503	com/tencent/mm/plugin/sns/model/ah:yBp	Ljava/util/concurrent/ExecutorService;
    //   691: ifnull +13 -> 704
    //   694: aload_1
    //   695: getfield 503	com/tencent/mm/plugin/sns/model/ah:yBp	Ljava/util/concurrent/ExecutorService;
    //   698: invokeinterface 1816 1 0
    //   703: pop
    //   704: aload_1
    //   705: getfield 507	com/tencent/mm/plugin/sns/model/ah:zAu	Ljava/util/concurrent/ExecutorService;
    //   708: ifnull +13 -> 721
    //   711: aload_1
    //   712: getfield 507	com/tencent/mm/plugin/sns/model/ah:zAu	Ljava/util/concurrent/ExecutorService;
    //   715: invokeinterface 1816 1 0
    //   720: pop
    //   721: aload_1
    //   722: getfield 515	com/tencent/mm/plugin/sns/model/ah:zAw	Ljava/util/concurrent/ExecutorService;
    //   725: ifnull +13 -> 738
    //   728: aload_1
    //   729: getfield 515	com/tencent/mm/plugin/sns/model/ah:zAw	Ljava/util/concurrent/ExecutorService;
    //   732: invokeinterface 1816 1 0
    //   737: pop
    //   738: aload_0
    //   739: getfield 1648	com/tencent/mm/plugin/sns/model/ah:zBc	Lcom/tencent/mm/plugin/sns/g/a;
    //   742: astore_1
    //   743: invokestatic 1818	com/tencent/mm/plugin/sns/model/ah:dXz	()Lcom/tencent/mm/plugin/sns/model/c;
    //   746: aload_1
    //   747: invokevirtual 1821	com/tencent/mm/plugin/sns/model/c:b	(Lcom/tencent/mm/plugin/sns/model/c$b;)V
    //   750: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   753: aload_1
    //   754: getfield 1824	com/tencent/mm/plugin/sns/g/a:zuZ	Lcom/tencent/mm/sdk/b/c;
    //   757: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   760: pop
    //   761: invokestatic 1827	com/tencent/mm/plugin/sns/model/as:unInit	()V
    //   764: getstatic 1699	com/tencent/mm/memory/g:hzq	Lcom/tencent/mm/memory/g;
    //   767: invokevirtual 1830	com/tencent/mm/memory/g:ayL	()V
    //   770: getstatic 1673	com/tencent/mm/memory/c:hzj	Lcom/tencent/mm/memory/c;
    //   773: invokevirtual 1831	com/tencent/mm/memory/c:ayL	()V
    //   776: getstatic 1689	com/tencent/mm/memory/o:hzF	Lcom/tencent/mm/memory/o;
    //   779: invokevirtual 1832	com/tencent/mm/memory/o:ayL	()V
    //   782: invokestatic 1705	com/tencent/mm/plugin/sns/model/ah:dXC	()Lcom/tencent/mm/plugin/sns/model/ax;
    //   785: astore_1
    //   786: aload_1
    //   787: aconst_null
    //   788: putfield 1836	com/tencent/mm/plugin/sns/model/ax:zEe	Lcom/tencent/mm/plugin/sns/model/be;
    //   791: aload_1
    //   792: getfield 1840	com/tencent/mm/plugin/sns/model/ax:zEi	Ljava/util/LinkedList;
    //   795: astore_2
    //   796: aload_2
    //   797: monitorenter
    //   798: aload_1
    //   799: getfield 1840	com/tencent/mm/plugin/sns/model/ax:zEi	Ljava/util/LinkedList;
    //   802: invokevirtual 1845	java/util/LinkedList:clear	()V
    //   805: aload_2
    //   806: monitorexit
    //   807: aload_1
    //   808: getfield 1849	com/tencent/mm/plugin/sns/model/ax:zEg	Ljava/util/Map;
    //   811: invokeinterface 1852 1 0
    //   816: aload_1
    //   817: getfield 1855	com/tencent/mm/plugin/sns/model/ax:zEf	Ljava/util/LinkedList;
    //   820: invokevirtual 1845	java/util/LinkedList:clear	()V
    //   823: aload_1
    //   824: getfield 1858	com/tencent/mm/plugin/sns/model/ax:zEh	Ljava/util/LinkedList;
    //   827: astore_2
    //   828: aload_2
    //   829: monitorenter
    //   830: aload_1
    //   831: getfield 1858	com/tencent/mm/plugin/sns/model/ax:zEh	Ljava/util/LinkedList;
    //   834: invokevirtual 1845	java/util/LinkedList:clear	()V
    //   837: aload_2
    //   838: monitorexit
    //   839: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   842: aload_1
    //   843: getfield 1861	com/tencent/mm/plugin/sns/model/ax:zEl	Lcom/tencent/mm/sdk/b/c;
    //   846: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   849: pop
    //   850: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   853: aload_1
    //   854: getfield 1862	com/tencent/mm/plugin/sns/model/ax:zCJ	Lcom/tencent/mm/sdk/b/c;
    //   857: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   860: pop
    //   861: getstatic 1509	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   864: aload_1
    //   865: getfield 1863	com/tencent/mm/plugin/sns/model/ax:zCK	Lcom/tencent/mm/sdk/b/c;
    //   868: invokevirtual 1763	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   871: pop
    //   872: invokestatic 1866	com/tencent/mm/plugin/sns/f/a:destroy	()V
    //   875: ldc_w 1759
    //   878: invokestatic 298	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   881: return
    //   882: astore_2
    //   883: ldc_w 1779
    //   886: ldc_w 1868
    //   889: iconst_1
    //   890: anewarray 4	java/lang/Object
    //   893: dup
    //   894: iconst_0
    //   895: aload_2
    //   896: invokevirtual 1871	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   899: aastore
    //   900: invokestatic 1873	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   903: goto -423 -> 480
    //   906: astore_1
    //   907: aload_2
    //   908: monitorexit
    //   909: ldc_w 1759
    //   912: invokestatic 298	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   915: aload_1
    //   916: athrow
    //   917: astore_1
    //   918: aload_2
    //   919: monitorexit
    //   920: ldc_w 1759
    //   923: invokestatic 298	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   926: aload_1
    //   927: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	928	0	this	ah
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
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ah
 * JD-Core Version:    0.7.0.1
 */