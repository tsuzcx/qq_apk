package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.c;
import com.tencent.mm.ag.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.p;

final class bf$9$1
  implements am.b.a
{
  bf$9$1(bf.9 param9) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    if (this.pkh.pkg.tipDialog != null) {
      this.pkh.pkg.tipDialog.dismiss();
    }
    if (!paramBoolean)
    {
      Toast.makeText(this.pkh.pkg.context, this.pkh.pkg.context.getString(i.j.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
      return;
    }
    b.M(paramString, 3);
    o.Kj().kb(paramString);
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("Contact_User", paramString);
    localIntent.putExtra("Contact_Scene", 37);
    g.DQ();
    ad localad = ((j)g.r(j.class)).Fw().abl(paramString);
    if ((localad != null) && (localad.cua()))
    {
      h.nFQ.aC(10298, paramString + ",37");
      localIntent.putExtra("Contact_Scene", 37);
    }
    a.eUR.d(localIntent, this.pkh.pkg.context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf.9.1
 * JD-Core Version:    0.7.0.1
 */