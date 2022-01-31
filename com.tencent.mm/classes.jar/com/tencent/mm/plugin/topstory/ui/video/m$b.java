package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ab;

final class m$b
  implements Runnable
{
  private String nev;
  
  m$b(m paramm, String paramString)
  {
    this.nev = paramString;
  }
  
  public final void run()
  {
    AppMethodBeat.i(1748);
    long l = System.currentTimeMillis();
    e.cO(this.nev);
    ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoFolderTask %s %d", new Object[] { this.nev, Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(1748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m.b
 * JD-Core Version:    0.7.0.1
 */