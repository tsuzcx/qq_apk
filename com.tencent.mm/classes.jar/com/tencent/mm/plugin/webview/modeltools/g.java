package com.tencent.mm.plugin.webview.modeltools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.c;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.aau;
import com.tencent.mm.g.a.aay;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.om;
import com.tencent.mm.g.a.pv;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.model.y;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.webview.fts.i.a;
import com.tencent.mm.plugin.webview.fts.j.b;
import com.tencent.mm.plugin.webview.fts.j.c;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.aq;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.plugin.webview.model.aw;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public class g
  implements bd
{
  private static final HashMap<Integer, h.b> baseDBFactories;
  private an JaH;
  private ao JaI;
  private am JaJ;
  private m JaK;
  private com.tencent.mm.plugin.webview.model.g JaL;
  private aq JaM;
  private com.tencent.mm.plugin.webview.b.e JaN;
  private com.tencent.mm.plugin.webview.fts.j JaO;
  private com.tencent.mm.plugin.webview.fts.b JaP;
  private com.tencent.mm.plugin.webview.fts.c JaQ;
  private com.tencent.mm.plugin.webview.emojistore.a JaR;
  private com.tencent.mm.plugin.webview.luggage.a JaS;
  private com.tencent.mm.plugin.game.api.h JaT;
  private IListener JaU;
  private IListener JaV;
  IListener JaW;
  IListener JaX;
  final IListener<aau> JaY;
  IListener JaZ;
  final IListener<l> Jba;
  IListener Jbb;
  IListener Jbc;
  IListener Jbd;
  private IListener Jbe;
  private o.a appForegroundListener;
  private IListener<bp> iUx;
  public boolean isAppActive;
  private com.tencent.mm.network.p netChanged;
  private cj.a oUZ;
  
  static
  {
    AppMethodBeat.i(79187);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("WebViewHostsFilterTable".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return m.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WEBVIEW_JSLOG_BLOCK_LIST_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.webview.model.g.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WEBVIEW_LOCAL_DATA".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return aq.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WEBVIEW_DATA".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.webview.b.c.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WEBVIEW_HISTORY_DATA".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.webview.b.e.SQL_CREATE;
      }
    });
    AppMethodBeat.o(79187);
  }
  
  public g()
  {
    AppMethodBeat.i(79172);
    this.JaT = new com.tencent.mm.plugin.game.api.h()
    {
      public final void eb(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(79150);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("postId", paramAnonymousString);
          localJSONObject.put("result", paramAnonymousInt);
          paramAnonymousString = new Bundle();
          paramAnonymousString.putString("name", "onPublishHaowanEnd");
          paramAnonymousString.putString("data", localJSONObject.toString());
          ToolsProcessIPCService.a(paramAnonymousString, com.tencent.mm.plugin.webview.luggage.a.a.class, null);
          AppMethodBeat.o(79150);
          return;
        }
        catch (JSONException paramAnonymousString)
        {
          AppMethodBeat.o(79150);
        }
      }
      
      public final void f(String paramAnonymousString, float paramAnonymousFloat)
      {
        AppMethodBeat.i(79151);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("postId", paramAnonymousString);
          localJSONObject.put("percent", paramAnonymousFloat);
          paramAnonymousString = new Bundle();
          paramAnonymousString.putString("name", "onPublishHaowanProgress");
          paramAnonymousString.putString("data", localJSONObject.toString());
          ToolsProcessIPCService.a(paramAnonymousString, com.tencent.mm.plugin.webview.luggage.a.a.class, null);
          AppMethodBeat.o(79151);
          return;
        }
        catch (JSONException paramAnonymousString)
        {
          AppMethodBeat.o(79151);
        }
      }
    };
    this.isAppActive = true;
    this.JaU = new g.12(this);
    this.JaV = new IListener() {};
    this.oUZ = new cj.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(79153);
        paramAnonymousa = com.tencent.mm.platformtools.z.a(paramAnonymousa.heO.KHn);
        final m localm = g.gdw();
        com.tencent.f.h.RTc.ba(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79152);
            Log.d("MicroMsg.SubCoreTools", "webview hijack sysMsgListener");
            Map localMap = XmlParser.parseXml(paramAnonymousa, "sysmsg", null);
            long l = Util.getLong((String)localMap.get(".sysmsg.hijackconfig.expiretime"), 9223372036854775807L);
            String str1 = ".sysmsg.hijackconfig.domainlist.domain";
            int i = 0;
            if (i > 0) {
              str1 = ".sysmsg.hijackconfig.domainlist.domain" + i;
            }
            for (;;)
            {
              i += 1;
              String str2 = (String)localMap.get(str1);
              if (!Util.isNullOrNil(str2))
              {
                i locali = new i();
                locali.field_expireTime = l;
                locali.field_host = str2;
                localm.insert(locali);
                break;
              }
              AppMethodBeat.o(79152);
              return;
            }
          }
        });
        AppMethodBeat.o(79153);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.JaW = new g.3(this);
    this.JaX = new IListener() {};
    this.JaY = new IListener() {};
    this.JaZ = new IListener() {};
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(79160);
        g.a(g.this, false);
        AppMethodBeat.o(79160);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(79159);
        g.a(g.this, true);
        AppMethodBeat.o(79159);
      }
    };
    this.Jba = new IListener()
    {
      private Boolean Jbi;
    };
    this.Jbb = new IListener()
    {
      private static boolean a(df paramAnonymousdf)
      {
        AppMethodBeat.i(79161);
        String str1;
        if ((paramAnonymousdf instanceof df))
        {
          paramAnonymousdf = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
          XWalkEnvironment.setIpType(com.tencent.mm.n.h.aqJ().getInt("WebKernelMode", -1));
          str1 = com.tencent.mm.n.h.aqJ().getValue("WebviewDownloadTbs");
          String str2 = com.tencent.mm.n.h.aqJ().getValue("WebviewEnableTbs");
          Log.i("MicroMsg.SubCoreTools", "updateWebViewDynamicConfig, tbsDownload = %s, tbsEnable = %s, tbsSupportedVerSec = %s", new Object[] { str1, str2, com.tencent.mm.n.h.aqJ().getValue("WebviewSupportedTbsVersionSection") });
          if (str1 != null) {
            paramAnonymousdf.putString("tbs_download", str1);
          }
          paramAnonymousdf.apply();
          if (("1".equals(str1)) && ("1".equals(str2))) {
            com.tencent.mm.pluginsdk.ui.tools.r.pl(1);
          }
          if (str1 == null) {}
        }
        try
        {
          if ("0".equals(str1))
          {
            Log.i("MicroMsg.SubCoreTools", "tbs download disable, reset tbssdk in sandbox");
            paramAnonymousdf = new Intent();
            paramAnonymousdf.setComponent(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
            MMApplicationContext.getContext().sendBroadcast(paramAnonymousdf);
          }
          AppMethodBeat.o(79161);
          return false;
        }
        catch (Exception paramAnonymousdf)
        {
          for (;;)
          {
            Log.w("MicroMsg.SubCoreTools", "sendbroadcast ,ex = %s", new Object[] { paramAnonymousdf.getMessage() });
          }
        }
      }
    };
    this.Jbc = new IListener() {};
    this.Jbd = new IListener() {};
    this.iUx = new IListener() {};
    this.Jbe = new IListener() {};
    this.netChanged = new p.a()
    {
      private final byte[] glH;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(79169);
        synchronized (this.glH)
        {
          String str = com.tencent.mm.pluginsdk.ui.tools.z.gcX();
          if (str.equalsIgnoreCase("WIFI"))
          {
            aw.gcU().setNetWorkState(1);
            g.aZs(str);
            AppMethodBeat.o(79169);
            return;
          }
          aw.gcU().setNetWorkState(2);
        }
      }
    };
    AppMethodBeat.o(79172);
  }
  
  public static g gdp()
  {
    AppMethodBeat.i(79173);
    g localg = (g)y.at(g.class);
    AppMethodBeat.o(79173);
    return localg;
  }
  
  public static com.tencent.mm.plugin.webview.emojistore.a gdq()
  {
    AppMethodBeat.i(79174);
    if (gdp().JaR == null) {
      gdp().JaR = new com.tencent.mm.plugin.webview.emojistore.a();
    }
    com.tencent.mm.plugin.webview.emojistore.a locala = gdp().JaR;
    AppMethodBeat.o(79174);
    return locala;
  }
  
  public static com.tencent.mm.plugin.webview.fts.b gdr()
  {
    AppMethodBeat.i(79175);
    if (gdp().JaP == null) {
      gdp().JaP = new com.tencent.mm.plugin.webview.fts.b();
    }
    com.tencent.mm.plugin.webview.fts.b localb = gdp().JaP;
    AppMethodBeat.o(79175);
    return localb;
  }
  
  public static com.tencent.mm.plugin.webview.fts.c gds()
  {
    AppMethodBeat.i(79176);
    if (gdp().JaQ == null) {
      gdp().JaQ = new com.tencent.mm.plugin.webview.fts.c();
    }
    com.tencent.mm.plugin.webview.fts.c localc = gdp().JaQ;
    AppMethodBeat.o(79176);
    return localc;
  }
  
  public static com.tencent.mm.plugin.webview.fts.j gdt()
  {
    AppMethodBeat.i(79177);
    if (gdp().JaO == null) {
      gdp().JaO = new com.tencent.mm.plugin.webview.fts.j();
    }
    com.tencent.mm.plugin.webview.fts.j localj = gdp().JaO;
    AppMethodBeat.o(79177);
    return localj;
  }
  
  public static an gdu()
  {
    AppMethodBeat.i(79178);
    if (gdp().JaH == null) {
      gdp().JaH = new an();
    }
    an localan = gdp().JaH;
    AppMethodBeat.o(79178);
    return localan;
  }
  
  public static ao gdv()
  {
    AppMethodBeat.i(79179);
    if (gdp().JaI == null) {
      gdp().JaI = ao.gcQ();
    }
    ao localao = gdp().JaI;
    AppMethodBeat.o(79179);
    return localao;
  }
  
  public static m gdw()
  {
    AppMethodBeat.i(79180);
    if (gdp().JaK == null)
    {
      localObject = gdp();
      com.tencent.mm.kernel.g.aAi();
      ((g)localObject).JaK = new m(com.tencent.mm.kernel.g.aAh().hqK);
    }
    Object localObject = gdp().JaK;
    AppMethodBeat.o(79180);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.webview.model.g gdx()
  {
    AppMethodBeat.i(79181);
    if (gdp().JaL == null)
    {
      localObject = gdp();
      com.tencent.mm.kernel.g.aAi();
      ((g)localObject).JaL = new com.tencent.mm.plugin.webview.model.g(com.tencent.mm.kernel.g.aAh().hqK);
    }
    Object localObject = gdp().JaL;
    AppMethodBeat.o(79181);
    return localObject;
  }
  
  public static aq gdy()
  {
    AppMethodBeat.i(79182);
    if (gdp().JaM == null)
    {
      localObject = gdp();
      com.tencent.mm.kernel.g.aAi();
      ((g)localObject).JaM = new aq(com.tencent.mm.kernel.g.aAh().hqK);
    }
    Object localObject = gdp().JaM;
    AppMethodBeat.o(79182);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.webview.b.e gdz()
  {
    AppMethodBeat.i(79183);
    if (gdp().JaN == null)
    {
      localObject = gdp();
      com.tencent.mm.kernel.g.aAi();
      ((g)localObject).JaN = new com.tencent.mm.plugin.webview.b.e(com.tencent.mm.kernel.g.aAh().hqK);
    }
    Object localObject = gdp().JaN;
    AppMethodBeat.o(79183);
    return localObject;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(79185);
    Log.i("MicroMsg.SubCoreTools", "onAccountPostReset hc:%d", new Object[] { Integer.valueOf(hashCode()) });
    this.JaU.alive();
    EventCenter.instance.addListener(this.JaZ);
    EventCenter.instance.addListener(this.Jbb);
    EventCenter.instance.addListener(this.Jbc);
    EventCenter.instance.addListener(this.Jbd);
    EventCenter.instance.addListener(this.JaW);
    EventCenter.instance.addListener(this.JaX);
    EventCenter.instance.addListener(this.Jbe);
    EventCenter.instance.addListener(this.iUx);
    this.appForegroundListener.alive();
    this.Jba.alive();
    this.JaV.alive();
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("hijackconfig", this.oUZ, true);
    com.tencent.mm.kernel.g.aAg().a(this.netChanged);
    com.tencent.mm.plugin.x.c.DlS.a(new com.tencent.mm.plugin.webview.model.d());
    com.tencent.mm.plugin.x.c.DlS.a(new as());
    this.JaY.alive();
    k.c.a(new com.tencent.mm.co.c() {});
    com.tencent.mm.cr.d.kT(MMApplicationContext.getContext());
    com.tencent.mm.kernel.g.aAf();
    XWalkEnvironment.setGrayValueByUserId(com.tencent.mm.kernel.a.getUin());
    if (com.tencent.mm.n.h.aqJ() != null) {
      XWalkEnvironment.setIpType(com.tencent.mm.n.h.aqJ().getInt("WebKernelMode", -1));
    }
    com.tencent.mm.plugin.webview.fts.i.gaz();
    com.tencent.mm.plugin.webview.fts.i.start();
    Log.d("MicroMsg.CityServiceHelper", "addCheckResUpdateListener");
    if (Log.getLogLevel() <= 0)
    {
      com.tencent.mm.pluginsdk.j.a.a.b.gnC();
      com.tencent.mm.pluginsdk.j.a.a.b.ahP(54);
    }
    Object localObject = new b.1();
    EventCenter.instance.add((IListener)localObject);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.webview.j.a.class, new com.tencent.mm.plugin.webview.ui.tools.bag.e());
    com.tencent.mm.plugin.webview.ui.tools.floatball.b.bCM();
    com.tencent.mm.plugin.webview.ui.tools.multitask.a.euA();
    com.tencent.mm.plugin.webview.luggage.r.gcb();
    this.JaS = new com.tencent.mm.plugin.webview.luggage.a();
    gdu().a(this.JaS);
    com.tencent.mm.plugin.game.api.a.a(this.JaT);
    localObject = com.tencent.mm.plugin.webview.fts.a.INO;
    com.tencent.mm.kernel.g.azz().a(1532, (com.tencent.mm.ak.i)localObject);
    gdt();
    AppMethodBeat.o(79185);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(79184);
    Log.i("MicroMsg.SubCoreTools", "onAccountRelease hc:%d", new Object[] { Integer.valueOf(hashCode()) });
    this.JaU.dead();
    EventCenter.instance.removeListener(this.JaZ);
    EventCenter.instance.removeListener(this.Jbb);
    EventCenter.instance.removeListener(this.Jbc);
    EventCenter.instance.removeListener(this.Jbd);
    EventCenter.instance.removeListener(this.JaW);
    EventCenter.instance.removeListener(this.JaX);
    EventCenter.instance.removeListener(this.Jbe);
    EventCenter.instance.removeListener(this.iUx);
    this.appForegroundListener.dead();
    this.Jba.dead();
    this.JaV.dead();
    com.tencent.mm.kernel.g.aAg().b(this.netChanged);
    if (this.JaJ != null)
    {
      localObject1 = this.JaJ;
      if (((am)localObject1).DXm != null)
      {
        com.tencent.mm.plugin.downloader.model.f.cBv();
        com.tencent.mm.plugin.downloader.model.c.b(((am)localObject1).DXm);
      }
      if ((((am)localObject1).IZf != null) && (((am)localObject1).IZf.size() > 0))
      {
        localObject1 = ((am)localObject1).IZf.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Long)((Iterator)localObject1).next();
          Log.i("MicroMsg.WebViewAutoDownloader", "remove download task : %d", new Object[] { localObject2 });
          com.tencent.mm.plugin.downloader.model.f.cBv().Cn(((Long)localObject2).longValue());
        }
      }
    }
    if (this.JaQ != null)
    {
      localObject1 = this.JaQ;
      com.tencent.mm.kernel.g.azz().b(2975, (com.tencent.mm.ak.i)localObject1);
      EventCenter.instance.removeListener(((com.tencent.mm.plugin.webview.fts.c)localObject1).lEl);
      if (((com.tencent.mm.plugin.webview.fts.c)localObject1).IOb != null)
      {
        com.tencent.mm.kernel.g.azz().b(1048, (com.tencent.mm.ak.i)localObject1);
        com.tencent.mm.kernel.g.azz().a(((com.tencent.mm.plugin.webview.fts.c)localObject1).IOb);
        ((com.tencent.mm.plugin.webview.fts.c)localObject1).IOb = null;
      }
      this.JaQ = null;
    }
    if (this.JaO != null)
    {
      localObject1 = this.JaO;
      ((com.tencent.mm.plugin.webview.fts.j)localObject1).IOZ.dead();
      ((com.tencent.mm.plugin.webview.fts.j)localObject1).IPl.dead();
      localObject2 = ((com.tencent.mm.plugin.webview.fts.j)localObject1).IPo;
      if (((j.b)localObject2).IPe != null) {
        com.tencent.mm.kernel.g.azz().a(((j.b)localObject2).IPe);
      }
      if (((j.b)localObject2).IPv != null) {
        ((j.b)localObject2).IPv.stopped = true;
      }
      localObject2 = ((com.tencent.mm.plugin.webview.fts.j)localObject1).IPp;
      if (((j.c)localObject2).IPx != null) {
        com.tencent.mm.kernel.g.azz().b(((j.c)localObject2).IPx.getType(), ((j.c)localObject2).IPq);
      }
      if (((com.tencent.mm.plugin.webview.fts.j)localObject1).wXa != null)
      {
        ((n)com.tencent.mm.kernel.g.ah(n.class)).cancelSearchTask(((com.tencent.mm.plugin.webview.fts.j)localObject1).wXa);
        ((com.tencent.mm.plugin.webview.fts.j)localObject1).wXa = null;
      }
      ((com.tencent.mm.plugin.webview.fts.j)localObject1).IPn.IOC.clear();
      ((com.tencent.mm.plugin.webview.fts.j)localObject1).IOP.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.webview.fts.j)localObject1).IOP.quit();
      this.JaO = null;
    }
    if (this.JaP != null)
    {
      localObject1 = this.JaP;
      ((com.tencent.mm.plugin.webview.fts.b)localObject1).DFm.dead();
      ((com.tencent.mm.plugin.webview.fts.b)localObject1).INW.dead();
      com.tencent.mm.aj.p.aYB().remove((MStorage.IOnStorageChange)localObject1);
      this.JaP = null;
    }
    Object localObject1 = com.tencent.mm.plugin.webview.fts.a.INO;
    com.tencent.mm.kernel.g.azz().b(1532, (com.tencent.mm.ak.i)localObject1);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("hijackconfig", this.oUZ, true);
    if (this.JaL != null) {
      this.JaL.gct();
    }
    this.JaY.dead();
    localObject1 = com.tencent.mm.plugin.webview.fts.i.gaz();
    Object localObject2 = ((com.tencent.mm.plugin.webview.fts.i)localObject1).IOR;
    if (((i.a)localObject2).IPe != null) {
      com.tencent.mm.kernel.g.azz().a(((i.a)localObject2).IPe);
    }
    if (((i.a)localObject2).IPf != null) {
      ((i.a)localObject2).IPf.stopped = true;
    }
    ((com.tencent.mm.plugin.webview.fts.i)localObject1).IOZ.dead();
    com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.webview.j.a.class);
    com.tencent.mm.plugin.webview.ui.tools.floatball.b.bCN();
    com.tencent.mm.plugin.webview.ui.tools.multitask.a.euB();
    com.tencent.mm.plugin.webview.luggage.r.gcc();
    gdu().b(this.JaS);
    com.tencent.mm.plugin.game.api.a.b(this.JaT);
    AppMethodBeat.o(79184);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.g
 * JD-Core Version:    0.7.0.1
 */