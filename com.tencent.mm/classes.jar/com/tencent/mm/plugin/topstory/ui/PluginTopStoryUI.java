package com.tencent.mm.plugin.topstory.ui;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.a.jx.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.vfs.q;
import com.tencent.xweb.WebView.c;
import java.util.HashMap;

public class PluginTopStoryUI
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, b
{
  private int BrG;
  private c BrH;
  private com.tencent.mm.plugin.topstory.ui.home.d BrI;
  private HashMap<String, Integer> BrJ;
  private b.a BrK;
  private com.tencent.mm.sdk.b.c<jx> BrL;
  
  public PluginTopStoryUI()
  {
    AppMethodBeat.i(125859);
    this.BrG = 2;
    this.BrJ = new HashMap();
    this.BrL = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(jx paramAnonymousjx)
      {
        AppMethodBeat.i(125857);
        if (paramAnonymousjx.dwR == null)
        {
          AppMethodBeat.o(125857);
          return false;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.PluginTopStoryUI", "recv HaoKanActionEvent, serverData:%s, clientData:%s", new Object[] { paramAnonymousjx.dwR.dwS, paramAnonymousjx.dwR.dwT });
        if ((!bt.isNullOrNil(paramAnonymousjx.dwR.dwS)) && (PluginTopStoryUI.this.BrK != null)) {
          PluginTopStoryUI.this.BrK.aCO(paramAnonymousjx.dwR.dwS);
        }
        if (!bt.isNullOrNil(paramAnonymousjx.dwR.dwT)) {}
        try
        {
          com.tencent.mm.ac.i locali = new com.tencent.mm.ac.i(paramAnonymousjx.dwR.dwT);
          paramAnonymousjx = locali.getString("action");
          locali = locali.wO("params");
          if (paramAnonymousjx.equals("updateNumReddot"))
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
            if (!paramAnonymousjx.equals("openProfile")) {
              break;
            }
            d.aCQ(locali.getString("openId"));
          }
        }
        catch (Exception paramAnonymousjx)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TopStory.PluginTopStoryUI", "HaoKanActionEvent error");
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.PluginTopStoryUI", paramAnonymousjx, "", new Object[0]);
            continue;
            if (paramAnonymousjx.equals("openWowColikeSetting")) {
              d.gy(aj.getContext());
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
    if (paramg.akw()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.topstory.a.g.class, new e());
    }
    AppMethodBeat.o(125862);
  }
  
  public int getFirstLoadWebView()
  {
    return this.BrG;
  }
  
  public c getTopStoryCommand()
  {
    return this.BrH;
  }
  
  public HashMap<String, Integer> getVideoPlayProgressMap()
  {
    return this.BrJ;
  }
  
  public com.tencent.mm.plugin.topstory.ui.home.d getWebViewMgr()
  {
    return this.BrI;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    int i = 1;
    AppMethodBeat.i(125860);
    this.BrI = new com.tencent.mm.plugin.topstory.ui.home.d();
    this.BrH = new c();
    com.tencent.mm.pluginsdk.cmd.b.a(this.BrH, new String[] { "//topstory" });
    this.BrL.alive();
    com.tencent.mm.plugin.topstory.ui.a.a.bgQ();
    long l = com.tencent.mm.kernel.g.ajC().ajl().a(al.a.IDT, 0L);
    if (System.currentTimeMillis() - l <= 259200000L)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.PluginTopStoryUI", "Use TopStory In Three Days %s", new Object[] { com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", l / 1000L) });
      am.Wm(23);
    }
    for (;;)
    {
      if (i != 0) {
        tryToCreateTopStoryWebView();
      }
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125854);
          long l = com.tencent.mm.plugin.websearch.api.ad.We(1);
          if (((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEz, Long.valueOf(0L))).longValue() != l)
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(17040, new Object[] { Integer.valueOf(1), Long.valueOf(l) });
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEz, Long.valueOf(l));
            com.tencent.mm.kernel.g.ajC().ajl().fqc();
          }
          ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTx("topstoryapp");
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.PluginTopStoryUI", "Delete TopStory Conversation Entry");
          AppMethodBeat.o(125854);
        }
      }, "TopStory.DeleteTopStoryConversation");
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125855);
          com.tencent.mm.plugin.topstory.ui.home.d locald = PluginTopStoryUI.this.BrI;
          com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(h.eoL());
          int i;
          int k;
          Object localObject;
          if (locale.exists())
          {
            com.tencent.mm.vfs.e[] arrayOfe = locale.fOM();
            if ((arrayOfe != null) && (arrayOfe.length > 0))
            {
              j = arrayOfe.length;
              i = 0;
              if (i < j)
              {
                locale = arrayOfe[i];
                k = bt.getInt(locale.getName(), -1);
                dnq localdnq;
                if (k > 0) {
                  localdnq = new dnq();
                }
                for (;;)
                {
                  try
                  {
                    localObject = com.tencent.mm.vfs.i.aY(q.B(locale.fOK()), 0, -1);
                    localdnq.parseFrom((byte[])localObject);
                    locald.BtH.put(Integer.valueOf(k), localdnq);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put home data cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(localObject.length) });
                    i += 1;
                  }
                  catch (Exception localException1)
                  {
                    com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException1, "loadHomeDataCache %s", new Object[] { locale.fOL() });
                    continue;
                  }
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Decode Key Error %s", new Object[] { q.B(locale.fOK()) });
                }
              }
            }
            else
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Files %s", new Object[] { q.B(locale.fOK()) });
            }
            locald = PluginTopStoryUI.this.BrI;
            locale = new com.tencent.mm.vfs.e(h.eoM());
            if (!locale.exists()) {
              break label502;
            }
            arrayOfe = locale.fOM();
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
            k = bt.getInt(locale.getName(), -1);
            if (k <= 0) {
              break label443;
            }
          }
          for (;;)
          {
            try
            {
              byte[] arrayOfByte = com.tencent.mm.vfs.i.aY(q.B(locale.fOK()), 0, -1);
              localObject = new String(arrayOfByte, "utf-8");
              locald.BtI.put(Integer.valueOf(k), localObject);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put neg cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(arrayOfByte.length) });
              i += 1;
              break label290;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Exist %s", new Object[] { q.B(locale.fOK()) });
            }
            catch (Exception localException2)
            {
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException2, "loadNegDataCache %s", new Object[] { locale.fOL() });
              continue;
            }
            label443:
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Decode Key Error %s", new Object[] { q.B(locale.fOK()) });
          }
          label468:
          AppMethodBeat.o(125855);
          return;
          label474:
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Files %s", new Object[] { q.B(locale.fOK()) });
          AppMethodBeat.o(125855);
          return;
          label502:
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Exist %s", new Object[] { q.B(locale.fOK()) });
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
    this.BrI = null;
    this.BrH = null;
    this.BrL.dead();
    com.tencent.mm.plugin.topstory.ui.a.a.bgR();
    com.tencent.mm.pluginsdk.cmd.b.S(new String[] { "//topstory" });
    this.BrJ.clear();
    AppMethodBeat.o(125861);
  }
  
  public void parallelsDependency() {}
  
  public void setFirstLoadWebView(int paramInt)
  {
    this.BrG = paramInt;
  }
  
  public void setHaokanEventListener(b.a parama)
  {
    this.BrK = parama;
  }
  
  public void tryToCreateTopStoryWebView()
  {
    AppMethodBeat.i(125863);
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125856);
        long l;
        if ((PluginTopStoryUI.this.BrG == 2) && (((PluginTopStory)com.tencent.mm.kernel.g.ad(PluginTopStory.class)).getWebViewType() == WebView.c.Mqw))
        {
          String str = Build.BRAND;
          int i;
          if (!bt.isNullOrNil(str))
          {
            str = str.toLowerCase();
            if ((str.contains("huawei")) || (str.contains("honor"))) {
              i = 0;
            }
          }
          while (i != 0)
          {
            i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("TopStoryWebViewPreInit", 1);
            if (i == 0)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.PluginTopStoryUI", "MXM_DynaCfg_AV_Item_Key_TopStory_WebViewPreInit is %d", new Object[] { Integer.valueOf(i) });
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
          new TopStoryWebView(aj.getContext()).destroy();
          label158:
          am.Wm(26);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.PluginTopStoryUI", "Create TopStoryWebView Use Time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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