package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.HashMap;

final class c$4
  implements com.tencent.e.i.h
{
  c$4(c paramc, egb paramegb, String paramString) {}
  
  public final String getKey()
  {
    return "TopStory.CacheHomeData";
  }
  
  public final void run()
  {
    AppMethodBeat.i(126556);
    don localdon = new don();
    localdon.Category = this.BPN.IjP.Category;
    localdon.HVt = System.currentTimeMillis();
    localdon.HDj = this.BPN.IjP.HDj;
    localdon.HVu = this.BPN.IjP.HDk;
    localdon.hFS = this.BPO;
    localdon.HDl = this.BPN.IjP.HDl;
    ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getWebViewMgr().BLf.put(Integer.valueOf(localdon.Category), localdon);
    try
    {
      byte[] arrayOfByte = localdon.toByteArray();
      k localk = new k(com.tencent.mm.plugin.topstory.a.h.ess());
      if (!localk.exists()) {
        localk.mkdirs();
      }
      o.f(com.tencent.mm.plugin.topstory.a.h.ess() + localdon.Category, arrayOfByte, arrayOfByte.length);
      ae.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putHomeDataCache write data key: %d length: %d", new Object[] { Integer.valueOf(localdon.Category), Integer.valueOf(arrayOfByte.length) });
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localIOException, "putHomeDataCache ", new Object[0]);
      }
    }
    ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getWebViewMgr().cl(localdon.Category, "");
    AppMethodBeat.o(126556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.c.4
 * JD-Core Version:    0.7.0.1
 */