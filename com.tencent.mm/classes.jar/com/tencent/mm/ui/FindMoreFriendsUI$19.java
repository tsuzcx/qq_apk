package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class FindMoreFriendsUI$19
  implements DialogInterface.OnClickListener
{
  FindMoreFriendsUI$19(FindMoreFriendsUI paramFindMoreFriendsUI, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33052);
    this.val$runnable.run();
    g.aAh().azQ().set(ar.a.Oju, Boolean.TRUE);
    AppMethodBeat.o(33052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.19
 * JD-Core Version:    0.7.0.1
 */