package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.ui.widget.snackbar.a.b;

final class NoteEditorUI$18
  implements a.b
{
  NoteEditorUI$18(NoteEditorUI paramNoteEditorUI) {}
  
  public final void bPM()
  {
    AppMethodBeat.i(30709);
    hi localhi = new hi();
    localhi.fEb.type = 35;
    EventCenter.instance.publish(localhi);
    AppMethodBeat.o(30709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.18
 * JD-Core Version:    0.7.0.1
 */