package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hf;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

final class NoteEditorUI$34
  extends IListener<hf>
{
  NoteEditorUI$34(NoteEditorUI paramNoteEditorUI)
  {
    AppMethodBeat.i(179747);
    this.__eventId = hf.class.getName().hashCode();
    AppMethodBeat.o(179747);
  }
  
  private boolean hea()
  {
    AppMethodBeat.i(179748);
    Log.i("MicroMsg.Note.NoteEditorUI", "FavNoteSaveEvent, isFinish:%s", new Object[] { Boolean.valueOf(NoteEditorUI.am(this.QJv)) });
    this.QJv.goBack();
    if (!NoteEditorUI.am(this.QJv)) {
      this.QJv.finish();
    }
    AppMethodBeat.o(179748);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.34
 * JD-Core Version:    0.7.0.1
 */