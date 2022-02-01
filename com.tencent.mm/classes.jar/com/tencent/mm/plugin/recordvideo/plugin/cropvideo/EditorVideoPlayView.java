package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditorVideoPlayView;", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handleOnSurfaceTextureUpdated", "", "surface", "Landroid/graphics/SurfaceTexture;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public class EditorVideoPlayView
  extends VideoPlayerTextureView
{
  public EditorVideoPlayView(Context paramContext)
  {
    super(paramContext);
  }
  
  public EditorVideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EditorVideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void o(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(75716);
    super.o(paramSurfaceTexture);
    paramSurfaceTexture = this.yki;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.gw(getCurrentPosition(), getDuration());
    }
    AppMethodBeat.o(75716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditorVideoPlayView
 * JD-Core Version:    0.7.0.1
 */