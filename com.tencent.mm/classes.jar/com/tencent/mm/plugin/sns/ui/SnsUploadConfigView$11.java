package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.pluginsdk.l;

final class SnsUploadConfigView$11
  implements DialogInterface.OnClickListener
{
  SnsUploadConfigView$11(SnsUploadConfigView paramSnsUploadConfigView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(99528);
    a.hYt.g(new Intent(), SnsUploadConfigView.k(this.xKd));
    AppMethodBeat.o(99528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.11
 * JD-Core Version:    0.7.0.1
 */