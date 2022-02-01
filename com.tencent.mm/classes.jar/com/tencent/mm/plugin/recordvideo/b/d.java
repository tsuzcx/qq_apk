package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/config/EditorConfig;", "", "()V", "autoDisplayMusicPanel", "", "getAutoDisplayMusicPanel", "()Z", "setAutoDisplayMusicPanel", "(Z)V", "autoPlayAudio", "getAutoPlayAudio", "setAutoPlayAudio", "muteOrigin", "getMuteOrigin", "setMuteOrigin", "scene", "Lcom/tencent/mm/plugin/recordvideo/config/VideoMusicBussId;", "getScene", "()Lcom/tencent/mm/plugin/recordvideo/config/VideoMusicBussId;", "setScene", "(Lcom/tencent/mm/plugin/recordvideo/config/VideoMusicBussId;)V", "showLyrics", "getShowLyrics", "setShowLyrics", "showMuteOrigin", "getShowMuteOrigin", "setShowMuteOrigin", "enableAutoPlayAudio", "enableLyrics", "enableMuteOrigin", "plugin-recordvideo_release"})
public final class d
{
  public boolean BNa;
  public boolean BNb;
  public boolean BNc;
  public boolean BNd = true;
  public boolean BNe;
  public i BNf = i.BNy;
  
  public final d a(i parami)
  {
    AppMethodBeat.i(75369);
    p.h(parami, "scene");
    this.BNf = parami;
    AppMethodBeat.o(75369);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.d
 * JD-Core Version:    0.7.0.1
 */