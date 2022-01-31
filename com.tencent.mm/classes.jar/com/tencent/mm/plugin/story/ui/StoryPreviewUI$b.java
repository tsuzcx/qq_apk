package com.tencent.mm.plugin.story.ui;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
public final class StoryPreviewUI$b
  implements e.a
{
  public final void Es()
  {
    AppMethodBeat.i(110035);
    StoryPreviewUI.a(this.sHK).e(0.0D, true);
    AppMethodBeat.o(110035);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public final void mG()
  {
    AppMethodBeat.i(110034);
    StoryPreviewUI.a(this.sHK).setOneTimeVideoTextureUpdateCallback((e.e)new StoryPreviewUI.b.a(this));
    StoryPreviewUI.a(this.sHK).start();
    AppMethodBeat.o(110034);
  }
  
  public final void onError(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryPreviewUI.b
 * JD-Core Version:    0.7.0.1
 */