package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.a.f;

final class e$7
  implements DialogInterface.OnCancelListener
{
  e$7(e parame, f paramf) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    au.Dk().c(this.hZc);
    if (this.nOI.nOF != null) {
      this.nOI.nOF.n(1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.e.7
 * JD-Core Version:    0.7.0.1
 */