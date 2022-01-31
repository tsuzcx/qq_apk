package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;

final class l$1
  implements RequestFloatWindowPermissionDialog.a
{
  l$1(l paraml, String paramString1, int paramInt, String paramString2, Bundle paramBundle, boolean paramBoolean) {}
  
  public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
  {
    AppMethodBeat.i(8208);
    paramRequestFloatWindowPermissionDialog.finish();
    l.a(this.viG, this.val$url, this.fwD, this.viE, this.val$extras, this.viF);
    l.a(this.viG);
    AppMethodBeat.o(8208);
  }
  
  public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
  {
    AppMethodBeat.i(8209);
    paramRequestFloatWindowPermissionDialog.finish();
    AppMethodBeat.o(8209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.l.1
 * JD-Core Version:    0.7.0.1
 */