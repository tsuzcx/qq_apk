package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPlayTextureView;", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handleOnSurfaceTextureUpdated", "", "surface", "Landroid/graphics/SurfaceTexture;", "seekTo", "time", "", "plugin-story_release"})
public final class StoryVideoPlayTextureView
  extends VideoPlayerTextureView
{
  public StoryVideoPlayTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(110860);
    setScaleType(h.d.vQL);
    AppMethodBeat.o(110860);
  }
  
  public StoryVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(110861);
    setScaleType(h.d.vQL);
    AppMethodBeat.o(110861);
  }
  
  public StoryVideoPlayTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110862);
    setScaleType(h.d.vQL);
    AppMethodBeat.o(110862);
  }
  
  public final void A(double paramDouble)
  {
    AppMethodBeat.i(110858);
    if (this.Pz)
    {
      super.A(paramDouble);
      AppMethodBeat.o(110858);
      return;
    }
    ab.b("MicroMsg.VideoPlayerTextureView", hashCode() + " error seekTo " + this.Pz + ' ', new Object[0]);
    AppMethodBeat.o(110858);
  }
  
  public final void j(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(110859);
    super.j(paramSurfaceTexture);
    this.lxA.dP(getCurrentPosition(), getDuration());
    AppMethodBeat.o(110859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView
 * JD-Core Version:    0.7.0.1
 */