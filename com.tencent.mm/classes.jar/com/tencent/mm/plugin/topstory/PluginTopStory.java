package com.tencent.mm.plugin.topstory;

import android.os.Build;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView.d;
import java.io.File;
import java.util.Map;

public class PluginTopStory
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.topstory.a.b
{
  private c teu;
  private b tev;
  private a tew;
  private WebView.d tey = WebView.d.BEs;
  
  private void preInitXWebView()
  {
    AppMethodBeat.i(65448);
    String str2 = Build.BRAND;
    Object localObject = "";
    String str1 = str2;
    boolean bool1;
    if (!bo.isNullOrNil(str2))
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
      ab.i("MicroMsg.TopStory.TopStoryApiLogic", "checkNeedXWeb %s %b %s", new Object[] { str1, Boolean.valueOf(bool1), localObject });
      if (bool1)
      {
        e.qrI.idkeyStat(649L, 25L, 1L, false);
        this.tey = WebView.d.BEq;
      }
      com.tencent.mm.cn.d.a(this.tey, new PluginTopStory.1(this));
      ab.i("MicroMsg.TopStory.PluginTopStory", "Start To Load WebView %s", new Object[] { this.tey.name() });
      AppMethodBeat.o(65448);
      return;
      if ((str2.contains("huawei")) || (str2.contains("honor")))
      {
        if (com.tencent.mm.compatible.util.d.fv(26))
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
        boolean bool2 = com.tencent.mm.plugin.topstory.a.g.T((File)localObject);
        localObject = ((File)localObject).getAbsolutePath();
        bool1 = bool2;
        str1 = str2;
        if (!bool2)
        {
          localObject = new File("/data/user/0/com.android.settings/app_fonts/", "sans.loc");
          bool1 = com.tencent.mm.plugin.topstory.a.g.T((File)localObject);
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
    return this.tew;
  }
  
  public b getRedDotMgr()
  {
    return this.tev;
  }
  
  public c getReporter()
  {
    return this.teu;
  }
  
  public WebView.d getWebViewType()
  {
    return this.tey;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(65446);
    this.teu = new c();
    this.tev = new b();
    this.tew = new a();
    com.tencent.mm.sdk.g.d.post(new PluginTopStory.a(this, (byte)0), "TopStory.InitTopStoryCacheFolderTask");
    preInitXWebView();
    AppMethodBeat.o(65446);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(65447);
    Object localObject;
    if (this.teu != null)
    {
      localObject = this.teu;
      ((c)localObject).teK.removeCallbacksAndMessages(null);
      ((c)localObject).teK.getLooper().quit();
      this.teu = null;
    }
    if (this.tev != null)
    {
      localObject = this.tev;
      ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", ((b)localObject).teE);
      com.tencent.mm.sdk.b.a.ymk.d(((b)localObject).teI);
      this.tev = null;
    }
    if (this.tew != null)
    {
      this.tew.teA.clear();
      this.tew = null;
    }
    AppMethodBeat.o(65447);
  }
  
  public void onVideoListUICreate() {}
  
  public void onVideoListUIDestroy(ckw paramckw) {}
  
  public void onVideoListUIPause() {}
  
  public void onVideoListUIResume() {}
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.PluginTopStory
 * JD-Core Version:    0.7.0.1
 */