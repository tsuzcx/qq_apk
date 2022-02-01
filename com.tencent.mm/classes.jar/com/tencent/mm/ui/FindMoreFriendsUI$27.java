package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

final class FindMoreFriendsUI$27
  implements DialogInterface.OnClickListener
{
  FindMoreFriendsUI$27(FindMoreFriendsUI paramFindMoreFriendsUI, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(250147);
    this.val$runnable.run();
    h.baE().ban().set(at.a.acZx, Boolean.TRUE);
    AppMethodBeat.o(250147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.27
 * JD-Core Version:    0.7.0.1
 */