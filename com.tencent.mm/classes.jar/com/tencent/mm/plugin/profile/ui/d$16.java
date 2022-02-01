package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.profile.a.c;

final class d$16
  implements DialogInterface.OnCancelListener
{
  d$16(d paramd, c paramc) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(27085);
    bh.aZW().a(this.MXn);
    bh.aZW().b(1363, this.MXk);
    AppMethodBeat.o(27085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.d.16
 * JD-Core Version:    0.7.0.1
 */