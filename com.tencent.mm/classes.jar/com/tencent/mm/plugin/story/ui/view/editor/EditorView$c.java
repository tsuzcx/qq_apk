package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.image2video.StoryFakeVideoPlayView.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/editor/EditorView$fakeVideoPlayViewCallback$1", "Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView$Callback;", "onPrepared", "", "plugin-story_release"})
public final class EditorView$c
  implements StoryFakeVideoPlayView.a
{
  public final void mG()
  {
    AppMethodBeat.i(151233);
    this.sQi.post((Runnable)new EditorView.c.a(this));
    AppMethodBeat.o(151233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorView.c
 * JD-Core Version:    0.7.0.1
 */