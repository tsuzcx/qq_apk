package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.storage.bu;

final class ShakeSayHiListUI$3$1
  implements DialogInterface.OnClickListener
{
  ShakeSayHiListUI$3$1(ShakeSayHiListUI.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ShakeSayHiListUI.e(this.odw.odv).aUK();
    ShakeSayHiListUI.b(this.odw.odv).yc();
    paramDialogInterface = (TextView)this.odw.odv.findViewById(R.h.empty_msg_tip_tv);
    paramDialogInterface.setText(R.l.say_hi_non);
    paramDialogInterface.setVisibility(0);
    this.odw.odv.enableOptionMenu(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.3.1
 * JD-Core Version:    0.7.0.1
 */