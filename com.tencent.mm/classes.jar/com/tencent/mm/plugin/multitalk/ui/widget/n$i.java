package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.ui.a;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSmallWindow$showMini$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-multitalk_release"})
public final class n$i
  implements RequestFloatWindowPermissionDialog.a
{
  public n$i(a parama, Intent paramIntent, boolean paramBoolean) {}
  
  public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
  {
    AppMethodBeat.i(195783);
    p.k(paramRequestFloatWindowPermissionDialog, "dialog");
    paramRequestFloatWindowPermissionDialog.finish();
    if (this.FzE.eIT()) {
      n.a(this.Fzz, this.$intent);
    }
    AppMethodBeat.o(195783);
  }
  
  public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
  {
    AppMethodBeat.i(195784);
    p.k(paramRequestFloatWindowPermissionDialog, "dialog");
    paramRequestFloatWindowPermissionDialog.finish();
    AppMethodBeat.o(195784);
  }
  
  public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
  {
    AppMethodBeat.i(195785);
    p.k(paramRequestFloatWindowPermissionDialog, "dialog");
    paramRequestFloatWindowPermissionDialog.finish();
    AppMethodBeat.o(195785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.n.i
 * JD-Core Version:    0.7.0.1
 */