package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.sdk.b.a;

final class ap$h$1
  implements DialogInterface.OnClickListener
{
  ap$h$1(ap.h paramh, aw paramaw) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ru localru = new ru();
    localru.cbq.cbt = true;
    a.udP.m(localru);
    ap.h.a(this.vGR, this.vGQ);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.h.1
 * JD-Core Version:    0.7.0.1
 */