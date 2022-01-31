package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.a.d;
import com.tencent.mm.sdk.platformtools.y;

final class ProductUI$8
  implements DialogInterface.OnCancelListener
{
  ProductUI$8(ProductUI paramProductUI, d paramd) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.d("MicroMsg.scanner.ProductUI", "User cancel");
    au.Dk().c(this.nKI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.8
 * JD-Core Version:    0.7.0.1
 */