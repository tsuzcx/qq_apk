package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteException;
import android.graphics.Point;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.cm;
import com.tencent.mm.h.a.ns;
import com.tencent.mm.h.a.ns.a;
import com.tencent.mm.h.a.qc;
import com.tencent.mm.model.bx;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.i;
import com.tencent.mm.plugin.sns.n;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class af
  implements com.tencent.mm.model.ar, com.tencent.mm.plugin.sns.b.j
{
  private static int orA;
  private static int orB;
  public static boolean ort = true;
  private static int oru = 0;
  private static int orv = 0;
  private static String osb = "";
  protected static HashMap<Integer, h.d> osc = new HashMap();
  private static int osk = 103;
  private static Point osl = new Point();
  private com.tencent.mm.cf.h dKu;
  private byte[] dMQ = new byte[0];
  private com.tencent.mm.sdk.platformtools.ah handler = new com.tencent.mm.sdk.platformtools.ah(Looper.getMainLooper());
  private com.tencent.mm.sdk.b.c mzB = new af.32(this);
  private s orC;
  private com.tencent.mm.plugin.sns.storage.o orD;
  private com.tencent.mm.plugin.sns.storage.f orE;
  private com.tencent.mm.plugin.sns.storage.d orF;
  private com.tencent.mm.plugin.sns.storage.y orG;
  private g orH;
  private com.tencent.mm.plugin.sns.storage.m orI;
  private com.tencent.mm.plugin.sns.storage.k orJ;
  private com.tencent.mm.plugin.sns.storage.u orK;
  private ad orL;
  private am.a orM;
  private b orN;
  private aw orO;
  private com.tencent.mm.plugin.sns.ui.ai orP;
  private com.tencent.mm.plugin.sns.f.c orQ;
  private com.tencent.mm.plugin.sns.f.g orR;
  private q orS;
  private i orT;
  private ao orU = new ao();
  private boolean orV = false;
  private boolean orW = true;
  private w orX = new w();
  private boolean orY = false;
  private byte[] orZ = new byte[0];
  private com.tencent.mm.sdk.platformtools.ah[] orw = new com.tencent.mm.sdk.platformtools.ah[3];
  private com.tencent.mm.sdk.platformtools.ah[] orx = new com.tencent.mm.sdk.platformtools.ah[1];
  private com.tencent.mm.sdk.platformtools.ah ory = null;
  private com.tencent.mm.sdk.platformtools.ah orz = null;
  private com.tencent.mm.sdk.b.c osA = new af.15(this);
  private com.tencent.mm.sdk.b.c osB = new af.16(this);
  private com.tencent.mm.sdk.b.c osC = new af.17(this);
  private com.tencent.mm.sdk.b.c osD = new af.18(this);
  private com.tencent.mm.sdk.b.c osE = new af.19(this);
  private com.tencent.mm.sdk.b.c osF = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.sdk.b.c osG = new af.21(this);
  private com.tencent.mm.sdk.b.c osH = new af.22(this);
  private com.tencent.mm.sdk.b.c osI = new af.24(this);
  private com.tencent.mm.sdk.b.c osJ = new af.25(this);
  private com.tencent.mm.sdk.b.c osK = new af.26(this);
  private com.tencent.mm.sdk.b.c osL = new com.tencent.mm.sdk.b.c()
  {
    private static boolean a(ns paramAnonymousns)
    {
      SnsAdClick localSnsAdClick = paramAnonymousns.bXt.bXi;
      for (;;)
      {
        i locali;
        try
        {
          if (paramAnonymousns.bXt.bXu != 1) {
            break label678;
          }
          if (localSnsAdClick.eAD == 1)
          {
            com.tencent.mm.plugin.sns.storage.e locale = af.bDI().gk(localSnsAdClick.eAA);
            if ((locale != null) && (locale.bEQ()))
            {
              localObject2 = af.bDz();
              j = 14647;
              localObject1 = new Object[7];
              localObject1[0] = Long.valueOf(localSnsAdClick.eAA);
              localObject1[1] = locale.bGb().ovV;
              localObject1[2] = Integer.valueOf(localSnsAdClick.eAz);
              localObject1[3] = Long.valueOf(localSnsAdClick.startTime);
              localObject1[4] = Long.valueOf(System.currentTimeMillis());
              i = locale.bGd();
              paramAnonymousns = (ns)localObject1;
              paramAnonymousns[5] = Integer.valueOf(i);
              localObject1[6] = "";
              ((i)localObject2).f(j, (Object[])localObject1);
              paramAnonymousns = com.tencent.mm.modelsns.b.je(750);
              paramAnonymousns.ni(localSnsAdClick.eAA).ni(locale.bGb().ovV).jg(localSnsAdClick.eAz).ni(localSnsAdClick.startTime).ni(System.currentTimeMillis());
              paramAnonymousns.QX();
              return false;
            }
            locali = af.bDz();
            int j = 13155;
            paramAnonymousns = new Object[7];
            paramAnonymousns[0] = Long.valueOf(localSnsAdClick.eAA);
            paramAnonymousns[1] = locale.bGb().ovV;
            paramAnonymousns[2] = Integer.valueOf(localSnsAdClick.eAz);
            paramAnonymousns[3] = Long.valueOf(localSnsAdClick.startTime);
            paramAnonymousns[4] = Long.valueOf(System.currentTimeMillis());
            if (locale == null) {
              break label680;
            }
            i = locale.bGd();
            localObject1 = paramAnonymousns;
            localObject2 = paramAnonymousns;
            paramAnonymousns = (ns)localObject1;
            localObject1 = localObject2;
            localObject2 = locali;
            continue;
          }
          paramAnonymousns = af.bDI().gk(localSnsAdClick.eAA);
          localObject1 = com.tencent.mm.plugin.sns.a.b.f.a(localSnsAdClick.eAA, new Object[] { localSnsAdClick, paramAnonymousns.bGb().ovV, Integer.valueOf(localSnsAdClick.eAz), Long.valueOf(localSnsAdClick.startTime), Long.valueOf(System.currentTimeMillis()) });
          localObject1 = (String)localObject1 + String.format(",%s", new Object[] { localSnsAdClick.eAE });
          localObject1 = (String)localObject1 + String.format(",%s", new Object[] { System.currentTimeMillis() - localSnsAdClick.startTime - localSnsAdClick.eAG });
          if ((paramAnonymousns != null) && (paramAnonymousns.bEQ()))
          {
            af.bDz().f(14643, new Object[] { localObject1 });
            localObject1 = com.tencent.mm.modelsns.b.je(733);
            ((com.tencent.mm.modelsns.b)localObject1).ni(localSnsAdClick.eAA).ni(paramAnonymousns.bGb().ovV).jg(localSnsAdClick.eAz).ni(localSnsAdClick.startTime).ni(System.currentTimeMillis());
            ((com.tencent.mm.modelsns.b)localObject1).QX();
            return false;
          }
        }
        catch (Exception paramAnonymousns)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.SnsCore", paramAnonymousns, "report ad click error", new Object[0]);
          return false;
        }
        af.bDz().f(12013, new Object[] { localObject1 });
        continue;
        label678:
        return false;
        label680:
        int i = -1;
        Object localObject1 = paramAnonymousns;
        Object localObject2 = paramAnonymousns;
        paramAnonymousns = (ns)localObject1;
        localObject1 = localObject2;
        localObject2 = locali;
      }
    }
  };
  private com.tencent.mm.sdk.b.c osM = new af.28(this);
  private com.tencent.mm.sdk.b.c osN = new af.29(this);
  private com.tencent.mm.sdk.b.c osO = new af.30(this);
  private boolean osP = false;
  private com.tencent.mm.sdk.b.c osQ = new af.33(this);
  private com.tencent.mm.sdk.b.c osR = new af.35(this);
  private String osa;
  private com.tencent.mm.plugin.sns.d osd;
  private com.tencent.mm.plugin.sns.e.a ose;
  private ar osf;
  private com.tencent.mm.plugin.sns.lucky.a.f osg = new com.tencent.mm.plugin.sns.lucky.a.f();
  private com.tencent.mm.plugin.sns.lucky.a.j osh = new com.tencent.mm.plugin.sns.lucky.a.j();
  private com.tencent.mm.plugin.sns.lucky.a.d osi = new com.tencent.mm.plugin.sns.lucky.a.d();
  private com.tencent.mm.plugin.sns.lucky.a.l osj = new com.tencent.mm.plugin.sns.lucky.a.l();
  private n osm;
  private com.tencent.mm.plugin.sns.k osn;
  private com.tencent.mm.plugin.sns.e oso;
  private com.tencent.mm.plugin.sns.p osp;
  private com.tencent.mm.plugin.sns.h osq;
  private com.tencent.mm.plugin.sns.g osr;
  private com.tencent.mm.plugin.sns.m oss;
  private com.tencent.mm.plugin.sns.j ost;
  private com.tencent.mm.plugin.sns.b osu;
  private com.tencent.mm.plugin.sns.c osv;
  private com.tencent.mm.plugin.sns.f osw;
  private com.tencent.mm.sdk.b.c osx = new af.11(this);
  private com.tencent.mm.sdk.b.c osy = new af.13(this);
  private com.tencent.mm.sdk.b.c osz = new com.tencent.mm.sdk.b.c() {};
  
  static
  {
    osc.put(Integer.valueOf("CanvasInfo".hashCode()), new af.12());
    osc.put(Integer.valueOf("UxCanvasInfo".hashCode()), new af.23());
    osc.put(Integer.valueOf("SNSMEDIA_TABLE".hashCode()), new af.34());
    osc.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new af.36());
    osc.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new af.37());
    osc.put(Integer.valueOf("ADSNSINFO_TABLE".hashCode()), new af.38());
    osc.put(Integer.valueOf("SNSEXT_TABLE".hashCode()), new af.39());
    osc.put(Integer.valueOf("SNSCOMMENT_TABLE".hashCode()), new af.40());
    osc.put(Integer.valueOf("SNSTAGINFO_TABLE".hashCode()), new af.2());
    osc.put(Integer.valueOf("SNSKVREPORT_TABLE".hashCode()), new af.3());
  }
  
  public af()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCore", "snscore create! " + Thread.currentThread().getId());
    bDR();
    if (this.ory == null) {
      com.tencent.mm.sdk.f.e.c(new af.6(this), "SnsCore_fileTask_handler", 1).start();
    }
    if (this.orz == null) {
      com.tencent.mm.sdk.f.e.c(new af.7(this), "SnsCore_task_handler", 10).start();
    }
    com.tencent.mm.sdk.platformtools.ai.l(new af.1(this), 3000L);
  }
  
  public static com.tencent.mm.cf.h Dv()
  {
    return bDn().dKu;
  }
  
  public static String FU()
  {
    com.tencent.mm.kernel.g.DN().CX();
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().dKt;
  }
  
  public static com.tencent.mm.sdk.platformtools.ah aXo()
  {
    if (orv > 0) {
      orv = 0;
    }
    com.tencent.mm.sdk.platformtools.ah[] arrayOfah = bDn().orx;
    int i = orv;
    orv = i + 1;
    return arrayOfah[i];
  }
  
  public static com.tencent.mm.sdk.platformtools.ah aXq()
  {
    return bDn().handler;
  }
  
  public static b bDA()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orN == null) {
      bDn().orN = new b();
    }
    return bDn().orN;
  }
  
  public static aw bDB()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orO == null)
    {
      bDn().orO = new aw();
      com.tencent.mm.plugin.sns.b.n.omB = bDn().orO;
    }
    return bDn().orO;
  }
  
  public static g bDC()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orH == null)
    {
      bDn().orH = new g();
      com.tencent.mm.plugin.sns.b.n.omC = bDn().orH;
    }
    return bDn().orH;
  }
  
  public static ar bDD()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().osf == null) {
      bDn().osf = new ar();
    }
    return bDn().osf;
  }
  
  public static ad bDE()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orL == null)
    {
      af localaf = bDn();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.DQ();
      localaf.orL = new ad(com.tencent.mm.kernel.g.DP().cachePath + "snsAsyncQueue.data");
    }
    return bDn().orL;
  }
  
  public static com.tencent.mm.plugin.sns.storage.o bDF()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orD == null)
    {
      bDn().orD = new com.tencent.mm.plugin.sns.storage.o(bDn().dKu);
      com.tencent.mm.plugin.sns.b.n.omI = bDn().orD;
    }
    return bDn().orD;
  }
  
  public static com.tencent.mm.plugin.sns.storage.d bDG()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orF == null) {
      bDn().orF = new com.tencent.mm.plugin.sns.storage.d(bDn().dKu);
    }
    return bDn().orF;
  }
  
  public static com.tencent.mm.plugin.sns.storage.y bDH()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orG == null) {
      bDn().orG = new com.tencent.mm.plugin.sns.storage.y(bDn().dKu);
    }
    return bDn().orG;
  }
  
  public static com.tencent.mm.plugin.sns.storage.f bDI()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orE == null) {
      bDn().orE = new com.tencent.mm.plugin.sns.storage.f(bDn().dKu);
    }
    return bDn().orE;
  }
  
  public static com.tencent.mm.plugin.sns.storage.m bDJ()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orI == null)
    {
      bDn().orI = new com.tencent.mm.plugin.sns.storage.m(bDn().dKu, new ah());
      com.tencent.mm.plugin.sns.b.n.omD = bDn().orI;
    }
    return bDn().orI;
  }
  
  public static com.tencent.mm.plugin.sns.storage.k bDK()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orJ == null)
    {
      bDn().orJ = new com.tencent.mm.plugin.sns.storage.k(bDn().dKu);
      com.tencent.mm.plugin.sns.b.n.omE = bDn().orJ;
    }
    return bDn().orJ;
  }
  
  public static com.tencent.mm.plugin.sns.storage.u bDL()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orK == null)
    {
      bDn().orK = new com.tencent.mm.plugin.sns.storage.u(bDn().dKu);
      com.tencent.mm.plugin.sns.b.n.omF = bDn().orK;
    }
    return bDn().orK;
  }
  
  public static com.tencent.mm.plugin.sns.ui.ai bDM()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orP == null) {
      bDn().orP = new com.tencent.mm.plugin.sns.ui.ai();
    }
    return bDn().orP;
  }
  
  public static int bDN()
  {
    if (biC().y < biC().x) {}
    for (int i = biC().y;; i = biC().x - com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), osk))
    {
      i /= 3;
      orA = i;
      if (i > 10) {
        break;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsCore", "can not get multiThumbDisplaySize or the multiThumbDisplaySize < 10");
      return 150;
    }
    return orA;
  }
  
  public static int bDO()
  {
    if (orB <= 0)
    {
      orB = 200;
      orB = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), orB);
    }
    return orB;
  }
  
  public static boolean bDP()
  {
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.ap.l(ae.getContext(), "sp_sns_dynswitch_stg", 4);
    if (localSharedPreferences.contains("st_sw_use_vcodec_img"))
    {
      bool = localSharedPreferences.getBoolean("st_sw_use_vcodec_img", false);
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.SnsCore", "isUseVCodecImg: %b (set statically outside)", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    boolean bool = localSharedPreferences.getBoolean("sw_use_vcodec_img", false);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsCore", "isUseVCodecImg: %b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public static boolean bDQ()
  {
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.ap.l(ae.getContext(), "sp_sns_dynswitch_stg", 4);
    if (localSharedPreferences.contains("st_sw_use_wxpc_img"))
    {
      bool = localSharedPreferences.getBoolean("st_sw_use_wxpc_img", false);
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.SnsCore", "isUseWxpcImg: %b (set statically outside)", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    boolean bool = localSharedPreferences.getBoolean("sw_use_wxpc_img", false);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsCore", "isUseWxpcImg: %b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  private void bDR()
  {
    int i = 0;
    while (i < 3)
    {
      if (this.orw[i] == null) {
        com.tencent.mm.sdk.f.e.c(new af.4(this, i), "SnsCore_CDNDownload_handler", 1).start();
      }
      i += 1;
    }
    i = 0;
    while (i <= 0)
    {
      if (this.orx[0] == null) {
        com.tencent.mm.sdk.f.e.c(new af.5(this), "SnsCore_thumbDecode_handler", 1).start();
      }
      i += 1;
    }
  }
  
  public static String bDS()
  {
    if (bk.bl(osb))
    {
      Iterator localIterator = az.crF().iterator();
      while (localIterator.hasNext())
      {
        az.a locala = (az.a)localIterator.next();
        if (com.tencent.mm.compatible.util.e.bkF.equals(locala.uhW)) {
          osb = locala.uhX;
        }
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCore", "get filesys " + osb);
    }
    return bk.aM(osb, "");
  }
  
  public static String bDl()
  {
    com.tencent.mm.kernel.g.DQ();
    return (String)com.tencent.mm.kernel.g.DP().Dz().get(2, null);
  }
  
  public static int bDm()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN();
    return com.tencent.mm.kernel.a.CK();
  }
  
  private static af bDn()
  {
    af localaf1 = (af)com.tencent.mm.model.p.B(af.class);
    if (!localaf1.orY) {}
    for (;;)
    {
      Object localObject3;
      Object localObject2;
      synchronized (localaf1.orZ)
      {
        if (!localaf1.orY)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCore", "onAccInit because bug!");
          localaf1.bh(true);
        }
        if (!localaf1.orV) {
          break label1567;
        }
        synchronized (localaf1.dMQ)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCore", "getCore need reset DB now " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + localaf1.hashCode());
          if (!localaf1.orV) {
            break label1564;
          }
          localaf1.orW = false;
          localObject3 = localaf1.orX;
          localObject2 = osc;
          if (((w)localObject3).oLX)
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TrimSnsDb", "pass hasTrim");
            if (localaf1.dKu != null) {
              break;
            }
            localaf1.dKu = new com.tencent.mm.cf.h();
            com.tencent.mm.kernel.g.DQ();
            localObject2 = com.tencent.mm.kernel.g.DP().cachePath;
            localObject2 = (String)localObject2 + "SnsMicroMsg.db";
            if (localaf1.dKu.b((String)localObject2, osc, true)) {
              break;
            }
            throw new SQLiteException("sns db init failed");
          }
        }
      }
      com.tencent.mm.kernel.g.DQ();
      if (com.tencent.mm.kernel.g.DN().Dc())
      {
        int i = bk.getInt(com.tencent.mm.m.g.AA().getValue("AndroidCleanSnsDb"), 0);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TrimSnsDb", "pass dynamic? " + i);
        if (i <= 0)
        {
          com.tencent.mm.kernel.g.DQ();
          String str = com.tencent.mm.kernel.g.DP().cachePath;
          if (com.tencent.mm.vfs.e.bK(str + "SnsMicroMsg2.db.ini"))
          {
            w.OY(str);
            com.tencent.mm.vfs.e.deleteFile(str + "SnsMicroMsg2.db.ini");
          }
          Object localObject4 = ae.getContext().getSharedPreferences(ae.cqR(), 0);
          if (bk.cn(((SharedPreferences)localObject4).getLong("check_trim_time", 0L)) < 604800L)
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TrimSnsDb", "trim sns pass because time short");
          }
          else
          {
            ((SharedPreferences)localObject4).edit().putLong("check_trim_time", bk.UX()).commit();
            ((w)localObject3).oLX = true;
            long l1 = System.currentTimeMillis();
            i = com.tencent.mm.q.a.Bu();
            if ((i == 1) || (i == 2))
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TrimSnsDb", "trim sns error space dangerous");
            }
            else if (com.tencent.mm.vfs.e.bK(str + "sns_mark.ini"))
            {
              if (bk.co(com.tencent.mm.vfs.e.aeR(str + "sns_mark.ini")) < 2592000000L)
              {
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TrimSnsDb", "mark file exist and return");
                w.OY(str);
              }
              else
              {
                com.tencent.mm.vfs.e.deleteFile(str + "sns_mark.ini");
              }
            }
            else
            {
              long l2 = com.tencent.mm.vfs.e.aeQ(str + "SnsMicroMsg.db");
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TrimSnsDb", "trim sns " + l2);
              if (l2 < 52428800L)
              {
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TrimSnsDb", "trim sns free pass: " + (System.currentTimeMillis() - l1));
              }
              else
              {
                com.tencent.mm.vfs.e.aeU(str + "sns_mark.ini");
                localObject4 = str + "SnsMicroMsg2.db";
                localObject3 = new com.tencent.mm.cf.h();
                if (!((com.tencent.mm.cf.h)localObject3).b((String)localObject4, null, false)) {
                  throw new com.tencent.mm.model.b((byte)0);
                }
                localObject4 = new com.tencent.mm.cf.h();
                if (!((com.tencent.mm.cf.h)localObject4).b(str + "SnsMicroMsg.db", (HashMap)localObject2, true)) {
                  throw new com.tencent.mm.model.b((byte)0);
                }
                l2 = System.currentTimeMillis();
                if (!w.a((com.tencent.mm.cf.h)localObject4, (com.tencent.mm.cf.h)localObject3)) {}
                for (i = -1;; i = 1)
                {
                  long l3 = System.currentTimeMillis() - l2;
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TrimSnsDb", "copysns insert all %d passed ret:" + i, new Object[] { Long.valueOf(l3) });
                  ((com.tencent.mm.cf.h)localObject4).closeDB();
                  ((com.tencent.mm.cf.h)localObject3).closeDB();
                  if (i >= 0)
                  {
                    com.tencent.mm.kernel.g.DQ();
                    localObject2 = com.tencent.mm.kernel.g.DP().cachePath;
                    com.tencent.mm.vfs.e.deleteFile((String)localObject2 + "SnsMicroMsg.db");
                    bool = com.tencent.mm.vfs.e.f((String)localObject2, "SnsMicroMsg2.db", "SnsMicroMsg.db");
                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TrimSnsDb", "rename file " + bool);
                    com.tencent.mm.vfs.e.deleteFile((String)localObject2 + "SnsMicroMsg.db-shm");
                    com.tencent.mm.vfs.e.deleteFile((String)localObject2 + "SnsMicroMsg.db-wal");
                    com.tencent.mm.vfs.e.deleteFile((String)localObject2 + "SnsMicroMsg.db.ini");
                    com.tencent.mm.vfs.e.r("SnsMicroMsg2.db.ini", "SnsMicroMsg.db.ini");
                    com.tencent.mm.vfs.e.deleteFile((String)localObject2 + "SnsMicroMsg2.db.ini");
                    com.tencent.mm.vfs.e.deleteFile((String)localObject2 + "SnsMicroMsg2.db");
                    com.tencent.mm.vfs.e.deleteFile((String)localObject2 + "sns_mark.ini");
                  }
                  l2 = System.currentTimeMillis() - l2;
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TrimSnsDb", "copysns data ret=%d all: %d copytime %d ", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l2 - l3) });
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TrimSnsDb", "trim sns done pass: " + (System.currentTimeMillis() - l1));
                  break;
                  l3 = System.currentTimeMillis();
                  w.a((com.tencent.mm.cf.h)localObject4, (com.tencent.mm.cf.h)localObject3, "snsExtInfo3");
                  boolean bool = ((com.tencent.mm.cf.h)localObject3).gk("", "insert into " + "snsExtInfo3" + " select * from old." + "snsExtInfo3");
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TrimSnsDb", "copysns ret_ext:" + bool + " passed " + (System.currentTimeMillis() - l3));
                  w.a((com.tencent.mm.cf.h)localObject4, (com.tencent.mm.cf.h)localObject3, "SnsComment");
                  bool = ((com.tencent.mm.cf.h)localObject3).gk("", "insert into " + "SnsComment" + " select * from old." + "SnsComment");
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TrimSnsDb", "copysns ret_msg:" + bool + " passed " + (System.currentTimeMillis() - l3));
                  w.a((com.tencent.mm.cf.h)localObject4, (com.tencent.mm.cf.h)localObject3, "SnsInfo");
                  bool = ((com.tencent.mm.cf.h)localObject3).gk("", "insert into " + "SnsInfo" + " select * from old." + "SnsInfo" + " where  (sourceType & 2 != 0 ) " + com.tencent.mm.plugin.sns.storage.o.oLA + " limit 200");
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TrimSnsDb", "copysns ret_sns:" + bool + " passed " + (System.currentTimeMillis() - l3));
                  bool = ((com.tencent.mm.cf.h)localObject3).gk("", "update snsExtinfo3 set md5 = '', faults = '';");
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.TrimSnsDb", "update ext info  passed  %s  updateRet %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l3), Boolean.valueOf(bool) });
                  ((com.tencent.mm.cf.h)localObject3).gk("", "DETACH DATABASE old");
                }
              }
            }
          }
        }
      }
    }
    localaf2.orV = false;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCore", "resetdb done");
    label1564:
    label1567:
    return localaf2;
  }
  
  public static boolean bDo()
  {
    bDn();
    return !com.tencent.mm.kernel.g.DN().Dc();
  }
  
  public static com.tencent.mm.sdk.platformtools.ah bDp()
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DS().crf();
  }
  
  public static com.tencent.mm.sdk.platformtools.ah bDq()
  {
    if ((oru >= ab.unv) || (oru >= 3)) {
      oru = 0;
    }
    com.tencent.mm.sdk.platformtools.ah[] arrayOfah = bDn().orw;
    int i = oru;
    oru = i + 1;
    return arrayOfah[i];
  }
  
  protected static com.tencent.mm.sdk.platformtools.ah bDr()
  {
    return bDn().ory;
  }
  
  public static com.tencent.mm.sdk.platformtools.ah bDs()
  {
    return bDn().orz;
  }
  
  public static bd bDt()
  {
    com.tencent.mm.kernel.g.DQ();
    return ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw();
  }
  
  public static s bDu()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orC == null) {
      bDn().orC = new s(bDn().dKu);
    }
    return bDn().orC;
  }
  
  public static am.a bDv()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orM == null)
    {
      bDn().orM = new am.a();
      com.tencent.mm.plugin.sns.b.n.omH = bDn().orM;
    }
    return bDn().orM;
  }
  
  public static com.tencent.mm.plugin.sns.f.c bDw()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orQ == null) {
      bDn().orQ = new com.tencent.mm.plugin.sns.f.c();
    }
    return bDn().orQ;
  }
  
  public static com.tencent.mm.plugin.sns.f.g bDx()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orR == null) {
      bDn().orR = new com.tencent.mm.plugin.sns.f.g();
    }
    return bDn().orR;
  }
  
  public static q bDy()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orS == null) {
      bDn().orS = new q(bDn().dKu);
    }
    return bDn().orS;
  }
  
  public static i bDz()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (bDn().orT == null) {
      bDn().orT = new i();
    }
    return bDn().orT;
  }
  
  private static Point biC()
  {
    WindowManager localWindowManager = (WindowManager)ae.getContext().getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    osl.x = localDisplayMetrics.widthPixels;
    osl.y = localDisplayMetrics.heightPixels;
    return osl;
  }
  
  private static void checkDir()
  {
    com.tencent.mm.vfs.e.nb(((com.tencent.mm.plugin.sns.b.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath());
    com.tencent.mm.vfs.e.nb(((com.tencent.mm.plugin.sns.b.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath());
  }
  
  public static String getAccSnsPath()
  {
    return ((com.tencent.mm.plugin.sns.b.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath();
  }
  
  public static String getAccSnsTmpPath()
  {
    return ((com.tencent.mm.plugin.sns.b.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath();
  }
  
  public final void a(com.tencent.mm.model.ap paramap)
  {
    u.a(paramap);
  }
  
  public final void b(com.tencent.mm.model.ap paramap)
  {
    u.b(paramap);
  }
  
  public final void bh(boolean paramBoolean)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCore", "onAccountPostReset " + Thread.currentThread().getId() + " isAccInit: " + this.orY);
    if (this.orY) {
      return;
    }
    this.orY = true;
    this.orV = true;
    com.tencent.mm.vfs.e.nb(FU() + "sfs");
    this.osa = getAccSnsPath();
    checkDir();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("NewYearSNSCtrl2016", this.osg, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("NewYearSNSTips2016", this.osh, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("NewYearSNSAmountLevelCtrl2016", this.osi, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("SnsAd", this.osj, true);
    com.tencent.mm.plugin.sns.b.n.omB = bDB();
    com.tencent.mm.plugin.sns.b.n.omC = bDC();
    com.tencent.mm.plugin.sns.b.n.omD = bDJ();
    com.tencent.mm.plugin.sns.b.n.omE = bDK();
    com.tencent.mm.plugin.sns.b.n.omF = bDL();
    com.tencent.mm.plugin.sns.b.n.omH = bDv();
    com.tencent.mm.plugin.sns.b.n.omG = this;
    com.tencent.mm.plugin.sns.b.n.omI = bDF();
    com.tencent.mm.sdk.b.a.udP.c(this.osN);
    com.tencent.mm.sdk.b.a.udP.c(this.osO);
    com.tencent.mm.sdk.b.a.udP.c(this.osB);
    com.tencent.mm.sdk.b.a.udP.c(this.osz);
    com.tencent.mm.sdk.b.a.udP.c(this.osA);
    com.tencent.mm.sdk.b.a.udP.c(this.osC);
    com.tencent.mm.sdk.b.a.udP.c(this.osD);
    com.tencent.mm.sdk.b.a.udP.c(this.osE);
    com.tencent.mm.sdk.b.a.udP.c(this.osF);
    com.tencent.mm.sdk.b.a.udP.c(this.osG);
    com.tencent.mm.sdk.b.a.udP.c(this.osH);
    com.tencent.mm.sdk.b.a.udP.c(this.osI);
    com.tencent.mm.sdk.b.a.udP.c(this.osJ);
    com.tencent.mm.sdk.b.a.udP.c(this.osR);
    this.osm = new n();
    this.osn = new com.tencent.mm.plugin.sns.k();
    this.oso = new com.tencent.mm.plugin.sns.e();
    this.osp = new com.tencent.mm.plugin.sns.p();
    this.osq = new com.tencent.mm.plugin.sns.h();
    this.osr = new com.tencent.mm.plugin.sns.g();
    this.oss = new com.tencent.mm.plugin.sns.m();
    this.ost = new com.tencent.mm.plugin.sns.j();
    this.osu = new com.tencent.mm.plugin.sns.b();
    this.osv = new com.tencent.mm.plugin.sns.c();
    this.osw = new com.tencent.mm.plugin.sns.f();
    com.tencent.mm.sdk.b.a.udP.c(this.osM);
    com.tencent.mm.sdk.b.a.udP.c(this.osL);
    com.tencent.mm.sdk.b.a.udP.c(this.osp);
    com.tencent.mm.sdk.b.a.udP.c(this.osm);
    com.tencent.mm.sdk.b.a.udP.c(this.osn);
    com.tencent.mm.sdk.b.a.udP.c(this.oso);
    com.tencent.mm.sdk.b.a.udP.c(this.osq);
    com.tencent.mm.sdk.b.a.udP.c(this.osr);
    com.tencent.mm.sdk.b.a.udP.c(this.oss);
    com.tencent.mm.sdk.b.a.udP.c(this.ost);
    com.tencent.mm.sdk.b.a.udP.c(this.osu);
    com.tencent.mm.sdk.b.a.udP.c(this.osv);
    com.tencent.mm.sdk.b.a.udP.c(this.osw);
    com.tencent.mm.sdk.b.a.udP.c(this.mzB);
    this.osd = new com.tencent.mm.plugin.sns.d();
    com.tencent.mm.sdk.b.a.udP.c(this.osd);
    com.tencent.mm.sdk.b.a.udP.c(this.osQ);
    com.tencent.mm.sdk.b.a.udP.c(this.osx);
    com.tencent.mm.sdk.b.a.udP.c(this.osy);
    com.tencent.mm.sdk.b.a.udP.c(this.osK);
    Object localObject1 = bDz();
    i.olB = com.tencent.mm.m.g.AA().getInt("MMUxAdLog2GSendSize", 20480);
    i.olC = com.tencent.mm.m.g.AA().getInt("MMUxAdLog3GSendSize", 30720);
    i.olD = com.tencent.mm.m.g.AA().getInt("MMUxAdLogWifiSendSize", 51200);
    i.olE = com.tencent.mm.m.g.AA().getInt("MMUxAdLogMinRandTime", 60);
    i.olF = com.tencent.mm.m.g.AA().getInt("MMUxAdLogMaxRandTime", 1800);
    i.olG = com.tencent.mm.m.g.AA().getInt("MMUxAdLogMaxExceptionTime", 43200);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsLogMgr", "init " + i.olB + ";" + i.olC + ";" + i.olD + ";" + i.olE + ";" + i.olF + ";" + i.olG);
    if (i.olF - i.olE < 0) {
      i.olF = i.olE;
    }
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(1802, (com.tencent.mm.ah.f)localObject1);
    localObject1 = bDB();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(207, (com.tencent.mm.ah.f)localObject1);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(209, (com.tencent.mm.ah.f)localObject1);
    localObject1 = this.orU;
    com.tencent.mm.sdk.b.a.udP.c(((ao)localObject1).oty);
    com.tencent.mm.sdk.b.a.udP.c(((ao)localObject1).otz);
    com.tencent.mm.sdk.b.a.udP.c(((ao)localObject1).otA);
    this.ose = new com.tencent.mm.plugin.sns.e.a();
    ap.init();
    localObject1 = com.tencent.mm.modelsns.c.eAU;
    com.tencent.mm.modelsns.c.QY();
    if (com.tencent.mm.memory.l.Fc())
    {
      localObject1 = com.tencent.mm.memory.c.dOU;
      localObject2 = com.tencent.mm.memory.c.dOU;
      localObject2.getClass();
      ((com.tencent.mm.memory.c)localObject1).a(new af.8(this, (com.tencent.mm.memory.c)localObject2));
    }
    localObject1 = com.tencent.mm.memory.o.dPr;
    Object localObject2 = com.tencent.mm.memory.o.dPr;
    localObject2.getClass();
    ((com.tencent.mm.memory.o)localObject1).a(new af.9(this, (com.tencent.mm.memory.o)localObject2));
    localObject1 = com.tencent.mm.memory.g.dPb;
    localObject2 = com.tencent.mm.memory.g.dPb;
    localObject2.getClass();
    ((com.tencent.mm.memory.g)localObject1).a(new af.10(this, (com.tencent.mm.memory.g)localObject2));
    bDD();
  }
  
  public final void bi(boolean paramBoolean)
  {
    com.tencent.mm.vfs.e.nb(FU() + "sfs");
    checkDir();
  }
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    ??? = bDz();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(1802, (com.tencent.mm.ah.f)???);
    ??? = this.orU;
    com.tencent.mm.sdk.b.a.udP.d(((ao)???).oty);
    com.tencent.mm.sdk.b.a.udP.d(((ao)???).otz);
    com.tencent.mm.sdk.b.a.udP.d(((ao)???).otA);
    com.tencent.mm.sdk.b.a.udP.d(this.osN);
    com.tencent.mm.sdk.b.a.udP.d(this.osO);
    com.tencent.mm.sdk.b.a.udP.d(this.osM);
    com.tencent.mm.sdk.b.a.udP.d(this.osL);
    com.tencent.mm.sdk.b.a.udP.d(this.osB);
    com.tencent.mm.sdk.b.a.udP.d(this.osz);
    com.tencent.mm.sdk.b.a.udP.d(this.osA);
    com.tencent.mm.sdk.b.a.udP.d(this.osC);
    com.tencent.mm.sdk.b.a.udP.d(this.osD);
    com.tencent.mm.sdk.b.a.udP.d(this.osE);
    com.tencent.mm.sdk.b.a.udP.d(this.osp);
    com.tencent.mm.sdk.b.a.udP.d(this.osq);
    com.tencent.mm.sdk.b.a.udP.d(this.osG);
    com.tencent.mm.sdk.b.a.udP.d(this.osH);
    com.tencent.mm.sdk.b.a.udP.d(this.osm);
    com.tencent.mm.sdk.b.a.udP.d(this.osn);
    com.tencent.mm.sdk.b.a.udP.d(this.oso);
    com.tencent.mm.sdk.b.a.udP.d(this.osr);
    com.tencent.mm.sdk.b.a.udP.d(this.oss);
    com.tencent.mm.sdk.b.a.udP.d(this.ost);
    com.tencent.mm.sdk.b.a.udP.d(this.osu);
    com.tencent.mm.sdk.b.a.udP.d(this.osv);
    com.tencent.mm.sdk.b.a.udP.d(this.osw);
    com.tencent.mm.sdk.b.a.udP.d(this.osF);
    com.tencent.mm.sdk.b.a.udP.d(this.osd);
    com.tencent.mm.sdk.b.a.udP.d(this.osI);
    com.tencent.mm.sdk.b.a.udP.d(this.osJ);
    com.tencent.mm.sdk.b.a.udP.d(this.mzB);
    com.tencent.mm.sdk.b.a.udP.d(this.osQ);
    com.tencent.mm.sdk.b.a.udP.d(this.osK);
    com.tencent.mm.sdk.b.a.udP.d(this.osx);
    com.tencent.mm.sdk.b.a.udP.d(this.osy);
    com.tencent.mm.sdk.b.a.udP.d(this.osR);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("NewYearSNSCtrl2016", this.osg, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("NewYearSNSTips2016", this.osh, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("NewYearSNSAmountLevelCtrl2016", this.osi, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("SnsAd", this.osj, true);
    ??? = bDB();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(207, (com.tencent.mm.ah.f)???);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(209, (com.tencent.mm.ah.f)???);
    ??? = (af)com.tencent.mm.model.p.B(af.class);
    if (??? != null)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsCore", "SnsCore close db");
      if (((af)???).dKu != null)
      {
        ((af)???).dKu.closeDB();
        ((af)???).dKu = null;
      }
      int i = 0;
      while (i < 3)
      {
        if (???.orw[i] != null) {
          ???.orw[i].getLooper().quit();
        }
        i += 1;
      }
      i = 0;
      while (i <= 0)
      {
        if (???.orx[0] != null) {
          ???.orx[0].getLooper().quit();
        }
        i += 1;
      }
      if (((af)???).ory != null) {
        ((af)???).ory.getLooper().quit();
      }
      if (((af)???).orz != null) {
        ((af)???).orz.getLooper().quit();
      }
    }
    ??? = this.ose;
    bDA().b((b.b)???);
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.sns.e.a)???).ono);
    ap.Vt();
    com.tencent.mm.memory.g.dPb.ET();
    com.tencent.mm.memory.c.dOU.ET();
    com.tencent.mm.memory.o.dPr.ET();
    ar localar = bDD();
    localar.otJ = null;
    localar.eGE = null;
    localar.otL.clear();
    localar.otK.clear();
    synchronized (localar.otM)
    {
      localar.otM.clear();
      com.tencent.mm.sdk.b.a.udP.d(localar.otN);
      com.tencent.mm.sdk.b.a.udP.d(localar.otz);
      com.tencent.mm.sdk.b.a.udP.d(localar.otA);
      return;
    }
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.af
 * JD-Core Version:    0.7.0.1
 */