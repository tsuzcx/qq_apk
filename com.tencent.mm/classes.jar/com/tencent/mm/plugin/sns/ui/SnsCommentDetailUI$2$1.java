package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.r;

final class SnsCommentDetailUI$2$1
  implements DialogInterface.OnCancelListener
{
  SnsCommentDetailUI$2$1(SnsCommentDetailUI.2 param2, r paramr) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(163079);
    g.ajS();
    g.ajQ().gDv.a(this.Atb);
    AppMethodBeat.o(163079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.2.1
 * JD-Core Version:    0.7.0.1
 */