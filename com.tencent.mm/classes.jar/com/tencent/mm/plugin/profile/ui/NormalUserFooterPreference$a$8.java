package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.report.service.h;

final class NormalUserFooterPreference$a$8
  implements DialogInterface.OnClickListener
{
  NormalUserFooterPreference$a$8(NormalUserFooterPreference.a parama, ProgressDialog paramProgressDialog, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(23682);
    h.qsU.e(14553, new Object[] { Integer.valueOf(2), Integer.valueOf(3), NormalUserFooterPreference.a(this.pCf.pCe).field_username });
    this.efE.show();
    this.pCf.isDeleteCancel = false;
    this.pCf.Au(this.pxM);
    AppMethodBeat.o(23682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.8
 * JD-Core Version:    0.7.0.1
 */