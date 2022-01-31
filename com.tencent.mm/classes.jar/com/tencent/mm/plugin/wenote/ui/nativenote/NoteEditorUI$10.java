package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NoteEditorUI$10
  implements DialogInterface.OnCancelListener
{
  NoteEditorUI$10(NoteEditorUI paramNoteEditorUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(27005);
    if (NoteEditorUI.ac(this.vCx) != null)
    {
      NoteEditorUI.ac(this.vCx).dismiss();
      NoteEditorUI.ad(this.vCx);
    }
    AppMethodBeat.o(27005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.10
 * JD-Core Version:    0.7.0.1
 */