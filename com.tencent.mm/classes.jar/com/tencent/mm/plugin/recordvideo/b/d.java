package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/config/EditorConfig;", "", "()V", "autoDisplayMusicPanel", "", "getAutoDisplayMusicPanel", "()Z", "setAutoDisplayMusicPanel", "(Z)V", "autoPlayAudio", "getAutoPlayAudio", "setAutoPlayAudio", "muteOrigin", "getMuteOrigin", "setMuteOrigin", "scene", "Lcom/tencent/mm/plugin/recordvideo/config/VideoMusicBussId;", "getScene", "()Lcom/tencent/mm/plugin/recordvideo/config/VideoMusicBussId;", "setScene", "(Lcom/tencent/mm/plugin/recordvideo/config/VideoMusicBussId;)V", "showLyrics", "getShowLyrics", "setShowLyrics", "enableAutoPlayAudio", "enableLyrics", "enableMuteOrigin", "plugin-recordvideo_release"})
public final class d
{
  public boolean xMU;
  public boolean xMV;
  public boolean xMW;
  public boolean xMX;
  public i xMY = i.xNs;
  
  public final d a(i parami)
  {
    AppMethodBeat.i(75369);
    p.h(parami, "scene");
    this.xMY = parami;
    AppMethodBeat.o(75369);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.d
 * JD-Core Version:    0.7.0.1
 */