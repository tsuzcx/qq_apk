package com.tencent.mm.plugin.shake.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.f.a.nn;
import com.tencent.mm.f.a.sv;
import com.tencent.mm.f.a.vr;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.a;
import com.tencent.mm.storage.cn;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class m
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private IListener FNC;
  private bv.a GsG;
  private e JmI;
  private g JmJ;
  private com.tencent.mm.plugin.shake.c.a.e JmK;
  private com.tencent.mm.plugin.shake.c.a.c JmL;
  private o JmM;
  private n JmN;
  com.tencent.mm.pluginsdk.d.d JmO;
  private ck.a JmP;
  private IListener JmQ;
  private ck.a JmR;
  private ck.a JmS;
  private IListener iVt;
  private bw.a ltK;
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
    this.JmN = new n();
    this.JmO = new com.tencent.mm.pluginsdk.d.d()
    {
      public final IEvent aIL(String paramAnonymousString)
      {
        AppMethodBeat.i(28149);
        vr localvr = new vr();
        localvr.fUO.event = paramAnonymousString;
        AppMethodBeat.o(28149);
        return localvr;
      }
      
      public final MStorage evj()
      {
        AppMethodBeat.i(28150);
        g localg = m.fHp();
        AppMethodBeat.o(28150);
        return localg;
      }
    };
    this.iVt = new m.7(this);
    this.JmP = new ck.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(28161);
        m.fHv();
        if (m.fHs() != null)
        {
          m.fHv();
          m.fHs();
          Object localObject = z.a(paramAnonymousa.jQG.RIF);
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
            localf.field_svrid = paramAnonymousa.jQG.HlH;
            localf.field_createtime = Util.nowSecond();
            localf.field_tag = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.jumpurl"));
            localf.field_status = 0;
            localf.field_title = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.title"));
            localf.field_thumburl = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.iconurl"));
            localf.field_desc = ((String)((Map)localObject).get(".sysmsg.shake.shaketv.desc"));
            localf.field_reserved1 = Util.nullAsNil((String)((Map)localObject).get(".sysmsg.shake.shaketv.pid"));
            m.fHp().a(localf);
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
    this.GsG = new m.14(this);
    this.ltK = new bw.a()
    {
      public final void a(az paramAnonymousaz, bw paramAnonymousbw)
      {
        AppMethodBeat.i(28151);
        if ((paramAnonymousaz != null) && (ab.QP(paramAnonymousaz.field_username))) {
          paramAnonymousaz.setUsername("");
        }
        AppMethodBeat.o(28151);
      }
    };
    this.JmQ = new IListener() {};
    this.JmR = new ck.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(28154);
        final String str = z.a(paramAnonymousa.jQG.RIF);
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
            m.fHt().n(str, paramAnonymousa.jQG.HlH, 0);
            AppMethodBeat.o(28153);
          }
        });
        AppMethodBeat.o(28154);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.JmS = new ck.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(28156);
        final String str = z.a(paramAnonymousa.jQG.RIF);
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
            m.fHt().n(str, paramAnonymousa.jQG.HlH, 1);
            AppMethodBeat.o(28155);
          }
        });
        AppMethodBeat.o(28156);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.FNC = new IListener() {};
    AppMethodBeat.o(28163);
  }
  
  public static String Wl(String paramString)
  {
    AppMethodBeat.i(28172);
    if (bh.aHB())
    {
      bh.beI();
      paramString = String.format("%s/Sk_%s", new Object[] { com.tencent.mm.model.c.bcc(), com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) });
      AppMethodBeat.o(28172);
      return paramString;
    }
    AppMethodBeat.o(28172);
    return "";
  }
  
  private static m fHn()
  {
    AppMethodBeat.i(28164);
    bh.beC();
    m localm2 = (m)ch.RZ("plugin.shake");
    m localm1 = localm2;
    if (localm2 == null)
    {
      localm1 = new m();
      bh.beC().a("plugin.shake", localm1);
    }
    AppMethodBeat.o(28164);
    return localm1;
  }
  
  public static e fHo()
  {
    AppMethodBeat.i(28165);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fHn().JmI == null)
    {
      localObject = fHn();
      bh.beI();
      ((m)localObject).JmI = new e(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = fHn().JmI;
    AppMethodBeat.o(28165);
    return localObject;
  }
  
  public static g fHp()
  {
    AppMethodBeat.i(28166);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fHn().JmJ == null)
    {
      localObject = fHn();
      bh.beI();
      ((m)localObject).JmJ = new g(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = fHn().JmJ;
    AppMethodBeat.o(28166);
    return localObject;
  }
  
  public static o fHq()
  {
    AppMethodBeat.i(28167);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fHn().JmM == null)
    {
      localObject = fHn();
      bh.beI();
      ((m)localObject).JmM = new o(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = fHn().JmM;
    AppMethodBeat.o(28167);
    return localObject;
  }
  
  public static void fHr()
  {
    AppMethodBeat.i(28169);
    fHo().fHd();
    com.tencent.mm.bl.d.bqe().bJQ();
    AppMethodBeat.o(28169);
  }
  
  public static i fHs()
  {
    AppMethodBeat.i(28171);
    com.tencent.mm.kernel.h.aHE().aGH();
    i locali = i.Jmx;
    AppMethodBeat.o(28171);
    return locali;
  }
  
  public static com.tencent.mm.plugin.shake.c.a.e fHt()
  {
    AppMethodBeat.i(28174);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fHn().JmK == null) {
      fHn().JmK = new com.tencent.mm.plugin.shake.c.a.e();
    }
    com.tencent.mm.plugin.shake.c.a.e locale = fHn().JmK;
    AppMethodBeat.o(28174);
    return locale;
  }
  
  public static com.tencent.mm.plugin.shake.c.a.c fHu()
  {
    AppMethodBeat.i(28175);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fHn().JmL == null) {
      fHn().JmL = new com.tencent.mm.plugin.shake.c.a.c();
    }
    com.tencent.mm.plugin.shake.c.a.c localc = fHn().JmL;
    AppMethodBeat.o(28175);
    return localc;
  }
  
  public static String kh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(28173);
    if ((bh.aHB()) && (!Util.isNullOrNil(paramString1)))
    {
      bh.beI();
      paramString1 = String.format("%s/Sk%s_%s", new Object[] { com.tencent.mm.model.c.bcc(), paramString2, com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) });
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
    com.tencent.mm.pluginsdk.o.a.QSc = new h();
    bh.beI();
    com.tencent.mm.model.c.bbR().b(this.ltK);
    EventCenter.instance.addListener(this.iVt);
    EventCenter.instance.addListener(this.JmQ);
    EventCenter.instance.addListener(this.JmN);
    EventCenter.instance.addListener(this.FNC);
    bh.beI();
    com.tencent.mm.model.c.bbL().a(this.GsG);
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28159);
        if (!bh.aHB())
        {
          AppMethodBeat.o(28159);
          return;
        }
        bh.beI();
        Util.deleteOutOfDateFile(com.tencent.mm.model.c.bcc(), "Sk", 604800000L);
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
    bh.getSysCmdMsgExtension().a("shake", this.JmP, true);
    bh.getSysCmdMsgExtension().a("ShakeCardEntrance", this.JmR, true);
    bh.getSysCmdMsgExtension().a("ShakeCardRedDot", this.JmS, true);
    this.JmK = null;
    this.JmL = null;
    AppMethodBeat.o(28170);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(28168);
    bh.beI();
    com.tencent.mm.model.c.bbR().c(this.ltK);
    EventCenter.instance.removeListener(this.iVt);
    EventCenter.instance.removeListener(this.JmQ);
    EventCenter.instance.removeListener(this.JmN);
    EventCenter.instance.removeListener(this.FNC);
    bh.beI();
    com.tencent.mm.model.c.bbL().b(this.GsG);
    bh.getSysCmdMsgExtension().b("shake", this.JmP, true);
    bh.getSysCmdMsgExtension().b("ShakeCardEntrance", this.JmR, true);
    bh.getSysCmdMsgExtension().b("ShakeCardRedDot", this.JmS, true);
    com.tencent.mm.pluginsdk.o.a.QSc = null;
    AppMethodBeat.o(28168);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.m
 * JD-Core Version:    0.7.0.1
 */