package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.widget.snackbar.b;

final class NoteEditorUI$13
  implements Runnable
{
  NoteEditorUI$13(NoteEditorUI paramNoteEditorUI, Dialog paramDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(275188);
    this.Afz.dismiss();
    b.u(this.XCU, this.XCU.getString(R.l.finish_sent));
    AppMethodBeat.o(275188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.13
 * JD-Core Version:    0.7.0.1
 */