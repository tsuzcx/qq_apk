package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class NoteEditorUI$10
  implements DialogInterface.OnCancelListener
{
  NoteEditorUI$10(NoteEditorUI paramNoteEditorUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (NoteEditorUI.ac(this.rLT) != null)
    {
      NoteEditorUI.ac(this.rLT).dismiss();
      NoteEditorUI.ad(this.rLT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.10
 * JD-Core Version:    0.7.0.1
 */