package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitalk.a.a;
import com.tencent.mm.sdk.platformtools.ae;

final class q$11
  implements DialogInterface.OnClickListener
{
  q$11(q paramq) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!((a)g.r(a.class)).It(this.vjS.getTalkerUserName())) {
      Toast.makeText(ae.getContext(), ae.getContext().getString(R.l.multitalk_system_master_multi_finish_msg), 0).show();
    }
    while (((a)g.r(a.class)).Iz(this.vjS.getTalkerUserName())) {
      return;
    }
    Toast.makeText(ae.getContext(), ae.getContext().getString(R.l.multitalk_error_300), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.11
 * JD-Core Version:    0.7.0.1
 */