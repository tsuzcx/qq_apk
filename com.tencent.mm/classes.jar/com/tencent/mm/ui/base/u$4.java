package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.ui.widget.snackbar.a.b;

final class u$4
  implements a.b
{
  u$4(Context paramContext) {}
  
  public final void bDZ()
  {
    AppMethodBeat.i(164155);
    if (!android.support.v4.app.a.a((Activity)this.lRR, "android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      h.a(this.lRR, this.lRR.getString(2131763888), this.lRR.getString(2131763890), this.lRR.getString(2131762043), this.lRR.getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(164153);
          paramAnonymousDialogInterface.dismiss();
          Object localObject = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
          ((Intent)localObject).setData(Uri.fromParts("package", u.4.this.lRR.getPackageName(), null));
          ((Intent)localObject).addFlags(268435456);
          paramAnonymousDialogInterface = u.4.this.lRR;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/base/MMToast$14$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/base/MMToast$14$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          e.Cxv.idkeyStat(462L, 23L, 1L, true);
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
    e.Cxv.idkeyStat(462L, 22L, 1L, true);
    android.support.v4.app.a.a((Activity)this.lRR, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 32767);
    AppMethodBeat.o(164155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.u.4
 * JD-Core Version:    0.7.0.1
 */