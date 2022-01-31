package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.y;

final class AppUpdaterUI$1$1
  implements DialogInterface.OnClickListener
{
  AppUpdaterUI$1$1(AppUpdaterUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.d("MicroMsg.AppUpdaterUI", "go to WebView");
    paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
    paramDialogInterface.addFlags(268435456);
    this.uch.ucg.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.1.1
 * JD-Core Version:    0.7.0.1
 */