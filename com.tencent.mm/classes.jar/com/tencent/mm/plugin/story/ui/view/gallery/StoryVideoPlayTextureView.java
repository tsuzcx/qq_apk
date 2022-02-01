package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPlayTextureView;", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handleOnSurfaceTextureUpdated", "", "surface", "Landroid/graphics/SurfaceTexture;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "seekTo", "time", "", "plugin-story_release"})
public final class StoryVideoPlayTextureView
  extends VideoPlayerTextureView
{
  public StoryVideoPlayTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(120530);
    setScaleType(h.e.DnK);
    AppMethodBeat.o(120530);
  }
  
  public StoryVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(120531);
    setScaleType(h.e.DnK);
    AppMethodBeat.o(120531);
  }
  
  public StoryVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120532);
    setScaleType(h.e.DnK);
    AppMethodBeat.o(120532);
  }
  
  public final void k(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(120529);
    super.k(paramSurfaceTexture);
    this.prg.eP(getCurrentPosition(), getDuration());
    AppMethodBeat.o(120529);
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120527);
    setScaleType(h.e.DnK);
    if ((this.DFS == 90) || (this.DFS == 270)) {
      if (this.mVideoHeight > this.mVideoWidth) {
        this.nQg.a(h.e.DnH);
      }
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(120527);
      return;
      if (this.mVideoWidth > this.mVideoHeight) {
        this.nQg.a(h.e.DnH);
      }
    }
  }
  
  public final void p(double paramDouble)
  {
    AppMethodBeat.i(120528);
    if (this.Xy)
    {
      super.p(paramDouble);
      AppMethodBeat.o(120528);
      return;
    }
    ac.m("MicroMsg.VideoPlayerTextureView", hashCode() + " error seekTo " + this.Xy + ' ', new Object[0]);
    AppMethodBeat.o(120528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */