package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.AuthorizeItemListView;

final class n$3
  implements DialogInterface.OnDismissListener
{
  n$3(n paramn) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(79176);
    if (this.vtf.jiY != null) {
      this.vtf.jiY.setAdapter(null);
    }
    AppMethodBeat.o(79176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.3
 * JD-Core Version:    0.7.0.1
 */