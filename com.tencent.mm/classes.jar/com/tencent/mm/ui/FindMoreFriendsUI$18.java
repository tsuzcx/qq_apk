package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

final class FindMoreFriendsUI$18
  implements DialogInterface.OnClickListener
{
  FindMoreFriendsUI$18(FindMoreFriendsUI paramFindMoreFriendsUI, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33051);
    if (this.val$runnable != null) {
      this.val$runnable.run();
    }
    g.agR().agA().set(ah.a.GTH, Boolean.TRUE);
    AppMethodBeat.o(33051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.18
 * JD-Core Version:    0.7.0.1
 */