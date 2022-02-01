package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPlayTextureView;", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handleOnSurfaceTextureUpdated", "", "surface", "Landroid/graphics/SurfaceTexture;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "seekTo", "time", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryVideoPlayTextureView
  extends VideoPlayerTextureView
{
  public StoryVideoPlayTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(120530);
    setScaleType(i.e.XYN);
    AppMethodBeat.o(120530);
  }
  
  public StoryVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(120531);
    setScaleType(i.e.XYN);
    AppMethodBeat.o(120531);
  }
  
  public StoryVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120532);
    setScaleType(i.e.XYN);
    AppMethodBeat.o(120532);
  }
  
  public final void H(double paramDouble)
  {
    AppMethodBeat.i(120528);
    if (this.hS)
    {
      super.H(paramDouble);
      AppMethodBeat.o(120528);
      return;
    }
    Log.printInfoStack("MicroMsg.VideoPlayerTextureView", hashCode() + " error seekTo " + this.hS + ' ', new Object[0]);
    AppMethodBeat.o(120528);
  }
  
  public final void o(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(120529);
    super.o(paramSurfaceTexture);
    this.yki.gw(getCurrentPosition(), getDuration());
    AppMethodBeat.o(120529);
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120527);
    setScaleType(i.e.XYN);
    if ((this.Yul == 90) || (this.Yul == 270)) {
      if (this.mVideoHeight > this.mVideoWidth) {
        this.vZi.a(i.e.XYK);
      }
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(120527);
      return;
      if (this.mVideoWidth > this.mVideoHeight) {
        this.vZi.a(i.e.XYK);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */