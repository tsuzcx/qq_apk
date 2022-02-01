package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.ui.widget.snackbar.a.b;

final class aa$4
  implements a.b
{
  aa$4(Context paramContext) {}
  
  public final void onMessageClick()
  {
    AppMethodBeat.i(164155);
    if (!androidx.core.app.a.a((Activity)this.rSm, "android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      k.a(this.rSm, this.rSm.getString(a.k.permission_storage_request_again_msg), this.rSm.getString(a.k.permission_tips_title), this.rSm.getString(a.k.jump_to_settings), this.rSm.getString(a.k.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(164153);
          paramAnonymousDialogInterface.dismiss();
          Object localObject = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
          ((Intent)localObject).setData(Uri.fromParts("package", aa.4.this.rSm.getPackageName(), null));
          ((Intent)localObject).addFlags(268435456);
          paramAnonymousDialogInterface = aa.4.this.rSm;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/base/MMToast$14$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/ui/base/MMToast$14$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          f.Ozc.idkeyStat(462L, 23L, 1L, true);
          AppMethodBeat.o(164153);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(164154);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(164154);
        }
      });
      AppMethodBeat.o(164155);
      return;
    }
    f.Ozc.idkeyStat(462L, 22L, 1L, true);
    androidx.core.app.a.a((Activity)this.rSm, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 32767);
    AppMethodBeat.o(164155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.aa.4
 * JD-Core Version:    0.7.0.1
 */