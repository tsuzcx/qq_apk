package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;

final class NoteEditorUI$14
  implements Runnable
{
  NoteEditorUI$14(NoteEditorUI paramNoteEditorUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(30704);
    Toast.makeText(this.QJv, this.QJv.getString(R.l.share_ok), 0).show();
    AppMethodBeat.o(30704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.14
 * JD-Core Version:    0.7.0.1
 */