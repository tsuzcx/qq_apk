package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

final class j$7
  implements DialogInterface.OnClickListener
{
  j$7(j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    g.DS().O(new j.7.1(this));
    j.e(this.vTn).dismiss();
    h.a(j.a(this.vTn), R.l.data_recovery_canceled, R.l.app_tip, false, new j.7.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.7
 * JD-Core Version:    0.7.0.1
 */