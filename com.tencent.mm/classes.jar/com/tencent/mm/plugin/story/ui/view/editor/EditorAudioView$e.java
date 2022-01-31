package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.audio.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class EditorAudioView$e
  implements Runnable
{
  EditorAudioView$e(EditorAudioView paramEditorAudioView) {}
  
  public final void run()
  {
    AppMethodBeat.i(110519);
    if (!EditorAudioView.d(this.sOy))
    {
      a locala = EditorAudioView.a(this.sOy);
      if (locala != null)
      {
        locala.ccL();
        AppMethodBeat.o(110519);
        return;
      }
    }
    AppMethodBeat.o(110519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView.e
 * JD-Core Version:    0.7.0.1
 */