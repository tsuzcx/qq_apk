package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.base.p;

final class NoteEditorUI$12
  implements DialogInterface.OnCancelListener
{
  NoteEditorUI$12(NoteEditorUI paramNoteEditorUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (NoteEditorUI.c(this.rLT) != null)
    {
      NoteEditorUI.c(this.rLT).dismiss();
      NoteEditorUI.a(this.rLT, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.12
 * JD-Core Version:    0.7.0.1
 */