package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.model.d;
import com.tencent.mm.sdk.platformtools.ab;

final class ProductUI$8
  implements DialogInterface.OnCancelListener
{
  ProductUI$8(ProductUI paramProductUI, d paramd) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(81088);
    ab.d("MicroMsg.scanner.ProductUI", "User cancel");
    g.Rc().a(this.qyl);
    AppMethodBeat.o(81088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.8
 * JD-Core Version:    0.7.0.1
 */