package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.c.a;

final class q$3
  implements n.d
{
  q$3(q paramq, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      new Intent();
      h.nFQ.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      l.a(q.e(this.vjS).vtz, new Intent(), this.vjS.getTalkerUserName(), this.uQO);
      return;
    }
    d.b(q.e(this.vjS).vtz.getContext(), "mmsight", ".ui.SightSettingsUI", new Intent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.3
 * JD-Core Version:    0.7.0.1
 */