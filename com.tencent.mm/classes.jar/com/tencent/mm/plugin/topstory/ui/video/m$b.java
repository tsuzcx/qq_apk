package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.y;

final class m$b
  implements Runnable
{
  private String kIi;
  
  m$b(m paramm, String paramString)
  {
    this.kIi = paramString;
  }
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    e.bL(this.kIi);
    y.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoFolderTask %s %d", new Object[] { this.kIi, Long.valueOf(System.currentTimeMillis() - l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m.b
 * JD-Core Version:    0.7.0.1
 */