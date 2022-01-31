package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NoteEditorUI$25
  implements Runnable
{
  NoteEditorUI$25(NoteEditorUI paramNoteEditorUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(27033);
    if (NoteEditorUI.ac(this.vCx) != null)
    {
      NoteEditorUI.ac(this.vCx).dismiss();
      NoteEditorUI.ad(this.vCx);
    }
    AppMethodBeat.o(27033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.25
 * JD-Core Version:    0.7.0.1
 */