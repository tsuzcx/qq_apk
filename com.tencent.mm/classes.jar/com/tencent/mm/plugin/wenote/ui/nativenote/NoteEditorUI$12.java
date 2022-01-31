package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class NoteEditorUI$12
  implements DialogInterface.OnCancelListener
{
  NoteEditorUI$12(NoteEditorUI paramNoteEditorUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(27007);
    if (NoteEditorUI.c(this.vCx) != null)
    {
      NoteEditorUI.c(this.vCx).dismiss();
      NoteEditorUI.a(this.vCx, null);
    }
    AppMethodBeat.o(27007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.12
 * JD-Core Version:    0.7.0.1
 */