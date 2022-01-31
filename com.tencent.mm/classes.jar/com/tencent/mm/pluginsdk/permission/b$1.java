package com.tencent.mm.pluginsdk.permission;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements DialogInterface.OnClickListener
{
  b$1(Activity paramActivity, String[] paramArrayOfString, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(79411);
    paramDialogInterface.dismiss();
    a.a(this.val$activity, this.vd, this.val$requestCode);
    AppMethodBeat.o(79411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.b.1
 * JD-Core Version:    0.7.0.1
 */