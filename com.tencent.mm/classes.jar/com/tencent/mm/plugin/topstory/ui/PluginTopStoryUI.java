package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.g.a.ji.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.topstory.ui.a.a;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.protocal.protobuf.dco;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vfs.q;
import java.util.HashMap;

public class PluginTopStoryUI
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, b
{
  private int yMc;
  private c yMd;
  private com.tencent.mm.plugin.topstory.ui.home.d yMe;
  private HashMap<String, Integer> yMf;
  private b.a yMg;
  private com.tencent.mm.sdk.b.c<ji> yMh;
  
  public PluginTopStoryUI()
  {
    AppMethodBeat.i(125859);
    this.yMc = 2;
    this.yMf = new HashMap();
    this.yMh = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(ji paramAnonymousji)
      {
        AppMethodBeat.i(125857);
        if (paramAnonymousji.dnw == null)
        {
          AppMethodBeat.o(125857);
          return false;
        }
        ad.i("MicroMsg.TopStory.PluginTopStoryUI", "recv HaoKanActionEvent, serverData:%s, clientData:%s", new Object[] { paramAnonymousji.dnw.dnx, paramAnonymousji.dnw.dny });
        if ((!bt.isNullOrNil(paramAnonymousji.dnw.dnx)) && (PluginTopStoryUI.this.yMg != null)) {
          PluginTopStoryUI.this.yMg.asA(paramAnonymousji.dnw.dnx);
        }
        if (!bt.isNullOrNil(paramAnonymousji.dnw.dny)) {}
        try
        {
          com.tencent.mm.ac.i locali = new com.tencent.mm.ac.i(paramAnonymousji.dnw.dny);
          paramAnonymousji = locali.getString("action");
          locali = locali.qJ("params");
          if (paramAnonymousji.equals("updateNumReddot"))
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
            if (!paramAnonymousji.equals("openProfile")) {
              break;
            }
            d.asC(locali.getString("openId"));
          }
        }
        catch (Exception paramAnonymousji)
        {
          for (;;)
          {
            ad.e("MicroMsg.TopStory.PluginTopStoryUI", "HaoKanActionEvent error");
            ad.printErrStackTrace("MicroMsg.TopStory.PluginTopStoryUI", paramAnonymousji, "", new Object[0]);
            continue;
            if (paramAnonymousji.equals("openWowColikeSetting")) {
              d.gj(aj.getContext());
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
    if (paramg.agu()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.topstory.a.g.class, new e());
    }
    AppMethodBeat.o(125862);
  }
  
  public int getFirstLoadWebView()
  {
    return this.yMc;
  }
  
  public c getTopStoryCommand()
  {
    return this.yMd;
  }
  
  public HashMap<String, Integer> getVideoPlayProgressMap()
  {
    return this.yMf;
  }
  
  public com.tencent.mm.plugin.topstory.ui.home.d getWebViewMgr()
  {
    return this.yMe;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    int i = 1;
    AppMethodBeat.i(125860);
    this.yMe = new com.tencent.mm.plugin.topstory.ui.home.d();
    this.yMd = new c();
    com.tencent.mm.pluginsdk.cmd.b.a(this.yMd, new String[] { "//topstory" });
    this.yMh.alive();
    a.aWo();
    long l = com.tencent.mm.kernel.g.afB().afk().a(ae.a.Ftv, 0L);
    if (System.currentTimeMillis() - l <= 259200000L)
    {
      ad.i("MicroMsg.TopStory.PluginTopStoryUI", "Use TopStory In Three Days %s", new Object[] { com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", l / 1000L) });
      ak.Sk(23);
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
          com.tencent.mm.plugin.topstory.ui.home.d locald = PluginTopStoryUI.this.yMe;
          com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.topstory.a.h.dNU());
          int i;
          int k;
          Object localObject;
          if (locale.exists())
          {
            com.tencent.mm.vfs.e[] arrayOfe = locale.fhW();
            if ((arrayOfe != null) && (arrayOfe.length > 0))
            {
              j = arrayOfe.length;
              i = 0;
              if (i < j)
              {
                locale = arrayOfe[i];
                k = bt.getInt(locale.getName(), -1);
                dco localdco;
                if (k > 0) {
                  localdco = new dco();
                }
                for (;;)
                {
                  try
                  {
                    localObject = com.tencent.mm.vfs.i.aR(q.B(locale.fhU()), 0, -1);
                    localdco.parseFrom((byte[])localObject);
                    locald.yOf.put(Integer.valueOf(k), localdco);
                    ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put home data cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(localObject.length) });
                    i += 1;
                  }
                  catch (Exception localException1)
                  {
                    ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException1, "loadHomeDataCache %s", new Object[] { locale.fhV() });
                    continue;
                  }
                  ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Decode Key Error %s", new Object[] { q.B(locale.fhU()) });
                }
              }
            }
            else
            {
              ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Files %s", new Object[] { q.B(locale.fhU()) });
            }
            locald = PluginTopStoryUI.this.yMe;
            locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.topstory.a.h.dNV());
            if (!locale.exists()) {
              break label502;
            }
            arrayOfe = locale.fhW();
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
              byte[] arrayOfByte = com.tencent.mm.vfs.i.aR(q.B(locale.fhU()), 0, -1);
              localObject = new String(arrayOfByte, "utf-8");
              locald.yOg.put(Integer.valueOf(k), localObject);
              ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put neg cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(arrayOfByte.length) });
              i += 1;
              break label290;
              ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Exist %s", new Object[] { q.B(locale.fhU()) });
            }
            catch (Exception localException2)
            {
              ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException2, "loadNegDataCache %s", new Object[] { locale.fhV() });
              continue;
            }
            label443:
            ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Decode Key Error %s", new Object[] { q.B(locale.fhU()) });
          }
          label468:
          AppMethodBeat.o(125855);
          return;
          label474:
          ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Files %s", new Object[] { q.B(locale.fhU()) });
          AppMethodBeat.o(125855);
          return;
          label502:
          ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Exist %s", new Object[] { q.B(locale.fhU()) });
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
    this.yMe = null;
    this.yMd = null;
    this.yMh.dead();
    a.aWp();
    com.tencent.mm.pluginsdk.cmd.b.Q(new String[] { "//topstory" });
    this.yMf.clear();
    AppMethodBeat.o(125861);
  }
  
  public void parallelsDependency() {}
  
  public void setFirstLoadWebView(int paramInt)
  {
    this.yMc = paramInt;
  }
  
  public void setHaokanEventListener(b.a parama)
  {
    this.yMg = parama;
  }
  
  public void tryToCreateTopStoryWebView()
  {
    AppMethodBeat.i(125863);
    aq.n(new PluginTopStoryUI.3(this), 5000L);
    AppMethodBeat.o(125863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI
 * JD-Core Version:    0.7.0.1
 */