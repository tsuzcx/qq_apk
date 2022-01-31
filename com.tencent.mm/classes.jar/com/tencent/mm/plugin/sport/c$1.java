package com.tencent.mm.plugin.sport;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sport.b.b;
import com.tencent.mm.plugin.sport.c.i;
import com.tencent.mm.plugin.sport.c.n;
import com.tencent.mm.plugin.sport.c.n.1;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.s;

final class c$1
  implements Runnable
{
  c$1(c paramc, Activity paramActivity, String paramString) {}
  
  public final void run()
  {
    Activity localActivity = this.val$activity;
    String str = this.dol;
    if (((n.ptK == null) || (!n.ptK.isShowing())) && (i.Q(5, 1L) != 0L) && (q.Gj().equals(str)) && (!((b)g.r(b.class)).ej(ae.getContext()))) {
      n.ptK = s.a(localActivity, b.a.tipsbar_red_bg_color, b.c.tipsbar_icon_warning, ae.getContext().getString(b.d.sport_device_not_support), b.b.tipsbar_icon_close_dark_selector, new n.1());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c.1
 * JD-Core Version:    0.7.0.1
 */