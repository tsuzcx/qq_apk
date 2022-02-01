package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class AppUpdaterUI$1$1
  implements DialogInterface.OnClickListener
{
  AppUpdaterUI$1$1(AppUpdaterUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(32622);
    ac.d("MicroMsg.AppUpdaterUI", "go to WebView");
    Object localObject = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
    ((Intent)localObject).addFlags(268435456);
    paramDialogInterface = this.Gln.Glm;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/sandbox/updater/AppUpdaterUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/sandbox/updater/AppUpdaterUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(32622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.1.1
 * JD-Core Version:    0.7.0.1
 */