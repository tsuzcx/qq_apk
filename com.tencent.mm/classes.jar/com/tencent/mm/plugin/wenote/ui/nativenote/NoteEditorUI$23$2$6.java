package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.a;
import com.tencent.mm.plugin.wenote.model.h;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

final class NoteEditorUI$23$2$6
  implements Runnable
{
  NoteEditorUI$23$2$6(NoteEditorUI.23.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(27027);
    NoteEditorUI.j(this.vCF.vCE.vCx).diW();
    a locala = new a();
    locala.vwW = false;
    locala.vxc = false;
    c.din().a(locala);
    int i = NoteEditorUI.j(this.vCF.vCE.vCx).vzL;
    NoteEditorUI.j(this.vCF.vCE.vCx).vzL = 3;
    h.Lb(i);
    AppMethodBeat.o(27027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2.6
 * JD-Core Version:    0.7.0.1
 */