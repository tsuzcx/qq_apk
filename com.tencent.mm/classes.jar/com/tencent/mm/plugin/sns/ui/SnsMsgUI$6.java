package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;

final class SnsMsgUI$6
  implements DialogInterface.OnCancelListener
{
  SnsMsgUI$6(SnsMsgUI paramSnsMsgUI, com.tencent.mm.plugin.sns.model.s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(98858);
    h.baF();
    h.baD().mCm.a(this.Rua);
    AppMethodBeat.o(98858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.6
 * JD-Core Version:    0.7.0.1
 */