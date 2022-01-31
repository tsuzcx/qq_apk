package com.tencent.mm.plugin.topstory.ui;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView.d;

final class PluginTopStoryUI$3
  implements Runnable
{
  PluginTopStoryUI$3(PluginTopStoryUI paramPluginTopStoryUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(1520);
    long l;
    if ((PluginTopStoryUI.access$100(this.tfz) == 2) && (((PluginTopStory)g.G(PluginTopStory.class)).getWebViewType() == WebView.d.BEs))
    {
      String str = Build.BRAND;
      int i;
      if (!bo.isNullOrNil(str))
      {
        str = str.toLowerCase();
        if ((str.contains("huawei")) || (str.contains("honor"))) {
          i = 0;
        }
      }
      while (i != 0)
      {
        i = ((a)g.E(a.class)).Nq().getInt("TopStoryWebViewPreInit", 1);
        if (i == 0)
        {
          ab.i("MicroMsg.TopStory.PluginTopStoryUI", "MXM_DynaCfg_AV_Item_Key_TopStory_WebViewPreInit is %d", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(1520);
          return;
          i = 1;
        }
        else
        {
          PluginTopStoryUI.access$102(this.tfz, 1);
          l = System.currentTimeMillis();
        }
      }
    }
    try
    {
      new TopStoryWebView(ah.getContext()).destroy();
      label160:
      an.Jw(26);
      ab.i("MicroMsg.TopStory.PluginTopStoryUI", "Create TopStoryWebView Use Time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(1520);
      return;
    }
    catch (Exception localException)
    {
      break label160;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI.3
 * JD-Core Version:    0.7.0.1
 */