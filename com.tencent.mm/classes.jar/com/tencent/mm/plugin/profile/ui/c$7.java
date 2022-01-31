package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;

final class c$7
  implements DialogInterface.OnClickListener
{
  c$7(c paramc, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent("android.intent.action.DIAL");
    paramDialogInterface.setFlags(268435456);
    paramDialogInterface.setData(Uri.parse("tel:" + this.ixq));
    if (bk.i(this.mWY.bER, paramDialogInterface)) {
      this.mWY.bER.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.7
 * JD-Core Version:    0.7.0.1
 */