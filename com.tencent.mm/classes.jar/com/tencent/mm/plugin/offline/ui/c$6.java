package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$6
  implements DialogInterface.OnClickListener
{
  c$6(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(43476);
    paramDialogInterface.dismiss();
    this.pmw.mActivity.finish();
    AppMethodBeat.o(43476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.6
 * JD-Core Version:    0.7.0.1
 */