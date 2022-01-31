package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.image2video.StoryFakeVideoPlayView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class EditorView$c$a
  implements Runnable
{
  EditorView$c$a(EditorView.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(151232);
    Object localObject = this.sQk.sQi.getTipDialog();
    if (localObject != null) {
      ((p)localObject).hide();
    }
    localObject = EditorView.u(this.sQk.sQi);
    if (localObject != null) {
      ((a)localObject).invoke();
    }
    EditorView.v(this.sQk.sQi).setAlpha(1.0F);
    ab.i(EditorView.b(this.sQk.sQi), "setup fakeVideoPlayView onPrepared");
    AppMethodBeat.o(151232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorView.c.a
 * JD-Core Version:    0.7.0.1
 */