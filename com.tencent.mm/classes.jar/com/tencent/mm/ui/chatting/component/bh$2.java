package com.tencent.mm.ui.chatting.component;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.cc;

final class bh$2
  implements DialogInterface.OnClickListener
{
  bh$2(bh parambh, cc paramcc, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(35560);
    bh.a(this.aewN, this.oiL);
    h.OAn.b(17509, new Object[] { Integer.valueOf(2), this.aewM });
    AppMethodBeat.o(35560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bh.2
 * JD-Core Version:    0.7.0.1
 */