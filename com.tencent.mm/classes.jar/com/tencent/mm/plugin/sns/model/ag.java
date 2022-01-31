package com.tencent.mm.plugin.sns.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteException;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.os;
import com.tencent.mm.g.a.os.a;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.i;
import com.tencent.mm.plugin.sns.n;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public final class ag
  implements at, com.tencent.mm.plugin.sns.b.j
{
  private static j.a appForegroundListener;
  private static String rgQ;
  protected static HashMap<Integer, h.d> rgR;
  private static ak rgZ;
  public static boolean rgi;
  private static int rgj;
  private static int rgk;
  private static int rgp;
  private static int rgq;
  private static int rha;
  private static int rhb;
  private static Point rhc;
  private com.tencent.mm.cg.h eHS;
  private byte[] eKs;
  private ak handler;
  private com.tencent.mm.sdk.b.c oZH;
  private ae rgA;
  private an.a rgB;
  private b rgC;
  private ax rgD;
  private com.tencent.mm.plugin.sns.ui.ai rgE;
  private com.tencent.mm.plugin.sns.g.c rgF;
  private com.tencent.mm.plugin.sns.g.g rgG;
  private com.tencent.mm.plugin.sns.storage.q rgH;
  private i rgI;
  private ap rgJ;
  private boolean rgK;
  private boolean rgL;
  private w rgM;
  private boolean rgN;
  private byte[] rgO;
  private String rgP;
  private com.tencent.mm.plugin.sns.d rgS;
  private com.tencent.mm.plugin.sns.f.a rgT;
  private as rgU;
  private com.tencent.mm.plugin.sns.lucky.a.f rgV;
  private com.tencent.mm.plugin.sns.lucky.a.j rgW;
  private com.tencent.mm.plugin.sns.lucky.a.d rgX;
  private com.tencent.mm.plugin.sns.lucky.a.l rgY;
  private com.tencent.mm.sdk.g.b.a rgl;
  private com.tencent.mm.sdk.g.b.a rgm;
  private com.tencent.mm.sdk.g.b.a rgn;
  private com.tencent.mm.sdk.g.b.a rgo;
  private s rgr;
  private com.tencent.mm.plugin.sns.storage.o rgs;
  private com.tencent.mm.plugin.sns.storage.f rgt;
  private com.tencent.mm.plugin.sns.storage.d rgu;
  private y rgv;
  private g rgw;
  private com.tencent.mm.plugin.sns.storage.m rgx;
  private com.tencent.mm.plugin.sns.storage.k rgy;
  private com.tencent.mm.plugin.sns.storage.u rgz;
  private com.tencent.mm.sdk.b.c rhA;
  private com.tencent.mm.sdk.b.c rhB;
  private com.tencent.mm.sdk.b.c rhC;
  private com.tencent.mm.sdk.b.c rhD;
  private com.tencent.mm.sdk.b.c rhE;
  private com.tencent.mm.sdk.b.c rhF;
  private com.tencent.mm.sdk.b.c rhG;
  private boolean rhH;
  private com.tencent.mm.sdk.b.c rhI;
  private com.tencent.mm.sdk.b.c rhJ;
  private n rhd;
  private com.tencent.mm.plugin.sns.k rhe;
  private com.tencent.mm.plugin.sns.e rhf;
  private com.tencent.mm.plugin.sns.p rhg;
  private com.tencent.mm.plugin.sns.h rhh;
  private com.tencent.mm.plugin.sns.g rhi;
  private com.tencent.mm.plugin.sns.m rhj;
  private com.tencent.mm.plugin.sns.j rhk;
  private com.tencent.mm.plugin.sns.b rhl;
  private com.tencent.mm.plugin.sns.c rhm;
  private com.tencent.mm.plugin.sns.f rhn;
  private com.tencent.mm.sdk.b.c rho;
  private com.tencent.mm.sdk.b.c rhp;
  private com.tencent.mm.sdk.b.c rhq;
  private com.tencent.mm.sdk.b.c rhr;
  private com.tencent.mm.sdk.b.c rhs;
  private com.tencent.mm.sdk.b.c rht;
  private com.tencent.mm.sdk.b.c rhu;
  private com.tencent.mm.sdk.b.c rhv;
  private com.tencent.mm.sdk.b.c rhw;
  private com.tencent.mm.sdk.b.c rhx;
  private com.tencent.mm.sdk.b.c rhy;
  private com.tencent.mm.sdk.b.c rhz;
  
  static
  {
    AppMethodBeat.i(36524);
    rgi = true;
    rgj = 0;
    rgk = 0;
    rgQ = "";
    rgR = new HashMap();
    rha = 103;
    rhb = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 130);
    rhc = new Point();
    rgR.put(Integer.valueOf("CanvasInfo".hashCode()), new ag.1());
    rgR.put(Integer.valueOf("UxCanvasInfo".hashCode()), new ag.12());
    rgR.put(Integer.valueOf("SNSMEDIA_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return s.SQL_CREATE;
      }
    });
    rgR.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new ag.32());
    rgR.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new ag.33());
    rgR.put(Integer.valueOf("ADSNSINFO_TABLE".hashCode()), new ag.34());
    rgR.put(Integer.valueOf("SNSEXT_TABLE".hashCode()), new ag.35());
    rgR.put(Integer.valueOf("SNSCOMMENT_TABLE".hashCode()), new ag.36());
    rgR.put(Integer.valueOf("SNSTAGINFO_TABLE".hashCode()), new ag.37());
    rgR.put(Integer.valueOf("SNSKVREPORT_TABLE".hashCode()), new ag.2());
    appForegroundListener = new ag.3();
    AppMethodBeat.o(36524);
  }
  
  public ag()
  {
    AppMethodBeat.i(36480);
    this.handler = new ak(Looper.getMainLooper());
    this.rgJ = new ap();
    this.rgK = false;
    this.rgL = true;
    this.eKs = new byte[0];
    this.rgM = new w();
    this.rgN = false;
    this.rgO = new byte[0];
    this.rgV = new com.tencent.mm.plugin.sns.lucky.a.f();
    this.rgW = new com.tencent.mm.plugin.sns.lucky.a.j();
    this.rgX = new com.tencent.mm.plugin.sns.lucky.a.d();
    this.rgY = new com.tencent.mm.plugin.sns.lucky.a.l();
    this.rho = new ag.7(this);
    this.rhp = new ag.8(this);
    this.rhq = new ag.9(this);
    this.rhr = new com.tencent.mm.sdk.b.c() {};
    this.rhs = new ag.11(this);
    this.rht = new ag.13(this);
    this.rhu = new ag.14(this);
    this.rhv = new ag.15(this);
    this.rhw = new ag.16(this);
    this.rhx = new ag.17(this);
    this.rhy = new ag.18(this);
    this.rhz = new ag.19(this);
    this.rhA = new ag.20(this);
    this.rhB = new com.tencent.mm.sdk.b.c() {};
    this.rhC = new com.tencent.mm.sdk.b.c() {};
    this.rhD = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(os paramAnonymousos)
      {
        AppMethodBeat.i(36457);
        SnsAdClick localSnsAdClick = paramAnonymousos.cFp.cFb;
        try
        {
          if (paramAnonymousos.cFp.cFq != 1) {
            break label259;
          }
          if (localSnsAdClick.fQv != 1) {
            break label365;
          }
          locale = ag.cpi().lQ(localSnsAdClick.cIo);
          if ((locale == null) || (!locale.cqx())) {
            break label266;
          }
          localObject2 = ag.coZ();
          j = 14647;
          localObject1 = new Object[7];
          localObject1[0] = Long.valueOf(localSnsAdClick.cIo);
          localObject1[1] = locale.csd().cFe;
          localObject1[2] = Integer.valueOf(localSnsAdClick.fQs);
          localObject1[3] = Long.valueOf(localSnsAdClick.startTime);
          localObject1[4] = Long.valueOf(System.currentTimeMillis());
          i = locale.csf();
          paramAnonymousos = (os)localObject1;
        }
        catch (Exception paramAnonymousos)
        {
          for (;;)
          {
            com.tencent.mm.plugin.sns.storage.e locale;
            int j;
            i locali;
            ab.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousos, "report ad click error", new Object[0]);
            continue;
            Object localObject1 = paramAnonymousos.cFp.cFe;
            paramAnonymousos = (os)localObject1;
            if (localObject1 == null) {
              paramAnonymousos = "";
            }
            ab.i("MicroMsg.SnsCore", "ReportSnsEvent, AdSnsInfo==null, uxInfo=".concat(String.valueOf(paramAnonymousos)));
            boolean bool = false;
            continue;
            ag.coZ().e(12013, new Object[] { localObject1 });
            continue;
            int i = -1;
            localObject1 = paramAnonymousos;
            Object localObject2 = paramAnonymousos;
            paramAnonymousos = (os)localObject1;
            localObject1 = localObject2;
            localObject2 = locali;
          }
        }
        paramAnonymousos[5] = Integer.valueOf(i);
        localObject1[6] = "";
        ((i)localObject2).e(j, (Object[])localObject1);
        paramAnonymousos = com.tencent.mm.modelsns.b.lW(750);
        paramAnonymousos.uv(localSnsAdClick.cIo).uv(locale.csd().cFe).lY(localSnsAdClick.fQs).uv(localSnsAdClick.startTime).uv(System.currentTimeMillis());
        paramAnonymousos.ake();
        for (;;)
        {
          label259:
          AppMethodBeat.o(36457);
          return false;
          label266:
          locali = ag.coZ();
          j = 13155;
          paramAnonymousos = new Object[7];
          paramAnonymousos[0] = Long.valueOf(localSnsAdClick.cIo);
          paramAnonymousos[1] = locale.csd().cFe;
          paramAnonymousos[2] = Integer.valueOf(localSnsAdClick.fQs);
          paramAnonymousos[3] = Long.valueOf(localSnsAdClick.startTime);
          paramAnonymousos[4] = Long.valueOf(System.currentTimeMillis());
          if (locale == null) {
            break label753;
          }
          i = locale.csf();
          localObject1 = paramAnonymousos;
          localObject2 = paramAnonymousos;
          paramAnonymousos = (os)localObject1;
          localObject1 = localObject2;
          localObject2 = locali;
          break;
          label365:
          localObject1 = ag.cpi().lQ(localSnsAdClick.cIo);
          if (localObject1 == null) {
            break label693;
          }
          paramAnonymousos = ((com.tencent.mm.plugin.sns.storage.e)localObject1).csd().cFe;
          bool = ((com.tencent.mm.plugin.sns.storage.e)localObject1).cqx();
          localObject1 = com.tencent.mm.plugin.sns.a.b.f.a(localSnsAdClick.cIo, new Object[] { localSnsAdClick, paramAnonymousos, Integer.valueOf(localSnsAdClick.fQs), Long.valueOf(localSnsAdClick.startTime), Long.valueOf(System.currentTimeMillis()) });
          localObject1 = (String)localObject1 + String.format(",%s", new Object[] { localSnsAdClick.fQw });
          localObject1 = (String)localObject1 + String.format(",%s", new Object[] { System.currentTimeMillis() - localSnsAdClick.startTime - localSnsAdClick.fQy });
          if (!bool) {
            break label732;
          }
          ag.coZ().e(14643, new Object[] { localObject1 });
          localObject1 = com.tencent.mm.modelsns.b.lW(733);
          ((com.tencent.mm.modelsns.b)localObject1).uv(localSnsAdClick.cIo).uv(paramAnonymousos).lY(localSnsAdClick.fQs).uv(localSnsAdClick.startTime).uv(System.currentTimeMillis());
          ((com.tencent.mm.modelsns.b)localObject1).ake();
        }
      }
    };
    this.rhE = new ag.25(this);
    this.rhF = new ag.26(this);
    this.rhG = new ag.27(this);
    this.rhH = false;
    this.oZH = new ag.29(this);
    this.rhI = new ag.30(this);
    this.rhJ = new ag.31(this);
    ab.i("MicroMsg.SnsCore", "snscore create! " + Thread.currentThread().getId());
    if (this.rgn == null) {
      this.rgn = com.tencent.mm.sdk.g.c.d.a("SnsCore_CDNDownload_handler", new LinkedBlockingQueue());
    }
    if (this.rgm == null) {
      this.rgm = com.tencent.mm.sdk.g.c.d.a("SnsCore_thumbDecode_handler", new LinkedBlockingQueue());
    }
    if (this.rgl == null) {
      this.rgl = com.tencent.mm.sdk.g.c.d.aqx("SnsCore#File");
    }
    if (this.rgo == null) {
      this.rgo = com.tencent.mm.sdk.g.c.d.aqx("SnsCore#Task");
    }
    if ((((ActivityManager)ah.getContext().getSystemService("activity")).getLargeMemoryClass() > 256) && (Build.VERSION.SDK_INT != 24)) {
      int i = Build.VERSION.SDK_INT;
    }
    AppMethodBeat.o(36480);
  }
  
  public static com.tencent.mm.cg.h Rq()
  {
    AppMethodBeat.i(36477);
    com.tencent.mm.cg.h localh = coM().eHS;
    AppMethodBeat.o(36477);
    return localh;
  }
  
  public static ak bEf()
  {
    AppMethodBeat.i(36486);
    ak localak = coM().handler;
    AppMethodBeat.o(36486);
    return localak;
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(36516);
    com.tencent.mm.vfs.e.um(((com.tencent.mm.plugin.sns.b.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath());
    com.tencent.mm.vfs.e.um(((com.tencent.mm.plugin.sns.b.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath());
    com.tencent.mm.vfs.e.avN(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.crV());
    AppMethodBeat.o(36516);
  }
  
  public static String coK()
  {
    AppMethodBeat.i(36475);
    com.tencent.mm.kernel.g.RM();
    String str = (String)com.tencent.mm.kernel.g.RL().Ru().get(2, null);
    AppMethodBeat.o(36475);
    return str;
  }
  
  public static int coL()
  {
    AppMethodBeat.i(36476);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ();
    int i = com.tencent.mm.kernel.a.getUin();
    AppMethodBeat.o(36476);
    return i;
  }
  
  private static ag coM()
  {
    AppMethodBeat.i(36478);
    Object localObject1 = (ag)com.tencent.mm.model.q.S(ag.class);
    if (!((ag)localObject1).rgN) {}
    com.tencent.mm.model.b localb;
    for (;;)
    {
      Object localObject5;
      Object localObject4;
      synchronized (((ag)localObject1).rgO)
      {
        if (!((ag)localObject1).rgN)
        {
          ab.i("MicroMsg.SnsCore", "onAccInit because bug!");
          ((ag)localObject1).onAccountPostReset(true);
        }
        if (!((ag)localObject1).rgK) {
          break label1583;
        }
        synchronized (((ag)localObject1).eKs)
        {
          ab.i("MicroMsg.SnsCore", "getCore need reset DB now " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + localObject1.hashCode());
          if (!((ag)localObject1).rgK) {
            break label1580;
          }
          ((ag)localObject1).rgL = false;
          localObject5 = ((ag)localObject1).rgM;
          localObject4 = rgR;
          if (((w)localObject5).rDI)
          {
            ab.i("MicroMsg.TrimSnsDb", "pass hasTrim");
            if (((ag)localObject1).eHS != null) {
              break;
            }
            ((ag)localObject1).eHS = new com.tencent.mm.cg.h();
            com.tencent.mm.kernel.g.RM();
            localObject4 = com.tencent.mm.kernel.g.RL().cachePath;
            localObject4 = (String)localObject4 + "SnsMicroMsg.db";
            if (((ag)localObject1).eHS.b((String)localObject4, rgR, true)) {
              break;
            }
            localObject1 = new SQLiteException("sns db init failed");
            AppMethodBeat.o(36478);
            throw ((Throwable)localObject1);
          }
        }
      }
      com.tencent.mm.kernel.g.RM();
      if (com.tencent.mm.kernel.g.RJ().QU())
      {
        int i = bo.getInt(com.tencent.mm.m.g.Nq().getValue("AndroidCleanSnsDb"), 0);
        ab.i("MicroMsg.TrimSnsDb", "pass dynamic? ".concat(String.valueOf(i)));
        if (i <= 0)
        {
          com.tencent.mm.kernel.g.RM();
          String str = com.tencent.mm.kernel.g.RL().cachePath;
          if (com.tencent.mm.vfs.e.cN(str + "SnsMicroMsg2.db.ini"))
          {
            w.abS(str);
            com.tencent.mm.vfs.e.deleteFile(str + "SnsMicroMsg2.db.ini");
          }
          Object localObject6 = ah.getContext().getSharedPreferences(ah.dsP(), 0);
          if (bo.gz(((SharedPreferences)localObject6).getLong("check_trim_time", 0L)) < 604800L)
          {
            ab.i("MicroMsg.TrimSnsDb", "trim sns pass because time short");
          }
          else
          {
            ((SharedPreferences)localObject6).edit().putLong("check_trim_time", bo.aox()).commit();
            ((w)localObject5).rDI = true;
            long l1 = System.currentTimeMillis();
            i = com.tencent.mm.q.a.Oj();
            if ((i == 1) || (i == 2))
            {
              ab.i("MicroMsg.TrimSnsDb", "trim sns error space dangerous");
            }
            else if (com.tencent.mm.vfs.e.cN(str + "sns_mark.ini"))
            {
              if (bo.hl(com.tencent.mm.vfs.e.avJ(str + "sns_mark.ini")) < 2592000000L)
              {
                ab.i("MicroMsg.TrimSnsDb", "mark file exist and return");
                w.abS(str);
              }
              else
              {
                com.tencent.mm.vfs.e.deleteFile(str + "sns_mark.ini");
              }
            }
            else
            {
              long l2 = com.tencent.mm.vfs.e.avI(str + "SnsMicroMsg.db");
              ab.i("MicroMsg.TrimSnsDb", "trim sns ".concat(String.valueOf(l2)));
              if (l2 < 52428800L)
              {
                ab.i("MicroMsg.TrimSnsDb", "trim sns free pass: " + (System.currentTimeMillis() - l1));
              }
              else
              {
                com.tencent.mm.vfs.e.avL(str + "sns_mark.ini");
                localObject6 = str + "SnsMicroMsg2.db";
                localObject5 = new com.tencent.mm.cg.h();
                if (!((com.tencent.mm.cg.h)localObject5).b((String)localObject6, null, false))
                {
                  localb = new com.tencent.mm.model.b((byte)0);
                  AppMethodBeat.o(36478);
                  throw localb;
                }
                localObject6 = new com.tencent.mm.cg.h();
                if (!((com.tencent.mm.cg.h)localObject6).b(str + "SnsMicroMsg.db", (HashMap)localObject4, true))
                {
                  localb = new com.tencent.mm.model.b((byte)0);
                  AppMethodBeat.o(36478);
                  throw localb;
                }
                l2 = System.currentTimeMillis();
                if (!w.a((com.tencent.mm.cg.h)localObject6, (com.tencent.mm.cg.h)localObject5)) {}
                for (i = -1;; i = 1)
                {
                  long l3 = System.currentTimeMillis() - l2;
                  ab.i("MicroMsg.TrimSnsDb", "copysns insert all %d passed ret:".concat(String.valueOf(i)), new Object[] { Long.valueOf(l3) });
                  ((com.tencent.mm.cg.h)localObject6).closeDB();
                  ((com.tencent.mm.cg.h)localObject5).closeDB();
                  if (i >= 0)
                  {
                    com.tencent.mm.kernel.g.RM();
                    localObject4 = com.tencent.mm.kernel.g.RL().cachePath;
                    com.tencent.mm.vfs.e.deleteFile((String)localObject4 + "SnsMicroMsg.db");
                    ab.i("MicroMsg.TrimSnsDb", "rename file ".concat(String.valueOf(com.tencent.mm.vfs.e.h((String)localObject4, "SnsMicroMsg2.db", "SnsMicroMsg.db"))));
                    com.tencent.mm.vfs.e.deleteFile((String)localObject4 + "SnsMicroMsg.db-shm");
                    com.tencent.mm.vfs.e.deleteFile((String)localObject4 + "SnsMicroMsg.db-wal");
                    com.tencent.mm.vfs.e.deleteFile((String)localObject4 + "SnsMicroMsg.db.ini");
                    com.tencent.mm.vfs.e.C("SnsMicroMsg2.db.ini", "SnsMicroMsg.db.ini");
                    com.tencent.mm.vfs.e.deleteFile((String)localObject4 + "SnsMicroMsg2.db.ini");
                    com.tencent.mm.vfs.e.deleteFile((String)localObject4 + "SnsMicroMsg2.db");
                    com.tencent.mm.vfs.e.deleteFile((String)localObject4 + "sns_mark.ini");
                  }
                  l2 = System.currentTimeMillis() - l2;
                  ab.i("MicroMsg.TrimSnsDb", "copysns data ret=%d all: %d copytime %d ", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l2 - l3) });
                  ab.i("MicroMsg.TrimSnsDb", "trim sns done pass: " + (System.currentTimeMillis() - l1));
                  break;
                  l3 = System.currentTimeMillis();
                  w.a((com.tencent.mm.cg.h)localObject6, (com.tencent.mm.cg.h)localObject5, "snsExtInfo3");
                  boolean bool = ((com.tencent.mm.cg.h)localObject5).execSQL("", "insert into " + "snsExtInfo3" + " select * from old." + "snsExtInfo3");
                  ab.i("MicroMsg.TrimSnsDb", "copysns ret_ext:" + bool + " passed " + (System.currentTimeMillis() - l3));
                  w.a((com.tencent.mm.cg.h)localObject6, (com.tencent.mm.cg.h)localObject5, "SnsComment");
                  bool = ((com.tencent.mm.cg.h)localObject5).execSQL("", "insert into " + "SnsComment" + " select * from old." + "SnsComment");
                  ab.i("MicroMsg.TrimSnsDb", "copysns ret_msg:" + bool + " passed " + (System.currentTimeMillis() - l3));
                  w.a((com.tencent.mm.cg.h)localObject6, (com.tencent.mm.cg.h)localObject5, "SnsInfo");
                  bool = ((com.tencent.mm.cg.h)localObject5).execSQL("", "insert into " + "SnsInfo" + " select * from old." + "SnsInfo" + " where  (sourceType & 2 != 0 ) " + com.tencent.mm.plugin.sns.storage.o.rDl + " limit 200");
                  ab.i("MicroMsg.TrimSnsDb", "copysns ret_sns:" + bool + " passed " + (System.currentTimeMillis() - l3));
                  bool = ((com.tencent.mm.cg.h)localObject5).execSQL("", "update snsExtinfo3 set md5 = '', faults = '';");
                  ab.i("MicroMsg.TrimSnsDb", "update ext info  passed  %s  updateRet %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l3), Boolean.valueOf(bool) });
                  ((com.tencent.mm.cg.h)localObject5).execSQL("", "DETACH DATABASE old");
                }
              }
            }
          }
        }
      }
    }
    localb.rgK = false;
    ab.i("MicroMsg.SnsCore", "resetdb done");
    label1580:
    label1583:
    AppMethodBeat.o(36478);
    return localb;
  }
  
  public static boolean coN()
  {
    AppMethodBeat.i(36479);
    coM();
    if (!com.tencent.mm.kernel.g.RJ().QU())
    {
      AppMethodBeat.o(36479);
      return true;
    }
    AppMethodBeat.o(36479);
    return false;
  }
  
  public static ak coO()
  {
    AppMethodBeat.i(36481);
    if (rgZ == null) {
      rgZ = new ak("MicroMsg.SnsCore#WorkingHandler");
    }
    ak localak = rgZ;
    AppMethodBeat.o(36481);
    return localak;
  }
  
  public static com.tencent.mm.sdk.g.b.a coP()
  {
    AppMethodBeat.i(36482);
    com.tencent.mm.sdk.g.b.a locala = coM().rgn;
    AppMethodBeat.o(36482);
    return locala;
  }
  
  public static com.tencent.mm.sdk.g.b.a coQ()
  {
    AppMethodBeat.i(36483);
    com.tencent.mm.sdk.g.b.a locala = coM().rgm;
    AppMethodBeat.o(36483);
    return locala;
  }
  
  protected static com.tencent.mm.sdk.g.b.a coR()
  {
    AppMethodBeat.i(36484);
    com.tencent.mm.sdk.g.b.a locala = coM().rgl;
    AppMethodBeat.o(36484);
    return locala;
  }
  
  public static com.tencent.mm.sdk.g.b.a coS()
  {
    AppMethodBeat.i(36485);
    com.tencent.mm.sdk.g.b.a locala = coM().rgo;
    AppMethodBeat.o(36485);
    return locala;
  }
  
  public static com.tencent.mm.storage.bd coT()
  {
    AppMethodBeat.i(36489);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.storage.bd localbd = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA();
    AppMethodBeat.o(36489);
    return localbd;
  }
  
  public static s coU()
  {
    AppMethodBeat.i(36490);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgr == null) {
      coM().rgr = new s(coM().eHS);
    }
    s locals = coM().rgr;
    AppMethodBeat.o(36490);
    return locals;
  }
  
  public static an.a coV()
  {
    AppMethodBeat.i(36491);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgB == null)
    {
      coM().rgB = new an.a();
      com.tencent.mm.plugin.sns.b.n.raV = coM().rgB;
    }
    an.a locala = coM().rgB;
    AppMethodBeat.o(36491);
    return locala;
  }
  
  public static com.tencent.mm.plugin.sns.g.c coW()
  {
    AppMethodBeat.i(36492);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgF == null) {
      coM().rgF = new com.tencent.mm.plugin.sns.g.c();
    }
    com.tencent.mm.plugin.sns.g.c localc = coM().rgF;
    AppMethodBeat.o(36492);
    return localc;
  }
  
  public static com.tencent.mm.plugin.sns.g.g coX()
  {
    AppMethodBeat.i(36493);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgG == null) {
      coM().rgG = new com.tencent.mm.plugin.sns.g.g();
    }
    com.tencent.mm.plugin.sns.g.g localg = coM().rgG;
    AppMethodBeat.o(36493);
    return localg;
  }
  
  public static com.tencent.mm.plugin.sns.storage.q coY()
  {
    AppMethodBeat.i(36494);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgH == null) {
      coM().rgH = new com.tencent.mm.plugin.sns.storage.q(coM().eHS);
    }
    com.tencent.mm.plugin.sns.storage.q localq = coM().rgH;
    AppMethodBeat.o(36494);
    return localq;
  }
  
  public static i coZ()
  {
    AppMethodBeat.i(36495);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgI == null) {
      coM().rgI = new i();
    }
    i locali = coM().rgI;
    AppMethodBeat.o(36495);
    return locali;
  }
  
  public static b cpa()
  {
    AppMethodBeat.i(36496);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgC == null) {
      coM().rgC = new b();
    }
    b localb = coM().rgC;
    AppMethodBeat.o(36496);
    return localb;
  }
  
  public static ax cpb()
  {
    AppMethodBeat.i(36497);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgD == null)
    {
      coM().rgD = new ax();
      com.tencent.mm.plugin.sns.b.n.raP = coM().rgD;
    }
    ax localax = coM().rgD;
    AppMethodBeat.o(36497);
    return localax;
  }
  
  public static g cpc()
  {
    AppMethodBeat.i(36498);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgw == null)
    {
      coM().rgw = new g();
      com.tencent.mm.plugin.sns.b.n.raQ = coM().rgw;
    }
    g localg = coM().rgw;
    AppMethodBeat.o(36498);
    return localg;
  }
  
  public static as cpd()
  {
    AppMethodBeat.i(36499);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgU == null) {
      coM().rgU = new as();
    }
    as localas = coM().rgU;
    AppMethodBeat.o(36499);
    return localas;
  }
  
  public static ae cpe()
  {
    AppMethodBeat.i(36500);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgA == null)
    {
      localObject = coM();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.RM();
      ((ag)localObject).rgA = new ae(com.tencent.mm.kernel.g.RL().cachePath + "snsAsyncQueue.data");
    }
    Object localObject = coM().rgA;
    AppMethodBeat.o(36500);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.sns.storage.o cpf()
  {
    AppMethodBeat.i(36501);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgs == null)
    {
      coM().rgs = new com.tencent.mm.plugin.sns.storage.o(coM().eHS);
      com.tencent.mm.plugin.sns.b.n.raW = coM().rgs;
    }
    com.tencent.mm.plugin.sns.storage.o localo = coM().rgs;
    AppMethodBeat.o(36501);
    return localo;
  }
  
  public static com.tencent.mm.plugin.sns.storage.d cpg()
  {
    AppMethodBeat.i(36502);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgu == null) {
      coM().rgu = new com.tencent.mm.plugin.sns.storage.d(coM().eHS);
    }
    com.tencent.mm.plugin.sns.storage.d locald = coM().rgu;
    AppMethodBeat.o(36502);
    return locald;
  }
  
  public static y cph()
  {
    AppMethodBeat.i(36503);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgv == null) {
      coM().rgv = new y(coM().eHS);
    }
    y localy = coM().rgv;
    AppMethodBeat.o(36503);
    return localy;
  }
  
  public static com.tencent.mm.plugin.sns.storage.f cpi()
  {
    AppMethodBeat.i(36504);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgt == null) {
      coM().rgt = new com.tencent.mm.plugin.sns.storage.f(coM().eHS);
    }
    com.tencent.mm.plugin.sns.storage.f localf = coM().rgt;
    AppMethodBeat.o(36504);
    return localf;
  }
  
  public static com.tencent.mm.plugin.sns.storage.m cpj()
  {
    AppMethodBeat.i(36505);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgx == null)
    {
      coM().rgx = new com.tencent.mm.plugin.sns.storage.m(coM().eHS, new ai());
      com.tencent.mm.plugin.sns.b.n.raR = coM().rgx;
    }
    com.tencent.mm.plugin.sns.storage.m localm = coM().rgx;
    AppMethodBeat.o(36505);
    return localm;
  }
  
  public static com.tencent.mm.plugin.sns.storage.k cpk()
  {
    AppMethodBeat.i(36506);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgy == null)
    {
      coM().rgy = new com.tencent.mm.plugin.sns.storage.k(coM().eHS);
      com.tencent.mm.plugin.sns.b.n.raS = coM().rgy;
    }
    com.tencent.mm.plugin.sns.storage.k localk = coM().rgy;
    AppMethodBeat.o(36506);
    return localk;
  }
  
  public static com.tencent.mm.plugin.sns.storage.u cpl()
  {
    AppMethodBeat.i(36507);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgz == null)
    {
      coM().rgz = new com.tencent.mm.plugin.sns.storage.u(coM().eHS);
      com.tencent.mm.plugin.sns.b.n.raT = coM().rgz;
    }
    com.tencent.mm.plugin.sns.storage.u localu = coM().rgz;
    AppMethodBeat.o(36507);
    return localu;
  }
  
  public static com.tencent.mm.plugin.sns.ui.ai cpm()
  {
    AppMethodBeat.i(36508);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (coM().rgE == null) {
      coM().rgE = new com.tencent.mm.plugin.sns.ui.ai();
    }
    com.tencent.mm.plugin.sns.ui.ai localai = coM().rgE;
    AppMethodBeat.o(36508);
    return localai;
  }
  
  public static int cpn()
  {
    AppMethodBeat.i(36509);
    WindowManager localWindowManager = (WindowManager)ah.getContext().getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    rhc.x = localDisplayMetrics.widthPixels;
    rhc.y = localDisplayMetrics.heightPixels;
    int i = (rhc.x - com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), rha)) / 3;
    rgp = i;
    if (i > rhb) {}
    for (i = rhb;; i = rgp)
    {
      rgp = i;
      if (i > 10) {
        break;
      }
      ab.e("MicroMsg.SnsCore", "can not get multiThumbDisplaySize or the multiThumbDisplaySize < 10");
      AppMethodBeat.o(36509);
      return 150;
    }
    i = rgp;
    AppMethodBeat.o(36509);
    return i;
  }
  
  public static int cpo()
  {
    AppMethodBeat.i(36510);
    if (rgq <= 0)
    {
      rgq = 200;
      rgq = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), rgq);
    }
    int i = rgq;
    AppMethodBeat.o(36510);
    return i;
  }
  
  public static boolean cpp()
  {
    AppMethodBeat.i(36512);
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.ar.r(ah.getContext(), "sp_sns_dynswitch_stg", 4);
    boolean bool;
    if (localSharedPreferences.contains("st_sw_use_vcodec_img"))
    {
      bool = localSharedPreferences.getBoolean("st_sw_use_vcodec_img", false);
      ab.w("MicroMsg.SnsCore", "isUseVCodecImg: %b (set statically outside)", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(36512);
      return bool;
      bool = localSharedPreferences.getBoolean("sw_use_vcodec_img", false);
      ab.d("MicroMsg.SnsCore", "isUseVCodecImg: %b", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static boolean cpq()
  {
    AppMethodBeat.i(36513);
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.ar.r(ah.getContext(), "sp_sns_dynswitch_stg", 4);
    boolean bool;
    if (localSharedPreferences.contains("st_sw_use_wxpc_img"))
    {
      bool = localSharedPreferences.getBoolean("st_sw_use_wxpc_img", false);
      ab.w("MicroMsg.SnsCore", "isUseWxpcImg: %b (set statically outside)", new Object[] { Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(36513);
      return bool;
      bool = localSharedPreferences.getBoolean("sw_use_wxpc_img", false);
      ab.d("MicroMsg.SnsCore", "isUseWxpcImg: %b", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  public static String cpr()
  {
    AppMethodBeat.i(36520);
    if (bo.isNullOrNil(rgQ))
    {
      localObject = com.tencent.mm.sdk.platformtools.bd.dtF().iterator();
      while (((Iterator)localObject).hasNext())
      {
        bd.a locala = (bd.a)((Iterator)localObject).next();
        if (com.tencent.mm.compatible.util.e.eQx.equals(locala.yqc)) {
          rgQ = locala.yqd;
        }
      }
      ab.i("MicroMsg.SnsCore", "get filesys " + rgQ);
    }
    Object localObject = bo.bf(rgQ, "");
    AppMethodBeat.o(36520);
    return localObject;
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(36474);
    com.tencent.mm.kernel.g.RJ().QQ();
    com.tencent.mm.kernel.g.RM();
    String str = com.tencent.mm.kernel.g.RL().eHR;
    AppMethodBeat.o(36474);
    return str;
  }
  
  public static String getAccSnsPath()
  {
    AppMethodBeat.i(36487);
    String str = ((com.tencent.mm.plugin.sns.b.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath();
    AppMethodBeat.o(36487);
    return str;
  }
  
  public static String getAccSnsTmpPath()
  {
    AppMethodBeat.i(36488);
    String str = ((com.tencent.mm.plugin.sns.b.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath();
    AppMethodBeat.o(36488);
    return str;
  }
  
  public static String getSnsAdPath()
  {
    AppMethodBeat.i(145281);
    String str = ((com.tencent.mm.plugin.sns.b.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.sns.b.b.class)).getSnsAdPath();
    AppMethodBeat.o(145281);
    return str;
  }
  
  public final void a(com.tencent.mm.model.ar paramar)
  {
    AppMethodBeat.i(36518);
    u.a(paramar);
    AppMethodBeat.o(36518);
  }
  
  public final void b(com.tencent.mm.model.ar paramar)
  {
    AppMethodBeat.i(36519);
    u.b(paramar);
    AppMethodBeat.o(36519);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(36515);
    ab.i("MicroMsg.SnsCore", "onAccountPostReset " + Thread.currentThread().getId() + " isAccInit: " + this.rgN);
    if (this.rgN)
    {
      AppMethodBeat.o(36515);
      return;
    }
    this.rgN = true;
    this.rgK = true;
    com.tencent.mm.vfs.e.um(getAccPath() + "sfs");
    this.rgP = getAccSnsPath();
    checkDir();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("NewYearSNSCtrl2016", this.rgV, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("NewYearSNSTips2016", this.rgW, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("NewYearSNSAmountLevelCtrl2016", this.rgX, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("SnsAd", this.rgY, true);
    com.tencent.mm.plugin.sns.b.n.raP = cpb();
    com.tencent.mm.plugin.sns.b.n.raQ = cpc();
    com.tencent.mm.plugin.sns.b.n.raR = cpj();
    com.tencent.mm.plugin.sns.b.n.raS = cpk();
    com.tencent.mm.plugin.sns.b.n.raT = cpl();
    com.tencent.mm.plugin.sns.b.n.raV = coV();
    com.tencent.mm.plugin.sns.b.n.raU = this;
    com.tencent.mm.plugin.sns.b.n.raW = cpf();
    com.tencent.mm.sdk.b.a.ymk.c(this.rhF);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhG);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhs);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhq);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhr);
    com.tencent.mm.sdk.b.a.ymk.c(this.rht);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhu);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhv);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhw);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhx);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhz);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhA);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhB);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhJ);
    appForegroundListener.alive();
    this.rhd = new n();
    this.rhe = new com.tencent.mm.plugin.sns.k();
    this.rhf = new com.tencent.mm.plugin.sns.e();
    this.rhg = new com.tencent.mm.plugin.sns.p();
    this.rhh = new com.tencent.mm.plugin.sns.h();
    this.rhi = new com.tencent.mm.plugin.sns.g();
    this.rhj = new com.tencent.mm.plugin.sns.m();
    this.rhk = new com.tencent.mm.plugin.sns.j();
    this.rhl = new com.tencent.mm.plugin.sns.b();
    this.rhm = new com.tencent.mm.plugin.sns.c();
    this.rhn = new com.tencent.mm.plugin.sns.f();
    com.tencent.mm.sdk.b.a.ymk.c(this.rhE);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhD);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhg);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhd);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhe);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhf);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhh);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhi);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhj);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhk);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhl);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhm);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhn);
    com.tencent.mm.sdk.b.a.ymk.c(this.oZH);
    this.rgS = new com.tencent.mm.plugin.sns.d();
    com.tencent.mm.sdk.b.a.ymk.c(this.rgS);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhI);
    com.tencent.mm.sdk.b.a.ymk.c(this.rho);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhp);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhC);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhy);
    Object localObject1 = coZ();
    i.qZN = com.tencent.mm.m.g.Nq().getInt("MMUxAdLog2GSendSize", 20480);
    i.qZO = com.tencent.mm.m.g.Nq().getInt("MMUxAdLog3GSendSize", 30720);
    i.qZP = com.tencent.mm.m.g.Nq().getInt("MMUxAdLogWifiSendSize", 51200);
    i.qZQ = com.tencent.mm.m.g.Nq().getInt("MMUxAdLogMinRandTime", 60);
    i.qZR = com.tencent.mm.m.g.Nq().getInt("MMUxAdLogMaxRandTime", 1800);
    i.qZS = com.tencent.mm.m.g.Nq().getInt("MMUxAdLogMaxExceptionTime", 43200);
    ab.i("MicroMsg.SnsLogMgr", "init " + i.qZN + ";" + i.qZO + ";" + i.qZP + ";" + i.qZQ + ";" + i.qZR + ";" + i.qZS);
    if (i.qZR - i.qZQ < 0) {
      i.qZR = i.qZQ;
    }
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(1802, (com.tencent.mm.ai.f)localObject1);
    localObject1 = cpb();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(207, (com.tencent.mm.ai.f)localObject1);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(209, (com.tencent.mm.ai.f)localObject1);
    localObject1 = this.rgJ;
    com.tencent.mm.sdk.b.a.ymk.c(((ap)localObject1).riq);
    com.tencent.mm.sdk.b.a.ymk.c(((ap)localObject1).rir);
    com.tencent.mm.sdk.b.a.ymk.c(((ap)localObject1).ris);
    this.rgT = new com.tencent.mm.plugin.sns.f.a();
    aq.init();
    localObject1 = com.tencent.mm.modelsns.c.fQN;
    com.tencent.mm.modelsns.c.akf();
    if (com.tencent.mm.memory.l.XR())
    {
      localObject1 = com.tencent.mm.memory.c.fdB;
      localObject2 = com.tencent.mm.memory.c.fdB;
      localObject2.getClass();
      ((com.tencent.mm.memory.c)localObject1).a(new ag.4(this, (com.tencent.mm.memory.c)localObject2));
    }
    localObject1 = com.tencent.mm.memory.o.fdX;
    Object localObject2 = com.tencent.mm.memory.o.fdX;
    localObject2.getClass();
    ((com.tencent.mm.memory.o)localObject1).a(new ag.5(this, (com.tencent.mm.memory.o)localObject2));
    localObject1 = com.tencent.mm.memory.g.fdI;
    localObject2 = com.tencent.mm.memory.g.fdI;
    localObject2.getClass();
    ((com.tencent.mm.memory.g)localObject1).a(new ag.6(this, (com.tencent.mm.memory.g)localObject2));
    cpd();
    com.tencent.mm.plugin.sns.e.a.init();
    AppMethodBeat.o(36515);
  }
  
  /* Error */
  public final void onAccountRelease()
  {
    // Byte code:
    //   0: ldc_w 1622
    //   3: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 1484	com/tencent/mm/plugin/sns/model/ag:coZ	()Lcom/tencent/mm/plugin/sns/a/b/i;
    //   9: astore_1
    //   10: invokestatic 638	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   13: pop
    //   14: invokestatic 1527	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   17: getfield 1533	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   20: sipush 1802
    //   23: aload_1
    //   24: invokevirtual 1624	com/tencent/mm/ai/p:b	(ILcom/tencent/mm/ai/f;)V
    //   27: aload_0
    //   28: getfield 291	com/tencent/mm/plugin/sns/model/ag:rgJ	Lcom/tencent/mm/plugin/sns/model/ap;
    //   31: astore_1
    //   32: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   35: aload_1
    //   36: getfield 1541	com/tencent/mm/plugin/sns/model/ap:riq	Lcom/tencent/mm/sdk/b/c;
    //   39: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   42: pop
    //   43: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   46: aload_1
    //   47: getfield 1544	com/tencent/mm/plugin/sns/model/ap:rir	Lcom/tencent/mm/sdk/b/c;
    //   50: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   53: pop
    //   54: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   57: aload_1
    //   58: getfield 1547	com/tencent/mm/plugin/sns/model/ap:ris	Lcom/tencent/mm/sdk/b/c;
    //   61: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   64: pop
    //   65: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   68: aload_0
    //   69: getfield 410	com/tencent/mm/plugin/sns/model/ag:rhF	Lcom/tencent/mm/sdk/b/c;
    //   72: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   75: pop
    //   76: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   79: aload_0
    //   80: getfield 415	com/tencent/mm/plugin/sns/model/ag:rhG	Lcom/tencent/mm/sdk/b/c;
    //   83: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   86: pop
    //   87: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   90: aload_0
    //   91: getfield 405	com/tencent/mm/plugin/sns/model/ag:rhE	Lcom/tencent/mm/sdk/b/c;
    //   94: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   97: pop
    //   98: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   101: aload_0
    //   102: getfield 400	com/tencent/mm/plugin/sns/model/ag:rhD	Lcom/tencent/mm/sdk/b/c;
    //   105: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   108: pop
    //   109: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   112: aload_0
    //   113: getfield 351	com/tencent/mm/plugin/sns/model/ag:rhs	Lcom/tencent/mm/sdk/b/c;
    //   116: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   119: pop
    //   120: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   123: aload_0
    //   124: getfield 343	com/tencent/mm/plugin/sns/model/ag:rhq	Lcom/tencent/mm/sdk/b/c;
    //   127: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   130: pop
    //   131: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   134: aload_0
    //   135: getfield 346	com/tencent/mm/plugin/sns/model/ag:rhr	Lcom/tencent/mm/sdk/b/c;
    //   138: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   141: pop
    //   142: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   145: aload_0
    //   146: getfield 356	com/tencent/mm/plugin/sns/model/ag:rht	Lcom/tencent/mm/sdk/b/c;
    //   149: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   152: pop
    //   153: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   156: aload_0
    //   157: getfield 361	com/tencent/mm/plugin/sns/model/ag:rhu	Lcom/tencent/mm/sdk/b/c;
    //   160: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   163: pop
    //   164: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   167: aload_0
    //   168: getfield 366	com/tencent/mm/plugin/sns/model/ag:rhv	Lcom/tencent/mm/sdk/b/c;
    //   171: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   174: pop
    //   175: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   178: aload_0
    //   179: getfield 1442	com/tencent/mm/plugin/sns/model/ag:rhg	Lcom/tencent/mm/plugin/sns/p;
    //   182: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   185: pop
    //   186: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   189: aload_0
    //   190: getfield 1447	com/tencent/mm/plugin/sns/model/ag:rhh	Lcom/tencent/mm/plugin/sns/h;
    //   193: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   196: pop
    //   197: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   200: aload_0
    //   201: getfield 376	com/tencent/mm/plugin/sns/model/ag:rhx	Lcom/tencent/mm/sdk/b/c;
    //   204: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   207: pop
    //   208: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   211: aload_0
    //   212: getfield 386	com/tencent/mm/plugin/sns/model/ag:rhz	Lcom/tencent/mm/sdk/b/c;
    //   215: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   218: pop
    //   219: getstatic 267	com/tencent/mm/plugin/sns/model/ag:appForegroundListener	Lcom/tencent/mm/app/j$a;
    //   222: invokevirtual 1629	com/tencent/mm/app/j$a:dead	()V
    //   225: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   228: aload_0
    //   229: getfield 1427	com/tencent/mm/plugin/sns/model/ag:rhd	Lcom/tencent/mm/plugin/sns/n;
    //   232: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   235: pop
    //   236: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   239: aload_0
    //   240: getfield 1432	com/tencent/mm/plugin/sns/model/ag:rhe	Lcom/tencent/mm/plugin/sns/k;
    //   243: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   246: pop
    //   247: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   250: aload_0
    //   251: getfield 1437	com/tencent/mm/plugin/sns/model/ag:rhf	Lcom/tencent/mm/plugin/sns/e;
    //   254: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   257: pop
    //   258: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   261: aload_0
    //   262: getfield 1452	com/tencent/mm/plugin/sns/model/ag:rhi	Lcom/tencent/mm/plugin/sns/g;
    //   265: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   268: pop
    //   269: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   272: aload_0
    //   273: getfield 1457	com/tencent/mm/plugin/sns/model/ag:rhj	Lcom/tencent/mm/plugin/sns/m;
    //   276: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   279: pop
    //   280: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   283: aload_0
    //   284: getfield 1462	com/tencent/mm/plugin/sns/model/ag:rhk	Lcom/tencent/mm/plugin/sns/j;
    //   287: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   290: pop
    //   291: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   294: aload_0
    //   295: getfield 1467	com/tencent/mm/plugin/sns/model/ag:rhl	Lcom/tencent/mm/plugin/sns/b;
    //   298: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   301: pop
    //   302: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   305: aload_0
    //   306: getfield 1472	com/tencent/mm/plugin/sns/model/ag:rhm	Lcom/tencent/mm/plugin/sns/c;
    //   309: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   312: pop
    //   313: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   316: aload_0
    //   317: getfield 1477	com/tencent/mm/plugin/sns/model/ag:rhn	Lcom/tencent/mm/plugin/sns/f;
    //   320: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   323: pop
    //   324: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   327: aload_0
    //   328: getfield 371	com/tencent/mm/plugin/sns/model/ag:rhw	Lcom/tencent/mm/sdk/b/c;
    //   331: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   334: pop
    //   335: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   338: aload_0
    //   339: getfield 1482	com/tencent/mm/plugin/sns/model/ag:rgS	Lcom/tencent/mm/plugin/sns/d;
    //   342: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   345: pop
    //   346: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   349: aload_0
    //   350: getfield 391	com/tencent/mm/plugin/sns/model/ag:rhA	Lcom/tencent/mm/sdk/b/c;
    //   353: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   356: pop
    //   357: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   360: aload_0
    //   361: getfield 394	com/tencent/mm/plugin/sns/model/ag:rhB	Lcom/tencent/mm/sdk/b/c;
    //   364: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   367: pop
    //   368: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   371: aload_0
    //   372: getfield 422	com/tencent/mm/plugin/sns/model/ag:oZH	Lcom/tencent/mm/sdk/b/c;
    //   375: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   378: pop
    //   379: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   382: aload_0
    //   383: getfield 427	com/tencent/mm/plugin/sns/model/ag:rhI	Lcom/tencent/mm/sdk/b/c;
    //   386: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   389: pop
    //   390: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   393: aload_0
    //   394: getfield 397	com/tencent/mm/plugin/sns/model/ag:rhC	Lcom/tencent/mm/sdk/b/c;
    //   397: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   400: pop
    //   401: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   404: aload_0
    //   405: getfield 333	com/tencent/mm/plugin/sns/model/ag:rho	Lcom/tencent/mm/sdk/b/c;
    //   408: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   411: pop
    //   412: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   415: aload_0
    //   416: getfield 338	com/tencent/mm/plugin/sns/model/ag:rhp	Lcom/tencent/mm/sdk/b/c;
    //   419: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   422: pop
    //   423: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   426: aload_0
    //   427: getfield 432	com/tencent/mm/plugin/sns/model/ag:rhJ	Lcom/tencent/mm/sdk/b/c;
    //   430: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   433: pop
    //   434: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   437: aload_0
    //   438: getfield 381	com/tencent/mm/plugin/sns/model/ag:rhy	Lcom/tencent/mm/sdk/b/c;
    //   441: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   444: pop
    //   445: getstatic 1635	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a$e:rrx	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a;
    //   448: astore_1
    //   449: aload_1
    //   450: getfield 1640	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:rrq	Z
    //   453: ifeq +18 -> 471
    //   456: invokestatic 187	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   459: aload_1
    //   460: getfield 1644	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:rrp	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a$a;
    //   463: invokevirtual 1648	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   466: aload_1
    //   467: iconst_0
    //   468: putfield 1640	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:rrq	Z
    //   471: invokestatic 1654	com/tencent/mm/plugin/downloader/model/f:bjl	()Lcom/tencent/mm/plugin/downloader/model/f;
    //   474: pop
    //   475: aload_1
    //   476: getfield 1658	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/a:rru	Lcom/tencent/mm/plugin/downloader/model/m;
    //   479: invokestatic 1663	com/tencent/mm/plugin/downloader/model/c:b	(Lcom/tencent/mm/plugin/downloader/model/m;)V
    //   482: ldc_w 1376
    //   485: invokestatic 614	com/tencent/mm/kernel/g:G	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   488: checkcast 1376	com/tencent/mm/plugin/messenger/foundation/a/p
    //   491: invokeinterface 1380 1 0
    //   496: ldc_w 1382
    //   499: aload_0
    //   500: getfield 311	com/tencent/mm/plugin/sns/model/ag:rgV	Lcom/tencent/mm/plugin/sns/lucky/a/f;
    //   503: iconst_1
    //   504: invokevirtual 1665	com/tencent/mm/model/bz:b	(Ljava/lang/String;Lcom/tencent/mm/model/bz$a;Z)V
    //   507: ldc_w 1376
    //   510: invokestatic 614	com/tencent/mm/kernel/g:G	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   513: checkcast 1376	com/tencent/mm/plugin/messenger/foundation/a/p
    //   516: invokeinterface 1380 1 0
    //   521: ldc_w 1389
    //   524: aload_0
    //   525: getfield 316	com/tencent/mm/plugin/sns/model/ag:rgW	Lcom/tencent/mm/plugin/sns/lucky/a/j;
    //   528: iconst_1
    //   529: invokevirtual 1665	com/tencent/mm/model/bz:b	(Ljava/lang/String;Lcom/tencent/mm/model/bz$a;Z)V
    //   532: ldc_w 1376
    //   535: invokestatic 614	com/tencent/mm/kernel/g:G	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   538: checkcast 1376	com/tencent/mm/plugin/messenger/foundation/a/p
    //   541: invokeinterface 1380 1 0
    //   546: ldc_w 1391
    //   549: aload_0
    //   550: getfield 321	com/tencent/mm/plugin/sns/model/ag:rgX	Lcom/tencent/mm/plugin/sns/lucky/a/d;
    //   553: iconst_1
    //   554: invokevirtual 1665	com/tencent/mm/model/bz:b	(Ljava/lang/String;Lcom/tencent/mm/model/bz$a;Z)V
    //   557: ldc_w 1376
    //   560: invokestatic 614	com/tencent/mm/kernel/g:G	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   563: checkcast 1376	com/tencent/mm/plugin/messenger/foundation/a/p
    //   566: invokeinterface 1380 1 0
    //   571: ldc_w 1393
    //   574: aload_0
    //   575: getfield 326	com/tencent/mm/plugin/sns/model/ag:rgY	Lcom/tencent/mm/plugin/sns/lucky/a/l;
    //   578: iconst_1
    //   579: invokevirtual 1665	com/tencent/mm/model/bz:b	(Ljava/lang/String;Lcom/tencent/mm/model/bz$a;Z)V
    //   582: invokestatic 1395	com/tencent/mm/plugin/sns/model/ag:cpb	()Lcom/tencent/mm/plugin/sns/model/ax;
    //   585: astore_1
    //   586: invokestatic 638	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   589: pop
    //   590: invokestatic 1527	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   593: getfield 1533	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   596: sipush 207
    //   599: aload_1
    //   600: invokevirtual 1624	com/tencent/mm/ai/p:b	(ILcom/tencent/mm/ai/f;)V
    //   603: invokestatic 638	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   606: pop
    //   607: invokestatic 1527	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   610: getfield 1533	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   613: sipush 209
    //   616: aload_1
    //   617: invokevirtual 1624	com/tencent/mm/ai/p:b	(ILcom/tencent/mm/ai/f;)V
    //   620: ldc 2
    //   622: invokestatic 672	com/tencent/mm/model/q:S	(Ljava/lang/Class;)Lcom/tencent/mm/model/at;
    //   625: checkcast 2	com/tencent/mm/plugin/sns/model/ag
    //   628: astore_1
    //   629: aload_1
    //   630: ifnull +95 -> 725
    //   633: ldc_w 434
    //   636: ldc_w 1667
    //   639: invokestatic 1669	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   642: aload_1
    //   643: getfield 520	com/tencent/mm/plugin/sns/model/ag:eHS	Lcom/tencent/mm/cg/h;
    //   646: ifnull +15 -> 661
    //   649: aload_1
    //   650: getfield 520	com/tencent/mm/plugin/sns/model/ag:eHS	Lcom/tencent/mm/cg/h;
    //   653: invokevirtual 845	com/tencent/mm/cg/h:closeDB	()V
    //   656: aload_1
    //   657: aconst_null
    //   658: putfield 520	com/tencent/mm/plugin/sns/model/ag:eHS	Lcom/tencent/mm/cg/h;
    //   661: aload_1
    //   662: getfield 466	com/tencent/mm/plugin/sns/model/ag:rgn	Lcom/tencent/mm/sdk/g/b/a;
    //   665: ifnull +12 -> 677
    //   668: aload_1
    //   669: getfield 466	com/tencent/mm/plugin/sns/model/ag:rgn	Lcom/tencent/mm/sdk/g/b/a;
    //   672: invokeinterface 1672 1 0
    //   677: aload_1
    //   678: getfield 479	com/tencent/mm/plugin/sns/model/ag:rgm	Lcom/tencent/mm/sdk/g/b/a;
    //   681: ifnull +12 -> 693
    //   684: aload_1
    //   685: getfield 479	com/tencent/mm/plugin/sns/model/ag:rgm	Lcom/tencent/mm/sdk/g/b/a;
    //   688: invokeinterface 1672 1 0
    //   693: aload_1
    //   694: getfield 483	com/tencent/mm/plugin/sns/model/ag:rgl	Lcom/tencent/mm/sdk/g/b/a;
    //   697: ifnull +12 -> 709
    //   700: aload_1
    //   701: getfield 483	com/tencent/mm/plugin/sns/model/ag:rgl	Lcom/tencent/mm/sdk/g/b/a;
    //   704: invokeinterface 1672 1 0
    //   709: aload_1
    //   710: getfield 491	com/tencent/mm/plugin/sns/model/ag:rgo	Lcom/tencent/mm/sdk/g/b/a;
    //   713: ifnull +12 -> 725
    //   716: aload_1
    //   717: getfield 491	com/tencent/mm/plugin/sns/model/ag:rgo	Lcom/tencent/mm/sdk/g/b/a;
    //   720: invokeinterface 1672 1 0
    //   725: aload_0
    //   726: getfield 1552	com/tencent/mm/plugin/sns/model/ag:rgT	Lcom/tencent/mm/plugin/sns/f/a;
    //   729: astore_1
    //   730: invokestatic 1674	com/tencent/mm/plugin/sns/model/ag:cpa	()Lcom/tencent/mm/plugin/sns/model/b;
    //   733: aload_1
    //   734: invokevirtual 1677	com/tencent/mm/plugin/sns/model/b:b	(Lcom/tencent/mm/plugin/sns/model/b$b;)V
    //   737: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   740: aload_1
    //   741: getfield 1680	com/tencent/mm/plugin/sns/f/a:rbF	Lcom/tencent/mm/sdk/b/c;
    //   744: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   747: pop
    //   748: invokestatic 1683	com/tencent/mm/plugin/sns/model/aq:aoR	()V
    //   751: getstatic 1607	com/tencent/mm/memory/g:fdI	Lcom/tencent/mm/memory/g;
    //   754: invokevirtual 1686	com/tencent/mm/memory/g:XJ	()V
    //   757: getstatic 1577	com/tencent/mm/memory/c:fdB	Lcom/tencent/mm/memory/c;
    //   760: invokevirtual 1687	com/tencent/mm/memory/c:XJ	()V
    //   763: getstatic 1595	com/tencent/mm/memory/o:fdX	Lcom/tencent/mm/memory/o;
    //   766: invokevirtual 1688	com/tencent/mm/memory/o:XJ	()V
    //   769: invokestatic 1615	com/tencent/mm/plugin/sns/model/ag:cpd	()Lcom/tencent/mm/plugin/sns/model/as;
    //   772: astore_2
    //   773: aload_2
    //   774: aconst_null
    //   775: putfield 1692	com/tencent/mm/plugin/sns/model/as:riB	Lcom/tencent/mm/plugin/sns/model/az;
    //   778: aload_2
    //   779: aconst_null
    //   780: putfield 1696	com/tencent/mm/plugin/sns/model/as:fWu	Lcom/tencent/mm/modelvideo/f;
    //   783: aload_2
    //   784: getfield 1700	com/tencent/mm/plugin/sns/model/as:riD	Ljava/util/Map;
    //   787: invokeinterface 1705 1 0
    //   792: aload_2
    //   793: getfield 1709	com/tencent/mm/plugin/sns/model/as:riC	Ljava/util/LinkedList;
    //   796: invokevirtual 1712	java/util/LinkedList:clear	()V
    //   799: aload_2
    //   800: getfield 1715	com/tencent/mm/plugin/sns/model/as:riE	Ljava/util/LinkedList;
    //   803: astore_1
    //   804: aload_1
    //   805: monitorenter
    //   806: aload_2
    //   807: getfield 1715	com/tencent/mm/plugin/sns/model/as:riE	Ljava/util/LinkedList;
    //   810: invokevirtual 1712	java/util/LinkedList:clear	()V
    //   813: aload_1
    //   814: monitorexit
    //   815: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   818: aload_2
    //   819: getfield 1718	com/tencent/mm/plugin/sns/model/as:riF	Lcom/tencent/mm/sdk/b/c;
    //   822: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   825: pop
    //   826: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   829: aload_2
    //   830: getfield 1719	com/tencent/mm/plugin/sns/model/as:rir	Lcom/tencent/mm/sdk/b/c;
    //   833: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   836: pop
    //   837: getstatic 1413	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   840: aload_2
    //   841: getfield 1720	com/tencent/mm/plugin/sns/model/as:ris	Lcom/tencent/mm/sdk/b/c;
    //   844: invokevirtual 1626	com/tencent/mm/sdk/b/a:d	(Lcom/tencent/mm/sdk/b/c;)Z
    //   847: pop
    //   848: invokestatic 1723	com/tencent/mm/plugin/sns/e/a:destroy	()V
    //   851: ldc_w 1622
    //   854: invokestatic 270	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   857: return
    //   858: astore_2
    //   859: ldc_w 1725
    //   862: ldc_w 1727
    //   865: iconst_1
    //   866: anewarray 4	java/lang/Object
    //   869: dup
    //   870: iconst_0
    //   871: aload_2
    //   872: invokevirtual 1730	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   875: aastore
    //   876: invokestatic 1732	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   879: goto -408 -> 471
    //   882: astore_2
    //   883: aload_1
    //   884: monitorexit
    //   885: ldc_w 1622
    //   888: invokestatic 270	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   891: aload_2
    //   892: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	893	0	this	ag
    //   772	69	2	localas	as
    //   858	14	2	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   882	10	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   456	471	858	java/lang/IllegalArgumentException
    //   806	815	882	finally
    //   883	885	882	finally
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(36517);
    com.tencent.mm.vfs.e.um(getAccPath() + "sfs");
    checkDir();
    AppMethodBeat.o(36517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ag
 * JD-Core Version:    0.7.0.1
 */