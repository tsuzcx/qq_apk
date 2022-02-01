package com.tencent.mm.plugin.mv.model;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.ui.h;
import com.tencent.mm.plugin.gallery.ui.h.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$GalleryThumbData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "mediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)V", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$f
  implements e.g
{
  private final GalleryItem.MediaItem HHB;
  
  public e$f(GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(286158);
    this.HHB = paramMediaItem;
    AppMethodBeat.o(286158);
  }
  
  public final void a(ImageView paramImageView, h.a parama)
  {
    AppMethodBeat.i(286164);
    s.u(paramImageView, "thumbView");
    h.a(paramImageView, this.HHB.getType(), this.HHB.bud(), this.HHB.Gcc, this.HHB.HHJ, parama, this.HHB.HHK);
    AppMethodBeat.o(286164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.e.f
 * JD-Core Version:    0.7.0.1
 */