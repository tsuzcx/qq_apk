package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ak$1
  implements DialogInterface.OnClickListener
{
  ak$1(ak paramak, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(30988);
    paramDialogInterface.dismiss();
    this.val$activity.finish();
    AppMethodBeat.o(30988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ak.1
 * JD-Core Version:    0.7.0.1
 */