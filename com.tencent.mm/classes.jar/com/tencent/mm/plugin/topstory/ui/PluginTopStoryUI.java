package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.g.a.jy.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.topstory.ui.a.a;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.HashMap;

public class PluginTopStoryUI
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, b
{
  private int BJf;
  private c BJg;
  private com.tencent.mm.plugin.topstory.ui.home.d BJh;
  private HashMap<String, Integer> BJi;
  private b.a BJj;
  private com.tencent.mm.sdk.b.c<jy> BJk;
  
  public PluginTopStoryUI()
  {
    AppMethodBeat.i(125859);
    this.BJf = 2;
    this.BJi = new HashMap();
    this.BJk = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(jy paramAnonymousjy)
      {
        AppMethodBeat.i(125857);
        if (paramAnonymousjy.dxW == null)
        {
          AppMethodBeat.o(125857);
          return false;
        }
        ae.i("MicroMsg.TopStory.PluginTopStoryUI", "recv HaoKanActionEvent, serverData:%s, clientData:%s", new Object[] { paramAnonymousjy.dxW.dxX, paramAnonymousjy.dxW.dxY });
        if ((!bu.isNullOrNil(paramAnonymousjy.dxW.dxX)) && (PluginTopStoryUI.this.BJj != null)) {
          PluginTopStoryUI.this.BJj.aEh(paramAnonymousjy.dxW.dxX);
        }
        if (!bu.isNullOrNil(paramAnonymousjy.dxW.dxY)) {}
        try
        {
          com.tencent.mm.ab.i locali = new com.tencent.mm.ab.i(paramAnonymousjy.dxW.dxY);
          paramAnonymousjy = locali.getString("action");
          locali = locali.xx("params");
          if (paramAnonymousjy.equals("updateNumReddot"))
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
            if (!paramAnonymousjy.equals("openProfile")) {
              break;
            }
            d.aEj(locali.getString("openId"));
          }
        }
        catch (Exception paramAnonymousjy)
        {
          for (;;)
          {
            ae.e("MicroMsg.TopStory.PluginTopStoryUI", "HaoKanActionEvent error");
            ae.printErrStackTrace("MicroMsg.TopStory.PluginTopStoryUI", paramAnonymousjy, "", new Object[0]);
            continue;
            if (paramAnonymousjy.equals("openWowColikeSetting")) {
              d.gD(ak.getContext());
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
    if (paramg.akL()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.topstory.a.g.class, new e());
    }
    AppMethodBeat.o(125862);
  }
  
  public int getFirstLoadWebView()
  {
    return this.BJf;
  }
  
  public c getTopStoryCommand()
  {
    return this.BJg;
  }
  
  public HashMap<String, Integer> getVideoPlayProgressMap()
  {
    return this.BJi;
  }
  
  public com.tencent.mm.plugin.topstory.ui.home.d getWebViewMgr()
  {
    return this.BJh;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    int i = 1;
    AppMethodBeat.i(125860);
    this.BJh = new com.tencent.mm.plugin.topstory.ui.home.d();
    this.BJg = new c();
    com.tencent.mm.pluginsdk.cmd.b.a(this.BJg, new String[] { "//topstory" });
    this.BJk.alive();
    a.bhy();
    long l = com.tencent.mm.kernel.g.ajR().ajA().a(am.a.IYt, 0L);
    if (System.currentTimeMillis() - l <= 259200000L)
    {
      ae.i("MicroMsg.TopStory.PluginTopStoryUI", "Use TopStory In Three Days %s", new Object[] { com.tencent.mm.pluginsdk.i.i.formatTime("yyyy-MM-dd HH:mm:ss", l / 1000L) });
      am.WT(23);
    }
    for (;;)
    {
      if (i != 0) {
        tryToCreateTopStoryWebView();
      }
      com.tencent.mm.sdk.g.b.c(new PluginTopStoryUI.1(this), "TopStory.DeleteTopStoryConversation");
      com.tencent.mm.sdk.g.b.c(new PluginTopStoryUI.2(this), "TopStory.LoadHomeCacheData");
      AppMethodBeat.o(125860);
      return;
      i = 0;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(125861);
    this.BJh = null;
    this.BJg = null;
    this.BJk.dead();
    a.bhz();
    com.tencent.mm.pluginsdk.cmd.b.S(new String[] { "//topstory" });
    this.BJi.clear();
    AppMethodBeat.o(125861);
  }
  
  public void parallelsDependency() {}
  
  public void setFirstLoadWebView(int paramInt)
  {
    this.BJf = paramInt;
  }
  
  public void setHaokanEventListener(b.a parama)
  {
    this.BJj = parama;
  }
  
  public void tryToCreateTopStoryWebView()
  {
    AppMethodBeat.i(125863);
    ar.o(new PluginTopStoryUI.3(this), 5000L);
    AppMethodBeat.o(125863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI
 * JD-Core Version:    0.7.0.1
 */