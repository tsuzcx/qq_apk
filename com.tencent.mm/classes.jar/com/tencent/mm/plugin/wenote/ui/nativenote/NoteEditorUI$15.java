package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.d;

final class NoteEditorUI$15
  implements DialogInterface.OnCancelListener
{
  NoteEditorUI$15(NoteEditorUI paramNoteEditorUI, d paramd, k paramk) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(27011);
    paramDialogInterface = this.vCB;
    paramDialogInterface.isStop = true;
    paramDialogInterface.interrupt();
    this.vCC.vxj = true;
    this.vCx.h(true, 100L);
    this.vCx.aj(1, 0L);
    AppMethodBeat.o(27011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.15
 * JD-Core Version:    0.7.0.1
 */