package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.modelavatar.e;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

final class bv$24
  implements View.OnClickListener
{
  bv$24(bv parambv) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(99740);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    if ((paramView.getTag() instanceof bs))
    {
      paramView = (bs)paramView.getTag();
      if (Util.isNullOrNil(paramView.OMN))
      {
        Log.e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
        Toast.makeText(this.RFN.context, this.RFN.context.getString(b.j.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99740);
        return;
      }
      com.tencent.mm.kernel.h.baF();
      localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramView.OMN);
      if ((localObject != null) && (((az)localObject).field_username.equals(paramView.OMN)))
      {
        localObject = new Intent();
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("Contact_User", paramView.OMN);
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, paramView.OMN + ",37");
        ((Intent)localObject).putExtra("Contact_Scene", 37);
        com.tencent.mm.plugin.sns.d.a.pFn.c((Intent)localObject, this.RFN.context);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99740);
        return;
      }
      az.a.okP.a(paramView.OMN, "", new az.b.a()
      {
        public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(308251);
          if (bv.24.this.RFN.tipDialog != null) {
            bv.24.this.RFN.tipDialog.dismiss();
          }
          if (!paramAnonymousBoolean)
          {
            Toast.makeText(bv.24.this.RFN.context, bv.24.this.RFN.context.getString(b.j.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
            AppMethodBeat.o(308251);
            return;
          }
          d.aS(paramAnonymousString, 3);
          q.bFG().LB(paramAnonymousString);
          Intent localIntent = new Intent();
          localIntent.addFlags(268435456);
          localIntent.putExtra("Contact_User", paramAnonymousString);
          localIntent.putExtra("Contact_Scene", 37);
          com.tencent.mm.kernel.h.baF();
          au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramAnonymousString);
          if ((localau != null) && (localau.iZC()))
          {
            com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, paramAnonymousString + ",37");
            localIntent.putExtra("Contact_Scene", 37);
          }
          com.tencent.mm.plugin.sns.d.a.pFn.c(localIntent, bv.24.this.RFN.context);
          AppMethodBeat.o(308251);
        }
      });
      localObject = this.RFN;
      Context localContext = this.RFN.context;
      this.RFN.context.getString(b.j.app_tip);
      ((bv)localObject).tipDialog = k.a(localContext, this.RFN.context.getString(b.j.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(308263);
          az.a.okP.Jq(paramView.OMN);
          AppMethodBeat.o(308263);
        }
      });
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bv.24
 * JD-Core Version:    0.7.0.1
 */