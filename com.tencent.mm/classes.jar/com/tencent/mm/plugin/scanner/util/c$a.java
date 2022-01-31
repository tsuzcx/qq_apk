package com.tencent.mm.plugin.scanner.util;

import a.l;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/scanner/util/OfflineScanManager$handleNetworkUnconnected$1", "Landroid/content/DialogInterface$OnClickListener;", "onClick", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "plugin-scan_release"})
public final class c$a
  implements DialogInterface.OnClickListener
{
  c$a(OfflineScanContext paramOfflineScanContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(151714);
    this.qCi.getActivity().finish();
    this.qCi.getActivity().overridePendingTransition(0, 0);
    AppMethodBeat.o(151714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.c.a
 * JD-Core Version:    0.7.0.1
 */