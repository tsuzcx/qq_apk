package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.d;

final class NoteEditorUI$15
  implements DialogInterface.OnCancelListener
{
  NoteEditorUI$15(NoteEditorUI paramNoteEditorUI, d paramd, k paramk) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.rLX;
    paramDialogInterface.isStop = true;
    paramDialogInterface.interrupt();
    this.rLY.rGA = true;
    this.rLT.f(true, 100L);
    this.rLT.U(1, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.15
 * JD-Core Version:    0.7.0.1
 */