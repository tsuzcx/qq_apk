package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.c;
import com.tencent.mm.sdk.platformtools.ab;

final class NoteEditorUI$2
  implements Runnable
{
  NoteEditorUI$2(NoteEditorUI paramNoteEditorUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(26995);
    ab.i("MicroMsg.Note.NoteEditorUI", "huahuastart: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(this.lU) });
    NoteEditorUI.S(this.vCx).bR(this.lU);
    ab.i("MicroMsg.Note.NoteEditorUI", "huahuaend: onNotifyItemChanged,position is %d", new Object[] { Integer.valueOf(this.lU) });
    AppMethodBeat.o(26995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.2
 * JD-Core Version:    0.7.0.1
 */