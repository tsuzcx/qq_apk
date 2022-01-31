package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class i$1$1$1
  implements DialogInterface.OnDismissListener
{
  i$1$1$1(i.1.1 param1) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(2006);
    g.RL().Ru().set(ac.a.yJG, Integer.valueOf(1));
    g.RL().Ru().dww();
    AppMethodBeat.o(2006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.i.1.1.1
 * JD-Core Version:    0.7.0.1
 */