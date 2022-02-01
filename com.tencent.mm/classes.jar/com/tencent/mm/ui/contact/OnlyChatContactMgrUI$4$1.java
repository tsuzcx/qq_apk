package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;

final class OnlyChatContactMgrUI$4$1
  implements DialogInterface.OnCancelListener
{
  OnlyChatContactMgrUI$4$1(OnlyChatContactMgrUI.4 param4, com.tencent.mm.modelmulti.h paramh) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(253005);
    com.tencent.mm.kernel.h.baD().mCm.a(this.afgL);
    AppMethodBeat.o(253005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OnlyChatContactMgrUI.4.1
 * JD-Core Version:    0.7.0.1
 */