package com.tencent.mm.plugin.shake.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bg.a;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bh.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class m
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.sdk.b.c fop;
  private bh.a gNp;
  private ap mHandler;
  private com.tencent.mm.sdk.b.c tTG;
  private bg.a tZU;
  private e wlZ;
  private g wma;
  private com.tencent.mm.plugin.shake.c.a.f wmb;
  private com.tencent.mm.plugin.shake.c.a.d wmc;
  private o wmd;
  private n wme;
  com.tencent.mm.pluginsdk.c.d wmf;
  private cc.a wmg;
  private com.tencent.mm.sdk.b.c wmh;
  private cc.a wmi;
  private cc.a wmj;
  
  static
  {
    AppMethodBeat.i(28177);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("SHAKEITEM_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return e.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("SHAKEMSG_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return g.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("SHAKETVHISTORY_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return o.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("SHAKENEWYEARFRIENDINFO_TABLE".hashCode()), new m.11());
    AppMethodBeat.o(28177);
  }
  
  public m()
  {
    AppMethodBeat.i(28163);
    this.mHandler = new ap(Looper.getMainLooper());
    this.wme = new n();
    this.wmf = new com.tencent.mm.pluginsdk.c.d()
    {
      public final b abU(String paramAnonymousString)
      {
        AppMethodBeat.i(28149);
        sp localsp = new sp();
        localsp.dyf.dcx = paramAnonymousString;
        AppMethodBeat.o(28149);
        return localsp;
      }
      
      public final k cBa()
      {
        AppMethodBeat.i(28150);
        g localg = m.dpc();
        AppMethodBeat.o(28150);
        return localg;
      }
    };
    this.fop = new com.tencent.mm.sdk.b.c() {};
    this.wmg = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(28161);
        m.dpi();
        if (m.dpf() != null)
        {
          m.dpi();
          m.dpf();
          Object localObject = z.a(paramAnonymousa.fTo.Cxz);
          ad.v("MicroMsg.ShakeMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(localObject)));
          if (bt.isNullOrNil((String)localObject))
          {
            ad.d("MicroMsg.ShakeMsgMgr", "func[onResvMsg] Msg content empty");
            AppMethodBeat.o(28161);
            return;
          }
          localObject = bw.K((String)localObject, "sysmsg");
          int i = bt.getInt((String)((Map)localObject).get(".sysmsg.shake.$type"), 0);
          switch (i)
          {
          default: 
            ad.d("MicroMsg.ShakeMsgMgr", "Unrecognized type :".concat(String.valueOf(i)));
            AppMethodBeat.o(28161);
            return;
          }
          f localf = new f();
          i = bt.getInt((String)((Map)localObject).get(".sysmsg.shake.shaketv.msgtype"), 0);
          if (i == 0)
          {
            localf.field_type = 1;
            localf.field_subtype = i;
            localf.field_svrid = paramAnonymousa.fTo.uKZ;
            localf.field_createtime = bt.aGK();
            localf.field_tag = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.jumpurl"));
            localf.field_status = 0;
            localf.field_title = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.title"));
            localf.field_thumburl = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.iconurl"));
            localf.field_desc = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.desc"));
            localf.field_reserved1 = bt.nullAsNil((String)((Map)localObject).get(".sysmsg.shake.shaketv.pid"));
            m.dpc().a(localf);
            AppMethodBeat.o(28161);
            return;
          }
          ad.w("MicroMsg.ShakeMsgMgr", "Unknown subType:".concat(String.valueOf(i)));
          AppMethodBeat.o(28161);
          return;
        }
        ad.w("MicroMsg.SubCoreShake", "func[onRecieveMsg] getShakeMsgMgr null");
        AppMethodBeat.o(28161);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.tZU = new bg.a()
    {
      public final void a(bg paramAnonymousbg, af paramAnonymousaf)
      {
        AppMethodBeat.i(28162);
        if ((paramAnonymousbg != null) && (paramAnonymousaf != null) && (paramAnonymousaf.ZM())) {
          m.dpb().ana(paramAnonymousaf.field_username);
        }
        AppMethodBeat.o(28162);
      }
    };
    this.gNp = new bh.a()
    {
      public final void a(am paramAnonymousam, bh paramAnonymousbh)
      {
        AppMethodBeat.i(28151);
        if ((paramAnonymousam != null) && (w.th(paramAnonymousam.field_username))) {
          paramAnonymousam.setUsername("");
        }
        AppMethodBeat.o(28151);
      }
    };
    this.wmh = new com.tencent.mm.sdk.b.c() {};
    this.wmi = new cc.a()
    {
      public final void a(final f.a paramAnonymousa)
      {
        AppMethodBeat.i(28154);
        final String str = z.a(paramAnonymousa.fTo.Cxz);
        if ((str == null) || (str.length() == 0))
        {
          ad.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardEntranceMsg msgContent is null");
          AppMethodBeat.o(28154);
          return;
        }
        m.a(m.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28153);
            m.dpg().k(str, paramAnonymousa.fTo.uKZ, 0);
            AppMethodBeat.o(28153);
          }
        });
        AppMethodBeat.o(28154);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.wmj = new cc.a()
    {
      public final void a(final f.a paramAnonymousa)
      {
        AppMethodBeat.i(28156);
        final String str = z.a(paramAnonymousa.fTo.Cxz);
        if ((str == null) || (str.length() == 0))
        {
          ad.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
          AppMethodBeat.o(28156);
          return;
        }
        m.a(m.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28155);
            m.dpg().k(str, paramAnonymousa.fTo.uKZ, 1);
            AppMethodBeat.o(28155);
          }
        });
        AppMethodBeat.o(28156);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.tTG = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(28163);
  }
  
  private static m dpa()
  {
    AppMethodBeat.i(28164);
    az.arP();
    m localm2 = (m)bz.ut("plugin.shake");
    m localm1 = localm2;
    if (localm2 == null)
    {
      localm1 = new m();
      az.arP().a("plugin.shake", localm1);
    }
    AppMethodBeat.o(28164);
    return localm1;
  }
  
  public static e dpb()
  {
    AppMethodBeat.i(28165);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dpa().wlZ == null)
    {
      localObject = dpa();
      az.arV();
      ((m)localObject).wlZ = new e(com.tencent.mm.model.c.afg());
    }
    Object localObject = dpa().wlZ;
    AppMethodBeat.o(28165);
    return localObject;
  }
  
  public static g dpc()
  {
    AppMethodBeat.i(28166);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dpa().wma == null)
    {
      localObject = dpa();
      az.arV();
      ((m)localObject).wma = new g(com.tencent.mm.model.c.afg());
    }
    Object localObject = dpa().wma;
    AppMethodBeat.o(28166);
    return localObject;
  }
  
  public static o dpd()
  {
    AppMethodBeat.i(28167);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dpa().wmd == null)
    {
      localObject = dpa();
      az.arV();
      ((m)localObject).wmd = new o(com.tencent.mm.model.c.afg());
    }
    Object localObject = dpa().wmd;
    AppMethodBeat.o(28167);
    return localObject;
  }
  
  public static void dpe()
  {
    AppMethodBeat.i(28169);
    dpb().doQ();
    com.tencent.mm.bk.d.aCq().aSi();
    AppMethodBeat.o(28169);
  }
  
  public static i dpf()
  {
    AppMethodBeat.i(28171);
    com.tencent.mm.kernel.g.afz().aeD();
    i locali = i.wlO;
    AppMethodBeat.o(28171);
    return locali;
  }
  
  public static com.tencent.mm.plugin.shake.c.a.f dpg()
  {
    AppMethodBeat.i(28174);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dpa().wmb == null) {
      dpa().wmb = new com.tencent.mm.plugin.shake.c.a.f();
    }
    com.tencent.mm.plugin.shake.c.a.f localf = dpa().wmb;
    AppMethodBeat.o(28174);
    return localf;
  }
  
  public static com.tencent.mm.plugin.shake.c.a.d dph()
  {
    AppMethodBeat.i(28175);
    com.tencent.mm.kernel.g.afz().aeD();
    if (dpa().wmc == null) {
      dpa().wmc = new com.tencent.mm.plugin.shake.c.a.d();
    }
    com.tencent.mm.plugin.shake.c.a.d locald = dpa().wmc;
    AppMethodBeat.o(28175);
    return locald;
  }
  
  public static String ir(String paramString1, String paramString2)
  {
    AppMethodBeat.i(28173);
    if ((az.afw()) && (!bt.isNullOrNil(paramString1)))
    {
      az.arV();
      paramString1 = String.format("%s/Sk%s_%s", new Object[] { com.tencent.mm.model.c.aqc(), paramString2, com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) });
      AppMethodBeat.o(28173);
      return paramString1;
    }
    AppMethodBeat.o(28173);
    return "";
  }
  
  public static String yr(String paramString)
  {
    AppMethodBeat.i(28172);
    if (az.afw())
    {
      az.arV();
      paramString = String.format("%s/Sk_%s", new Object[] { com.tencent.mm.model.c.aqc(), com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) });
      AppMethodBeat.o(28172);
      return paramString;
    }
    AppMethodBeat.o(28172);
    return "";
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(28170);
    com.tencent.mm.pluginsdk.n.a.BNu = new h();
    az.arV();
    com.tencent.mm.model.c.apR().c(this.gNp);
    com.tencent.mm.sdk.b.a.ESL.c(this.fop);
    com.tencent.mm.sdk.b.a.ESL.c(this.wmh);
    com.tencent.mm.sdk.b.a.ESL.c(this.wme);
    com.tencent.mm.sdk.b.a.ESL.c(this.tTG);
    az.arV();
    com.tencent.mm.model.c.apM().a(this.tZU);
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28159);
        if (!az.afw())
        {
          AppMethodBeat.o(28159);
          return;
        }
        az.arV();
        bt.z(com.tencent.mm.model.c.aqc(), "Sk", 604800000L);
        AppMethodBeat.o(28159);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(28160);
        String str = super.toString() + "|onAccountPostReset";
        AppMethodBeat.o(28160);
        return str;
      }
    });
    az.getSysCmdMsgExtension().a("shake", this.wmg, true);
    az.getSysCmdMsgExtension().a("ShakeCardEntrance", this.wmi, true);
    az.getSysCmdMsgExtension().a("ShakeCardRedDot", this.wmj, true);
    this.wmb = null;
    this.wmc = null;
    AppMethodBeat.o(28170);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(28168);
    az.arV();
    com.tencent.mm.model.c.apR().d(this.gNp);
    com.tencent.mm.sdk.b.a.ESL.d(this.fop);
    com.tencent.mm.sdk.b.a.ESL.d(this.wmh);
    com.tencent.mm.sdk.b.a.ESL.d(this.wme);
    com.tencent.mm.sdk.b.a.ESL.d(this.tTG);
    az.arV();
    com.tencent.mm.model.c.apM().b(this.tZU);
    az.getSysCmdMsgExtension().b("shake", this.wmg, true);
    az.getSysCmdMsgExtension().b("ShakeCardEntrance", this.wmi, true);
    az.getSysCmdMsgExtension().b("ShakeCardRedDot", this.wmj, true);
    com.tencent.mm.pluginsdk.n.a.BNu = null;
    AppMethodBeat.o(28168);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.m
 * JD-Core Version:    0.7.0.1
 */