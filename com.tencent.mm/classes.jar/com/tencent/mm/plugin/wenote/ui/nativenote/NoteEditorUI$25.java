package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.ProgressDialog;

final class NoteEditorUI$25
  implements Runnable
{
  NoteEditorUI$25(NoteEditorUI paramNoteEditorUI) {}
  
  public final void run()
  {
    if (NoteEditorUI.ac(this.rLT) != null)
    {
      NoteEditorUI.ac(this.rLT).dismiss();
      NoteEditorUI.ad(this.rLT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.25
 * JD-Core Version:    0.7.0.1
 */