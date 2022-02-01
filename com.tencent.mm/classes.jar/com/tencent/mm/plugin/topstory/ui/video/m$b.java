package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;

final class m$b
  implements Runnable
{
  private String HMr;
  
  m$b(m paramm, String paramString)
  {
    this.HMr = paramString;
  }
  
  public final void run()
  {
    AppMethodBeat.i(126113);
    long l = System.currentTimeMillis();
    y.ew(this.HMr, true);
    Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoFolderTask %s %d", new Object[] { this.HMr, Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(126113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m.b
 * JD-Core Version:    0.7.0.1
 */