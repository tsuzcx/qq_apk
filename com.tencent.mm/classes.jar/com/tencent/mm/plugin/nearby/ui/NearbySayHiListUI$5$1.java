package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.storage.bg;

final class NearbySayHiListUI$5$1
  implements DialogInterface.OnClickListener
{
  NearbySayHiListUI$5$1(NearbySayHiListUI.5 param5) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NearbySayHiListUI.e(this.mDQ.mDP).aUK();
    NearbySayHiListUI.b(this.mDQ.mDP).yc();
    paramDialogInterface = (TextView)this.mDQ.mDP.findViewById(b.d.empty_msg_tip_tv);
    paramDialogInterface.setText(b.h.say_hi_non);
    paramDialogInterface.setVisibility(0);
    this.mDQ.mDP.enableOptionMenu(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.5.1
 * JD-Core Version:    0.7.0.1
 */