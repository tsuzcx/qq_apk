package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

final class NoteEditorUI$18
  implements Runnable
{
  NoteEditorUI$18(NoteEditorUI paramNoteEditorUI) {}
  
  public final void run()
  {
    WXRTEditText localWXRTEditText = NoteEditorUI.j(this.rLT).ciC();
    if (localWXRTEditText != null) {
      localWXRTEditText.clearFocus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.18
 * JD-Core Version:    0.7.0.1
 */