package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.ProgressDialog;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;

final class NoteEditorUI$14
  implements d.a
{
  NoteEditorUI$14(NoteEditorUI paramNoteEditorUI) {}
  
  public final void a(String paramString, com.tencent.mm.plugin.wenote.model.a.k paramk)
  {
    AppMethodBeat.i(27009);
    ab.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onImportFinish");
    if ((!bo.isNullOrNil(paramString)) && (e.cN(paramString)) && (paramk != null)) {
      paramk.thumbPath = paramString;
    }
    AppMethodBeat.o(27009);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.wenote.model.a.k paramk)
  {
    AppMethodBeat.i(27010);
    ab.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onExportFinish");
    if (NoteEditorUI.ac(this.vCx) != null)
    {
      NoteEditorUI.ac(this.vCx).dismiss();
      NoteEditorUI.ad(this.vCx);
    }
    if ((!bo.isNullOrNil(paramString)) && (e.cN(paramString)) && (paramk != null) && (!paramk.vxj)) {
      if (new b(paramString).length() < NoteEditorUI.djS())
      {
        paramk.cBD = paramString;
        c.din().a(paramk, NoteEditorUI.j(this.vCx).diX(), false, true, false);
      }
    }
    for (;;)
    {
      this.vCx.h(true, 100L);
      this.vCx.aj(1, 0L);
      AppMethodBeat.o(27010);
      return;
      Toast.makeText(this.vCx.getContext(), this.vCx.getString(2131299848), 1).show();
      continue;
      ab.i("MicroMsg.Note.NoteEditorUI", "file not exist or user canceled");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.14
 * JD-Core Version:    0.7.0.1
 */