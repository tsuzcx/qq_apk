package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;

final class NoteEditorUI$23$2$3
  implements DialogInterface.OnClickListener
{
  NoteEditorUI$23$2$3(NoteEditorUI.23.2 param2) {}
  
  public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = h.b(this.rMb.rMa.rLT.mController.uMN, this.rMb.rMa.rLT.getString(R.l.app_delete_tips), false, null);
    NoteEditorUI.j(this.rMb.rMa.rLT).ciF();
    gf localgf = new gf();
    localgf.bNF.type = 12;
    localgf.bNF.bIr = NoteEditorUI.h(this.rMb.rMa.rLT);
    localgf.bNF.bNK = new Runnable()
    {
      public final void run()
      {
        NoteEditorUI.l(NoteEditorUI.23.2.3.this.rMb.rMa.rLT).jYQ = true;
        paramDialogInterface.dismiss();
        y.d("MicroMsg.Note.NoteEditorUI", "do del, local id %d", new Object[] { Long.valueOf(NoteEditorUI.h(NoteEditorUI.23.2.3.this.rMb.rMa.rLT)) });
        NoteEditorUI.23.2.3.this.rMb.rMa.rLT.finish();
      }
    };
    a.udP.m(localgf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2.3
 * JD-Core Version:    0.7.0.1
 */