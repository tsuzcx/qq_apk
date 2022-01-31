package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class NoteEditorUI$28
  implements DialogInterface.OnClickListener
{
  NoteEditorUI$28(NoteEditorUI paramNoteEditorUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.rLT.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.28
 * JD-Core Version:    0.7.0.1
 */