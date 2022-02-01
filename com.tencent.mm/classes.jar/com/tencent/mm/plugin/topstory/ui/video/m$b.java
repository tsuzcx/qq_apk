package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;

final class m$b
  implements Runnable
{
  private String tLW;
  
  m$b(m paramm, String paramString)
  {
    this.tLW = paramString;
  }
  
  public final void run()
  {
    AppMethodBeat.i(126113);
    long l = System.currentTimeMillis();
    i.cZ(this.tLW, true);
    ad.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoFolderTask %s %d", new Object[] { this.tLW, Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(126113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m.b
 * JD-Core Version:    0.7.0.1
 */