package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

final class NoteEditorUI$23$2$3
  implements DialogInterface.OnClickListener
{
  NoteEditorUI$23$2$3(NoteEditorUI.23.2 param2) {}
  
  public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(27024);
    paramDialogInterface = h.b(this.vCF.vCE.vCx.getContext(), this.vCF.vCE.vCx.getString(2131296902), false, null);
    NoteEditorUI.j(this.vCF.vCE.vCx).diW();
    gi localgi = new gi();
    localgi.cuX.type = 12;
    localgi.cuX.cpM = NoteEditorUI.h(this.vCF.vCE.vCx);
    localgi.cuX.cvc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27023);
        NoteEditorUI.l(NoteEditorUI.23.2.3.this.vCF.vCE.vCx).mtj = true;
        paramDialogInterface.dismiss();
        ab.d("MicroMsg.Note.NoteEditorUI", "do del, local id %d", new Object[] { Long.valueOf(NoteEditorUI.h(NoteEditorUI.23.2.3.this.vCF.vCE.vCx)) });
        NoteEditorUI.23.2.3.this.vCF.vCE.vCx.finish();
        AppMethodBeat.o(27023);
      }
    };
    a.ymk.l(localgi);
    AppMethodBeat.o(27024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2.3
 * JD-Core Version:    0.7.0.1
 */