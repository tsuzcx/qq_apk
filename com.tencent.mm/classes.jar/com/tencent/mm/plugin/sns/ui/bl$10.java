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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;

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
      if (bs.isNullOrNil(paramView.yXW))
      {
        ac.e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
        Toast.makeText(this.yYB.context, this.yYB.context.getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
        AppMethodBeat.o(99734);
        return;
      }
      g.agS();
      Object localObject = ((k)g.ab(k.class)).awB().aNt(paramView.yXW);
      if ((localObject != null) && (((av)localObject).field_username.equals(paramView.yXW)))
      {
        localObject = new Intent();
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("Contact_User", paramView.yXW);
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, paramView.yXW + ",37");
        ((Intent)localObject).putExtra("Contact_Scene", 37);
        a.iyx.c((Intent)localObject, this.yYB.context);
        AppMethodBeat.o(99734);
        return;
      }
      ar.a.hnw.a(paramView.yXW, "", new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(99732);
          if (bl.10.this.yYB.tipDialog != null) {
            bl.10.this.yYB.tipDialog.dismiss();
          }
          if (!paramAnonymousBoolean)
          {
            Toast.makeText(bl.10.this.yYB.context, bl.10.this.yYB.context.getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
            AppMethodBeat.o(99732);
            return;
          }
          c.ag(paramAnonymousString, 3);
          com.tencent.mm.aj.p.aBy().zV(paramAnonymousString);
          Intent localIntent = new Intent();
          localIntent.addFlags(268435456);
          localIntent.putExtra("Contact_User", paramAnonymousString);
          localIntent.putExtra("Contact_Scene", 37);
          g.agS();
          ai localai = ((k)g.ab(k.class)).awB().aNt(paramAnonymousString);
          if ((localai != null) && (localai.fad()))
          {
            com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, paramAnonymousString + ",37");
            localIntent.putExtra("Contact_Scene", 37);
          }
          a.iyx.c(localIntent, bl.10.this.yYB.context);
          AppMethodBeat.o(99732);
        }
      });
      localObject = this.yYB;
      Context localContext = this.yYB.context;
      this.yYB.context.getString(2131755906);
      ((bl)localObject).tipDialog = com.tencent.mm.ui.base.h.b(localContext, this.yYB.context.getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(99733);
          ar.a.hnw.yd(paramView.yXW);
          AppMethodBeat.o(99733);
        }
      });
    }
    AppMethodBeat.o(99734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bl.10
 * JD-Core Version:    0.7.0.1
 */