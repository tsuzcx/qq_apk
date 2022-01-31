package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NoteEditorUI$8
  implements DialogInterface.OnCancelListener
{
  NoteEditorUI$8(NoteEditorUI paramNoteEditorUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(27003);
    if (NoteEditorUI.ac(this.vCx) != null)
    {
      NoteEditorUI.ac(this.vCx).dismiss();
      NoteEditorUI.ad(this.vCx);
    }
    AppMethodBeat.o(27003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.8
 * JD-Core Version:    0.7.0.1
 */