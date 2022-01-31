package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import java.net.URI;
import java.net.URL;

final class m$2
  implements DialogInterface.OnClickListener
{
  m$2(m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(23592);
    paramDialogInterface = "http://tools.3g.qq.com/j/wechatandriodpim";
    if (g.bWu == 1)
    {
      paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.qqpim")).addFlags(268435456);
      if (bo.k(this.pAA.context, paramDialogInterface))
      {
        this.pAA.context.startActivity(paramDialogInterface);
        AppMethodBeat.o(23592);
        return;
      }
      paramDialogInterface = "https://play.google.com/store/apps/details?id=com.tencent.qqpim";
    }
    try
    {
      paramDialogInterface = new URL(paramDialogInterface);
      paramDialogInterface = new URI(paramDialogInterface.getProtocol(), paramDialogInterface.getUserInfo(), paramDialogInterface.getHost(), paramDialogInterface.getPort(), paramDialogInterface.getPath(), paramDialogInterface.getQuery(), paramDialogInterface.getRef()).toURL();
      g.a locala = new g.a();
      locala.JL("qqpim.apk");
      locala.JJ(paramDialogInterface.toString());
      locala.gr(true);
      locala.tV(1);
      f.bjl().a(locala.kYR);
      AppMethodBeat.o(23592);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ab.e("MicroMsg.ContactWidgetQQSync", "dz[download qq mail error:%s]", new Object[] { paramDialogInterface.toString() });
      AppMethodBeat.o(23592);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.m.2
 * JD-Core Version:    0.7.0.1
 */