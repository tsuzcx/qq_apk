package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.bn.a;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.lh.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.plugin.websearch.api.l;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginWebSearch
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.websearch.api.c
{
  static final int[] DSv;
  private static HashMap<Integer, h.b> cPO;
  private q BIf;
  private a DSt;
  private b DSu;
  private final com.tencent.mm.sdk.b.c checkLanguageChangeIListener;
  private com.tencent.mm.sdk.b.c jkx;
  private com.tencent.mm.sdk.b.c oaM;
  
  static
  {
    AppMethodBeat.i(116525);
    cPO = new HashMap();
    String str = com.tencent.mm.sdk.e.j.getCreateSQLs(com.tencent.mm.plugin.websearch.widget.a.a.info, "WidgetSafeMode");
    cPO.put(Integer.valueOf("WidgetSafeMode".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return this.cPQ;
      }
    });
    DSv = new int[] { 64 };
    AppMethodBeat.o(116525);
  }
  
  public PluginWebSearch()
  {
    AppMethodBeat.i(116518);
    this.checkLanguageChangeIListener = new com.tencent.mm.sdk.b.c() {};
    this.jkx = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(bn paramAnonymousbn)
      {
        AppMethodBeat.i(168797);
        int k;
        if (paramAnonymousbn != null)
        {
          int i;
          int m;
          if ((paramAnonymousbn.dny.dnz == 27) && (paramAnonymousbn.dny.subType == 1))
          {
            i = 0;
            k = i * 30;
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(1181L, k + 0, 1L, false);
            m = ao.aHp(paramAnonymousbn.dny.filePath);
            if (m != 1) {
              break label317;
            }
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(1181L, k + 1, 1L, false);
          }
          ao localao;
          for (;;)
          {
            localao = ad.WJ(i);
            if (m < localao.aHD()) {
              break label417;
            }
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(1181L, k + 4, 1L, false);
            int j = 0;
            while (j < 3)
            {
              localao.aHo(paramAnonymousbn.dny.filePath);
              if (localao.eQl()) {
                break;
              }
              ae.i("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate invalid md5 and delete template folder retryTimes:%s", new Object[] { Integer.valueOf(j) });
              j += 1;
            }
            if ((paramAnonymousbn.dny.dnz == 27) && (paramAnonymousbn.dny.subType == 2))
            {
              i = 1;
              break;
            }
            if ((paramAnonymousbn.dny.dnz == 62) && (paramAnonymousbn.dny.subType == 1))
            {
              i = 2;
              break;
            }
            if ((paramAnonymousbn.dny.dnz == 40) && (paramAnonymousbn.dny.subType == 1))
            {
              i = 3;
              break;
            }
            if ((paramAnonymousbn.dny.dnz == 64) && (paramAnonymousbn.dny.subType == 1))
            {
              i = 4;
              break;
            }
            if ((paramAnonymousbn.dny.dnz == 66) && (paramAnonymousbn.dny.subType == 1))
            {
              i = 5;
              break;
            }
            AppMethodBeat.o(168797);
            return false;
            label317:
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(1181L, k + 2, 1L, false);
          }
          if (!localao.eQl()) {
            break label392;
          }
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(1181L, k + 6, 1L, false);
          ae.w("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate final update success version %d", new Object[] { Integer.valueOf(m) });
          if (i == 0) {
            ad.ePO();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(168797);
          return false;
          label392:
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(1181L, k + 5, 1L, false);
          ae.w("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate final md5 is invalid!");
          continue;
          label417:
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(1181L, k + 3, 1L, false);
        }
      }
    };
    this.oaM = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(lh paramAnonymouslh)
      {
        int i = 1;
        AppMethodBeat.i(168799);
        if ((paramAnonymouslh.dzH.dnz == 27) && (paramAnonymouslh.dzH.subType == 1)) {
          i = 0;
        }
        for (;;)
        {
          ad.WJ(i).aHo(paramAnonymouslh.dzH.filePath);
          if (i == 0) {
            ad.ePO();
          }
          AppMethodBeat.o(168799);
          return false;
          if ((paramAnonymouslh.dzH.dnz != 27) || (paramAnonymouslh.dzH.subType != 2)) {
            if ((paramAnonymouslh.dzH.dnz == 62) && (paramAnonymouslh.dzH.subType == 1))
            {
              i = 2;
            }
            else if ((paramAnonymouslh.dzH.dnz == 40) && (paramAnonymouslh.dzH.subType == 1))
            {
              i = 3;
            }
            else if ((paramAnonymouslh.dzH.dnz == 64) && (paramAnonymouslh.dzH.subType == 1))
            {
              i = 4;
            }
            else
            {
              if ((paramAnonymouslh.dzH.dnz != 66) || (paramAnonymouslh.dzH.subType != 1)) {
                break;
              }
              i = 5;
            }
          }
        }
        AppMethodBeat.o(168799);
        return false;
      }
    };
    this.BIf = new PluginWebSearch.7(this);
    AppMethodBeat.o(116518);
  }
  
  private void checkWebSearchTemplate(boolean paramBoolean)
  {
    AppMethodBeat.i(116523);
    ae.i("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate %b", new Object[] { Boolean.valueOf(paramBoolean) });
    int j = 0;
    int k;
    ao localao;
    int m;
    int n;
    int i;
    if (j < 6)
    {
      k = new int[] { 0, 1, 2, 3, 4, 5 }[j];
      localao = ad.WJ(k);
      m = localao.aHE();
      localao.eQd();
      n = localao.aHD();
      if (n == 1)
      {
        ae.i("MicroMsg.WebSearch.PluginWebSearch", "first time init template");
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        localao.eQm();
      }
      if (!localao.eQl())
      {
        i = 1;
        for (;;)
        {
          if (i <= 3)
          {
            ae.i("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate invalid md5 and delete template folder retryTimes:%s", new Object[] { Integer.valueOf(i) });
            localao.eQm();
            if (!localao.eQl())
            {
              i += 1;
              continue;
              com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
              if (com.tencent.mm.util.c.aZw(com.tencent.mm.util.c.mz("search", "openResetTemplate")) == 1) {}
              for (i = 1;; i = 0)
              {
                if (i == 0) {
                  break label208;
                }
                ae.i("MicroMsg.WebSearch.PluginWebSearch", "expt reset template");
                i = 1;
                break;
              }
              label208:
              if (n >= m) {
                break label295;
              }
              ae.i("MicroMsg.WebSearch.PluginWebSearch", "update template currentVersion %d assetVersion %d", new Object[] { Integer.valueOf(n), Integer.valueOf(m) });
              i = 1;
              break;
            }
          }
        }
      }
      if (!localao.eQl())
      {
        ae.w("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate final md5 is invalid!");
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(1181L, k * 30 + 7, 1L, false);
      }
      j += 1;
      break;
      AppMethodBeat.o(116523);
      return;
      label295:
      i = 0;
    }
  }
  
  private void manualCheckRes()
  {
    AppMethodBeat.i(168802);
    ay localay = ay.aRX("MicroMsg.WebSearch.PluginWebSearch");
    long l1 = localay.decodeLong("last_check_res_time", 0L);
    long l2 = System.currentTimeMillis();
    long l3 = Math.abs(l2 - l1);
    if (l3 < 86400000L)
    {
      ae.i("MicroMsg.WebSearch.PluginWebSearch", "manualCheckRes return lastCheckTime %d, current %d, gap %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      AppMethodBeat.o(168802);
      return;
    }
    localay.encode("last_check_res_time", l2);
    ae.i("MicroMsg.WebSearch.PluginWebSearch", "manualCheckRes");
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168796);
        int[] arrayOfInt = PluginWebSearch.DSv;
        int j = arrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          int k = arrayOfInt[i];
          com.tencent.mm.pluginsdk.j.a.a.b.fes();
          com.tencent.mm.pluginsdk.j.a.a.b.Zd(k);
          i += 1;
        }
        AppMethodBeat.o(168796);
      }
    }, 3000L);
    AppMethodBeat.o(168802);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return cPO;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(116520);
    super.configure(paramg);
    this.DSt = new a();
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.h.class, new com.tencent.mm.kernel.c.e(this.DSt));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.j.class, new com.tencent.mm.kernel.c.e(new c()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.f.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.b()));
    com.tencent.mm.kernel.g.a(l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.c()));
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).akL())
    {
      this.DSu = new b();
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.i.class, new com.tencent.mm.kernel.c.e(this.DSu));
    }
    AppMethodBeat.o(116520);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(116519);
    super.installed();
    AppMethodBeat.o(116519);
  }
  
  public boolean isOpenFingerSearch()
  {
    AppMethodBeat.i(209738);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
    if (com.tencent.mm.util.c.fSh())
    {
      localc = com.tencent.mm.util.c.LDf;
      if (com.tencent.mm.util.c.aZw(com.tencent.mm.util.c.mz("search", "openFingerSearch")) == 1)
      {
        AppMethodBeat.o(209738);
        return true;
      }
      AppMethodBeat.o(209738);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLf, 0) == 1)
    {
      AppMethodBeat.o(209738);
      return true;
    }
    AppMethodBeat.o(209738);
    return false;
  }
  
  public boolean isOpenHotWordSearch()
  {
    AppMethodBeat.i(209739);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
    if (com.tencent.mm.util.c.fSh())
    {
      localc = com.tencent.mm.util.c.LDf;
      if (com.tencent.mm.util.c.aZw(com.tencent.mm.util.c.mz("search", "openHotWordSearch")) == 1)
      {
        AppMethodBeat.o(209739);
        return true;
      }
      AppMethodBeat.o(209739);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLg, 0) == 1)
    {
      AppMethodBeat.o(209739);
      return true;
    }
    AppMethodBeat.o(209739);
    return false;
  }
  
  public boolean isOpenImageSearch()
  {
    AppMethodBeat.i(209740);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
    if (com.tencent.mm.util.c.fSh())
    {
      localc = com.tencent.mm.util.c.LDf;
      if (com.tencent.mm.util.c.aZw(com.tencent.mm.util.c.mz("search", "openImageSearch")) == 1)
      {
        AppMethodBeat.o(209740);
        return true;
      }
      AppMethodBeat.o(209740);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qLh, 0) == 1)
    {
      AppMethodBeat.o(209740);
      return true;
    }
    AppMethodBeat.o(209740);
    return false;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(116521);
    this.jkx.alive();
    this.oaM.alive();
    manualCheckRes();
    this.checkLanguageChangeIListener.alive();
    b.init();
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.BIf);
    com.tencent.e.h.MqF.f(new a(paramc.gEo), "WebSearchThread");
    ad.CI(5000L);
    ad.CJ(5000L);
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116511);
        long l = ad.WL(0);
        if (((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IZa, Long.valueOf(0L))).longValue() != l)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(17040, new Object[] { Integer.valueOf(2), Long.valueOf(l) });
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IZa, Long.valueOf(l));
          com.tencent.mm.kernel.g.ajR().ajA().fuc();
        }
        AppMethodBeat.o(116511);
      }
    }, "WebSearchThread");
    AppMethodBeat.o(116521);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(116522);
    this.jkx.dead();
    this.oaM.dead();
    this.checkLanguageChangeIListener.dead();
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", this.BIf);
    com.tencent.mm.plugin.websearch.api.ah.DUb = null;
    AppMethodBeat.o(116522);
  }
  
  public void parallelsDependency() {}
  
  public void startImageSearch(o paramo)
  {
    AppMethodBeat.i(209741);
    ae.i("MicroMsg.WebSearch.PluginWebSearch", "startImageSearch %s %s", new Object[] { Long.valueOf(paramo.dCi.field_msgId), Integer.valueOf(paramo.doR) });
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(ak.getPackageName(), "com.tencent.mm.plugin.websearch.ui.WebSearchImageLoadingUI");
    ((Intent)localObject).putExtra("key_source", paramo.doR);
    ((Intent)localObject).putExtra("key_msg_id", paramo.dCi.field_msgId);
    paramo = paramo.context;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramo, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/websearch/PluginWebSearch", "startImageSearch", "(Lcom/tencent/mm/plugin/websearch/api/ImageSearchContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramo.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramo, "com/tencent/mm/plugin/websearch/PluginWebSearch", "startImageSearch", "(Lcom/tencent/mm/plugin/websearch/api/ImageSearchContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(209741);
  }
  
  final class a
    implements Runnable
  {
    boolean DSx;
    
    a(boolean paramBoolean)
    {
      this.DSx = paramBoolean;
    }
    
    public final void run()
    {
      AppMethodBeat.i(116517);
      PluginWebSearch.access$100(PluginWebSearch.this, this.DSx);
      AppMethodBeat.o(116517);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch
 * JD-Core Version:    0.7.0.1
 */