package com.tencent.mm.plugin.topstory.ui;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.c.byc;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.HashMap;

public class PluginTopStoryUI
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, a
{
  private int pDC = 2;
  private c pDD;
  private d pDE;
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public int getFirstLoadWebView()
  {
    return this.pDC;
  }
  
  public c getTopStoryCommand()
  {
    return this.pDD;
  }
  
  public d getWebViewMgr()
  {
    return this.pDE;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    int i = 1;
    this.pDE = new d();
    this.pDD = new c();
    com.tencent.mm.pluginsdk.cmd.b.a(this.pDD, new String[] { "//topstory" });
    long l = com.tencent.mm.kernel.g.DP().Dz().a(ac.a.uzw, 0L);
    if (System.currentTimeMillis() - l <= 259200000L)
    {
      y.i("MicroMsg.TopStory.PluginTopStoryUI", "Use TopStory In Three Days %s", new Object[] { h.g("yyyy-MM-dd HH:mm:ss", l / 1000L) });
      ao.BG(23);
    }
    for (;;)
    {
      if (i != 0) {
        tryToCreateTopStoryWebView();
      }
      com.tencent.mm.sdk.f.e.post(new PluginTopStoryUI.1(this), "TopStory.DeleteTopStoryConversation");
      com.tencent.mm.sdk.f.e.post(new Runnable()
      {
        public final void run()
        {
          d locald = PluginTopStoryUI.this.pDE;
          File localFile = new File(com.tencent.mm.plugin.topstory.a.g.bNe());
          if (localFile.exists())
          {
            File[] arrayOfFile = localFile.listFiles();
            if ((arrayOfFile != null) && (arrayOfFile.length > 0))
            {
              int j = arrayOfFile.length;
              int i = 0;
              if (i < j)
              {
                localFile = arrayOfFile[i];
                int k = bk.getInt(localFile.getName(), -1);
                byc localbyc;
                if (k > 0) {
                  localbyc = new byc();
                }
                for (;;)
                {
                  try
                  {
                    byte[] arrayOfByte = com.tencent.mm.vfs.e.c(localFile.getAbsolutePath(), 0, -1);
                    localbyc.aH(arrayOfByte);
                    locald.pEi.put(Integer.valueOf(k), localbyc);
                    y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put home data cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(arrayOfByte.length) });
                    i += 1;
                  }
                  catch (Exception localException)
                  {
                    y.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException, "loadHomeDataCache %s", new Object[] { localFile.getAbsoluteFile() });
                    continue;
                  }
                  y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Decode Key Error %s", new Object[] { localFile.getAbsolutePath() });
                }
              }
            }
            else
            {
              y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Files %s", new Object[] { localFile.getAbsolutePath() });
            }
          }
          for (;;)
          {
            PluginTopStoryUI.this.pDE.bNo();
            return;
            y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Exist %s", new Object[] { localFile.getAbsolutePath() });
          }
        }
      }, "TopStory.LoadHomeCacheData");
      return;
      i = 0;
    }
  }
  
  public void onAccountRelease()
  {
    this.pDE = null;
    this.pDD = null;
    com.tencent.mm.pluginsdk.cmd.b.E(new String[] { "//topstory" });
  }
  
  public void parallelsDependency() {}
  
  public void setFirstLoadWebView(int paramInt)
  {
    this.pDC = paramInt;
  }
  
  public void tryToCreateTopStoryWebView() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI
 * JD-Core Version:    0.7.0.1
 */