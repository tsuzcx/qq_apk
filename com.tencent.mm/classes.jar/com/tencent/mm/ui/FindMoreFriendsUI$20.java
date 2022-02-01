package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class FindMoreFriendsUI$20
  implements DialogInterface.OnClickListener
{
  FindMoreFriendsUI$20(FindMoreFriendsUI paramFindMoreFriendsUI, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(197871);
    this.val$runnable.run();
    h.aHG().aHp().set(ar.a.VxK, Boolean.TRUE);
    AppMethodBeat.o(197871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.20
 * JD-Core Version:    0.7.0.1
 */