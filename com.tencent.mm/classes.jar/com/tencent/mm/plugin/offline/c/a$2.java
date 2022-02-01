package com.tencent.mm.plugin.offline.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$2
  implements DialogInterface.OnClickListener
{
  a$2(Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(66553);
    this.val$activity.finish();
    AppMethodBeat.o(66553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.a.2
 * JD-Core Version:    0.7.0.1
 */