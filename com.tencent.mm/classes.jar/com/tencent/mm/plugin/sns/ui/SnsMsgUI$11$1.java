package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.cf.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.k;

final class SnsMsgUI$11$1
  implements DialogInterface.OnClickListener
{
  SnsMsgUI$11$1(SnsMsgUI.11 param11) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SnsMsgUI.c(this.pat.paq).setVisibility(8);
    SnsMsgUI.d(this.pat.paq).setVisibility(0);
    af.bDK().dXo.gk("SnsComment", "delete from SnsComment");
    this.pat.paq.enableOptionMenu(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.11.1
 * JD-Core Version:    0.7.0.1
 */