package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.h;

final class e$3
  implements DialogInterface.OnCancelListener
{
  e$3(e parame, h paramh) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    au.Dk().c(this.nOJ);
    if (this.nOI.nOF != null) {
      this.nOI.nOF.n(1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.e.3
 * JD-Core Version:    0.7.0.1
 */