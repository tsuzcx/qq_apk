package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.widget.snackbar.b;

final class NoteEditorUI$18
  implements Runnable
{
  NoteEditorUI$18(NoteEditorUI paramNoteEditorUI, Dialog paramDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(275181);
    this.Afz.dismiss();
    b.u(this.XCU, this.XCU.getString(R.l.finish_sent));
    AppMethodBeat.o(275181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.18
 * JD-Core Version:    0.7.0.1
 */