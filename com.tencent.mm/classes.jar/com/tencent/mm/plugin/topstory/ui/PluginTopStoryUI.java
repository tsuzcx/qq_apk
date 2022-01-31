package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.in.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashMap;

public class PluginTopStoryUI
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, b
{
  private int tft;
  private c tfu;
  private com.tencent.mm.plugin.topstory.ui.home.d tfv;
  private HashMap<String, Integer> tfw;
  private b.a tfx;
  private com.tencent.mm.sdk.b.c<in> tfy;
  
  public PluginTopStoryUI()
  {
    AppMethodBeat.i(1524);
    this.tft = 2;
    this.tfw = new HashMap();
    this.tfy = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(in paramAnonymousin)
      {
        AppMethodBeat.i(1522);
        if (paramAnonymousin.cxU == null)
        {
          AppMethodBeat.o(1522);
          return false;
        }
        ab.i("MicroMsg.TopStory.PluginTopStoryUI", "recv HaoKanActionEvent, serverData:%s, clientData:%s", new Object[] { paramAnonymousin.cxU.cxV, paramAnonymousin.cxU.cxW });
        if ((!bo.isNullOrNil(paramAnonymousin.cxU.cxV)) && (PluginTopStoryUI.this.tfx != null)) {
          PluginTopStoryUI.this.tfx.aeg(paramAnonymousin.cxU.cxV);
        }
        if (!bo.isNullOrNil(paramAnonymousin.cxU.cxW)) {}
        try
        {
          i locali = new i(paramAnonymousin.cxU.cxW);
          paramAnonymousin = locali.getString("action");
          locali = locali.mt("params");
          if (paramAnonymousin.equals("updateNumReddot"))
          {
            locali.optString("msgId");
            int i = locali.getInt("latestTimeStamp");
            int j = locali.getInt("seq");
            ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().h(i, j, true);
          }
          for (;;)
          {
            AppMethodBeat.o(1522);
            return true;
            if (!paramAnonymousin.equals("openProfile")) {
              break;
            }
            d.aei(locali.getString("openId"));
          }
        }
        catch (Exception paramAnonymousin)
        {
          for (;;)
          {
            ab.e("MicroMsg.TopStory.PluginTopStoryUI", "HaoKanActionEvent error");
            ab.printErrStackTrace("MicroMsg.TopStory.PluginTopStoryUI", paramAnonymousin, "", new Object[0]);
            continue;
            if (paramAnonymousin.equals("openWowColikeSetting")) {
              d.ff(ah.getContext());
            }
          }
        }
      }
    };
    AppMethodBeat.o(1524);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public int getFirstLoadWebView()
  {
    return this.tft;
  }
  
  public c getTopStoryCommand()
  {
    return this.tfu;
  }
  
  public HashMap<String, Integer> getVideoPlayProgressMap()
  {
    return this.tfw;
  }
  
  public com.tencent.mm.plugin.topstory.ui.home.d getWebViewMgr()
  {
    return this.tfv;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    int i = 1;
    AppMethodBeat.i(1525);
    this.tfv = new com.tencent.mm.plugin.topstory.ui.home.d();
    this.tfu = new c();
    com.tencent.mm.pluginsdk.cmd.b.a(this.tfu, new String[] { "//topstory" });
    this.tfy.alive();
    long l = com.tencent.mm.kernel.g.RL().Ru().a(ac.a.yKk, 0L);
    if (System.currentTimeMillis() - l <= 259200000L)
    {
      ab.i("MicroMsg.TopStory.PluginTopStoryUI", "Use TopStory In Three Days %s", new Object[] { h.formatTime("yyyy-MM-dd HH:mm:ss", l / 1000L) });
      an.Jw(23);
    }
    for (;;)
    {
      if (i != 0) {
        tryToCreateTopStoryWebView();
      }
      com.tencent.mm.sdk.g.d.post(new PluginTopStoryUI.1(this), "TopStory.DeleteTopStoryConversation");
      com.tencent.mm.sdk.g.d.post(new PluginTopStoryUI.2(this), "TopStory.LoadHomeCacheData");
      AppMethodBeat.o(1525);
      return;
      i = 0;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(1526);
    this.tfv = null;
    this.tfu = null;
    this.tfy.dead();
    com.tencent.mm.pluginsdk.cmd.b.N(new String[] { "//topstory" });
    this.tfw.clear();
    AppMethodBeat.o(1526);
  }
  
  public void parallelsDependency() {}
  
  public void setFirstLoadWebView(int paramInt)
  {
    this.tft = paramInt;
  }
  
  public void setHaokanEventListener(b.a parama)
  {
    this.tfx = parama;
  }
  
  public void tryToCreateTopStoryWebView()
  {
    AppMethodBeat.i(1527);
    al.p(new PluginTopStoryUI.3(this), 5000L);
    AppMethodBeat.o(1527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI
 * JD-Core Version:    0.7.0.1
 */