package com.tencent.mm.plugin.story.image2video;

import a.l;
import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-story_release"})
public final class StoryFakeVideoPlayView$e
  implements TextureView.SurfaceTextureListener
{
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151031);
    StoryFakeVideoPlayView.a(this.stF, new c(paramSurfaceTexture, StoryFakeVideoPlayView.c(this.stF)));
    StoryFakeVideoPlayView.d(this.stF).start();
    StoryFakeVideoPlayView.d(this.stF).cR(paramInt1, paramInt2);
    StoryFakeVideoPlayView.d(this.stF).FD(d.ssU);
    StoryFakeVideoPlayView.a(this.stF, true);
    paramSurfaceTexture = StoryFakeVideoPlayView.stA;
    ab.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureAvailable");
    AppMethodBeat.o(151031);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(151030);
    paramSurfaceTexture = StoryFakeVideoPlayView.stA;
    ab.i(StoryFakeVideoPlayView.access$getTAG$cp(), "onSurfaceTextureDestroyed");
    StoryFakeVideoPlayView.a(this.stF, false);
    StoryFakeVideoPlayView.d(this.stF).stop();
    AppMethodBeat.o(151030);
    return true;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.image2video.StoryFakeVideoPlayView.e
 * JD-Core Version:    0.7.0.1
 */