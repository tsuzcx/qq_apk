package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.protocal.c.bjj;
import com.tencent.mm.protocal.c.byc;
import com.tencent.mm.protocal.c.cks;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

final class b$1
  implements Runnable
{
  b$1(b paramb, cks paramcks, String paramString) {}
  
  public final void run()
  {
    byc localbyc = new byc();
    localbyc.tcY = this.pIk.tXZ.tcY;
    localbyc.tOf = System.currentTimeMillis();
    localbyc.tDg = this.pIk.tXZ.tDg;
    localbyc.tOg = this.pIk.tXZ.tDh;
    localbyc.kVs = this.gGB;
    localbyc.tDi = this.pIk.tXZ.tDi;
    ((PluginTopStoryUI)com.tencent.mm.kernel.g.t(PluginTopStoryUI.class)).getWebViewMgr().pEi.put(Integer.valueOf(localbyc.tcY), localbyc);
    try
    {
      byte[] arrayOfByte = localbyc.toByteArray();
      File localFile = new File(com.tencent.mm.plugin.topstory.a.g.bNe());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      e.b(com.tencent.mm.plugin.topstory.a.g.bNe() + localbyc.tcY, arrayOfByte, arrayOfByte.length);
      y.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putHomeDataCache write data key: %d length: %d", new Object[] { Integer.valueOf(localbyc.tcY), Integer.valueOf(arrayOfByte.length) });
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localIOException, "putHomeDataCache ", new Object[0]);
      }
    }
    ((PluginTopStoryUI)com.tencent.mm.kernel.g.t(PluginTopStoryUI.class)).getWebViewMgr().aL(localbyc.tcY, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.b.1
 * JD-Core Version:    0.7.0.1
 */