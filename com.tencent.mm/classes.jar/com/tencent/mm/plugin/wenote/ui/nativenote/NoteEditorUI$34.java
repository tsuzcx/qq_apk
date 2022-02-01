package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;

final class NoteEditorUI$34
  implements DialogInterface.OnClickListener
{
  NoteEditorUI$34(NoteEditorUI paramNoteEditorUI)
  {
    AppMethodBeat.i(179747);
    AppMethodBeat.o(179747);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(275234);
    paramDialogInterface.dismiss();
    b.lx(this.XCU.getContext());
    AppMethodBeat.o(275234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.34
 * JD-Core Version:    0.7.0.1
 */