package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class NoteEditorUI$31
  implements MenuItem.OnMenuItemClickListener
{
  NoteEditorUI$31(NoteEditorUI paramNoteEditorUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (!NoteEditorUI.K(this.rLT)) {
      return true;
    }
    NoteEditorUI.L(this.rLT);
    this.rLT.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.31
 * JD-Core Version:    0.7.0.1
 */