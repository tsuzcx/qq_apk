package com.tencent.mm.plugin.mv.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.ui.uic.u;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/MusicMvMakerPreviewUI$onCreate$4", "Lcom/tencent/mm/plugin/mv/ui/uic/OnBackgroundBitmapReadyListener;", "onReady", "", "bitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvMakerPreviewUI$a
  implements u
{
  public final void au(Bitmap paramBitmap)
  {
    AppMethodBeat.i(286398);
    s.u(paramBitmap, "bitmap");
    AppMethodBeat.o(286398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvMakerPreviewUI.a
 * JD-Core Version:    0.7.0.1
 */