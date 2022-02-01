package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/config/EditorConfig;", "", "()V", "autoDisplayMusicPanel", "", "getAutoDisplayMusicPanel", "()Z", "setAutoDisplayMusicPanel", "(Z)V", "autoPlayAudio", "getAutoPlayAudio", "setAutoPlayAudio", "muteOrigin", "getMuteOrigin", "setMuteOrigin", "scene", "Lcom/tencent/mm/plugin/recordvideo/config/VideoMusicBussId;", "getScene", "()Lcom/tencent/mm/plugin/recordvideo/config/VideoMusicBussId;", "setScene", "(Lcom/tencent/mm/plugin/recordvideo/config/VideoMusicBussId;)V", "showLyrics", "getShowLyrics", "setShowLyrics", "enableAutoPlayAudio", "enableLyrics", "enableMuteOrigin", "plugin-recordvideo_release"})
public final class d
{
  public boolean wph;
  public boolean wpi;
  public boolean wpj;
  public boolean wpk;
  public i wpl = i.wpF;
  
  public final d a(i parami)
  {
    AppMethodBeat.i(75369);
    k.h(parami, "scene");
    this.wpl = parami;
    AppMethodBeat.o(75369);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.d
 * JD-Core Version:    0.7.0.1
 */