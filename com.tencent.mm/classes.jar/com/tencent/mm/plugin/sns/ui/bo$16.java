package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    if ((paramView.getTag() instanceof bl))
    {
      paramView = (bl)paramView.getTag();
      if (bt.isNullOrNil(paramView.ApH))
      {
        ad.e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
        Toast.makeText(this.Aqp.context, this.Aqp.context.getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99737);
        return;
      }
      com.tencent.mm.kernel.g.ajD();
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramView.ApH);
      if ((localObject != null) && (((aw)localObject).field_username.equals(paramView.ApH)))
      {
        localObject = new Intent();
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("Contact_User", paramView.ApH);
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, paramView.ApH + ",37");
        ((Intent)localObject).putExtra("Contact_Scene", 37);
        com.tencent.mm.plugin.sns.c.a.iRG.c((Intent)localObject, this.Aqp.context);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99737);
        return;
      }
      as.a.hFO.a(paramView.ApH, "", new as.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(198514);
          if (bo.16.this.Aqp.tipDialog != null) {
            bo.16.this.Aqp.tipDialog.dismiss();
          }
          if (!paramAnonymousBoolean)
          {
            Toast.makeText(bo.16.this.Aqp.context, bo.16.this.Aqp.context.getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
            AppMethodBeat.o(198514);
            return;
          }
          c.ak(paramAnonymousString, 3);
          com.tencent.mm.ak.p.aEz().CU(paramAnonymousString);
          Intent localIntent = new Intent();
          localIntent.addFlags(268435456);
          localIntent.putExtra("Contact_User", paramAnonymousString);
          localIntent.putExtra("Contact_Scene", 37);
          com.tencent.mm.kernel.g.ajD();
          am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramAnonymousString);
          if ((localam != null) && (localam.fqg()))
          {
            com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, paramAnonymousString + ",37");
            localIntent.putExtra("Contact_Scene", 37);
          }
          com.tencent.mm.plugin.sns.c.a.iRG.c(localIntent, bo.16.this.Aqp.context);
          AppMethodBeat.o(198514);
        }
      });
      localObject = this.Aqp;
      Context localContext = this.Aqp.context;
      this.Aqp.context.getString(2131755906);
      ((bo)localObject).tipDialog = h.b(localContext, this.Aqp.context.getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(198515);
          as.a.hFO.AJ(paramView.ApH);
          AppMethodBeat.o(198515);
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