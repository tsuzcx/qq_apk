package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;
import java.net.URI;
import java.net.URL;

final class m$2
  implements DialogInterface.OnClickListener
{
  m$2(m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(27207);
    paramDialogInterface = "http://tools.3g.qq.com/j/wechatandriodpim";
    Object localObject;
    if (j.cSc == 1)
    {
      localObject = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.qqpim")).addFlags(268435456);
      if (bt.aj(this.wSl.context, (Intent)localObject))
      {
        paramDialogInterface = this.wSl.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(27207);
        return;
      }
      paramDialogInterface = "https://play.google.com/store/apps/details?id=com.tencent.qqpim";
    }
    try
    {
      paramDialogInterface = new URL(paramDialogInterface);
      paramDialogInterface = new URI(paramDialogInterface.getProtocol(), paramDialogInterface.getUserInfo(), paramDialogInterface.getHost(), paramDialogInterface.getPort(), paramDialogInterface.getPath(), paramDialogInterface.getQuery(), paramDialogInterface.getRef()).toURL();
      localObject = new g.a();
      ((g.a)localObject).aam("qqpim.apk");
      ((g.a)localObject).aak(paramDialogInterface.toString());
      ((g.a)localObject).jQ(true);
      ((g.a)localObject).Bp(1);
      f.ccl().a(((g.a)localObject).pmN);
      AppMethodBeat.o(27207);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ad.e("MicroMsg.ContactWidgetQQSync", "dz[download qq mail error:%s]", new Object[] { paramDialogInterface.toString() });
      AppMethodBeat.o(27207);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.m.2
 * JD-Core Version:    0.7.0.1
 */