package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;

final class m$b
  implements Runnable
{
  private String Cap;
  
  m$b(m paramm, String paramString)
  {
    this.Cap = paramString;
  }
  
  public final void run()
  {
    AppMethodBeat.i(126113);
    long l = System.currentTimeMillis();
    u.deleteDir(this.Cap);
    Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoFolderTask %s %d", new Object[] { this.Cap, Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(126113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m.b
 * JD-Core Version:    0.7.0.1
 */