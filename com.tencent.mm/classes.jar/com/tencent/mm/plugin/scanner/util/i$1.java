package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.scanner.model.j;
import com.tencent.mm.sdk.platformtools.ab;

final class i$1
  implements DialogInterface.OnCancelListener
{
  i$1(i parami, com.tencent.mm.plugin.scanner.model.g paramg) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    int i = 2;
    int k = 1;
    AppMethodBeat.i(151692);
    com.tencent.mm.kernel.g.Rc().a(this.qBW);
    this.qCP.kA(false);
    if (this.qCP.qCN != null) {
      this.qCP.qCN.onCancel();
    }
    paramDialogInterface = this.qCP;
    Object localObject = this.qBW;
    c localc = c.qCh;
    int j;
    if (c.n((m)localObject))
    {
      ab.i("MicroMsg.ScanBarCodeHelper", "alvinluo OfflineScan onCancelScene processOfflineScan: %b, offlineScanNetworkType: %d", new Object[] { Boolean.valueOf(paramDialogInterface.qCt), Integer.valueOf(paramDialogInterface.qCu) });
      localObject = j.qut;
      localObject = paramDialogInterface.typeName;
      if (!paramDialogInterface.qus) {
        break label157;
      }
      if (!paramDialogInterface.qCt) {
        break label162;
      }
      j = paramDialogInterface.qCu;
      label135:
      if (!paramDialogInterface.qCt) {
        break label167;
      }
    }
    for (;;)
    {
      j.l((String)localObject, i, j, k);
      AppMethodBeat.o(151692);
      return;
      label157:
      i = 1;
      break;
      label162:
      j = 3;
      break label135;
      label167:
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.i.1
 * JD-Core Version:    0.7.0.1
 */