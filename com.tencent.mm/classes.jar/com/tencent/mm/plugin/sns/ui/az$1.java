package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

final class az$1
  implements DialogInterface.OnDismissListener
{
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(39833);
    g.RM();
    int i = bo.a((Integer)g.RL().Ru().get(68385, null), 0);
    g.RM();
    g.RL().Ru().set(68385, Integer.valueOf(i + 1));
    AppMethodBeat.o(39833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.az.1
 * JD-Core Version:    0.7.0.1
 */