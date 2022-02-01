package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.adz;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.message.k.c;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.model.y;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.webview.fts.i.a;
import com.tencent.mm.plugin.webview.fts.j;
import com.tencent.mm.plugin.webview.fts.j.b;
import com.tencent.mm.plugin.webview.fts.j.c;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.aq;
import com.tencent.mm.plugin.webview.model.at;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.model.d;
import com.tencent.mm.pluginsdk.model.ad.a;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  implements be
{
  private static final HashMap<Integer, h.b> baseDBFactories;
  private p ItW;
  private an WND;
  private com.tencent.mm.plugin.webview.model.ao WNE;
  private am WNF;
  private n WNG;
  private com.tencent.mm.plugin.webview.model.g WNH;
  private aq WNI;
  private com.tencent.mm.plugin.webview.b.e WNJ;
  private j WNK;
  private com.tencent.mm.plugin.webview.fts.b WNL;
  private com.tencent.mm.plugin.webview.fts.c WNM;
  private com.tencent.mm.plugin.webview.emojistore.a WNN;
  private com.tencent.mm.plugin.webview.luggage.a WNO;
  private com.tencent.mm.plugin.game.api.i WNP;
  public boolean WNQ;
  private IListener WNR;
  IListener WNS;
  IListener WNT;
  final IListener<adz> WNU;
  IListener WNV;
  final IListener<com.tencent.mm.autogen.a.n> WNW;
  IListener WNX;
  IListener WNY;
  IListener WNZ;
  private IListener WOa;
  private q.a appForegroundListener;
  private IListener<cd> oDs;
  private cl.a vip;
  
  static
  {
    AppMethodBeat.i(79187);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("WebViewHostsFilterTable".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return n.SQL_CREATE;
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
    this.WNP = new com.tencent.mm.plugin.game.api.i()
    {
      public final void fn(String paramAnonymousString, int paramAnonymousInt)
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
      
      public final void h(String paramAnonymousString, float paramAnonymousFloat)
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
    this.WNQ = true;
    this.WNR = new SubCoreTools.2(this, com.tencent.mm.app.f.hfK);
    this.vip = new cl.a()
    {
      public final void a(final g.a paramAnonymousa)
      {
        AppMethodBeat.i(295823);
        paramAnonymousa = w.a(paramAnonymousa.mpN.YFG);
        final n localn = g.iwa();
        com.tencent.threadpool.h.ahAA.bp(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(295778);
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
                localn.insert(locali);
                break;
              }
              AppMethodBeat.o(295778);
              return;
            }
          }
        });
        AppMethodBeat.o(295823);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.WNS = new SubCoreTools.10(this, com.tencent.mm.app.f.hfK);
    this.WNT = new SubCoreTools.11(this, com.tencent.mm.app.f.hfK);
    this.WNU = new SubCoreTools.12(this, com.tencent.mm.app.f.hfK);
    this.WNV = new SubCoreTools.13(this, com.tencent.mm.app.f.hfK);
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(295852);
        g.a(g.this, false);
        AppMethodBeat.o(295852);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(295849);
        g.a(g.this, true);
        AppMethodBeat.o(295849);
      }
    };
    this.WNW = new SubCoreTools.15(this, com.tencent.mm.app.f.hfK);
    this.WNX = new SubCoreTools.16(this, com.tencent.mm.app.f.hfK);
    this.WNY = new SubCoreTools.17(this, com.tencent.mm.app.f.hfK);
    this.WNZ = new SubCoreTools.18(this, com.tencent.mm.app.f.hfK);
    this.oDs = new SubCoreTools.19(this, com.tencent.mm.app.f.hfK);
    this.WOa = new SubCoreTools.20(this, com.tencent.mm.app.f.hfK);
    this.ItW = new p.a()
    {
      private final byte[] lrK;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(295845);
        synchronized (this.lrK)
        {
          String str = aa.fTX();
          if (str.equalsIgnoreCase("WIFI"))
          {
            ax.ivy().setNetWorkState(1);
            g.bkO(str);
            AppMethodBeat.o(295845);
            return;
          }
          ax.ivy().setNetWorkState(2);
        }
      }
    };
    AppMethodBeat.o(79172);
  }
  
  public static g ivT()
  {
    AppMethodBeat.i(79173);
    g localg = (g)y.aL(g.class);
    AppMethodBeat.o(79173);
    return localg;
  }
  
  public static com.tencent.mm.plugin.webview.emojistore.a ivU()
  {
    AppMethodBeat.i(79174);
    if (ivT().WNN == null) {
      ivT().WNN = new com.tencent.mm.plugin.webview.emojistore.a();
    }
    com.tencent.mm.plugin.webview.emojistore.a locala = ivT().WNN;
    AppMethodBeat.o(79174);
    return locala;
  }
  
  public static com.tencent.mm.plugin.webview.fts.b ivV()
  {
    AppMethodBeat.i(79175);
    if (ivT().WNL == null) {
      ivT().WNL = new com.tencent.mm.plugin.webview.fts.b();
    }
    com.tencent.mm.plugin.webview.fts.b localb = ivT().WNL;
    AppMethodBeat.o(79175);
    return localb;
  }
  
  public static com.tencent.mm.plugin.webview.fts.c ivW()
  {
    AppMethodBeat.i(79176);
    if (ivT().WNM == null) {
      ivT().WNM = new com.tencent.mm.plugin.webview.fts.c();
    }
    com.tencent.mm.plugin.webview.fts.c localc = ivT().WNM;
    AppMethodBeat.o(79176);
    return localc;
  }
  
  public static j ivX()
  {
    AppMethodBeat.i(79177);
    if (ivT().WNK == null) {
      ivT().WNK = new j();
    }
    j localj = ivT().WNK;
    AppMethodBeat.o(79177);
    return localj;
  }
  
  public static an ivY()
  {
    AppMethodBeat.i(79178);
    if (ivT().WND == null) {
      ivT().WND = new an();
    }
    an localan = ivT().WND;
    AppMethodBeat.o(79178);
    return localan;
  }
  
  public static com.tencent.mm.plugin.webview.model.ao ivZ()
  {
    AppMethodBeat.i(79179);
    if (ivT().WNE == null) {
      ivT().WNE = com.tencent.mm.plugin.webview.model.ao.ivu();
    }
    com.tencent.mm.plugin.webview.model.ao localao = ivT().WNE;
    AppMethodBeat.o(79179);
    return localao;
  }
  
  public static n iwa()
  {
    AppMethodBeat.i(79180);
    if (ivT().WNG == null)
    {
      localObject = ivT();
      com.tencent.mm.kernel.h.baF();
      ((g)localObject).WNG = new n(com.tencent.mm.kernel.h.baE().mCN);
    }
    Object localObject = ivT().WNG;
    AppMethodBeat.o(79180);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.webview.model.g iwb()
  {
    AppMethodBeat.i(79181);
    if (ivT().WNH == null)
    {
      localObject = ivT();
      com.tencent.mm.kernel.h.baF();
      ((g)localObject).WNH = new com.tencent.mm.plugin.webview.model.g(com.tencent.mm.kernel.h.baE().mCN);
    }
    Object localObject = ivT().WNH;
    AppMethodBeat.o(79181);
    return localObject;
  }
  
  public static aq iwc()
  {
    AppMethodBeat.i(79182);
    if (ivT().WNI == null)
    {
      localObject = ivT();
      com.tencent.mm.kernel.h.baF();
      ((g)localObject).WNI = new aq(com.tencent.mm.kernel.h.baE().mCN);
    }
    Object localObject = ivT().WNI;
    AppMethodBeat.o(79182);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.webview.b.e iwd()
  {
    AppMethodBeat.i(79183);
    if (ivT().WNJ == null)
    {
      localObject = ivT();
      com.tencent.mm.kernel.h.baF();
      ((g)localObject).WNJ = new com.tencent.mm.plugin.webview.b.e(com.tencent.mm.kernel.h.baE().mCN);
    }
    Object localObject = ivT().WNJ;
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
    this.WNV.alive();
    this.WNX.alive();
    this.WNY.alive();
    this.WNZ.alive();
    this.WNS.alive();
    this.WNT.alive();
    this.WOa.alive();
    this.oDs.alive();
    this.appForegroundListener.alive();
    this.WNW.alive();
    this.WNR.alive();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("hijackconfig", this.vip, true);
    com.tencent.mm.kernel.h.baD().a(this.ItW);
    com.tencent.mm.plugin.an.c.PET.a(new d());
    com.tencent.mm.plugin.an.c.PET.a(new at());
    this.WNU.alive();
    k.c.a(new com.tencent.mm.cp.c() {});
    com.tencent.mm.xwebutil.c.nU(MMApplicationContext.getContext());
    com.tencent.mm.kernel.h.baC();
    boolean bool = com.tencent.xweb.ao.setGrayValueByUserId(com.tencent.mm.kernel.b.getUin());
    if (com.tencent.mm.k.i.aRC() != null) {}
    for (paramBoolean = com.tencent.xweb.ao.aJA(com.tencent.mm.k.i.aRC().getInt("WebKernelMode", -1));; paramBoolean = false)
    {
      Log.i("MicroMsg.SubCoreTools", "onAccountPostReset, hasChangedGrayValue:%s, hasChangedIPType:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
      if ((bool) || (paramBoolean))
      {
        MMApplicationContext.getContext();
        ad.a.avN(5);
      }
      com.tencent.mm.plugin.webview.fts.i.ite();
      com.tencent.mm.plugin.webview.fts.i.start();
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.webview.i.a.class, new com.tencent.mm.plugin.webview.ui.tools.bag.e());
      com.tencent.mm.plugin.webview.ui.tools.floatball.b.cou();
      com.tencent.mm.plugin.webview.ui.tools.multitask.a.evw();
      com.tencent.mm.plugin.webview.luggage.s.iuI();
      this.WNO = new com.tencent.mm.plugin.webview.luggage.a();
      ivY().a(this.WNO);
      com.tencent.mm.plugin.game.api.a.a(this.WNP);
      com.tencent.mm.plugin.webview.fts.a locala = com.tencent.mm.plugin.webview.fts.a.WAv;
      com.tencent.mm.kernel.h.aZW().a(1532, (com.tencent.mm.am.h)locala);
      ivX();
      AppMethodBeat.o(79185);
      return;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(79184);
    Log.i("MicroMsg.SubCoreTools", "onAccountRelease hc:%d", new Object[] { Integer.valueOf(hashCode()) });
    this.WNV.dead();
    this.WNX.dead();
    this.WNY.dead();
    this.WNZ.dead();
    this.WNS.dead();
    this.WNT.dead();
    this.WOa.dead();
    this.oDs.dead();
    this.appForegroundListener.dead();
    this.WNW.dead();
    this.WNR.dead();
    com.tencent.mm.kernel.h.baD().b(this.ItW);
    if (this.WNF != null)
    {
      AppMethodBeat.o(79184);
      throw null;
    }
    if (this.WNM != null)
    {
      localObject1 = this.WNM;
      com.tencent.mm.kernel.h.aZW().b(2975, (com.tencent.mm.am.h)localObject1);
      ((com.tencent.mm.plugin.webview.fts.c)localObject1).rDF.dead();
      if (((com.tencent.mm.plugin.webview.fts.c)localObject1).HAc != null)
      {
        com.tencent.mm.kernel.h.aZW().b(1048, (com.tencent.mm.am.h)localObject1);
        com.tencent.mm.kernel.h.aZW().a(((com.tencent.mm.plugin.webview.fts.c)localObject1).HAc);
        ((com.tencent.mm.plugin.webview.fts.c)localObject1).HAc = null;
      }
      this.WNM = null;
    }
    if (this.WNK != null)
    {
      localObject1 = this.WNK;
      ((j)localObject1).WBC.dead();
      ((j)localObject1).WBO.dead();
      localObject2 = ((j)localObject1).WBR;
      if (((j.b)localObject2).WBH != null) {
        com.tencent.mm.kernel.h.aZW().a(((j.b)localObject2).WBH);
      }
      if (((j.b)localObject2).WBX != null) {
        ((j.b)localObject2).WBX.cBt = true;
      }
      localObject2 = ((j)localObject1).WBS;
      if (((j.c)localObject2).WBZ != null) {
        com.tencent.mm.kernel.h.aZW().b(((j.c)localObject2).WBZ.getType(), ((j.c)localObject2).WBT);
      }
      if (((j)localObject1).HtE != null)
      {
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(((j)localObject1).HtE);
        ((j)localObject1).HtE = null;
      }
      ((j)localObject1).WBQ.WBg.clear();
      ((j)localObject1).WBt.removeCallbacksAndMessages(null);
      ((j)localObject1).WBt.quit();
      this.WNK = null;
    }
    if (this.WNL != null)
    {
      localObject1 = this.WNL;
      ((com.tencent.mm.plugin.webview.fts.b)localObject1).QoU.dead();
      ((com.tencent.mm.plugin.webview.fts.b)localObject1).WAB.dead();
      q.bFE().remove((MStorage.IOnStorageChange)localObject1);
      this.WNL = null;
    }
    Object localObject1 = com.tencent.mm.plugin.webview.fts.a.WAv;
    com.tencent.mm.kernel.h.aZW().b(1532, (com.tencent.mm.am.h)localObject1);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("hijackconfig", this.vip, true);
    if (this.WNH != null) {
      this.WNH.iuZ();
    }
    this.WNU.dead();
    localObject1 = com.tencent.mm.plugin.webview.fts.i.ite();
    Object localObject2 = ((com.tencent.mm.plugin.webview.fts.i)localObject1).WBv;
    if (((i.a)localObject2).WBH != null) {
      com.tencent.mm.kernel.h.aZW().a(((i.a)localObject2).WBH);
    }
    if (((i.a)localObject2).WBI != null) {
      ((i.a)localObject2).WBI.cBt = true;
    }
    ((com.tencent.mm.plugin.webview.fts.i)localObject1).WBC.dead();
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.webview.i.a.class);
    com.tencent.mm.plugin.webview.ui.tools.floatball.b.cov();
    com.tencent.mm.plugin.webview.ui.tools.multitask.a.evx();
    com.tencent.mm.plugin.webview.luggage.s.iuJ();
    ivY().b(this.WNO);
    com.tencent.mm.plugin.game.api.a.b(this.WNP);
    AppMethodBeat.o(79184);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.g
 * JD-Core Version:    0.7.0.1
 */