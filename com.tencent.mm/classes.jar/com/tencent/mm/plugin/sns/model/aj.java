package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.CancellationSignal;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.cb;
import com.tencent.mm.f.a.di;
import com.tencent.mm.f.a.in;
import com.tencent.mm.f.a.in.a;
import com.tencent.mm.f.a.jv;
import com.tencent.mm.f.a.kt;
import com.tencent.mm.f.a.nn;
import com.tencent.mm.f.a.pg;
import com.tencent.mm.f.a.pg.a;
import com.tencent.mm.f.a.sq;
import com.tencent.mm.f.a.sr;
import com.tencent.mm.f.a.sr.a;
import com.tencent.mm.f.a.ss;
import com.tencent.mm.f.a.ss.a;
import com.tencent.mm.f.a.tb;
import com.tencent.mm.f.a.tb.a;
import com.tencent.mm.f.a.tn;
import com.tencent.mm.f.a.to;
import com.tencent.mm.f.a.wl;
import com.tencent.mm.f.a.wm;
import com.tencent.mm.f.a.wp;
import com.tencent.mm.f.a.wy;
import com.tencent.mm.f.a.yf;
import com.tencent.mm.f.a.yf.a;
import com.tencent.mm.f.a.zl;
import com.tencent.mm.f.a.zz;
import com.tencent.mm.f.b.a.ev;
import com.tencent.mm.f.b.a.kr;
import com.tencent.mm.memory.e.a;
import com.tencent.mm.memory.o;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.y;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.SnsUploadUI;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.pluginsdk.ui.span.k.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class aj
  implements be, com.tencent.mm.plugin.sns.b.l
{
  private static String JXS;
  protected static HashMap<Integer, h.b> JXT;
  public static boolean JXk;
  private static int JXo;
  private static int JXp;
  private static long JYN;
  private static MMHandler JYb;
  private static int JYc;
  private static int JYd;
  private static o.a appForegroundListener;
  private static Point lbY;
  private IListener FNC;
  private ExecutorService IIs;
  private ag JXA;
  private x JXB;
  private com.tencent.mm.plugin.sns.storage.v JXC;
  private ap.a JXD;
  private c JXE;
  private bd JXF;
  private au JXG;
  private com.tencent.mm.plugin.sns.h.c JXH;
  private com.tencent.mm.plugin.sns.h.g JXI;
  private av JXJ;
  private as JXK;
  private p JXL;
  private com.tencent.mm.plugin.sns.ad.f.n JXM;
  private ar JXN;
  private boolean JXO;
  private aa JXP;
  private boolean JXQ;
  private byte[] JXR;
  private com.tencent.mm.plugin.sns.d JXU;
  private com.tencent.mm.plugin.sns.g.a JXV;
  private ay JXW;
  private com.tencent.mm.plugin.sns.lucky.a.f JXX;
  private com.tencent.mm.plugin.sns.lucky.a.j JXY;
  private com.tencent.mm.plugin.sns.lucky.a.d JXZ;
  private ExecutorService JXl;
  private ExecutorService JXm;
  private ExecutorService JXn;
  private r JXq;
  private com.tencent.mm.plugin.sns.storage.n JXr;
  private com.tencent.mm.plugin.sns.storage.c JXs;
  private com.tencent.mm.plugin.sns.storage.b JXt;
  private ac JXu;
  private g JXv;
  private com.tencent.mm.plugin.sns.storage.m JXw;
  private com.tencent.mm.plugin.sns.storage.i JXx;
  private com.tencent.mm.plugin.sns.storage.t JXy;
  private com.tencent.mm.plugin.sns.storage.k JXz;
  private IListener JYA;
  private IListener JYB;
  private IListener JYC;
  private IListener JYD;
  private IListener JYE;
  private IListener JYF;
  private IListener JYG;
  private IListener JYH;
  private boolean JYI;
  private IListener JYJ;
  private IListener JYK;
  private IListener JYL;
  private final bd.a JYM;
  private IListener JYO;
  private com.tencent.mm.plugin.sns.lucky.a.l JYa;
  private com.tencent.mm.plugin.sns.n JYe;
  private com.tencent.mm.plugin.sns.k JYf;
  private com.tencent.mm.plugin.sns.e JYg;
  private com.tencent.mm.plugin.sns.q JYh;
  private com.tencent.mm.plugin.sns.h JYi;
  private com.tencent.mm.plugin.sns.g JYj;
  private com.tencent.mm.plugin.sns.m JYk;
  private com.tencent.mm.plugin.sns.j JYl;
  private com.tencent.mm.plugin.sns.b JYm;
  private com.tencent.mm.plugin.sns.c JYn;
  private com.tencent.mm.plugin.sns.f JYo;
  private IListener JYp;
  private IListener JYq;
  private IListener JYr;
  private IListener JYs;
  private IListener JYt;
  private IListener JYu;
  private IListener JYv;
  private IListener JYw;
  private IListener JYx;
  private IListener JYy;
  private IListener JYz;
  private MMHandler handler;
  private com.tencent.mm.storagebase.h kcF;
  private byte[] lock;
  private boolean wUJ;
  
  static
  {
    AppMethodBeat.i(95843);
    JXk = true;
    JXS = "";
    JXT = new HashMap();
    JYc = 103;
    JYd = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 130);
    lbY = new Point();
    JXT.put(Integer.valueOf("CanvasInfo".hashCode()), new aj.1());
    JXT.put(Integer.valueOf("UxCanvasInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ac.SQL_CREATE;
      }
    });
    JXT.put(Integer.valueOf("SNSMEDIA_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return r.SQL_CREATE;
      }
    });
    JXT.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.n.SQL_CREATE;
      }
    });
    JXT.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.n.SQL_CREATE;
      }
    });
    JXT.put(Integer.valueOf("ADSNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.c.SQL_CREATE;
      }
    });
    JXT.put(Integer.valueOf("SNSEXT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.m.SQL_CREATE;
      }
    });
    JXT.put(Integer.valueOf("SNSCOMMENT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.i.SQL_CREATE;
      }
    });
    JXT.put(Integer.valueOf("SNSTAGINFO_TABLE".hashCode()), new aj.45());
    JXT.put(Integer.valueOf("SNSKVREPORT_TABLE".hashCode()), new aj.2());
    JXT.put(Integer.valueOf("SNSDRAFT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.k.SQL_CREATE;
      }
    });
    JXT.put(Integer.valueOf("SNSWSFOLDGROUP_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return x.SQL_CREATE;
      }
    });
    JXT.put(Integer.valueOf("SNSWSFOLDDETAIL_TABLE".hashCode()), new h.b()
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
        AppMethodBeat.i(219637);
        if ((com.tencent.mm.kernel.h.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT))
        {
          com.tencent.mm.kernel.h.aHE();
          if (!com.tencent.mm.kernel.b.aGE())
          {
            paramAnonymousString = new sq();
            paramAnonymousString.fSa.state = 0;
            EventCenter.instance.publish(paramAnonymousString);
            paramAnonymousString = new zl();
            EventCenter.instance.publish(paramAnonymousString);
          }
        }
        AppMethodBeat.o(219637);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(219634);
        if ((com.tencent.mm.kernel.h.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT))
        {
          com.tencent.mm.kernel.h.aHE();
          if (!com.tencent.mm.kernel.b.aGE())
          {
            paramAnonymousString = new sq();
            paramAnonymousString.fSa.state = 1;
            EventCenter.instance.publish(paramAnonymousString);
          }
        }
        AppMethodBeat.o(219634);
      }
    };
    JYN = 10080L;
    AppMethodBeat.o(95843);
  }
  
  public aj()
  {
    AppMethodBeat.i(95798);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.JXN = new ar();
    this.wUJ = false;
    this.JXO = true;
    this.lock = new byte[0];
    this.JXP = new aa();
    this.JXQ = false;
    this.JXR = new byte[0];
    this.JXX = new com.tencent.mm.plugin.sns.lucky.a.f();
    this.JXY = new com.tencent.mm.plugin.sns.lucky.a.j();
    this.JXZ = new com.tencent.mm.plugin.sns.lucky.a.d();
    this.JYa = new com.tencent.mm.plugin.sns.lucky.a.l();
    this.JYp = new aj.13(this);
    this.JYq = new IListener() {};
    this.JYr = new aj.15(this);
    this.JYs = new IListener() {};
    this.JYt = new IListener() {};
    this.JYu = new IListener() {};
    this.JYv = new IListener()
    {
      private static boolean a(pg paramAnonymouspg)
      {
        AppMethodBeat.i(203690);
        Object localObject2 = paramAnonymouspg.fNY.fHi;
        com.tencent.mm.plugin.sns.storage.n localn = aj.fOI();
        paramAnonymouspg = aj.getDataDB();
        long l1 = paramAnonymouspg.beginTransaction(-1L);
        try
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            long l2 = ((Long)((Iterator)localObject2).next()).longValue();
            SnsInfo localSnsInfo = localn.agI((int)l2);
            if (localSnsInfo != null)
            {
              localSnsInfo.setOmittedFailResend();
              Log.d("MicroMsg.SnsInfoStorage", "snsInfoId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
              localn.d((int)l2, localSnsInfo);
            }
          }
          paramAnonymouspg.endTransaction(l1);
        }
        finally
        {
          paramAnonymouspg.endTransaction(l1);
          AppMethodBeat.o(203690);
        }
        AppMethodBeat.o(203690);
        return false;
      }
    };
    this.JYw = new IListener() {};
    this.JYx = new IListener() {};
    this.JYy = new IListener()
    {
      private static boolean a(sr paramAnonymoussr)
      {
        AppMethodBeat.i(256932);
        try
        {
          SnsAdClick localSnsAdClick = paramAnonymoussr.fSb.fSc;
          paramAnonymoussr = aj.fOL().QX(localSnsAdClick.fWg);
          if (paramAnonymoussr == null)
          {
            AppMethodBeat.o(256932);
            return false;
          }
          SnsInfo localSnsInfo = paramAnonymoussr.convertToSnsInfo();
          String str1;
          String str2;
          com.tencent.mm.plugin.sns.ad.f.a locala;
          if (localSnsAdClick.source == 2)
          {
            paramAnonymoussr = localSnsInfo.getAtAdInfo();
            if (paramAnonymoussr == null) {
              break label443;
            }
            str1 = paramAnonymoussr.waidPkg;
            str2 = com.tencent.mm.plugin.sns.waid.b.bcD(str1);
            locala = new com.tencent.mm.plugin.sns.ad.f.a();
            locala.JDN = com.tencent.mm.plugin.sns.data.m.r(localSnsInfo);
            locala.JDO = com.tencent.mm.plugin.sns.data.m.s(localSnsInfo);
            locala.JDP = ((int)localSnsAdClick.mbd);
            locala.mbe = localSnsAdClick.mbe;
            if (localSnsAdClick.source != 2) {
              break label276;
            }
            Log.i("MicroMsg.SnsCore", "at_friend_detail report ad click, exposureTime=" + localSnsAdClick.mbc + ", clkPos=" + localSnsAdClick.maV + ", pkg=" + str1 + ", waid=" + str2);
            paramAnonymoussr = new com.tencent.mm.plugin.sns.ad.f.f(localSnsAdClick.fWg, paramAnonymoussr.viewId, localSnsAdClick.maV, localSnsAdClick.maW, localSnsAdClick.maU, "", localSnsInfo.getAdType(), localSnsInfo.getTimeLine().statExtStr, localSnsAdClick.mbb, localSnsInfo.getAdSnsInfo().getAtFriendRemindInfoSourceInfo(), localSnsInfo.getAdSnsInfo().getAtFriendRemindInfoSelfInfo(), localSnsAdClick.mbc, str1, str2, locala);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymoussr, 0);
          }
          for (;;)
          {
            AppMethodBeat.o(256932);
            return true;
            paramAnonymoussr = localSnsInfo.getAdInfo();
            break;
            label276:
            Log.i("MicroMsg.SnsCore", "report ad click, exposureTime=" + localSnsAdClick.mbc + ", clkPos=" + localSnsAdClick.maV + ", source=" + localSnsAdClick.source + ", pkg=" + str1 + ", waid=" + str2);
            paramAnonymoussr = new com.tencent.mm.plugin.sns.ad.f.f(localSnsAdClick.fWg, paramAnonymoussr.viewId, localSnsAdClick.maV, localSnsAdClick.maW, localSnsAdClick.maU, "", localSnsInfo.getAdType(), localSnsInfo.getTimeLine().statExtStr, localSnsAdClick.mbb, localSnsInfo.getAdSnsInfo().getTimelineRemindInfoSourceInfo(), localSnsInfo.getAdSnsInfo().getTimelineRemindInfoSelfInfo(), localSnsAdClick.mbc, str1, str2, locala);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymoussr, 0);
          }
          label443:
          return false;
        }
        catch (Exception paramAnonymoussr)
        {
          Log.printErrStackTrace("MicroMsg.SnsCore", paramAnonymoussr, "report ad click error", new Object[0]);
          AppMethodBeat.o(256932);
        }
      }
    };
    this.JYz = new IListener()
    {
      private static boolean a(ss paramAnonymousss)
      {
        AppMethodBeat.i(193690);
        SnsAdClick localSnsAdClick;
        Object localObject1;
        try
        {
          localSnsAdClick = paramAnonymousss.fSd.fSc;
          localObject1 = aj.fOL().QX(localSnsAdClick.fWg);
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
              com.tencent.mm.plugin.report.service.h.IzE.a(16972, new Object[] { Long.valueOf(localSnsAdClick.fWg), Integer.valueOf(localSnsAdClick.maU), ((ADInfo)localObject1).uxInfo, Integer.valueOf(((SnsInfo)localObject2).getAdRecSrc()), ((SnsInfo)localObject2).getTimeLine().statExtStr, paramAnonymousss.fSd.url, Integer.valueOf(paramAnonymousss.fSd.fSe), Integer.valueOf(paramAnonymousss.fSd.errorCode), Long.valueOf(paramAnonymousss.fSd.timestamp) });
              AppMethodBeat.o(193690);
              return true;
              localObject1 = ((SnsInfo)localObject2).getAdInfo();
              break;
              label204:
              Log.i("MicroMsg.SnsCore", "report ad h5 load");
            }
          }
          label227:
          localObject1 = aj.fOI().Rd(localSnsAdClick.fWg);
        }
        catch (Exception paramAnonymousss)
        {
          Log.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousss, "report load ad h5 error", new Object[0]);
          AppMethodBeat.o(193690);
          return false;
        }
        Object localObject2 = new StringBuilder("report ad h5, AdSnsInfo==null, uxInfo=").append(paramAnonymousss.fSd.uxInfo).append(", snsInfo==null?");
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
          str = paramAnonymousss.fSd.uxInfo;
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
          com.tencent.mm.plugin.report.service.h.IzE.a(16972, new Object[] { Long.valueOf(localSnsAdClick.fWg), Integer.valueOf(localSnsAdClick.maU), str, Integer.valueOf(i), localObject2, paramAnonymousss.fSd.url, Integer.valueOf(paramAnonymousss.fSd.fSe), Integer.valueOf(paramAnonymousss.fSd.errorCode), Long.valueOf(paramAnonymousss.fSd.timestamp) });
          AppMethodBeat.o(193690);
          return true;
          bool = false;
          break;
          label442:
          localObject1 = ((TimeLineObject)localObject1).statExtStr;
          break label569;
          label450:
          localObject1 = paramAnonymousss.fSd.uxInfo;
          com.tencent.mm.plugin.report.service.h.IzE.a(16972, new Object[] { Long.valueOf(localSnsAdClick.fWg), Integer.valueOf(localSnsAdClick.maU), localObject1, Integer.valueOf(0), "", paramAnonymousss.fSd.url, Integer.valueOf(paramAnonymousss.fSd.fSe), Integer.valueOf(paramAnonymousss.fSd.errorCode), Long.valueOf(paramAnonymousss.fSd.timestamp) });
          AppMethodBeat.o(193690);
          return true;
          label569:
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
        }
      }
    };
    this.JYA = new IListener() {};
    this.JYB = new aj.26(this);
    this.JYC = new IListener() {};
    this.JYD = new IListener() {};
    this.JYE = new IListener()
    {
      private static boolean a(tb paramAnonymoustb)
      {
        AppMethodBeat.i(193810);
        SnsAdClick localSnsAdClick = paramAnonymoustb.fSu.fSc;
        try
        {
          if (paramAnonymoustb.fSu.fSv != 1) {
            break label259;
          }
          if (localSnsAdClick.maX != 1) {
            break label365;
          }
          localAdSnsInfo = aj.fOL().QX(localSnsAdClick.fWg);
          if ((localAdSnsInfo == null) || (!localAdSnsInfo.isRecExpAd())) {
            break label266;
          }
          localObject2 = aj.fOC();
          j = 14647;
          localObject1 = new Object[7];
          localObject1[0] = Long.valueOf(localSnsAdClick.fWg);
          localObject1[1] = localAdSnsInfo.getAdInfo().uxInfo;
          localObject1[2] = Integer.valueOf(localSnsAdClick.maU);
          localObject1[3] = Long.valueOf(localSnsAdClick.startTime);
          localObject1[4] = Long.valueOf(System.currentTimeMillis());
          i = localAdSnsInfo.getRecSrc();
          paramAnonymoustb = (tb)localObject1;
        }
        catch (Exception paramAnonymoustb)
        {
          for (;;)
          {
            AdSnsInfo localAdSnsInfo;
            int j;
            com.tencent.mm.plugin.sns.ad.f.n localn;
            Log.printErrStackTrace("MicroMsg.SnsCore", paramAnonymoustb, "report ad click error", new Object[0]);
            continue;
            Object localObject1 = paramAnonymoustb.fSu.uxInfo;
            paramAnonymoustb = (tb)localObject1;
            if (localObject1 == null) {
              paramAnonymoustb = "";
            }
            Log.i("MicroMsg.SnsCore", "ReportSnsEvent, AdSnsInfo==null, uxInfo=".concat(String.valueOf(paramAnonymoustb)));
            boolean bool = false;
            continue;
            aj.fOC().a(12013, new Object[] { localObject1 });
            continue;
            int i = -1;
            localObject1 = paramAnonymoustb;
            Object localObject2 = paramAnonymoustb;
            paramAnonymoustb = (tb)localObject1;
            localObject1 = localObject2;
            localObject2 = localn;
          }
        }
        paramAnonymoustb[5] = Integer.valueOf(i);
        localObject1[6] = "";
        ((com.tencent.mm.plugin.sns.ad.f.n)localObject2).a(j, (Object[])localObject1);
        paramAnonymoustb = com.tencent.mm.modelsns.l.wP(750);
        paramAnonymoustb.Xf(localSnsAdClick.fWg).Xf(localAdSnsInfo.getAdInfo().uxInfo).wR(localSnsAdClick.maU).Xf(localSnsAdClick.startTime).Xf(System.currentTimeMillis());
        paramAnonymoustb.bpa();
        for (;;)
        {
          label259:
          AppMethodBeat.o(193810);
          return false;
          label266:
          localn = aj.fOC();
          j = 13155;
          paramAnonymoustb = new Object[7];
          paramAnonymoustb[0] = Long.valueOf(localSnsAdClick.fWg);
          paramAnonymoustb[1] = localAdSnsInfo.getAdInfo().uxInfo;
          paramAnonymoustb[2] = Integer.valueOf(localSnsAdClick.maU);
          paramAnonymoustb[3] = Long.valueOf(localSnsAdClick.startTime);
          paramAnonymoustb[4] = Long.valueOf(System.currentTimeMillis());
          if (localAdSnsInfo == null) {
            break label753;
          }
          i = localAdSnsInfo.getRecSrc();
          localObject1 = paramAnonymoustb;
          localObject2 = paramAnonymoustb;
          paramAnonymoustb = (tb)localObject1;
          localObject1 = localObject2;
          localObject2 = localn;
          break;
          label365:
          localObject1 = aj.fOL().QX(localSnsAdClick.fWg);
          if (localObject1 == null) {
            break label693;
          }
          paramAnonymoustb = ((AdSnsInfo)localObject1).getAdInfo().uxInfo;
          bool = ((AdSnsInfo)localObject1).isRecExpAd();
          localObject1 = com.tencent.mm.plugin.sns.ad.f.k.a(localSnsAdClick.fWg, new Object[] { localSnsAdClick, paramAnonymoustb, Integer.valueOf(localSnsAdClick.maU), Long.valueOf(localSnsAdClick.startTime), Long.valueOf(System.currentTimeMillis()) });
          localObject1 = (String)localObject1 + String.format(",%s", new Object[] { localSnsAdClick.maY });
          localObject1 = (String)localObject1 + String.format(",%s", new Object[] { System.currentTimeMillis() - localSnsAdClick.startTime - localSnsAdClick.mba });
          if (!bool) {
            break label732;
          }
          aj.fOC().a(14643, new Object[] { localObject1 });
          localObject1 = com.tencent.mm.modelsns.l.wP(733);
          ((com.tencent.mm.modelsns.l)localObject1).Xf(localSnsAdClick.fWg).Xf(paramAnonymoustb).wR(localSnsAdClick.maU).Xf(localSnsAdClick.startTime).Xf(System.currentTimeMillis());
          ((com.tencent.mm.modelsns.l)localObject1).bpa();
        }
      }
    };
    this.JYF = new aj.30(this);
    this.JYG = new IListener() {};
    this.JYH = new aj.32(this);
    this.JYI = false;
    this.FNC = new IListener() {};
    this.JYJ = new IListener() {};
    this.JYK = new IListener() {};
    this.JYL = new IListener() {};
    this.JYM = new bd.a()
    {
      public final void aY(final int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(195391);
        if ((paramAnonymousBoolean) && (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag()) && (paramAnonymousInt > 0)) {
          ((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.secdata.g.class)).getWithClear(2, "SnsPostEnd_".concat(String.valueOf(paramAnonymousInt)), com.tencent.mm.plugin.sns.j.j.class, new com.tencent.mm.plugin.secdata.i() {});
        }
        AppMethodBeat.o(195391);
      }
      
      public final void fPf() {}
    };
    this.JYO = new IListener() {};
    Log.i("MicroMsg.SnsCore", "snscore create! " + Thread.currentThread().getId());
    if (this.JXm == null) {
      this.JXm = com.tencent.e.h.ZvG.a("SnsCore_CDNDownload_handler", 6, 6, new LinkedBlockingQueue());
    }
    if (this.IIs == null) {
      this.IIs = com.tencent.e.h.ZvG.a("SnsCore_thumbDecode_handler", 6, 6, new LinkedBlockingQueue());
    }
    if (this.JXl == null) {
      this.JXl = com.tencent.e.h.ZvG.bDi("SnsCore#File");
    }
    if (this.JXn == null) {
      this.JXn = com.tencent.e.h.ZvG.bDi("SnsCore#Task");
    }
    AppMethodBeat.o(95798);
  }
  
  public static void a(CancellationSignal paramCancellationSignal, long paramLong)
  {
    AppMethodBeat.i(194926);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("SnsMMKV");
    if (localMultiProcessMMKV.getBoolean("SnsMMKVSnsUI", false))
    {
      Log.e("MicroMsg.SnsCore", "cleanSnsTablesByTimeLimit in SnsUI, exit clean.");
      AppMethodBeat.o(194926);
      return;
    }
    long l3 = SystemClock.uptimeMillis();
    long l4 = System.currentTimeMillis();
    long l2 = fOI().fSP();
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    long l5 = new com.tencent.mm.vfs.q(com.tencent.mm.kernel.h.aHG().cachePath + "SnsMicroMsg.db").length();
    Log.i("MicroMsg.SnsCore", "cleanSnsTablesByTimeLimit calcDbSize. originSnsDbCount:%s, originSnsDbSize%s MB", new Object[] { Long.valueOf(l2), Long.valueOf(l5 / 1024L / 1024L) });
    localObject = new kr();
    ((kr)localObject).gOM = l2;
    ((kr)localObject).gOO = l5;
    ((kr)localObject).nmJ = 1;
    ((kr)localObject).bpa();
    localObject = localMultiProcessMMKV.getString("SnsMMKVCleanDbReport", "");
    if (!Util.isNullOrNil((String)localObject))
    {
      fOM().fSH();
      com.tencent.mm.plugin.report.service.h.IzE.el(150, 115);
      localObject = new kr((String)localObject);
      ((kr)localObject).gOL = 5;
      ((kr)localObject).gON = (((kr)localObject).gOM - l2);
      ((kr)localObject).gOP = (((kr)localObject).gOO - l5);
      ((kr)localObject).bpa();
      localMultiProcessMMKV.encode("SnsMMKVCleanDbReport", "");
      Log.i("MicroMsg.SnsCore", "cleanSnsTablesByTimeLimit lastTime error exit. %s", new Object[] { ((kr)localObject).agH() });
    }
    if (Util.getInt(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_sns_clean_db_switch", "0", false, true), 0) <= 0)
    {
      Log.e("MicroMsg.SnsCore", "cleanSnsTablesByTimeLimit cleanDbSwitch not enable.");
      AppMethodBeat.o(194926);
      return;
    }
    if (l2 > Util.getLong(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_sns_clean_db_oversize_limit", "50000", false, true), 50000L))
    {
      Log.e("MicroMsg.SnsCore", "cleanSnsTablesByTimeLimit dbcount oversize skip! originSnsDbCount:%s, originSnsDbSize:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l5) });
      AppMethodBeat.o(194926);
      return;
    }
    long l1 = paramLong;
    if (paramLong < 0L)
    {
      paramLong = Util.getLong(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_sns_clean_db_time_limit", Long.toString(JYN), false, true), JYN);
      l1 = paramLong;
      if (paramLong < 0L) {
        l1 = JYN;
      }
    }
    if ((paramCancellationSignal != null) && (paramCancellationSignal.isCanceled()))
    {
      Log.e("MicroMsg.SnsCore", "cleanSnsTablesByTimeLimit calcDbExpire cancel.");
      AppMethodBeat.o(194926);
      return;
    }
    Log.i("MicroMsg.SnsCore", "cleanSnsTablesByTimeLimit start.");
    com.tencent.mm.plugin.report.service.h.IzE.el(150, 111);
    boolean bool1 = localMultiProcessMMKV.getBoolean("SnsMMKVCleanDbIsFirstTime", true);
    localObject = new kr();
    ((kr)localObject).gOM = l2;
    ((kr)localObject).gOO = l5;
    ((kr)localObject).gOS = l1;
    if (bool1) {}
    for (int i = 1;; i = 0)
    {
      ((kr)localObject).gOT = i;
      ((kr)localObject).gOU = l4;
      ((kr)localObject).nmJ = 0;
      localMultiProcessMMKV.encode("SnsMMKVCleanDbReport", ((kr)localObject).agH());
      paramLong = (System.currentTimeMillis() - 60L * l1 * 1000L) / 1000L;
      if ((paramCancellationSignal == null) || (!paramCancellationSignal.isCanceled())) {
        break;
      }
      Log.e("MicroMsg.SnsCore", "cleanSnsTablesByTimeLimit calcDbExpire cancel.");
      com.tencent.mm.plugin.report.service.h.IzE.el(150, 113);
      ((kr)localObject).gOL = 2;
      ((kr)localObject).gOQ = (SystemClock.uptimeMillis() - l3);
      ((kr)localObject).bpa();
      localMultiProcessMMKV.encode("SnsMMKVCleanDbReport", "");
      AppMethodBeat.o(194926);
      return;
    }
    paramCancellationSignal = fOI();
    String str = "DELETE FROM SnsInfo WHERE createTime < ".concat(String.valueOf(paramLong));
    boolean bool2 = paramCancellationSignal.lvy.execSQL("SnsInfo", str);
    boolean bool3 = paramCancellationSignal.lvy.execSQL("SnsInfo", "VACUUM");
    Log.d("MicroMsg.SnsInfoStorage", "cleanDbExpire:" + str + ", result:" + bool2 + ", vacuumResult:" + bool3);
    Log.i("MicroMsg.SnsCore", "cleanSnsTablesByTimeLimit delete db.");
    if (!bool2)
    {
      Log.e("MicroMsg.SnsCore", "cleanSnsTablesByTimeLimit calcDbExpire delete failed.");
      com.tencent.mm.plugin.report.service.h.IzE.el(150, 114);
      ((kr)localObject).gOL = 3;
      ((kr)localObject).gOQ = (SystemClock.uptimeMillis() - l3);
      ((kr)localObject).bpa();
      localMultiProcessMMKV.encode("SnsMMKVCleanDbReport", "");
      AppMethodBeat.o(194926);
      return;
    }
    fOM().fSH();
    long l6 = fOI().fSP();
    paramCancellationSignal = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    long l7 = new com.tencent.mm.vfs.q(com.tencent.mm.kernel.h.aHG().cachePath + "SnsMicroMsg.db").length();
    l3 = SystemClock.uptimeMillis() - l3;
    paramLong = localMultiProcessMMKV.getLong("SnsMMKVCleanDbLastCleanTime", 0L);
    if (paramLong > 0L) {}
    for (paramLong = l4 - paramLong;; paramLong = 0L)
    {
      Log.i("MicroMsg.SnsCore", "cleanSnsTablesByTimeLimit finish, limit:%s min, SnsDbCount[%s, %s, diff:%s], SnsDbSize[%s, %s, diff:%s kb], costTime:%s ms, timeSinceLastClean:%s s, startTime:%s ms", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l6), Long.valueOf(l2 - l6), Long.valueOf(l5 / 1024L), Long.valueOf(l7 / 1024L), Long.valueOf((l5 - l7) / 1024L), Long.valueOf(l3), Long.valueOf(paramLong / 1000L), Long.valueOf(l4) });
      com.tencent.mm.plugin.report.service.h.IzE.el(150, 112);
      paramCancellationSignal = new ArrayList();
      if (l2 <= 0L)
      {
        l1 = 1L;
        paramCancellationSignal.add(new IDKey(150L, 121L, l1));
        if (l2 - l6 > 0L) {
          break label1323;
        }
        l1 = 1L;
        label1098:
        paramCancellationSignal.add(new IDKey(150L, 122L, l1));
        if (l5 / 1024L > 0L) {
          break label1333;
        }
        l1 = 1L;
        label1132:
        paramCancellationSignal.add(new IDKey(150L, 123L, l1));
        if ((l5 - l7) / 1024L > 0L) {
          break label1344;
        }
        l1 = 1L;
        label1169:
        paramCancellationSignal.add(new IDKey(150L, 124L, l1));
        if (l3 > 0L) {
          break label1358;
        }
      }
      label1323:
      label1333:
      label1344:
      label1358:
      for (l1 = 1L;; l1 = l3)
      {
        paramCancellationSignal.add(new IDKey(150L, 126L, l1));
        com.tencent.mm.plugin.report.service.h.IzE.b(paramCancellationSignal, false);
        ((kr)localObject).gOL = 1;
        ((kr)localObject).gON = (l2 - l6);
        ((kr)localObject).gOP = (l5 - l7);
        ((kr)localObject).gOQ = l3;
        ((kr)localObject).gOV = paramLong;
        ((kr)localObject).bpa();
        localMultiProcessMMKV.encode("SnsMMKVCleanDbReport", "");
        if (bool1) {
          localMultiProcessMMKV.encode("SnsMMKVCleanDbIsFirstTime", false);
        }
        localMultiProcessMMKV.encode("SnsMMKVCleanDbLastCleanTime", l4);
        AppMethodBeat.o(194926);
        return;
        l1 = l2;
        break;
        l1 = l2 - l6;
        break label1098;
        l1 = l5 / 1024L;
        break label1132;
        l1 = (l5 - l7) / 1024L;
        break label1169;
      }
    }
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(95835);
    u.bBD(((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath());
    u.bBD(((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsTmpPath());
    u.bBX(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.fSq());
    AppMethodBeat.o(95835);
  }
  
  public static Point eSY()
  {
    AppMethodBeat.i(95830);
    if (lbY.x == 0)
    {
      localObject = (WindowManager)MMApplicationContext.getContext().getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
      lbY.x = localDisplayMetrics.widthPixels;
      lbY.y = localDisplayMetrics.heightPixels;
    }
    Object localObject = lbY;
    AppMethodBeat.o(95830);
    return localObject;
  }
  
  public static MMHandler etE()
  {
    AppMethodBeat.i(95804);
    MMHandler localMMHandler = fOq().handler;
    AppMethodBeat.o(95804);
    return localMMHandler;
  }
  
  public static com.tencent.mm.plugin.sns.h.g fOA()
  {
    AppMethodBeat.i(95812);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXI == null) {
      fOq().JXI = new com.tencent.mm.plugin.sns.h.g();
    }
    com.tencent.mm.plugin.sns.h.g localg = fOq().JXI;
    AppMethodBeat.o(95812);
    return localg;
  }
  
  public static p fOB()
  {
    AppMethodBeat.i(95813);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXL == null) {
      fOq().JXL = new p(fOq().kcF);
    }
    p localp = fOq().JXL;
    AppMethodBeat.o(95813);
    return localp;
  }
  
  public static com.tencent.mm.plugin.sns.ad.f.n fOC()
  {
    AppMethodBeat.i(95814);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXM == null) {
      fOq().JXM = new com.tencent.mm.plugin.sns.ad.f.n();
    }
    com.tencent.mm.plugin.sns.ad.f.n localn = fOq().JXM;
    AppMethodBeat.o(95814);
    return localn;
  }
  
  public static c fOD()
  {
    AppMethodBeat.i(95815);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXE == null) {
      fOq().JXE = new c();
    }
    c localc = fOq().JXE;
    AppMethodBeat.o(95815);
    return localc;
  }
  
  public static bd fOE()
  {
    AppMethodBeat.i(95816);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXF == null)
    {
      fOq().JXF = new bd();
      com.tencent.mm.plugin.sns.b.p.JPb = fOq().JXF;
    }
    bd localbd = fOq().JXF;
    AppMethodBeat.o(95816);
    return localbd;
  }
  
  public static g fOF()
  {
    AppMethodBeat.i(95817);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXv == null)
    {
      fOq().JXv = new g();
      com.tencent.mm.plugin.sns.b.p.JPc = fOq().JXv;
    }
    g localg = fOq().JXv;
    AppMethodBeat.o(95817);
    return localg;
  }
  
  public static ay fOG()
  {
    AppMethodBeat.i(95818);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXW == null) {
      fOq().JXW = new ay();
    }
    ay localay = fOq().JXW;
    AppMethodBeat.o(95818);
    return localay;
  }
  
  public static ag fOH()
  {
    AppMethodBeat.i(95819);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXA == null)
    {
      localObject = fOq();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.aHH();
      ((aj)localObject).JXA = new ag(com.tencent.mm.kernel.h.aHG().cachePath + "snsAsyncQueue.data");
    }
    Object localObject = fOq().JXA;
    AppMethodBeat.o(95819);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.sns.storage.n fOI()
  {
    AppMethodBeat.i(95820);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXr == null)
    {
      fOq().JXr = new com.tencent.mm.plugin.sns.storage.n(fOq().kcF);
      com.tencent.mm.plugin.sns.b.p.JPi = fOq().JXr;
    }
    com.tencent.mm.plugin.sns.storage.n localn = fOq().JXr;
    AppMethodBeat.o(95820);
    return localn;
  }
  
  public static com.tencent.mm.plugin.sns.storage.b fOJ()
  {
    AppMethodBeat.i(95821);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXt == null) {
      fOq().JXt = new com.tencent.mm.plugin.sns.storage.b(fOq().kcF);
    }
    com.tencent.mm.plugin.sns.storage.b localb = fOq().JXt;
    AppMethodBeat.o(95821);
    return localb;
  }
  
  public static ac fOK()
  {
    AppMethodBeat.i(95822);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXu == null) {
      fOq().JXu = new ac(fOq().kcF);
    }
    ac localac = fOq().JXu;
    AppMethodBeat.o(95822);
    return localac;
  }
  
  public static com.tencent.mm.plugin.sns.storage.c fOL()
  {
    AppMethodBeat.i(95823);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXs == null) {
      fOq().JXs = new com.tencent.mm.plugin.sns.storage.c(fOq().kcF);
    }
    com.tencent.mm.plugin.sns.storage.c localc = fOq().JXs;
    AppMethodBeat.o(95823);
    return localc;
  }
  
  public static com.tencent.mm.plugin.sns.storage.m fOM()
  {
    AppMethodBeat.i(95824);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXw == null)
    {
      fOq().JXw = new com.tencent.mm.plugin.sns.storage.m(fOq().kcF, new al());
      com.tencent.mm.plugin.sns.b.p.JPd = fOq().JXw;
    }
    com.tencent.mm.plugin.sns.storage.m localm = fOq().JXw;
    AppMethodBeat.o(95824);
    return localm;
  }
  
  public static com.tencent.mm.plugin.sns.storage.i fON()
  {
    AppMethodBeat.i(95825);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXx == null)
    {
      fOq().JXx = new com.tencent.mm.plugin.sns.storage.i(fOq().kcF);
      com.tencent.mm.plugin.sns.b.p.JPe = fOq().JXx;
    }
    com.tencent.mm.plugin.sns.storage.i locali = fOq().JXx;
    AppMethodBeat.o(95825);
    return locali;
  }
  
  public static com.tencent.mm.plugin.sns.storage.t fOO()
  {
    AppMethodBeat.i(95826);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXy == null)
    {
      fOq().JXy = new com.tencent.mm.plugin.sns.storage.t(fOq().kcF);
      com.tencent.mm.plugin.sns.b.p.JPf = fOq().JXy;
    }
    com.tencent.mm.plugin.sns.storage.t localt = fOq().JXy;
    AppMethodBeat.o(95826);
    return localt;
  }
  
  public static com.tencent.mm.plugin.sns.storage.k fOP()
  {
    AppMethodBeat.i(176273);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXz == null) {
      fOq().JXz = new com.tencent.mm.plugin.sns.storage.k(fOq().kcF);
    }
    com.tencent.mm.plugin.sns.storage.k localk = fOq().JXz;
    AppMethodBeat.o(176273);
    return localk;
  }
  
  public static x fOQ()
  {
    AppMethodBeat.i(194805);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXB == null) {
      fOq().JXB = new x(fOq().kcF);
    }
    x localx = fOq().JXB;
    AppMethodBeat.o(194805);
    return localx;
  }
  
  public static com.tencent.mm.plugin.sns.storage.v fOR()
  {
    AppMethodBeat.i(194806);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXC == null) {
      fOq().JXC = new com.tencent.mm.plugin.sns.storage.v(fOq().kcF);
    }
    com.tencent.mm.plugin.sns.storage.v localv = fOq().JXC;
    AppMethodBeat.o(194806);
    return localv;
  }
  
  public static au fOS()
  {
    AppMethodBeat.i(95827);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXG == null) {
      fOq().JXG = new au();
    }
    au localau = fOq().JXG;
    AppMethodBeat.o(95827);
    return localau;
  }
  
  public static av fOT()
  {
    AppMethodBeat.i(179093);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXJ == null) {
      fOq().JXJ = new av();
    }
    av localav = fOq().JXJ;
    AppMethodBeat.o(179093);
    return localav;
  }
  
  public static as fOU()
  {
    AppMethodBeat.i(194812);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXK == null) {
      fOq().JXK = new as();
    }
    as localas = fOq().JXK;
    AppMethodBeat.o(194812);
    return localas;
  }
  
  public static int fOV()
  {
    AppMethodBeat.i(95828);
    int i = (eSY().x - com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), JYc)) / 3;
    JXo = i;
    if (i > JYd) {}
    for (i = JYd;; i = JXo)
    {
      JXo = i;
      if (i > 10) {
        break;
      }
      Log.e("MicroMsg.SnsCore", "can not get multiThumbDisplaySize or the multiThumbDisplaySize < 10");
      AppMethodBeat.o(95828);
      return 150;
    }
    i = JXo;
    AppMethodBeat.o(95828);
    return i;
  }
  
  public static int fOW()
  {
    AppMethodBeat.i(95829);
    if (JXp <= 0)
    {
      JXp = 200;
      JXp = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), JXp);
    }
    int i = JXp;
    AppMethodBeat.o(95829);
    return i;
  }
  
  public static boolean fOX()
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
  
  public static boolean fOY()
  {
    AppMethodBeat.i(194818);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVG, false);
    AppMethodBeat.o(194818);
    return bool;
  }
  
  public static boolean fOZ()
  {
    AppMethodBeat.i(194821);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(194821);
      return true;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVF, false);
    AppMethodBeat.o(194821);
    return bool;
  }
  
  public static String fOo()
  {
    AppMethodBeat.i(95793);
    com.tencent.mm.kernel.h.aHH();
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().b(2, null);
    AppMethodBeat.o(95793);
    return str;
  }
  
  public static int fOp()
  {
    AppMethodBeat.i(95794);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE();
    int i = com.tencent.mm.kernel.b.getUin();
    AppMethodBeat.o(95794);
    return i;
  }
  
  private static aj fOq()
  {
    AppMethodBeat.i(95796);
    aj localaj = (aj)y.as(aj.class);
    if (!localaj.JXQ) {}
    synchronized (localaj.JXR)
    {
      if (!localaj.JXQ)
      {
        Log.i("MicroMsg.SnsCore", "onAccInit because bug!");
        localaj.onAccountPostReset(true);
      }
      if (!localaj.wUJ) {}
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
        if (localaj.wUJ)
        {
          localaj.JXO = false;
          localObject4 = localaj.JXP;
          localObject3 = JXT;
          if (((aa)localObject4).KAh)
          {
            Log.i("MicroMsg.TrimSnsDb", "pass hasTrim");
            if (localaj.kcF == null)
            {
              localaj.kcF = new com.tencent.mm.storagebase.h();
              com.tencent.mm.kernel.h.aHH();
              localObject3 = com.tencent.mm.kernel.h.aHG().cachePath;
              localObject3 = (String)localObject3 + "SnsMicroMsg.db";
              if (!localaj.kcF.a((String)localObject3, JXT, true))
              {
                com.tencent.mm.plugin.report.service.h.IzE.el(150, 82);
                fOr();
                localaj.kcF = new com.tencent.mm.storagebase.h();
                bool = localaj.kcF.a((String)localObject3, JXT, true);
                Log.i("MicroMsg.SnsCore", "one more time result:%s:", new Object[] { Boolean.valueOf(bool) });
                if (bool) {
                  com.tencent.mm.plugin.report.service.h.IzE.el(150, 83);
                }
              }
            }
            localaj.wUJ = false;
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
        com.tencent.mm.kernel.h.aHH();
        if (!com.tencent.mm.kernel.h.aHE().aGM()) {
          continue;
        }
        i = Util.getInt(com.tencent.mm.n.h.axc().getValue("AndroidCleanSnsDb"), 0);
        Log.i("MicroMsg.TrimSnsDb", "pass dynamic? ".concat(String.valueOf(i)));
        if (i > 0) {
          continue;
        }
        com.tencent.mm.kernel.h.aHH();
        str = com.tencent.mm.kernel.h.aHG().cachePath;
        if (u.agG(str + "SnsMicroMsg2.db.ini"))
        {
          aa.bbM(str);
          u.deleteFile(str + "SnsMicroMsg2.db.ini");
        }
        localObject5 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
        if (Util.secondsToNow(((SharedPreferences)localObject5).getLong("check_trim_time", 0L)) < 604800L) {
          Log.i("MicroMsg.TrimSnsDb", "trim sns pass because time short");
        }
      }
      ((SharedPreferences)localObject5).edit().putLong("check_trim_time", Util.nowSecond()).commit();
      ((aa)localObject4).KAh = true;
      l1 = System.currentTimeMillis();
      i = com.tencent.mm.p.a.aAi();
      if ((i == 1) || (i == 2))
      {
        Log.i("MicroMsg.TrimSnsDb", "trim sns error space dangerous");
      }
      else if (u.agG(str + "sns_mark.ini"))
      {
        if (Util.milliSecondsToNow(u.bBR(str + "sns_mark.ini")) < 2592000000L)
        {
          Log.i("MicroMsg.TrimSnsDb", "mark file exist and return");
          aa.bbM(str);
        }
        else
        {
          u.deleteFile(str + "sns_mark.ini");
        }
      }
      else
      {
        l2 = u.bBQ(str + "SnsMicroMsg.db");
        Log.i("MicroMsg.TrimSnsDb", "trim sns ".concat(String.valueOf(l2)));
        if (l2 >= 52428800L) {
          break;
        }
        Log.i("MicroMsg.TrimSnsDb", "trim sns free pass: " + (System.currentTimeMillis() - l1));
      }
    }
    u.bBV(str + "sns_mark.ini");
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
        com.tencent.mm.kernel.h.aHH();
        localObject3 = com.tencent.mm.kernel.h.aHG().cachePath;
        u.deleteFile((String)localObject3 + "SnsMicroMsg.db");
        Log.i("MicroMsg.TrimSnsDb", "rename file ".concat(String.valueOf(u.bj((String)localObject3, "SnsMicroMsg2.db", "SnsMicroMsg.db"))));
        u.deleteFile((String)localObject3 + "SnsMicroMsg.db-shm");
        u.deleteFile((String)localObject3 + "SnsMicroMsg.db-wal");
        u.deleteFile((String)localObject3 + "SnsMicroMsg.db.ini");
        u.on("SnsMicroMsg2.db.ini", "SnsMicroMsg.db.ini");
        u.deleteFile((String)localObject3 + "SnsMicroMsg2.db.ini");
        u.deleteFile((String)localObject3 + "SnsMicroMsg2.db");
        u.deleteFile((String)localObject3 + "sns_mark.ini");
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
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "insert into " + "SnsInfo" + " select * from old." + "SnsInfo" + " where  (sourceType & 2 != 0 ) " + com.tencent.mm.plugin.sns.storage.n.KzD + " limit 200");
      Log.i("MicroMsg.TrimSnsDb", "copysns ret_sns:" + bool + " passed " + (System.currentTimeMillis() - l3));
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "update snsExtinfo3 set md5 = '', faults = '';");
      Log.i("MicroMsg.TrimSnsDb", "update ext info  passed  %s  updateRet %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l3), Boolean.valueOf(bool) });
      ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "DETACH DATABASE old");
    }
  }
  
  private static void fOr()
  {
    AppMethodBeat.i(194745);
    com.tencent.mm.kernel.h.aHH();
    String[] arrayOfString = new File(com.tencent.mm.kernel.h.aHG().cachePath).list();
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
          u.deleteFile(str);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(194745);
  }
  
  public static ExecutorService fOs()
  {
    AppMethodBeat.i(179089);
    ExecutorService localExecutorService = fOq().JXm;
    AppMethodBeat.o(179089);
    return localExecutorService;
  }
  
  public static ExecutorService fOt()
  {
    AppMethodBeat.i(179090);
    ExecutorService localExecutorService = fOq().IIs;
    AppMethodBeat.o(179090);
    return localExecutorService;
  }
  
  protected static ExecutorService fOu()
  {
    AppMethodBeat.i(179091);
    ExecutorService localExecutorService = fOq().JXl;
    AppMethodBeat.o(179091);
    return localExecutorService;
  }
  
  public static ExecutorService fOv()
  {
    AppMethodBeat.i(179092);
    ExecutorService localExecutorService = fOq().JXn;
    AppMethodBeat.o(179092);
    return localExecutorService;
  }
  
  public static bv fOw()
  {
    AppMethodBeat.i(95808);
    com.tencent.mm.kernel.h.aHH();
    bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL();
    AppMethodBeat.o(95808);
    return localbv;
  }
  
  public static r fOx()
  {
    AppMethodBeat.i(95809);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXq == null) {
      fOq().JXq = new r(fOq().kcF);
    }
    r localr = fOq().JXq;
    AppMethodBeat.o(95809);
    return localr;
  }
  
  public static ap.a fOy()
  {
    AppMethodBeat.i(95810);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXD == null)
    {
      fOq().JXD = new ap.a();
      com.tencent.mm.plugin.sns.b.p.JPh = fOq().JXD;
    }
    ap.a locala = fOq().JXD;
    AppMethodBeat.o(95810);
    return locala;
  }
  
  public static com.tencent.mm.plugin.sns.h.c fOz()
  {
    AppMethodBeat.i(95811);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fOq().JXH == null) {
      fOq().JXH = new com.tencent.mm.plugin.sns.h.c();
    }
    com.tencent.mm.plugin.sns.h.c localc = fOq().JXH;
    AppMethodBeat.o(95811);
    return localc;
  }
  
  public static boolean fPa()
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
  
  public static String fPb()
  {
    AppMethodBeat.i(95839);
    AppMethodBeat.o(95839);
    return "";
  }
  
  /* Error */
  public static void fPc()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: ldc_w 1559
    //   6: invokestatic 251	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc_w 501
    //   12: ldc_w 1561
    //   15: invokestatic 531	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: ldc_w 571
    //   21: invokestatic 577	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   24: ldc_w 1563
    //   27: iconst_1
    //   28: invokevirtual 853	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Z)Z
    //   31: pop
    //   32: invokestatic 602	com/tencent/mm/plugin/sns/model/aj:fOI	()Lcom/tencent/mm/plugin/sns/storage/n;
    //   35: astore 9
    //   37: invokestatic 598	java/lang/System:currentTimeMillis	()J
    //   40: lstore 6
    //   42: aload 9
    //   44: getfield 788	com/tencent/mm/plugin/sns/storage/n:lvy	Lcom/tencent/mm/storagebase/h;
    //   47: ldc2_w 1564
    //   50: invokevirtual 1568	com/tencent/mm/storagebase/h:beginTransaction	(J)J
    //   53: lstore_2
    //   54: lload_2
    //   55: lstore_0
    //   56: aload 9
    //   58: getfield 788	com/tencent/mm/plugin/sns/storage/n:lvy	Lcom/tencent/mm/storagebase/h;
    //   61: ldc_w 790
    //   64: ldc_w 1570
    //   67: invokevirtual 795	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   70: pop
    //   71: lload_2
    //   72: lstore_0
    //   73: aload 9
    //   75: getfield 788	com/tencent/mm/plugin/sns/storage/n:lvy	Lcom/tencent/mm/storagebase/h;
    //   78: ldc_w 790
    //   81: getstatic 1574	com/tencent/mm/plugin/sns/storage/n:SQL_CREATE	[Ljava/lang/String;
    //   84: iconst_0
    //   85: aaload
    //   86: invokevirtual 795	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   89: pop
    //   90: aload 9
    //   92: getfield 788	com/tencent/mm/plugin/sns/storage/n:lvy	Lcom/tencent/mm/storagebase/h;
    //   95: lload_2
    //   96: invokevirtual 1578	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   99: pop
    //   100: ldc_w 799
    //   103: ldc_w 1580
    //   106: iconst_1
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: invokestatic 598	java/lang/System:currentTimeMillis	()J
    //   115: lload 6
    //   117: lsub
    //   118: invokestatic 641	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   121: aastore
    //   122: invokestatic 646	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: invokestatic 678	com/tencent/mm/plugin/sns/model/aj:fOM	()Lcom/tencent/mm/plugin/sns/storage/m;
    //   128: astore 9
    //   130: invokestatic 598	java/lang/System:currentTimeMillis	()J
    //   133: lstore 6
    //   135: aload 9
    //   137: getfield 1581	com/tencent/mm/plugin/sns/storage/m:lvy	Lcom/tencent/mm/storagebase/h;
    //   140: ldc2_w 1564
    //   143: invokevirtual 1568	com/tencent/mm/storagebase/h:beginTransaction	(J)J
    //   146: lstore_2
    //   147: lload_2
    //   148: lstore_0
    //   149: aload 9
    //   151: getfield 1581	com/tencent/mm/plugin/sns/storage/m:lvy	Lcom/tencent/mm/storagebase/h;
    //   154: ldc_w 1452
    //   157: ldc_w 1583
    //   160: invokevirtual 795	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   163: pop
    //   164: lload_2
    //   165: lstore_0
    //   166: aload 9
    //   168: getfield 1581	com/tencent/mm/plugin/sns/storage/m:lvy	Lcom/tencent/mm/storagebase/h;
    //   171: ldc_w 1452
    //   174: getstatic 1584	com/tencent/mm/plugin/sns/storage/m:SQL_CREATE	[Ljava/lang/String;
    //   177: iconst_0
    //   178: aaload
    //   179: invokevirtual 795	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   182: pop
    //   183: aload 9
    //   185: getfield 1581	com/tencent/mm/plugin/sns/storage/m:lvy	Lcom/tencent/mm/storagebase/h;
    //   188: lload_2
    //   189: invokevirtual 1578	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   192: pop
    //   193: ldc_w 1586
    //   196: ldc_w 1580
    //   199: iconst_1
    //   200: anewarray 4	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: invokestatic 598	java/lang/System:currentTimeMillis	()J
    //   208: lload 6
    //   210: lsub
    //   211: invokestatic 641	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   214: aastore
    //   215: invokestatic 646	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: invokestatic 1588	com/tencent/mm/plugin/sns/model/aj:fOR	()Lcom/tencent/mm/plugin/sns/storage/v;
    //   221: astore 9
    //   223: invokestatic 598	java/lang/System:currentTimeMillis	()J
    //   226: lstore 6
    //   228: aload 9
    //   230: getfield 1589	com/tencent/mm/plugin/sns/storage/v:lvy	Lcom/tencent/mm/storagebase/h;
    //   233: ldc2_w 1564
    //   236: invokevirtual 1568	com/tencent/mm/storagebase/h:beginTransaction	(J)J
    //   239: lstore_2
    //   240: lload_2
    //   241: lstore_0
    //   242: aload 9
    //   244: getfield 1589	com/tencent/mm/plugin/sns/storage/v:lvy	Lcom/tencent/mm/storagebase/h;
    //   247: ldc_w 1591
    //   250: ldc_w 1593
    //   253: invokevirtual 795	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   256: pop
    //   257: lload_2
    //   258: lstore_0
    //   259: aload 9
    //   261: getfield 1589	com/tencent/mm/plugin/sns/storage/v:lvy	Lcom/tencent/mm/storagebase/h;
    //   264: ldc_w 1591
    //   267: getstatic 1594	com/tencent/mm/plugin/sns/storage/v:SQL_CREATE	[Ljava/lang/String;
    //   270: iconst_0
    //   271: aaload
    //   272: invokevirtual 795	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   275: pop
    //   276: lload_2
    //   277: lstore_0
    //   278: aload 9
    //   280: getfield 1598	com/tencent/mm/plugin/sns/storage/v:KAc	Ljava/util/Map;
    //   283: invokeinterface 1603 1 0
    //   288: aload 9
    //   290: getfield 1589	com/tencent/mm/plugin/sns/storage/v:lvy	Lcom/tencent/mm/storagebase/h;
    //   293: lload_2
    //   294: invokevirtual 1578	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   297: pop
    //   298: ldc_w 1605
    //   301: ldc_w 1580
    //   304: iconst_1
    //   305: anewarray 4	java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: invokestatic 598	java/lang/System:currentTimeMillis	()J
    //   313: lload 6
    //   315: lsub
    //   316: invokestatic 641	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   319: aastore
    //   320: invokestatic 646	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   323: invokestatic 1607	com/tencent/mm/plugin/sns/model/aj:fOQ	()Lcom/tencent/mm/plugin/sns/storage/x;
    //   326: astore 8
    //   328: invokestatic 598	java/lang/System:currentTimeMillis	()J
    //   331: lstore 6
    //   333: lload 4
    //   335: lstore_0
    //   336: lload 4
    //   338: lstore_2
    //   339: aload 8
    //   341: getfield 1608	com/tencent/mm/plugin/sns/storage/x:lvy	Lcom/tencent/mm/storagebase/h;
    //   344: ldc2_w 1564
    //   347: invokevirtual 1568	com/tencent/mm/storagebase/h:beginTransaction	(J)J
    //   350: lstore 4
    //   352: lload 4
    //   354: lstore_0
    //   355: lload 4
    //   357: lstore_2
    //   358: aload 8
    //   360: getfield 1608	com/tencent/mm/plugin/sns/storage/x:lvy	Lcom/tencent/mm/storagebase/h;
    //   363: ldc_w 1610
    //   366: ldc_w 1612
    //   369: invokevirtual 795	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   372: pop
    //   373: lload 4
    //   375: lstore_0
    //   376: lload 4
    //   378: lstore_2
    //   379: aload 8
    //   381: getfield 1608	com/tencent/mm/plugin/sns/storage/x:lvy	Lcom/tencent/mm/storagebase/h;
    //   384: ldc_w 1610
    //   387: getstatic 1613	com/tencent/mm/plugin/sns/storage/x:SQL_CREATE	[Ljava/lang/String;
    //   390: iconst_0
    //   391: aaload
    //   392: invokevirtual 795	com/tencent/mm/storagebase/h:execSQL	(Ljava/lang/String;Ljava/lang/String;)Z
    //   395: pop
    //   396: aload 8
    //   398: getfield 1608	com/tencent/mm/plugin/sns/storage/x:lvy	Lcom/tencent/mm/storagebase/h;
    //   401: lload 4
    //   403: invokevirtual 1578	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   406: pop
    //   407: ldc_w 1615
    //   410: ldc_w 1580
    //   413: iconst_1
    //   414: anewarray 4	java/lang/Object
    //   417: dup
    //   418: iconst_0
    //   419: invokestatic 598	java/lang/System:currentTimeMillis	()J
    //   422: lload 6
    //   424: lsub
    //   425: invokestatic 641	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   428: aastore
    //   429: invokestatic 646	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   432: getstatic 1535	com/tencent/mm/plugin/sns/b/p:JPh	Lcom/tencent/mm/plugin/sns/b/j;
    //   435: iconst_2
    //   436: invokestatic 1620	com/tencent/mm/model/z:bcZ	()Ljava/lang/String;
    //   439: iconst_1
    //   440: iconst_0
    //   441: invokeinterface 1625 5 0
    //   446: ldc_w 1559
    //   449: invokestatic 354	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: return
    //   453: astore 8
    //   455: lconst_0
    //   456: lstore_2
    //   457: lload_2
    //   458: lstore_0
    //   459: ldc_w 799
    //   462: new 503	java/lang/StringBuilder
    //   465: dup
    //   466: ldc_w 1627
    //   469: invokespecial 508	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   472: aload 8
    //   474: invokevirtual 1630	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   477: invokevirtual 628	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokevirtual 526	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 588	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: aload 9
    //   488: getfield 788	com/tencent/mm/plugin/sns/storage/n:lvy	Lcom/tencent/mm/storagebase/h;
    //   491: lload_2
    //   492: invokevirtual 1578	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   495: pop
    //   496: goto -396 -> 100
    //   499: astore 8
    //   501: lconst_0
    //   502: lstore_0
    //   503: aload 9
    //   505: getfield 788	com/tencent/mm/plugin/sns/storage/n:lvy	Lcom/tencent/mm/storagebase/h;
    //   508: lload_0
    //   509: invokevirtual 1578	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   512: pop
    //   513: ldc_w 1559
    //   516: invokestatic 354	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   519: aload 8
    //   521: athrow
    //   522: astore 8
    //   524: lconst_0
    //   525: lstore_2
    //   526: lload_2
    //   527: lstore_0
    //   528: ldc_w 1586
    //   531: new 503	java/lang/StringBuilder
    //   534: dup
    //   535: ldc_w 1627
    //   538: invokespecial 508	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   541: aload 8
    //   543: invokevirtual 1630	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   546: invokevirtual 628	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: invokevirtual 526	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokestatic 588	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   555: aload 9
    //   557: getfield 1581	com/tencent/mm/plugin/sns/storage/m:lvy	Lcom/tencent/mm/storagebase/h;
    //   560: lload_2
    //   561: invokevirtual 1578	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   564: pop
    //   565: goto -372 -> 193
    //   568: astore 8
    //   570: lconst_0
    //   571: lstore_0
    //   572: aload 9
    //   574: getfield 1581	com/tencent/mm/plugin/sns/storage/m:lvy	Lcom/tencent/mm/storagebase/h;
    //   577: lload_0
    //   578: invokevirtual 1578	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   581: pop
    //   582: ldc_w 1559
    //   585: invokestatic 354	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   588: aload 8
    //   590: athrow
    //   591: astore 8
    //   593: lconst_0
    //   594: lstore_2
    //   595: lload_2
    //   596: lstore_0
    //   597: ldc_w 1605
    //   600: new 503	java/lang/StringBuilder
    //   603: dup
    //   604: ldc_w 1627
    //   607: invokespecial 508	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   610: aload 8
    //   612: invokevirtual 1630	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   615: invokevirtual 628	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 526	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 588	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: aload 9
    //   626: getfield 1589	com/tencent/mm/plugin/sns/storage/v:lvy	Lcom/tencent/mm/storagebase/h;
    //   629: lload_2
    //   630: invokevirtual 1578	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   633: pop
    //   634: goto -336 -> 298
    //   637: astore 8
    //   639: lconst_0
    //   640: lstore_0
    //   641: aload 9
    //   643: getfield 1589	com/tencent/mm/plugin/sns/storage/v:lvy	Lcom/tencent/mm/storagebase/h;
    //   646: lload_0
    //   647: invokevirtual 1578	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   650: pop
    //   651: ldc_w 1559
    //   654: invokestatic 354	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   657: aload 8
    //   659: athrow
    //   660: astore 9
    //   662: lload_0
    //   663: lstore_2
    //   664: ldc_w 1615
    //   667: new 503	java/lang/StringBuilder
    //   670: dup
    //   671: ldc_w 1627
    //   674: invokespecial 508	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   677: aload 9
    //   679: invokevirtual 1630	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   682: invokevirtual 628	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: invokevirtual 526	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 588	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   691: aload 8
    //   693: getfield 1608	com/tencent/mm/plugin/sns/storage/x:lvy	Lcom/tencent/mm/storagebase/h;
    //   696: lload_0
    //   697: invokevirtual 1578	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   700: pop
    //   701: goto -294 -> 407
    //   704: astore 9
    //   706: aload 8
    //   708: getfield 1608	com/tencent/mm/plugin/sns/storage/x:lvy	Lcom/tencent/mm/storagebase/h;
    //   711: lload_2
    //   712: invokevirtual 1578	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   715: pop
    //   716: ldc_w 1559
    //   719: invokestatic 354	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   722: aload 9
    //   724: athrow
    //   725: astore 8
    //   727: goto -86 -> 641
    //   730: astore 8
    //   732: goto -137 -> 595
    //   735: astore 8
    //   737: goto -165 -> 572
    //   740: astore 8
    //   742: goto -216 -> 526
    //   745: astore 8
    //   747: goto -244 -> 503
    //   750: astore 8
    //   752: goto -295 -> 457
    // Local variable table:
    //   start	length	slot	name	signature
    //   55	642	0	l1	long
    //   53	659	2	l2	long
    //   1	401	4	l3	long
    //   40	383	6	l4	long
    //   326	71	8	localx	x
    //   453	20	8	localException1	Exception
    //   499	21	8	localObject1	Object
    //   522	20	8	localException2	Exception
    //   568	21	8	localObject2	Object
    //   591	20	8	localException3	Exception
    //   637	70	8	localObject3	Object
    //   725	1	8	localObject4	Object
    //   730	1	8	localException4	Exception
    //   735	1	8	localObject5	Object
    //   740	1	8	localException5	Exception
    //   745	1	8	localObject6	Object
    //   750	1	8	localException6	Exception
    //   35	607	9	localObject7	Object
    //   660	18	9	localException7	Exception
    //   704	19	9	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   42	54	453	java/lang/Exception
    //   42	54	499	finally
    //   135	147	522	java/lang/Exception
    //   135	147	568	finally
    //   228	240	591	java/lang/Exception
    //   228	240	637	finally
    //   339	352	660	java/lang/Exception
    //   358	373	660	java/lang/Exception
    //   379	396	660	java/lang/Exception
    //   339	352	704	finally
    //   358	373	704	finally
    //   379	396	704	finally
    //   664	691	704	finally
    //   242	257	725	finally
    //   259	276	725	finally
    //   278	288	725	finally
    //   597	624	725	finally
    //   242	257	730	java/lang/Exception
    //   259	276	730	java/lang/Exception
    //   278	288	730	java/lang/Exception
    //   149	164	735	finally
    //   166	183	735	finally
    //   528	555	735	finally
    //   149	164	740	java/lang/Exception
    //   166	183	740	java/lang/Exception
    //   56	71	745	finally
    //   73	90	745	finally
    //   459	486	745	finally
    //   56	71	750	java/lang/Exception
    //   73	90	750	java/lang/Exception
  }
  
  public static MMHandler fwa()
  {
    AppMethodBeat.i(95799);
    if (JYb == null) {
      JYb = new MMHandler("MicroMsg.SnsCore#WorkingHandler");
    }
    MMHandler localMMHandler = JYb;
    AppMethodBeat.o(95799);
    return localMMHandler;
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(95792);
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.kernel.h.aHH();
    String str = com.tencent.mm.kernel.h.aHG().kcB;
    AppMethodBeat.o(95792);
    return str;
  }
  
  public static String getAccSnsPath()
  {
    AppMethodBeat.i(95805);
    String str = ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath();
    AppMethodBeat.o(95805);
    return str;
  }
  
  public static String getAccSnsTmpPath()
  {
    AppMethodBeat.i(95806);
    String str = ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsTmpPath();
    AppMethodBeat.o(95806);
    return str;
  }
  
  public static com.tencent.mm.storagebase.h getDataDB()
  {
    AppMethodBeat.i(95795);
    com.tencent.mm.storagebase.h localh = fOq().kcF;
    AppMethodBeat.o(95795);
    return localh;
  }
  
  public static String getSnsAdPath()
  {
    AppMethodBeat.i(95807);
    String str = ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.sns.b.c.class)).getSnsAdPath();
    AppMethodBeat.o(95807);
    return str;
  }
  
  public static boolean isInValid()
  {
    AppMethodBeat.i(95797);
    fOq();
    if (!com.tencent.mm.kernel.h.aHE().aGM())
    {
      AppMethodBeat.o(95797);
      return true;
    }
    AppMethodBeat.o(95797);
    return false;
  }
  
  public static void k(Point paramPoint)
  {
    lbY = paramPoint;
  }
  
  public final void a(bc parambc)
  {
    AppMethodBeat.i(95837);
    v.a(parambc);
    AppMethodBeat.o(95837);
  }
  
  public final void b(bc parambc)
  {
    AppMethodBeat.i(95838);
    v.b(parambc);
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
    Log.i("MicroMsg.SnsCore", "onAccountPostReset " + Thread.currentThread().getId() + " isAccInit: " + this.JXQ);
    if (this.JXQ)
    {
      AppMethodBeat.o(95834);
      return;
    }
    this.JXQ = true;
    this.wUJ = true;
    checkDir();
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("NewYearSNSCtrl2016", this.JXX, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("NewYearSNSTips2016", this.JXY, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("NewYearSNSAmountLevelCtrl2016", this.JXZ, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("SnsAd", this.JYa, true);
    com.tencent.mm.plugin.sns.b.p.JPb = fOE();
    com.tencent.mm.plugin.sns.b.p.JPc = fOF();
    com.tencent.mm.plugin.sns.b.p.JPd = fOM();
    com.tencent.mm.plugin.sns.b.p.JPe = fON();
    com.tencent.mm.plugin.sns.b.p.JPf = fOO();
    com.tencent.mm.plugin.sns.b.p.JPh = fOy();
    com.tencent.mm.plugin.sns.b.p.JPg = this;
    com.tencent.mm.plugin.sns.b.p.JPi = fOI();
    EventCenter.instance.addListener(this.JYG);
    EventCenter.instance.addListener(this.JYH);
    EventCenter.instance.addListener(this.JYt);
    EventCenter.instance.addListener(this.JYr);
    EventCenter.instance.addListener(this.JYs);
    EventCenter.instance.addListener(this.JYu);
    EventCenter.instance.addListener(this.JYv);
    EventCenter.instance.addListener(this.JYw);
    EventCenter.instance.addListener(this.JYx);
    EventCenter.instance.addListener(this.JYy);
    EventCenter.instance.addListener(this.JYA);
    EventCenter.instance.addListener(this.JYB);
    EventCenter.instance.addListener(this.JYC);
    EventCenter.instance.addListener(this.JYK);
    EventCenter.instance.addListener(this.JYL);
    appForegroundListener.alive();
    this.JYe = new com.tencent.mm.plugin.sns.n();
    this.JYf = new com.tencent.mm.plugin.sns.k();
    this.JYg = new com.tencent.mm.plugin.sns.e();
    this.JYh = new com.tencent.mm.plugin.sns.q();
    this.JYi = new com.tencent.mm.plugin.sns.h();
    this.JYj = new com.tencent.mm.plugin.sns.g();
    this.JYk = new com.tencent.mm.plugin.sns.m();
    this.JYl = new com.tencent.mm.plugin.sns.j();
    this.JYm = new com.tencent.mm.plugin.sns.b();
    this.JYn = new com.tencent.mm.plugin.sns.c();
    this.JYo = new com.tencent.mm.plugin.sns.f();
    EventCenter.instance.addListener(this.JYF);
    EventCenter.instance.addListener(this.JYE);
    EventCenter.instance.addListener(this.JYh);
    EventCenter.instance.addListener(this.JYe);
    EventCenter.instance.addListener(this.JYf);
    EventCenter.instance.addListener(this.JYg);
    EventCenter.instance.addListener(this.JYi);
    EventCenter.instance.addListener(this.JYj);
    EventCenter.instance.addListener(this.JYk);
    EventCenter.instance.addListener(this.JYl);
    EventCenter.instance.addListener(this.JYm);
    EventCenter.instance.addListener(this.JYn);
    EventCenter.instance.addListener(this.JYo);
    EventCenter.instance.addListener(this.FNC);
    this.JXU = new com.tencent.mm.plugin.sns.d();
    EventCenter.instance.addListener(this.JXU);
    EventCenter.instance.addListener(this.JYJ);
    EventCenter.instance.addListener(this.JYp);
    EventCenter.instance.addListener(this.JYq);
    EventCenter.instance.addListener(this.JYD);
    EventCenter.instance.addListener(this.JYz);
    EventCenter.instance.addListener(this.JYO);
    Object localObject1 = fOC();
    com.tencent.mm.plugin.sns.ad.f.n.JFz = com.tencent.mm.n.h.axc().getInt("MMUxAdLog2GSendSize", 20480);
    com.tencent.mm.plugin.sns.ad.f.n.JFA = com.tencent.mm.n.h.axc().getInt("MMUxAdLog3GSendSize", 30720);
    com.tencent.mm.plugin.sns.ad.f.n.JFB = com.tencent.mm.n.h.axc().getInt("MMUxAdLogWifiSendSize", 51200);
    com.tencent.mm.plugin.sns.ad.f.n.JFC = com.tencent.mm.n.h.axc().getInt("MMUxAdLogMinRandTime", 60);
    com.tencent.mm.plugin.sns.ad.f.n.JFD = com.tencent.mm.n.h.axc().getInt("MMUxAdLogMaxRandTime", 1800);
    com.tencent.mm.plugin.sns.ad.f.n.JFE = com.tencent.mm.n.h.axc().getInt("MMUxAdLogMaxExceptionTime", 43200);
    Log.i("MicroMsg.SnsLogMgr", "init " + com.tencent.mm.plugin.sns.ad.f.n.JFz + ";" + com.tencent.mm.plugin.sns.ad.f.n.JFA + ";" + com.tencent.mm.plugin.sns.ad.f.n.JFB + ";" + com.tencent.mm.plugin.sns.ad.f.n.JFC + ";" + com.tencent.mm.plugin.sns.ad.f.n.JFD + ";" + com.tencent.mm.plugin.sns.ad.f.n.JFE);
    if (com.tencent.mm.plugin.sns.ad.f.n.JFD - com.tencent.mm.plugin.sns.ad.f.n.JFC < 0) {
      com.tencent.mm.plugin.sns.ad.f.n.JFD = com.tencent.mm.plugin.sns.ad.f.n.JFC;
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(1802, (com.tencent.mm.an.i)localObject1);
    localObject1 = fOE();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(207, (com.tencent.mm.an.i)localObject1);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(209, (com.tencent.mm.an.i)localObject1);
    localObject1 = this.JXN;
    EventCenter.instance.addListener(((ar)localObject1).JZN);
    EventCenter.instance.addListener(((ar)localObject1).JZO);
    EventCenter.instance.addListener(((ar)localObject1).JZP);
    this.JXV = new com.tencent.mm.plugin.sns.g.a();
    at.init();
    localObject1 = com.tencent.mm.modelsns.m.mby;
    com.tencent.mm.modelsns.m.bpb();
    ah.fOl();
    if (com.tencent.mm.memory.l.baU())
    {
      localObject1 = com.tencent.mm.memory.c.liz;
      localObject2 = com.tencent.mm.memory.c.liz;
      localObject2.getClass();
      ((com.tencent.mm.memory.c)localObject1).a(new e.a((com.tencent.mm.memory.c)localObject2)
      {
        final int JYQ;
        
        public final long baP()
        {
          return 10485760L;
        }
        
        public final int baQ()
        {
          return -1;
        }
      });
    }
    localObject1 = o.liV;
    Object localObject2 = o.liV;
    localObject2.getClass();
    ((o)localObject1).a(new e.a((o)localObject2)
    {
      public final long baP()
      {
        return -1L;
      }
      
      public final int baQ()
      {
        return 3;
      }
    });
    localObject1 = com.tencent.mm.memory.g.liH;
    localObject2 = com.tencent.mm.memory.g.liH;
    localObject2.getClass();
    ((com.tencent.mm.memory.g)localObject1).a(new e.a((com.tencent.mm.memory.g)localObject2)
    {
      public final long baP()
      {
        return 0L;
      }
      
      public final int baQ()
      {
        return 5;
      }
    });
    fOG();
    com.tencent.mm.plugin.sns.f.a.init();
    try
    {
      localObject1 = MultiProcessMMKV.getMMKV("TrackDataSource");
      if (!Util.isNullOrNil(((MultiProcessMMKV)localObject1).getString("path", "")))
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(150, 74);
        com.tencent.mm.plugin.report.service.h.IzE.a(17832, new Object[] { Integer.valueOf(((MultiProcessMMKV)localObject1).getInt("type", 0)), ((MultiProcessMMKV)localObject1).getString("path", ""), Long.valueOf(((MultiProcessMMKV)localObject1).getLong("ts", 0L)), ((MultiProcessMMKV)localObject1).getString("media-url", ""), ((MultiProcessMMKV)localObject1).getString("thumb-url", ""), Long.valueOf(((MultiProcessMMKV)localObject1).getLong("prepare-ts", 0L)), ((MultiProcessMMKV)localObject1).getString("prepare-path", "") });
        ((MultiProcessMMKV)localObject1).putInt("type", 0);
        ((MultiProcessMMKV)localObject1).putString("path", "");
        ((MultiProcessMMKV)localObject1).putLong("ts", 0L);
        ((MultiProcessMMKV)localObject1).putString("media-url", "");
        ((MultiProcessMMKV)localObject1).putString("thumb-url", "");
        ((MultiProcessMMKV)localObject1).putLong("prepare-ts", 0L);
        ((MultiProcessMMKV)localObject1).commit();
      }
      fOq().handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(250993);
          aj.fOE().a(aj.a(aj.this));
          AppMethodBeat.o(250993);
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
    //   0: ldc_w 2007
    //   3: invokestatic 251	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 1829	com/tencent/mm/plugin/sns/model/aj:fOC	()Lcom/tencent/mm/plugin/sns/ad/f/n;
    //   9: astore_1
    //   10: invokestatic 614	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   13: pop
    //   14: invokestatic 1872	com/tencent/mm/kernel/h:aHF	()Lcom/tencent/mm/kernel/c;
    //   17: getfield 1878	com/tencent/mm/kernel/c:kcd	Lcom/tencent/mm/an/t;
    //   20: sipush 1802
    //   23: aload_1
    //   24: invokevirtual 2009	com/tencent/mm/an/t:b	(ILcom/tencent/mm/an/i;)V
    //   27: aload_0
    //   28: getfield 375	com/tencent/mm/plugin/sns/model/aj:JXN	Lcom/tencent/mm/plugin/sns/model/ar;
    //   31: astore_1
    //   32: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   35: aload_1
    //   36: getfield 1886	com/tencent/mm/plugin/sns/model/ar:JZN	Lcom/tencent/mm/sdk/event/IListener;
    //   39: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   42: pop
    //   43: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   46: aload_1
    //   47: getfield 1889	com/tencent/mm/plugin/sns/model/ar:JZO	Lcom/tencent/mm/sdk/event/IListener;
    //   50: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   53: pop
    //   54: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   57: aload_1
    //   58: getfield 1892	com/tencent/mm/plugin/sns/model/ar:JZP	Lcom/tencent/mm/sdk/event/IListener;
    //   61: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   64: pop
    //   65: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   68: aload_0
    //   69: getfield 474	com/tencent/mm/plugin/sns/model/aj:JYG	Lcom/tencent/mm/sdk/event/IListener;
    //   72: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   75: pop
    //   76: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   79: aload_0
    //   80: getfield 479	com/tencent/mm/plugin/sns/model/aj:JYH	Lcom/tencent/mm/sdk/event/IListener;
    //   83: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   86: pop
    //   87: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   90: aload_0
    //   91: getfield 471	com/tencent/mm/plugin/sns/model/aj:JYF	Lcom/tencent/mm/sdk/event/IListener;
    //   94: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   97: pop
    //   98: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   101: aload_0
    //   102: getfield 466	com/tencent/mm/plugin/sns/model/aj:JYE	Lcom/tencent/mm/sdk/event/IListener;
    //   105: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   108: pop
    //   109: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   112: aload_0
    //   113: getfield 431	com/tencent/mm/plugin/sns/model/aj:JYt	Lcom/tencent/mm/sdk/event/IListener;
    //   116: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   119: pop
    //   120: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   123: aload_0
    //   124: getfield 425	com/tencent/mm/plugin/sns/model/aj:JYr	Lcom/tencent/mm/sdk/event/IListener;
    //   127: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   130: pop
    //   131: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   134: aload_0
    //   135: getfield 428	com/tencent/mm/plugin/sns/model/aj:JYs	Lcom/tencent/mm/sdk/event/IListener;
    //   138: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   141: pop
    //   142: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   145: aload_0
    //   146: getfield 434	com/tencent/mm/plugin/sns/model/aj:JYu	Lcom/tencent/mm/sdk/event/IListener;
    //   149: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   152: pop
    //   153: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   156: aload_0
    //   157: getfield 437	com/tencent/mm/plugin/sns/model/aj:JYv	Lcom/tencent/mm/sdk/event/IListener;
    //   160: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   163: pop
    //   164: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   167: aload_0
    //   168: getfield 440	com/tencent/mm/plugin/sns/model/aj:JYw	Lcom/tencent/mm/sdk/event/IListener;
    //   171: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   174: pop
    //   175: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   178: aload_0
    //   179: getfield 1787	com/tencent/mm/plugin/sns/model/aj:JYh	Lcom/tencent/mm/plugin/sns/q;
    //   182: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   185: pop
    //   186: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   189: aload_0
    //   190: getfield 1792	com/tencent/mm/plugin/sns/model/aj:JYi	Lcom/tencent/mm/plugin/sns/h;
    //   193: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   196: pop
    //   197: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   200: aload_0
    //   201: getfield 446	com/tencent/mm/plugin/sns/model/aj:JYy	Lcom/tencent/mm/sdk/event/IListener;
    //   204: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   207: pop
    //   208: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   211: aload_0
    //   212: getfield 452	com/tencent/mm/plugin/sns/model/aj:JYA	Lcom/tencent/mm/sdk/event/IListener;
    //   215: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   218: pop
    //   219: getstatic 347	com/tencent/mm/plugin/sns/model/aj:appForegroundListener	Lcom/tencent/mm/app/o$a;
    //   222: invokevirtual 2015	com/tencent/mm/app/o$a:dead	()V
    //   225: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   228: aload_0
    //   229: getfield 1772	com/tencent/mm/plugin/sns/model/aj:JYe	Lcom/tencent/mm/plugin/sns/n;
    //   232: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   235: pop
    //   236: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   239: aload_0
    //   240: getfield 1777	com/tencent/mm/plugin/sns/model/aj:JYf	Lcom/tencent/mm/plugin/sns/k;
    //   243: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   246: pop
    //   247: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   250: aload_0
    //   251: getfield 1782	com/tencent/mm/plugin/sns/model/aj:JYg	Lcom/tencent/mm/plugin/sns/e;
    //   254: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   257: pop
    //   258: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   261: aload_0
    //   262: getfield 1797	com/tencent/mm/plugin/sns/model/aj:JYj	Lcom/tencent/mm/plugin/sns/g;
    //   265: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   268: pop
    //   269: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   272: aload_0
    //   273: getfield 1802	com/tencent/mm/plugin/sns/model/aj:JYk	Lcom/tencent/mm/plugin/sns/m;
    //   276: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   279: pop
    //   280: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   283: aload_0
    //   284: getfield 1807	com/tencent/mm/plugin/sns/model/aj:JYl	Lcom/tencent/mm/plugin/sns/j;
    //   287: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   290: pop
    //   291: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   294: aload_0
    //   295: getfield 1812	com/tencent/mm/plugin/sns/model/aj:JYm	Lcom/tencent/mm/plugin/sns/b;
    //   298: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   301: pop
    //   302: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   305: aload_0
    //   306: getfield 1817	com/tencent/mm/plugin/sns/model/aj:JYn	Lcom/tencent/mm/plugin/sns/c;
    //   309: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   312: pop
    //   313: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   316: aload_0
    //   317: getfield 1822	com/tencent/mm/plugin/sns/model/aj:JYo	Lcom/tencent/mm/plugin/sns/f;
    //   320: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   323: pop
    //   324: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   327: aload_0
    //   328: getfield 443	com/tencent/mm/plugin/sns/model/aj:JYx	Lcom/tencent/mm/sdk/event/IListener;
    //   331: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   334: pop
    //   335: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   338: aload_0
    //   339: getfield 1827	com/tencent/mm/plugin/sns/model/aj:JXU	Lcom/tencent/mm/plugin/sns/d;
    //   342: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   345: pop
    //   346: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   349: aload_0
    //   350: getfield 457	com/tencent/mm/plugin/sns/model/aj:JYB	Lcom/tencent/mm/sdk/event/IListener;
    //   353: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   356: pop
    //   357: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   360: aload_0
    //   361: getfield 460	com/tencent/mm/plugin/sns/model/aj:JYC	Lcom/tencent/mm/sdk/event/IListener;
    //   364: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   367: pop
    //   368: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   371: aload_0
    //   372: getfield 484	com/tencent/mm/plugin/sns/model/aj:FNC	Lcom/tencent/mm/sdk/event/IListener;
    //   375: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   378: pop
    //   379: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   382: aload_0
    //   383: getfield 487	com/tencent/mm/plugin/sns/model/aj:JYJ	Lcom/tencent/mm/sdk/event/IListener;
    //   386: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   389: pop
    //   390: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   393: aload_0
    //   394: getfield 463	com/tencent/mm/plugin/sns/model/aj:JYD	Lcom/tencent/mm/sdk/event/IListener;
    //   397: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   400: pop
    //   401: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   404: aload_0
    //   405: getfield 417	com/tencent/mm/plugin/sns/model/aj:JYp	Lcom/tencent/mm/sdk/event/IListener;
    //   408: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   411: pop
    //   412: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   415: aload_0
    //   416: getfield 420	com/tencent/mm/plugin/sns/model/aj:JYq	Lcom/tencent/mm/sdk/event/IListener;
    //   419: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   422: pop
    //   423: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   426: aload_0
    //   427: getfield 490	com/tencent/mm/plugin/sns/model/aj:JYK	Lcom/tencent/mm/sdk/event/IListener;
    //   430: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   433: pop
    //   434: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   437: aload_0
    //   438: getfield 449	com/tencent/mm/plugin/sns/model/aj:JYz	Lcom/tencent/mm/sdk/event/IListener;
    //   441: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   444: pop
    //   445: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   448: aload_0
    //   449: getfield 493	com/tencent/mm/plugin/sns/model/aj:JYL	Lcom/tencent/mm/sdk/event/IListener;
    //   452: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   455: pop
    //   456: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   459: aload_0
    //   460: getfield 499	com/tencent/mm/plugin/sns/model/aj:JYO	Lcom/tencent/mm/sdk/event/IListener;
    //   463: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   466: pop
    //   467: getstatic 2021	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a$f:Kky	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a;
    //   470: astore_1
    //   471: aload_1
    //   472: getfield 2026	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:Kkr	Z
    //   475: ifeq +27 -> 502
    //   478: ldc_w 2028
    //   481: ldc_w 2030
    //   484: invokestatic 2032	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: invokestatic 272	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   490: aload_1
    //   491: getfield 2036	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:Kkq	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a$a;
    //   494: invokevirtual 2040	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   497: aload_1
    //   498: iconst_0
    //   499: putfield 2026	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:Kkr	Z
    //   502: invokestatic 2046	com/tencent/mm/plugin/downloader/model/f:cPZ	()Lcom/tencent/mm/plugin/downloader/model/f;
    //   505: pop
    //   506: aload_1
    //   507: getfield 2050	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:Kkv	Lcom/tencent/mm/plugin/downloader/model/m;
    //   510: invokestatic 2055	com/tencent/mm/plugin/downloader/model/c:b	(Lcom/tencent/mm/plugin/downloader/model/m;)V
    //   513: ldc_w 1721
    //   516: invokestatic 920	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   519: checkcast 1721	com/tencent/mm/plugin/messenger/foundation/a/v
    //   522: invokeinterface 1725 1 0
    //   527: ldc_w 1727
    //   530: aload_0
    //   531: getfield 395	com/tencent/mm/plugin/sns/model/aj:JXX	Lcom/tencent/mm/plugin/sns/lucky/a/f;
    //   534: iconst_1
    //   535: invokevirtual 2057	com/tencent/mm/model/ck:b	(Ljava/lang/String;Lcom/tencent/mm/model/ck$a;Z)V
    //   538: ldc_w 1721
    //   541: invokestatic 920	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   544: checkcast 1721	com/tencent/mm/plugin/messenger/foundation/a/v
    //   547: invokeinterface 1725 1 0
    //   552: ldc_w 1734
    //   555: aload_0
    //   556: getfield 400	com/tencent/mm/plugin/sns/model/aj:JXY	Lcom/tencent/mm/plugin/sns/lucky/a/j;
    //   559: iconst_1
    //   560: invokevirtual 2057	com/tencent/mm/model/ck:b	(Ljava/lang/String;Lcom/tencent/mm/model/ck$a;Z)V
    //   563: ldc_w 1721
    //   566: invokestatic 920	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   569: checkcast 1721	com/tencent/mm/plugin/messenger/foundation/a/v
    //   572: invokeinterface 1725 1 0
    //   577: ldc_w 1736
    //   580: aload_0
    //   581: getfield 405	com/tencent/mm/plugin/sns/model/aj:JXZ	Lcom/tencent/mm/plugin/sns/lucky/a/d;
    //   584: iconst_1
    //   585: invokevirtual 2057	com/tencent/mm/model/ck:b	(Ljava/lang/String;Lcom/tencent/mm/model/ck$a;Z)V
    //   588: ldc_w 1721
    //   591: invokestatic 920	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   594: checkcast 1721	com/tencent/mm/plugin/messenger/foundation/a/v
    //   597: invokeinterface 1725 1 0
    //   602: ldc_w 1738
    //   605: aload_0
    //   606: getfield 410	com/tencent/mm/plugin/sns/model/aj:JYa	Lcom/tencent/mm/plugin/sns/lucky/a/l;
    //   609: iconst_1
    //   610: invokevirtual 2057	com/tencent/mm/model/ck:b	(Ljava/lang/String;Lcom/tencent/mm/model/ck$a;Z)V
    //   613: invokestatic 861	com/tencent/mm/plugin/sns/model/aj:fOq	()Lcom/tencent/mm/plugin/sns/model/aj;
    //   616: getfield 370	com/tencent/mm/plugin/sns/model/aj:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   619: new 88	com/tencent/mm/plugin/sns/model/aj$6
    //   622: dup
    //   623: aload_0
    //   624: invokespecial 2058	com/tencent/mm/plugin/sns/model/aj$6:<init>	(Lcom/tencent/mm/plugin/sns/model/aj;)V
    //   627: invokevirtual 1997	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   630: pop
    //   631: invokestatic 1740	com/tencent/mm/plugin/sns/model/aj:fOE	()Lcom/tencent/mm/plugin/sns/model/bd;
    //   634: astore_1
    //   635: invokestatic 614	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   638: pop
    //   639: invokestatic 1872	com/tencent/mm/kernel/h:aHF	()Lcom/tencent/mm/kernel/c;
    //   642: getfield 1878	com/tencent/mm/kernel/c:kcd	Lcom/tencent/mm/an/t;
    //   645: sipush 207
    //   648: aload_1
    //   649: invokevirtual 2009	com/tencent/mm/an/t:b	(ILcom/tencent/mm/an/i;)V
    //   652: invokestatic 614	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   655: pop
    //   656: invokestatic 1872	com/tencent/mm/kernel/h:aHF	()Lcom/tencent/mm/kernel/c;
    //   659: getfield 1878	com/tencent/mm/kernel/c:kcd	Lcom/tencent/mm/an/t;
    //   662: sipush 209
    //   665: aload_1
    //   666: invokevirtual 2009	com/tencent/mm/an/t:b	(ILcom/tencent/mm/an/i;)V
    //   669: ldc 2
    //   671: invokestatic 1282	com/tencent/mm/model/y:as	(Ljava/lang/Class;)Lcom/tencent/mm/model/be;
    //   674: checkcast 2	com/tencent/mm/plugin/sns/model/aj
    //   677: astore_1
    //   678: aload_1
    //   679: ifnull +99 -> 778
    //   682: ldc_w 501
    //   685: ldc_w 2060
    //   688: invokestatic 811	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   691: aload_1
    //   692: getfield 1004	com/tencent/mm/plugin/sns/model/aj:kcF	Lcom/tencent/mm/storagebase/h;
    //   695: ifnull +15 -> 710
    //   698: aload_1
    //   699: getfield 1004	com/tencent/mm/plugin/sns/model/aj:kcF	Lcom/tencent/mm/storagebase/h;
    //   702: invokevirtual 1427	com/tencent/mm/storagebase/h:closeDB	()V
    //   705: aload_1
    //   706: aconst_null
    //   707: putfield 1004	com/tencent/mm/plugin/sns/model/aj:kcF	Lcom/tencent/mm/storagebase/h;
    //   710: aload_1
    //   711: getfield 533	com/tencent/mm/plugin/sns/model/aj:JXm	Ljava/util/concurrent/ExecutorService;
    //   714: ifnull +13 -> 727
    //   717: aload_1
    //   718: getfield 533	com/tencent/mm/plugin/sns/model/aj:JXm	Ljava/util/concurrent/ExecutorService;
    //   721: invokeinterface 2064 1 0
    //   726: pop
    //   727: aload_1
    //   728: getfield 552	com/tencent/mm/plugin/sns/model/aj:IIs	Ljava/util/concurrent/ExecutorService;
    //   731: ifnull +13 -> 744
    //   734: aload_1
    //   735: getfield 552	com/tencent/mm/plugin/sns/model/aj:IIs	Ljava/util/concurrent/ExecutorService;
    //   738: invokeinterface 2064 1 0
    //   743: pop
    //   744: aload_1
    //   745: getfield 556	com/tencent/mm/plugin/sns/model/aj:JXl	Ljava/util/concurrent/ExecutorService;
    //   748: ifnull +13 -> 761
    //   751: aload_1
    //   752: getfield 556	com/tencent/mm/plugin/sns/model/aj:JXl	Ljava/util/concurrent/ExecutorService;
    //   755: invokeinterface 2064 1 0
    //   760: pop
    //   761: aload_1
    //   762: getfield 564	com/tencent/mm/plugin/sns/model/aj:JXn	Ljava/util/concurrent/ExecutorService;
    //   765: ifnull +13 -> 778
    //   768: aload_1
    //   769: getfield 564	com/tencent/mm/plugin/sns/model/aj:JXn	Ljava/util/concurrent/ExecutorService;
    //   772: invokeinterface 2064 1 0
    //   777: pop
    //   778: aload_0
    //   779: getfield 1897	com/tencent/mm/plugin/sns/model/aj:JXV	Lcom/tencent/mm/plugin/sns/g/a;
    //   782: astore_1
    //   783: invokestatic 2066	com/tencent/mm/plugin/sns/model/aj:fOD	()Lcom/tencent/mm/plugin/sns/model/c;
    //   786: aload_1
    //   787: invokevirtual 2069	com/tencent/mm/plugin/sns/model/c:b	(Lcom/tencent/mm/plugin/sns/model/c$b;)V
    //   790: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   793: aload_1
    //   794: getfield 2072	com/tencent/mm/plugin/sns/g/a:JSi	Lcom/tencent/mm/sdk/event/IListener;
    //   797: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   800: pop
    //   801: invokestatic 2075	com/tencent/mm/plugin/sns/model/at:unInit	()V
    //   804: getstatic 1953	com/tencent/mm/memory/g:liH	Lcom/tencent/mm/memory/g;
    //   807: invokevirtual 2078	com/tencent/mm/memory/g:baL	()V
    //   810: getstatic 1927	com/tencent/mm/memory/c:liz	Lcom/tencent/mm/memory/c;
    //   813: invokevirtual 2079	com/tencent/mm/memory/c:baL	()V
    //   816: getstatic 1943	com/tencent/mm/memory/o:liV	Lcom/tencent/mm/memory/o;
    //   819: invokevirtual 2080	com/tencent/mm/memory/o:baL	()V
    //   822: invokestatic 1959	com/tencent/mm/plugin/sns/model/aj:fOG	()Lcom/tencent/mm/plugin/sns/model/ay;
    //   825: astore_1
    //   826: aload_1
    //   827: aconst_null
    //   828: putfield 2084	com/tencent/mm/plugin/sns/model/ay:Kbn	Lcom/tencent/mm/plugin/sns/model/bf;
    //   831: aload_1
    //   832: getfield 2088	com/tencent/mm/plugin/sns/model/ay:Kbr	Ljava/util/LinkedList;
    //   835: astore_2
    //   836: aload_2
    //   837: monitorenter
    //   838: aload_1
    //   839: getfield 2088	com/tencent/mm/plugin/sns/model/ay:Kbr	Ljava/util/LinkedList;
    //   842: invokevirtual 2091	java/util/LinkedList:clear	()V
    //   845: aload_2
    //   846: monitorexit
    //   847: aload_1
    //   848: getfield 2094	com/tencent/mm/plugin/sns/model/ay:Kbp	Ljava/util/Map;
    //   851: invokeinterface 1603 1 0
    //   856: aload_1
    //   857: getfield 2097	com/tencent/mm/plugin/sns/model/ay:Kbo	Ljava/util/LinkedList;
    //   860: invokevirtual 2091	java/util/LinkedList:clear	()V
    //   863: aload_1
    //   864: getfield 2100	com/tencent/mm/plugin/sns/model/ay:Kbq	Ljava/util/LinkedList;
    //   867: astore_2
    //   868: aload_2
    //   869: monitorenter
    //   870: aload_1
    //   871: getfield 2100	com/tencent/mm/plugin/sns/model/ay:Kbq	Ljava/util/LinkedList;
    //   874: invokevirtual 2091	java/util/LinkedList:clear	()V
    //   877: aload_2
    //   878: monitorexit
    //   879: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   882: aload_1
    //   883: getfield 2103	com/tencent/mm/plugin/sns/model/ay:Kbu	Lcom/tencent/mm/sdk/event/IListener;
    //   886: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   889: pop
    //   890: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   893: aload_1
    //   894: getfield 2106	com/tencent/mm/plugin/sns/model/ay:Kbv	Lcom/tencent/mm/sdk/event/IListener;
    //   897: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   900: pop
    //   901: getstatic 1758	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   904: aload_1
    //   905: getfield 2107	com/tencent/mm/plugin/sns/model/ay:JZP	Lcom/tencent/mm/sdk/event/IListener;
    //   908: invokevirtual 2012	com/tencent/mm/sdk/event/EventCenter:removeListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   911: pop
    //   912: invokestatic 2110	com/tencent/mm/plugin/sns/f/a:destroy	()V
    //   915: ldc_w 2007
    //   918: invokestatic 354	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   921: return
    //   922: astore_2
    //   923: ldc_w 2028
    //   926: ldc_w 2112
    //   929: iconst_1
    //   930: anewarray 4	java/lang/Object
    //   933: dup
    //   934: iconst_0
    //   935: aload_2
    //   936: invokevirtual 2113	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   939: aastore
    //   940: invokestatic 745	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   943: goto -441 -> 502
    //   946: astore_1
    //   947: aload_2
    //   948: monitorexit
    //   949: ldc_w 2007
    //   952: invokestatic 354	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   955: aload_1
    //   956: athrow
    //   957: astore_1
    //   958: aload_2
    //   959: monitorexit
    //   960: ldc_w 2007
    //   963: invokestatic 354	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   966: aload_1
    //   967: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	968	0	this	aj
    //   9	896	1	localObject1	Object
    //   946	10	1	localObject2	Object
    //   957	10	1	localObject3	Object
    //   922	37	2	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   478	502	922	java/lang/IllegalArgumentException
    //   838	847	946	finally
    //   870	879	957	finally
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(95836);
    checkDir();
    AppMethodBeat.o(95836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aj
 * JD-Core Version:    0.7.0.1
 */