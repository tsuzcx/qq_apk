package com.tencent.mm.plugin.mv.ui.free;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.a.b;
import com.tencent.mm.plugin.thumbplayer.view.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/free/MusicMvFreeMakerPreviewUI$onCreate$5", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "onChange", "", "index", "", "targetMedia", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvFreeMakerPreviewUI$c
  implements d
{
  public final void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(286734);
    s.u(paramb, "targetMedia");
    Log.i("MicroMsg.MusicMvFreeMakerPreviewUI", s.X("media changed: Index=", Integer.valueOf(paramInt)));
    AppMethodBeat.o(286734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.free.MusicMvFreeMakerPreviewUI.c
 * JD-Core Version:    0.7.0.1
 */