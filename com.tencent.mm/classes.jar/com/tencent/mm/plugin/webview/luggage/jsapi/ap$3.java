package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.c;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class ap$3
  implements ao.b.a
{
  ap$3(ap paramap, Context paramContext, bh.a parama, ProgressDialog paramProgressDialog, Intent paramIntent) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(6352);
    if (this.val$context == null)
    {
      ab.w("MicroMsg.JsApiProfile", "getNow callback, msghandler has already been detached!");
      this.lax.c("fail", null);
      AppMethodBeat.o(6352);
      return;
    }
    if (this.efE != null) {
      this.efE.dismiss();
    }
    ad localad2 = ((j)g.E(j.class)).YA().arw(paramString);
    ad localad1;
    if (localad2 != null)
    {
      localad1 = localad2;
      if ((int)localad2.euF > 0) {}
    }
    else
    {
      localad1 = ((j)g.E(j.class)).YA().ars(paramString);
    }
    if ((localad1 == null) || ((int)localad1.euF <= 0)) {
      paramBoolean = false;
    }
    while (!paramBoolean)
    {
      l.q(new ap.3.1(this));
      this.lax.c("fail", null);
      AppMethodBeat.o(6352);
      return;
      paramString = localad1.field_username;
    }
    b.U(paramString, 3);
    o.adi().qU(paramString);
    this.val$intent.addFlags(268435456);
    this.val$intent.putExtra("Contact_User", paramString);
    if (localad1.dwz())
    {
      h.qsU.kvStat(10298, localad1.field_username + ",42");
      this.val$intent.putExtra("Contact_Scene", 42);
    }
    com.tencent.mm.plugin.webview.a.a.gmO.c(this.val$intent, this.val$context);
    this.lax.c(null, null);
    AppMethodBeat.o(6352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ap.3
 * JD-Core Version:    0.7.0.1
 */