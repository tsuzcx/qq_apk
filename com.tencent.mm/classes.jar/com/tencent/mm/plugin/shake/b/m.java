package com.tencent.mm.plugin.shake.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.g.a.ra;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.g.a.we;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bp.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;
import com.tencent.mm.storage.ce;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class m
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.sdk.b.c fJT;
  private bq.a hGh;
  private ap mHandler;
  private com.tencent.mm.sdk.b.c whK;
  private bp.a won;
  private e yMa;
  private g yMb;
  private com.tencent.mm.plugin.shake.c.a.f yMc;
  private com.tencent.mm.plugin.shake.c.a.d yMd;
  private o yMe;
  private n yMf;
  com.tencent.mm.pluginsdk.c.d yMg;
  private cd.a yMh;
  private com.tencent.mm.sdk.b.c yMi;
  private cd.a yMj;
  private cd.a yMk;
  
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
    this.yMf = new n();
    this.yMg = new com.tencent.mm.pluginsdk.c.d()
    {
      public final b alj(String paramAnonymousString)
      {
        AppMethodBeat.i(28149);
        tp localtp = new tp();
        localtp.dIa.dln = paramAnonymousString;
        AppMethodBeat.o(28149);
        return localtp;
      }
      
      public final k cWC()
      {
        AppMethodBeat.i(28150);
        g localg = m.dOP();
        AppMethodBeat.o(28150);
        return localg;
      }
    };
    this.fJT = new com.tencent.mm.sdk.b.c() {};
    this.yMh = new cd.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(28161);
        m.dOV();
        if (m.dOS() != null)
        {
          m.dOV();
          m.dOS();
          Object localObject = z.a(paramAnonymousa.gqE.Fvk);
          ad.v("MicroMsg.ShakeMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(localObject)));
          if (bt.isNullOrNil((String)localObject))
          {
            ad.d("MicroMsg.ShakeMsgMgr", "func[onResvMsg] Msg content empty");
            AppMethodBeat.o(28161);
            return;
          }
          localObject = bw.M((String)localObject, "sysmsg");
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
            localf.field_svrid = paramAnonymousa.gqE.xbt;
            localf.field_createtime = bt.aQJ();
            localf.field_tag = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.jumpurl"));
            localf.field_status = 0;
            localf.field_title = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.title"));
            localf.field_thumburl = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.iconurl"));
            localf.field_desc = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.desc"));
            localf.field_reserved1 = bt.nullAsNil((String)((Map)localObject).get(".sysmsg.shake.shaketv.pid"));
            m.dOP().a(localf);
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
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.won = new bp.a()
    {
      public final am Bf(String paramAnonymousString)
      {
        return null;
      }
      
      public final void a(bp paramAnonymousbp, am paramAnonymousam)
      {
        AppMethodBeat.i(28162);
        if ((paramAnonymousbp != null) && (paramAnonymousam != null) && (paramAnonymousam.adk())) {
          m.dOO().axj(paramAnonymousam.field_username);
        }
        AppMethodBeat.o(28162);
      }
      
      public final int b(am paramAnonymousam, boolean paramAnonymousBoolean)
      {
        return 0;
      }
    };
    this.hGh = new bq.a()
    {
      public final void a(at paramAnonymousat, bq paramAnonymousbq)
      {
        AppMethodBeat.i(28151);
        if ((paramAnonymousat != null) && (w.Ah(paramAnonymousat.field_username))) {
          paramAnonymousat.setUsername("");
        }
        AppMethodBeat.o(28151);
      }
    };
    this.yMi = new com.tencent.mm.sdk.b.c() {};
    this.yMj = new cd.a()
    {
      public final void a(final e.a paramAnonymousa)
      {
        AppMethodBeat.i(28154);
        final String str = z.a(paramAnonymousa.gqE.Fvk);
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
            m.dOT().m(str, paramAnonymousa.gqE.xbt, 0);
            AppMethodBeat.o(28153);
          }
        });
        AppMethodBeat.o(28154);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.yMk = new cd.a()
    {
      public final void a(final e.a paramAnonymousa)
      {
        AppMethodBeat.i(28156);
        final String str = z.a(paramAnonymousa.gqE.Fvk);
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
            m.dOT().m(str, paramAnonymousa.gqE.xbt, 1);
            AppMethodBeat.o(28155);
          }
        });
        AppMethodBeat.o(28156);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.whK = new m.6(this);
    AppMethodBeat.o(28163);
  }
  
  public static String FA(String paramString)
  {
    AppMethodBeat.i(28172);
    if (com.tencent.mm.model.ba.ajx())
    {
      com.tencent.mm.model.ba.aBQ();
      paramString = String.format("%s/Sk_%s", new Object[] { com.tencent.mm.model.c.azG(), com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) });
      AppMethodBeat.o(28172);
      return paramString;
    }
    AppMethodBeat.o(28172);
    return "";
  }
  
  private static m dON()
  {
    AppMethodBeat.i(28164);
    com.tencent.mm.model.ba.aBK();
    m localm2 = (m)ca.By("plugin.shake");
    m localm1 = localm2;
    if (localm2 == null)
    {
      localm1 = new m();
      com.tencent.mm.model.ba.aBK().a("plugin.shake", localm1);
    }
    AppMethodBeat.o(28164);
    return localm1;
  }
  
  public static e dOO()
  {
    AppMethodBeat.i(28165);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dON().yMa == null)
    {
      localObject = dON();
      com.tencent.mm.model.ba.aBQ();
      ((m)localObject).yMa = new e(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dON().yMa;
    AppMethodBeat.o(28165);
    return localObject;
  }
  
  public static g dOP()
  {
    AppMethodBeat.i(28166);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dON().yMb == null)
    {
      localObject = dON();
      com.tencent.mm.model.ba.aBQ();
      ((m)localObject).yMb = new g(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dON().yMb;
    AppMethodBeat.o(28166);
    return localObject;
  }
  
  public static o dOQ()
  {
    AppMethodBeat.i(28167);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dON().yMe == null)
    {
      localObject = dON();
      com.tencent.mm.model.ba.aBQ();
      ((m)localObject).yMe = new o(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dON().yMe;
    AppMethodBeat.o(28167);
    return localObject;
  }
  
  public static void dOR()
  {
    AppMethodBeat.i(28169);
    dOO().dOD();
    com.tencent.mm.bk.d.aMq().bcD();
    AppMethodBeat.o(28169);
  }
  
  public static i dOS()
  {
    AppMethodBeat.i(28171);
    com.tencent.mm.kernel.g.ajA().aiF();
    i locali = i.yLP;
    AppMethodBeat.o(28171);
    return locali;
  }
  
  public static com.tencent.mm.plugin.shake.c.a.f dOT()
  {
    AppMethodBeat.i(28174);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dON().yMc == null) {
      dON().yMc = new com.tencent.mm.plugin.shake.c.a.f();
    }
    com.tencent.mm.plugin.shake.c.a.f localf = dON().yMc;
    AppMethodBeat.o(28174);
    return localf;
  }
  
  public static com.tencent.mm.plugin.shake.c.a.d dOU()
  {
    AppMethodBeat.i(28175);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dON().yMd == null) {
      dON().yMd = new com.tencent.mm.plugin.shake.c.a.d();
    }
    com.tencent.mm.plugin.shake.c.a.d locald = dON().yMd;
    AppMethodBeat.o(28175);
    return locald;
  }
  
  public static String iY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(28173);
    if ((com.tencent.mm.model.ba.ajx()) && (!bt.isNullOrNil(paramString1)))
    {
      com.tencent.mm.model.ba.aBQ();
      paramString1 = String.format("%s/Sk%s_%s", new Object[] { com.tencent.mm.model.c.azG(), paramString2, com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) });
      AppMethodBeat.o(28173);
      return paramString1;
    }
    AppMethodBeat.o(28173);
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
    com.tencent.mm.pluginsdk.o.a.EJA = new h();
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azv().c(this.hGh);
    com.tencent.mm.sdk.b.a.IbL.c(this.fJT);
    com.tencent.mm.sdk.b.a.IbL.c(this.yMi);
    com.tencent.mm.sdk.b.a.IbL.c(this.yMf);
    com.tencent.mm.sdk.b.a.IbL.c(this.whK);
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azp().a(this.won);
    com.tencent.mm.model.ba.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28159);
        if (!com.tencent.mm.model.ba.ajx())
        {
          AppMethodBeat.o(28159);
          return;
        }
        com.tencent.mm.model.ba.aBQ();
        bt.n(com.tencent.mm.model.c.azG(), "Sk", 604800000L);
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
    com.tencent.mm.model.ba.getSysCmdMsgExtension().a("shake", this.yMh, true);
    com.tencent.mm.model.ba.getSysCmdMsgExtension().a("ShakeCardEntrance", this.yMj, true);
    com.tencent.mm.model.ba.getSysCmdMsgExtension().a("ShakeCardRedDot", this.yMk, true);
    this.yMc = null;
    this.yMd = null;
    AppMethodBeat.o(28170);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(28168);
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azv().d(this.hGh);
    com.tencent.mm.sdk.b.a.IbL.d(this.fJT);
    com.tencent.mm.sdk.b.a.IbL.d(this.yMi);
    com.tencent.mm.sdk.b.a.IbL.d(this.yMf);
    com.tencent.mm.sdk.b.a.IbL.d(this.whK);
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azp().b(this.won);
    com.tencent.mm.model.ba.getSysCmdMsgExtension().b("shake", this.yMh, true);
    com.tencent.mm.model.ba.getSysCmdMsgExtension().b("ShakeCardEntrance", this.yMj, true);
    com.tencent.mm.model.ba.getSysCmdMsgExtension().b("ShakeCardRedDot", this.yMk, true);
    com.tencent.mm.pluginsdk.o.a.EJA = null;
    AppMethodBeat.o(28168);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.m
 * JD-Core Version:    0.7.0.1
 */