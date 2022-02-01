package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;

final class SnsTimeLineUI$76
  implements DialogInterface.OnClickListener
{
  SnsTimeLineUI$76(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(307562);
    paramDialogInterface.dismiss();
    b.lx(this.RAo.getContext());
    AppMethodBeat.o(307562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.76
 * JD-Core Version:    0.7.0.1
 */