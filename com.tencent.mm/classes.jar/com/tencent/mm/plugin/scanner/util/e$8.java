package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.openim.b.n;

final class e$8
  implements DialogInterface.OnCancelListener
{
  e$8(e parame, n paramn) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    au.Dk().c(this.kAN);
    if (this.nOI.nOF != null) {
      this.nOI.nOF.n(1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.e.8
 * JD-Core Version:    0.7.0.1
 */