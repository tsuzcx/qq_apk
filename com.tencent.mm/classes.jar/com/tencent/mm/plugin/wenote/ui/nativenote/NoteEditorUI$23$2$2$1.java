package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class NoteEditorUI$23$2$2$1
  implements Runnable
{
  NoteEditorUI$23$2$2$1(NoteEditorUI.23.2.2 param2) {}
  
  public final void run()
  {
    NoteEditorUI.g(this.rMc.rMb.rMa.rLT);
    Object localObject = new gf();
    ((gf)localObject).bNF.type = 32;
    ((gf)localObject).bNF.bIr = NoteEditorUI.h(this.rMc.rMb.rMa.rLT);
    a.udP.m((b)localObject);
    boolean bool = ((gf)localObject).bNG.bNW;
    if (((gf)localObject).bNG.ret != 0) {}
    for (int i = 1; ((gf)localObject).bNG.path == null; i = 0)
    {
      com.tencent.mm.ui.base.h.bC(this.rMc.rMb.rMa.rLT.mController.uMN, this.rMc.rMb.rMa.rLT.getString(R.l.favorite_retransmit_tip));
      return;
    }
    if (bool)
    {
      com.tencent.mm.ui.base.h.bC(this.rMc.rMb.rMa.rLT.mController.uMN, this.rMc.rMb.rMa.rLT.getString(R.l.Note_NotDownload_CannotForward));
      return;
    }
    if (i != 0)
    {
      com.tencent.mm.ui.base.h.bC(this.rMc.rMb.rMa.rLT.mController.uMN, this.rMc.rMb.rMa.rLT.getString(R.l.Note_NotUpload_CannotForward));
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("Select_Conv_Type", 3);
    ((Intent)localObject).putExtra("scene_from", 1);
    ((Intent)localObject).putExtra("mutil_select_is_ret", true);
    ((Intent)localObject).putExtra("select_fav_local_id", NoteEditorUI.h(this.rMc.rMb.rMa.rLT));
    d.c(this.rMc.rMb.rMa.rLT, ".ui.transmit.SelectConversationUI", (Intent)localObject, 4101);
    com.tencent.mm.plugin.fav.a.h.f(NoteEditorUI.h(this.rMc.rMb.rMa.rLT), 1, 0);
    localObject = NoteEditorUI.i(this.rMc.rMb.rMa.rLT);
    ((h.a)localObject).jYM += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2.2.1
 * JD-Core Version:    0.7.0.1
 */