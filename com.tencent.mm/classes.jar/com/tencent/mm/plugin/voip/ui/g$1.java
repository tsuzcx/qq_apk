package com.tencent.mm.plugin.voip.ui;

import android.content.Intent;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;

final class g$1
  implements RequestFloatWindowPermissionDialog.a
{
  g$1(g paramg, a parama, Intent paramIntent) {}
  
  public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
  {
    paramRequestFloatWindowPermissionDialog.finish();
    if (this.pZC.bbL()) {
      g.a(this.pZD, this.val$intent);
    }
  }
  
  public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
  {
    paramRequestFloatWindowPermissionDialog.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.g.1
 * JD-Core Version:    0.7.0.1
 */