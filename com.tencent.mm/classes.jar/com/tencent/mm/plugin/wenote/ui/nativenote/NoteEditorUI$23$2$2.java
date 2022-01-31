package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class NoteEditorUI$23$2$2
  implements Runnable
{
  NoteEditorUI$23$2$2(NoteEditorUI.23.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(27022);
    NoteEditorUI localNoteEditorUI = this.vCF.vCE.vCx;
    Object localObject = c.din().div();
    if (NoteEditorUI.aka((String)localObject))
    {
      localObject = new gi();
      ((gi)localObject).cuX.type = 12;
      ((gi)localObject).cuX.cpM = localNoteEditorUI.fDL;
      a.ymk.l((b)localObject);
      if (NoteEditorUI.c(this.vCF.vCE.vCx) == null) {
        AppMethodBeat.o(27022);
      }
    }
    else
    {
      if ((localNoteEditorUI.vwt) || (localNoteEditorUI.vwb))
      {
        ab.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do savewnnotefavitem");
        localNoteEditorUI.j((String)localObject, true, true);
      }
      for (;;)
      {
        localNoteEditorUI.vCn = true;
        break;
        if (localNoteEditorUI.vBT)
        {
          ab.i("MicroMsg.Note.NoteEditorUI", "syncWNNoteFavItem noteeditorui, do updateWNNoteFavitem");
          localNoteEditorUI.j((String)localObject, false, true);
        }
      }
    }
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27021);
        NoteEditorUI.g(NoteEditorUI.23.2.2.this.vCF.vCE.vCx);
        Object localObject = new gi();
        ((gi)localObject).cuX.type = 32;
        ((gi)localObject).cuX.cpM = NoteEditorUI.h(NoteEditorUI.23.2.2.this.vCF.vCE.vCx);
        a.ymk.l((b)localObject);
        boolean bool = ((gi)localObject).cuY.cvo;
        if (((gi)localObject).cuY.ret != 0) {}
        for (int i = 1; ((gi)localObject).cuY.path == null; i = 0)
        {
          com.tencent.mm.ui.base.h.bO(NoteEditorUI.23.2.2.this.vCF.vCE.vCx.getContext(), NoteEditorUI.23.2.2.this.vCF.vCE.vCx.getString(2131299813));
          AppMethodBeat.o(27021);
          return;
        }
        if (bool)
        {
          com.tencent.mm.ui.base.h.bO(NoteEditorUI.23.2.2.this.vCF.vCE.vCx.getContext(), NoteEditorUI.23.2.2.this.vCF.vCE.vCx.getString(2131296333));
          AppMethodBeat.o(27021);
          return;
        }
        if (i != 0)
        {
          com.tencent.mm.ui.base.h.bO(NoteEditorUI.23.2.2.this.vCF.vCE.vCx.getContext(), NoteEditorUI.23.2.2.this.vCF.vCE.vCx.getString(2131296334));
          AppMethodBeat.o(27021);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("Select_Conv_Type", 3);
        ((Intent)localObject).putExtra("scene_from", 1);
        ((Intent)localObject).putExtra("mutil_select_is_ret", true);
        ((Intent)localObject).putExtra("select_fav_local_id", NoteEditorUI.h(NoteEditorUI.23.2.2.this.vCF.vCE.vCx));
        d.b(NoteEditorUI.23.2.2.this.vCF.vCE.vCx, ".ui.transmit.SelectConversationUI", (Intent)localObject, 4101);
        com.tencent.mm.plugin.fav.a.h.i(NoteEditorUI.h(NoteEditorUI.23.2.2.this.vCF.vCE.vCx), 1, 0);
        localObject = NoteEditorUI.i(NoteEditorUI.23.2.2.this.vCF.vCE.vCx);
        ((h.a)localObject).mtf += 1;
        AppMethodBeat.o(27021);
      }
    });
    AppMethodBeat.o(27022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2.2
 * JD-Core Version:    0.7.0.1
 */