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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;

final class bl$10
  implements View.OnClickListener
{
  bl$10(bl parambl) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(99734);
    if ((paramView.getTag() instanceof bi))
    {
      paramView = (bi)paramView.getTag();
      if (bt.isNullOrNil(paramView.xLh))
      {
        ad.e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
        Toast.makeText(this.xLM.context, this.xLM.context.getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
        AppMethodBeat.o(99734);
        return;
      }
      g.afC();
      Object localObject = ((k)g.ab(k.class)).apM().aHY(paramView.xLh);
      if ((localObject != null) && (((au)localObject).field_username.equals(paramView.xLh)))
      {
        localObject = new Intent();
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("Contact_User", paramView.xLh);
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(10298, paramView.xLh + ",37");
        ((Intent)localObject).putExtra("Contact_Scene", 37);
        a.hYt.c((Intent)localObject, this.xLM.context);
        AppMethodBeat.o(99734);
        return;
      }
      ar.a.gMW.a(paramView.xLh, "", new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(99732);
          if (bl.10.this.xLM.tipDialog != null) {
            bl.10.this.xLM.tipDialog.dismiss();
          }
          if (!paramAnonymousBoolean)
          {
            Toast.makeText(bl.10.this.xLM.context, bl.10.this.xLM.context.getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
            AppMethodBeat.o(99732);
            return;
          }
          c.ac(paramAnonymousString, 3);
          com.tencent.mm.ak.p.auH().vP(paramAnonymousString);
          Intent localIntent = new Intent();
          localIntent.addFlags(268435456);
          localIntent.putExtra("Contact_User", paramAnonymousString);
          localIntent.putExtra("Contact_Scene", 37);
          g.afC();
          af localaf = ((k)g.ab(k.class)).apM().aHY(paramAnonymousString);
          if ((localaf != null) && (localaf.eKB()))
          {
            com.tencent.mm.plugin.report.service.h.vKh.kvStat(10298, paramAnonymousString + ",37");
            localIntent.putExtra("Contact_Scene", 37);
          }
          a.hYt.c(localIntent, bl.10.this.xLM.context);
          AppMethodBeat.o(99732);
        }
      });
      localObject = this.xLM;
      Context localContext = this.xLM.context;
      this.xLM.context.getString(2131755906);
      ((bl)localObject).tipDialog = com.tencent.mm.ui.base.h.b(localContext, this.xLM.context.getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(99733);
          ar.a.gMW.tX(paramView.xLh);
          AppMethodBeat.o(99733);
        }
      });
    }
    AppMethodBeat.o(99734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bl.10
 * JD-Core Version:    0.7.0.1
 */