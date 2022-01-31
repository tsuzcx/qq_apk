package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.sdk.b.a;

final class NormalUserFooterPreference$a$2
  implements DialogInterface.OnClickListener
{
  NormalUserFooterPreference$a$2(NormalUserFooterPreference.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ru localru = new ru();
    localru.cbq.cbt = true;
    a.udP.m(localru);
    this.mYE.bsL();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.2
 * JD-Core Version:    0.7.0.1
 */