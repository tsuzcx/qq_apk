package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;

final class SnsLabelUI$9
  implements DialogInterface.OnClickListener
{
  SnsLabelUI$9(SnsLabelUI paramSnsLabelUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SnsLabelUI.i(this.oZN);
    a.bdA().bF(SnsLabelUI.b(this.oZN));
    SnsLabelUI.a(this.oZN, h.b(this.oZN, this.oZN.getString(i.j.sns_label_is_transforming), false, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI.9
 * JD-Core Version:    0.7.0.1
 */