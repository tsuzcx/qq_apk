package com.tencent.mm.ui.chatting.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

final class au$1
  implements DialogInterface.OnCancelListener
{
  au$1(au paramau, ca paramca, w paramw) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(35526);
    Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "cancel revoke msg:%d", new Object[] { Long.valueOf(this.iBP.field_msgId) });
    bg.azz().a(this.Ptk);
    AppMethodBeat.o(35526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.au.1
 * JD-Core Version:    0.7.0.1
 */