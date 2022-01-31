package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;

final class af$1
  implements DialogInterface.OnCancelListener
{
  af$1(af paramaf, bi parambi, v paramv) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(31631);
    ab.i("MicroMsg.ChattingUI.VerifyUserComponent", "cancel revoke msg:%d", new Object[] { Long.valueOf(this.fkQ.field_msgId) });
    aw.Rc().a(this.zHq);
    AppMethodBeat.o(31631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.af.1
 * JD-Core Version:    0.7.0.1
 */