package com.tencent.mm.plugin.shake.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bj.a;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bk.a;
import com.tencent.mm.storage.by;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class m
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.sdk.b.c frK;
  private bk.a hnP;
  private ao mHandler;
  private com.tencent.mm.sdk.b.c vco;
  private bj.a viU;
  private e xxp;
  private g xxq;
  private com.tencent.mm.plugin.shake.c.a.f xxr;
  private com.tencent.mm.plugin.shake.c.a.d xxs;
  private o xxt;
  private n xxu;
  com.tencent.mm.pluginsdk.c.d xxv;
  private cc.a xxw;
  private com.tencent.mm.sdk.b.c xxx;
  private cc.a xxy;
  private cc.a xxz;
  
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
    this.mHandler = new ao(Looper.getMainLooper());
    this.xxu = new n();
    this.xxv = new com.tencent.mm.pluginsdk.c.d()
    {
      public final b agM(String paramAnonymousString)
      {
        AppMethodBeat.i(28149);
        sy localsy = new sy();
        localsy.dvR.cZV = paramAnonymousString;
        AppMethodBeat.o(28149);
        return localsy;
      }
      
      public final k cOj()
      {
        AppMethodBeat.i(28150);
        g localg = m.dDm();
        AppMethodBeat.o(28150);
        return localg;
      }
    };
    this.frK = new com.tencent.mm.sdk.b.c() {};
    this.xxw = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(28161);
        m.dDs();
        if (m.dDp() != null)
        {
          m.dDs();
          m.dDp();
          Object localObject = z.a(paramAnonymousa.fXi.DPV);
          ac.v("MicroMsg.ShakeMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(localObject)));
          if (bs.isNullOrNil((String)localObject))
          {
            ac.d("MicroMsg.ShakeMsgMgr", "func[onResvMsg] Msg content empty");
            AppMethodBeat.o(28161);
            return;
          }
          localObject = bv.L((String)localObject, "sysmsg");
          int i = bs.getInt((String)((Map)localObject).get(".sysmsg.shake.$type"), 0);
          switch (i)
          {
          default: 
            ac.d("MicroMsg.ShakeMsgMgr", "Unrecognized type :".concat(String.valueOf(i)));
            AppMethodBeat.o(28161);
            return;
          }
          f localf = new f();
          i = bs.getInt((String)((Map)localObject).get(".sysmsg.shake.shaketv.msgtype"), 0);
          if (i == 0)
          {
            localf.field_type = 1;
            localf.field_subtype = i;
            localf.field_svrid = paramAnonymousa.fXi.vTQ;
            localf.field_createtime = bs.aNx();
            localf.field_tag = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.jumpurl"));
            localf.field_status = 0;
            localf.field_title = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.title"));
            localf.field_thumburl = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.iconurl"));
            localf.field_desc = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.desc"));
            localf.field_reserved1 = bs.nullAsNil((String)((Map)localObject).get(".sysmsg.shake.shaketv.pid"));
            m.dDm().a(localf);
            AppMethodBeat.o(28161);
            return;
          }
          ac.w("MicroMsg.ShakeMsgMgr", "Unknown subType:".concat(String.valueOf(i)));
          AppMethodBeat.o(28161);
          return;
        }
        ac.w("MicroMsg.SubCoreShake", "func[onRecieveMsg] getShakeMsgMgr null");
        AppMethodBeat.o(28161);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.viU = new bj.a()
    {
      public final void a(bj paramAnonymousbj, ai paramAnonymousai)
      {
        AppMethodBeat.i(28162);
        if ((paramAnonymousbj != null) && (paramAnonymousai != null) && (paramAnonymousai.aaH())) {
          m.dDl().asj(paramAnonymousai.field_username);
        }
        AppMethodBeat.o(28162);
      }
    };
    this.hnP = new bk.a()
    {
      public final void a(com.tencent.mm.storage.ap paramAnonymousap, bk paramAnonymousbk)
      {
        AppMethodBeat.i(28151);
        if ((paramAnonymousap != null) && (w.xk(paramAnonymousap.field_username))) {
          paramAnonymousap.setUsername("");
        }
        AppMethodBeat.o(28151);
      }
    };
    this.xxx = new com.tencent.mm.sdk.b.c() {};
    this.xxy = new cc.a()
    {
      public final void a(final f.a paramAnonymousa)
      {
        AppMethodBeat.i(28154);
        final String str = z.a(paramAnonymousa.fXi.DPV);
        if ((str == null) || (str.length() == 0))
        {
          ac.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardEntranceMsg msgContent is null");
          AppMethodBeat.o(28154);
          return;
        }
        m.a(m.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28153);
            m.dDq().k(str, paramAnonymousa.fXi.vTQ, 0);
            AppMethodBeat.o(28153);
          }
        });
        AppMethodBeat.o(28154);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.xxz = new cc.a()
    {
      public final void a(final f.a paramAnonymousa)
      {
        AppMethodBeat.i(28156);
        final String str = z.a(paramAnonymousa.fXi.DPV);
        if ((str == null) || (str.length() == 0))
        {
          ac.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
          AppMethodBeat.o(28156);
          return;
        }
        m.a(m.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28155);
            m.dDq().k(str, paramAnonymousa.fXi.vTQ, 1);
            AppMethodBeat.o(28155);
          }
        });
        AppMethodBeat.o(28156);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.vco = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(28163);
  }
  
  public static String Cw(String paramString)
  {
    AppMethodBeat.i(28172);
    if (com.tencent.mm.model.az.agM())
    {
      com.tencent.mm.model.az.ayM();
      paramString = String.format("%s/Sk_%s", new Object[] { com.tencent.mm.model.c.awR(), com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) });
      AppMethodBeat.o(28172);
      return paramString;
    }
    AppMethodBeat.o(28172);
    return "";
  }
  
  private static m dDk()
  {
    AppMethodBeat.i(28164);
    com.tencent.mm.model.az.ayG();
    m localm2 = (m)bz.yz("plugin.shake");
    m localm1 = localm2;
    if (localm2 == null)
    {
      localm1 = new m();
      com.tencent.mm.model.az.ayG().a("plugin.shake", localm1);
    }
    AppMethodBeat.o(28164);
    return localm1;
  }
  
  public static e dDl()
  {
    AppMethodBeat.i(28165);
    com.tencent.mm.kernel.g.agP().afT();
    if (dDk().xxp == null)
    {
      localObject = dDk();
      com.tencent.mm.model.az.ayM();
      ((m)localObject).xxp = new e(com.tencent.mm.model.c.agw());
    }
    Object localObject = dDk().xxp;
    AppMethodBeat.o(28165);
    return localObject;
  }
  
  public static g dDm()
  {
    AppMethodBeat.i(28166);
    com.tencent.mm.kernel.g.agP().afT();
    if (dDk().xxq == null)
    {
      localObject = dDk();
      com.tencent.mm.model.az.ayM();
      ((m)localObject).xxq = new g(com.tencent.mm.model.c.agw());
    }
    Object localObject = dDk().xxq;
    AppMethodBeat.o(28166);
    return localObject;
  }
  
  public static o dDn()
  {
    AppMethodBeat.i(28167);
    com.tencent.mm.kernel.g.agP().afT();
    if (dDk().xxt == null)
    {
      localObject = dDk();
      com.tencent.mm.model.az.ayM();
      ((m)localObject).xxt = new o(com.tencent.mm.model.c.agw());
    }
    Object localObject = dDk().xxt;
    AppMethodBeat.o(28167);
    return localObject;
  }
  
  public static void dDo()
  {
    AppMethodBeat.i(28169);
    dDl().dDa();
    com.tencent.mm.bj.d.aJg().aZf();
    AppMethodBeat.o(28169);
  }
  
  public static i dDp()
  {
    AppMethodBeat.i(28171);
    com.tencent.mm.kernel.g.agP().afT();
    i locali = i.xxe;
    AppMethodBeat.o(28171);
    return locali;
  }
  
  public static com.tencent.mm.plugin.shake.c.a.f dDq()
  {
    AppMethodBeat.i(28174);
    com.tencent.mm.kernel.g.agP().afT();
    if (dDk().xxr == null) {
      dDk().xxr = new com.tencent.mm.plugin.shake.c.a.f();
    }
    com.tencent.mm.plugin.shake.c.a.f localf = dDk().xxr;
    AppMethodBeat.o(28174);
    return localf;
  }
  
  public static com.tencent.mm.plugin.shake.c.a.d dDr()
  {
    AppMethodBeat.i(28175);
    com.tencent.mm.kernel.g.agP().afT();
    if (dDk().xxs == null) {
      dDk().xxs = new com.tencent.mm.plugin.shake.c.a.d();
    }
    com.tencent.mm.plugin.shake.c.a.d locald = dDk().xxs;
    AppMethodBeat.o(28175);
    return locald;
  }
  
  public static String iL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(28173);
    if ((com.tencent.mm.model.az.agM()) && (!bs.isNullOrNil(paramString1)))
    {
      com.tencent.mm.model.az.ayM();
      paramString1 = String.format("%s/Sk%s_%s", new Object[] { com.tencent.mm.model.c.awR(), paramString2, com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) });
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
    com.tencent.mm.pluginsdk.n.a.DfE = new h();
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awG().c(this.hnP);
    com.tencent.mm.sdk.b.a.GpY.c(this.frK);
    com.tencent.mm.sdk.b.a.GpY.c(this.xxx);
    com.tencent.mm.sdk.b.a.GpY.c(this.xxu);
    com.tencent.mm.sdk.b.a.GpY.c(this.vco);
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awB().a(this.viU);
    com.tencent.mm.model.az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28159);
        if (!com.tencent.mm.model.az.agM())
        {
          AppMethodBeat.o(28159);
          return;
        }
        com.tencent.mm.model.az.ayM();
        bs.z(com.tencent.mm.model.c.awR(), "Sk", 604800000L);
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
    com.tencent.mm.model.az.getSysCmdMsgExtension().a("shake", this.xxw, true);
    com.tencent.mm.model.az.getSysCmdMsgExtension().a("ShakeCardEntrance", this.xxy, true);
    com.tencent.mm.model.az.getSysCmdMsgExtension().a("ShakeCardRedDot", this.xxz, true);
    this.xxr = null;
    this.xxs = null;
    AppMethodBeat.o(28170);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(28168);
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awG().d(this.hnP);
    com.tencent.mm.sdk.b.a.GpY.d(this.frK);
    com.tencent.mm.sdk.b.a.GpY.d(this.xxx);
    com.tencent.mm.sdk.b.a.GpY.d(this.xxu);
    com.tencent.mm.sdk.b.a.GpY.d(this.vco);
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awB().b(this.viU);
    com.tencent.mm.model.az.getSysCmdMsgExtension().b("shake", this.xxw, true);
    com.tencent.mm.model.az.getSysCmdMsgExtension().b("ShakeCardEntrance", this.xxy, true);
    com.tencent.mm.model.az.getSysCmdMsgExtension().b("ShakeCardRedDot", this.xxz, true);
    com.tencent.mm.pluginsdk.n.a.DfE = null;
    AppMethodBeat.o(28168);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.m
 * JD-Core Version:    0.7.0.1
 */