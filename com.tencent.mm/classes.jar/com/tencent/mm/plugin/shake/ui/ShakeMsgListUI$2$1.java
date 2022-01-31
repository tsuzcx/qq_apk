package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.sdk.e.e;

final class ShakeMsgListUI$2$1
  implements DialogInterface.OnClickListener
{
  ShakeMsgListUI$2$1(ShakeMsgListUI.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = ShakeMsgListUI.a(this.obU.obT);
    paramDialogInterface.dXw.delete(paramDialogInterface.getTableName(), null, null);
    ShakeMsgListUI.b(this.obU.obT).yc();
    ShakeMsgListUI.c(this.obU.obT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.2.1
 * JD-Core Version:    0.7.0.1
 */