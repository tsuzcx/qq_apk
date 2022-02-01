package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.widget.snackbar.b;

final class NoteEditorUI$15
  implements Runnable
{
  NoteEditorUI$15(NoteEditorUI paramNoteEditorUI, Dialog paramDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(30705);
    this.wJe.dismiss();
    b.r(this.QJv, this.QJv.getString(R.l.finish_sent));
    AppMethodBeat.o(30705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.15
 * JD-Core Version:    0.7.0.1
 */