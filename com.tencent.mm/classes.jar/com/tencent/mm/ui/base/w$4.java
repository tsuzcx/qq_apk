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

final class w$4
  implements a.b
{
  w$4(Context paramContext) {}
  
  public final void bPM()
  {
    AppMethodBeat.i(164155);
    if (!androidx.core.app.a.a((Activity)this.oOw, "android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      h.a(this.oOw, this.oOw.getString(a.k.permission_storage_request_again_msg), this.oOw.getString(a.k.permission_tips_title), this.oOw.getString(a.k.jump_to_settings), this.oOw.getString(a.k.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(164153);
          paramAnonymousDialogInterface.dismiss();
          Object localObject = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
          ((Intent)localObject).setData(Uri.fromParts("package", w.4.this.oOw.getPackageName(), null));
          ((Intent)localObject).addFlags(268435456);
          paramAnonymousDialogInterface = w.4.this.oOw;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/base/MMToast$14$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/ui/base/MMToast$14$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          f.Iyx.idkeyStat(462L, 23L, 1L, true);
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
    f.Iyx.idkeyStat(462L, 22L, 1L, true);
    androidx.core.app.a.a((Activity)this.oOw, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 32767);
    AppMethodBeat.o(164155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.w.4
 * JD-Core Version:    0.7.0.1
 */