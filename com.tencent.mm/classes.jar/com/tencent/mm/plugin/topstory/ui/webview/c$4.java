package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

final class c$4
  implements Runnable
{
  c$4(c paramc, cyh paramcyh, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(2151);
    ckp localckp = new ckp();
    localckp.Category = this.tmc.yfq.Category;
    localckp.xUA = System.currentTimeMillis();
    localckp.xFw = this.tmc.yfq.xFw;
    localckp.xUB = this.tmc.yfq.xFx;
    localckp.ntu = this.ihj;
    localckp.xFy = this.tmc.yfq.xFy;
    ((PluginTopStoryUI)com.tencent.mm.kernel.g.G(PluginTopStoryUI.class)).getWebViewMgr().thE.put(Integer.valueOf(localckp.Category), localckp);
    try
    {
      byte[] arrayOfByte = localckp.toByteArray();
      File localFile = new File(com.tencent.mm.plugin.topstory.a.g.cIx());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      e.b(com.tencent.mm.plugin.topstory.a.g.cIx() + localckp.Category, arrayOfByte, arrayOfByte.length);
      ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putHomeDataCache write data key: %d length: %d", new Object[] { Integer.valueOf(localckp.Category), Integer.valueOf(arrayOfByte.length) });
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localIOException, "putHomeDataCache ", new Object[0]);
      }
    }
    ((PluginTopStoryUI)com.tencent.mm.kernel.g.G(PluginTopStoryUI.class)).getWebViewMgr().bp(localckp.Category, "");
    AppMethodBeat.o(2151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.c.4
 * JD-Core Version:    0.7.0.1
 */