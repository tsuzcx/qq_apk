package com.tencent.mm.plugin.topstory.ui;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jp;
import com.tencent.mm.g.a.jp.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vfs.q;
import com.tencent.xweb.WebView.c;
import java.util.HashMap;

public class PluginTopStoryUI
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, b
{
  private int zZU;
  private c zZV;
  private com.tencent.mm.plugin.topstory.ui.home.d zZW;
  private HashMap<String, Integer> zZX;
  private b.a zZY;
  private com.tencent.mm.sdk.b.c<jp> zZZ;
  
  public PluginTopStoryUI()
  {
    AppMethodBeat.i(125859);
    this.zZU = 2;
    this.zZX = new HashMap();
    this.zZZ = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(jp paramAnonymousjp)
      {
        AppMethodBeat.i(125857);
        if (paramAnonymousjp.dle == null)
        {
          AppMethodBeat.o(125857);
          return false;
        }
        ac.i("MicroMsg.TopStory.PluginTopStoryUI", "recv HaoKanActionEvent, serverData:%s, clientData:%s", new Object[] { paramAnonymousjp.dle.dlf, paramAnonymousjp.dle.dlg });
        if ((!bs.isNullOrNil(paramAnonymousjp.dle.dlf)) && (PluginTopStoryUI.this.zZY != null)) {
          PluginTopStoryUI.this.zZY.axJ(paramAnonymousjp.dle.dlf);
        }
        if (!bs.isNullOrNil(paramAnonymousjp.dle.dlg)) {}
        try
        {
          com.tencent.mm.ab.i locali = new com.tencent.mm.ab.i(paramAnonymousjp.dle.dlg);
          paramAnonymousjp = locali.getString("action");
          locali = locali.tY("params");
          if (paramAnonymousjp.equals("updateNumReddot"))
          {
            locali.optString("msgId");
            int i = locali.getInt("latestTimeStamp");
            int j = locali.getInt("seq");
            ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().h(i, j, true);
          }
          for (;;)
          {
            AppMethodBeat.o(125857);
            return true;
            if (!paramAnonymousjp.equals("openProfile")) {
              break;
            }
            d.axL(locali.getString("openId"));
          }
        }
        catch (Exception paramAnonymousjp)
        {
          for (;;)
          {
            ac.e("MicroMsg.TopStory.PluginTopStoryUI", "HaoKanActionEvent error");
            ac.printErrStackTrace("MicroMsg.TopStory.PluginTopStoryUI", paramAnonymousjp, "", new Object[0]);
            continue;
            if (paramAnonymousjp.equals("openWowColikeSetting")) {
              d.gv(com.tencent.mm.sdk.platformtools.ai.getContext());
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
    if (paramg.ahL()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.topstory.a.g.class, new e());
    }
    AppMethodBeat.o(125862);
  }
  
  public int getFirstLoadWebView()
  {
    return this.zZU;
  }
  
  public c getTopStoryCommand()
  {
    return this.zZV;
  }
  
  public HashMap<String, Integer> getVideoPlayProgressMap()
  {
    return this.zZX;
  }
  
  public com.tencent.mm.plugin.topstory.ui.home.d getWebViewMgr()
  {
    return this.zZW;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    int i = 1;
    AppMethodBeat.i(125860);
    this.zZW = new com.tencent.mm.plugin.topstory.ui.home.d();
    this.zZV = new c();
    com.tencent.mm.pluginsdk.cmd.b.a(this.zZV, new String[] { "//topstory" });
    this.zZZ.alive();
    com.tencent.mm.plugin.topstory.ui.a.a.bdm();
    long l = com.tencent.mm.kernel.g.agR().agA().a(ah.a.GRp, 0L);
    if (System.currentTimeMillis() - l <= 259200000L)
    {
      ac.i("MicroMsg.TopStory.PluginTopStoryUI", "Use TopStory In Three Days %s", new Object[] { com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", l / 1000L) });
      com.tencent.mm.plugin.websearch.api.ai.Ut(23);
    }
    for (;;)
    {
      if (i != 0) {
        tryToCreateTopStoryWebView();
      }
      com.tencent.mm.sdk.g.b.c(new PluginTopStoryUI.1(this), "TopStory.DeleteTopStoryConversation");
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125855);
          com.tencent.mm.plugin.topstory.ui.home.d locald = PluginTopStoryUI.this.zZW;
          com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.topstory.a.h.ecu());
          int i;
          int k;
          Object localObject;
          if (locale.exists())
          {
            com.tencent.mm.vfs.e[] arrayOfe = locale.fxX();
            if ((arrayOfe != null) && (arrayOfe.length > 0))
            {
              j = arrayOfe.length;
              i = 0;
              if (i < j)
              {
                locale = arrayOfe[i];
                k = bs.getInt(locale.getName(), -1);
                dib localdib;
                if (k > 0) {
                  localdib = new dib();
                }
                for (;;)
                {
                  try
                  {
                    localObject = com.tencent.mm.vfs.i.aU(q.B(locale.fxV()), 0, -1);
                    localdib.parseFrom((byte[])localObject);
                    locald.AbW.put(Integer.valueOf(k), localdib);
                    ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put home data cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(localObject.length) });
                    i += 1;
                  }
                  catch (Exception localException1)
                  {
                    ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException1, "loadHomeDataCache %s", new Object[] { locale.fxW() });
                    continue;
                  }
                  ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Decode Key Error %s", new Object[] { q.B(locale.fxV()) });
                }
              }
            }
            else
            {
              ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Files %s", new Object[] { q.B(locale.fxV()) });
            }
            locald = PluginTopStoryUI.this.zZW;
            locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.topstory.a.h.ecv());
            if (!locale.exists()) {
              break label502;
            }
            arrayOfe = locale.fxX();
            if ((arrayOfe == null) || (arrayOfe.length <= 0)) {
              break label474;
            }
            int j = arrayOfe.length;
            i = 0;
            label290:
            if (i >= j) {
              break label468;
            }
            locale = arrayOfe[i];
            k = bs.getInt(locale.getName(), -1);
            if (k <= 0) {
              break label443;
            }
          }
          for (;;)
          {
            try
            {
              byte[] arrayOfByte = com.tencent.mm.vfs.i.aU(q.B(locale.fxV()), 0, -1);
              localObject = new String(arrayOfByte, "utf-8");
              locald.AbX.put(Integer.valueOf(k), localObject);
              ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put neg cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(arrayOfByte.length) });
              i += 1;
              break label290;
              ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Exist %s", new Object[] { q.B(locale.fxV()) });
            }
            catch (Exception localException2)
            {
              ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException2, "loadNegDataCache %s", new Object[] { locale.fxW() });
              continue;
            }
            label443:
            ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Decode Key Error %s", new Object[] { q.B(locale.fxV()) });
          }
          label468:
          AppMethodBeat.o(125855);
          return;
          label474:
          ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Files %s", new Object[] { q.B(locale.fxV()) });
          AppMethodBeat.o(125855);
          return;
          label502:
          ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Exist %s", new Object[] { q.B(locale.fxV()) });
          AppMethodBeat.o(125855);
        }
      }, "TopStory.LoadHomeCacheData");
      AppMethodBeat.o(125860);
      return;
      i = 0;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(125861);
    this.zZW = null;
    this.zZV = null;
    this.zZZ.dead();
    com.tencent.mm.plugin.topstory.ui.a.a.bdn();
    com.tencent.mm.pluginsdk.cmd.b.Q(new String[] { "//topstory" });
    this.zZX.clear();
    AppMethodBeat.o(125861);
  }
  
  public void parallelsDependency() {}
  
  public void setFirstLoadWebView(int paramInt)
  {
    this.zZU = paramInt;
  }
  
  public void setHaokanEventListener(b.a parama)
  {
    this.zZY = parama;
  }
  
  public void tryToCreateTopStoryWebView()
  {
    AppMethodBeat.i(125863);
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125856);
        long l;
        if ((PluginTopStoryUI.this.zZU == 2) && (((PluginTopStory)com.tencent.mm.kernel.g.ad(PluginTopStory.class)).getWebViewType() == WebView.c.KAb))
        {
          String str = Build.BRAND;
          int i;
          if (!bs.isNullOrNil(str))
          {
            str = str.toLowerCase();
            if ((str.contains("huawei")) || (str.contains("honor"))) {
              i = 0;
            }
          }
          while (i != 0)
          {
            i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("TopStoryWebViewPreInit", 1);
            if (i == 0)
            {
              ac.i("MicroMsg.TopStory.PluginTopStoryUI", "MXM_DynaCfg_AV_Item_Key_TopStory_WebViewPreInit is %d", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(125856);
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
          new TopStoryWebView(com.tencent.mm.sdk.platformtools.ai.getContext()).destroy();
          label158:
          com.tencent.mm.plugin.websearch.api.ai.Ut(26);
          ac.i("MicroMsg.TopStory.PluginTopStoryUI", "Create TopStoryWebView Use Time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI
 * JD-Core Version:    0.7.0.1
 */