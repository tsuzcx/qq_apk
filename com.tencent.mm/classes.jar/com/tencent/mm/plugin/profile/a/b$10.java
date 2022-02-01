package com.tencent.mm.plugin.profile.a;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.report.service.h;

final class b$10
  implements DialogInterface.OnClickListener
{
  b$10(b paramb, ProgressDialog paramProgressDialog, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(219681);
    h.IzE.a(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(3), b.c(this.GWM).field_username });
    this.iYO.show();
    b.a(this.GWM, false);
    b.a(this.GWM, this.GWQ);
    AppMethodBeat.o(219681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.b.10
 * JD-Core Version:    0.7.0.1
 */