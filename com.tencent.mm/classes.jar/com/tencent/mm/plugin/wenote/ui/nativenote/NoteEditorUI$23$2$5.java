package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class NoteEditorUI$23$2$5
  implements DialogInterface.OnCancelListener
{
  NoteEditorUI$23$2$5(NoteEditorUI.23.2 param2) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(27026);
    if (NoteEditorUI.c(this.vCF.vCE.vCx) != null)
    {
      NoteEditorUI.c(this.vCF.vCE.vCx).dismiss();
      NoteEditorUI.a(this.vCF.vCE.vCx, null);
    }
    AppMethodBeat.o(27026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2.5
 * JD-Core Version:    0.7.0.1
 */