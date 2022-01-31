package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.ProgressDialog;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class NoteEditorUI$9
  implements Runnable
{
  NoteEditorUI$9(NoteEditorUI paramNoteEditorUI, ArrayList paramArrayList) {}
  
  public final void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.rLW.size())
    {
      String str = (String)this.rLW.get(i);
      com.tencent.mm.plugin.wenote.model.a.f localf = new com.tencent.mm.plugin.wenote.model.a.f();
      localf.rGJ = true;
      localf.type = 2;
      localf.rGI = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cid();
      localf.kgC = com.tencent.mm.plugin.wenote.model.f.Ur(localf.toString());
      NoteEditorUI.a(this.rLT, new xv());
      NoteEditorUI.ae(this.rLT).XH(localf.kgC);
      localf.rGK = com.tencent.mm.plugin.wenote.b.c.fH(str, com.tencent.mm.plugin.wenote.model.f.o(NoteEditorUI.ae(this.rLT)));
      localf.bTY = com.tencent.mm.plugin.wenote.b.c.fI(localf.rGK, com.tencent.mm.plugin.wenote.model.f.c(NoteEditorUI.ae(this.rLT)));
      localArrayList.add(localf);
      i += 1;
    }
    if ((NoteEditorUI.ac(this.rLT) != null) && (NoteEditorUI.ac(this.rLT).isShowing()))
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().a(localArrayList, NoteEditorUI.j(this.rLT).ciG(), true, false, true, false);
      this.rLT.f(true, 100L);
      this.rLT.U(1, 0L);
      return;
    }
    y.i("MicroMsg.Note.NoteEditorUI", "user canceled");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.9
 * JD-Core Version:    0.7.0.1
 */