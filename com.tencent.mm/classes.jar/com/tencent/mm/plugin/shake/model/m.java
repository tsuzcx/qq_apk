package com.tencent.mm.plugin.shake.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.autogen.a.xh;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.br.c.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.shake.c.a.r;
import com.tencent.mm.pluginsdk.event.a;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.bx.a;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.a;
import com.tencent.mm.storage.cq;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class m
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private IListener LIy;
  private bx.a MoG;
  private com.tencent.mm.plugin.shake.shakecard.a.e PzA;
  private com.tencent.mm.plugin.shake.shakecard.a.c PzB;
  private r PzC;
  private TVOperationListener PzD;
  a PzE;
  private cl.a PzF;
  private IListener PzG;
  private cl.a PzH;
  private cl.a PzI;
  private e Pzy;
  private g Pzz;
  private IListener lxy;
  private MMHandler mHandler;
  private by.a olj;
  
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
        return r.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("SHAKENEWYEARFRIENDINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return k.SQL_CREATE;
      }
    });
    AppMethodBeat.o(28177);
  }
  
  public m()
  {
    AppMethodBeat.i(28163);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.PzD = new TVOperationListener();
    this.PzE = new a()
    {
      public final IEvent aFl(String paramAnonymousString)
      {
        AppMethodBeat.i(28149);
        xh localxh = new xh();
        localxh.iaL.event = paramAnonymousString;
        AppMethodBeat.o(28149);
        return localxh;
      }
      
      public final MStorage fCc()
      {
        AppMethodBeat.i(28150);
        g localg = m.gXe();
        AppMethodBeat.o(28150);
        return localg;
      }
    };
    this.lxy = new SubCoreShake.2(this, com.tencent.mm.app.f.hfK);
    this.PzF = new cl.a()
    {
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(273521);
        m.gXk();
        if (m.gXh() != null)
        {
          m.gXk();
          m.gXh();
          Object localObject = w.a(paramAnonymousa.mpN.YFG);
          Log.v("MicroMsg.ShakeMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(localObject)));
          if (Util.isNullOrNil((String)localObject))
          {
            Log.d("MicroMsg.ShakeMsgMgr", "func[onResvMsg] Msg content empty");
            AppMethodBeat.o(273521);
            return;
          }
          localObject = XmlParser.parseXml((String)localObject, "sysmsg", null);
          int i = Util.getInt((String)((Map)localObject).get(".sysmsg.shake.$type"), 0);
          switch (i)
          {
          default: 
            Log.d("MicroMsg.ShakeMsgMgr", "Unrecognized type :".concat(String.valueOf(i)));
            AppMethodBeat.o(273521);
            return;
          }
          f localf = new f();
          i = Util.getInt((String)((Map)localObject).get(".sysmsg.shake.shaketv.msgtype"), 0);
          if (i == 0)
          {
            localf.field_type = 1;
            localf.field_subtype = i;
            localf.field_svrid = paramAnonymousa.mpN.Njv;
            localf.field_createtime = Util.nowSecond();
            localf.field_tag = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.jumpurl"));
            localf.field_status = 0;
            localf.field_title = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.title"));
            localf.field_thumburl = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.iconurl"));
            localf.field_desc = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.desc"));
            localf.field_reserved1 = Util.nullAsNil((String)((Map)localObject).get(".sysmsg.shake.shaketv.pid"));
            m.gXe().a(localf);
            AppMethodBeat.o(273521);
            return;
          }
          Log.w("MicroMsg.ShakeMsgMgr", "Unknown subType:".concat(String.valueOf(i)));
          AppMethodBeat.o(273521);
          return;
        }
        Log.w("MicroMsg.SubCoreShake", "func[onRecieveMsg] getShakeMsgMgr null");
        AppMethodBeat.o(273521);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.MoG = new bx.a()
    {
      public final au JE(String paramAnonymousString)
      {
        return null;
      }
      
      public final void a(bx paramAnonymousbx, au paramAnonymousau)
      {
        AppMethodBeat.i(273531);
        if ((paramAnonymousbx != null) && (paramAnonymousau != null) && (paramAnonymousau.aSF())) {
          m.gXd().aVK(paramAnonymousau.field_username);
        }
        AppMethodBeat.o(273531);
      }
      
      public final int b(au paramAnonymousau, boolean paramAnonymousBoolean)
      {
        return 0;
      }
    };
    this.olj = new by.a()
    {
      public final void a(bb paramAnonymousbb, by paramAnonymousby)
      {
        AppMethodBeat.i(273528);
        if ((paramAnonymousbb != null) && (au.bwt(paramAnonymousbb.field_username))) {
          paramAnonymousbb.setUsername("");
        }
        AppMethodBeat.o(273528);
      }
    };
    this.PzG = new SubCoreShake.12(this, com.tencent.mm.app.f.hfK);
    this.PzH = new cl.a()
    {
      public final void a(final g.a paramAnonymousa)
      {
        AppMethodBeat.i(28156);
        final String str = w.a(paramAnonymousa.mpN.YFG);
        if ((str == null) || (str.length() == 0))
        {
          Log.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardEntranceMsg msgContent is null");
          AppMethodBeat.o(28156);
          return;
        }
        m.a(m.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28155);
            m.gXi().p(str, paramAnonymousa.mpN.Njv, 0);
            AppMethodBeat.o(28155);
          }
        });
        AppMethodBeat.o(28156);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.PzI = new cl.a()
    {
      public final void a(final g.a paramAnonymousa)
      {
        AppMethodBeat.i(273533);
        final String str = w.a(paramAnonymousa.mpN.YFG);
        if ((str == null) || (str.length() == 0))
        {
          Log.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
          AppMethodBeat.o(273533);
          return;
        }
        m.a(m.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(273515);
            m.gXi().p(str, paramAnonymousa.mpN.Njv, 1);
            AppMethodBeat.o(273515);
          }
        });
        AppMethodBeat.o(273533);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.LIy = new SubCoreShake.15(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(28163);
  }
  
  public static String Ol(String paramString)
  {
    AppMethodBeat.i(28172);
    if (bh.baz())
    {
      bh.bCz();
      paramString = String.format("%s/Sk_%s", new Object[] { com.tencent.mm.model.c.bzR(), com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) });
      AppMethodBeat.o(28172);
      return paramString;
    }
    AppMethodBeat.o(28172);
    return "";
  }
  
  private static m gXc()
  {
    AppMethodBeat.i(28164);
    bh.bCt();
    m localm2 = (m)ci.Ka("plugin.shake");
    m localm1 = localm2;
    if (localm2 == null)
    {
      localm1 = new m();
      bh.bCt().a("plugin.shake", localm1);
    }
    AppMethodBeat.o(28164);
    return localm1;
  }
  
  public static e gXd()
  {
    AppMethodBeat.i(28165);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gXc().Pzy == null)
    {
      localObject = gXc();
      bh.bCz();
      ((m)localObject).Pzy = new e(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = gXc().Pzy;
    AppMethodBeat.o(28165);
    return localObject;
  }
  
  public static g gXe()
  {
    AppMethodBeat.i(28166);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gXc().Pzz == null)
    {
      localObject = gXc();
      bh.bCz();
      ((m)localObject).Pzz = new g(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = gXc().Pzz;
    AppMethodBeat.o(28166);
    return localObject;
  }
  
  public static r gXf()
  {
    AppMethodBeat.i(28167);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gXc().PzC == null)
    {
      localObject = gXc();
      bh.bCz();
      ((m)localObject).PzC = new r(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = gXc().PzC;
    AppMethodBeat.o(28167);
    return localObject;
  }
  
  public static void gXg()
  {
    AppMethodBeat.i(28169);
    gXd().gWR();
    com.tencent.mm.modelverify.d.bNK().cju();
    AppMethodBeat.o(28169);
  }
  
  public static i gXh()
  {
    AppMethodBeat.i(28171);
    com.tencent.mm.kernel.h.baC().aZJ();
    i locali = i.Pzn;
    AppMethodBeat.o(28171);
    return locali;
  }
  
  public static com.tencent.mm.plugin.shake.shakecard.a.e gXi()
  {
    AppMethodBeat.i(28174);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gXc().PzA == null) {
      gXc().PzA = new com.tencent.mm.plugin.shake.shakecard.a.e();
    }
    com.tencent.mm.plugin.shake.shakecard.a.e locale = gXc().PzA;
    AppMethodBeat.o(28174);
    return locale;
  }
  
  public static com.tencent.mm.plugin.shake.shakecard.a.c gXj()
  {
    AppMethodBeat.i(28175);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gXc().PzB == null) {
      gXc().PzB = new com.tencent.mm.plugin.shake.shakecard.a.c();
    }
    com.tencent.mm.plugin.shake.shakecard.a.c localc = gXc().PzB;
    AppMethodBeat.o(28175);
    return localc;
  }
  
  public static String lG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(28173);
    if ((bh.baz()) && (!Util.isNullOrNil(paramString1)))
    {
      bh.bCz();
      paramString1 = String.format("%s/Sk%s_%s", new Object[] { com.tencent.mm.model.c.bzR(), paramString2, com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) });
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
    com.tencent.mm.pluginsdk.o.a.XNT = new h();
    bh.bCz();
    com.tencent.mm.model.c.bzG().b(this.olj);
    this.lxy.alive();
    this.PzG.alive();
    this.PzD.alive();
    this.LIy.alive();
    bh.bCz();
    com.tencent.mm.model.c.bzA().a(this.MoG);
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28159);
        if (!bh.baz())
        {
          AppMethodBeat.o(28159);
          return;
        }
        bh.bCz();
        Util.deleteOutOfDateFile(com.tencent.mm.model.c.bzR(), "Sk", 604800000L);
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
    bh.getSysCmdMsgExtension().a("shake", this.PzF, true);
    bh.getSysCmdMsgExtension().a("ShakeCardEntrance", this.PzH, true);
    bh.getSysCmdMsgExtension().a("ShakeCardRedDot", this.PzI, true);
    this.PzA = null;
    this.PzB = null;
    com.tencent.mm.br.c.a(new c.c()
    {
      public final boolean aR(Context paramAnonymousContext, String paramAnonymousString)
      {
        AppMethodBeat.i(273514);
        if ((paramAnonymousString.startsWith("shake")) && (paramAnonymousString.endsWith(".ShakeReportUI")) && (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()))
        {
          ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(paramAnonymousContext);
          AppMethodBeat.o(273514);
          return true;
        }
        AppMethodBeat.o(273514);
        return false;
      }
    });
    AppMethodBeat.o(28170);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(28168);
    bh.bCz();
    com.tencent.mm.model.c.bzG().c(this.olj);
    this.lxy.dead();
    this.PzG.dead();
    this.PzD.dead();
    this.LIy.dead();
    bh.bCz();
    com.tencent.mm.model.c.bzA().b(this.MoG);
    bh.getSysCmdMsgExtension().b("shake", this.PzF, true);
    bh.getSysCmdMsgExtension().b("ShakeCardEntrance", this.PzH, true);
    bh.getSysCmdMsgExtension().b("ShakeCardRedDot", this.PzI, true);
    com.tencent.mm.pluginsdk.o.a.XNT = null;
    AppMethodBeat.o(28168);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.model.m
 * JD-Core Version:    0.7.0.1
 */