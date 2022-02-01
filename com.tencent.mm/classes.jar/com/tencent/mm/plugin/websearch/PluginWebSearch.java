package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.bn.a;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.lg.a;
import com.tencent.mm.g.a.st;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.al.a;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.plugin.websearch.api.l;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public class PluginWebSearch
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.websearch.api.c
{
  static final int[] DAy;
  private static HashMap<Integer, h.b> cPe;
  private q BqG;
  private a DAw;
  private b DAx;
  private final com.tencent.mm.sdk.b.c checkLanguageChangeIListener;
  private com.tencent.mm.sdk.b.c jhE;
  private com.tencent.mm.sdk.b.c nVf;
  
  static
  {
    AppMethodBeat.i(116525);
    cPe = new HashMap();
    String str = com.tencent.mm.sdk.e.j.getCreateSQLs(com.tencent.mm.plugin.websearch.widget.a.a.info, "WidgetSafeMode");
    cPe.put(Integer.valueOf("WidgetSafeMode".hashCode()), new PluginWebSearch.1(new String[] { str }));
    DAy = new int[] { 64 };
    AppMethodBeat.o(116525);
  }
  
  public PluginWebSearch()
  {
    AppMethodBeat.i(116518);
    this.checkLanguageChangeIListener = new com.tencent.mm.sdk.b.c() {};
    this.jhE = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(bn paramAnonymousbn)
      {
        AppMethodBeat.i(168797);
        int k;
        if (paramAnonymousbn != null)
        {
          int i;
          int m;
          if ((paramAnonymousbn.dmw.dmx == 27) && (paramAnonymousbn.dmw.subType == 1))
          {
            i = 0;
            k = i * 30;
            com.tencent.mm.plugin.report.e.ygI.idkeyStat(1181L, k + 0, 1L, false);
            m = ao.aFV(paramAnonymousbn.dmw.filePath);
            if (m != 1) {
              break label317;
            }
            com.tencent.mm.plugin.report.e.ygI.idkeyStat(1181L, k + 1, 1L, false);
          }
          ao localao;
          for (;;)
          {
            localao = com.tencent.mm.plugin.websearch.api.ad.Wc(i);
            if (m < localao.aHm()) {
              break label417;
            }
            com.tencent.mm.plugin.report.e.ygI.idkeyStat(1181L, k + 4, 1L, false);
            int j = 0;
            while (j < 3)
            {
              localao.aFU(paramAnonymousbn.dmw.filePath);
              if (localao.eMA()) {
                break;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate invalid md5 and delete template folder retryTimes:%s", new Object[] { Integer.valueOf(j) });
              j += 1;
            }
            if ((paramAnonymousbn.dmw.dmx == 27) && (paramAnonymousbn.dmw.subType == 2))
            {
              i = 1;
              break;
            }
            if ((paramAnonymousbn.dmw.dmx == 62) && (paramAnonymousbn.dmw.subType == 1))
            {
              i = 2;
              break;
            }
            if ((paramAnonymousbn.dmw.dmx == 40) && (paramAnonymousbn.dmw.subType == 1))
            {
              i = 3;
              break;
            }
            if ((paramAnonymousbn.dmw.dmx == 64) && (paramAnonymousbn.dmw.subType == 1))
            {
              i = 4;
              break;
            }
            if ((paramAnonymousbn.dmw.dmx == 66) && (paramAnonymousbn.dmw.subType == 1))
            {
              i = 5;
              break;
            }
            AppMethodBeat.o(168797);
            return false;
            label317:
            com.tencent.mm.plugin.report.e.ygI.idkeyStat(1181L, k + 2, 1L, false);
          }
          if (!localao.eMA()) {
            break label392;
          }
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(1181L, k + 6, 1L, false);
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate final update success version %d", new Object[] { Integer.valueOf(m) });
          if (i == 0) {
            com.tencent.mm.plugin.websearch.api.ad.eMf();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(168797);
          return false;
          label392:
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(1181L, k + 5, 1L, false);
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdate final md5 is invalid!");
          continue;
          label417:
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(1181L, k + 3, 1L, false);
        }
      }
    };
    this.nVf = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(lg paramAnonymouslg)
      {
        int i = 1;
        AppMethodBeat.i(168799);
        if ((paramAnonymouslg.dyC.dmx == 27) && (paramAnonymouslg.dyC.subType == 1)) {
          i = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.websearch.api.ad.Wc(i).aFU(paramAnonymouslg.dyC.filePath);
          if (i == 0) {
            com.tencent.mm.plugin.websearch.api.ad.eMf();
          }
          AppMethodBeat.o(168799);
          return false;
          if ((paramAnonymouslg.dyC.dmx != 27) || (paramAnonymouslg.dyC.subType != 2)) {
            if ((paramAnonymouslg.dyC.dmx == 62) && (paramAnonymouslg.dyC.subType == 1))
            {
              i = 2;
            }
            else if ((paramAnonymouslg.dyC.dmx == 40) && (paramAnonymouslg.dyC.subType == 1))
            {
              i = 3;
            }
            else if ((paramAnonymouslg.dyC.dmx == 64) && (paramAnonymouslg.dyC.subType == 1))
            {
              i = 4;
            }
            else
            {
              if ((paramAnonymouslg.dyC.dmx != 66) || (paramAnonymouslg.dyC.subType != 1)) {
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
    this.BqG = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, e.a paramAnonymousa)
      {
        AppMethodBeat.i(168801);
        long l2;
        al localal;
        if ((paramAnonymousMap != null) && (paramAnonymousString != null) && (paramAnonymousString.equals("mmsearch_reddot_new")))
        {
          int i = bt.aRe((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.entry"));
          if (i == 1)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.PluginWebSearch", "recv %s, %s", new Object[] { "mmsearch_reddot_new", paramAnonymousMap.toString() });
            int j = bt.aRe((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.clear"));
            paramAnonymousa = bt.x((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
            int k = bt.aRe((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.discovery"));
            int m = bt.aRe((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
            long l1 = bt.aRf((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.expire_time"));
            int n = bt.aRe((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.h5_version"));
            int i1 = bt.aRe((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
            String str1 = (String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_text");
            String str2 = (String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
            l2 = bt.aRf((String)paramAnonymousMap.get(".sysmsg.mmsearch_reddot_new.timestamp"));
            localal = al.eMo();
            paramAnonymousString = null;
            switch (i)
            {
            default: 
              paramAnonymousMap = paramAnonymousString;
              if (paramAnonymousString == null) {
                paramAnonymousMap = new al.a();
              }
              if (paramAnonymousMap.timestamp < l2)
              {
                paramAnonymousMap.id = paramAnonymousa;
                paramAnonymousMap.DCx = k;
                paramAnonymousMap.DCv = i;
                paramAnonymousMap.DCw = m;
                paramAnonymousMap.iJn = l1;
                paramAnonymousMap.DBB = n;
                paramAnonymousMap.type = i1;
                paramAnonymousMap.text = str1;
                paramAnonymousMap.dDH = str2;
                paramAnonymousMap.timestamp = l2;
                paramAnonymousMap.clear = j;
                paramAnonymousMap.hWw = System.currentTimeMillis();
              }
              break;
            }
          }
        }
        for (;;)
        {
          localal.save();
          paramAnonymousString = new st();
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString);
          AppMethodBeat.o(168801);
          return;
          paramAnonymousString = localal.DCs;
          break;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "timestamp %d not big than last msg %d", new Object[] { Long.valueOf(l2), Long.valueOf(paramAnonymousMap.timestamp) });
        }
      }
    };
    AppMethodBeat.o(116518);
  }
  
  private void checkWebSearchTemplate(boolean paramBoolean)
  {
    AppMethodBeat.i(116523);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate %b", new Object[] { Boolean.valueOf(paramBoolean) });
    int j = 0;
    int k;
    ao localao;
    int m;
    int n;
    int i;
    if (j < 6)
    {
      k = new int[] { 0, 1, 2, 3, 4, 5 }[j];
      localao = com.tencent.mm.plugin.websearch.api.ad.Wc(k);
      m = localao.aHn();
      localao.eMu();
      n = localao.aHm();
      if (n == 1)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.PluginWebSearch", "first time init template");
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        localao.eMB();
      }
      if (!localao.eMA())
      {
        i = 1;
        for (;;)
        {
          if (i <= 3)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate invalid md5 and delete template folder retryTimes:%s", new Object[] { Integer.valueOf(i) });
            localao.eMB();
            if (!localao.eMA())
            {
              i += 1;
              continue;
              com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
              if (com.tencent.mm.util.c.aXU(com.tencent.mm.util.c.ms("search", "openResetTemplate")) == 1) {}
              for (i = 1;; i = 0)
              {
                if (i == 0) {
                  break label208;
                }
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.PluginWebSearch", "expt reset template");
                i = 1;
                break;
              }
              label208:
              if (n >= m) {
                break label295;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.PluginWebSearch", "update template currentVersion %d assetVersion %d", new Object[] { Integer.valueOf(n), Integer.valueOf(m) });
              i = 1;
              break;
            }
          }
        }
      }
      if (!localao.eMA())
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WebSearch.PluginWebSearch", "checkWebSearchTemplate final md5 is invalid!");
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(1181L, k * 30 + 7, 1L, false);
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
    ax localax = ax.aQA("MicroMsg.WebSearch.PluginWebSearch");
    long l1 = localax.decodeLong("last_check_res_time", 0L);
    long l2 = System.currentTimeMillis();
    long l3 = Math.abs(l2 - l1);
    if (l3 < 86400000L)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.PluginWebSearch", "manualCheckRes return lastCheckTime %d, current %d, gap %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      AppMethodBeat.o(168802);
      return;
    }
    localax.encode("last_check_res_time", l2);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.PluginWebSearch", "manualCheckRes");
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(168796);
        int[] arrayOfInt = PluginWebSearch.DAy;
        int j = arrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          int k = arrayOfInt[i];
          com.tencent.mm.pluginsdk.j.a.a.b.faE();
          com.tencent.mm.pluginsdk.j.a.a.b.Yx(k);
          i += 1;
        }
        AppMethodBeat.o(168796);
      }
    }, 3000L);
    AppMethodBeat.o(168802);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return cPe;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(116520);
    super.configure(paramg);
    this.DAw = new a();
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.h.class, new com.tencent.mm.kernel.c.e(this.DAw));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.j.class, new com.tencent.mm.kernel.c.e(new c()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.f.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.b()));
    com.tencent.mm.kernel.g.a(l.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.c()));
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).akw())
    {
      this.DAx = new b();
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.i.class, new com.tencent.mm.kernel.c.e(this.DAx));
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
    AppMethodBeat.i(219996);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
    if (com.tencent.mm.util.c.fNM())
    {
      localc = com.tencent.mm.util.c.LgD;
      if (com.tencent.mm.util.c.aXU(com.tencent.mm.util.c.ms("search", "openFingerSearch")) == 1)
      {
        AppMethodBeat.o(219996);
        return true;
      }
      AppMethodBeat.o(219996);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDC, 0) == 1)
    {
      AppMethodBeat.o(219996);
      return true;
    }
    AppMethodBeat.o(219996);
    return false;
  }
  
  public boolean isOpenHotWordSearch()
  {
    AppMethodBeat.i(221670);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
    if (com.tencent.mm.util.c.fNM())
    {
      localc = com.tencent.mm.util.c.LgD;
      if (com.tencent.mm.util.c.aXU(com.tencent.mm.util.c.ms("search", "openHotWordSearch")) == 1)
      {
        AppMethodBeat.o(221670);
        return true;
      }
      AppMethodBeat.o(221670);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.CZl, 0) == 1)
    {
      AppMethodBeat.o(221670);
      return true;
    }
    AppMethodBeat.o(221670);
    return false;
  }
  
  public boolean isOpenImageSearch()
  {
    AppMethodBeat.i(219997);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
    if (com.tencent.mm.util.c.fNM())
    {
      localc = com.tencent.mm.util.c.LgD;
      if (com.tencent.mm.util.c.aXU(com.tencent.mm.util.c.ms("search", "openImageSearch")) == 1)
      {
        AppMethodBeat.o(219997);
        return true;
      }
      AppMethodBeat.o(219997);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDD, 0) == 1)
    {
      AppMethodBeat.o(219997);
      return true;
    }
    AppMethodBeat.o(219997);
    return false;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(116521);
    this.jhE.alive();
    this.nVf.alive();
    manualCheckRes();
    this.checkLanguageChangeIListener.alive();
    b.init();
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.BqG);
    com.tencent.e.h.LTJ.f(new a(paramc.gBH), "WebSearchThread");
    com.tencent.mm.plugin.websearch.api.ad.Ck(5000L);
    com.tencent.mm.plugin.websearch.api.ad.Cl(5000L);
    com.tencent.e.h.LTJ.f(new PluginWebSearch.3(this), "WebSearchThread");
    AppMethodBeat.o(116521);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(116522);
    this.jhE.dead();
    this.nVf.dead();
    this.checkLanguageChangeIListener.dead();
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", this.BqG);
    com.tencent.mm.plugin.websearch.api.ah.DCe = null;
    AppMethodBeat.o(116522);
  }
  
  public void parallelsDependency() {}
  
  public void startImageSearch(o paramo)
  {
    AppMethodBeat.i(219998);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.PluginWebSearch", "startImageSearch %s %s", new Object[] { Long.valueOf(paramo.dBd.field_msgId), Integer.valueOf(paramo.dnM) });
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(aj.getPackageName(), "com.tencent.mm.plugin.websearch.ui.WebSearchImageLoadingUI");
    ((Intent)localObject).putExtra("key_source", paramo.dnM);
    ((Intent)localObject).putExtra("key_msg_id", paramo.dBd.field_msgId);
    paramo = paramo.context;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramo, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/websearch/PluginWebSearch", "startImageSearch", "(Lcom/tencent/mm/plugin/websearch/api/ImageSearchContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramo.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramo, "com/tencent/mm/plugin/websearch/PluginWebSearch", "startImageSearch", "(Lcom/tencent/mm/plugin/websearch/api/ImageSearchContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(219998);
  }
  
  final class a
    implements Runnable
  {
    boolean DAA;
    
    a(boolean paramBoolean)
    {
      this.DAA = paramBoolean;
    }
    
    public final void run()
    {
      AppMethodBeat.i(116517);
      PluginWebSearch.access$100(PluginWebSearch.this, this.DAA);
      AppMethodBeat.o(116517);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch
 * JD-Core Version:    0.7.0.1
 */