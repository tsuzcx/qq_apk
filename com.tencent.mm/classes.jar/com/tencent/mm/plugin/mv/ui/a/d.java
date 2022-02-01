package com.tencent.mm.plugin.mv.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"buildBusinessBuffer", "", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "escape", "", "toMusicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "albumUrl", "toXml", "plugin-mv_release"})
public final class d
{
  public static final String dG(Object paramObject)
  {
    AppMethodBeat.i(257038);
    paramObject = Util.escapeStringForXml(String.valueOf(paramObject));
    p.g(paramObject, "Util.escapeStringForXml(this.toString())");
    AppMethodBeat.o(257038);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.d
 * JD-Core Version:    0.7.0.1
 */