package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;

final class NoteEditorUI$26
  implements Runnable
{
  NoteEditorUI$26(NoteEditorUI paramNoteEditorUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(30717);
    RecyclerView localRecyclerView = NoteEditorUI.S(this.JKc);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(this.vi, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$33", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/wenote/ui/nativenote/NoteEditorUI$33", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(30717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.26
 * JD-Core Version:    0.7.0.1
 */