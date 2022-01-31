package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.base.p;

final class NoteEditorUI$23$2$5
  implements DialogInterface.OnCancelListener
{
  NoteEditorUI$23$2$5(NoteEditorUI.23.2 param2) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (NoteEditorUI.c(this.rMb.rMa.rLT) != null)
    {
      NoteEditorUI.c(this.rMb.rMa.rLT).dismiss();
      NoteEditorUI.a(this.rMb.rMa.rLT, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2.5
 * JD-Core Version:    0.7.0.1
 */