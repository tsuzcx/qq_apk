package com.tencent.mm.ui.chatting.component;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.cc;

final class bs$4
  implements DialogInterface.OnClickListener
{
  bs$4(bs parambs, cc paramcc, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(35751);
    bs.a(this.aeyW, this.oiL);
    h.OAn.b(17509, new Object[] { Integer.valueOf(2), this.aewM });
    AppMethodBeat.o(35751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bs.4
 * JD-Core Version:    0.7.0.1
 */