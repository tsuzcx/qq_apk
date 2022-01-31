package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ak$2
  implements DialogInterface.OnClickListener
{
  ak$2(ak paramak, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(30989);
    paramDialogInterface.dismiss();
    this.val$activity.finish();
    AppMethodBeat.o(30989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ak.2
 * JD-Core Version:    0.7.0.1
 */