package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.d;
import com.tencent.mm.am.e;
import com.tencent.mm.am.q;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.s;

final class bu$24
  implements View.OnClickListener
{
  bu$24(bu parambu) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(99740);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    if ((paramView.getTag() instanceof br))
    {
      paramView = (br)paramView.getTag();
      if (Util.isNullOrNil(paramView.IGF))
      {
        Log.e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
        Toast.makeText(this.LfB.context, this.LfB.context.getString(i.j.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99740);
        return;
      }
      com.tencent.mm.kernel.h.aHH();
      localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramView.IGF);
      if ((localObject != null) && (((ax)localObject).field_username.equals(paramView.IGF)))
      {
        localObject = new Intent();
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("Contact_User", paramView.IGF);
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, paramView.IGF + ",37");
        ((Intent)localObject).putExtra("Contact_Scene", 37);
        com.tencent.mm.plugin.sns.c.a.mIG.c((Intent)localObject, this.LfB.context);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99740);
        return;
      }
      az.a.ltq.a(paramView.IGF, "", new az.b.a()
      {
        public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(224628);
          if (bu.24.this.LfB.tipDialog != null) {
            bu.24.this.LfB.tipDialog.dismiss();
          }
          if (!paramAnonymousBoolean)
          {
            Toast.makeText(bu.24.this.LfB.context, bu.24.this.LfB.context.getString(i.j.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
            AppMethodBeat.o(224628);
            return;
          }
          d.aH(paramAnonymousString, 3);
          q.bhR().TB(paramAnonymousString);
          Intent localIntent = new Intent();
          localIntent.addFlags(268435456);
          localIntent.putExtra("Contact_User", paramAnonymousString);
          localIntent.putExtra("Contact_Scene", 37);
          com.tencent.mm.kernel.h.aHH();
          as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramAnonymousString);
          if ((localas != null) && (localas.hxX()))
          {
            com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, paramAnonymousString + ",37");
            localIntent.putExtra("Contact_Scene", 37);
          }
          com.tencent.mm.plugin.sns.c.a.mIG.c(localIntent, bu.24.this.LfB.context);
          AppMethodBeat.o(224628);
        }
      });
      localObject = this.LfB;
      Context localContext = this.LfB.context;
      this.LfB.context.getString(i.j.app_tip);
      ((bu)localObject).tipDialog = com.tencent.mm.ui.base.h.a(localContext, this.LfB.context.getString(i.j.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(270239);
          az.a.ltq.Rr(paramView.IGF);
          AppMethodBeat.o(270239);
        }
      });
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bu.24
 * JD-Core Version:    0.7.0.1
 */