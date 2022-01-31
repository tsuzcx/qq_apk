package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Dialog;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.widget.snackbar.b;

final class NoteEditorUI$7
  implements Runnable
{
  NoteEditorUI$7(NoteEditorUI paramNoteEditorUI, Dialog paramDialog) {}
  
  public final void run()
  {
    this.kbH.dismiss();
    b.h(this.rLT, this.rLT.getString(R.l.finish_sent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.7
 * JD-Core Version:    0.7.0.1
 */