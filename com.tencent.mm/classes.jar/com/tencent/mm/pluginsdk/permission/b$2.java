package com.tencent.mm.pluginsdk.permission;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2
  implements DialogInterface.OnClickListener
{
  b$2(Activity paramActivity, String paramString, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(151620);
    paramDialogInterface.dismiss();
    paramDialogInterface = this.val$activity;
    String str = this.bFE;
    paramInt = this.val$requestCode;
    a.a(paramDialogInterface, new String[] { str }, paramInt);
    AppMethodBeat.o(151620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.b.2
 * JD-Core Version:    0.7.0.1
 */