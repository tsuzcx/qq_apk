package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.k;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.vfs.e;

final class ComposeUI$15$1
  implements DialogInterface.OnClickListener
{
  ComposeUI$15$1(ComposeUI.15 param15) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(122914);
    paramDialogInterface = ((o)g.ad(o.class)).getNormalMailAppService().vUM;
    String str = ComposeUI.J(this.vXh.vXa);
    paramInt = ComposeUI.K(this.vXh.vXa);
    paramDialogInterface = new e(paramDialogInterface.vTR.vUb + i.em(str, paramInt));
    if (paramDialogInterface.exists()) {
      paramDialogInterface.delete();
    }
    this.vXh.vXa.setResult(-1);
    this.vXh.vXa.finish();
    AppMethodBeat.o(122914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.15.1
 * JD-Core Version:    0.7.0.1
 */