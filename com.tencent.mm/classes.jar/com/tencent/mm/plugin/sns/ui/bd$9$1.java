package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.c;
import com.tencent.mm.ah.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.p;

final class bd$9$1
  implements ao.b.a
{
  bd$9$1(bd.9 param9) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39870);
    if (this.scL.scK.tipDialog != null) {
      this.scL.scK.tipDialog.dismiss();
    }
    if (!paramBoolean)
    {
      Toast.makeText(this.scL.scK.context, this.scL.scK.context.getString(2131300095, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
      AppMethodBeat.o(39870);
      return;
    }
    b.U(paramString, 3);
    o.adi().qU(paramString);
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("Contact_User", paramString);
    localIntent.putExtra("Contact_Scene", 37);
    g.RM();
    ad localad = ((j)g.E(j.class)).YA().arw(paramString);
    if ((localad != null) && (localad.dwz()))
    {
      h.qsU.kvStat(10298, paramString + ",37");
      localIntent.putExtra("Contact_Scene", 37);
    }
    a.gmO.c(localIntent, this.scL.scK.context);
    AppMethodBeat.o(39870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd.9.1
 * JD-Core Version:    0.7.0.1
 */