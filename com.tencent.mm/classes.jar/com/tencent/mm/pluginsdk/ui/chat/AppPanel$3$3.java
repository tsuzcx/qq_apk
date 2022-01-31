package com.tencent.mm.pluginsdk.ui.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.sdk.b.a;

final class AppPanel$3$3
  implements DialogInterface.OnClickListener
{
  AppPanel$3$3(AppPanel.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ru localru = new ru();
    localru.cbq.cbt = true;
    a.udP.m(localru);
    AppPanel.k(this.seo.sen).bhn();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel.3.3
 * JD-Core Version:    0.7.0.1
 */