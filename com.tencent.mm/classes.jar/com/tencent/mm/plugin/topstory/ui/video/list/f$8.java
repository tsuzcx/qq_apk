package com.tencent.mm.plugin.topstory.ui.video.list;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class f$8
  implements b
{
  f$8(f paramf) {}
  
  public final void aFf()
  {
    AppMethodBeat.i(2050);
    ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekPre");
    f.g(this.tlr).baj();
    AppMethodBeat.o(2050);
  }
  
  public final void on(int paramInt)
  {
    AppMethodBeat.i(2051);
    ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "onSeekTo %d", new Object[] { Integer.valueOf(paramInt) });
    this.tlr.seekTo(paramInt);
    f.g(this.tlr).aFn();
    a.kS(22);
    AppMethodBeat.o(2051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f.8
 * JD-Core Version:    0.7.0.1
 */