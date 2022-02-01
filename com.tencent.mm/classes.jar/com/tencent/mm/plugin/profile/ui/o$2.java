package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Util;

final class o$2
  implements DialogInterface.OnClickListener
{
  o$2(o paramo) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(27207);
    if (ChannelUtil.channelId == 1)
    {
      Object localObject = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.qqpim")).addFlags(268435456);
      if (Util.isIntentAvailable(o.a(this.MXK), (Intent)localObject))
      {
        paramDialogInterface = o.a(this.MXK);
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramDialogInterface, "com/tencent/mm/plugin/profile/ui/ContactWidgetQQSync$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(27207);
        return;
      }
    }
    AppMethodBeat.o(27207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.o.2
 * JD-Core Version:    0.7.0.1
 */