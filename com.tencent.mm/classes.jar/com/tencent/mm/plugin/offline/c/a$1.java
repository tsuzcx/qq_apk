package com.tencent.mm.plugin.offline.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements DialogInterface.OnClickListener
{
  a$1(Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(66552);
    a.dAK();
    a.ay(this.val$activity);
    this.val$activity.finish();
    AppMethodBeat.o(66552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.c.a.1
 * JD-Core Version:    0.7.0.1
 */