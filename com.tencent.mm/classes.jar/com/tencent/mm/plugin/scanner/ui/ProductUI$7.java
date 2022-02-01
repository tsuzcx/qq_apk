package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.scanner.model.r;
import com.tencent.mm.sdk.platformtools.Log;

final class ProductUI$7
  implements DialogInterface.OnCancelListener
{
  ProductUI$7(ProductUI paramProductUI, r paramr) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(51859);
    Log.d("MicroMsg.scanner.ProductUI", "User cancel");
    h.aZW().a(this.Paa);
    AppMethodBeat.o(51859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.7
 * JD-Core Version:    0.7.0.1
 */