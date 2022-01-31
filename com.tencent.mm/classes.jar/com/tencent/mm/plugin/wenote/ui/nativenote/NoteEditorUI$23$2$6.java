package com.tencent.mm.plugin.wenote.ui.nativenote;

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
    NoteEditorUI.j(this.rMb.rMa.rLT).ciF();
    a locala = new a();
    locala.rGn = false;
    locala.rGt = false;
    c.chX().a(locala);
    int i = NoteEditorUI.j(this.rMb.rMa.rLT).rJg;
    NoteEditorUI.j(this.rMb.rMa.rLT).rJg = 3;
    h.Di(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2.6
 * JD-Core Version:    0.7.0.1
 */