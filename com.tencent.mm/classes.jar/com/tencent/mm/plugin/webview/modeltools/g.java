package com.tencent.mm.plugin.webview.modeltools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.c;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.cn.d;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.wd;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.webview.fts.g.a;
import com.tencent.mm.plugin.webview.fts.h;
import com.tencent.mm.plugin.webview.fts.h.a;
import com.tencent.mm.plugin.webview.fts.h.b;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.plugin.webview.luggage.t.1;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.au;
import com.tencent.mm.plugin.webview.ui.tools.bag.l;
import com.tencent.mm.plugin.webview.ui.tools.bag.l.b;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import org.xwalk.core.XWalkEnvironment;

public class g
  implements at
{
  private static final HashMap<Integer, h.d> baseDBFactories;
  private com.tencent.mm.sdk.b.c<bg> fAZ;
  public boolean isAppActive;
  private bz.a jKW;
  com.tencent.mm.sdk.b.c kMK;
  private com.tencent.mm.network.n mKL;
  private com.tencent.mm.plugin.webview.model.al uXF;
  private am uXG;
  private ak uXH;
  private m uXI;
  private com.tencent.mm.plugin.webview.model.e uXJ;
  private ao uXK;
  private com.tencent.mm.plugin.webview.b.e uXL;
  private h uXM;
  private com.tencent.mm.plugin.webview.fts.a uXN;
  private com.tencent.mm.plugin.webview.fts.b uXO;
  private com.tencent.mm.plugin.webview.c.a uXP;
  private com.tencent.mm.plugin.webview.luggage.a uXQ;
  private com.tencent.mm.plugin.game.api.g uXR;
  private com.tencent.mm.sdk.b.c uXS;
  private com.tencent.mm.sdk.b.c uXT;
  com.tencent.mm.sdk.b.c uXU;
  com.tencent.mm.sdk.b.c uXV;
  final com.tencent.mm.sdk.b.c<wd> uXW;
  com.tencent.mm.sdk.b.c uXX;
  final com.tencent.mm.sdk.b.c<k> uXY;
  com.tencent.mm.sdk.b.c uXZ;
  com.tencent.mm.sdk.b.c uYa;
  com.tencent.mm.sdk.b.c uYb;
  private com.tencent.mm.sdk.b.c uYc;
  
  static
  {
    AppMethodBeat.i(7006);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("WebViewHostsFilterTable".hashCode()), new g.18());
    baseDBFactories.put(Integer.valueOf("WEBVIEW_JSLOG_BLOCK_LIST_TABLE".hashCode()), new g.19());
    baseDBFactories.put(Integer.valueOf("WEBVIEW_LOCAL_DATA".hashCode()), new g.20());
    baseDBFactories.put(Integer.valueOf("WEBVIEW_DATA".hashCode()), new g.21());
    baseDBFactories.put(Integer.valueOf("WEBVIEW_HISTORY_DATA".hashCode()), new g.22());
    AppMethodBeat.o(7006);
  }
  
  public g()
  {
    AppMethodBeat.i(6991);
    this.uXR = new g.1(this);
    this.isAppActive = true;
    this.uXS = new g.12(this);
    this.uXT = new g.17(this);
    this.jKW = new g.3(this);
    this.uXU = new g.4(this);
    this.uXV = new g.5(this);
    this.uXW = new g.6(this);
    this.uXX = new g.7(this);
    this.kMK = new g.8(this);
    this.uXY = new g.9(this);
    this.uXZ = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(cr paramAnonymouscr)
      {
        AppMethodBeat.i(153149);
        String str1;
        if ((paramAnonymouscr instanceof cr))
        {
          paramAnonymouscr = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
          XWalkEnvironment.setIpType(com.tencent.mm.m.g.Nq().getInt("WebKernelMode", -1));
          str1 = com.tencent.mm.m.g.Nq().getValue("WebviewDownloadTbs");
          String str2 = com.tencent.mm.m.g.Nq().getValue("WebviewEnableTbs");
          ab.i("MicroMsg.SubCoreTools", "updateWebViewDynamicConfig, tbsDownload = %s, tbsEnable = %s, tbsSupportedVerSec = %s", new Object[] { str1, str2, com.tencent.mm.m.g.Nq().getValue("WebviewSupportedTbsVersionSection") });
          if (str1 != null) {
            paramAnonymouscr.putString("tbs_download", str1);
          }
          paramAnonymouscr.apply();
          if (("1".equals(str1)) && ("1".equals(str2))) {
            com.tencent.mm.pluginsdk.ui.tools.m.kS(1);
          }
          if (str1 == null) {}
        }
        try
        {
          if ("0".equals(str1))
          {
            ab.i("MicroMsg.SubCoreTools", "tbs download disable, reset tbssdk in sandbox");
            paramAnonymouscr = new Intent();
            paramAnonymouscr.setComponent(new ComponentName(ah.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
            ah.getContext().sendBroadcast(paramAnonymouscr);
          }
          AppMethodBeat.o(153149);
          return false;
        }
        catch (Exception paramAnonymouscr)
        {
          for (;;)
          {
            ab.w("MicroMsg.SubCoreTools", "sendbroadcast ,ex = %s", new Object[] { paramAnonymouscr.getMessage() });
          }
        }
      }
    };
    this.uYa = new g.11(this);
    this.uYb = new g.13(this);
    this.fAZ = new g.14(this);
    this.uYc = new g.15(this);
    this.mKL = new g.16(this);
    AppMethodBeat.o(6991);
  }
  
  public static com.tencent.mm.plugin.webview.fts.a dcA()
  {
    AppMethodBeat.i(6994);
    if (dcy().uXN == null) {
      dcy().uXN = new com.tencent.mm.plugin.webview.fts.a();
    }
    com.tencent.mm.plugin.webview.fts.a locala = dcy().uXN;
    AppMethodBeat.o(6994);
    return locala;
  }
  
  public static com.tencent.mm.plugin.webview.fts.b dcB()
  {
    AppMethodBeat.i(6995);
    if (dcy().uXO == null) {
      dcy().uXO = new com.tencent.mm.plugin.webview.fts.b();
    }
    com.tencent.mm.plugin.webview.fts.b localb = dcy().uXO;
    AppMethodBeat.o(6995);
    return localb;
  }
  
  public static h dcC()
  {
    AppMethodBeat.i(6996);
    if (dcy().uXM == null) {
      dcy().uXM = new h();
    }
    h localh = dcy().uXM;
    AppMethodBeat.o(6996);
    return localh;
  }
  
  public static com.tencent.mm.plugin.webview.model.al dcD()
  {
    AppMethodBeat.i(6997);
    if (dcy().uXF == null) {
      dcy().uXF = new com.tencent.mm.plugin.webview.model.al();
    }
    com.tencent.mm.plugin.webview.model.al localal = dcy().uXF;
    AppMethodBeat.o(6997);
    return localal;
  }
  
  public static am dcE()
  {
    AppMethodBeat.i(6998);
    if (dcy().uXG == null) {
      dcy().uXG = am.dbZ();
    }
    am localam = dcy().uXG;
    AppMethodBeat.o(6998);
    return localam;
  }
  
  public static m dcF()
  {
    AppMethodBeat.i(6999);
    if (dcy().uXI == null)
    {
      localObject = dcy();
      com.tencent.mm.kernel.g.RM();
      ((g)localObject).uXI = new m(com.tencent.mm.kernel.g.RL().eHS);
    }
    Object localObject = dcy().uXI;
    AppMethodBeat.o(6999);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.webview.model.e dcG()
  {
    AppMethodBeat.i(7000);
    if (dcy().uXJ == null)
    {
      localObject = dcy();
      com.tencent.mm.kernel.g.RM();
      ((g)localObject).uXJ = new com.tencent.mm.plugin.webview.model.e(com.tencent.mm.kernel.g.RL().eHS);
    }
    Object localObject = dcy().uXJ;
    AppMethodBeat.o(7000);
    return localObject;
  }
  
  public static ao dcH()
  {
    AppMethodBeat.i(7001);
    if (dcy().uXK == null)
    {
      localObject = dcy();
      com.tencent.mm.kernel.g.RM();
      ((g)localObject).uXK = new ao(com.tencent.mm.kernel.g.RL().eHS);
    }
    Object localObject = dcy().uXK;
    AppMethodBeat.o(7001);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.webview.b.e dcI()
  {
    AppMethodBeat.i(7002);
    if (dcy().uXL == null)
    {
      localObject = dcy();
      com.tencent.mm.kernel.g.RM();
      ((g)localObject).uXL = new com.tencent.mm.plugin.webview.b.e(com.tencent.mm.kernel.g.RL().eHS);
    }
    Object localObject = dcy().uXL;
    AppMethodBeat.o(7002);
    return localObject;
  }
  
  public static g dcy()
  {
    AppMethodBeat.i(6992);
    g localg = (g)q.S(g.class);
    AppMethodBeat.o(6992);
    return localg;
  }
  
  public static com.tencent.mm.plugin.webview.c.a dcz()
  {
    AppMethodBeat.i(6993);
    if (dcy().uXP == null) {
      dcy().uXP = new com.tencent.mm.plugin.webview.c.a();
    }
    com.tencent.mm.plugin.webview.c.a locala = dcy().uXP;
    AppMethodBeat.o(6993);
    return locala;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(7004);
    ab.i("MicroMsg.SubCoreTools", "onAccountPostReset hc:%d", new Object[] { Integer.valueOf(hashCode()) });
    this.uXS.alive();
    com.tencent.mm.sdk.b.a.ymk.c(this.uXX);
    com.tencent.mm.sdk.b.a.ymk.c(this.uXZ);
    com.tencent.mm.sdk.b.a.ymk.c(this.uYa);
    com.tencent.mm.sdk.b.a.ymk.c(this.uYb);
    com.tencent.mm.sdk.b.a.ymk.c(this.uXU);
    com.tencent.mm.sdk.b.a.ymk.c(this.uXV);
    com.tencent.mm.sdk.b.a.ymk.c(this.uYc);
    com.tencent.mm.sdk.b.a.ymk.c(this.fAZ);
    com.tencent.mm.sdk.b.a.ymk.c(this.kMK);
    if (AppForegroundDelegate.bXk.bLR) {
      com.tencent.mm.sdk.platformtools.al.d(new g.23(this));
    }
    this.uXY.alive();
    this.uXT.alive();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("hijackconfig", this.jKW, true);
    com.tencent.mm.kernel.g.RK().a(this.mKL);
    com.tencent.mm.plugin.w.c.qSb.a(new au());
    this.uXW.alive();
    j.c.a(new g.2(this));
    d.iO(ah.getContext());
    com.tencent.mm.kernel.g.RJ();
    XWalkEnvironment.setGrayValueByUserId(com.tencent.mm.kernel.a.getUin());
    if (com.tencent.mm.m.g.Nq() != null) {
      XWalkEnvironment.setIpType(com.tencent.mm.m.g.Nq().getInt("WebKernelMode", -1));
    }
    com.tencent.mm.plugin.webview.fts.g.daB();
    com.tencent.mm.plugin.webview.fts.g.start();
    ab.d("MicroMsg.CityServiceHelper", "addCheckResUpdateListener");
    if (ab.getLogLevel() <= 0)
    {
      b.c.dmg();
      com.tencent.mm.pluginsdk.g.a.a.b.LE(54);
    }
    Object localObject = new b.1();
    com.tencent.mm.sdk.b.a.ymk.b((com.tencent.mm.sdk.b.c)localObject);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.webview.e.a.class, new com.tencent.mm.plugin.webview.ui.tools.bag.m());
    this.uXQ = new com.tencent.mm.plugin.webview.luggage.a();
    dcD().a(this.uXQ);
    t.uTa = new t.1();
    localObject = l.vix;
    l.b localb = t.uTa;
    if (localb != null) {
      ((l)localObject).viC.add(localb);
    }
    if (com.tencent.mm.plugin.webview.luggage.a.b.uUp == null) {
      com.tencent.mm.plugin.webview.luggage.a.b.uUp = new com.tencent.mm.plugin.webview.luggage.a.b.1();
    }
    com.tencent.mm.plugin.downloader.b.a.a(com.tencent.mm.plugin.webview.luggage.a.b.uUp);
    com.tencent.mm.plugin.game.api.a.a(this.uXR);
    AppMethodBeat.o(7004);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(7003);
    ab.i("MicroMsg.SubCoreTools", "onAccountRelease hc:%d", new Object[] { Integer.valueOf(hashCode()) });
    this.uXS.dead();
    com.tencent.mm.sdk.b.a.ymk.d(this.uXX);
    com.tencent.mm.sdk.b.a.ymk.d(this.uXZ);
    com.tencent.mm.sdk.b.a.ymk.d(this.uYa);
    com.tencent.mm.sdk.b.a.ymk.d(this.uYb);
    com.tencent.mm.sdk.b.a.ymk.d(this.uXU);
    com.tencent.mm.sdk.b.a.ymk.d(this.uXV);
    com.tencent.mm.sdk.b.a.ymk.d(this.uYc);
    com.tencent.mm.sdk.b.a.ymk.d(this.fAZ);
    com.tencent.mm.sdk.b.a.ymk.d(this.kMK);
    this.uXY.dead();
    this.uXT.dead();
    com.tencent.mm.kernel.g.RK().b(this.mKL);
    if (this.uXH != null)
    {
      localObject1 = this.uXH;
      if (((ak)localObject1).rru != null)
      {
        com.tencent.mm.plugin.downloader.model.f.bjl();
        com.tencent.mm.plugin.downloader.model.c.b(((ak)localObject1).rru);
      }
      if ((((ak)localObject1).uWe != null) && (((ak)localObject1).uWe.size() > 0))
      {
        localObject1 = ((ak)localObject1).uWe.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Long)((Iterator)localObject1).next();
          ab.i("MicroMsg.WebViewAutoDownloader", "remove download task : %d", new Object[] { localObject2 });
          com.tencent.mm.plugin.downloader.model.f.bjl().iz(((Long)localObject2).longValue());
        }
      }
    }
    if (this.uXO != null)
    {
      localObject1 = this.uXO;
      com.tencent.mm.sdk.b.a.ymk.d(((com.tencent.mm.plugin.webview.fts.b)localObject1).hCe);
      if (((com.tencent.mm.plugin.webview.fts.b)localObject1).uOB != null)
      {
        com.tencent.mm.kernel.g.Rc().b(1048, (com.tencent.mm.ai.f)localObject1);
        com.tencent.mm.kernel.g.Rc().a(((com.tencent.mm.plugin.webview.fts.b)localObject1).uOB);
        ((com.tencent.mm.plugin.webview.fts.b)localObject1).uOB = null;
      }
      this.uXO = null;
    }
    if (this.uXM != null)
    {
      localObject1 = this.uXM;
      ((h)localObject1).uPn.dead();
      ((h)localObject1).uPz.dead();
      localObject2 = ((h)localObject1).uPB;
      if (((h.a)localObject2).uPs != null) {
        com.tencent.mm.kernel.g.Rc().a(((h.a)localObject2).uPs);
      }
      if (((h.a)localObject2).uPG != null) {
        ((h.a)localObject2).uPG.jFQ = true;
      }
      localObject2 = ((h)localObject1).uPC;
      if (((h.b)localObject2).uPI != null) {
        com.tencent.mm.kernel.g.Rc().b(((h.b)localObject2).uPI.getType(), ((h.b)localObject2).uPD);
      }
      if (((h)localObject1).mSV != null)
      {
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(((h)localObject1).mSV);
        ((h)localObject1).mSV = null;
      }
      this.uXM = null;
    }
    if (this.uXN != null)
    {
      localObject1 = this.uXN;
      ((com.tencent.mm.plugin.webview.fts.a)localObject1).rbF.dead();
      ((com.tencent.mm.plugin.webview.fts.a)localObject1).uOv.dead();
      o.adg().remove((k.a)localObject1);
      this.uXN = null;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("hijackconfig", this.jKW, true);
    if (this.uXJ != null) {
      this.uXJ.dbI();
    }
    this.uXW.dead();
    Object localObject1 = com.tencent.mm.plugin.webview.fts.g.daB();
    Object localObject2 = ((com.tencent.mm.plugin.webview.fts.g)localObject1).uPg;
    if (((g.a)localObject2).uPs != null) {
      com.tencent.mm.kernel.g.Rc().a(((g.a)localObject2).uPs);
    }
    if (((g.a)localObject2).uPt != null) {
      ((g.a)localObject2).uPt.jFQ = true;
    }
    ((com.tencent.mm.plugin.webview.fts.g)localObject1).uPn.dead();
    com.tencent.mm.kernel.g.F(com.tencent.mm.plugin.webview.e.a.class);
    dcD().b(this.uXQ);
    localObject1 = l.vix;
    localObject2 = t.uTa;
    if (localObject2 != null) {
      ((l)localObject1).viC.remove(localObject2);
    }
    com.tencent.mm.plugin.downloader.b.a.b(com.tencent.mm.plugin.webview.luggage.a.b.uUp);
    com.tencent.mm.plugin.webview.luggage.a.b.uUp = null;
    com.tencent.mm.plugin.game.api.a.b(this.uXR);
    AppMethodBeat.o(7003);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.g
 * JD-Core Version:    0.7.0.1
 */