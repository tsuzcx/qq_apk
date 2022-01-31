package com.tencent.mm.plugin.topstory;

import android.os.Build;
import android.os.Looper;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView.d;
import java.io.File;
import java.util.Map;

public class PluginTopStory
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.topstory.a.b
{
  private c pCL;
  private b pCM;
  private a pCN;
  private WebView.d pCO = WebView.d.xhq;
  
  private void preInitXWebView()
  {
    String str2 = Build.BRAND;
    Object localObject = "";
    String str1 = str2;
    boolean bool1;
    if (!bk.bl(str2))
    {
      str2 = str2.toLowerCase();
      if (str2.contains("xiaomi"))
      {
        localObject = new File("/data/system/theme/fonts/", "Roboto-Regular.ttf");
        bool1 = ((File)localObject).exists();
        localObject = ((File)localObject).getAbsolutePath();
        str1 = str2;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.TopStory.TopStoryApiLogic", "checkNeedXWeb %s %b %s", new Object[] { str1, Boolean.valueOf(bool1), localObject });
      if (bool1)
      {
        com.tencent.mm.plugin.report.f.nEG.a(649L, 25L, 1L, false);
        this.pCO = WebView.d.xho;
      }
      com.tencent.mm.cl.b.a(this.pCO, new PluginTopStory.1(this));
      y.i("MicroMsg.TopStory.PluginTopStory", "Start To Load WebView %s", new Object[] { this.pCO.name() });
      return;
      if ((str2.contains("huawei")) || (str2.contains("honor")))
      {
        if (d.gF(26))
        {
          bool1 = true;
          str1 = str2;
        }
        else
        {
          localObject = new File("/data/skin/fonts/", "DroidSansChinese.ttf");
          bool1 = ((File)localObject).exists();
          localObject = ((File)localObject).getAbsolutePath();
          str1 = str2;
        }
      }
      else if (str2.contains("samsung"))
      {
        localObject = new File("/data/app_fonts/0/", "sans.loc");
        boolean bool2 = com.tencent.mm.plugin.topstory.a.g.L((File)localObject);
        localObject = ((File)localObject).getAbsolutePath();
        bool1 = bool2;
        str1 = str2;
        if (!bool2)
        {
          localObject = new File("/data/user/0/com.android.settings/app_fonts/", "sans.loc");
          bool1 = com.tencent.mm.plugin.topstory.a.g.L((File)localObject);
          localObject = ((File)localObject).getAbsolutePath();
          str1 = str2;
        }
      }
      else
      {
        str1 = str2;
        if (str2.contains("meizu"))
        {
          localObject = new File("/data/data/com.meizu.customizecenter/font/", "flymeFont.ttf");
          bool1 = ((File)localObject).exists();
          localObject = ((File)localObject).getAbsolutePath();
          str1 = str2;
        }
        else
        {
          bool1 = false;
        }
      }
    }
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public a getPerformTracer()
  {
    return this.pCN;
  }
  
  public b getRedDotMgr()
  {
    return this.pCM;
  }
  
  public c getReporter()
  {
    return this.pCL;
  }
  
  public WebView.d getWebViewType()
  {
    return this.pCO;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    this.pCL = new c();
    this.pCM = new b();
    this.pCN = new a();
    e.post(new PluginTopStory.a(this, (byte)0), "TopStory.InitTopStoryCacheFolderTask");
    preInitXWebView();
  }
  
  public void onAccountRelease()
  {
    Object localObject;
    if (this.pCL != null)
    {
      localObject = this.pCL;
      ((c)localObject).pCV.removeCallbacksAndMessages(null);
      ((c)localObject).pCV.getLooper().quit();
      this.pCL = null;
    }
    if (this.pCM != null)
    {
      localObject = this.pCM;
      ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", ((b)localObject).pCS);
      this.pCM = null;
    }
    if (this.pCN != null)
    {
      this.pCN.pCQ.clear();
      this.pCN = null;
    }
  }
  
  public void onVideoListUICreate() {}
  
  public void onVideoListUIDestroy(byf parambyf) {}
  
  public void onVideoListUIPause() {}
  
  public void onVideoListUIResume() {}
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.PluginTopStory
 * JD-Core Version:    0.7.0.1
 */