package com.tencent.mm.plugin.voip.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;

final class d$1
  implements RequestFloatWindowPermissionDialog.a
{
  d$1(d paramd, a parama, Intent paramIntent) {}
  
  public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
  {
    AppMethodBeat.i(4969);
    paramRequestFloatWindowPermissionDialog.finish();
    if (this.tFc.bIS()) {
      d.a(this.tFd, this.val$intent);
    }
    AppMethodBeat.o(4969);
  }
  
  public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
  {
    AppMethodBeat.i(4970);
    paramRequestFloatWindowPermissionDialog.finish();
    AppMethodBeat.o(4970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.d.1
 * JD-Core Version:    0.7.0.1
 */