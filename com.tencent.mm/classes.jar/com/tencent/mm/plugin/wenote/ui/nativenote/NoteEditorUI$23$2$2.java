package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.h.a.gf;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class NoteEditorUI$23$2$2
  implements Runnable
{
  NoteEditorUI$23$2$2(NoteEditorUI.23.2 param2) {}
  
  public final void run()
  {
    NoteEditorUI localNoteEditorUI = this.rMb.rMa.rLT;
    Object localObject = c.chX().cie();
    if (NoteEditorUI.UI((String)localObject))
    {
      localObject = new gf();
      ((gf)localObject).bNF.type = 12;
      ((gf)localObject).bNF.bIr = localNoteEditorUI.enp;
      a.udP.m((b)localObject);
      if (NoteEditorUI.c(this.rMb.rMa.rLT) != null) {}
    }
    else
    {
      if ((localNoteEditorUI.rFK) || (localNoteEditorUI.rFs))
      {
        y.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do savewnnotefavitem");
        localNoteEditorUI.f((String)localObject, true, true);
      }
      for (;;)
      {
        localNoteEditorUI.rLJ = true;
        break;
        if (localNoteEditorUI.rLp)
        {
          y.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do updateWNNoteFavitem");
          localNoteEditorUI.f((String)localObject, false, true);
        }
      }
    }
    ai.d(new NoteEditorUI.23.2.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2.2
 * JD-Core Version:    0.7.0.1
 */