package com.tencent.mm.plugin.mv.ui.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.thumbplayer.view.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewBgUIC$initBgVideo$1$1$1", "Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "getCurrentPosition", "", "getTotalDuration", "seekMusic", "", "position", "", "plugin-mv_release"})
public final class MusicMvPreviewBgUIC$b$a
  implements c
{
  public final void Tp(int paramInt)
  {
    AppMethodBeat.i(258922);
    k localk = k.euj();
    p.g(localk, "MusicPlayerManager.Instance()");
    localk.etW().tG(paramInt);
    AppMethodBeat.o(258922);
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(258921);
    Object localObject = k.euj();
    p.g(localObject, "MusicPlayerManager.Instance()");
    localObject = ((k)localObject).etW();
    p.g(localObject, "MusicPlayerManager.Instance().musicPlayer");
    long l = ((d)localObject).etn();
    AppMethodBeat.o(258921);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewBgUIC.b.a
 * JD-Core Version:    0.7.0.1
 */