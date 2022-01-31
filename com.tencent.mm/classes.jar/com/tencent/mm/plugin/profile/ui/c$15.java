package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;

final class c$15
  implements DialogInterface.OnCancelListener
{
  c$15(c paramc, com.tencent.mm.plugin.profile.b.c paramc1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(23470);
    aw.Rc().a(this.pzW);
    aw.Rc().b(1363, this.pzT);
    AppMethodBeat.o(23470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.15
 * JD-Core Version:    0.7.0.1
 */