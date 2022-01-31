package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;

final class l$a$1
  implements View.OnClickListener
{
  l$a$1(l.a parama) {}
  
  public final void onClick(View paramView)
  {
    if (!PlatformComm.C2Java.isNetworkConnected())
    {
      y.w("MicroMsg.MailPhoneMenuHelper", "hy: no network. abort download");
      s.makeText(l.a.a(this.sjT), l.a.a(this.sjT).getString(R.l.fmt_iap_err), 0).show();
      if (l.a.b(this.sjT) != null) {
        l.a.b(this.sjT).hb(false);
      }
    }
    do
    {
      return;
      q.g(l.a.a(this.sjT), l.a.c(this.sjT));
    } while (l.a.b(this.sjT) == null);
    l.a.b(this.sjT).hb(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l.a.1
 * JD-Core Version:    0.7.0.1
 */