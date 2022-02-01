package com.tencent.mm.plugin.topstory.ui;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.f.a.le;
import com.tencent.mm.f.a.le.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.protocal.protobuf.esl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebView.c;
import java.util.HashMap;

public class PluginTopStoryUI
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, c, b
{
  private com.tencent.mm.plugin.topstory.ui.home.d MWA;
  private HashMap<String, Integer> MWB;
  private b.a MWC;
  private IListener<le> MWD;
  private int MWz;
  
  public PluginTopStoryUI()
  {
    AppMethodBeat.i(125859);
    this.MWz = 2;
    this.MWB = new HashMap();
    this.MWD = new IListener()
    {
      private boolean a(le paramAnonymousle)
      {
        AppMethodBeat.i(206172);
        if (paramAnonymousle.fIS == null)
        {
          AppMethodBeat.o(206172);
          return false;
        }
        Log.i("MicroMsg.TopStory.PluginTopStoryUI", "recv HaoKanActionEvent, serverData:%s, clientData:%s", new Object[] { paramAnonymousle.fIS.fIT, paramAnonymousle.fIS.fIU });
        if ((!Util.isNullOrNil(paramAnonymousle.fIS.fIT)) && (PluginTopStoryUI.this.MWC != null)) {
          PluginTopStoryUI.this.MWC.beV(paramAnonymousle.fIS.fIT);
        }
        if (!Util.isNullOrNil(paramAnonymousle.fIS.fIU)) {}
        try
        {
          i locali = new i(paramAnonymousle.fIS.fIU);
          paramAnonymousle = locali.getString("action");
          locali = locali.MJ("params");
          if (paramAnonymousle.equals("updateNumReddot"))
          {
            locali.optString("msgId");
            int i = locali.getInt("latestTimeStamp");
            int j = locali.getInt("seq");
            ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().j(i, j, true);
          }
          for (;;)
          {
            AppMethodBeat.o(206172);
            return true;
            if (!paramAnonymousle.equals("openProfile")) {
              break;
            }
            d.beX(locali.getString("openId"));
          }
        }
        catch (Exception paramAnonymousle)
        {
          for (;;)
          {
            Log.e("MicroMsg.TopStory.PluginTopStoryUI", "HaoKanActionEvent error");
            Log.printErrStackTrace("MicroMsg.TopStory.PluginTopStoryUI", paramAnonymousle, "", new Object[0]);
            continue;
            if (paramAnonymousle.equals("openWowColikeSetting")) {
              d.iC(MMApplicationContext.getContext());
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
    if (paramg.aIE()) {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.topstory.a.g.class, new e());
    }
    AppMethodBeat.o(125862);
  }
  
  public int getFirstLoadWebView()
  {
    return this.MWz;
  }
  
  public HashMap<String, Integer> getVideoPlayProgressMap()
  {
    return this.MWB;
  }
  
  public com.tencent.mm.plugin.topstory.ui.home.d getWebViewMgr()
  {
    return this.MWA;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(125860);
    this.MWA = new com.tencent.mm.plugin.topstory.ui.home.d();
    this.MWD.alive();
    com.tencent.mm.plugin.topstory.ui.a.a.bOh();
    ((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.multitask.d.class)).registerMultiTaskUIC(8, com.tencent.mm.plugin.topstory.ui.b.a.a.class);
    long l = com.tencent.mm.kernel.h.aHG().aHp().a(ar.a.Vvg, 0L);
    if (System.currentTimeMillis() - l <= 259200000L)
    {
      Log.i("MicroMsg.TopStory.PluginTopStoryUI", "Use TopStory In Three Days %s", new Object[] { com.tencent.mm.pluginsdk.j.f.formatTime("yyyy-MM-dd HH:mm:ss", l / 1000L) });
      ar.anp(23);
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
          com.tencent.mm.plugin.topstory.ui.home.d locald = PluginTopStoryUI.this.MWA;
          q localq = new q(com.tencent.mm.plugin.topstory.a.h.gpN());
          int i;
          int k;
          Object localObject;
          if (localq.ifE())
          {
            q[] arrayOfq = localq.ifJ();
            if ((arrayOfq != null) && (arrayOfq.length > 0))
            {
              j = arrayOfq.length;
              i = 0;
              if (i < j)
              {
                localq = arrayOfq[i];
                k = Util.getInt(localq.getName(), -1);
                esl localesl;
                if (k > 0) {
                  localesl = new esl();
                }
                for (;;)
                {
                  try
                  {
                    localObject = u.aY(localq.bOF(), 0, -1);
                    localesl.parseFrom((byte[])localObject);
                    locald.MYx.put(Integer.valueOf(k), localesl);
                    Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put home data cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(localObject.length) });
                    i += 1;
                  }
                  catch (Exception localException1)
                  {
                    Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException1, "loadHomeDataCache %s", new Object[] { localq.ifG() });
                    continue;
                  }
                  Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Decode Key Error %s", new Object[] { localq.bOF() });
                }
              }
            }
            else
            {
              Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Files %s", new Object[] { localq.bOF() });
            }
            locald = PluginTopStoryUI.this.MWA;
            localq = new q(com.tencent.mm.plugin.topstory.a.h.gpO());
            if (!localq.ifE()) {
              break label481;
            }
            arrayOfq = localq.ifJ();
            if ((arrayOfq == null) || (arrayOfq.length <= 0)) {
              break label456;
            }
            int j = arrayOfq.length;
            i = 0;
            label281:
            if (i >= j) {
              break label450;
            }
            localq = arrayOfq[i];
            k = Util.getInt(localq.getName(), -1);
            if (k <= 0) {
              break label428;
            }
          }
          for (;;)
          {
            try
            {
              byte[] arrayOfByte = u.aY(localq.bOF(), 0, -1);
              localObject = new String(arrayOfByte, "utf-8");
              locald.MYy.put(Integer.valueOf(k), localObject);
              Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put neg cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(arrayOfByte.length) });
              i += 1;
              break label281;
              Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Exist %s", new Object[] { localq.bOF() });
            }
            catch (Exception localException2)
            {
              Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException2, "loadNegDataCache %s", new Object[] { localq.ifG() });
              continue;
            }
            label428:
            Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Decode Key Error %s", new Object[] { localq.bOF() });
          }
          label450:
          AppMethodBeat.o(125854);
          return;
          label456:
          Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Files %s", new Object[] { localq.bOF() });
          AppMethodBeat.o(125854);
          return;
          label481:
          Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Exist %s", new Object[] { localq.bOF() });
          AppMethodBeat.o(125854);
        }
      }, "TopStory.LoadHomeCacheData");
      AppMethodBeat.o(125860);
      return;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(125861);
    this.MWA = null;
    this.MWD.dead();
    com.tencent.mm.plugin.topstory.ui.a.a.bOi();
    com.tencent.mm.pluginsdk.cmd.b.W(new String[] { "//topstory" });
    this.MWB.clear();
    AppMethodBeat.o(125861);
  }
  
  public void parallelsDependency() {}
  
  public void setFirstLoadWebView(int paramInt)
  {
    this.MWz = paramInt;
  }
  
  public void setHaokanEventListener(b.a parama)
  {
    this.MWC = parama;
  }
  
  public void tryToCreateTopStoryWebView()
  {
    AppMethodBeat.i(125863);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125855);
        long l;
        if ((PluginTopStoryUI.this.MWz == 2) && (((PluginTopStory)com.tencent.mm.kernel.h.ag(PluginTopStory.class)).getWebViewType() == WebView.c.aabo))
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
            i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("TopStoryWebViewPreInit", 1);
            if (i == 0)
            {
              Log.i("MicroMsg.TopStory.PluginTopStoryUI", "MXM_DynaCfg_AV_Item_Key_TopStory_WebViewPreInit is %d", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(125855);
              return;
              i = 1;
            }
            else
            {
              PluginTopStoryUI.access$102(PluginTopStoryUI.this, 1);
              l = System.currentTimeMillis();
            }
          }
        }
        try
        {
          new WebSearchWebView(MMApplicationContext.getContext()).destroy();
          label158:
          ar.anp(26);
          Log.i("MicroMsg.TopStory.PluginTopStoryUI", "Create TopStoryWebView Use Time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(125855);
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