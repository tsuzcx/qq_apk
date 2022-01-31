package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import a.l;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditorVideoPlayView;", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handleOnSurfaceTextureUpdated", "", "surface", "Landroid/graphics/SurfaceTexture;", "plugin-recordvideo_release"})
public final class EditorVideoPlayView
  extends VideoPlayerTextureView
{
  public EditorVideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EditorVideoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void j(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(150759);
    super.j(paramSurfaceTexture);
    paramSurfaceTexture = this.lxA;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.dP(getCurrentPosition(), getDuration());
      AppMethodBeat.o(150759);
      return;
    }
    AppMethodBeat.o(150759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditorVideoPlayView
 * JD-Core Version:    0.7.0.1
 */