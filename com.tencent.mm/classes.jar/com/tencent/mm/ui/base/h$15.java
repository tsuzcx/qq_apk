package com.tencent.mm.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class h$15
  implements DialogInterface.OnCancelListener
{
  h$15(WeakReference paramWeakReference) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(106419);
    DialogInterface.OnCancelListener localOnCancelListener = (DialogInterface.OnCancelListener)this.ziH.get();
    if (localOnCancelListener != null) {
      localOnCancelListener.onCancel(paramDialogInterface);
    }
    y.activateBroadcast(false);
    AppMethodBeat.o(106419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.h.15
 * JD-Core Version:    0.7.0.1
 */