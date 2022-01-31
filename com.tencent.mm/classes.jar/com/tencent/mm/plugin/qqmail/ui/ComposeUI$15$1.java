package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.k;
import com.tencent.mm.plugin.qqmail.b.v;
import java.io.File;

final class ComposeUI$15$1
  implements DialogInterface.OnClickListener
{
  ComposeUI$15$1(ComposeUI.15 param15) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = ac.btF().nen;
    String str = ComposeUI.J(this.ngQ.ngJ);
    paramInt = ComposeUI.K(this.ngQ.ngJ);
    paramDialogInterface = new File(paramDialogInterface.ndq.ndA + i.ci(str, paramInt));
    if (paramDialogInterface.exists()) {
      paramDialogInterface.delete();
    }
    this.ngQ.ngJ.setResult(-1);
    this.ngQ.ngJ.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.15.1
 * JD-Core Version:    0.7.0.1
 */