package com.tencent.mm.plugin.topstory.ui;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.xweb.WebView.c;

final class PluginTopStoryUI$3
  implements Runnable
{
  PluginTopStoryUI$3(PluginTopStoryUI paramPluginTopStoryUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(125856);
    long l;
    if ((PluginTopStoryUI.access$100(this.BJl) == 2) && (((PluginTopStory)g.ad(PluginTopStory.class)).getWebViewType() == WebView.c.MNA))
    {
      String str = Build.BRAND;
      int i;
      if (!bu.isNullOrNil(str))
      {
        str = str.toLowerCase();
        if ((str.contains("huawei")) || (str.contains("honor"))) {
          i = 0;
        }
      }
      while (i != 0)
      {
        i = ((a)g.ab(a.class)).acL().getInt("TopStoryWebViewPreInit", 1);
        if (i == 0)
        {
          ae.i("MicroMsg.TopStory.PluginTopStoryUI", "MXM_DynaCfg_AV_Item_Key_TopStory_WebViewPreInit is %d", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(125856);
          return;
          i = 1;
        }
        else
        {
          PluginTopStoryUI.access$102(this.BJl, 1);
          l = System.currentTimeMillis();
        }
      }
    }
    try
    {
      new TopStoryWebView(ak.getContext()).destroy();
      label158:
      am.WT(26);
      ae.i("MicroMsg.TopStory.PluginTopStoryUI", "Create TopStoryWebView Use Time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(125856);
      return;
    }
    catch (Exception localException)
    {
      break label158;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI.3
 * JD-Core Version:    0.7.0.1
 */