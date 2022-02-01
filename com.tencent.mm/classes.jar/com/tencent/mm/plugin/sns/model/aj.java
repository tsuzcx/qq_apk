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
import com.tencent.mm.g.a.bx;
import com.tencent.mm.g.a.jf;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.g.a.oj.a;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.g.a.rr.a;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.g.a.rs.a;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.a.sa.a;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.a.vh;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.wc;
import com.tencent.mm.g.a.wy;
import com.tencent.mm.g.a.wy.a;
import com.tencent.mm.g.a.ye;
import com.tencent.mm.g.a.ys;
import com.tencent.mm.memory.e.a;
import com.tencent.mm.memory.o;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.y;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.q;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.SdcardUtil.StatMountParse;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public final class aj
  implements bd, com.tencent.mm.plugin.sns.b.k
{
  private static String DKR;
  protected static HashMap<Integer, h.b> DKS;
  public static boolean DKh;
  private static int DKi;
  private static int DKj;
  private static int DKn;
  private static int DKo;
  private static MMHandler DLa;
  private static int DLb;
  private static int DLc;
  private static o.a appForegroundListener;
  private static Point imX;
  private IListener AgM;
  private ExecutorService CDQ;
  private x DKA;
  private com.tencent.mm.plugin.sns.storage.v DKB;
  private aq.a DKC;
  private c DKD;
  private be DKE;
  private com.tencent.mm.plugin.sns.ui.as DKF;
  private com.tencent.mm.plugin.sns.h.c DKG;
  private com.tencent.mm.plugin.sns.h.g DKH;
  private aw DKI;
  private at DKJ;
  private p DKK;
  private com.tencent.mm.plugin.sns.ad.g.m DKL;
  private as DKM;
  private boolean DKN;
  private aa DKO;
  private boolean DKP;
  private byte[] DKQ;
  private com.tencent.mm.plugin.sns.d DKT;
  private com.tencent.mm.plugin.sns.g.a DKU;
  private az DKV;
  private com.tencent.mm.plugin.sns.lucky.a.f DKW;
  private com.tencent.mm.plugin.sns.lucky.a.j DKX;
  private com.tencent.mm.plugin.sns.lucky.a.d DKY;
  private com.tencent.mm.plugin.sns.lucky.a.l DKZ;
  private ExecutorService DKk;
  private ExecutorService DKl;
  private ExecutorService DKm;
  private r DKp;
  private com.tencent.mm.plugin.sns.storage.n DKq;
  private com.tencent.mm.plugin.sns.storage.c DKr;
  private com.tencent.mm.plugin.sns.storage.b DKs;
  private ac DKt;
  private g DKu;
  private com.tencent.mm.plugin.sns.storage.m DKv;
  private com.tencent.mm.plugin.sns.storage.i DKw;
  private com.tencent.mm.plugin.sns.storage.t DKx;
  private com.tencent.mm.plugin.sns.storage.k DKy;
  private ag DKz;
  private IListener DLA;
  private IListener DLB;
  private IListener DLC;
  private IListener DLD;
  private IListener DLE;
  private IListener DLF;
  private IListener DLG;
  private boolean DLH;
  private IListener DLI;
  private IListener DLJ;
  private IListener DLK;
  private final be.a DLL;
  private com.tencent.mm.plugin.sns.n DLd;
  private com.tencent.mm.plugin.sns.k DLe;
  private com.tencent.mm.plugin.sns.e DLf;
  private q DLg;
  private com.tencent.mm.plugin.sns.h DLh;
  private com.tencent.mm.plugin.sns.g DLi;
  private com.tencent.mm.plugin.sns.m DLj;
  private com.tencent.mm.plugin.sns.j DLk;
  private com.tencent.mm.plugin.sns.b DLl;
  private com.tencent.mm.plugin.sns.c DLm;
  private com.tencent.mm.plugin.sns.f DLn;
  private IListener DLo;
  private IListener DLp;
  private IListener DLq;
  private IListener DLr;
  private IListener DLs;
  private IListener DLt;
  private IListener DLu;
  private IListener DLv;
  private IListener DLw;
  private IListener DLx;
  private IListener DLy;
  private IListener DLz;
  private MMHandler handler;
  private com.tencent.mm.storagebase.h hqK;
  private byte[] lock;
  private boolean tnN;
  
  static
  {
    AppMethodBeat.i(95843);
    DKh = true;
    DKi = 0;
    DKj = 0;
    DKR = "";
    DKS = new HashMap();
    DLb = 103;
    DLc = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 130);
    imX = new Point();
    DKS.put(Integer.valueOf("CanvasInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.b.SQL_CREATE;
      }
    });
    DKS.put(Integer.valueOf("UxCanvasInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ac.SQL_CREATE;
      }
    });
    DKS.put(Integer.valueOf("SNSMEDIA_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return r.SQL_CREATE;
      }
    });
    DKS.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.n.SQL_CREATE;
      }
    });
    DKS.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.n.SQL_CREATE;
      }
    });
    DKS.put(Integer.valueOf("ADSNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.c.SQL_CREATE;
      }
    });
    DKS.put(Integer.valueOf("SNSEXT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.m.SQL_CREATE;
      }
    });
    DKS.put(Integer.valueOf("SNSCOMMENT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.i.SQL_CREATE;
      }
    });
    DKS.put(Integer.valueOf("SNSTAGINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.t.SQL_CREATE;
      }
    });
    DKS.put(Integer.valueOf("SNSKVREPORT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return p.SQL_CREATE;
      }
    });
    DKS.put(Integer.valueOf("SNSDRAFT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.k.SQL_CREATE;
      }
    });
    DKS.put(Integer.valueOf("SNSWSFOLDGROUP_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return x.SQL_CREATE;
      }
    });
    DKS.put(Integer.valueOf("SNSWSFOLDDETAIL_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.v.SQL_CREATE;
      }
    });
    appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(202736);
        if ((com.tencent.mm.kernel.g.aAc()) && (com.tencent.mm.kernel.g.aAf().hpY))
        {
          com.tencent.mm.kernel.g.aAf();
          if (!com.tencent.mm.kernel.a.azj())
          {
            paramAnonymousString = new rq();
            paramAnonymousString.dYj.state = 0;
            EventCenter.instance.publish(paramAnonymousString);
            paramAnonymousString = new ye();
            EventCenter.instance.publish(paramAnonymousString);
          }
        }
        AppMethodBeat.o(202736);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(202735);
        if ((com.tencent.mm.kernel.g.aAc()) && (com.tencent.mm.kernel.g.aAf().hpY))
        {
          com.tencent.mm.kernel.g.aAf();
          if (!com.tencent.mm.kernel.a.azj())
          {
            paramAnonymousString = new rq();
            paramAnonymousString.dYj.state = 1;
            EventCenter.instance.publish(paramAnonymousString);
          }
        }
        AppMethodBeat.o(202735);
      }
    };
    AppMethodBeat.o(95843);
  }
  
  public aj()
  {
    AppMethodBeat.i(95798);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.DKM = new as();
    this.tnN = false;
    this.DKN = true;
    this.lock = new byte[0];
    this.DKO = new aa();
    this.DKP = false;
    this.DKQ = new byte[0];
    this.DKW = new com.tencent.mm.plugin.sns.lucky.a.f();
    this.DKX = new com.tencent.mm.plugin.sns.lucky.a.j();
    this.DKY = new com.tencent.mm.plugin.sns.lucky.a.d();
    this.DKZ = new com.tencent.mm.plugin.sns.lucky.a.l();
    this.DLo = new aj.13(this);
    this.DLp = new IListener() {};
    this.DLq = new aj.15(this);
    this.DLr = new IListener() {};
    this.DLs = new IListener() {};
    this.DLt = new IListener() {};
    this.DLu = new IListener()
    {
      private static boolean a(oj paramAnonymousoj)
      {
        AppMethodBeat.i(202744);
        Object localObject2 = paramAnonymousoj.dUw.dNX;
        com.tencent.mm.plugin.sns.storage.n localn = aj.faO();
        paramAnonymousoj = aj.getDataDB();
        long l1 = paramAnonymousoj.beginTransaction(-1L);
        try
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            long l2 = ((Long)((Iterator)localObject2).next()).longValue();
            SnsInfo localSnsInfo = localn.Zr((int)l2);
            if (localSnsInfo != null)
            {
              localSnsInfo.setOmittedFailResend();
              Log.d("MicroMsg.SnsInfoStorage", "snsInfoId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
              localn.d((int)l2, localSnsInfo);
            }
          }
          paramAnonymousoj.endTransaction(l1);
        }
        finally
        {
          paramAnonymousoj.endTransaction(l1);
          AppMethodBeat.o(202744);
        }
        AppMethodBeat.o(202744);
        return false;
      }
    };
    this.DLv = new IListener() {};
    this.DLw = new aj.21(this);
    this.DLx = new IListener()
    {
      private static boolean a(rr paramAnonymousrr)
      {
        AppMethodBeat.i(202746);
        try
        {
          SnsAdClick localSnsAdClick = paramAnonymousrr.dYk.dYl;
          paramAnonymousrr = aj.faR().JE(localSnsAdClick.ece);
          if (paramAnonymousrr == null)
          {
            AppMethodBeat.o(202746);
            return false;
          }
          SnsInfo localSnsInfo = paramAnonymousrr.convertToSnsInfo();
          String str1;
          String str2;
          com.tencent.mm.plugin.sns.ad.g.a locala;
          if (localSnsAdClick.source == 2)
          {
            paramAnonymousrr = localSnsInfo.getAtAdInfo();
            if (paramAnonymousrr == null) {
              break label434;
            }
            str1 = paramAnonymousrr.waidPkg;
            str2 = com.tencent.mm.plugin.sns.waid.b.aRy(str1);
            locala = new com.tencent.mm.plugin.sns.ad.g.a();
            locala.Dup = com.tencent.mm.plugin.sns.data.k.r(localSnsInfo);
            locala.Duq = com.tencent.mm.plugin.sns.data.k.s(localSnsInfo);
            locala.Dur = ((int)localSnsAdClick.jlc);
            if (localSnsAdClick.source != 2) {
              break label267;
            }
            Log.i("MicroMsg.SnsCore", "at_friend_detail report ad click, exposureTime=" + localSnsAdClick.jlb + ", clkPos=" + localSnsAdClick.jkU + ", pkg=" + str1 + ", waid=" + str2);
            paramAnonymousrr = new com.tencent.mm.plugin.sns.ad.g.f(localSnsAdClick.ece, paramAnonymousrr.viewId, localSnsAdClick.jkU, localSnsAdClick.jkV, localSnsAdClick.jkT, "", localSnsInfo.getAdType(), localSnsInfo.getTimeLine().statExtStr, localSnsAdClick.jla, localSnsInfo.getAdSnsInfo().getAtFriendRemindInfoSourceInfo(), localSnsInfo.getAdSnsInfo().getAtFriendRemindInfoSelfInfo(), localSnsAdClick.jlb, str1, str2, locala);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(paramAnonymousrr, 0);
          }
          for (;;)
          {
            AppMethodBeat.o(202746);
            return true;
            paramAnonymousrr = localSnsInfo.getAdInfo();
            break;
            label267:
            Log.i("MicroMsg.SnsCore", "report ad click, exposureTime=" + localSnsAdClick.jlb + ", clkPos=" + localSnsAdClick.jkU + ", source=" + localSnsAdClick.source + ", pkg=" + str1 + ", waid=" + str2);
            paramAnonymousrr = new com.tencent.mm.plugin.sns.ad.g.f(localSnsAdClick.ece, paramAnonymousrr.viewId, localSnsAdClick.jkU, localSnsAdClick.jkV, localSnsAdClick.jkT, "", localSnsInfo.getAdType(), localSnsInfo.getTimeLine().statExtStr, localSnsAdClick.jla, localSnsInfo.getAdSnsInfo().getTimelineRemindInfoSourceInfo(), localSnsInfo.getAdSnsInfo().getTimelineRemindInfoSelfInfo(), localSnsAdClick.jlb, str1, str2, locala);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(paramAnonymousrr, 0);
          }
          label434:
          return false;
        }
        catch (Exception paramAnonymousrr)
        {
          Log.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousrr, "report ad click error", new Object[0]);
          AppMethodBeat.o(202746);
        }
      }
    };
    this.DLy = new IListener()
    {
      private static boolean a(rs paramAnonymousrs)
      {
        AppMethodBeat.i(202747);
        SnsAdClick localSnsAdClick;
        Object localObject1;
        try
        {
          localSnsAdClick = paramAnonymousrs.dYm.dYl;
          localObject1 = aj.faR().JE(localSnsAdClick.ece);
          if (localObject1 != null)
          {
            localObject2 = ((AdSnsInfo)localObject1).convertToSnsInfo();
            if (localSnsAdClick.source == 2)
            {
              localObject1 = ((SnsInfo)localObject2).getAtAdInfo();
              if (localObject1 == null) {
                break label227;
              }
              if (localSnsAdClick.source != 2) {
                break label204;
              }
              Log.i("MicroMsg.SnsCore", "at_friend_detail report ad h5 load");
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.h.CyF.a(16972, new Object[] { Long.valueOf(localSnsAdClick.ece), Integer.valueOf(localSnsAdClick.jkT), ((ADInfo)localObject1).uxInfo, Integer.valueOf(((SnsInfo)localObject2).getAdRecSrc()), ((SnsInfo)localObject2).getTimeLine().statExtStr, paramAnonymousrs.dYm.url, Integer.valueOf(paramAnonymousrs.dYm.dYn), Integer.valueOf(paramAnonymousrs.dYm.errorCode), Long.valueOf(paramAnonymousrs.dYm.timestamp) });
              AppMethodBeat.o(202747);
              return true;
              localObject1 = ((SnsInfo)localObject2).getAdInfo();
              break;
              label204:
              Log.i("MicroMsg.SnsCore", "report ad h5 load");
            }
          }
          label227:
          localObject1 = aj.faO().JJ(localSnsAdClick.ece);
        }
        catch (Exception paramAnonymousrs)
        {
          Log.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousrs, "report load ad h5 error", new Object[0]);
          AppMethodBeat.o(202747);
          return false;
        }
        Object localObject2 = new StringBuilder("report ad h5, AdSnsInfo==null, uxInfo=").append(paramAnonymousrs.dYm.uxInfo).append(", snsInfo==null?");
        boolean bool;
        String str;
        int i;
        if (localObject1 == null)
        {
          bool = true;
          Log.i("MicroMsg.SnsCore", bool);
          if (localObject1 == null) {
            break label450;
          }
          str = paramAnonymousrs.dYm.uxInfo;
          i = ((SnsInfo)localObject1).getAdRecSrc();
          localObject1 = ((SnsInfo)localObject1).getTimeLine();
          if (localObject1 != null) {
            break label442;
          }
          localObject1 = "";
          break label569;
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(16972, new Object[] { Long.valueOf(localSnsAdClick.ece), Integer.valueOf(localSnsAdClick.jkT), str, Integer.valueOf(i), localObject2, paramAnonymousrs.dYm.url, Integer.valueOf(paramAnonymousrs.dYm.dYn), Integer.valueOf(paramAnonymousrs.dYm.errorCode), Long.valueOf(paramAnonymousrs.dYm.timestamp) });
          AppMethodBeat.o(202747);
          return true;
          bool = false;
          break;
          label442:
          localObject1 = ((TimeLineObject)localObject1).statExtStr;
          break label569;
          label450:
          localObject1 = paramAnonymousrs.dYm.uxInfo;
          com.tencent.mm.plugin.report.service.h.CyF.a(16972, new Object[] { Long.valueOf(localSnsAdClick.ece), Integer.valueOf(localSnsAdClick.jkT), localObject1, Integer.valueOf(0), "", paramAnonymousrs.dYm.url, Integer.valueOf(paramAnonymousrs.dYm.dYn), Integer.valueOf(paramAnonymousrs.dYm.errorCode), Long.valueOf(paramAnonymousrs.dYm.timestamp) });
          AppMethodBeat.o(202747);
          return true;
          label569:
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
        }
      }
    };
    this.DLz = new aj.25(this);
    this.DLA = new aj.26(this);
    this.DLB = new IListener() {};
    this.DLC = new IListener() {};
    this.DLD = new IListener()
    {
      private static boolean a(sa paramAnonymoussa)
      {
        AppMethodBeat.i(202748);
        SnsAdClick localSnsAdClick = paramAnonymoussa.dYC.dYl;
        try
        {
          if (paramAnonymoussa.dYC.dYD != 1) {
            break label259;
          }
          if (localSnsAdClick.jkW != 1) {
            break label365;
          }
          localAdSnsInfo = aj.faR().JE(localSnsAdClick.ece);
          if ((localAdSnsInfo == null) || (!localAdSnsInfo.isRecExpAd())) {
            break label266;
          }
          localObject2 = aj.faI();
          j = 14647;
          localObject1 = new Object[7];
          localObject1[0] = Long.valueOf(localSnsAdClick.ece);
          localObject1[1] = localAdSnsInfo.getAdInfo().uxInfo;
          localObject1[2] = Integer.valueOf(localSnsAdClick.jkT);
          localObject1[3] = Long.valueOf(localSnsAdClick.startTime);
          localObject1[4] = Long.valueOf(System.currentTimeMillis());
          i = localAdSnsInfo.getRecSrc();
          paramAnonymoussa = (sa)localObject1;
        }
        catch (Exception paramAnonymoussa)
        {
          for (;;)
          {
            AdSnsInfo localAdSnsInfo;
            int j;
            com.tencent.mm.plugin.sns.ad.g.m localm;
            Log.printErrStackTrace("MicroMsg.SnsCore", paramAnonymoussa, "report ad click error", new Object[0]);
            continue;
            Object localObject1 = paramAnonymoussa.dYC.uxInfo;
            paramAnonymoussa = (sa)localObject1;
            if (localObject1 == null) {
              paramAnonymoussa = "";
            }
            Log.i("MicroMsg.SnsCore", "ReportSnsEvent, AdSnsInfo==null, uxInfo=".concat(String.valueOf(paramAnonymoussa)));
            boolean bool = false;
            continue;
            aj.faI().a(12013, new Object[] { localObject1 });
            continue;
            int i = -1;
            localObject1 = paramAnonymoussa;
            Object localObject2 = paramAnonymoussa;
            paramAnonymoussa = (sa)localObject1;
            localObject1 = localObject2;
            localObject2 = localm;
          }
        }
        paramAnonymoussa[5] = Integer.valueOf(i);
        localObject1[6] = "";
        ((com.tencent.mm.plugin.sns.ad.g.m)localObject2).a(j, (Object[])localObject1);
        paramAnonymoussa = com.tencent.mm.modelsns.k.tP(750);
        paramAnonymoussa.PH(localSnsAdClick.ece).PH(localAdSnsInfo.getAdInfo().uxInfo).tR(localSnsAdClick.jkT).PH(localSnsAdClick.startTime).PH(System.currentTimeMillis());
        paramAnonymoussa.bfK();
        for (;;)
        {
          label259:
          AppMethodBeat.o(202748);
          return false;
          label266:
          localm = aj.faI();
          j = 13155;
          paramAnonymoussa = new Object[7];
          paramAnonymoussa[0] = Long.valueOf(localSnsAdClick.ece);
          paramAnonymoussa[1] = localAdSnsInfo.getAdInfo().uxInfo;
          paramAnonymoussa[2] = Integer.valueOf(localSnsAdClick.jkT);
          paramAnonymoussa[3] = Long.valueOf(localSnsAdClick.startTime);
          paramAnonymoussa[4] = Long.valueOf(System.currentTimeMillis());
          if (localAdSnsInfo == null) {
            break label753;
          }
          i = localAdSnsInfo.getRecSrc();
          localObject1 = paramAnonymoussa;
          localObject2 = paramAnonymoussa;
          paramAnonymoussa = (sa)localObject1;
          localObject1 = localObject2;
          localObject2 = localm;
          break;
          label365:
          localObject1 = aj.faR().JE(localSnsAdClick.ece);
          if (localObject1 == null) {
            break label693;
          }
          paramAnonymoussa = ((AdSnsInfo)localObject1).getAdInfo().uxInfo;
          bool = ((AdSnsInfo)localObject1).isRecExpAd();
          localObject1 = com.tencent.mm.plugin.sns.ad.g.j.a(localSnsAdClick.ece, new Object[] { localSnsAdClick, paramAnonymoussa, Integer.valueOf(localSnsAdClick.jkT), Long.valueOf(localSnsAdClick.startTime), Long.valueOf(System.currentTimeMillis()) });
          localObject1 = (String)localObject1 + String.format(",%s", new Object[] { localSnsAdClick.jkX });
          localObject1 = (String)localObject1 + String.format(",%s", new Object[] { System.currentTimeMillis() - localSnsAdClick.startTime - localSnsAdClick.jkZ });
          if (!bool) {
            break label732;
          }
          aj.faI().a(14643, new Object[] { localObject1 });
          localObject1 = com.tencent.mm.modelsns.k.tP(733);
          ((com.tencent.mm.modelsns.k)localObject1).PH(localSnsAdClick.ece).PH(paramAnonymoussa).tR(localSnsAdClick.jkT).PH(localSnsAdClick.startTime).PH(System.currentTimeMillis());
          ((com.tencent.mm.modelsns.k)localObject1).bfK();
        }
      }
    };
    this.DLE = new IListener()
    {
      private static boolean fbk()
      {
        AppMethodBeat.i(202749);
        com.tencent.mm.plugin.sns.lucky.a.g.eZK();
        ar.a locala = ar.a.NWJ;
        com.tencent.mm.plugin.sns.j.i locali = new com.tencent.mm.plugin.sns.j.i();
        try
        {
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(locala, new String(locali.toByteArray(), Charset.forName("ISO-8859-1")));
          AppMethodBeat.o(202749);
          return false;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.w("MicroMsg.RedDotUtil", "mardRedotList save exception:" + localIOException.getLocalizedMessage());
          }
        }
      }
    };
    this.DLF = new IListener() {};
    this.DLG = new aj.32(this);
    this.DLH = false;
    this.AgM = new IListener() {};
    this.DLI = new IListener() {};
    this.DLJ = new IListener() {};
    this.DLK = new aj.38(this);
    this.DLL = new aj.39(this);
    Log.i("MicroMsg.SnsCore", "snscore create! " + Thread.currentThread().getId());
    if (this.DKl == null) {
      this.DKl = com.tencent.f.h.RTc.a("SnsCore_CDNDownload_handler", 6, 6, new LinkedBlockingQueue());
    }
    if (this.CDQ == null) {
      this.CDQ = com.tencent.f.h.RTc.a("SnsCore_thumbDecode_handler", 6, 6, new LinkedBlockingQueue());
    }
    if (this.DKk == null) {
      this.DKk = com.tencent.f.h.RTc.bqp("SnsCore#File");
    }
    if (this.DKm == null) {
      this.DKm = com.tencent.f.h.RTc.bqp("SnsCore#Task");
    }
    if ((((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass() > 256) && (Build.VERSION.SDK_INT != 24)) {
      int i = Build.VERSION.SDK_INT;
    }
    AppMethodBeat.o(95798);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(95835);
    com.tencent.mm.vfs.s.boN(((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath());
    com.tencent.mm.vfs.s.boN(((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsTmpPath());
    com.tencent.mm.vfs.s.bpc(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.few());
    AppMethodBeat.o(95835);
  }
  
  public static MMHandler dRd()
  {
    AppMethodBeat.i(95804);
    MMHandler localMMHandler = faw().handler;
    AppMethodBeat.o(95804);
    return localMMHandler;
  }
  
  public static MMHandler eJP()
  {
    AppMethodBeat.i(95799);
    if (DLa == null) {
      DLa = new MMHandler("MicroMsg.SnsCore#WorkingHandler");
    }
    MMHandler localMMHandler = DLa;
    AppMethodBeat.o(95799);
    return localMMHandler;
  }
  
  public static Point ejr()
  {
    AppMethodBeat.i(95830);
    if (imX.x == 0)
    {
      localObject = (WindowManager)MMApplicationContext.getContext().getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
      imX.x = localDisplayMetrics.widthPixels;
      imX.y = localDisplayMetrics.heightPixels;
    }
    Object localObject = imX;
    AppMethodBeat.o(95830);
    return localObject;
  }
  
  protected static ExecutorService faA()
  {
    AppMethodBeat.i(179091);
    ExecutorService localExecutorService = faw().DKk;
    AppMethodBeat.o(179091);
    return localExecutorService;
  }
  
  public static ExecutorService faB()
  {
    AppMethodBeat.i(179092);
    ExecutorService localExecutorService = faw().DKm;
    AppMethodBeat.o(179092);
    return localExecutorService;
  }
  
  public static bv faC()
  {
    AppMethodBeat.i(95808);
    com.tencent.mm.kernel.g.aAi();
    bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN();
    AppMethodBeat.o(95808);
    return localbv;
  }
  
  public static r faD()
  {
    AppMethodBeat.i(95809);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKp == null) {
      faw().DKp = new r(faw().hqK);
    }
    r localr = faw().DKp;
    AppMethodBeat.o(95809);
    return localr;
  }
  
  public static aq.a faE()
  {
    AppMethodBeat.i(95810);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKC == null)
    {
      faw().DKC = new aq.a();
      com.tencent.mm.plugin.sns.b.o.DCR = faw().DKC;
    }
    aq.a locala = faw().DKC;
    AppMethodBeat.o(95810);
    return locala;
  }
  
  public static com.tencent.mm.plugin.sns.h.c faF()
  {
    AppMethodBeat.i(95811);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKG == null) {
      faw().DKG = new com.tencent.mm.plugin.sns.h.c();
    }
    com.tencent.mm.plugin.sns.h.c localc = faw().DKG;
    AppMethodBeat.o(95811);
    return localc;
  }
  
  public static com.tencent.mm.plugin.sns.h.g faG()
  {
    AppMethodBeat.i(95812);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKH == null) {
      faw().DKH = new com.tencent.mm.plugin.sns.h.g();
    }
    com.tencent.mm.plugin.sns.h.g localg = faw().DKH;
    AppMethodBeat.o(95812);
    return localg;
  }
  
  public static p faH()
  {
    AppMethodBeat.i(95813);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKK == null) {
      faw().DKK = new p(faw().hqK);
    }
    p localp = faw().DKK;
    AppMethodBeat.o(95813);
    return localp;
  }
  
  public static com.tencent.mm.plugin.sns.ad.g.m faI()
  {
    AppMethodBeat.i(95814);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKL == null) {
      faw().DKL = new com.tencent.mm.plugin.sns.ad.g.m();
    }
    com.tencent.mm.plugin.sns.ad.g.m localm = faw().DKL;
    AppMethodBeat.o(95814);
    return localm;
  }
  
  public static c faJ()
  {
    AppMethodBeat.i(95815);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKD == null) {
      faw().DKD = new c();
    }
    c localc = faw().DKD;
    AppMethodBeat.o(95815);
    return localc;
  }
  
  public static be faK()
  {
    AppMethodBeat.i(95816);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKE == null)
    {
      faw().DKE = new be();
      com.tencent.mm.plugin.sns.b.o.DCL = faw().DKE;
    }
    be localbe = faw().DKE;
    AppMethodBeat.o(95816);
    return localbe;
  }
  
  public static g faL()
  {
    AppMethodBeat.i(95817);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKu == null)
    {
      faw().DKu = new g();
      com.tencent.mm.plugin.sns.b.o.DCM = faw().DKu;
    }
    g localg = faw().DKu;
    AppMethodBeat.o(95817);
    return localg;
  }
  
  public static az faM()
  {
    AppMethodBeat.i(95818);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKV == null) {
      faw().DKV = new az();
    }
    az localaz = faw().DKV;
    AppMethodBeat.o(95818);
    return localaz;
  }
  
  public static ag faN()
  {
    AppMethodBeat.i(95819);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKz == null)
    {
      localObject = faw();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.aAi();
      ((aj)localObject).DKz = new ag(com.tencent.mm.kernel.g.aAh().cachePath + "snsAsyncQueue.data");
    }
    Object localObject = faw().DKz;
    AppMethodBeat.o(95819);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.sns.storage.n faO()
  {
    AppMethodBeat.i(95820);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKq == null)
    {
      faw().DKq = new com.tencent.mm.plugin.sns.storage.n(faw().hqK);
      com.tencent.mm.plugin.sns.b.o.DCS = faw().DKq;
    }
    com.tencent.mm.plugin.sns.storage.n localn = faw().DKq;
    AppMethodBeat.o(95820);
    return localn;
  }
  
  public static com.tencent.mm.plugin.sns.storage.b faP()
  {
    AppMethodBeat.i(95821);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKs == null) {
      faw().DKs = new com.tencent.mm.plugin.sns.storage.b(faw().hqK);
    }
    com.tencent.mm.plugin.sns.storage.b localb = faw().DKs;
    AppMethodBeat.o(95821);
    return localb;
  }
  
  public static ac faQ()
  {
    AppMethodBeat.i(95822);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKt == null) {
      faw().DKt = new ac(faw().hqK);
    }
    ac localac = faw().DKt;
    AppMethodBeat.o(95822);
    return localac;
  }
  
  public static com.tencent.mm.plugin.sns.storage.c faR()
  {
    AppMethodBeat.i(95823);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKr == null) {
      faw().DKr = new com.tencent.mm.plugin.sns.storage.c(faw().hqK);
    }
    com.tencent.mm.plugin.sns.storage.c localc = faw().DKr;
    AppMethodBeat.o(95823);
    return localc;
  }
  
  public static com.tencent.mm.plugin.sns.storage.m faS()
  {
    AppMethodBeat.i(95824);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKv == null)
    {
      faw().DKv = new com.tencent.mm.plugin.sns.storage.m(faw().hqK, new al());
      com.tencent.mm.plugin.sns.b.o.DCN = faw().DKv;
    }
    com.tencent.mm.plugin.sns.storage.m localm = faw().DKv;
    AppMethodBeat.o(95824);
    return localm;
  }
  
  public static com.tencent.mm.plugin.sns.storage.i faT()
  {
    AppMethodBeat.i(95825);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKw == null)
    {
      faw().DKw = new com.tencent.mm.plugin.sns.storage.i(faw().hqK);
      com.tencent.mm.plugin.sns.b.o.DCO = faw().DKw;
    }
    com.tencent.mm.plugin.sns.storage.i locali = faw().DKw;
    AppMethodBeat.o(95825);
    return locali;
  }
  
  public static com.tencent.mm.plugin.sns.storage.t faU()
  {
    AppMethodBeat.i(95826);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKx == null)
    {
      faw().DKx = new com.tencent.mm.plugin.sns.storage.t(faw().hqK);
      com.tencent.mm.plugin.sns.b.o.DCP = faw().DKx;
    }
    com.tencent.mm.plugin.sns.storage.t localt = faw().DKx;
    AppMethodBeat.o(95826);
    return localt;
  }
  
  public static com.tencent.mm.plugin.sns.storage.k faV()
  {
    AppMethodBeat.i(176273);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKy == null) {
      faw().DKy = new com.tencent.mm.plugin.sns.storage.k(faw().hqK);
    }
    com.tencent.mm.plugin.sns.storage.k localk = faw().DKy;
    AppMethodBeat.o(176273);
    return localk;
  }
  
  public static x faW()
  {
    AppMethodBeat.i(202765);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKA == null) {
      faw().DKA = new x(faw().hqK);
    }
    x localx = faw().DKA;
    AppMethodBeat.o(202765);
    return localx;
  }
  
  public static com.tencent.mm.plugin.sns.storage.v faX()
  {
    AppMethodBeat.i(202766);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKB == null) {
      faw().DKB = new com.tencent.mm.plugin.sns.storage.v(faw().hqK);
    }
    com.tencent.mm.plugin.sns.storage.v localv = faw().DKB;
    AppMethodBeat.o(202766);
    return localv;
  }
  
  public static com.tencent.mm.plugin.sns.ui.as faY()
  {
    AppMethodBeat.i(95827);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKF == null) {
      faw().DKF = new com.tencent.mm.plugin.sns.ui.as();
    }
    com.tencent.mm.plugin.sns.ui.as localas = faw().DKF;
    AppMethodBeat.o(95827);
    return localas;
  }
  
  public static aw faZ()
  {
    AppMethodBeat.i(179093);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKI == null) {
      faw().DKI = new aw();
    }
    aw localaw = faw().DKI;
    AppMethodBeat.o(179093);
    return localaw;
  }
  
  public static String fau()
  {
    AppMethodBeat.i(95793);
    com.tencent.mm.kernel.g.aAi();
    String str = (String)com.tencent.mm.kernel.g.aAh().azQ().get(2, null);
    AppMethodBeat.o(95793);
    return str;
  }
  
  public static int fav()
  {
    AppMethodBeat.i(95794);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf();
    int i = com.tencent.mm.kernel.a.getUin();
    AppMethodBeat.o(95794);
    return i;
  }
  
  private static aj faw()
  {
    AppMethodBeat.i(95796);
    aj localaj = (aj)y.at(aj.class);
    if (!localaj.DKP) {}
    synchronized (localaj.DKQ)
    {
      if (!localaj.DKP)
      {
        Log.i("MicroMsg.SnsCore", "onAccInit because bug!");
        localaj.onAccountPostReset(true);
      }
      if (!localaj.tnN) {}
    }
    Object localObject3;
    boolean bool;
    String str;
    long l1;
    for (;;)
    {
      synchronized (localaj.lock)
      {
        Log.i("MicroMsg.SnsCore", "getCore need reset DB now " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + localaj.hashCode());
        if (localaj.tnN)
        {
          localaj.DKN = false;
          localObject4 = localaj.DKO;
          localObject3 = DKS;
          if (((aa)localObject4).EmY)
          {
            Log.i("MicroMsg.TrimSnsDb", "pass hasTrim");
            if (localaj.hqK == null)
            {
              localaj.hqK = new com.tencent.mm.storagebase.h();
              com.tencent.mm.kernel.g.aAi();
              localObject3 = com.tencent.mm.kernel.g.aAh().cachePath;
              localObject3 = (String)localObject3 + "SnsMicroMsg.db";
              if (!localaj.hqK.a((String)localObject3, DKS, true))
              {
                com.tencent.mm.plugin.report.service.h.CyF.dN(150, 82);
                fax();
                localaj.hqK = new com.tencent.mm.storagebase.h();
                bool = localaj.hqK.a((String)localObject3, DKS, true);
                Log.i("MicroMsg.SnsCore", "one more time result:%s:", new Object[] { Boolean.valueOf(bool) });
                if (bool) {
                  com.tencent.mm.plugin.report.service.h.CyF.dN(150, 83);
                }
              }
            }
            localaj.tnN = false;
            Log.i("MicroMsg.SnsCore", "resetdb done");
          }
        }
        else
        {
          AppMethodBeat.o(95796);
          return localaj;
          localObject1 = finally;
          AppMethodBeat.o(95796);
          throw localObject1;
        }
        com.tencent.mm.kernel.g.aAi();
        if (!com.tencent.mm.kernel.g.aAf().azp()) {
          continue;
        }
        i = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("AndroidCleanSnsDb"), 0);
        Log.i("MicroMsg.TrimSnsDb", "pass dynamic? ".concat(String.valueOf(i)));
        if (i > 0) {
          continue;
        }
        com.tencent.mm.kernel.g.aAi();
        str = com.tencent.mm.kernel.g.aAh().cachePath;
        if (com.tencent.mm.vfs.s.YS(str + "SnsMicroMsg2.db.ini"))
        {
          aa.aQM(str);
          com.tencent.mm.vfs.s.deleteFile(str + "SnsMicroMsg2.db.ini");
        }
        localObject5 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
        if (Util.secondsToNow(((SharedPreferences)localObject5).getLong("check_trim_time", 0L)) < 604800L) {
          Log.i("MicroMsg.TrimSnsDb", "trim sns pass because time short");
        }
      }
      ((SharedPreferences)localObject5).edit().putLong("check_trim_time", Util.nowSecond()).commit();
      ((aa)localObject4).EmY = true;
      l1 = System.currentTimeMillis();
      i = com.tencent.mm.p.a.ats();
      if ((i == 1) || (i == 2))
      {
        Log.i("MicroMsg.TrimSnsDb", "trim sns error space dangerous");
      }
      else if (com.tencent.mm.vfs.s.YS(str + "sns_mark.ini"))
      {
        if (Util.milliSecondsToNow(com.tencent.mm.vfs.s.boX(str + "sns_mark.ini")) < 2592000000L)
        {
          Log.i("MicroMsg.TrimSnsDb", "mark file exist and return");
          aa.aQM(str);
        }
        else
        {
          com.tencent.mm.vfs.s.deleteFile(str + "sns_mark.ini");
        }
      }
      else
      {
        l2 = com.tencent.mm.vfs.s.boW(str + "SnsMicroMsg.db");
        Log.i("MicroMsg.TrimSnsDb", "trim sns ".concat(String.valueOf(l2)));
        if (l2 >= 52428800L) {
          break;
        }
        Log.i("MicroMsg.TrimSnsDb", "trim sns free pass: " + (System.currentTimeMillis() - l1));
      }
    }
    com.tencent.mm.vfs.s.bpa(str + "sns_mark.ini");
    Object localObject5 = str + "SnsMicroMsg2.db";
    Object localObject4 = new com.tencent.mm.storagebase.h();
    com.tencent.mm.model.b localb;
    if (!((com.tencent.mm.storagebase.h)localObject4).a((String)localObject5, null, false))
    {
      localb = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(95796);
      throw localb;
    }
    localObject5 = new com.tencent.mm.storagebase.h();
    if (!((com.tencent.mm.storagebase.h)localObject5).a(str + "SnsMicroMsg.db", (HashMap)localObject3, true))
    {
      localb = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(95796);
      throw localb;
    }
    long l2 = System.currentTimeMillis();
    if (!aa.a((com.tencent.mm.storagebase.h)localObject5, (com.tencent.mm.storagebase.h)localObject4)) {}
    for (int i = -1;; i = 1)
    {
      long l3 = System.currentTimeMillis() - l2;
      Log.i("MicroMsg.TrimSnsDb", "copysns insert all %d passed ret:".concat(String.valueOf(i)), new Object[] { Long.valueOf(l3) });
      ((com.tencent.mm.storagebase.h)localObject5).closeDB();
      ((com.tencent.mm.storagebase.h)localObject4).closeDB();
      if (i >= 0)
      {
        com.tencent.mm.kernel.g.aAi();
        localObject3 = com.tencent.mm.kernel.g.aAh().cachePath;
        com.tencent.mm.vfs.s.deleteFile((String)localObject3 + "SnsMicroMsg.db");
        Log.i("MicroMsg.TrimSnsDb", "rename file ".concat(String.valueOf(com.tencent.mm.vfs.s.bo((String)localObject3, "SnsMicroMsg2.db", "SnsMicroMsg.db"))));
        com.tencent.mm.vfs.s.deleteFile((String)localObject3 + "SnsMicroMsg.db-shm");
        com.tencent.mm.vfs.s.deleteFile((String)localObject3 + "SnsMicroMsg.db-wal");
        com.tencent.mm.vfs.s.deleteFile((String)localObject3 + "SnsMicroMsg.db.ini");
        com.tencent.mm.vfs.s.nw("SnsMicroMsg2.db.ini", "SnsMicroMsg.db.ini");
        com.tencent.mm.vfs.s.deleteFile((String)localObject3 + "SnsMicroMsg2.db.ini");
        com.tencent.mm.vfs.s.deleteFile((String)localObject3 + "SnsMicroMsg2.db");
        com.tencent.mm.vfs.s.deleteFile((String)localObject3 + "sns_mark.ini");
      }
      l2 = System.currentTimeMillis() - l2;
      Log.i("MicroMsg.TrimSnsDb", "copysns data ret=%d all: %d copytime %d ", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l2 - l3) });
      Log.i("MicroMsg.TrimSnsDb", "trim sns done pass: " + (System.currentTimeMillis() - l1));
      break;
      l3 = System.currentTimeMillis();
      aa.a((com.tencent.mm.storagebase.h)localObject5, (com.tencent.mm.storagebase.h)localObject4, "snsExtInfo3");
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "insert into " + "snsExtInfo3" + " select * from old." + "snsExtInfo3");
      Log.i("MicroMsg.TrimSnsDb", "copysns ret_ext:" + bool + " passed " + (System.currentTimeMillis() - l3));
      aa.a((com.tencent.mm.storagebase.h)localObject5, (com.tencent.mm.storagebase.h)localObject4, "SnsComment");
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "insert into " + "SnsComment" + " select * from old." + "SnsComment");
      Log.i("MicroMsg.TrimSnsDb", "copysns ret_msg:" + bool + " passed " + (System.currentTimeMillis() - l3));
      aa.a((com.tencent.mm.storagebase.h)localObject5, (com.tencent.mm.storagebase.h)localObject4, "SnsInfo");
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "insert into " + "SnsInfo" + " select * from old." + "SnsInfo" + " where  (sourceType & 2 != 0 ) " + com.tencent.mm.plugin.sns.storage.n.Emu + " limit 200");
      Log.i("MicroMsg.TrimSnsDb", "copysns ret_sns:" + bool + " passed " + (System.currentTimeMillis() - l3));
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "update snsExtinfo3 set md5 = '', faults = '';");
      Log.i("MicroMsg.TrimSnsDb", "update ext info  passed  %s  updateRet %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l3), Boolean.valueOf(bool) });
      ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "DETACH DATABASE old");
    }
  }
  
  private static void fax()
  {
    AppMethodBeat.i(202764);
    com.tencent.mm.kernel.g.aAi();
    String[] arrayOfString = new File(com.tencent.mm.kernel.g.aAh().cachePath).list();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        Log.i("MicroMsg.SnsCore", "removeDirtyDB file:%s", new Object[] { str });
        if ((str != null) && (str.contains("SnsMicroMsg")))
        {
          Log.i("MicroMsg.SnsCore", "removeDirtyDB will delete:%s", new Object[] { str });
          com.tencent.mm.vfs.s.deleteFile(str);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(202764);
  }
  
  public static ExecutorService fay()
  {
    AppMethodBeat.i(179089);
    ExecutorService localExecutorService = faw().DKl;
    AppMethodBeat.o(179089);
    return localExecutorService;
  }
  
  public static ExecutorService faz()
  {
    AppMethodBeat.i(179090);
    ExecutorService localExecutorService = faw().CDQ;
    AppMethodBeat.o(179090);
    return localExecutorService;
  }
  
  public static at fba()
  {
    AppMethodBeat.i(202767);
    com.tencent.mm.kernel.g.aAf().azk();
    if (faw().DKJ == null) {
      faw().DKJ = new at();
    }
    at localat = faw().DKJ;
    AppMethodBeat.o(202767);
    return localat;
  }
  
  public static int fbb()
  {
    AppMethodBeat.i(95828);
    int i = (ejr().x - com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), DLb)) / 3;
    DKn = i;
    if (i > DLc) {}
    for (i = DLc;; i = DKn)
    {
      DKn = i;
      if (i > 10) {
        break;
      }
      Log.e("MicroMsg.SnsCore", "can not get multiThumbDisplaySize or the multiThumbDisplaySize < 10");
      AppMethodBeat.o(95828);
      return 150;
    }
    i = DKn;
    AppMethodBeat.o(95828);
    return i;
  }
  
  public static int fbc()
  {
    AppMethodBeat.i(95829);
    if (DKo <= 0)
    {
      DKo = 200;
      DKo = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), DKo);
    }
    int i = DKo;
    AppMethodBeat.o(95829);
    return i;
  }
  
  public static boolean fbd()
  {
    AppMethodBeat.i(95831);
    SharedPreferences localSharedPreferences = MultiProcSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "sp_sns_dynswitch_stg", 4, false);
    boolean bool;
    if (localSharedPreferences.contains("st_sw_use_vcodec_img"))
    {
      bool = localSharedPreferences.getBoolean("st_sw_use_vcodec_img", false);
      Log.w("MicroMsg.SnsCore", "isUseVCodecImg: %b (set statically outside)", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(95831);
      return bool;
      bool = localSharedPreferences.getBoolean("sw_use_vcodec_img", false);
      Log.d("MicroMsg.SnsCore", "isUseVCodecImg: %b", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static boolean fbe()
  {
    AppMethodBeat.i(202768);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sld, false);
    AppMethodBeat.o(202768);
    return bool;
  }
  
  public static boolean fbf()
  {
    AppMethodBeat.i(202769);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(202769);
      return true;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slc, false);
    AppMethodBeat.o(202769);
    return bool;
  }
  
  public static boolean fbg()
  {
    AppMethodBeat.i(95832);
    SharedPreferences localSharedPreferences = MultiProcSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "sp_sns_dynswitch_stg", 4, false);
    boolean bool;
    if (localSharedPreferences.contains("st_sw_use_wxpc_img"))
    {
      bool = localSharedPreferences.getBoolean("st_sw_use_wxpc_img", false);
      Log.w("MicroMsg.SnsCore", "isUseWxpcImg: %b (set statically outside)", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(95832);
      return bool;
      bool = localSharedPreferences.getBoolean("sw_use_wxpc_img", false);
      Log.d("MicroMsg.SnsCore", "isUseWxpcImg: %b", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static String fbh()
  {
    AppMethodBeat.i(95839);
    if (Util.isNullOrNil(DKR))
    {
      localObject = SdcardUtil.getWritableStatMountParseForStorage().iterator();
      while (((Iterator)localObject).hasNext())
      {
        SdcardUtil.StatMountParse localStatMountParse = (SdcardUtil.StatMountParse)((Iterator)localObject).next();
        if (com.tencent.mm.loader.j.b.aKD().equals(localStatMountParse.mountDir)) {
          DKR = localStatMountParse.fileSystem;
        }
      }
      Log.i("MicroMsg.SnsCore", "get filesys " + DKR);
    }
    Object localObject = Util.nullAs(DKR, "");
    AppMethodBeat.o(95839);
    return localObject;
  }
  
  /* Error */
  public static void fbi()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: ldc_w 1425
    //   6: invokestatic 242	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc_w 1427
    //   12: invokestatic 1433	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   15: ldc_w 1435
    //   18: iconst_1
    //   19: invokevirtual 1438	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Z)Z
    //   22: pop
    //   23: invokestatic 1440	com/tencent/mm/plugin/sns/model/aj:faO	()Lcom/tencent/mm/plugin/sns/storage/n;
    //   26: astore 9
    //   28: invokestatic 1152	java/lang/System:currentTimeMillis	()J
    //   31: lstore 6
    //   33: aload 9
    //   35: getfield 1443	com/tencent/mm/plugin/sns/storage/n:iFy	Lcom/tencent/mm/storagebase/h;
    //   38: ldc2_w 1444
    //   41: invokevirtual 1448	com/tencent/mm/storagebase/h:beginTransaction	(J)J
    //   44: lstore_2
    //   45: lload_2
    //   46: lstore_0
    //   47: aload 9
    //   49: getfield 1443	com/tencent/mm/plugin/sns/storage/n:iFy	Lcom/tencent/mm/storagebase/h;
    //   52: ldc_w 1253
    //   55: ldc_w 1450
    //   58: invokevirtual 1240	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   61: pop
    //   62: lload_2
    //   63: lstore_0
    //   64: aload 9
    //   66: getfield 1443	com/tencent/mm/plugin/sns/storage/n:iFy	Lcom/tencent/mm/storagebase/h;
    //   69: ldc_w 1253
    //   72: getstatic 1454	com/tencent/mm/plugin/sns/storage/n:SQL_CREATE	[Ljava/lang/String;
    //   75: iconst_0
    //   76: aaload
    //   77: invokevirtual 1240	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   80: pop
    //   81: aload 9
    //   83: getfield 1443	com/tencent/mm/plugin/sns/storage/n:iFy	Lcom/tencent/mm/storagebase/h;
    //   86: lload_2
    //   87: invokevirtual 1458	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   90: pop
    //   91: ldc_w 1460
    //   94: ldc_w 1462
    //   97: iconst_1
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: invokestatic 1152	java/lang/System:currentTimeMillis	()J
    //   106: lload 6
    //   108: lsub
    //   109: invokestatic 1201	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   112: aastore
    //   113: invokestatic 648	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: invokestatic 1464	com/tencent/mm/plugin/sns/model/aj:faS	()Lcom/tencent/mm/plugin/sns/storage/m;
    //   119: astore 9
    //   121: invokestatic 1152	java/lang/System:currentTimeMillis	()J
    //   124: lstore 6
    //   126: aload 9
    //   128: getfield 1465	com/tencent/mm/plugin/sns/storage/m:iFy	Lcom/tencent/mm/storagebase/h;
    //   131: ldc2_w 1444
    //   134: invokevirtual 1448	com/tencent/mm/storagebase/h:beginTransaction	(J)J
    //   137: lstore_2
    //   138: lload_2
    //   139: lstore_0
    //   140: aload 9
    //   142: getfield 1465	com/tencent/mm/plugin/sns/storage/m:iFy	Lcom/tencent/mm/storagebase/h;
    //   145: ldc_w 1229
    //   148: ldc_w 1467
    //   151: invokevirtual 1240	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   154: pop
    //   155: lload_2
    //   156: lstore_0
    //   157: aload 9
    //   159: getfield 1465	com/tencent/mm/plugin/sns/storage/m:iFy	Lcom/tencent/mm/storagebase/h;
    //   162: ldc_w 1229
    //   165: getstatic 1468	com/tencent/mm/plugin/sns/storage/m:SQL_CREATE	[Ljava/lang/String;
    //   168: iconst_0
    //   169: aaload
    //   170: invokevirtual 1240	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   173: pop
    //   174: aload 9
    //   176: getfield 1465	com/tencent/mm/plugin/sns/storage/m:iFy	Lcom/tencent/mm/storagebase/h;
    //   179: lload_2
    //   180: invokevirtual 1458	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   183: pop
    //   184: ldc_w 1470
    //   187: ldc_w 1462
    //   190: iconst_1
    //   191: anewarray 4	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: invokestatic 1152	java/lang/System:currentTimeMillis	()J
    //   199: lload 6
    //   201: lsub
    //   202: invokestatic 1201	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   205: aastore
    //   206: invokestatic 648	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: invokestatic 1472	com/tencent/mm/plugin/sns/model/aj:faX	()Lcom/tencent/mm/plugin/sns/storage/v;
    //   212: astore 9
    //   214: invokestatic 1152	java/lang/System:currentTimeMillis	()J
    //   217: lstore 6
    //   219: aload 9
    //   221: getfield 1473	com/tencent/mm/plugin/sns/storage/v:iFy	Lcom/tencent/mm/storagebase/h;
    //   224: ldc2_w 1444
    //   227: invokevirtual 1448	com/tencent/mm/storagebase/h:beginTransaction	(J)J
    //   230: lstore_2
    //   231: lload_2
    //   232: lstore_0
    //   233: aload 9
    //   235: getfield 1473	com/tencent/mm/plugin/sns/storage/v:iFy	Lcom/tencent/mm/storagebase/h;
    //   238: ldc_w 1475
    //   241: ldc_w 1477
    //   244: invokevirtual 1240	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   247: pop
    //   248: lload_2
    //   249: lstore_0
    //   250: aload 9
    //   252: getfield 1473	com/tencent/mm/plugin/sns/storage/v:iFy	Lcom/tencent/mm/storagebase/h;
    //   255: ldc_w 1475
    //   258: getstatic 1478	com/tencent/mm/plugin/sns/storage/v:SQL_CREATE	[Ljava/lang/String;
    //   261: iconst_0
    //   262: aaload
    //   263: invokevirtual 1240	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   266: pop
    //   267: lload_2
    //   268: lstore_0
    //   269: aload 9
    //   271: getfield 1482	com/tencent/mm/plugin/sns/storage/v:EmT	Ljava/util/Map;
    //   274: invokeinterface 1487 1 0
    //   279: aload 9
    //   281: getfield 1473	com/tencent/mm/plugin/sns/storage/v:iFy	Lcom/tencent/mm/storagebase/h;
    //   284: lload_2
    //   285: invokevirtual 1458	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   288: pop
    //   289: ldc_w 1489
    //   292: ldc_w 1462
    //   295: iconst_1
    //   296: anewarray 4	java/lang/Object
    //   299: dup
    //   300: iconst_0
    //   301: invokestatic 1152	java/lang/System:currentTimeMillis	()J
    //   304: lload 6
    //   306: lsub
    //   307: invokestatic 1201	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   310: aastore
    //   311: invokestatic 648	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   314: invokestatic 1491	com/tencent/mm/plugin/sns/model/aj:faW	()Lcom/tencent/mm/plugin/sns/storage/x;
    //   317: astore 8
    //   319: invokestatic 1152	java/lang/System:currentTimeMillis	()J
    //   322: lstore 6
    //   324: lload 4
    //   326: lstore_0
    //   327: lload 4
    //   329: lstore_2
    //   330: aload 8
    //   332: getfield 1492	com/tencent/mm/plugin/sns/storage/x:iFy	Lcom/tencent/mm/storagebase/h;
    //   335: ldc2_w 1444
    //   338: invokevirtual 1448	com/tencent/mm/storagebase/h:beginTransaction	(J)J
    //   341: lstore 4
    //   343: lload 4
    //   345: lstore_0
    //   346: lload 4
    //   348: lstore_2
    //   349: aload 8
    //   351: getfield 1492	com/tencent/mm/plugin/sns/storage/x:iFy	Lcom/tencent/mm/storagebase/h;
    //   354: ldc_w 1494
    //   357: ldc_w 1496
    //   360: invokevirtual 1240	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   363: pop
    //   364: lload 4
    //   366: lstore_0
    //   367: lload 4
    //   369: lstore_2
    //   370: aload 8
    //   372: getfield 1492	com/tencent/mm/plugin/sns/storage/x:iFy	Lcom/tencent/mm/storagebase/h;
    //   375: ldc_w 1494
    //   378: getstatic 1497	com/tencent/mm/plugin/sns/storage/x:SQL_CREATE	[Ljava/lang/String;
    //   381: iconst_0
    //   382: aaload
    //   383: invokevirtual 1240	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   386: pop
    //   387: aload 8
    //   389: getfield 1492	com/tencent/mm/plugin/sns/storage/x:iFy	Lcom/tencent/mm/storagebase/h;
    //   392: lload 4
    //   394: invokevirtual 1458	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   397: pop
    //   398: ldc_w 1499
    //   401: ldc_w 1462
    //   404: iconst_1
    //   405: anewarray 4	java/lang/Object
    //   408: dup
    //   409: iconst_0
    //   410: invokestatic 1152	java/lang/System:currentTimeMillis	()J
    //   413: lload 6
    //   415: lsub
    //   416: invokestatic 1201	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   419: aastore
    //   420: invokestatic 648	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: getstatic 783	com/tencent/mm/plugin/sns/b/o:DCR	Lcom/tencent/mm/plugin/sns/b/i;
    //   426: iconst_2
    //   427: invokestatic 1504	com/tencent/mm/model/z:aTY	()Ljava/lang/String;
    //   430: iconst_1
    //   431: iconst_0
    //   432: invokeinterface 1509 5 0
    //   437: ldc_w 1425
    //   440: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   443: return
    //   444: astore 8
    //   446: lconst_0
    //   447: lstore_2
    //   448: lload_2
    //   449: lstore_0
    //   450: ldc_w 1460
    //   453: new 491	java/lang/StringBuilder
    //   456: dup
    //   457: ldc_w 1511
    //   460: invokespecial 496	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   463: aload 8
    //   465: invokevirtual 1514	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   468: invokevirtual 636	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 514	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 1306	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: aload 9
    //   479: getfield 1443	com/tencent/mm/plugin/sns/storage/n:iFy	Lcom/tencent/mm/storagebase/h;
    //   482: lload_2
    //   483: invokevirtual 1458	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   486: pop
    //   487: goto -396 -> 91
    //   490: astore 8
    //   492: lconst_0
    //   493: lstore_0
    //   494: aload 9
    //   496: getfield 1443	com/tencent/mm/plugin/sns/storage/n:iFy	Lcom/tencent/mm/storagebase/h;
    //   499: lload_0
    //   500: invokevirtual 1458	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   503: pop
    //   504: ldc_w 1425
    //   507: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   510: aload 8
    //   512: athrow
    //   513: astore 8
    //   515: lconst_0
    //   516: lstore_2
    //   517: lload_2
    //   518: lstore_0
    //   519: ldc_w 1470
    //   522: new 491	java/lang/StringBuilder
    //   525: dup
    //   526: ldc_w 1511
    //   529: invokespecial 496	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   532: aload 8
    //   534: invokevirtual 1514	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   537: invokevirtual 636	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokevirtual 514	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokestatic 1306	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   546: aload 9
    //   548: getfield 1465	com/tencent/mm/plugin/sns/storage/m:iFy	Lcom/tencent/mm/storagebase/h;
    //   551: lload_2
    //   552: invokevirtual 1458	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   555: pop
    //   556: goto -372 -> 184
    //   559: astore 8
    //   561: lconst_0
    //   562: lstore_0
    //   563: aload 9
    //   565: getfield 1465	com/tencent/mm/plugin/sns/storage/m:iFy	Lcom/tencent/mm/storagebase/h;
    //   568: lload_0
    //   569: invokevirtual 1458	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   572: pop
    //   573: ldc_w 1425
    //   576: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   579: aload 8
    //   581: athrow
    //   582: astore 8
    //   584: lconst_0
    //   585: lstore_2
    //   586: lload_2
    //   587: lstore_0
    //   588: ldc_w 1489
    //   591: new 491	java/lang/StringBuilder
    //   594: dup
    //   595: ldc_w 1511
    //   598: invokespecial 496	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   601: aload 8
    //   603: invokevirtual 1514	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   606: invokevirtual 636	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: invokevirtual 514	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokestatic 1306	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   615: aload 9
    //   617: getfield 1473	com/tencent/mm/plugin/sns/storage/v:iFy	Lcom/tencent/mm/storagebase/h;
    //   620: lload_2
    //   621: invokevirtual 1458	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   624: pop
    //   625: goto -336 -> 289
    //   628: astore 8
    //   630: lconst_0
    //   631: lstore_0
    //   632: aload 9
    //   634: getfield 1473	com/tencent/mm/plugin/sns/storage/v:iFy	Lcom/tencent/mm/storagebase/h;
    //   637: lload_0
    //   638: invokevirtual 1458	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   641: pop
    //   642: ldc_w 1425
    //   645: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   648: aload 8
    //   650: athrow
    //   651: astore 9
    //   653: lload_0
    //   654: lstore_2
    //   655: ldc_w 1499
    //   658: new 491	java/lang/StringBuilder
    //   661: dup
    //   662: ldc_w 1511
    //   665: invokespecial 496	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   668: aload 9
    //   670: invokevirtual 1514	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   673: invokevirtual 636	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: invokevirtual 514	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: invokestatic 1306	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   682: aload 8
    //   684: getfield 1492	com/tencent/mm/plugin/sns/storage/x:iFy	Lcom/tencent/mm/storagebase/h;
    //   687: lload_0
    //   688: invokevirtual 1458	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   691: pop
    //   692: goto -294 -> 398
    //   695: astore 9
    //   697: aload 8
    //   699: getfield 1492	com/tencent/mm/plugin/sns/storage/x:iFy	Lcom/tencent/mm/storagebase/h;
    //   702: lload_2
    //   703: invokevirtual 1458	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   706: pop
    //   707: ldc_w 1425
    //   710: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   713: aload 9
    //   715: athrow
    //   716: astore 8
    //   718: goto -86 -> 632
    //   721: astore 8
    //   723: goto -137 -> 586
    //   726: astore 8
    //   728: goto -165 -> 563
    //   731: astore 8
    //   733: goto -216 -> 517
    //   736: astore 8
    //   738: goto -244 -> 494
    //   741: astore 8
    //   743: goto -295 -> 448
    // Local variable table:
    //   start	length	slot	name	signature
    //   46	642	0	l1	long
    //   44	659	2	l2	long
    //   1	392	4	l3	long
    //   31	383	6	l4	long
    //   317	71	8	localx	x
    //   444	20	8	localException1	Exception
    //   490	21	8	localObject1	Object
    //   513	20	8	localException2	Exception
    //   559	21	8	localObject2	Object
    //   582	20	8	localException3	Exception
    //   628	70	8	localObject3	Object
    //   716	1	8	localObject4	Object
    //   721	1	8	localException4	Exception
    //   726	1	8	localObject5	Object
    //   731	1	8	localException5	Exception
    //   736	1	8	localObject6	Object
    //   741	1	8	localException6	Exception
    //   26	607	9	localObject7	Object
    //   651	18	9	localException7	Exception
    //   695	19	9	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   33	45	444	java/lang/Exception
    //   33	45	490	finally
    //   126	138	513	java/lang/Exception
    //   126	138	559	finally
    //   219	231	582	java/lang/Exception
    //   219	231	628	finally
    //   330	343	651	java/lang/Exception
    //   349	364	651	java/lang/Exception
    //   370	387	651	java/lang/Exception
    //   330	343	695	finally
    //   349	364	695	finally
    //   370	387	695	finally
    //   655	682	695	finally
    //   233	248	716	finally
    //   250	267	716	finally
    //   269	279	716	finally
    //   588	615	716	finally
    //   233	248	721	java/lang/Exception
    //   250	267	721	java/lang/Exception
    //   269	279	721	java/lang/Exception
    //   140	155	726	finally
    //   157	174	726	finally
    //   519	546	726	finally
    //   140	155	731	java/lang/Exception
    //   157	174	731	java/lang/Exception
    //   47	62	736	finally
    //   64	81	736	finally
    //   450	477	736	finally
    //   47	62	741	java/lang/Exception
    //   64	81	741	java/lang/Exception
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(95792);
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.kernel.g.aAi();
    String str = com.tencent.mm.kernel.g.aAh().hqG;
    AppMethodBeat.o(95792);
    return str;
  }
  
  public static String getAccSnsPath()
  {
    AppMethodBeat.i(95805);
    String str = ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath();
    AppMethodBeat.o(95805);
    return str;
  }
  
  public static String getAccSnsTmpPath()
  {
    AppMethodBeat.i(95806);
    String str = ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsTmpPath();
    AppMethodBeat.o(95806);
    return str;
  }
  
  public static com.tencent.mm.storagebase.h getDataDB()
  {
    AppMethodBeat.i(95795);
    com.tencent.mm.storagebase.h localh = faw().hqK;
    AppMethodBeat.o(95795);
    return localh;
  }
  
  public static String getSnsAdPath()
  {
    AppMethodBeat.i(95807);
    String str = ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.sns.b.c.class)).getSnsAdPath();
    AppMethodBeat.o(95807);
    return str;
  }
  
  public static boolean isInValid()
  {
    AppMethodBeat.i(95797);
    faw();
    if (!com.tencent.mm.kernel.g.aAf().azp())
    {
      AppMethodBeat.o(95797);
      return true;
    }
    AppMethodBeat.o(95797);
    return false;
  }
  
  public static void k(Point paramPoint)
  {
    imX = paramPoint;
  }
  
  public final void a(bb parambb)
  {
    AppMethodBeat.i(95837);
    v.a(parambb);
    AppMethodBeat.o(95837);
  }
  
  public final void b(bb parambb)
  {
    AppMethodBeat.i(95838);
    v.b(parambb);
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
    Log.i("MicroMsg.SnsCore", "onAccountPostReset " + Thread.currentThread().getId() + " isAccInit: " + this.DKP);
    if (this.DKP)
    {
      AppMethodBeat.o(95834);
      return;
    }
    this.DKP = true;
    this.tnN = true;
    checkDir();
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("NewYearSNSCtrl2016", this.DKW, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("NewYearSNSTips2016", this.DKX, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("NewYearSNSAmountLevelCtrl2016", this.DKY, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("SnsAd", this.DKZ, true);
    com.tencent.mm.plugin.sns.b.o.DCL = faK();
    com.tencent.mm.plugin.sns.b.o.DCM = faL();
    com.tencent.mm.plugin.sns.b.o.DCN = faS();
    com.tencent.mm.plugin.sns.b.o.DCO = faT();
    com.tencent.mm.plugin.sns.b.o.DCP = faU();
    com.tencent.mm.plugin.sns.b.o.DCR = faE();
    com.tencent.mm.plugin.sns.b.o.DCQ = this;
    com.tencent.mm.plugin.sns.b.o.DCS = faO();
    EventCenter.instance.addListener(this.DLF);
    EventCenter.instance.addListener(this.DLG);
    EventCenter.instance.addListener(this.DLs);
    EventCenter.instance.addListener(this.DLq);
    EventCenter.instance.addListener(this.DLr);
    EventCenter.instance.addListener(this.DLt);
    EventCenter.instance.addListener(this.DLu);
    EventCenter.instance.addListener(this.DLv);
    EventCenter.instance.addListener(this.DLw);
    EventCenter.instance.addListener(this.DLx);
    EventCenter.instance.addListener(this.DLz);
    EventCenter.instance.addListener(this.DLA);
    EventCenter.instance.addListener(this.DLB);
    EventCenter.instance.addListener(this.DLJ);
    EventCenter.instance.addListener(this.DLK);
    appForegroundListener.alive();
    this.DLd = new com.tencent.mm.plugin.sns.n();
    this.DLe = new com.tencent.mm.plugin.sns.k();
    this.DLf = new com.tencent.mm.plugin.sns.e();
    this.DLg = new q();
    this.DLh = new com.tencent.mm.plugin.sns.h();
    this.DLi = new com.tencent.mm.plugin.sns.g();
    this.DLj = new com.tencent.mm.plugin.sns.m();
    this.DLk = new com.tencent.mm.plugin.sns.j();
    this.DLl = new com.tencent.mm.plugin.sns.b();
    this.DLm = new com.tencent.mm.plugin.sns.c();
    this.DLn = new com.tencent.mm.plugin.sns.f();
    EventCenter.instance.addListener(this.DLE);
    EventCenter.instance.addListener(this.DLD);
    EventCenter.instance.addListener(this.DLg);
    EventCenter.instance.addListener(this.DLd);
    EventCenter.instance.addListener(this.DLe);
    EventCenter.instance.addListener(this.DLf);
    EventCenter.instance.addListener(this.DLh);
    EventCenter.instance.addListener(this.DLi);
    EventCenter.instance.addListener(this.DLj);
    EventCenter.instance.addListener(this.DLk);
    EventCenter.instance.addListener(this.DLl);
    EventCenter.instance.addListener(this.DLm);
    EventCenter.instance.addListener(this.DLn);
    EventCenter.instance.addListener(this.AgM);
    this.DKT = new com.tencent.mm.plugin.sns.d();
    EventCenter.instance.addListener(this.DKT);
    EventCenter.instance.addListener(this.DLI);
    EventCenter.instance.addListener(this.DLo);
    EventCenter.instance.addListener(this.DLp);
    EventCenter.instance.addListener(this.DLC);
    EventCenter.instance.addListener(this.DLy);
    Object localObject1 = faI();
    com.tencent.mm.plugin.sns.ad.g.m.Dwb = com.tencent.mm.n.h.aqJ().getInt("MMUxAdLog2GSendSize", 20480);
    com.tencent.mm.plugin.sns.ad.g.m.Dwc = com.tencent.mm.n.h.aqJ().getInt("MMUxAdLog3GSendSize", 30720);
    com.tencent.mm.plugin.sns.ad.g.m.Dwd = com.tencent.mm.n.h.aqJ().getInt("MMUxAdLogWifiSendSize", 51200);
    com.tencent.mm.plugin.sns.ad.g.m.Dwe = com.tencent.mm.n.h.aqJ().getInt("MMUxAdLogMinRandTime", 60);
    com.tencent.mm.plugin.sns.ad.g.m.Dwf = com.tencent.mm.n.h.aqJ().getInt("MMUxAdLogMaxRandTime", 1800);
    com.tencent.mm.plugin.sns.ad.g.m.Dwg = com.tencent.mm.n.h.aqJ().getInt("MMUxAdLogMaxExceptionTime", 43200);
    Log.i("MicroMsg.SnsLogMgr", "init " + com.tencent.mm.plugin.sns.ad.g.m.Dwb + ";" + com.tencent.mm.plugin.sns.ad.g.m.Dwc + ";" + com.tencent.mm.plugin.sns.ad.g.m.Dwd + ";" + com.tencent.mm.plugin.sns.ad.g.m.Dwe + ";" + com.tencent.mm.plugin.sns.ad.g.m.Dwf + ";" + com.tencent.mm.plugin.sns.ad.g.m.Dwg);
    if (com.tencent.mm.plugin.sns.ad.g.m.Dwf - com.tencent.mm.plugin.sns.ad.g.m.Dwe < 0) {
      com.tencent.mm.plugin.sns.ad.g.m.Dwf = com.tencent.mm.plugin.sns.ad.g.m.Dwe;
    }
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(1802, (com.tencent.mm.ak.i)localObject1);
    localObject1 = faK();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(207, (com.tencent.mm.ak.i)localObject1);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(209, (com.tencent.mm.ak.i)localObject1);
    localObject1 = this.DKM;
    EventCenter.instance.addListener(((as)localObject1).DML);
    EventCenter.instance.addListener(((as)localObject1).DMM);
    EventCenter.instance.addListener(((as)localObject1).DMN);
    this.DKU = new com.tencent.mm.plugin.sns.g.a();
    au.init();
    localObject1 = com.tencent.mm.modelsns.l.jlw;
    com.tencent.mm.modelsns.l.bfL();
    ah.far();
    if (com.tencent.mm.memory.l.aRZ())
    {
      localObject1 = com.tencent.mm.memory.c.itr;
      localObject2 = com.tencent.mm.memory.c.itr;
      localObject2.getClass();
      ((com.tencent.mm.memory.c)localObject1).a(new e.a((com.tencent.mm.memory.c)localObject2)
      {
        final int DLN;
        
        public final long aRU()
        {
          return 10485760L;
        }
        
        public final int aRV()
        {
          return -1;
        }
      });
    }
    localObject1 = o.itM;
    Object localObject2 = o.itM;
    localObject2.getClass();
    ((o)localObject1).a(new e.a((o)localObject2)
    {
      public final long aRU()
      {
        return -1L;
      }
      
      public final int aRV()
      {
        return 3;
      }
    });
    localObject1 = com.tencent.mm.memory.g.ity;
    localObject2 = com.tencent.mm.memory.g.ity;
    localObject2.getClass();
    ((com.tencent.mm.memory.g)localObject1).a(new e.a((com.tencent.mm.memory.g)localObject2)
    {
      public final long aRU()
      {
        return 0L;
      }
      
      public final int aRV()
      {
        return 5;
      }
    });
    faM();
    com.tencent.mm.plugin.sns.f.a.init();
    try
    {
      localObject1 = MultiProcessMMKV.getMMKV("TrackDataSource");
      if (!Util.isNullOrNil(((MultiProcessMMKV)localObject1).getString("path", "")))
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(150, 74);
        com.tencent.mm.plugin.report.service.h.CyF.a(17832, new Object[] { Integer.valueOf(((MultiProcessMMKV)localObject1).getInt("type", 0)), ((MultiProcessMMKV)localObject1).getString("path", ""), Long.valueOf(((MultiProcessMMKV)localObject1).getLong("ts", 0L)), ((MultiProcessMMKV)localObject1).getString("media-url", ""), ((MultiProcessMMKV)localObject1).getString("thumb-url", ""), Long.valueOf(((MultiProcessMMKV)localObject1).getLong("prepare-ts", 0L)), ((MultiProcessMMKV)localObject1).getString("prepare-path", "") });
        ((MultiProcessMMKV)localObject1).putInt("type", 0);
        ((MultiProcessMMKV)localObject1).putString("path", "");
        ((MultiProcessMMKV)localObject1).putLong("ts", 0L);
        ((MultiProcessMMKV)localObject1).putString("media-url", "");
        ((MultiProcessMMKV)localObject1).putString("thumb-url", "");
        ((MultiProcessMMKV)localObject1).putLong("prepare-ts", 0L);
        ((MultiProcessMMKV)localObject1).commit();
      }
      faw().handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(202743);
          aj.faK().a(aj.a(aj.this));
          AppMethodBeat.o(202743);
        }
      });
      AppMethodBeat.o(95834);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.SnsCore", localThrowable, "videoCrashKvReport", new Object[0]);
      }
    }
  }
  
  /* Error */
  public final void onAccountRelease()
  {
    // Byte code:
    //   0: ldc_w 1891
    //   3: invokestatic 242	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 1709	com/tencent/mm/plugin/sns/model/aj:faI	()Lcom/tencent/mm/plugin/sns/ad/g/m;
    //   9: astore_1
    //   10: invokestatic 739	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   13: pop
    //   14: invokestatic 1752	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   17: getfield 1758	com/tencent/mm/kernel/b:hqi	Lcom/tencent/mm/ak/t;
    //   20: sipush 1802
    //   23: aload_1
    //   24: invokevirtual 1893	com/tencent/mm/ak/t:b	(ILcom/tencent/mm/ak/i;)V
    //   27: aload_0
    //   28: getfield 360	com/tencent/mm/plugin/sns/model/aj:DKM	Lcom/tencent/mm/plugin/sns/model/as;
    //   31: astore_1
    //   32: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   35: aload_1
    //   36: getfield 1766	com/tencent/mm/plugin/sns/model/as:DML	Lcom/tencent/mm/sdk/event/IListener;
    //   39: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   42: pop
    //   43: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   46: aload_1
    //   47: getfield 1769	com/tencent/mm/plugin/sns/model/as:DMM	Lcom/tencent/mm/sdk/event/IListener;
    //   50: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   53: pop
    //   54: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   57: aload_1
    //   58: getfield 1772	com/tencent/mm/plugin/sns/model/as:DMN	Lcom/tencent/mm/sdk/event/IListener;
    //   61: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   64: pop
    //   65: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   68: aload_0
    //   69: getfield 461	com/tencent/mm/plugin/sns/model/aj:DLF	Lcom/tencent/mm/sdk/event/IListener;
    //   72: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   75: pop
    //   76: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   79: aload_0
    //   80: getfield 466	com/tencent/mm/plugin/sns/model/aj:DLG	Lcom/tencent/mm/sdk/event/IListener;
    //   83: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   86: pop
    //   87: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   90: aload_0
    //   91: getfield 458	com/tencent/mm/plugin/sns/model/aj:DLE	Lcom/tencent/mm/sdk/event/IListener;
    //   94: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   97: pop
    //   98: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   101: aload_0
    //   102: getfield 455	com/tencent/mm/plugin/sns/model/aj:DLD	Lcom/tencent/mm/sdk/event/IListener;
    //   105: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   108: pop
    //   109: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   112: aload_0
    //   113: getfield 416	com/tencent/mm/plugin/sns/model/aj:DLs	Lcom/tencent/mm/sdk/event/IListener;
    //   116: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   119: pop
    //   120: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   123: aload_0
    //   124: getfield 410	com/tencent/mm/plugin/sns/model/aj:DLq	Lcom/tencent/mm/sdk/event/IListener;
    //   127: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   130: pop
    //   131: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   134: aload_0
    //   135: getfield 413	com/tencent/mm/plugin/sns/model/aj:DLr	Lcom/tencent/mm/sdk/event/IListener;
    //   138: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   141: pop
    //   142: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   145: aload_0
    //   146: getfield 419	com/tencent/mm/plugin/sns/model/aj:DLt	Lcom/tencent/mm/sdk/event/IListener;
    //   149: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   152: pop
    //   153: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   156: aload_0
    //   157: getfield 422	com/tencent/mm/plugin/sns/model/aj:DLu	Lcom/tencent/mm/sdk/event/IListener;
    //   160: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   163: pop
    //   164: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   167: aload_0
    //   168: getfield 425	com/tencent/mm/plugin/sns/model/aj:DLv	Lcom/tencent/mm/sdk/event/IListener;
    //   171: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   174: pop
    //   175: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   178: aload_0
    //   179: getfield 1667	com/tencent/mm/plugin/sns/model/aj:DLg	Lcom/tencent/mm/plugin/sns/q;
    //   182: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   185: pop
    //   186: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   189: aload_0
    //   190: getfield 1672	com/tencent/mm/plugin/sns/model/aj:DLh	Lcom/tencent/mm/plugin/sns/h;
    //   193: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   196: pop
    //   197: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   200: aload_0
    //   201: getfield 433	com/tencent/mm/plugin/sns/model/aj:DLx	Lcom/tencent/mm/sdk/event/IListener;
    //   204: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   207: pop
    //   208: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   211: aload_0
    //   212: getfield 441	com/tencent/mm/plugin/sns/model/aj:DLz	Lcom/tencent/mm/sdk/event/IListener;
    //   215: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   218: pop
    //   219: getstatic 336	com/tencent/mm/plugin/sns/model/aj:appForegroundListener	Lcom/tencent/mm/app/o$a;
    //   222: invokevirtual 1899	com/tencent/mm/app/o$a:dead	()V
    //   225: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   228: aload_0
    //   229: getfield 1652	com/tencent/mm/plugin/sns/model/aj:DLd	Lcom/tencent/mm/plugin/sns/n;
    //   232: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   235: pop
    //   236: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   239: aload_0
    //   240: getfield 1657	com/tencent/mm/plugin/sns/model/aj:DLe	Lcom/tencent/mm/plugin/sns/k;
    //   243: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   246: pop
    //   247: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   250: aload_0
    //   251: getfield 1662	com/tencent/mm/plugin/sns/model/aj:DLf	Lcom/tencent/mm/plugin/sns/e;
    //   254: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   257: pop
    //   258: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   261: aload_0
    //   262: getfield 1677	com/tencent/mm/plugin/sns/model/aj:DLi	Lcom/tencent/mm/plugin/sns/g;
    //   265: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   268: pop
    //   269: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   272: aload_0
    //   273: getfield 1682	com/tencent/mm/plugin/sns/model/aj:DLj	Lcom/tencent/mm/plugin/sns/m;
    //   276: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   279: pop
    //   280: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   283: aload_0
    //   284: getfield 1687	com/tencent/mm/plugin/sns/model/aj:DLk	Lcom/tencent/mm/plugin/sns/j;
    //   287: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   290: pop
    //   291: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   294: aload_0
    //   295: getfield 1692	com/tencent/mm/plugin/sns/model/aj:DLl	Lcom/tencent/mm/plugin/sns/b;
    //   298: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   301: pop
    //   302: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   305: aload_0
    //   306: getfield 1697	com/tencent/mm/plugin/sns/model/aj:DLm	Lcom/tencent/mm/plugin/sns/c;
    //   309: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   312: pop
    //   313: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   316: aload_0
    //   317: getfield 1702	com/tencent/mm/plugin/sns/model/aj:DLn	Lcom/tencent/mm/plugin/sns/f;
    //   320: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   323: pop
    //   324: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   327: aload_0
    //   328: getfield 430	com/tencent/mm/plugin/sns/model/aj:DLw	Lcom/tencent/mm/sdk/event/IListener;
    //   331: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   334: pop
    //   335: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   338: aload_0
    //   339: getfield 1707	com/tencent/mm/plugin/sns/model/aj:DKT	Lcom/tencent/mm/plugin/sns/d;
    //   342: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   345: pop
    //   346: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   349: aload_0
    //   350: getfield 446	com/tencent/mm/plugin/sns/model/aj:DLA	Lcom/tencent/mm/sdk/event/IListener;
    //   353: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   356: pop
    //   357: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   360: aload_0
    //   361: getfield 449	com/tencent/mm/plugin/sns/model/aj:DLB	Lcom/tencent/mm/sdk/event/IListener;
    //   364: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   367: pop
    //   368: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   371: aload_0
    //   372: getfield 471	com/tencent/mm/plugin/sns/model/aj:AgM	Lcom/tencent/mm/sdk/event/IListener;
    //   375: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   378: pop
    //   379: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   382: aload_0
    //   383: getfield 474	com/tencent/mm/plugin/sns/model/aj:DLI	Lcom/tencent/mm/sdk/event/IListener;
    //   386: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   389: pop
    //   390: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   393: aload_0
    //   394: getfield 452	com/tencent/mm/plugin/sns/model/aj:DLC	Lcom/tencent/mm/sdk/event/IListener;
    //   397: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   400: pop
    //   401: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   404: aload_0
    //   405: getfield 402	com/tencent/mm/plugin/sns/model/aj:DLo	Lcom/tencent/mm/sdk/event/IListener;
    //   408: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   411: pop
    //   412: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   415: aload_0
    //   416: getfield 405	com/tencent/mm/plugin/sns/model/aj:DLp	Lcom/tencent/mm/sdk/event/IListener;
    //   419: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   422: pop
    //   423: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   426: aload_0
    //   427: getfield 477	com/tencent/mm/plugin/sns/model/aj:DLJ	Lcom/tencent/mm/sdk/event/IListener;
    //   430: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   433: pop
    //   434: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   437: aload_0
    //   438: getfield 436	com/tencent/mm/plugin/sns/model/aj:DLy	Lcom/tencent/mm/sdk/event/IListener;
    //   441: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   444: pop
    //   445: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   448: aload_0
    //   449: getfield 482	com/tencent/mm/plugin/sns/model/aj:DLK	Lcom/tencent/mm/sdk/event/IListener;
    //   452: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   455: pop
    //   456: getstatic 1905	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a$e:DXp	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a;
    //   459: astore_1
    //   460: aload_1
    //   461: getfield 1910	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:DXi	Z
    //   464: ifeq +27 -> 491
    //   467: ldc_w 1912
    //   470: ldc_w 1914
    //   473: invokestatic 1916	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   476: invokestatic 267	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   479: aload_1
    //   480: getfield 1920	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:DXh	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a$a;
    //   483: invokevirtual 1924	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   486: aload_1
    //   487: iconst_0
    //   488: putfield 1910	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:DXi	Z
    //   491: invokestatic 1930	com/tencent/mm/plugin/downloader/model/f:cBv	()Lcom/tencent/mm/plugin/downloader/model/f;
    //   494: pop
    //   495: aload_1
    //   496: getfield 1934	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:DXm	Lcom/tencent/mm/plugin/downloader/model/m;
    //   499: invokestatic 1939	com/tencent/mm/plugin/downloader/model/c:b	(Lcom/tencent/mm/plugin/downloader/model/m;)V
    //   502: ldc_w 1601
    //   505: invokestatic 667	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   508: checkcast 1601	com/tencent/mm/plugin/messenger/foundation/a/s
    //   511: invokeinterface 1605 1 0
    //   516: ldc_w 1607
    //   519: aload_0
    //   520: getfield 380	com/tencent/mm/plugin/sns/model/aj:DKW	Lcom/tencent/mm/plugin/sns/lucky/a/f;
    //   523: iconst_1
    //   524: invokevirtual 1941	com/tencent/mm/model/cj:b	(Ljava/lang/String;Lcom/tencent/mm/model/cj$a;Z)V
    //   527: ldc_w 1601
    //   530: invokestatic 667	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   533: checkcast 1601	com/tencent/mm/plugin/messenger/foundation/a/s
    //   536: invokeinterface 1605 1 0
    //   541: ldc_w 1614
    //   544: aload_0
    //   545: getfield 385	com/tencent/mm/plugin/sns/model/aj:DKX	Lcom/tencent/mm/plugin/sns/lucky/a/j;
    //   548: iconst_1
    //   549: invokevirtual 1941	com/tencent/mm/model/cj:b	(Ljava/lang/String;Lcom/tencent/mm/model/cj$a;Z)V
    //   552: ldc_w 1601
    //   555: invokestatic 667	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   558: checkcast 1601	com/tencent/mm/plugin/messenger/foundation/a/s
    //   561: invokeinterface 1605 1 0
    //   566: ldc_w 1616
    //   569: aload_0
    //   570: getfield 390	com/tencent/mm/plugin/sns/model/aj:DKY	Lcom/tencent/mm/plugin/sns/lucky/a/d;
    //   573: iconst_1
    //   574: invokevirtual 1941	com/tencent/mm/model/cj:b	(Ljava/lang/String;Lcom/tencent/mm/model/cj$a;Z)V
    //   577: ldc_w 1601
    //   580: invokestatic 667	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   583: checkcast 1601	com/tencent/mm/plugin/messenger/foundation/a/s
    //   586: invokeinterface 1605 1 0
    //   591: ldc_w 1618
    //   594: aload_0
    //   595: getfield 395	com/tencent/mm/plugin/sns/model/aj:DKZ	Lcom/tencent/mm/plugin/sns/lucky/a/l;
    //   598: iconst_1
    //   599: invokevirtual 1941	com/tencent/mm/model/cj:b	(Ljava/lang/String;Lcom/tencent/mm/model/cj$a;Z)V
    //   602: invokestatic 579	com/tencent/mm/plugin/sns/model/aj:faw	()Lcom/tencent/mm/plugin/sns/model/aj;
    //   605: getfield 355	com/tencent/mm/plugin/sns/model/aj:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   608: new 80	com/tencent/mm/plugin/sns/model/aj$6
    //   611: dup
    //   612: aload_0
    //   613: invokespecial 1942	com/tencent/mm/plugin/sns/model/aj$6:<init>	(Lcom/tencent/mm/plugin/sns/model/aj;)V
    //   616: invokevirtual 1881	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   619: pop
    //   620: invokestatic 1620	com/tencent/mm/plugin/sns/model/aj:faK	()Lcom/tencent/mm/plugin/sns/model/be;
    //   623: astore_1
    //   624: invokestatic 739	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   627: pop
    //   628: invokestatic 1752	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   631: getfield 1758	com/tencent/mm/kernel/b:hqi	Lcom/tencent/mm/ak/t;
    //   634: sipush 207
    //   637: aload_1
    //   638: invokevirtual 1893	com/tencent/mm/ak/t:b	(ILcom/tencent/mm/ak/i;)V
    //   641: invokestatic 739	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   644: pop
    //   645: invokestatic 1752	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   648: getfield 1758	com/tencent/mm/kernel/b:hqi	Lcom/tencent/mm/ak/t;
    //   651: sipush 209
    //   654: aload_1
    //   655: invokevirtual 1893	com/tencent/mm/ak/t:b	(ILcom/tencent/mm/ak/i;)V
    //   658: ldc 2
    //   660: invokestatic 1017	com/tencent/mm/model/y:at	(Ljava/lang/Class;)Lcom/tencent/mm/model/bd;
    //   663: checkcast 2	com/tencent/mm/plugin/sns/model/aj
    //   666: astore_1
    //   667: aload_1
    //   668: ifnull +99 -> 767
    //   671: ldc_w 489
    //   674: ldc_w 1944
    //   677: invokestatic 1946	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   680: aload_1
    //   681: getfield 766	com/tencent/mm/plugin/sns/model/aj:hqK	Lcom/tencent/mm/storagebase/h;
    //   684: ifnull +15 -> 699
    //   687: aload_1
    //   688: getfield 766	com/tencent/mm/plugin/sns/model/aj:hqK	Lcom/tencent/mm/storagebase/h;
    //   691: invokevirtual 1204	com/tencent/mm/storagebase/h:closeDB	()V
    //   694: aload_1
    //   695: aconst_null
    //   696: putfield 766	com/tencent/mm/plugin/sns/model/aj:hqK	Lcom/tencent/mm/storagebase/h;
    //   699: aload_1
    //   700: getfield 521	com/tencent/mm/plugin/sns/model/aj:DKl	Ljava/util/concurrent/ExecutorService;
    //   703: ifnull +13 -> 716
    //   706: aload_1
    //   707: getfield 521	com/tencent/mm/plugin/sns/model/aj:DKl	Ljava/util/concurrent/ExecutorService;
    //   710: invokeinterface 1950 1 0
    //   715: pop
    //   716: aload_1
    //   717: getfield 540	com/tencent/mm/plugin/sns/model/aj:CDQ	Ljava/util/concurrent/ExecutorService;
    //   720: ifnull +13 -> 733
    //   723: aload_1
    //   724: getfield 540	com/tencent/mm/plugin/sns/model/aj:CDQ	Ljava/util/concurrent/ExecutorService;
    //   727: invokeinterface 1950 1 0
    //   732: pop
    //   733: aload_1
    //   734: getfield 544	com/tencent/mm/plugin/sns/model/aj:DKk	Ljava/util/concurrent/ExecutorService;
    //   737: ifnull +13 -> 750
    //   740: aload_1
    //   741: getfield 544	com/tencent/mm/plugin/sns/model/aj:DKk	Ljava/util/concurrent/ExecutorService;
    //   744: invokeinterface 1950 1 0
    //   749: pop
    //   750: aload_1
    //   751: getfield 552	com/tencent/mm/plugin/sns/model/aj:DKm	Ljava/util/concurrent/ExecutorService;
    //   754: ifnull +13 -> 767
    //   757: aload_1
    //   758: getfield 552	com/tencent/mm/plugin/sns/model/aj:DKm	Ljava/util/concurrent/ExecutorService;
    //   761: invokeinterface 1950 1 0
    //   766: pop
    //   767: aload_0
    //   768: getfield 1777	com/tencent/mm/plugin/sns/model/aj:DKU	Lcom/tencent/mm/plugin/sns/g/a;
    //   771: astore_1
    //   772: invokestatic 1952	com/tencent/mm/plugin/sns/model/aj:faJ	()Lcom/tencent/mm/plugin/sns/model/c;
    //   775: aload_1
    //   776: invokevirtual 1955	com/tencent/mm/plugin/sns/model/c:b	(Lcom/tencent/mm/plugin/sns/model/c$b;)V
    //   779: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   782: aload_1
    //   783: getfield 1958	com/tencent/mm/plugin/sns/g/a:DFm	Lcom/tencent/mm/sdk/event/IListener;
    //   786: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   789: pop
    //   790: invokestatic 1961	com/tencent/mm/plugin/sns/model/au:unInit	()V
    //   793: getstatic 1833	com/tencent/mm/memory/g:ity	Lcom/tencent/mm/memory/g;
    //   796: invokevirtual 1964	com/tencent/mm/memory/g:aRR	()V
    //   799: getstatic 1807	com/tencent/mm/memory/c:itr	Lcom/tencent/mm/memory/c;
    //   802: invokevirtual 1965	com/tencent/mm/memory/c:aRR	()V
    //   805: getstatic 1823	com/tencent/mm/memory/o:itM	Lcom/tencent/mm/memory/o;
    //   808: invokevirtual 1966	com/tencent/mm/memory/o:aRR	()V
    //   811: invokestatic 1839	com/tencent/mm/plugin/sns/model/aj:faM	()Lcom/tencent/mm/plugin/sns/model/az;
    //   814: astore_1
    //   815: aload_1
    //   816: aconst_null
    //   817: putfield 1970	com/tencent/mm/plugin/sns/model/az:DOh	Lcom/tencent/mm/plugin/sns/model/bg;
    //   820: aload_1
    //   821: getfield 1974	com/tencent/mm/plugin/sns/model/az:DOl	Ljava/util/LinkedList;
    //   824: astore_2
    //   825: aload_2
    //   826: monitorenter
    //   827: aload_1
    //   828: getfield 1974	com/tencent/mm/plugin/sns/model/az:DOl	Ljava/util/LinkedList;
    //   831: invokevirtual 1977	java/util/LinkedList:clear	()V
    //   834: aload_2
    //   835: monitorexit
    //   836: aload_1
    //   837: getfield 1980	com/tencent/mm/plugin/sns/model/az:DOj	Ljava/util/Map;
    //   840: invokeinterface 1487 1 0
    //   845: aload_1
    //   846: getfield 1983	com/tencent/mm/plugin/sns/model/az:DOi	Ljava/util/LinkedList;
    //   849: invokevirtual 1977	java/util/LinkedList:clear	()V
    //   852: aload_1
    //   853: getfield 1986	com/tencent/mm/plugin/sns/model/az:DOk	Ljava/util/LinkedList;
    //   856: astore_2
    //   857: aload_2
    //   858: monitorenter
    //   859: aload_1
    //   860: getfield 1986	com/tencent/mm/plugin/sns/model/az:DOk	Ljava/util/LinkedList;
    //   863: invokevirtual 1977	java/util/LinkedList:clear	()V
    //   866: aload_2
    //   867: monitorexit
    //   868: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   871: aload_1
    //   872: getfield 1989	com/tencent/mm/plugin/sns/model/az:DOo	Lcom/tencent/mm/sdk/event/IListener;
    //   875: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   878: pop
    //   879: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   882: aload_1
    //   883: getfield 1990	com/tencent/mm/plugin/sns/model/az:DMM	Lcom/tencent/mm/sdk/event/IListener;
    //   886: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   889: pop
    //   890: getstatic 1638	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   893: aload_1
    //   894: getfield 1991	com/tencent/mm/plugin/sns/model/az:DMN	Lcom/tencent/mm/sdk/event/IListener;
    //   897: invokevirtual 1896	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   900: pop
    //   901: invokestatic 1994	com/tencent/mm/plugin/sns/f/a:destroy	()V
    //   904: ldc_w 1891
    //   907: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   910: return
    //   911: astore_2
    //   912: ldc_w 1912
    //   915: ldc_w 1996
    //   918: iconst_1
    //   919: anewarray 4	java/lang/Object
    //   922: dup
    //   923: iconst_0
    //   924: aload_2
    //   925: invokevirtual 1997	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   928: aastore
    //   929: invokestatic 1999	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   932: goto -441 -> 491
    //   935: astore_1
    //   936: aload_2
    //   937: monitorexit
    //   938: ldc_w 1891
    //   941: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   944: aload_1
    //   945: athrow
    //   946: astore_1
    //   947: aload_2
    //   948: monitorexit
    //   949: ldc_w 1891
    //   952: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   955: aload_1
    //   956: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	957	0	this	aj
    //   9	885	1	localObject1	Object
    //   935	10	1	localObject2	Object
    //   946	10	1	localObject3	Object
    //   911	37	2	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   467	491	911	java/lang/IllegalArgumentException
    //   827	836	935	finally
    //   936	938	935	finally
    //   859	868	946	finally
    //   947	949	946	finally
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(95836);
    checkDir();
    AppMethodBeat.o(95836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aj
 * JD-Core Version:    0.7.0.1
 */