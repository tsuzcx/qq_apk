package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bh;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.bk.a;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.g.a.ko.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginWebSearch
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c
{
  static final int[] AFp;
  private static HashMap<Integer, h.b> cGR;
  private a AFn;
  private b AFo;
  private com.tencent.mm.sdk.b.c AFq;
  private final com.tencent.mm.sdk.b.c checkLanguageChangeIListener;
  private com.tencent.mm.sdk.b.c iop;
  private p yLb;
  
  static
  {
    AppMethodBeat.i(116525);
    cGR = new HashMap();
    String str = com.tencent.mm.sdk.e.j.getCreateSQLs(com.tencent.mm.plugin.websearch.widget.a.a.info, "WidgetSafeMode");
    cGR.put(Integer.valueOf("WidgetSafeMode".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return this.cGT;
      }
    });
    AFp = new int[] { 64 };
    AppMethodBeat.o(116525);
  }
  
  public PluginWebSearch()
  {
    AppMethodBeat.i(116518);
    this.checkLanguageChangeIListener = new com.tencent.mm.sdk.b.c() {};
    this.iop = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(bk paramAnonymousbk)
      {
        AppMethodBeat.i(168797);
        int k;
        if (paramAnonymousbk != null)
        {
          int i;
          int m;
          if ((paramAnonymousbk.ddG.ddH == 27) && (paramAnonymousbk.ddG.subType == 1))
          {
            i = 0;
            k = i * 30;
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(1181L, k + 0, 1L, false);
            m = am.avj(paramAnonymousbk.ddG.filePath);
            if (m != 1) {
              break label317;
            }
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(1181L, k + 1, 1L, false);
          }
          am localam;
          for (;;)
          {
            localam = aa.RZ(i);
            if (m < localam.axp()) {
              break label417;
            }
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(1181L, k + 4, 1L, false);
            int j = 0;
            while (j < 3)
            {
              localam.avi(paramAnonymousbk.ddG.filePath);
              if (localam.eip()) {
                break;
              }
              ad.i("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate invalid md5 and delete template folder retryTimes:%s", new Object[] { Integer.valueOf(j) });
              j += 1;
            }
            if ((paramAnonymousbk.ddG.ddH == 27) && (paramAnonymousbk.ddG.subType == 2))
            {
              i = 1;
              break;
            }
            if ((paramAnonymousbk.ddG.ddH == 62) && (paramAnonymousbk.ddG.subType == 1))
            {
              i = 2;
              break;
            }
            if ((paramAnonymousbk.ddG.ddH == 40) && (paramAnonymousbk.ddG.subType == 1))
            {
              i = 3;
              break;
            }
            if ((paramAnonymousbk.ddG.ddH == 64) && (paramAnonymousbk.ddG.subType == 1))
            {
              i = 4;
              break;
            }
            if ((paramAnonymousbk.ddG.ddH == 66) && (paramAnonymousbk.ddG.subType == 1))
            {
              i = 5;
              break;
            }
            AppMethodBeat.o(168797);
            return false;
            label317:
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(1181L, k + 2, 1L, false);
          }
          if (!localam.eip()) {
            break label392;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(1181L, k + 6, 1L, false);
          ad.w("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate final update success version %d", new Object[] { Integer.valueOf(m) });
          if (i == 0) {
            aa.ehV();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(168797);
          return false;
          label392:
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(1181L, k + 5, 1L, false);
          ad.w("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate final md5 is invalid!");
          continue;
          label417:
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(1181L, k + 3, 1L, false);
        }
      }
    };
    this.AFq = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(ko paramAnonymousko)
      {
        int i = 1;
        AppMethodBeat.i(168799);
        if ((paramAnonymousko.dpe.ddH == 27) && (paramAnonymousko.dpe.subType == 1)) {
          i = 0;
        }
        for (;;)
        {
          aa.RZ(i).avi(paramAnonymousko.dpe.filePath);
          if (i == 0) {
            aa.ehV();
          }
          AppMethodBeat.o(168799);
          return false;
          if ((paramAnonymousko.dpe.ddH != 27) || (paramAnonymousko.dpe.subType != 2)) {
            if ((paramAnonymousko.dpe.ddH == 62) && (paramAnonymousko.dpe.subType == 1))
            {
              i = 2;
            }
            else if ((paramAnonymousko.dpe.ddH == 40) && (paramAnonymousko.dpe.subType == 1))
            {
              i = 3;
            }
            else if ((paramAnonymousko.dpe.ddH == 64) && (paramAnonymousko.dpe.subType == 1))
            {
              i = 4;
            }
            else
            {
              if ((paramAnonymousko.dpe.ddH != 66) || (paramAnonymousko.dpe.subType != 1)) {
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
    this.yLb = new PluginWebSearch.7(this);
    AppMethodBeat.o(116518);
  }
  
  private void checkWebSearchTemplate(boolean paramBoolean)
  {
    AppMethodBeat.i(116523);
    int[] arrayOfInt = new int[6];
    int[] tmp13_11 = arrayOfInt;
    tmp13_11[0] = 0;
    int[] tmp17_13 = tmp13_11;
    tmp17_13[1] = 1;
    int[] tmp21_17 = tmp17_13;
    tmp21_17[2] = 2;
    int[] tmp25_21 = tmp21_17;
    tmp25_21[3] = 3;
    int[] tmp29_25 = tmp25_21;
    tmp29_25[4] = 4;
    int[] tmp33_29 = tmp29_25;
    tmp33_29[5] = 5;
    tmp33_29;
    int i;
    am localam;
    if (paramBoolean)
    {
      i = 0;
      while (i < 6)
      {
        localam = aa.RZ(arrayOfInt[i]);
        com.tencent.mm.vfs.i.cO(localam.eil(), true);
        localam.eij();
        i += 1;
      }
    }
    int j = 0;
    int k;
    int m;
    if (j < 6)
    {
      k = arrayOfInt[j];
      localam = aa.RZ(k);
      i = localam.axq();
      localam.eij();
      m = localam.axp();
      if (m == 1)
      {
        ad.i("MicroMsg.WebSearch.PluginWebSearch", "first time init template");
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        localam.eiq();
      }
      if (!localam.eip())
      {
        i = 1;
        for (;;)
        {
          if (i <= 3)
          {
            ad.i("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate invalid md5 and delete template folder retryTimes:%s", new Object[] { Integer.valueOf(i) });
            localam.eiq();
            if (!localam.eip())
            {
              i += 1;
              continue;
              if (com.tencent.mm.util.c.fgW())
              {
                ad.i("MicroMsg.WebSearch.PluginWebSearch", "red and debug package init template");
                i = 1;
                break;
              }
              if (m >= i) {
                break label300;
              }
              ad.i("MicroMsg.WebSearch.PluginWebSearch", "update template currentVersion %d assetVersion %d", new Object[] { Integer.valueOf(m), Integer.valueOf(i) });
              i = 1;
              break;
            }
          }
        }
      }
      if (!localam.eip())
      {
        ad.w("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate final md5 is invalid!");
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(1181L, k * 30 + 7, 1L, false);
      }
      j += 1;
      break;
      AppMethodBeat.o(116523);
      return;
      label300:
      i = 0;
    }
  }
  
  private void manualCheckRes()
  {
    AppMethodBeat.i(168802);
    ax localax = ax.aFD("MicroMsg.WebSearch.PluginWebSearch");
    long l1 = localax.decodeLong("last_check_res_time", 0L);
    long l2 = System.currentTimeMillis();
    long l3 = Math.abs(l2 - l1);
    if (l3 < 86400000L)
    {
      ad.i("MicroMsg.WebSearch.PluginWebSearch", "manualCheckRes return lastCheckTime %d, current %d, gap %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      AppMethodBeat.o(168802);
      return;
    }
    localax.encode("last_check_res_time", l2);
    ad.i("MicroMsg.WebSearch.PluginWebSearch", "manualCheckRes");
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168796);
        int[] arrayOfInt = PluginWebSearch.AFp;
        int j = arrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          int k = arrayOfInt[i];
          com.tencent.mm.pluginsdk.h.a.a.b.ewn();
          com.tencent.mm.pluginsdk.h.a.a.b.Ur(k);
          i += 1;
        }
        AppMethodBeat.o(168796);
      }
    }, 3000L);
    AppMethodBeat.o(168802);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return cGR;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(116520);
    super.configure(paramg);
    this.AFn = new a();
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.g.class, new com.tencent.mm.kernel.c.e(this.AFn));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.j.class, new com.tencent.mm.kernel.c.e(new c()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.b()));
    com.tencent.mm.kernel.g.a(l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.c()));
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).agu())
    {
      this.AFo = new b();
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.i.class, new com.tencent.mm.kernel.c.e(this.AFo));
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
    this.iop.alive();
    this.AFq.alive();
    manualCheckRes();
    this.checkLanguageChangeIListener.alive();
    b.init();
    com.tencent.mm.sdk.g.b.c(new a(paramc.gdr), "CopySearchTemplateTask");
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.yLb);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).agu()) {
      com.tencent.mm.kernel.g.afE().m(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(116511);
          aa.uU(5000L);
          long l = aa.Sb(0);
          if (((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fuc, Long.valueOf(0L))).longValue() != l)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(17040, new Object[] { Integer.valueOf(2), Long.valueOf(l) });
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fuc, Long.valueOf(l));
            com.tencent.mm.kernel.g.afB().afk().eKy();
          }
          AppMethodBeat.o(116511);
        }
      }, 2000L);
    }
    AppMethodBeat.o(116521);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(116522);
    this.iop.dead();
    this.AFq.dead();
    this.checkLanguageChangeIListener.dead();
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", this.yLb);
    com.tencent.mm.plugin.websearch.api.af.AGQ = null;
    AppMethodBeat.o(116522);
  }
  
  public void parallelsDependency() {}
  
  final class a
    implements Runnable
  {
    boolean AFs;
    
    a(boolean paramBoolean)
    {
      this.AFs = paramBoolean;
    }
    
    public final void run()
    {
      AppMethodBeat.i(116517);
      PluginWebSearch.access$100(PluginWebSearch.this, this.AFs);
      AppMethodBeat.o(116517);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch
 * JD-Core Version:    0.7.0.1
 */