package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class NewBizInfoMoreInofUI$4
  implements DialogInterface.OnClickListener
{
  NewBizInfoMoreInofUI$4(NewBizInfoMoreInofUI paramNewBizInfoMoreInofUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(27548);
    Object localObject = new Intent("android.intent.action.DIAL");
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setData(Uri.parse("tel:" + this.qew));
    if (Util.isIntentAvailable(this.BjS, (Intent)localObject))
    {
      paramDialogInterface = this.BjS;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMoreInofUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMoreInofUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(27548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI.4
 * JD-Core Version:    0.7.0.1
 */