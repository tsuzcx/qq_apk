package com.tencent.mm.plugin.topstory.ui;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.g.a.kn.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.multitask.uic.TopStoryMultiTaskUIC;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebView.c;
import java.util.HashMap;

public class PluginTopStoryUI
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, b
{
  private int GjO;
  private com.tencent.mm.plugin.topstory.ui.home.d GjP;
  private HashMap<String, Integer> GjQ;
  private b.a GjR;
  private IListener<kn> GjS;
  
  public PluginTopStoryUI()
  {
    AppMethodBeat.i(125859);
    this.GjO = 2;
    this.GjQ = new HashMap();
    this.GjS = new IListener()
    {
      private boolean a(kn paramAnonymouskn)
      {
        AppMethodBeat.i(236378);
        if (paramAnonymouskn.dPD == null)
        {
          AppMethodBeat.o(236378);
          return false;
        }
        Log.i("MicroMsg.TopStory.PluginTopStoryUI", "recv HaoKanActionEvent, serverData:%s, clientData:%s", new Object[] { paramAnonymouskn.dPD.dPE, paramAnonymouskn.dPD.dPF });
        if ((!Util.isNullOrNil(paramAnonymouskn.dPD.dPE)) && (PluginTopStoryUI.this.GjR != null)) {
          PluginTopStoryUI.this.GjR.aTx(paramAnonymouskn.dPD.dPE);
        }
        if (!Util.isNullOrNil(paramAnonymouskn.dPD.dPF)) {}
        try
        {
          i locali = new i(paramAnonymouskn.dPD.dPF);
          paramAnonymouskn = locali.getString("action");
          locali = locali.FJ("params");
          if (paramAnonymouskn.equals("updateNumReddot"))
          {
            locali.optString("msgId");
            int i = locali.getInt("latestTimeStamp");
            int j = locali.getInt("seq");
            ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().j(i, j, true);
          }
          for (;;)
          {
            AppMethodBeat.o(236378);
            return true;
            if (!paramAnonymouskn.equals("openProfile")) {
              break;
            }
            c.aTz(locali.getString("openId"));
          }
        }
        catch (Exception paramAnonymouskn)
        {
          for (;;)
          {
            Log.e("MicroMsg.TopStory.PluginTopStoryUI", "HaoKanActionEvent error");
            Log.printErrStackTrace("MicroMsg.TopStory.PluginTopStoryUI", paramAnonymouskn, "", new Object[0]);
            continue;
            if (paramAnonymouskn.equals("openWowColikeSetting")) {
              c.hw(MMApplicationContext.getContext());
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
    if (paramg.aBb()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.topstory.a.g.class, new d());
    }
    AppMethodBeat.o(125862);
  }
  
  public int getFirstLoadWebView()
  {
    return this.GjO;
  }
  
  public HashMap<String, Integer> getVideoPlayProgressMap()
  {
    return this.GjQ;
  }
  
  public com.tencent.mm.plugin.topstory.ui.home.d getWebViewMgr()
  {
    return this.GjP;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(125860);
    this.GjP = new com.tencent.mm.plugin.topstory.ui.home.d();
    this.GjS.alive();
    ((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class)).registerMultiTaskUIC(8, TopStoryMultiTaskUIC.class);
    long l = com.tencent.mm.kernel.g.aAh().azQ().a(ar.a.OgQ, 0L);
    if (System.currentTimeMillis() - l <= 259200000L)
    {
      Log.i("MicroMsg.TopStory.PluginTopStoryUI", "Use TopStory In Three Days %s", new Object[] { com.tencent.mm.pluginsdk.i.f.formatTime("yyyy-MM-dd HH:mm:ss", l / 1000L) });
      ar.afB(23);
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
          com.tencent.mm.plugin.topstory.ui.home.d locald = PluginTopStoryUI.this.GjP;
          o localo = new o(h.fxS());
          int i;
          int k;
          Object localObject;
          if (localo.exists())
          {
            o[] arrayOfo = localo.het();
            if ((arrayOfo != null) && (arrayOfo.length > 0))
            {
              j = arrayOfo.length;
              i = 0;
              if (i < j)
              {
                localo = arrayOfo[i];
                k = Util.getInt(localo.getName(), -1);
                eij localeij;
                if (k > 0) {
                  localeij = new eij();
                }
                for (;;)
                {
                  try
                  {
                    localObject = s.aW(aa.z(localo.her()), 0, -1);
                    localeij.parseFrom((byte[])localObject);
                    locald.GlL.put(Integer.valueOf(k), localeij);
                    Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put home data cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(localObject.length) });
                    i += 1;
                  }
                  catch (Exception localException1)
                  {
                    Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException1, "loadHomeDataCache %s", new Object[] { localo.hes() });
                    continue;
                  }
                  Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Decode Key Error %s", new Object[] { aa.z(localo.her()) });
                }
              }
            }
            else
            {
              Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Files %s", new Object[] { aa.z(localo.her()) });
            }
            locald = PluginTopStoryUI.this.GjP;
            localo = new o(h.fxT());
            if (!localo.exists()) {
              break label502;
            }
            arrayOfo = localo.het();
            if ((arrayOfo == null) || (arrayOfo.length <= 0)) {
              break label474;
            }
            int j = arrayOfo.length;
            i = 0;
            label290:
            if (i >= j) {
              break label468;
            }
            localo = arrayOfo[i];
            k = Util.getInt(localo.getName(), -1);
            if (k <= 0) {
              break label443;
            }
          }
          for (;;)
          {
            try
            {
              byte[] arrayOfByte = s.aW(aa.z(localo.her()), 0, -1);
              localObject = new String(arrayOfByte, "utf-8");
              locald.GlM.put(Integer.valueOf(k), localObject);
              Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put neg cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(arrayOfByte.length) });
              i += 1;
              break label290;
              Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Exist %s", new Object[] { aa.z(localo.her()) });
            }
            catch (Exception localException2)
            {
              Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException2, "loadNegDataCache %s", new Object[] { localo.hes() });
              continue;
            }
            label443:
            Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Decode Key Error %s", new Object[] { aa.z(localo.her()) });
          }
          label468:
          AppMethodBeat.o(125854);
          return;
          label474:
          Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Files %s", new Object[] { aa.z(localo.her()) });
          AppMethodBeat.o(125854);
          return;
          label502:
          Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Exist %s", new Object[] { aa.z(localo.her()) });
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
    this.GjP = null;
    this.GjS.dead();
    com.tencent.mm.pluginsdk.cmd.b.V(new String[] { "//topstory" });
    this.GjQ.clear();
    AppMethodBeat.o(125861);
  }
  
  public void parallelsDependency() {}
  
  public void setFirstLoadWebView(int paramInt)
  {
    this.GjO = paramInt;
  }
  
  public void setHaokanEventListener(b.a parama)
  {
    this.GjR = parama;
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
        if ((PluginTopStoryUI.this.GjO == 2) && (((PluginTopStory)com.tencent.mm.kernel.g.ah(PluginTopStory.class)).getWebViewType() == WebView.c.SAv))
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
            i = ((a)com.tencent.mm.kernel.g.af(a.class)).aqJ().getInt("TopStoryWebViewPreInit", 1);
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
          ar.afB(26);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI
 * JD-Core Version:    0.7.0.1
 */