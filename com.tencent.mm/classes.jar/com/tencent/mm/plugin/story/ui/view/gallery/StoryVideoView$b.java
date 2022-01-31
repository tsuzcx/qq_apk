package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/gallery/StoryVideoView$playLocalVideo$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
public final class StoryVideoView$b
  implements e.a
{
  public final void Es()
  {
    AppMethodBeat.i(110911);
    String str = StoryVideoView.a(this.sVf);
    StringBuilder localStringBuilder = new StringBuilder("localVideo onCompleted, isFakeVideo:");
    Object localObject = StoryVideoView.c(this.sVf);
    if (localObject != null)
    {
      localObject = Boolean.valueOf(((i)localObject).cBM());
      ab.i(str, localObject + ", fakeStartTime:" + StoryVideoView.d(this.sVf));
      localObject = StoryVideoView.c(this.sVf);
      if ((localObject == null) || (((i)localObject).cBM() != true) || (StoryVideoView.d(this.sVf) <= 0L)) {
        break label166;
      }
      StoryVideoView.f(this.sVf).e(StoryVideoView.d(this.sVf), true);
    }
    for (;;)
    {
      localObject = StoryVideoView.i(this.sVf);
      if (localObject == null) {
        break label183;
      }
      ((h.b)localObject).cr(this.sVf.getSessionId(), StoryVideoView.j(this.sVf));
      AppMethodBeat.o(110911);
      return;
      localObject = null;
      break;
      label166:
      StoryVideoView.f(this.sVf).e(0.0D, true);
    }
    label183:
    AppMethodBeat.o(110911);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110912);
    i locali = StoryVideoView.c(this.sVf);
    if ((locali != null) && (locali.cBM() == true) && (StoryVideoView.e(this.sVf) > 0L) && (paramInt1 >= StoryVideoView.e(this.sVf)))
    {
      ab.i(StoryVideoView.a(this.sVf), "fakeVideo exceed endTime, playTime:" + paramInt1 + ", fakeEndTime:" + StoryVideoView.e(this.sVf) + ", fakeStartTime:" + StoryVideoView.d(this.sVf));
      if (StoryVideoView.d(this.sVf) <= 0L) {
        break label146;
      }
      StoryVideoView.f(this.sVf).e(StoryVideoView.d(this.sVf), true);
    }
    for (;;)
    {
      AppMethodBeat.o(110912);
      return 0;
      label146:
      StoryVideoView.f(this.sVf).e(0.0D, true);
    }
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public final void mG()
  {
    AppMethodBeat.i(110910);
    String str = StoryVideoView.a(this.sVf);
    StringBuilder localStringBuilder = new StringBuilder("localVideo onPrepared, isLocalVideoPause:").append(StoryVideoView.b(this.sVf)).append(", isFakeVideo:");
    Object localObject = StoryVideoView.c(this.sVf);
    if (localObject != null)
    {
      localObject = Boolean.valueOf(((i)localObject).cBM());
      ab.i(str, localObject + ", fakeStartTime:" + StoryVideoView.d(this.sVf) + ", fakeEndTime:" + StoryVideoView.e(this.sVf));
      if (!StoryVideoView.b(this.sVf))
      {
        localObject = StoryVideoView.c(this.sVf);
        if ((localObject == null) || (((i)localObject).cBM() != true) || (StoryVideoView.d(this.sVf) <= 0L)) {
          break label197;
        }
        StoryVideoView.f(this.sVf).e(StoryVideoView.d(this.sVf), true);
      }
    }
    for (;;)
    {
      StoryVideoView.f(this.sVf).setOneTimeVideoTextureUpdateCallback((e.e)new a(this));
      AppMethodBeat.o(110910);
      return;
      localObject = null;
      break;
      label197:
      StoryVideoView.f(this.sVf).start();
    }
  }
  
  public final void onError(int paramInt1, int paramInt2) {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "onTextureUpdate"})
  static final class a
    implements e.e
  {
    a(StoryVideoView.b paramb) {}
    
    public final void bSk()
    {
      AppMethodBeat.i(110909);
      this.sVg.sVf.setFirstPlayWaitTime(bo.av(StoryVideoView.g(this.sVg.sVf)));
      al.p((Runnable)new StoryVideoView.b.a.1(this), 50L);
      AppMethodBeat.o(110909);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView.b
 * JD-Core Version:    0.7.0.1
 */