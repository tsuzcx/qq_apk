package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class NoteEditorUI$27
  implements DialogInterface.OnClickListener
{
  NoteEditorUI$27(NoteEditorUI paramNoteEditorUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.rLT.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.27
 * JD-Core Version:    0.7.0.1
 */