package com.tencent.mm.plugin.shake.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.a;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class m
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private IListener AgM;
  private bv.a AzD;
  private e Dhc;
  private g Dhd;
  private com.tencent.mm.plugin.shake.c.a.f Dhe;
  private com.tencent.mm.plugin.shake.c.a.d Dhf;
  private o Dhg;
  private n Dhh;
  com.tencent.mm.pluginsdk.c.d Dhi;
  private cj.a Dhj;
  private IListener Dhk;
  private cj.a Dhl;
  private cj.a Dhm;
  private IListener grk;
  private bw.a iDJ;
  private MMHandler mHandler;
  
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
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.Dhh = new n();
    this.Dhi = new com.tencent.mm.pluginsdk.c.d()
    {
      public final IEvent azl(String paramAnonymousString)
      {
        AppMethodBeat.i(28149);
        uo localuo = new uo();
        localuo.eaR.event = paramAnonymousString;
        AppMethodBeat.o(28149);
        return localuo;
      }
      
      public final MStorage dSG()
      {
        AppMethodBeat.i(28150);
        g localg = m.eUn();
        AppMethodBeat.o(28150);
        return localg;
      }
    };
    this.grk = new m.7(this);
    this.Dhj = new cj.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(28161);
        m.eUt();
        if (m.eUq() != null)
        {
          m.eUt();
          m.eUq();
          Object localObject = z.a(paramAnonymousa.heO.KHn);
          Log.v("MicroMsg.ShakeMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(localObject)));
          if (Util.isNullOrNil((String)localObject))
          {
            Log.d("MicroMsg.ShakeMsgMgr", "func[onResvMsg] Msg content empty");
            AppMethodBeat.o(28161);
            return;
          }
          localObject = XmlParser.parseXml((String)localObject, "sysmsg", null);
          int i = Util.getInt((String)((Map)localObject).get(".sysmsg.shake.$type"), 0);
          switch (i)
          {
          default: 
            Log.d("MicroMsg.ShakeMsgMgr", "Unrecognized type :".concat(String.valueOf(i)));
            AppMethodBeat.o(28161);
            return;
          }
          f localf = new f();
          i = Util.getInt((String)((Map)localObject).get(".sysmsg.shake.shaketv.msgtype"), 0);
          if (i == 0)
          {
            localf.field_type = 1;
            localf.field_subtype = i;
            localf.field_svrid = paramAnonymousa.heO.Brn;
            localf.field_createtime = Util.nowSecond();
            localf.field_tag = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.jumpurl"));
            localf.field_status = 0;
            localf.field_title = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.title"));
            localf.field_thumburl = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.iconurl"));
            localf.field_desc = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.desc"));
            localf.field_reserved1 = Util.nullAsNil((String)((Map)localObject).get(".sysmsg.shake.shaketv.pid"));
            m.eUn().a(localf);
            AppMethodBeat.o(28161);
            return;
          }
          Log.w("MicroMsg.ShakeMsgMgr", "Unknown subType:".concat(String.valueOf(i)));
          AppMethodBeat.o(28161);
          return;
        }
        Log.w("MicroMsg.SubCoreShake", "func[onRecieveMsg] getShakeMsgMgr null");
        AppMethodBeat.o(28161);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.AzD = new bv.a()
    {
      public final as Kn(String paramAnonymousString)
      {
        return null;
      }
      
      public final void a(bv paramAnonymousbv, as paramAnonymousas)
      {
        AppMethodBeat.i(28162);
        if ((paramAnonymousbv != null) && (paramAnonymousas != null) && (paramAnonymousas.ary())) {
          m.eUm().aNj(paramAnonymousas.field_username);
        }
        AppMethodBeat.o(28162);
      }
      
      public final int b(as paramAnonymousas, boolean paramAnonymousBoolean)
      {
        return 0;
      }
    };
    this.iDJ = new m.2(this);
    this.Dhk = new IListener() {};
    this.Dhl = new cj.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(28154);
        final String str = z.a(paramAnonymousa.heO.KHn);
        if ((str == null) || (str.length() == 0))
        {
          Log.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardEntranceMsg msgContent is null");
          AppMethodBeat.o(28154);
          return;
        }
        m.a(m.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28153);
            m.eUr().m(str, paramAnonymousa.heO.Brn, 0);
            AppMethodBeat.o(28153);
          }
        });
        AppMethodBeat.o(28154);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.Dhm = new cj.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(28156);
        final String str = z.a(paramAnonymousa.heO.KHn);
        if ((str == null) || (str.length() == 0))
        {
          Log.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
          AppMethodBeat.o(28156);
          return;
        }
        m.a(m.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(28155);
            m.eUr().m(str, paramAnonymousa.heO.Brn, 1);
            AppMethodBeat.o(28155);
          }
        });
        AppMethodBeat.o(28156);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.AgM = new IListener() {};
    AppMethodBeat.o(28163);
  }
  
  public static String ON(String paramString)
  {
    AppMethodBeat.i(28172);
    if (bg.aAc())
    {
      bg.aVF();
      paramString = String.format("%s/Sk_%s", new Object[] { c.aTe(), com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) });
      AppMethodBeat.o(28172);
      return paramString;
    }
    AppMethodBeat.o(28172);
    return "";
  }
  
  private static m eUl()
  {
    AppMethodBeat.i(28164);
    bg.aVz();
    m localm2 = (m)cg.KG("plugin.shake");
    m localm1 = localm2;
    if (localm2 == null)
    {
      localm1 = new m();
      bg.aVz().a("plugin.shake", localm1);
    }
    AppMethodBeat.o(28164);
    return localm1;
  }
  
  public static e eUm()
  {
    AppMethodBeat.i(28165);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eUl().Dhc == null)
    {
      localObject = eUl();
      bg.aVF();
      ((m)localObject).Dhc = new e(c.getDataDB());
    }
    Object localObject = eUl().Dhc;
    AppMethodBeat.o(28165);
    return localObject;
  }
  
  public static g eUn()
  {
    AppMethodBeat.i(28166);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eUl().Dhd == null)
    {
      localObject = eUl();
      bg.aVF();
      ((m)localObject).Dhd = new g(c.getDataDB());
    }
    Object localObject = eUl().Dhd;
    AppMethodBeat.o(28166);
    return localObject;
  }
  
  public static o eUo()
  {
    AppMethodBeat.i(28167);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eUl().Dhg == null)
    {
      localObject = eUl();
      bg.aVF();
      ((m)localObject).Dhg = new o(c.getDataDB());
    }
    Object localObject = eUl().Dhg;
    AppMethodBeat.o(28167);
    return localObject;
  }
  
  public static void eUp()
  {
    AppMethodBeat.i(28169);
    eUm().eUb();
    com.tencent.mm.bj.d.bgP().byC();
    AppMethodBeat.o(28169);
  }
  
  public static i eUq()
  {
    AppMethodBeat.i(28171);
    com.tencent.mm.kernel.g.aAf().azk();
    i locali = i.DgR;
    AppMethodBeat.o(28171);
    return locali;
  }
  
  public static com.tencent.mm.plugin.shake.c.a.f eUr()
  {
    AppMethodBeat.i(28174);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eUl().Dhe == null) {
      eUl().Dhe = new com.tencent.mm.plugin.shake.c.a.f();
    }
    com.tencent.mm.plugin.shake.c.a.f localf = eUl().Dhe;
    AppMethodBeat.o(28174);
    return localf;
  }
  
  public static com.tencent.mm.plugin.shake.c.a.d eUs()
  {
    AppMethodBeat.i(28175);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eUl().Dhf == null) {
      eUl().Dhf = new com.tencent.mm.plugin.shake.c.a.d();
    }
    com.tencent.mm.plugin.shake.c.a.d locald = eUl().Dhf;
    AppMethodBeat.o(28175);
    return locald;
  }
  
  public static String jP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(28173);
    if ((bg.aAc()) && (!Util.isNullOrNil(paramString1)))
    {
      bg.aVF();
      paramString1 = String.format("%s/Sk%s_%s", new Object[] { c.aTe(), paramString2, com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) });
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
    com.tencent.mm.pluginsdk.o.a.JSX = new h();
    bg.aVF();
    c.aST().c(this.iDJ);
    EventCenter.instance.addListener(this.grk);
    EventCenter.instance.addListener(this.Dhk);
    EventCenter.instance.addListener(this.Dhh);
    EventCenter.instance.addListener(this.AgM);
    bg.aVF();
    c.aSN().a(this.AzD);
    bg.aAk().postToWorker(new m.12(this));
    bg.getSysCmdMsgExtension().a("shake", this.Dhj, true);
    bg.getSysCmdMsgExtension().a("ShakeCardEntrance", this.Dhl, true);
    bg.getSysCmdMsgExtension().a("ShakeCardRedDot", this.Dhm, true);
    this.Dhe = null;
    this.Dhf = null;
    AppMethodBeat.o(28170);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(28168);
    bg.aVF();
    c.aST().d(this.iDJ);
    EventCenter.instance.removeListener(this.grk);
    EventCenter.instance.removeListener(this.Dhk);
    EventCenter.instance.removeListener(this.Dhh);
    EventCenter.instance.removeListener(this.AgM);
    bg.aVF();
    c.aSN().b(this.AzD);
    bg.getSysCmdMsgExtension().b("shake", this.Dhj, true);
    bg.getSysCmdMsgExtension().b("ShakeCardEntrance", this.Dhl, true);
    bg.getSysCmdMsgExtension().b("ShakeCardRedDot", this.Dhm, true);
    com.tencent.mm.pluginsdk.o.a.JSX = null;
    AppMethodBeat.o(28168);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.m
 * JD-Core Version:    0.7.0.1
 */