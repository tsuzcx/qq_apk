package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class NoteEditorUI$9
  implements Runnable
{
  NoteEditorUI$9(NoteEditorUI paramNoteEditorUI, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(27004);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.vCA.size())
    {
      String str = (String)this.vCA.get(i);
      com.tencent.mm.plugin.wenote.model.a.f localf = new com.tencent.mm.plugin.wenote.model.a.f();
      localf.vxs = true;
      localf.type = 2;
      localf.vxr = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().dit();
      localf.mBq = com.tencent.mm.plugin.wenote.model.f.ajF(localf.toString());
      NoteEditorUI.a(this.vCx, new aca());
      NoteEditorUI.ae(this.vCx).anD(localf.mBq);
      localf.vxt = com.tencent.mm.plugin.wenote.b.c.hI(str, com.tencent.mm.plugin.wenote.model.f.o(NoteEditorUI.ae(this.vCx)));
      localf.cBD = com.tencent.mm.plugin.wenote.b.c.hJ(localf.vxt, com.tencent.mm.plugin.wenote.model.f.c(NoteEditorUI.ae(this.vCx)));
      localArrayList.add(localf);
      i += 1;
    }
    if ((NoteEditorUI.ac(this.vCx) != null) && (NoteEditorUI.ac(this.vCx).isShowing()))
    {
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a(localArrayList, NoteEditorUI.j(this.vCx).diX(), true, false, true, false);
      this.vCx.h(true, 100L);
      this.vCx.aj(1, 0L);
      AppMethodBeat.o(27004);
      return;
    }
    ab.i("MicroMsg.Note.NoteEditorUI", "user canceled");
    AppMethodBeat.o(27004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.9
 * JD-Core Version:    0.7.0.1
 */