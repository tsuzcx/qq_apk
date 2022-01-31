package com.tencent.mm.plugin.soter.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.support.v7.app.AlertController;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class b$5
  implements DialogInterface.OnShowListener
{
  b$5(b paramb) {}
  
  public final void onShow(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(73875);
    this.soc.snU.Or.Nn.setTextColor(ah.getContext().getResources().getColor(2131689820));
    AppMethodBeat.o(73875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b.5
 * JD-Core Version:    0.7.0.1
 */