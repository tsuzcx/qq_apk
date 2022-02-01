package com.tencent.mm.plugin.mv.model;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.ui.h;
import com.tencent.mm.plugin.gallery.ui.h.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$CaptureThumbData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "thumbPath", "", "videoPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "getVideoPath", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$a
  implements e.g
{
  private final String thumbPath;
  private final String videoPath;
  
  public e$a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(286147);
    this.thumbPath = paramString1;
    this.videoPath = paramString2;
    AppMethodBeat.o(286147);
  }
  
  public final void a(ImageView paramImageView, h.a parama)
  {
    AppMethodBeat.i(286153);
    s.u(paramImageView, "thumbView");
    h.a(paramImageView, 2, this.thumbPath, this.videoPath, this.videoPath.hashCode(), parama, 0L);
    AppMethodBeat.o(286153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.e.a
 * JD-Core Version:    0.7.0.1
 */