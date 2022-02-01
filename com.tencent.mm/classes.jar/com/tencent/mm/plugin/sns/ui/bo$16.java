package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;

final class bo$16
  implements View.OnClickListener
{
  bo$16(bo parambo) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(99737);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    if ((paramView.getTag() instanceof bl))
    {
      paramView = (bl)paramView.getTag();
      if (bu.isNullOrNil(paramView.AGU))
      {
        ae.e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
        Toast.makeText(this.AHD.context, this.AHD.context.getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99737);
        return;
      }
      com.tencent.mm.kernel.g.ajS();
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramView.AGU);
      if ((localObject != null) && (((aw)localObject).field_username.equals(paramView.AGU)))
      {
        localObject = new Intent();
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("Contact_User", paramView.AGU);
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, paramView.AGU + ",37");
        ((Intent)localObject).putExtra("Contact_Scene", 37);
        com.tencent.mm.plugin.sns.c.a.iUz.c((Intent)localObject, this.AHD.context);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99737);
        return;
      }
      au.a.hIG.a(paramView.AGU, "", new au.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(220056);
          if (bo.16.this.AHD.tipDialog != null) {
            bo.16.this.AHD.tipDialog.dismiss();
          }
          if (!paramAnonymousBoolean)
          {
            Toast.makeText(bo.16.this.AHD.context, bo.16.this.AHD.context.getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
            AppMethodBeat.o(220056);
            return;
          }
          c.al(paramAnonymousString, 3);
          com.tencent.mm.aj.p.aEP().Dw(paramAnonymousString);
          Intent localIntent = new Intent();
          localIntent.addFlags(268435456);
          localIntent.putExtra("Contact_User", paramAnonymousString);
          localIntent.putExtra("Contact_Scene", 37);
          com.tencent.mm.kernel.g.ajS();
          an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramAnonymousString);
          if ((localan != null) && (localan.fug()))
          {
            com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, paramAnonymousString + ",37");
            localIntent.putExtra("Contact_Scene", 37);
          }
          com.tencent.mm.plugin.sns.c.a.iUz.c(localIntent, bo.16.this.AHD.context);
          AppMethodBeat.o(220056);
        }
      });
      localObject = this.AHD;
      Context localContext = this.AHD.context;
      this.AHD.context.getString(2131755906);
      ((bo)localObject).tipDialog = h.b(localContext, this.AHD.context.getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(220057);
          au.a.hIG.Bt(paramView.AGU);
          AppMethodBeat.o(220057);
        }
      });
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bo.16
 * JD-Core Version:    0.7.0.1
 */