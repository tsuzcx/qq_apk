package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.j.a;

final class SnsUploadConfigView$15
  implements DialogInterface.OnClickListener
{
  SnsUploadConfigView$15(SnsUploadConfigView paramSnsUploadConfigView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(39700);
    paramDialogInterface = this.sbB;
    Context localContext = this.sbB.getContext();
    this.sbB.getContext().getString(2131297087);
    SnsUploadConfigView.a(paramDialogInterface, h.b(localContext, this.sbB.getContext().getString(2131304397), true, new SnsUploadConfigView.15.1(this)));
    SnsUploadConfigView.l(this.sbB).a(this.sbB, this.sbB.getContext());
    AppMethodBeat.o(39700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.15
 * JD-Core Version:    0.7.0.1
 */