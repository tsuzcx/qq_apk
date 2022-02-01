package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import android.os.Build;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.a.mk;
import com.tencent.mm.autogen.a.mk.a;
import com.tencent.mm.br.c.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.protocal.protobuf.fnu;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebView.WebViewKind;
import java.util.HashMap;

public class PluginTopStoryUI
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, b
{
  private int TJd;
  private com.tencent.mm.plugin.topstory.ui.home.d TJe;
  private HashMap<String, Integer> TJf;
  private b.a TJg;
  private IListener<mk> TJh;
  
  public PluginTopStoryUI()
  {
    AppMethodBeat.i(125859);
    this.TJd = 2;
    this.TJf = new HashMap();
    this.TJh = new IListener(com.tencent.mm.app.f.hfK)
    {
      private boolean a(mk paramAnonymousmk)
      {
        AppMethodBeat.i(125857);
        if (paramAnonymousmk.hOA == null)
        {
          AppMethodBeat.o(125857);
          return false;
        }
        Log.i("MicroMsg.TopStory.PluginTopStoryUI", "recv HaoKanActionEvent, serverData:%s, clientData:%s", new Object[] { paramAnonymousmk.hOA.hOB, paramAnonymousmk.hOA.hOC });
        if ((!Util.isNullOrNil(paramAnonymousmk.hOA.hOB)) && (PluginTopStoryUI.this.TJg != null)) {
          PluginTopStoryUI.this.TJg.bes(paramAnonymousmk.hOA.hOB);
        }
        if (!Util.isNullOrNil(paramAnonymousmk.hOA.hOC)) {}
        try
        {
          i locali = new i(paramAnonymousmk.hOA.hOC);
          paramAnonymousmk = locali.getString("action");
          locali = locali.Fs("params");
          if (paramAnonymousmk.equals("updateNumReddot"))
          {
            locali.optString("msgId");
            int i = locali.getInt("latestTimeStamp");
            int j = locali.getInt("seq");
            ((com.tencent.mm.plugin.topstory.a.b)h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().k(i, j, true);
          }
          for (;;)
          {
            AppMethodBeat.o(125857);
            return true;
            if (!paramAnonymousmk.equals("openProfile")) {
              break;
            }
            d.beu(locali.getString("openId"));
          }
        }
        catch (Exception paramAnonymousmk)
        {
          for (;;)
          {
            Log.e("MicroMsg.TopStory.PluginTopStoryUI", "HaoKanActionEvent error");
            Log.printErrStackTrace("MicroMsg.TopStory.PluginTopStoryUI", paramAnonymousmk, "", new Object[0]);
            continue;
            if (paramAnonymousmk.equals("openWowColikeSetting")) {
              d.ku(MMApplicationContext.getContext());
            }
          }
        }
      }
    };
    AppMethodBeat.o(125859);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(125862);
    if (paramg.bbA())
    {
      h.b(com.tencent.mm.plugin.topstory.a.f.class, new e());
      h.b(com.tencent.mm.emojisearch.ui.c.class, new com.tencent.mm.plugin.websearch.a.b());
    }
    AppMethodBeat.o(125862);
  }
  
  public int getFirstLoadWebView()
  {
    return this.TJd;
  }
  
  public HashMap<String, Integer> getVideoPlayProgressMap()
  {
    return this.TJf;
  }
  
  public com.tencent.mm.plugin.topstory.ui.home.d getWebViewMgr()
  {
    return this.TJe;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(125860);
    this.TJe = new com.tencent.mm.plugin.topstory.ui.home.d();
    this.TJh.alive();
    com.tencent.mm.plugin.topstory.ui.a.a.cou();
    ((com.tencent.mm.plugin.multitask.d)h.az(com.tencent.mm.plugin.multitask.d.class)).registerMultiTaskUIC(8, com.tencent.mm.plugin.topstory.ui.b.a.a.class);
    long l = h.baE().ban().a(at.a.acWP, 0L);
    if (cn.bDw() - l <= 259200000L)
    {
      Log.i("MicroMsg.TopStory.PluginTopStoryUI", "Use TopStory In Three Days %s", new Object[] { com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd HH:mm:ss", l / 1000L) });
      as.atf(23);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        tryToCreateTopStoryWebView();
      }
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125854);
          com.tencent.mm.plugin.topstory.ui.home.d locald = PluginTopStoryUI.this.TJe;
          u localu = new u(com.tencent.mm.plugin.topstory.a.g.hMJ());
          int i;
          int k;
          Object localObject;
          if (localu.jKS())
          {
            u[] arrayOfu = localu.jKX();
            if ((arrayOfu != null) && (arrayOfu.length > 0))
            {
              j = arrayOfu.length;
              i = 0;
              if (i < j)
              {
                localu = arrayOfu[i];
                k = Util.getInt(localu.getName(), -1);
                fnu localfnu;
                if (k > 0) {
                  localfnu = new fnu();
                }
                for (;;)
                {
                  try
                  {
                    localObject = y.bi(ah.v(localu.jKT()), 0, -1);
                    localfnu.parseFrom((byte[])localObject);
                    locald.TLg.put(Integer.valueOf(k), localfnu);
                    Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put home data cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(localObject.length) });
                    i += 1;
                  }
                  catch (Exception localException1)
                  {
                    Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException1, "loadHomeDataCache %s", new Object[] { localu.jKU() });
                    continue;
                  }
                  Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Decode Key Error %s", new Object[] { ah.v(localu.jKT()) });
                }
              }
            }
            else
            {
              Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Files %s", new Object[] { ah.v(localu.jKT()) });
            }
            locald = PluginTopStoryUI.this.TJe;
            localu = new u(com.tencent.mm.plugin.topstory.a.g.hMK());
            if (!localu.jKS()) {
              break label502;
            }
            arrayOfu = localu.jKX();
            if ((arrayOfu == null) || (arrayOfu.length <= 0)) {
              break label474;
            }
            int j = arrayOfu.length;
            i = 0;
            label290:
            if (i >= j) {
              break label468;
            }
            localu = arrayOfu[i];
            k = Util.getInt(localu.getName(), -1);
            if (k <= 0) {
              break label443;
            }
          }
          for (;;)
          {
            try
            {
              byte[] arrayOfByte = y.bi(ah.v(localu.jKT()), 0, -1);
              localObject = new String(arrayOfByte, "utf-8");
              locald.TLh.put(Integer.valueOf(k), localObject);
              Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put neg cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(arrayOfByte.length) });
              i += 1;
              break label290;
              Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Exist %s", new Object[] { ah.v(localu.jKT()) });
            }
            catch (Exception localException2)
            {
              Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException2, "loadNegDataCache %s", new Object[] { localu.jKU() });
              continue;
            }
            label443:
            Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Decode Key Error %s", new Object[] { ah.v(localu.jKT()) });
          }
          label468:
          AppMethodBeat.o(125854);
          return;
          label474:
          Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Files %s", new Object[] { ah.v(localu.jKT()) });
          AppMethodBeat.o(125854);
          return;
          label502:
          Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Exist %s", new Object[] { ah.v(localu.jKT()) });
          AppMethodBeat.o(125854);
        }
      }, "TopStory.LoadHomeCacheData");
      com.tencent.mm.br.c.a(new c.c()
      {
        public final boolean aR(Context paramAnonymousContext, String paramAnonymousString)
        {
          AppMethodBeat.i(271683);
          if ((paramAnonymousString.endsWith(".TopStoryHomeUI")) && (((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()))
          {
            ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(paramAnonymousContext);
            AppMethodBeat.o(271683);
            return true;
          }
          AppMethodBeat.o(271683);
          return false;
        }
      });
      AppMethodBeat.o(125860);
      return;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(125861);
    this.TJe = null;
    this.TJh.dead();
    com.tencent.mm.plugin.topstory.ui.a.a.cov();
    com.tencent.mm.pluginsdk.cmd.b.X(new String[] { "//topstory" });
    this.TJf.clear();
    AppMethodBeat.o(125861);
  }
  
  public void parallelsDependency() {}
  
  public void setFirstLoadWebView(int paramInt)
  {
    this.TJd = paramInt;
  }
  
  public void setHaokanEventListener(b.a parama)
  {
    this.TJg = parama;
  }
  
  public void tryToCreateTopStoryWebView()
  {
    AppMethodBeat.i(125863);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125856);
        long l;
        if ((PluginTopStoryUI.this.TJd == 2) && (((PluginTopStory)h.az(PluginTopStory.class)).getWebViewType() == WebView.WebViewKind.aifK))
        {
          String str = Build.BRAND;
          int i;
          if (!Util.isNullOrNil(str))
          {
            str = str.toLowerCase();
            if ((str.contains("huawei")) || (str.contains("honor"))) {
              i = 0;
            }
          }
          while (i != 0)
          {
            i = ((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("TopStoryWebViewPreInit", 1);
            if (i == 0)
            {
              Log.i("MicroMsg.TopStory.PluginTopStoryUI", "MXM_DynaCfg_AV_Item_Key_TopStory_WebViewPreInit is %d", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(125856);
              return;
              i = 1;
            }
            else
            {
              PluginTopStoryUI.access$102(PluginTopStoryUI.this, 1);
              l = cn.bDw();
            }
          }
        }
        try
        {
          new WebSearchWebView(MMApplicationContext.getContext()).destroy();
          label158:
          as.atf(26);
          Log.i("MicroMsg.TopStory.PluginTopStoryUI", "Create TopStoryWebView Use Time %d", new Object[] { Long.valueOf(cn.bDw() - l) });
          AppMethodBeat.o(125856);
          return;
        }
        catch (Exception localException)
        {
          break label158;
        }
      }
    }, 5000L);
    AppMethodBeat.o(125863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI
 * JD-Core Version:    0.7.0.1
 */