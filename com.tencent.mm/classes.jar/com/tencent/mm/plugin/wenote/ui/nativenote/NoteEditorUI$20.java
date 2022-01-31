package com.tencent.mm.plugin.wenote.ui.nativenote;

final class NoteEditorUI$20
  implements Runnable
{
  NoteEditorUI$20(NoteEditorUI paramNoteEditorUI, boolean paramBoolean) {}
  
  public final void run()
  {
    if ((this.rLZ) && (!NoteEditorUI.O(this.rLT))) {
      this.rLT.showVKB();
    }
    while ((this.rLZ) || (!NoteEditorUI.O(this.rLT))) {
      return;
    }
    this.rLT.XM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.20
 * JD-Core Version:    0.7.0.1
 */