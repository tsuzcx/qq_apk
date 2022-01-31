package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.plugin.wenote.ui.nativenote.a.c;
import com.tencent.mm.sdk.platformtools.y;

final class NoteEditorUI$2
  implements Runnable
{
  NoteEditorUI$2(NoteEditorUI paramNoteEditorUI, int paramInt) {}
  
  public final void run()
  {
    y.i("MicroMsg.Note.NoteEditorUI", "huahuastart: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(this.kX) });
    NoteEditorUI.S(this.rLT).bL(this.kX);
    y.i("MicroMsg.Note.NoteEditorUI", "huahuaend: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(this.kX) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.2
 * JD-Core Version:    0.7.0.1
 */