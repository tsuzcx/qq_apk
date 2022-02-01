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
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.q;

final class br$24
  implements View.OnClickListener
{
  br$24(br parambr) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(99740);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if ((paramView.getTag() instanceof bo))
    {
      paramView = (bo)paramView.getTag();
      if (Util.isNullOrNil(paramView.CAZ))
      {
        Log.e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
        Toast.makeText(this.ERz.context, this.ERz.context.getString(2131760879, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99740);
        return;
      }
      g.aAi();
      localObject = ((l)g.af(l.class)).aSN().Kn(paramView.CAZ);
      if ((localObject != null) && (((ax)localObject).field_username.equals(paramView.CAZ)))
      {
        localObject = new Intent();
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("Contact_User", paramView.CAZ);
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(10298, paramView.CAZ + ",37");
        ((Intent)localObject).putExtra("Contact_Scene", 37);
        com.tencent.mm.plugin.sns.c.a.jRt.c((Intent)localObject, this.ERz.context);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99740);
        return;
      }
      ay.a.iDq.a(paramView.CAZ, "", new ay.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(203843);
          if (br.24.this.ERz.tipDialog != null) {
            br.24.this.ERz.tipDialog.dismiss();
          }
          if (!paramAnonymousBoolean)
          {
            Toast.makeText(br.24.this.ERz.context, br.24.this.ERz.context.getString(2131760879, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
            AppMethodBeat.o(203843);
            return;
          }
          c.ap(paramAnonymousString, 3);
          p.aYD().Mg(paramAnonymousString);
          Intent localIntent = new Intent();
          localIntent.addFlags(268435456);
          localIntent.putExtra("Contact_User", paramAnonymousString);
          localIntent.putExtra("Contact_Scene", 37);
          g.aAi();
          as localas = ((l)g.af(l.class)).aSN().Kn(paramAnonymousString);
          if ((localas != null) && (localas.gBM()))
          {
            com.tencent.mm.plugin.report.service.h.CyF.kvStat(10298, paramAnonymousString + ",37");
            localIntent.putExtra("Contact_Scene", 37);
          }
          com.tencent.mm.plugin.sns.c.a.jRt.c(localIntent, br.24.this.ERz.context);
          AppMethodBeat.o(203843);
        }
      });
      localObject = this.ERz;
      Context localContext = this.ERz.context;
      this.ERz.context.getString(2131755998);
      ((br)localObject).tipDialog = com.tencent.mm.ui.base.h.a(localContext, this.ERz.context.getString(2131756029), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(203844);
          ay.a.iDq.JZ(paramView.CAZ);
          AppMethodBeat.o(203844);
        }
      });
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.br.24
 * JD-Core Version:    0.7.0.1
 */