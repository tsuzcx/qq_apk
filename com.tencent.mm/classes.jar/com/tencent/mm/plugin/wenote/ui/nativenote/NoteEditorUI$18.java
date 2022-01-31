package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

final class NoteEditorUI$18
  implements Runnable
{
  NoteEditorUI$18(NoteEditorUI paramNoteEditorUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(27014);
    WXRTEditText localWXRTEditText = NoteEditorUI.j(this.vCx).diT();
    if (localWXRTEditText != null) {
      localWXRTEditText.clearFocus();
    }
    AppMethodBeat.o(27014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.18
 * JD-Core Version:    0.7.0.1
 */