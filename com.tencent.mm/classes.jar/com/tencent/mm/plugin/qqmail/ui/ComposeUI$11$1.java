package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.v;

final class ComposeUI$11$1
  implements DialogInterface.OnCancelListener
{
  ComposeUI$11$1(ComposeUI.11 param11) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    ComposeUI.E(this.ngO.ngJ).buc();
    ComposeUI.E(this.ngO.ngJ).nhG = null;
    ac.btF().cancel(ComposeUI.F(this.ngO.ngJ));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.11.1
 * JD-Core Version:    0.7.0.1
 */