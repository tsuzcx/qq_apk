package com.tencent.mm.plugin.shake.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class m
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.sdk.b.c fLW;
  private br.a hIZ;
  private aq mHandler;
  private bq.a wDW;
  private com.tencent.mm.sdk.b.c wxo;
  private e zck;
  private g zcl;
  private com.tencent.mm.plugin.shake.c.a.f zcm;
  private com.tencent.mm.plugin.shake.c.a.d zcn;
  private o zco;
  private n zcp;
  com.tencent.mm.pluginsdk.c.d zcq;
  private cf.a zcr;
  private com.tencent.mm.sdk.b.c zcs;
  private cf.a zct;
  private cf.a zcu;
  
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
    this.mHandler = new aq(Looper.getMainLooper());
    this.zcp = new n();
    this.zcq = new com.tencent.mm.pluginsdk.c.d()
    {
      public final b amh(String paramAnonymousString)
      {
        AppMethodBeat.i(28149);
        tq localtq = new tq();
        localtq.dJe.dmp = paramAnonymousString;
        AppMethodBeat.o(28149);
        return localtq;
      }
      
      public final k cZh()
      {
        AppMethodBeat.i(28150);
        g localg = m.dSm();
        AppMethodBeat.o(28150);
        return localg;
      }
    };
    this.fLW = new com.tencent.mm.sdk.b.c() {};
    this.zcr = new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(28161);
        m.dSs();
        if (m.dSp() != null)
        {
          m.dSs();
          m.dSp();
          Object localObject = z.a(paramAnonymousa.gte.FNI);
          ae.v("MicroMsg.ShakeMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(localObject)));
          if (bu.isNullOrNil((String)localObject))
          {
            ae.d("MicroMsg.ShakeMsgMgr", "func[onResvMsg] Msg content empty");
            AppMethodBeat.o(28161);
            return;
          }
          localObject = bx.M((String)localObject, "sysmsg");
          int i = bu.getInt((String)((Map)localObject).get(".sysmsg.shake.$type"), 0);
          switch (i)
          {
          default: 
            ae.d("MicroMsg.ShakeMsgMgr", "Unrecognized type :".concat(String.valueOf(i)));
            AppMethodBeat.o(28161);
            return;
          }
          f localf = new f();
          i = bu.getInt((String)((Map)localObject).get(".sysmsg.shake.shaketv.msgtype"), 0);
          if (i == 0)
          {
            localf.field_type = 1;
            localf.field_subtype = i;
            localf.field_svrid = paramAnonymousa.gte.xrk;
            localf.field_createtime = bu.aRi();
            localf.field_tag = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.jumpurl"));
            localf.field_status = 0;
            localf.field_title = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.title"));
            localf.field_thumburl = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.iconurl"));
            localf.field_desc = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.desc"));
            localf.field_reserved1 = bu.nullAsNil((String)((Map)localObject).get(".sysmsg.shake.shaketv.pid"));
            m.dSm().a(localf);
            AppMethodBeat.o(28161);
            return;
          }
          ae.w("MicroMsg.ShakeMsgMgr", "Unknown subType:".concat(String.valueOf(i)));
          AppMethodBeat.o(28161);
          return;
        }
        ae.w("MicroMsg.SubCoreShake", "func[onRecieveMsg] getShakeMsgMgr null");
        AppMethodBeat.o(28161);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.wDW = new bq.a()
    {
      public final an BH(String paramAnonymousString)
      {
        return null;
      }
      
      public final void a(bq paramAnonymousbq, an paramAnonymousan)
      {
        AppMethodBeat.i(28162);
        if ((paramAnonymousbq != null) && (paramAnonymousan != null) && (paramAnonymousan.adv())) {
          m.dSl().ayz(paramAnonymousan.field_username);
        }
        AppMethodBeat.o(28162);
      }
      
      public final int b(an paramAnonymousan, boolean paramAnonymousBoolean)
      {
        return 0;
      }
    };
    this.hIZ = new br.a()
    {
      public final void a(au paramAnonymousau, br paramAnonymousbr)
      {
        AppMethodBeat.i(28151);
        if ((paramAnonymousau != null) && (x.AR(paramAnonymousau.field_username))) {
          paramAnonymousau.setUsername("");
        }
        AppMethodBeat.o(28151);
      }
    };
    this.zcs = new com.tencent.mm.sdk.b.c() {};
    this.zct = new cf.a()
    {
      public final void a(final e.a paramAnonymousa)
      {
        AppMethodBeat.i(28154);
        final String str = z.a(paramAnonymousa.gte.FNI);
        if ((str == null) || (str.length() == 0))
        {
          ae.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardEntranceMsg msgContent is null");
          AppMethodBeat.o(28154);
          return;
        }
        m.a(m.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28153);
            m.dSq().m(str, paramAnonymousa.gte.xrk, 0);
            AppMethodBeat.o(28153);
          }
        });
        AppMethodBeat.o(28154);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.zcu = new cf.a()
    {
      public final void a(final e.a paramAnonymousa)
      {
        AppMethodBeat.i(28156);
        final String str = z.a(paramAnonymousa.gte.FNI);
        if ((str == null) || (str.length() == 0))
        {
          ae.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
          AppMethodBeat.o(28156);
          return;
        }
        m.a(m.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28155);
            m.dSq().m(str, paramAnonymousa.gte.xrk, 1);
            AppMethodBeat.o(28155);
          }
        });
        AppMethodBeat.o(28156);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.wxo = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(28163);
  }
  
  public static String Gc(String paramString)
  {
    AppMethodBeat.i(28172);
    if (bc.ajM())
    {
      bc.aCg();
      paramString = String.format("%s/Sk_%s", new Object[] { com.tencent.mm.model.c.azW(), com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) });
      AppMethodBeat.o(28172);
      return paramString;
    }
    AppMethodBeat.o(28172);
    return "";
  }
  
  private static m dSk()
  {
    AppMethodBeat.i(28164);
    bc.aCa();
    m localm2 = (m)cc.Ca("plugin.shake");
    m localm1 = localm2;
    if (localm2 == null)
    {
      localm1 = new m();
      bc.aCa().a("plugin.shake", localm1);
    }
    AppMethodBeat.o(28164);
    return localm1;
  }
  
  public static e dSl()
  {
    AppMethodBeat.i(28165);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dSk().zck == null)
    {
      localObject = dSk();
      bc.aCg();
      ((m)localObject).zck = new e(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dSk().zck;
    AppMethodBeat.o(28165);
    return localObject;
  }
  
  public static g dSm()
  {
    AppMethodBeat.i(28166);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dSk().zcl == null)
    {
      localObject = dSk();
      bc.aCg();
      ((m)localObject).zcl = new g(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dSk().zcl;
    AppMethodBeat.o(28166);
    return localObject;
  }
  
  public static o dSn()
  {
    AppMethodBeat.i(28167);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dSk().zco == null)
    {
      localObject = dSk();
      bc.aCg();
      ((m)localObject).zco = new o(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dSk().zco;
    AppMethodBeat.o(28167);
    return localObject;
  }
  
  public static void dSo()
  {
    AppMethodBeat.i(28169);
    dSl().dSa();
    com.tencent.mm.bj.d.aMO().bdi();
    AppMethodBeat.o(28169);
  }
  
  public static i dSp()
  {
    AppMethodBeat.i(28171);
    com.tencent.mm.kernel.g.ajP().aiU();
    i locali = i.zbZ;
    AppMethodBeat.o(28171);
    return locali;
  }
  
  public static com.tencent.mm.plugin.shake.c.a.f dSq()
  {
    AppMethodBeat.i(28174);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dSk().zcm == null) {
      dSk().zcm = new com.tencent.mm.plugin.shake.c.a.f();
    }
    com.tencent.mm.plugin.shake.c.a.f localf = dSk().zcm;
    AppMethodBeat.o(28174);
    return localf;
  }
  
  public static com.tencent.mm.plugin.shake.c.a.d dSr()
  {
    AppMethodBeat.i(28175);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dSk().zcn == null) {
      dSk().zcn = new com.tencent.mm.plugin.shake.c.a.d();
    }
    com.tencent.mm.plugin.shake.c.a.d locald = dSk().zcn;
    AppMethodBeat.o(28175);
    return locald;
  }
  
  public static String je(String paramString1, String paramString2)
  {
    AppMethodBeat.i(28173);
    if ((bc.ajM()) && (!bu.isNullOrNil(paramString1)))
    {
      bc.aCg();
      paramString1 = String.format("%s/Sk%s_%s", new Object[] { com.tencent.mm.model.c.azW(), paramString2, com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) });
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
    com.tencent.mm.pluginsdk.o.a.FbY = new h();
    bc.aCg();
    com.tencent.mm.model.c.azL().c(this.hIZ);
    com.tencent.mm.sdk.b.a.IvT.c(this.fLW);
    com.tencent.mm.sdk.b.a.IvT.c(this.zcs);
    com.tencent.mm.sdk.b.a.IvT.c(this.zcp);
    com.tencent.mm.sdk.b.a.IvT.c(this.wxo);
    bc.aCg();
    com.tencent.mm.model.c.azF().a(this.wDW);
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28159);
        if (!bc.ajM())
        {
          AppMethodBeat.o(28159);
          return;
        }
        bc.aCg();
        bu.n(com.tencent.mm.model.c.azW(), "Sk", 604800000L);
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
    bc.getSysCmdMsgExtension().a("shake", this.zcr, true);
    bc.getSysCmdMsgExtension().a("ShakeCardEntrance", this.zct, true);
    bc.getSysCmdMsgExtension().a("ShakeCardRedDot", this.zcu, true);
    this.zcm = null;
    this.zcn = null;
    AppMethodBeat.o(28170);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(28168);
    bc.aCg();
    com.tencent.mm.model.c.azL().d(this.hIZ);
    com.tencent.mm.sdk.b.a.IvT.d(this.fLW);
    com.tencent.mm.sdk.b.a.IvT.d(this.zcs);
    com.tencent.mm.sdk.b.a.IvT.d(this.zcp);
    com.tencent.mm.sdk.b.a.IvT.d(this.wxo);
    bc.aCg();
    com.tencent.mm.model.c.azF().b(this.wDW);
    bc.getSysCmdMsgExtension().b("shake", this.zcr, true);
    bc.getSysCmdMsgExtension().b("ShakeCardEntrance", this.zct, true);
    bc.getSysCmdMsgExtension().b("ShakeCardRedDot", this.zcu, true);
    com.tencent.mm.pluginsdk.o.a.FbY = null;
    AppMethodBeat.o(28168);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.m
 * JD-Core Version:    0.7.0.1
 */