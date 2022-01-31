package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;

final class l$a$1
  implements View.OnClickListener
{
  l$a$1(l.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28140);
    if (!PlatformComm.C2Java.isNetworkConnected())
    {
      ab.w("MicroMsg.MailPhoneMenuHelper", "hy: no network. abort download");
      t.makeText(l.a.a(this.wcA), l.a.a(this.wcA).getString(2131300044), 0).show();
      if (l.a.b(this.wcA) != null)
      {
        l.a.b(this.wcA).iL(false);
        AppMethodBeat.o(28140);
      }
    }
    else
    {
      q.i(l.a.a(this.wcA), l.a.c(this.wcA));
      if (l.a.b(this.wcA) != null) {
        l.a.b(this.wcA).iL(true);
      }
    }
    AppMethodBeat.o(28140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l.a.1
 * JD-Core Version:    0.7.0.1
 */