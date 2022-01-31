package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

final class c$9
  implements DialogInterface.OnClickListener
{
  c$9(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    a.bqS();
    h.bC(this.mMg.mActivity, this.mMg.mActivity.getResources().getString(a.i.wallet_wx_offline_close_toast_tips));
    c.a(this.mMg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.c.9
 * JD-Core Version:    0.7.0.1
 */