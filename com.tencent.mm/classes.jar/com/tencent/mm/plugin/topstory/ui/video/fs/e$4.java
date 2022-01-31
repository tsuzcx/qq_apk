package com.tencent.mm.plugin.topstory.ui.video.fs;

import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class e$4
  implements b
{
  e$4(e parame) {}
  
  public final void akz()
  {
    y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekPre");
    e.l(this.pGX).bOy();
  }
  
  public final void lE(int paramInt)
  {
    y.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramInt) });
    this.pGX.seekTo(paramInt);
    e.l(this.pGX).akG();
    a.jdMethod_if(22);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.4
 * JD-Core Version:    0.7.0.1
 */