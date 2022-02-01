package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.sdk.platformtools.ad;

final class ProductUI$8
  implements DialogInterface.OnCancelListener
{
  ProductUI$8(ProductUI paramProductUI, com.tencent.mm.plugin.scanner.model.g paramg) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(51859);
    ad.d("MicroMsg.scanner.ProductUI", "User cancel");
    com.tencent.mm.kernel.g.aeS().a(this.vTf);
    AppMethodBeat.o(51859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.8
 * JD-Core Version:    0.7.0.1
 */