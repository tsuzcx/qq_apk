package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class NoteEditorUI$20
  implements Runnable
{
  NoteEditorUI$20(NoteEditorUI paramNoteEditorUI, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(27016);
    if ((this.vCD) && (!NoteEditorUI.O(this.vCx)))
    {
      this.vCx.showVKB();
      AppMethodBeat.o(27016);
      return;
    }
    if ((!this.vCD) && (NoteEditorUI.O(this.vCx))) {
      this.vCx.hideVKB();
    }
    AppMethodBeat.o(27016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.20
 * JD-Core Version:    0.7.0.1
 */