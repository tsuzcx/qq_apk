package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.abf;
import com.tencent.mm.autogen.a.ue;
import com.tencent.mm.memory.BucketPool;
import com.tencent.mm.memory.BucketPool.a;
import com.tencent.mm.memory.n.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.ExtGetSnsDataEventListener;
import com.tencent.mm.plugin.sns.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener;
import com.tencent.mm.plugin.sns.GetSnsObjectDetailListener;
import com.tencent.mm.plugin.sns.GetSnsTagListListener;
import com.tencent.mm.plugin.sns.GetSnsTimeLineObjectListener;
import com.tencent.mm.plugin.sns.PostSnsAsyncTaskListener;
import com.tencent.mm.plugin.sns.PostSnsTagMemberOptionListener;
import com.tencent.mm.plugin.sns.RecentlySnsMediaObjListener;
import com.tencent.mm.plugin.sns.RemoveSnsTaskEventListener;
import com.tencent.mm.plugin.sns.SnsSyncListener;
import com.tencent.mm.plugin.sns.SnsfillEventInfoListener;
import com.tencent.mm.plugin.sns.UpdateSnsTagListListener;
import com.tencent.mm.plugin.sns.lucky.a.l;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.ad;
import com.tencent.mm.plugin.sns.storage.af;
import com.tencent.mm.plugin.sns.storage.ah;
import com.tencent.mm.plugin.sns.storage.ak;
import com.tencent.mm.plugin.sns.storage.am;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public final class al
  implements be, com.tencent.mm.plugin.sns.c.m
{
  public static boolean Qus;
  private static int Qux;
  private static int Quy;
  private static String Qvd;
  protected static HashMap<Integer, h.b> Qve;
  private static MMHandler Qvm;
  private static int Qvn;
  private static int Qvo;
  private static q.a appForegroundListener;
  private static Point nGU;
  private boolean Arp;
  private IListener LIy;
  private ExecutorService OOq;
  private w QuA;
  private com.tencent.mm.plugin.sns.storage.f QuB;
  private com.tencent.mm.plugin.sns.storage.d QuC;
  private am QuD;
  private g QuE;
  private com.tencent.mm.plugin.sns.storage.v QuF;
  private r QuG;
  private p QuH;
  private ad QuI;
  private t QuJ;
  private ai QuK;
  private ah QuL;
  private af QuM;
  private ar.a QuN;
  private c QuO;
  private bf QuP;
  private com.tencent.mm.plugin.sns.ui.av QuQ;
  private com.tencent.mm.plugin.sns.i.c QuR;
  private com.tencent.mm.plugin.sns.i.g QuS;
  private ax QuT;
  private au QuU;
  private com.tencent.mm.plugin.sns.storage.y QuV;
  private com.tencent.mm.plugin.sns.ad.g.n QuW;
  private at QuX;
  private com.tencent.mm.plugin.sns.f.a QuY;
  private boolean QuZ;
  private ExecutorService Qut;
  private ExecutorService Quu;
  private ExecutorService Quv;
  private ab Quw;
  private aa Quz;
  private IListener QvA;
  private IListener QvB;
  private IListener QvC;
  private IListener QvD;
  private IListener QvE;
  private IListener QvF;
  private IListener QvG;
  private IListener QvH;
  private IListener QvI;
  private IListener QvJ;
  private IListener QvK;
  private IListener QvL;
  private IListener QvM;
  private IListener QvN;
  private IListener QvO;
  private IListener QvP;
  private IListener QvQ;
  private IListener QvR;
  private IListener QvS;
  private boolean QvT;
  private IListener QvU;
  private IListener QvV;
  private IListener QvW;
  private final bf.a QvX;
  private IListener QvY;
  private ak Qva;
  private boolean Qvb;
  private byte[] Qvc;
  private GetSnsObjectDetailListener Qvf;
  private com.tencent.mm.plugin.sns.fts.a Qvg;
  private ba Qvh;
  private com.tencent.mm.plugin.sns.lucky.a.f Qvi;
  private com.tencent.mm.plugin.sns.lucky.a.j Qvj;
  private com.tencent.mm.plugin.sns.lucky.a.d Qvk;
  private l Qvl;
  private SnsfillEventInfoListener Qvp;
  private RemoveSnsTaskEventListener Qvq;
  private GetSnsTagListListener Qvr;
  private UpdateSnsTagListListener Qvs;
  private PostSnsTagMemberOptionListener Qvt;
  private PostSnsAsyncTaskListener Qvu;
  private SnsSyncListener Qvv;
  private RecentlySnsMediaObjListener Qvw;
  private ExtGetSnsDataEventListener Qvx;
  private ExtStartSnsServerAndCallbackOnFpSetSizeEventListener Qvy;
  private GetSnsTimeLineObjectListener Qvz;
  private MMHandler handler;
  private byte[] lock;
  
  static
  {
    AppMethodBeat.i(95843);
    Qus = true;
    Qvd = "";
    Qve = new HashMap();
    Qvn = 103;
    Qvo = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 130);
    nGU = new Point();
    Qve.put(Integer.valueOf("CanvasInfo".hashCode()), new al.1());
    Qve.put(Integer.valueOf("UxCanvasInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return am.SQL_CREATE;
      }
    });
    Qve.put(Integer.valueOf("SNSMEDIA_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return aa.SQL_CREATE;
      }
    });
    Qve.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return w.SQL_CREATE;
      }
    });
    Qve.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return w.SQL_CREATE;
      }
    });
    Qve.put(Integer.valueOf("ADSNSINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.f.SQL_CREATE;
      }
    });
    Qve.put(Integer.valueOf("SNSEXT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.sns.storage.v.SQL_CREATE;
      }
    });
    Qve.put(Integer.valueOf("SNSCOMMENT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return p.SQL_CREATE;
      }
    });
    Qve.put(Integer.valueOf("SNSTAGINFO_TABLE".hashCode()), new al.22());
    Qve.put(Integer.valueOf("SNSKVREPORT_TABLE".hashCode()), new al.2());
    Qve.put(Integer.valueOf("SNSDRAFT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return t.SQL_CREATE;
      }
    });
    Qve.put(Integer.valueOf("SNSCOVER_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(309382);
        Object localObject = r.QYI;
        localObject = r.dZh();
        AppMethodBeat.o(309382);
        return localObject;
      }
    });
    Qve.put(Integer.valueOf("SNSWSFOLDGROUP_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ah.SQL_CREATE;
      }
    });
    Qve.put(Integer.valueOf("SNSWSFOLDDETAIL_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return af.SQL_CREATE;
      }
    });
    appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(309388);
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          if (!com.tencent.mm.kernel.b.aZG())
          {
            paramAnonymousString = new ue();
            paramAnonymousString.hXV.state = 0;
            paramAnonymousString.publish();
            new abf().publish();
          }
        }
        AppMethodBeat.o(309388);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(309384);
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          if (!com.tencent.mm.kernel.b.aZG())
          {
            paramAnonymousString = new ue();
            paramAnonymousString.hXV.state = 1;
            paramAnonymousString.publish();
          }
        }
        AppMethodBeat.o(309384);
      }
    };
    AppMethodBeat.o(95843);
  }
  
  public al()
  {
    AppMethodBeat.i(95798);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.QuX = new at();
    this.Arp = false;
    this.QuZ = true;
    this.lock = new byte[0];
    this.Qva = new ak();
    this.Qvb = false;
    this.Qvc = new byte[0];
    this.Qvi = new com.tencent.mm.plugin.sns.lucky.a.f();
    this.Qvj = new com.tencent.mm.plugin.sns.lucky.a.j();
    this.Qvk = new com.tencent.mm.plugin.sns.lucky.a.d();
    this.Qvl = new l();
    this.QvA = new SnsCore.21(this, com.tencent.mm.app.f.hfK);
    this.QvB = new SnsCore.22(this, com.tencent.mm.app.f.hfK);
    this.QvC = new SnsCore.23(this, com.tencent.mm.app.f.hfK);
    this.QvD = new SnsCore.24(this, com.tencent.mm.app.f.hfK);
    this.QvE = new SnsCore.25(this, com.tencent.mm.app.f.hfK);
    this.QvF = new SnsCore.26(this, com.tencent.mm.app.f.hfK);
    this.QvG = new SnsCore.27(this, com.tencent.mm.app.f.hfK);
    this.QvH = new SnsCore.28(this, com.tencent.mm.app.f.hfK);
    this.QvI = new SnsCore.29(this, com.tencent.mm.app.f.hfK);
    this.QvJ = new SnsCore.30(this, com.tencent.mm.app.f.hfK);
    this.QvK = new SnsCore.31(this, com.tencent.mm.app.f.hfK);
    this.QvL = new SnsCore.32(this, com.tencent.mm.app.f.hfK);
    this.QvM = new SnsCore.33(this, com.tencent.mm.app.f.hfK);
    this.QvN = new SnsCore.34(this, com.tencent.mm.app.f.hfK);
    this.QvO = new SnsCore.35(this, com.tencent.mm.app.f.hfK);
    this.QvP = new SnsCore.36(this, com.tencent.mm.app.f.hfK);
    this.QvQ = new SnsCore.37(this, com.tencent.mm.app.f.hfK);
    this.QvR = new SnsCore.38(this, com.tencent.mm.app.f.hfK);
    this.QvS = new SnsCore.39(this, com.tencent.mm.app.f.hfK);
    this.QvT = false;
    this.LIy = new SnsCore.41(this, com.tencent.mm.app.f.hfK);
    this.QvU = new SnsCore.42(this, com.tencent.mm.app.f.hfK);
    this.QvV = new SnsCore.43(this, com.tencent.mm.app.f.hfK);
    this.QvW = new SnsCore.44(this, com.tencent.mm.app.f.hfK);
    this.QvX = new al.17(this);
    this.QvY = new SnsCore.46(this, com.tencent.mm.app.f.hfK);
    Log.i("MicroMsg.SnsCore", "snscore create! " + Thread.currentThread().getId());
    if (this.Quu == null) {
      this.Quu = com.tencent.threadpool.h.ahAA.a("SnsCore_CDNDownload_handler", 6, 6, new LinkedBlockingQueue());
    }
    if (this.OOq == null) {
      this.OOq = com.tencent.threadpool.h.ahAA.a("SnsCore_thumbDecode_handler", 6, 6, new LinkedBlockingQueue());
    }
    if (this.Qut == null) {
      this.Qut = com.tencent.threadpool.h.ahAA.bFR("SnsCore#File");
    }
    if (this.Quv == null) {
      this.Quv = com.tencent.threadpool.h.ahAA.bFR("SnsCore#Task");
    }
    AppMethodBeat.o(95798);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(95835);
    com.tencent.mm.vfs.y.bDX(((com.tencent.mm.plugin.sns.c.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.sns.c.c.class)).getAccSnsPath());
    com.tencent.mm.vfs.y.bDX(((com.tencent.mm.plugin.sns.c.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.sns.c.c.class)).getAccSnsTmpPath());
    com.tencent.mm.vfs.y.bEr(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.hkC());
    AppMethodBeat.o(95835);
  }
  
  public static MMHandler fAG()
  {
    AppMethodBeat.i(95804);
    MMHandler localMMHandler = hgj().handler;
    AppMethodBeat.o(95804);
    return localMMHandler;
  }
  
  public static MMHandler gHI()
  {
    AppMethodBeat.i(95799);
    if (Qvm == null) {
      Qvm = new MMHandler("MicroMsg.SnsCore#WorkingHandler");
    }
    MMHandler localMMHandler = Qvm;
    AppMethodBeat.o(95799);
    return localMMHandler;
  }
  
  public static Point gbR()
  {
    AppMethodBeat.i(95830);
    if (nGU.x == 0)
    {
      localObject = (WindowManager)MMApplicationContext.getContext().getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
      nGU.x = localDisplayMetrics.widthPixels;
      nGU.y = localDisplayMetrics.heightPixels;
    }
    Object localObject = nGU;
    AppMethodBeat.o(95830);
    return localObject;
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(95792);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.kernel.h.baF();
    String str = com.tencent.mm.kernel.h.baE().mCJ;
    AppMethodBeat.o(95792);
    return str;
  }
  
  public static String getAccSnsPath()
  {
    AppMethodBeat.i(95805);
    String str = ((com.tencent.mm.plugin.sns.c.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.sns.c.c.class)).getAccSnsPath();
    AppMethodBeat.o(95805);
    return str;
  }
  
  public static String getAccSnsTmpPath()
  {
    AppMethodBeat.i(95806);
    String str = ((com.tencent.mm.plugin.sns.c.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.sns.c.c.class)).getAccSnsTmpPath();
    AppMethodBeat.o(95806);
    return str;
  }
  
  public static String getSnsAdPath()
  {
    AppMethodBeat.i(95807);
    String str = ((com.tencent.mm.plugin.sns.c.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.sns.c.c.class)).getSnsAdPath();
    AppMethodBeat.o(95807);
    return str;
  }
  
  public static ai hgA()
  {
    AppMethodBeat.i(95819);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuK == null)
    {
      localObject = hgj();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baF();
      ((al)localObject).QuK = new ai(com.tencent.mm.kernel.h.baE().cachePath + "snsAsyncQueue.data");
    }
    Object localObject = hgj().QuK;
    AppMethodBeat.o(95819);
    return localObject;
  }
  
  public static w hgB()
  {
    AppMethodBeat.i(95820);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuA == null)
    {
      hgj().QuA = new w(hgj().Quw);
      com.tencent.mm.plugin.sns.c.q.Qko = hgj().QuA;
    }
    w localw = hgj().QuA;
    AppMethodBeat.o(95820);
    return localw;
  }
  
  public static com.tencent.mm.plugin.sns.storage.d hgC()
  {
    AppMethodBeat.i(95821);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuC == null) {
      hgj().QuC = new com.tencent.mm.plugin.sns.storage.d(hgj().Quw);
    }
    com.tencent.mm.plugin.sns.storage.d locald = hgj().QuC;
    AppMethodBeat.o(95821);
    return locald;
  }
  
  public static am hgD()
  {
    AppMethodBeat.i(95822);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuD == null) {
      hgj().QuD = new am(hgj().Quw);
    }
    am localam = hgj().QuD;
    AppMethodBeat.o(95822);
    return localam;
  }
  
  public static com.tencent.mm.plugin.sns.storage.f hgE()
  {
    AppMethodBeat.i(95823);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuB == null) {
      hgj().QuB = new com.tencent.mm.plugin.sns.storage.f(hgj().Quw);
    }
    com.tencent.mm.plugin.sns.storage.f localf = hgj().QuB;
    AppMethodBeat.o(95823);
    return localf;
  }
  
  public static com.tencent.mm.plugin.sns.storage.v hgF()
  {
    AppMethodBeat.i(95824);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuF == null)
    {
      hgj().QuF = new com.tencent.mm.plugin.sns.storage.v(hgj().Quw, new an());
      com.tencent.mm.plugin.sns.c.q.Qki = hgj().QuF;
    }
    com.tencent.mm.plugin.sns.storage.v localv = hgj().QuF;
    AppMethodBeat.o(95824);
    return localv;
  }
  
  public static r hgG()
  {
    AppMethodBeat.i(309509);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuG == null)
    {
      hgj().QuG = new r(hgj().Quw);
      com.tencent.mm.plugin.sns.c.q.Qkj = hgj().QuG;
    }
    r localr = hgj().QuG;
    AppMethodBeat.o(309509);
    return localr;
  }
  
  public static p hgH()
  {
    AppMethodBeat.i(95825);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuH == null)
    {
      hgj().QuH = new p(hgj().Quw);
      com.tencent.mm.plugin.sns.c.q.Qkk = hgj().QuH;
    }
    p localp = hgj().QuH;
    AppMethodBeat.o(95825);
    return localp;
  }
  
  public static ad hgI()
  {
    AppMethodBeat.i(95826);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuI == null)
    {
      hgj().QuI = new ad(hgj().Quw);
      com.tencent.mm.plugin.sns.c.q.Qkl = hgj().QuI;
    }
    ad localad = hgj().QuI;
    AppMethodBeat.o(95826);
    return localad;
  }
  
  public static t hgJ()
  {
    AppMethodBeat.i(176273);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuJ == null) {
      hgj().QuJ = new t(hgj().Quw);
    }
    t localt = hgj().QuJ;
    AppMethodBeat.o(176273);
    return localt;
  }
  
  public static ah hgK()
  {
    AppMethodBeat.i(309515);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuL == null) {
      hgj().QuL = new ah(hgj().Quw);
    }
    ah localah = hgj().QuL;
    AppMethodBeat.o(309515);
    return localah;
  }
  
  public static af hgL()
  {
    AppMethodBeat.i(309520);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuM == null) {
      hgj().QuM = new af(hgj().Quw);
    }
    af localaf = hgj().QuM;
    AppMethodBeat.o(309520);
    return localaf;
  }
  
  public static com.tencent.mm.plugin.sns.ui.av hgM()
  {
    AppMethodBeat.i(95827);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuQ == null) {
      hgj().QuQ = new com.tencent.mm.plugin.sns.ui.av();
    }
    com.tencent.mm.plugin.sns.ui.av localav = hgj().QuQ;
    AppMethodBeat.o(95827);
    return localav;
  }
  
  public static ax hgN()
  {
    AppMethodBeat.i(179093);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuT == null) {
      hgj().QuT = new ax();
    }
    ax localax = hgj().QuT;
    AppMethodBeat.o(179093);
    return localax;
  }
  
  public static au hgO()
  {
    AppMethodBeat.i(309526);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuU == null) {
      hgj().QuU = new au();
    }
    au localau = hgj().QuU;
    AppMethodBeat.o(309526);
    return localau;
  }
  
  public static int hgP()
  {
    AppMethodBeat.i(95828);
    int i = (gbR().x - com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), Qvn)) / 3;
    Qux = i;
    if (i > Qvo) {}
    for (i = Qvo;; i = Qux)
    {
      Qux = i;
      if (i > 10) {
        break;
      }
      Log.e("MicroMsg.SnsCore", "can not get multiThumbDisplaySize or the multiThumbDisplaySize < 10");
      AppMethodBeat.o(95828);
      return 150;
    }
    i = Qux;
    AppMethodBeat.o(95828);
    return i;
  }
  
  public static int hgQ()
  {
    AppMethodBeat.i(95829);
    if (Quy <= 0)
    {
      Quy = 200;
      Quy = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), Quy);
    }
    int i = Quy;
    AppMethodBeat.o(95829);
    return i;
  }
  
  public static boolean hgR()
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
  
  public static boolean hgS()
  {
    AppMethodBeat.i(309548);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zok, false);
    AppMethodBeat.o(309548);
    return bool;
  }
  
  public static boolean hgT()
  {
    AppMethodBeat.i(309552);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(309552);
      return true;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoj, false);
    AppMethodBeat.o(309552);
    return bool;
  }
  
  public static boolean hgU()
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
  
  public static String hgV()
  {
    AppMethodBeat.i(95839);
    AppMethodBeat.o(95839);
    return "";
  }
  
  public static com.tencent.mm.plugin.sns.f.a hgW()
  {
    AppMethodBeat.i(309560);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuY == null) {
      hgj().QuY = new com.tencent.mm.plugin.sns.f.a();
    }
    com.tencent.mm.plugin.sns.f.a locala = hgj().QuY;
    AppMethodBeat.o(309560);
    return locala;
  }
  
  public static String hgg()
  {
    AppMethodBeat.i(95793);
    com.tencent.mm.kernel.h.baF();
    String str = (String)com.tencent.mm.kernel.h.baE().ban().d(2, null);
    AppMethodBeat.o(95793);
    return str;
  }
  
  public static int hgh()
  {
    AppMethodBeat.i(95794);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC();
    int i = com.tencent.mm.kernel.b.getUin();
    AppMethodBeat.o(95794);
    return i;
  }
  
  public static ab hgi()
  {
    AppMethodBeat.i(309436);
    ab localab = hgj().Quw;
    AppMethodBeat.o(309436);
    return localab;
  }
  
  private static al hgj()
  {
    AppMethodBeat.i(95796);
    al localal = (al)com.tencent.mm.model.y.aL(al.class);
    if (!localal.Qvb) {}
    synchronized (localal.Qvc)
    {
      if (!localal.Qvb)
      {
        Log.i("MicroMsg.SnsCore", "onAccInit because bug!");
        localal.onAccountPostReset(true);
      }
      if (!localal.Arp) {}
    }
    Object localObject3;
    boolean bool;
    String str;
    long l1;
    for (;;)
    {
      synchronized (localal.lock)
      {
        Log.i("MicroMsg.SnsCore", "getCore need reset DB now " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + localal.hashCode());
        if (localal.Arp)
        {
          localal.QuZ = false;
          localObject4 = localal.Qva;
          localObject3 = Qve;
          if (((ak)localObject4).QZG)
          {
            Log.i("MicroMsg.TrimSnsDb", "pass hasTrim");
            if (localal.Quw == null)
            {
              localal.Quw = new ab();
              com.tencent.mm.kernel.h.baF();
              localObject3 = com.tencent.mm.kernel.h.baE().cachePath;
              localObject3 = (String)localObject3 + "SnsMicroMsg.db";
              if (!localal.Quw.a((String)localObject3, Qve, true))
              {
                com.tencent.mm.plugin.report.service.h.OAn.kJ(150, 82);
                hgk();
                localal.Quw = new ab();
                bool = localal.Quw.a((String)localObject3, Qve, true);
                Log.i("MicroMsg.SnsCore", "one more time result:%s:", new Object[] { Boolean.valueOf(bool) });
                if (bool) {
                  com.tencent.mm.plugin.report.service.h.OAn.kJ(150, 83);
                }
              }
            }
            localal.Arp = false;
            Log.i("MicroMsg.SnsCore", "resetdb done");
          }
        }
        else
        {
          AppMethodBeat.o(95796);
          return localal;
          localObject1 = finally;
          AppMethodBeat.o(95796);
          throw localObject1;
        }
        com.tencent.mm.kernel.h.baF();
        if (!com.tencent.mm.kernel.h.baC().aZN()) {
          continue;
        }
        i = Util.getInt(com.tencent.mm.k.i.aRC().getValue("AndroidCleanSnsDb"), 0);
        Log.i("MicroMsg.TrimSnsDb", "pass dynamic? ".concat(String.valueOf(i)));
        if (i > 0) {
          continue;
        }
        com.tencent.mm.kernel.h.baF();
        str = com.tencent.mm.kernel.h.baE().cachePath;
        if (com.tencent.mm.vfs.y.ZC(str + "SnsMicroMsg2.db.ini"))
        {
          ak.bat(str);
          com.tencent.mm.vfs.y.deleteFile(str + "SnsMicroMsg2.db.ini");
        }
        localObject5 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
        if (Util.secondsToNow(((SharedPreferences)localObject5).getLong("check_trim_time", 0L)) < 604800L) {
          Log.i("MicroMsg.TrimSnsDb", "trim sns pass because time short");
        }
      }
      ((SharedPreferences)localObject5).edit().putLong("check_trim_time", Util.nowSecond()).commit();
      ((ak)localObject4).QZG = true;
      l1 = System.currentTimeMillis();
      i = com.tencent.mm.m.a.aTd();
      if ((i == 1) || (i == 2))
      {
        Log.i("MicroMsg.TrimSnsDb", "trim sns error space dangerous");
      }
      else if (com.tencent.mm.vfs.y.ZC(str + "sns_mark.ini"))
      {
        if (Util.milliSecondsToNow(com.tencent.mm.vfs.y.bEm(str + "sns_mark.ini")) < 2592000000L)
        {
          Log.i("MicroMsg.TrimSnsDb", "mark file exist and return");
          ak.bat(str);
        }
        else
        {
          com.tencent.mm.vfs.y.deleteFile(str + "sns_mark.ini");
        }
      }
      else
      {
        l2 = com.tencent.mm.vfs.y.bEl(str + "SnsMicroMsg.db");
        Log.i("MicroMsg.TrimSnsDb", "trim sns ".concat(String.valueOf(l2)));
        if (l2 >= 52428800L) {
          break;
        }
        Log.i("MicroMsg.TrimSnsDb", "trim sns free pass: " + (System.currentTimeMillis() - l1));
      }
    }
    com.tencent.mm.vfs.y.bEp(str + "sns_mark.ini");
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
    if (!ak.a((com.tencent.mm.storagebase.h)localObject5, (com.tencent.mm.storagebase.h)localObject4)) {}
    for (int i = -1;; i = 1)
    {
      long l3 = System.currentTimeMillis() - l2;
      Log.i("MicroMsg.TrimSnsDb", "copysns insert all %d passed ret:".concat(String.valueOf(i)), new Object[] { Long.valueOf(l3) });
      ((com.tencent.mm.storagebase.h)localObject5).closeDB();
      ((com.tencent.mm.storagebase.h)localObject4).closeDB();
      if (i >= 0)
      {
        com.tencent.mm.kernel.h.baF();
        localObject3 = com.tencent.mm.kernel.h.baE().cachePath;
        com.tencent.mm.vfs.y.deleteFile((String)localObject3 + "SnsMicroMsg.db");
        Log.i("MicroMsg.TrimSnsDb", "rename file ".concat(String.valueOf(com.tencent.mm.vfs.y.bF((String)localObject3, "SnsMicroMsg2.db", "SnsMicroMsg.db"))));
        com.tencent.mm.vfs.y.deleteFile((String)localObject3 + "SnsMicroMsg.db-shm");
        com.tencent.mm.vfs.y.deleteFile((String)localObject3 + "SnsMicroMsg.db-wal");
        com.tencent.mm.vfs.y.deleteFile((String)localObject3 + "SnsMicroMsg.db.ini");
        com.tencent.mm.vfs.y.O("SnsMicroMsg2.db.ini", "SnsMicroMsg.db.ini", false);
        com.tencent.mm.vfs.y.deleteFile((String)localObject3 + "SnsMicroMsg2.db.ini");
        com.tencent.mm.vfs.y.deleteFile((String)localObject3 + "SnsMicroMsg2.db");
        com.tencent.mm.vfs.y.deleteFile((String)localObject3 + "sns_mark.ini");
      }
      l2 = System.currentTimeMillis() - l2;
      Log.i("MicroMsg.TrimSnsDb", "copysns data ret=%d all: %d copytime %d ", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l2 - l3) });
      Log.i("MicroMsg.TrimSnsDb", "trim sns done pass: " + (System.currentTimeMillis() - l1));
      break;
      l3 = System.currentTimeMillis();
      ak.a((com.tencent.mm.storagebase.h)localObject5, (com.tencent.mm.storagebase.h)localObject4, "snsExtInfo3");
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "insert into " + "snsExtInfo3" + " select * from old." + "snsExtInfo3");
      Log.i("MicroMsg.TrimSnsDb", "copysns ret_ext:" + bool + " passed " + (System.currentTimeMillis() - l3));
      ak.a((com.tencent.mm.storagebase.h)localObject5, (com.tencent.mm.storagebase.h)localObject4, "SnsComment");
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "insert into " + "SnsComment" + " select * from old." + "SnsComment");
      Log.i("MicroMsg.TrimSnsDb", "copysns ret_msg:" + bool + " passed " + (System.currentTimeMillis() - l3));
      ak.a((com.tencent.mm.storagebase.h)localObject5, (com.tencent.mm.storagebase.h)localObject4, "SnsInfo");
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "insert into " + "SnsInfo" + " select * from old." + "SnsInfo" + " where  (sourceType & 2 != 0 ) " + w.QYW + " limit 200");
      Log.i("MicroMsg.TrimSnsDb", "copysns ret_sns:" + bool + " passed " + (System.currentTimeMillis() - l3));
      bool = ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "update snsExtinfo3 set md5 = '', faults = '';");
      Log.i("MicroMsg.TrimSnsDb", "update ext info  passed  %s  updateRet %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l3), Boolean.valueOf(bool) });
      ((com.tencent.mm.storagebase.h)localObject4).execSQL("", "DETACH DATABASE old");
    }
  }
  
  private static void hgk()
  {
    AppMethodBeat.i(309458);
    Log.i("MicroMsg.SnsCore", "removeDirtyDB.");
    com.tencent.mm.kernel.h.baF();
    Object localObject = com.tencent.mm.vfs.y.eB(com.tencent.mm.kernel.h.baE().cachePath, false);
    if (localObject == null)
    {
      Log.e("MicroMsg.SnsCore", "removeDirtyDB files null");
      AppMethodBeat.o(309458);
      return;
    }
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.vfs.j localj = (com.tencent.mm.vfs.j)((Iterator)localObject).next();
      if ((!localj.agxh) && (localj.name.contains("SnsMicroMsg")))
      {
        Log.i("MicroMsg.SnsCore", "removeDirtyDB will delete:%s", new Object[] { localj.acpB });
        localj.NP(true);
      }
    }
    AppMethodBeat.o(309458);
  }
  
  public static ExecutorService hgl()
  {
    AppMethodBeat.i(179089);
    ExecutorService localExecutorService = hgj().Quu;
    AppMethodBeat.o(179089);
    return localExecutorService;
  }
  
  public static ExecutorService hgm()
  {
    AppMethodBeat.i(179090);
    ExecutorService localExecutorService = hgj().OOq;
    AppMethodBeat.o(179090);
    return localExecutorService;
  }
  
  protected static ExecutorService hgn()
  {
    AppMethodBeat.i(179091);
    ExecutorService localExecutorService = hgj().Qut;
    AppMethodBeat.o(179091);
    return localExecutorService;
  }
  
  public static ExecutorService hgo()
  {
    AppMethodBeat.i(179092);
    ExecutorService localExecutorService = hgj().Quv;
    AppMethodBeat.o(179092);
    return localExecutorService;
  }
  
  public static bx hgp()
  {
    AppMethodBeat.i(95808);
    com.tencent.mm.kernel.h.baF();
    bx localbx = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA();
    AppMethodBeat.o(95808);
    return localbx;
  }
  
  public static aa hgq()
  {
    AppMethodBeat.i(95809);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().Quz == null) {
      hgj().Quz = new aa(hgj().Quw);
    }
    aa localaa = hgj().Quz;
    AppMethodBeat.o(95809);
    return localaa;
  }
  
  public static ar.a hgr()
  {
    AppMethodBeat.i(95810);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuN == null)
    {
      hgj().QuN = new ar.a();
      com.tencent.mm.plugin.sns.c.q.Qkn = hgj().QuN;
    }
    ar.a locala = hgj().QuN;
    AppMethodBeat.o(95810);
    return locala;
  }
  
  public static com.tencent.mm.plugin.sns.i.c hgs()
  {
    AppMethodBeat.i(95811);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuR == null) {
      hgj().QuR = new com.tencent.mm.plugin.sns.i.c();
    }
    com.tencent.mm.plugin.sns.i.c localc = hgj().QuR;
    AppMethodBeat.o(95811);
    return localc;
  }
  
  public static com.tencent.mm.plugin.sns.i.g hgt()
  {
    AppMethodBeat.i(95812);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuS == null) {
      hgj().QuS = new com.tencent.mm.plugin.sns.i.g();
    }
    com.tencent.mm.plugin.sns.i.g localg = hgj().QuS;
    AppMethodBeat.o(95812);
    return localg;
  }
  
  public static com.tencent.mm.plugin.sns.storage.y hgu()
  {
    AppMethodBeat.i(95813);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuV == null) {
      hgj().QuV = new com.tencent.mm.plugin.sns.storage.y(hgj().Quw);
    }
    com.tencent.mm.plugin.sns.storage.y localy = hgj().QuV;
    AppMethodBeat.o(95813);
    return localy;
  }
  
  public static com.tencent.mm.plugin.sns.ad.g.n hgv()
  {
    AppMethodBeat.i(95814);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuW == null) {
      hgj().QuW = new com.tencent.mm.plugin.sns.ad.g.n();
    }
    com.tencent.mm.plugin.sns.ad.g.n localn = hgj().QuW;
    AppMethodBeat.o(95814);
    return localn;
  }
  
  public static c hgw()
  {
    AppMethodBeat.i(95815);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuO == null) {
      hgj().QuO = new c();
    }
    c localc = hgj().QuO;
    AppMethodBeat.o(95815);
    return localc;
  }
  
  public static bf hgx()
  {
    AppMethodBeat.i(95816);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuP == null)
    {
      hgj().QuP = new bf();
      com.tencent.mm.plugin.sns.c.q.Qkg = hgj().QuP;
    }
    bf localbf = hgj().QuP;
    AppMethodBeat.o(95816);
    return localbf;
  }
  
  public static g hgy()
  {
    AppMethodBeat.i(95817);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().QuE == null)
    {
      hgj().QuE = new g();
      com.tencent.mm.plugin.sns.c.q.Qkh = hgj().QuE;
    }
    g localg = hgj().QuE;
    AppMethodBeat.o(95817);
    return localg;
  }
  
  public static ba hgz()
  {
    AppMethodBeat.i(95818);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (hgj().Qvh == null) {
      hgj().Qvh = new ba();
    }
    ba localba = hgj().Qvh;
    AppMethodBeat.o(95818);
    return localba;
  }
  
  public static boolean isInValid()
  {
    AppMethodBeat.i(95797);
    hgj();
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      AppMethodBeat.o(95797);
      return true;
    }
    AppMethodBeat.o(95797);
    return false;
  }
  
  public static void m(Point paramPoint)
  {
    nGU = paramPoint;
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
    Log.i("MicroMsg.SnsCore", "onAccountPostReset " + Thread.currentThread().getId() + " isAccInit: " + this.Qvb);
    if (this.Qvb)
    {
      AppMethodBeat.o(95834);
      return;
    }
    this.Qvb = true;
    this.Arp = true;
    checkDir();
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("NewYearSNSCtrl2016", this.Qvi, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("NewYearSNSTips2016", this.Qvj, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("NewYearSNSAmountLevelCtrl2016", this.Qvk, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("SnsAd", this.Qvl, true);
    com.tencent.mm.plugin.sns.c.q.Qkg = hgx();
    com.tencent.mm.plugin.sns.c.q.Qkh = hgy();
    com.tencent.mm.plugin.sns.c.q.Qki = hgF();
    com.tencent.mm.plugin.sns.c.q.Qkk = hgH();
    com.tencent.mm.plugin.sns.c.q.Qkl = hgI();
    com.tencent.mm.plugin.sns.c.q.Qkn = hgr();
    com.tencent.mm.plugin.sns.c.q.Qkm = this;
    com.tencent.mm.plugin.sns.c.q.Qko = hgB();
    com.tencent.mm.plugin.sns.c.q.Qkp = hgG();
    this.QvR.alive();
    this.QvS.alive();
    this.QvE.alive();
    this.QvC.alive();
    this.QvD.alive();
    this.QvF.alive();
    this.QvG.alive();
    this.QvH.alive();
    this.QvI.alive();
    this.QvJ.alive();
    this.QvL.alive();
    this.QvM.alive();
    this.QvN.alive();
    this.QvV.alive();
    this.QvW.alive();
    appForegroundListener.alive();
    this.Qvp = new SnsfillEventInfoListener();
    this.Qvq = new RemoveSnsTaskEventListener();
    this.Qvr = new GetSnsTagListListener();
    this.Qvs = new UpdateSnsTagListListener();
    this.Qvt = new PostSnsTagMemberOptionListener();
    this.Qvu = new PostSnsAsyncTaskListener();
    this.Qvv = new SnsSyncListener();
    this.Qvw = new RecentlySnsMediaObjListener();
    this.Qvx = new ExtGetSnsDataEventListener();
    this.Qvy = new ExtStartSnsServerAndCallbackOnFpSetSizeEventListener();
    this.Qvz = new GetSnsTimeLineObjectListener();
    this.QvQ.alive();
    this.QvP.alive();
    this.Qvs.alive();
    this.Qvp.alive();
    this.Qvq.alive();
    this.Qvr.alive();
    this.Qvt.alive();
    this.Qvu.alive();
    this.Qvv.alive();
    this.Qvw.alive();
    this.Qvx.alive();
    this.Qvy.alive();
    this.Qvz.alive();
    this.LIy.alive();
    this.Qvf = new GetSnsObjectDetailListener();
    this.Qvf.alive();
    this.QvU.alive();
    this.QvA.alive();
    this.QvB.alive();
    this.QvO.alive();
    this.QvK.alive();
    this.QvY.alive();
    Object localObject1 = hgv();
    com.tencent.mm.plugin.sns.ad.g.n.PWA = com.tencent.mm.k.i.aRC().getInt("MMUxAdLog2GSendSize", 20480);
    com.tencent.mm.plugin.sns.ad.g.n.PWB = com.tencent.mm.k.i.aRC().getInt("MMUxAdLog3GSendSize", 30720);
    com.tencent.mm.plugin.sns.ad.g.n.PWC = com.tencent.mm.k.i.aRC().getInt("MMUxAdLogWifiSendSize", 51200);
    com.tencent.mm.plugin.sns.ad.g.n.PWD = com.tencent.mm.k.i.aRC().getInt("MMUxAdLogMinRandTime", 60);
    com.tencent.mm.plugin.sns.ad.g.n.PWE = com.tencent.mm.k.i.aRC().getInt("MMUxAdLogMaxRandTime", 1800);
    com.tencent.mm.plugin.sns.ad.g.n.PWF = com.tencent.mm.k.i.aRC().getInt("MMUxAdLogMaxExceptionTime", 43200);
    Log.i("MicroMsg.SnsLogMgr", "init " + com.tencent.mm.plugin.sns.ad.g.n.PWA + ";" + com.tencent.mm.plugin.sns.ad.g.n.PWB + ";" + com.tencent.mm.plugin.sns.ad.g.n.PWC + ";" + com.tencent.mm.plugin.sns.ad.g.n.PWD + ";" + com.tencent.mm.plugin.sns.ad.g.n.PWE + ";" + com.tencent.mm.plugin.sns.ad.g.n.PWF);
    if (com.tencent.mm.plugin.sns.ad.g.n.PWE - com.tencent.mm.plugin.sns.ad.g.n.PWD < 0) {
      com.tencent.mm.plugin.sns.ad.g.n.PWE = com.tencent.mm.plugin.sns.ad.g.n.PWD;
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1802, (com.tencent.mm.am.h)localObject1);
    localObject1 = hgx();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(207, (com.tencent.mm.am.h)localObject1);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(209, (com.tencent.mm.am.h)localObject1);
    localObject1 = this.QuX;
    ((at)localObject1).QwW.alive();
    ((at)localObject1).QwX.alive();
    ((at)localObject1).QwY.alive();
    this.Qvg = new com.tencent.mm.plugin.sns.fts.a();
    av.init();
    localObject1 = com.tencent.mm.modelsns.m.oUt;
    com.tencent.mm.modelsns.m.bMI();
    aj.hfX();
    if (com.tencent.mm.memory.k.bvP())
    {
      localObject1 = com.tencent.mm.memory.c.nNk;
      localObject2 = com.tencent.mm.memory.c.nNk;
      Objects.requireNonNull(localObject2);
      ((com.tencent.mm.memory.c)localObject1).a(new BucketPool.a((com.tencent.mm.memory.c)localObject2)
      {
        final int Qwa;
        
        public final long bvK()
        {
          return 10485760L;
        }
        
        public final int bvL()
        {
          return -1;
        }
      });
    }
    localObject1 = com.tencent.mm.memory.n.nNG;
    Object localObject2 = com.tencent.mm.memory.n.nNG;
    Objects.requireNonNull(localObject2);
    ((com.tencent.mm.memory.n)localObject1).a(new BucketPool.a((com.tencent.mm.memory.n)localObject2)
    {
      public final long bvK()
      {
        return -1L;
      }
      
      public final int bvL()
      {
        return 3;
      }
    });
    localObject1 = com.tencent.mm.memory.f.nNs;
    localObject2 = com.tencent.mm.memory.f.nNs;
    Objects.requireNonNull(localObject2);
    ((com.tencent.mm.memory.f)localObject1).a(new BucketPool.a((com.tencent.mm.memory.f)localObject2)
    {
      public final long bvK()
      {
        return 0L;
      }
      
      public final int bvL()
      {
        return 5;
      }
    });
    hgz();
    com.tencent.mm.plugin.sns.easteregg.a.init();
    try
    {
      localObject1 = MultiProcessMMKV.getMMKV("TrackDataSource");
      if (!Util.isNullOrNil(((MultiProcessMMKV)localObject1).getString("path", "")))
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(150, 74);
        com.tencent.mm.plugin.report.service.h.OAn.b(17832, new Object[] { Integer.valueOf(((MultiProcessMMKV)localObject1).getInt("type", 0)), ((MultiProcessMMKV)localObject1).getString("path", ""), Long.valueOf(((MultiProcessMMKV)localObject1).getLong("ts", 0L)), ((MultiProcessMMKV)localObject1).getString("media-url", ""), ((MultiProcessMMKV)localObject1).getString("thumb-url", ""), Long.valueOf(((MultiProcessMMKV)localObject1).getLong("prepare-ts", 0L)), ((MultiProcessMMKV)localObject1).getString("prepare-path", "") });
        ((MultiProcessMMKV)localObject1).putInt("type", 0);
        ((MultiProcessMMKV)localObject1).putString("path", "");
        ((MultiProcessMMKV)localObject1).putLong("ts", 0L);
        ((MultiProcessMMKV)localObject1).putString("media-url", "");
        ((MultiProcessMMKV)localObject1).putString("thumb-url", "");
        ((MultiProcessMMKV)localObject1).putLong("prepare-ts", 0L);
        ((MultiProcessMMKV)localObject1).commit();
      }
      hgj().handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(309547);
          al.hgx().a(al.a(al.this));
          AppMethodBeat.o(309547);
        }
      });
      AppMethodBeat.o(95834);
      return;
    }
    finally
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
    //   0: ldc_w 1839
    //   3: invokestatic 221	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 1645	com/tencent/mm/plugin/sns/model/al:hgv	()Lcom/tencent/mm/plugin/sns/ad/g/n;
    //   9: astore_1
    //   10: invokestatic 743	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   13: pop
    //   14: invokestatic 1688	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   17: getfield 1694	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   20: sipush 1802
    //   23: aload_1
    //   24: invokevirtual 1841	com/tencent/mm/am/s:b	(ILcom/tencent/mm/am/h;)V
    //   27: aload_0
    //   28: getfield 344	com/tencent/mm/plugin/sns/model/al:QuX	Lcom/tencent/mm/plugin/sns/model/at;
    //   31: astore_1
    //   32: aload_1
    //   33: getfield 1702	com/tencent/mm/plugin/sns/model/at:QwW	Lcom/tencent/mm/sdk/event/IListener;
    //   36: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   39: aload_1
    //   40: getfield 1705	com/tencent/mm/plugin/sns/model/at:QwX	Lcom/tencent/mm/sdk/event/IListener;
    //   43: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   46: aload_1
    //   47: getfield 1708	com/tencent/mm/plugin/sns/model/at:QwY	Lcom/tencent/mm/sdk/event/IListener;
    //   50: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   53: aload_0
    //   54: getfield 463	com/tencent/mm/plugin/sns/model/al:QvR	Lcom/tencent/mm/sdk/event/IListener;
    //   57: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   60: aload_0
    //   61: getfield 468	com/tencent/mm/plugin/sns/model/al:QvS	Lcom/tencent/mm/sdk/event/IListener;
    //   64: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   67: aload_0
    //   68: getfield 458	com/tencent/mm/plugin/sns/model/al:QvQ	Lcom/tencent/mm/sdk/event/IListener;
    //   71: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   74: aload_0
    //   75: getfield 453	com/tencent/mm/plugin/sns/model/al:QvP	Lcom/tencent/mm/sdk/event/IListener;
    //   78: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   81: aload_0
    //   82: getfield 410	com/tencent/mm/plugin/sns/model/al:QvE	Lcom/tencent/mm/sdk/event/IListener;
    //   85: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   88: aload_0
    //   89: getfield 402	com/tencent/mm/plugin/sns/model/al:QvC	Lcom/tencent/mm/sdk/event/IListener;
    //   92: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   95: aload_0
    //   96: getfield 407	com/tencent/mm/plugin/sns/model/al:QvD	Lcom/tencent/mm/sdk/event/IListener;
    //   99: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   102: aload_0
    //   103: getfield 413	com/tencent/mm/plugin/sns/model/al:QvF	Lcom/tencent/mm/sdk/event/IListener;
    //   106: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   109: aload_0
    //   110: getfield 418	com/tencent/mm/plugin/sns/model/al:QvG	Lcom/tencent/mm/sdk/event/IListener;
    //   113: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   116: aload_0
    //   117: getfield 423	com/tencent/mm/plugin/sns/model/al:QvH	Lcom/tencent/mm/sdk/event/IListener;
    //   120: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   123: aload_0
    //   124: getfield 1591	com/tencent/mm/plugin/sns/model/al:Qvs	Lcom/tencent/mm/plugin/sns/UpdateSnsTagListListener;
    //   127: invokevirtual 1845	com/tencent/mm/plugin/sns/UpdateSnsTagListListener:dead	()V
    //   130: aload_0
    //   131: getfield 1596	com/tencent/mm/plugin/sns/model/al:Qvt	Lcom/tencent/mm/plugin/sns/PostSnsTagMemberOptionListener;
    //   134: invokevirtual 1846	com/tencent/mm/plugin/sns/PostSnsTagMemberOptionListener:dead	()V
    //   137: aload_0
    //   138: getfield 431	com/tencent/mm/plugin/sns/model/al:QvJ	Lcom/tencent/mm/sdk/event/IListener;
    //   141: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   144: aload_0
    //   145: getfield 439	com/tencent/mm/plugin/sns/model/al:QvL	Lcom/tencent/mm/sdk/event/IListener;
    //   148: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   151: getstatic 320	com/tencent/mm/plugin/sns/model/al:appForegroundListener	Lcom/tencent/mm/app/q$a;
    //   154: invokevirtual 1847	com/tencent/mm/app/q$a:dead	()V
    //   157: aload_0
    //   158: getfield 1576	com/tencent/mm/plugin/sns/model/al:Qvp	Lcom/tencent/mm/plugin/sns/SnsfillEventInfoListener;
    //   161: invokevirtual 1848	com/tencent/mm/plugin/sns/SnsfillEventInfoListener:dead	()V
    //   164: aload_0
    //   165: getfield 1581	com/tencent/mm/plugin/sns/model/al:Qvq	Lcom/tencent/mm/plugin/sns/RemoveSnsTaskEventListener;
    //   168: invokevirtual 1849	com/tencent/mm/plugin/sns/RemoveSnsTaskEventListener:dead	()V
    //   171: aload_0
    //   172: getfield 1586	com/tencent/mm/plugin/sns/model/al:Qvr	Lcom/tencent/mm/plugin/sns/GetSnsTagListListener;
    //   175: invokevirtual 1850	com/tencent/mm/plugin/sns/GetSnsTagListListener:dead	()V
    //   178: aload_0
    //   179: getfield 1601	com/tencent/mm/plugin/sns/model/al:Qvu	Lcom/tencent/mm/plugin/sns/PostSnsAsyncTaskListener;
    //   182: invokevirtual 1851	com/tencent/mm/plugin/sns/PostSnsAsyncTaskListener:dead	()V
    //   185: aload_0
    //   186: getfield 1606	com/tencent/mm/plugin/sns/model/al:Qvv	Lcom/tencent/mm/plugin/sns/SnsSyncListener;
    //   189: invokevirtual 1852	com/tencent/mm/plugin/sns/SnsSyncListener:dead	()V
    //   192: aload_0
    //   193: getfield 1611	com/tencent/mm/plugin/sns/model/al:Qvw	Lcom/tencent/mm/plugin/sns/RecentlySnsMediaObjListener;
    //   196: invokevirtual 1853	com/tencent/mm/plugin/sns/RecentlySnsMediaObjListener:dead	()V
    //   199: aload_0
    //   200: getfield 1616	com/tencent/mm/plugin/sns/model/al:Qvx	Lcom/tencent/mm/plugin/sns/ExtGetSnsDataEventListener;
    //   203: invokevirtual 1854	com/tencent/mm/plugin/sns/ExtGetSnsDataEventListener:dead	()V
    //   206: aload_0
    //   207: getfield 1621	com/tencent/mm/plugin/sns/model/al:Qvy	Lcom/tencent/mm/plugin/sns/ExtStartSnsServerAndCallbackOnFpSetSizeEventListener;
    //   210: invokevirtual 1855	com/tencent/mm/plugin/sns/ExtStartSnsServerAndCallbackOnFpSetSizeEventListener:dead	()V
    //   213: aload_0
    //   214: getfield 1626	com/tencent/mm/plugin/sns/model/al:Qvz	Lcom/tencent/mm/plugin/sns/GetSnsTimeLineObjectListener;
    //   217: invokevirtual 1856	com/tencent/mm/plugin/sns/GetSnsTimeLineObjectListener:dead	()V
    //   220: aload_0
    //   221: getfield 428	com/tencent/mm/plugin/sns/model/al:QvI	Lcom/tencent/mm/sdk/event/IListener;
    //   224: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   227: aload_0
    //   228: getfield 1642	com/tencent/mm/plugin/sns/model/al:Qvf	Lcom/tencent/mm/plugin/sns/GetSnsObjectDetailListener;
    //   231: invokevirtual 1857	com/tencent/mm/plugin/sns/GetSnsObjectDetailListener:dead	()V
    //   234: aload_0
    //   235: getfield 444	com/tencent/mm/plugin/sns/model/al:QvM	Lcom/tencent/mm/sdk/event/IListener;
    //   238: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   241: aload_0
    //   242: getfield 447	com/tencent/mm/plugin/sns/model/al:QvN	Lcom/tencent/mm/sdk/event/IListener;
    //   245: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   248: aload_0
    //   249: getfield 473	com/tencent/mm/plugin/sns/model/al:LIy	Lcom/tencent/mm/sdk/event/IListener;
    //   252: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   255: aload_0
    //   256: getfield 478	com/tencent/mm/plugin/sns/model/al:QvU	Lcom/tencent/mm/sdk/event/IListener;
    //   259: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   262: aload_0
    //   263: getfield 450	com/tencent/mm/plugin/sns/model/al:QvO	Lcom/tencent/mm/sdk/event/IListener;
    //   266: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   269: aload_0
    //   270: getfield 392	com/tencent/mm/plugin/sns/model/al:QvA	Lcom/tencent/mm/sdk/event/IListener;
    //   273: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   276: aload_0
    //   277: getfield 397	com/tencent/mm/plugin/sns/model/al:QvB	Lcom/tencent/mm/sdk/event/IListener;
    //   280: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   283: aload_0
    //   284: getfield 483	com/tencent/mm/plugin/sns/model/al:QvV	Lcom/tencent/mm/sdk/event/IListener;
    //   287: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   290: aload_0
    //   291: getfield 434	com/tencent/mm/plugin/sns/model/al:QvK	Lcom/tencent/mm/sdk/event/IListener;
    //   294: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   297: aload_0
    //   298: getfield 486	com/tencent/mm/plugin/sns/model/al:QvW	Lcom/tencent/mm/sdk/event/IListener;
    //   301: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   304: aload_0
    //   305: getfield 498	com/tencent/mm/plugin/sns/model/al:QvY	Lcom/tencent/mm/sdk/event/IListener;
    //   308: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   311: getstatic 1863	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a$f:QIF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a;
    //   314: astore_1
    //   315: aload_1
    //   316: getfield 1868	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:QIy	Z
    //   319: ifeq +27 -> 346
    //   322: ldc_w 1870
    //   325: ldc_w 1872
    //   328: invokestatic 1874	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: invokestatic 242	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   334: aload_1
    //   335: getfield 1878	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:QIx	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a$a;
    //   338: invokevirtual 1882	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   341: aload_1
    //   342: iconst_0
    //   343: putfield 1868	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:QIy	Z
    //   346: invokestatic 1888	com/tencent/mm/plugin/downloader/model/f:duv	()Lcom/tencent/mm/plugin/downloader/model/f;
    //   349: pop
    //   350: aload_1
    //   351: getfield 1892	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:QIC	Lcom/tencent/mm/plugin/downloader/model/m;
    //   354: invokestatic 1897	com/tencent/mm/plugin/downloader/model/c:b	(Lcom/tencent/mm/plugin/downloader/model/m;)V
    //   357: ldc_w 1527
    //   360: invokestatic 662	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   363: checkcast 1527	com/tencent/mm/plugin/messenger/foundation/a/v
    //   366: invokeinterface 1531 1 0
    //   371: ldc_w 1533
    //   374: aload_0
    //   375: getfield 364	com/tencent/mm/plugin/sns/model/al:Qvi	Lcom/tencent/mm/plugin/sns/lucky/a/f;
    //   378: iconst_1
    //   379: invokevirtual 1899	com/tencent/mm/model/cl:b	(Ljava/lang/String;Lcom/tencent/mm/model/cl$a;Z)V
    //   382: ldc_w 1527
    //   385: invokestatic 662	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   388: checkcast 1527	com/tencent/mm/plugin/messenger/foundation/a/v
    //   391: invokeinterface 1531 1 0
    //   396: ldc_w 1540
    //   399: aload_0
    //   400: getfield 369	com/tencent/mm/plugin/sns/model/al:Qvj	Lcom/tencent/mm/plugin/sns/lucky/a/j;
    //   403: iconst_1
    //   404: invokevirtual 1899	com/tencent/mm/model/cl:b	(Ljava/lang/String;Lcom/tencent/mm/model/cl$a;Z)V
    //   407: ldc_w 1527
    //   410: invokestatic 662	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   413: checkcast 1527	com/tencent/mm/plugin/messenger/foundation/a/v
    //   416: invokeinterface 1531 1 0
    //   421: ldc_w 1542
    //   424: aload_0
    //   425: getfield 374	com/tencent/mm/plugin/sns/model/al:Qvk	Lcom/tencent/mm/plugin/sns/lucky/a/d;
    //   428: iconst_1
    //   429: invokevirtual 1899	com/tencent/mm/model/cl:b	(Ljava/lang/String;Lcom/tencent/mm/model/cl$a;Z)V
    //   432: ldc_w 1527
    //   435: invokestatic 662	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   438: checkcast 1527	com/tencent/mm/plugin/messenger/foundation/a/v
    //   441: invokeinterface 1531 1 0
    //   446: ldc_w 1544
    //   449: aload_0
    //   450: getfield 379	com/tencent/mm/plugin/sns/model/al:Qvl	Lcom/tencent/mm/plugin/sns/lucky/a/l;
    //   453: iconst_1
    //   454: invokevirtual 1899	com/tencent/mm/model/cl:b	(Ljava/lang/String;Lcom/tencent/mm/model/cl$a;Z)V
    //   457: invokestatic 572	com/tencent/mm/plugin/sns/model/al:hgj	()Lcom/tencent/mm/plugin/sns/model/al;
    //   460: getfield 339	com/tencent/mm/plugin/sns/model/al:handler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   463: new 58	com/tencent/mm/plugin/sns/model/al$7
    //   466: dup
    //   467: aload_0
    //   468: invokespecial 1900	com/tencent/mm/plugin/sns/model/al$7:<init>	(Lcom/tencent/mm/plugin/sns/model/al;)V
    //   471: invokevirtual 1829	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   474: pop
    //   475: invokestatic 1546	com/tencent/mm/plugin/sns/model/al:hgx	()Lcom/tencent/mm/plugin/sns/model/bf;
    //   478: astore_1
    //   479: invokestatic 743	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   482: pop
    //   483: invokestatic 1688	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   486: getfield 1694	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   489: sipush 207
    //   492: aload_1
    //   493: invokevirtual 1841	com/tencent/mm/am/s:b	(ILcom/tencent/mm/am/h;)V
    //   496: invokestatic 743	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   499: pop
    //   500: invokestatic 1688	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   503: getfield 1694	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   506: sipush 209
    //   509: aload_1
    //   510: invokevirtual 1841	com/tencent/mm/am/s:b	(ILcom/tencent/mm/am/h;)V
    //   513: ldc 2
    //   515: invokestatic 1119	com/tencent/mm/model/y:aL	(Ljava/lang/Class;)Lcom/tencent/mm/model/be;
    //   518: checkcast 2	com/tencent/mm/plugin/sns/model/al
    //   521: astore_1
    //   522: aload_1
    //   523: ifnull +99 -> 622
    //   526: ldc_w 500
    //   529: ldc_w 1902
    //   532: invokestatic 1904	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   535: aload_1
    //   536: getfield 780	com/tencent/mm/plugin/sns/model/al:Quw	Lcom/tencent/mm/plugin/sns/storage/ab;
    //   539: ifnull +15 -> 554
    //   542: aload_1
    //   543: getfield 780	com/tencent/mm/plugin/sns/model/al:Quw	Lcom/tencent/mm/plugin/sns/storage/ab;
    //   546: invokevirtual 1905	com/tencent/mm/plugin/sns/storage/ab:closeDB	()V
    //   549: aload_1
    //   550: aconst_null
    //   551: putfield 780	com/tencent/mm/plugin/sns/model/al:Quw	Lcom/tencent/mm/plugin/sns/storage/ab;
    //   554: aload_1
    //   555: getfield 532	com/tencent/mm/plugin/sns/model/al:Quu	Ljava/util/concurrent/ExecutorService;
    //   558: ifnull +13 -> 571
    //   561: aload_1
    //   562: getfield 532	com/tencent/mm/plugin/sns/model/al:Quu	Ljava/util/concurrent/ExecutorService;
    //   565: invokeinterface 1909 1 0
    //   570: pop
    //   571: aload_1
    //   572: getfield 551	com/tencent/mm/plugin/sns/model/al:OOq	Ljava/util/concurrent/ExecutorService;
    //   575: ifnull +13 -> 588
    //   578: aload_1
    //   579: getfield 551	com/tencent/mm/plugin/sns/model/al:OOq	Ljava/util/concurrent/ExecutorService;
    //   582: invokeinterface 1909 1 0
    //   587: pop
    //   588: aload_1
    //   589: getfield 555	com/tencent/mm/plugin/sns/model/al:Qut	Ljava/util/concurrent/ExecutorService;
    //   592: ifnull +13 -> 605
    //   595: aload_1
    //   596: getfield 555	com/tencent/mm/plugin/sns/model/al:Qut	Ljava/util/concurrent/ExecutorService;
    //   599: invokeinterface 1909 1 0
    //   604: pop
    //   605: aload_1
    //   606: getfield 563	com/tencent/mm/plugin/sns/model/al:Quv	Ljava/util/concurrent/ExecutorService;
    //   609: ifnull +13 -> 622
    //   612: aload_1
    //   613: getfield 563	com/tencent/mm/plugin/sns/model/al:Quv	Ljava/util/concurrent/ExecutorService;
    //   616: invokeinterface 1909 1 0
    //   621: pop
    //   622: aload_0
    //   623: getfield 1713	com/tencent/mm/plugin/sns/model/al:Qvg	Lcom/tencent/mm/plugin/sns/fts/a;
    //   626: astore_1
    //   627: invokestatic 1911	com/tencent/mm/plugin/sns/model/al:hgw	()Lcom/tencent/mm/plugin/sns/model/c;
    //   630: aload_1
    //   631: invokevirtual 1914	com/tencent/mm/plugin/sns/model/c:b	(Lcom/tencent/mm/plugin/sns/model/c$b;)V
    //   634: aload_1
    //   635: getfield 1917	com/tencent/mm/plugin/sns/fts/a:QoU	Lcom/tencent/mm/sdk/event/IListener;
    //   638: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   641: invokestatic 1920	com/tencent/mm/plugin/sns/model/av:unInit	()V
    //   644: getstatic 1771	com/tencent/mm/memory/f:nNs	Lcom/tencent/mm/memory/f;
    //   647: invokevirtual 1923	com/tencent/mm/memory/f:bvG	()V
    //   650: getstatic 1743	com/tencent/mm/memory/c:nNk	Lcom/tencent/mm/memory/c;
    //   653: invokevirtual 1924	com/tencent/mm/memory/c:bvG	()V
    //   656: getstatic 1761	com/tencent/mm/memory/n:nNG	Lcom/tencent/mm/memory/n;
    //   659: invokevirtual 1925	com/tencent/mm/memory/n:bvG	()V
    //   662: invokestatic 1777	com/tencent/mm/plugin/sns/model/al:hgz	()Lcom/tencent/mm/plugin/sns/model/ba;
    //   665: astore_1
    //   666: aload_1
    //   667: aconst_null
    //   668: putfield 1929	com/tencent/mm/plugin/sns/model/ba:QyD	Lcom/tencent/mm/plugin/sns/model/bh;
    //   671: aload_1
    //   672: getfield 1933	com/tencent/mm/plugin/sns/model/ba:QyH	Ljava/util/LinkedList;
    //   675: astore_2
    //   676: aload_2
    //   677: monitorenter
    //   678: aload_1
    //   679: getfield 1933	com/tencent/mm/plugin/sns/model/ba:QyH	Ljava/util/LinkedList;
    //   682: invokevirtual 1938	java/util/LinkedList:clear	()V
    //   685: aload_2
    //   686: monitorexit
    //   687: aload_1
    //   688: getfield 1942	com/tencent/mm/plugin/sns/model/ba:QyF	Ljava/util/Map;
    //   691: invokeinterface 1945 1 0
    //   696: aload_1
    //   697: getfield 1948	com/tencent/mm/plugin/sns/model/ba:QyE	Ljava/util/LinkedList;
    //   700: invokevirtual 1938	java/util/LinkedList:clear	()V
    //   703: aload_1
    //   704: getfield 1951	com/tencent/mm/plugin/sns/model/ba:QyG	Ljava/util/LinkedList;
    //   707: astore_2
    //   708: aload_2
    //   709: monitorenter
    //   710: aload_1
    //   711: getfield 1951	com/tencent/mm/plugin/sns/model/ba:QyG	Ljava/util/LinkedList;
    //   714: invokevirtual 1938	java/util/LinkedList:clear	()V
    //   717: aload_2
    //   718: monitorexit
    //   719: aload_1
    //   720: getfield 1954	com/tencent/mm/plugin/sns/model/ba:QyK	Lcom/tencent/mm/sdk/event/IListener;
    //   723: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   726: aload_1
    //   727: getfield 1957	com/tencent/mm/plugin/sns/model/ba:QyL	Lcom/tencent/mm/sdk/event/IListener;
    //   730: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   733: aload_1
    //   734: getfield 1958	com/tencent/mm/plugin/sns/model/ba:QwY	Lcom/tencent/mm/sdk/event/IListener;
    //   737: invokevirtual 1844	com/tencent/mm/sdk/event/IListener:dead	()V
    //   740: invokestatic 1961	com/tencent/mm/plugin/sns/easteregg/a:destroy	()V
    //   743: invokestatic 1966	com/tencent/mm/plugin/sns/h/a:stop	()V
    //   746: ldc_w 1839
    //   749: invokestatic 323	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   752: return
    //   753: astore_2
    //   754: ldc_w 1870
    //   757: ldc_w 1968
    //   760: iconst_1
    //   761: anewarray 4	java/lang/Object
    //   764: dup
    //   765: iconst_0
    //   766: aload_2
    //   767: invokevirtual 1971	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   770: aastore
    //   771: invokestatic 1973	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   774: goto -428 -> 346
    //   777: astore_1
    //   778: aload_2
    //   779: monitorexit
    //   780: ldc_w 1839
    //   783: invokestatic 323	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   786: aload_1
    //   787: athrow
    //   788: astore_1
    //   789: aload_2
    //   790: monitorexit
    //   791: ldc_w 1839
    //   794: invokestatic 323	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   797: aload_1
    //   798: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	799	0	this	al
    //   9	725	1	localObject1	Object
    //   777	10	1	localObject2	Object
    //   788	10	1	localObject3	Object
    //   753	37	2	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   322	346	753	java/lang/IllegalArgumentException
    //   678	687	777	finally
    //   710	719	788	finally
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(95836);
    checkDir();
    AppMethodBeat.o(95836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.al
 * JD-Core Version:    0.7.0.1
 */