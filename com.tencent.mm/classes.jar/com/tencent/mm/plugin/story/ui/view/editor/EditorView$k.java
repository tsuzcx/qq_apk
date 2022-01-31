package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/editor/EditorView$videoCallBack$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
public final class EditorView$k
  implements e.a
{
  public final void Es()
  {
    double d = 0.0D;
    AppMethodBeat.i(110593);
    if (EditorView.x(this.sQi) >= 0.0D) {
      d = EditorView.x(this.sQi);
    }
    ab.i(EditorView.b(this.sQi), "onCompletion, seekTo startTime: " + EditorView.x(this.sQi));
    EditorView.w(this.sQi).e(d * 1000.0D, true);
    this.sQi.getPresenter();
    AppMethodBeat.o(110593);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    double d = 0.0D;
    AppMethodBeat.i(110594);
    if ((EditorView.y(this.sQi) > 0.0D) && (paramInt1 >= EditorView.y(this.sQi) * 1000.0D))
    {
      if (EditorView.x(this.sQi) >= 0.0D) {
        d = EditorView.x(this.sQi);
      }
      ab.i(EditorView.b(this.sQi), "onPlayTime, reach loop endtime:" + EditorView.y(this.sQi) + ", startTime:" + d);
      EditorView.w(this.sQi).e(d * 1000.0D, true);
    }
    AppMethodBeat.o(110594);
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public final void mG()
  {
    AppMethodBeat.i(110592);
    EditorView.w(this.sQi).setOneTimeVideoTextureUpdateCallback((e.e)new EditorView.k.a(this));
    if (EditorView.x(this.sQi) >= 0.0D) {}
    for (double d = EditorView.x(this.sQi);; d = 0.0D)
    {
      ab.i(EditorView.b(this.sQi), "onPrepared, startTime:".concat(String.valueOf(d)));
      if (d <= 0.0D) {
        break;
      }
      EditorView.w(this.sQi).e(d * 1000.0D, true);
      AppMethodBeat.o(110592);
      return;
    }
    EditorView.w(this.sQi).start();
    AppMethodBeat.o(110592);
  }
  
  public final void onError(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorView.k
 * JD-Core Version:    0.7.0.1
 */