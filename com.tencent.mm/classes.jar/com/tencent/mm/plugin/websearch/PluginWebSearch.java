package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bi;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.bk.a;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.g.a.kx.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.k;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginWebSearch
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c
{
  static final int[] BXI;
  private static HashMap<Integer, h.b> cDZ;
  private a BXG;
  private b BXH;
  private com.tencent.mm.sdk.b.c BXJ;
  private final com.tencent.mm.sdk.b.c checkLanguageChangeIListener;
  private com.tencent.mm.sdk.b.c iOv;
  private p zYU;
  
  static
  {
    AppMethodBeat.i(116525);
    cDZ = new HashMap();
    String str = j.getCreateSQLs(com.tencent.mm.plugin.websearch.widget.a.a.info, "WidgetSafeMode");
    cDZ.put(Integer.valueOf("WidgetSafeMode".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return this.cEb;
      }
    });
    BXI = new int[] { 64 };
    AppMethodBeat.o(116525);
  }
  
  public PluginWebSearch()
  {
    AppMethodBeat.i(116518);
    this.checkLanguageChangeIListener = new com.tencent.mm.sdk.b.c() {};
    this.iOv = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(bk paramAnonymousbk)
      {
        AppMethodBeat.i(168797);
        int k;
        if (paramAnonymousbk != null)
        {
          int i;
          int m;
          if ((paramAnonymousbk.dbc.dbd == 27) && (paramAnonymousbk.dbc.subType == 1))
          {
            i = 0;
            k = i * 30;
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(1181L, k + 0, 1L, false);
            m = ak.aAB(paramAnonymousbk.dbc.filePath);
            if (m != 1) {
              break label317;
            }
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(1181L, k + 1, 1L, false);
          }
          ak localak;
          for (;;)
          {
            localak = z.Uj(i);
            if (m < localak.aEh()) {
              break label417;
            }
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(1181L, k + 4, 1L, false);
            int j = 0;
            while (j < 3)
            {
              localak.aAA(paramAnonymousbk.dbc.filePath);
              if (localak.exJ()) {
                break;
              }
              ac.i("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate invalid md5 and delete template folder retryTimes:%s", new Object[] { Integer.valueOf(j) });
              j += 1;
            }
            if ((paramAnonymousbk.dbc.dbd == 27) && (paramAnonymousbk.dbc.subType == 2))
            {
              i = 1;
              break;
            }
            if ((paramAnonymousbk.dbc.dbd == 62) && (paramAnonymousbk.dbc.subType == 1))
            {
              i = 2;
              break;
            }
            if ((paramAnonymousbk.dbc.dbd == 40) && (paramAnonymousbk.dbc.subType == 1))
            {
              i = 3;
              break;
            }
            if ((paramAnonymousbk.dbc.dbd == 64) && (paramAnonymousbk.dbc.subType == 1))
            {
              i = 4;
              break;
            }
            if ((paramAnonymousbk.dbc.dbd == 66) && (paramAnonymousbk.dbc.subType == 1))
            {
              i = 5;
              break;
            }
            AppMethodBeat.o(168797);
            return false;
            label317:
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(1181L, k + 2, 1L, false);
          }
          if (!localak.exJ()) {
            break label392;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(1181L, k + 6, 1L, false);
          ac.w("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate final update success version %d", new Object[] { Integer.valueOf(m) });
          if (i == 0) {
            z.exp();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(168797);
          return false;
          label392:
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(1181L, k + 5, 1L, false);
          ac.w("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate final md5 is invalid!");
          continue;
          label417:
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(1181L, k + 3, 1L, false);
        }
      }
    };
    this.BXJ = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(kx paramAnonymouskx)
      {
        int i = 1;
        AppMethodBeat.i(168799);
        if ((paramAnonymouskx.dmO.dbd == 27) && (paramAnonymouskx.dmO.subType == 1)) {
          i = 0;
        }
        for (;;)
        {
          z.Uj(i).aAA(paramAnonymouskx.dmO.filePath);
          if (i == 0) {
            z.exp();
          }
          AppMethodBeat.o(168799);
          return false;
          if ((paramAnonymouskx.dmO.dbd != 27) || (paramAnonymouskx.dmO.subType != 2)) {
            if ((paramAnonymouskx.dmO.dbd == 62) && (paramAnonymouskx.dmO.subType == 1))
            {
              i = 2;
            }
            else if ((paramAnonymouskx.dmO.dbd == 40) && (paramAnonymouskx.dmO.subType == 1))
            {
              i = 3;
            }
            else if ((paramAnonymouskx.dmO.dbd == 64) && (paramAnonymouskx.dmO.subType == 1))
            {
              i = 4;
            }
            else
            {
              if ((paramAnonymouskx.dmO.dbd != 66) || (paramAnonymouskx.dmO.subType != 1)) {
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
    this.zYU = new PluginWebSearch.7(this);
    AppMethodBeat.o(116518);
  }
  
  private void checkWebSearchTemplate(boolean paramBoolean)
  {
    AppMethodBeat.i(116523);
    ac.i("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate %b", new Object[] { Boolean.valueOf(paramBoolean) });
    int[] arrayOfInt = new int[6];
    int[] tmp31_29 = arrayOfInt;
    tmp31_29[0] = 0;
    int[] tmp35_31 = tmp31_29;
    tmp35_31[1] = 1;
    int[] tmp39_35 = tmp35_31;
    tmp39_35[2] = 2;
    int[] tmp43_39 = tmp39_35;
    tmp43_39[3] = 3;
    int[] tmp47_43 = tmp43_39;
    tmp47_43[4] = 4;
    int[] tmp51_47 = tmp47_43;
    tmp51_47[5] = 5;
    tmp51_47;
    int i;
    ak localak;
    if (paramBoolean)
    {
      i = 0;
      while (i < 6)
      {
        localak = z.Uj(arrayOfInt[i]);
        com.tencent.mm.vfs.i.cU(localak.exF(), true);
        localak.exD();
        i += 1;
      }
    }
    int j = 0;
    int k;
    int m;
    int n;
    if (j < 6)
    {
      k = arrayOfInt[j];
      localak = z.Uj(k);
      m = localak.aEi();
      localak.exD();
      n = localak.aEh();
      if (n == 1)
      {
        ac.i("MicroMsg.WebSearch.PluginWebSearch", "first time init template");
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        localak.exK();
      }
      if (!localak.exJ())
      {
        i = 1;
        for (;;)
        {
          if (i <= 3)
          {
            ac.i("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate invalid md5 and delete template folder retryTimes:%s", new Object[] { Integer.valueOf(i) });
            localak.exK();
            if (!localak.exJ())
            {
              i += 1;
              continue;
              if ((com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GWl, 0) & 0x8) > 0) {}
              for (i = 1;; i = 0)
              {
                if (i == 0) {
                  break label258;
                }
                ac.i("MicroMsg.WebSearch.PluginWebSearch", "expt reset template");
                i = 1;
                break;
              }
              label258:
              if (n >= m) {
                break label345;
              }
              ac.i("MicroMsg.WebSearch.PluginWebSearch", "update template currentVersion %d assetVersion %d", new Object[] { Integer.valueOf(n), Integer.valueOf(m) });
              i = 1;
              break;
            }
          }
        }
      }
      if (!localak.exJ())
      {
        ac.w("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate final md5 is invalid!");
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(1181L, k * 30 + 7, 1L, false);
      }
      j += 1;
      break;
      AppMethodBeat.o(116523);
      return;
      label345:
      i = 0;
    }
  }
  
  private void manualCheckRes()
  {
    AppMethodBeat.i(168802);
    aw localaw = aw.aKU("MicroMsg.WebSearch.PluginWebSearch");
    long l1 = localaw.decodeLong("last_check_res_time", 0L);
    long l2 = System.currentTimeMillis();
    long l3 = Math.abs(l2 - l1);
    if (l3 < 86400000L)
    {
      ac.i("MicroMsg.WebSearch.PluginWebSearch", "manualCheckRes return lastCheckTime %d, current %d, gap %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      AppMethodBeat.o(168802);
      return;
    }
    localaw.encode("last_check_res_time", l2);
    ac.i("MicroMsg.WebSearch.PluginWebSearch", "manualCheckRes");
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168796);
        int[] arrayOfInt = PluginWebSearch.BXI;
        int j = arrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          int k = arrayOfInt[i];
          com.tencent.mm.pluginsdk.h.a.a.b.eLH();
          com.tencent.mm.pluginsdk.h.a.a.b.WB(k);
          i += 1;
        }
        AppMethodBeat.o(168796);
      }
    }, 3000L);
    AppMethodBeat.o(168802);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return cDZ;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(116520);
    super.configure(paramg);
    this.BXG = new a();
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.g.class, new com.tencent.mm.kernel.c.e(this.BXG));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.i.class, new com.tencent.mm.kernel.c.e(new c()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.b()));
    com.tencent.mm.kernel.g.a(k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.c()));
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ahL())
    {
      this.BXH = new b();
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.h.class, new com.tencent.mm.kernel.c.e(this.BXH));
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
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(116521);
    this.iOv.alive();
    this.BXJ.alive();
    manualCheckRes();
    this.checkLanguageChangeIListener.alive();
    b.init();
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.zYU);
    com.tencent.e.h.JZN.f(new a(paramc.ghX), "WebSearchThread");
    z.zx(5000L);
    z.uT(5000L);
    com.tencent.e.h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116511);
        long l = z.Ul(0);
        if (((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRW, Long.valueOf(0L))).longValue() != l)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(17040, new Object[] { Integer.valueOf(2), Long.valueOf(l) });
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRW, Long.valueOf(l));
          com.tencent.mm.kernel.g.agR().agA().faa();
        }
        AppMethodBeat.o(116511);
      }
    }, "WebSearchThread");
    AppMethodBeat.o(116521);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(116522);
    this.iOv.dead();
    this.BXJ.dead();
    this.checkLanguageChangeIListener.dead();
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", this.zYU);
    com.tencent.mm.plugin.websearch.api.ad.BZi = null;
    AppMethodBeat.o(116522);
  }
  
  public void parallelsDependency() {}
  
  final class a
    implements Runnable
  {
    boolean BXL;
    
    a(boolean paramBoolean)
    {
      this.BXL = paramBoolean;
    }
    
    public final void run()
    {
      AppMethodBeat.i(116517);
      PluginWebSearch.access$100(PluginWebSearch.this, this.BXL);
      AppMethodBeat.o(116517);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch
 * JD-Core Version:    0.7.0.1
 */