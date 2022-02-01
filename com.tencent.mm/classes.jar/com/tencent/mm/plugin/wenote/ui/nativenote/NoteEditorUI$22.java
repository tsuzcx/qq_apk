package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class NoteEditorUI$22
  implements Runnable
{
  NoteEditorUI$22(NoteEditorUI paramNoteEditorUI, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(30713);
    Log.i("MicroMsg.Note.NoteEditorUI", "onUpdateVKBVisibility 2 isVKBShow:%s", new Object[] { Boolean.valueOf(NoteEditorUI.U(this.QJv)) });
    if ((this.upl) && (!NoteEditorUI.U(this.QJv)))
    {
      this.QJv.showVKB();
      AppMethodBeat.o(30713);
      return;
    }
    if ((!this.upl) && (NoteEditorUI.U(this.QJv))) {
      this.QJv.hideVKB();
    }
    AppMethodBeat.o(30713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.22
 * JD-Core Version:    0.7.0.1
 */