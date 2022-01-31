package com.tencent.mm.plugin.topstory.ui.video.fs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class e$6
  implements b
{
  e$6(e parame) {}
  
  public final void aFf()
  {
    AppMethodBeat.i(1890);
    ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekPre");
    this.tkq.tkg.baj();
    AppMethodBeat.o(1890);
  }
  
  public final void on(int paramInt)
  {
    AppMethodBeat.i(1891);
    ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramInt) });
    this.tkq.seekTo(paramInt);
    this.tkq.tkg.aFn();
    a.kS(22);
    AppMethodBeat.o(1891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.6
 * JD-Core Version:    0.7.0.1
 */