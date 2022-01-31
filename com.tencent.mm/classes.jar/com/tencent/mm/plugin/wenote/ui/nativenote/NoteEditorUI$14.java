package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.ProgressDialog;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.d.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;

final class NoteEditorUI$14
  implements d.a
{
  NoteEditorUI$14(NoteEditorUI paramNoteEditorUI) {}
  
  public final void a(String paramString, com.tencent.mm.plugin.wenote.model.a.k paramk)
  {
    y.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onImportFinish");
    if ((!bk.bl(paramString)) && (e.bK(paramString)) && (paramk != null)) {
      paramk.thumbPath = paramString;
    }
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.wenote.model.a.k paramk)
  {
    y.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onExportFinish");
    if (NoteEditorUI.ac(this.rLT) != null)
    {
      NoteEditorUI.ac(this.rLT).dismiss();
      NoteEditorUI.ad(this.rLT);
    }
    if ((!bk.bl(paramString)) && (e.bK(paramString)) && (paramk != null) && (!paramk.rGA)) {
      if (new b(paramString).length() < NoteEditorUI.cjq())
      {
        paramk.bTY = paramString;
        c.chX().a(paramk, NoteEditorUI.j(this.rLT).ciG(), false, true, false);
      }
    }
    for (;;)
    {
      this.rLT.f(true, 100L);
      this.rLT.U(1, 0L);
      return;
      Toast.makeText(this.rLT.mController.uMN, this.rLT.getString(R.l.favorite_too_large), 1).show();
      continue;
      y.i("MicroMsg.Note.NoteEditorUI", "file not exist or user canceled");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.14
 * JD-Core Version:    0.7.0.1
 */