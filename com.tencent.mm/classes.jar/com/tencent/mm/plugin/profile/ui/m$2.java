package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URI;
import java.net.URL;

final class m$2
  implements DialogInterface.OnClickListener
{
  m$2(m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = "http://tools.3g.qq.com/j/wechatandriodpim";
    if (e.bvj == 1)
    {
      paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.qqpim")).addFlags(268435456);
      if (bk.i(this.mXN.context, paramDialogInterface))
      {
        this.mXN.context.startActivity(paramDialogInterface);
        return;
      }
      paramDialogInterface = "https://play.google.com/store/apps/details?id=com.tencent.qqpim";
    }
    try
    {
      paramDialogInterface = new URL(paramDialogInterface);
      paramDialogInterface = new URI(paramDialogInterface.getProtocol(), paramDialogInterface.getUserInfo(), paramDialogInterface.getHost(), paramDialogInterface.getPort(), paramDialogInterface.getPath(), paramDialogInterface.getQuery(), paramDialogInterface.getRef()).toURL();
      e.a locala = new e.a();
      locala.zP("qqpim.apk");
      locala.zN(paramDialogInterface.toString());
      locala.eO(true);
      locala.pE(1);
      d.aFP().a(locala.iPG);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      y.e("MicroMsg.ContactWidgetQQSync", "dz[download qq mail error:%s]", new Object[] { paramDialogInterface.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.m.2
 * JD-Core Version:    0.7.0.1
 */