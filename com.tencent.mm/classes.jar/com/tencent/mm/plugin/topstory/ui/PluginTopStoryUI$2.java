package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.HashMap;

final class PluginTopStoryUI$2
  implements Runnable
{
  PluginTopStoryUI$2(PluginTopStoryUI paramPluginTopStoryUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(1519);
    d locald = PluginTopStoryUI.access$000(this.tfz);
    File localFile = new File(g.cIx());
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
          int k = bo.getInt(localFile.getName(), -1);
          ckp localckp;
          if (k > 0) {
            localckp = new ckp();
          }
          for (;;)
          {
            try
            {
              byte[] arrayOfByte = e.i(localFile.getAbsolutePath(), 0, -1);
              localckp.parseFrom(arrayOfByte);
              locald.thE.put(Integer.valueOf(k), localckp);
              ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put home data cache key:%d size:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(arrayOfByte.length) });
              i += 1;
            }
            catch (Exception localException)
            {
              ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localException, "loadHomeDataCache %s", new Object[] { localFile.getAbsoluteFile() });
              continue;
            }
            ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Decode Key Error %s", new Object[] { localFile.getAbsolutePath() });
          }
        }
      }
      else
      {
        ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Files %s", new Object[] { localFile.getAbsolutePath() });
      }
    }
    for (;;)
    {
      PluginTopStoryUI.access$000(this.tfz).cIY();
      AppMethodBeat.o(1519);
      return;
      ab.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Exist %s", new Object[] { localFile.getAbsolutePath() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI.2
 * JD-Core Version:    0.7.0.1
 */