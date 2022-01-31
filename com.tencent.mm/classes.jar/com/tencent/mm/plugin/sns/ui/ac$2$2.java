package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;

final class ac$2$2
  implements n.d
{
  ac$2$2(ac.2 param2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 0: 
      paramMenuItem = this.oRf.oRe;
      paramMenuItem.yB(1);
      h.nFQ.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
      Intent localIntent = new Intent();
      l.a(paramMenuItem.bER, 11, localIntent, 2, 0);
      return;
    }
    paramMenuItem = this.oRf.oRe.bER.getSharedPreferences(ae.cqR(), 0).getString("gallery", "1");
    h.nFQ.f(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
    if (paramMenuItem.equalsIgnoreCase("0")) {
      l.T(this.oRf.oRe.bER);
    }
    for (;;)
    {
      this.oRf.oRe.yB(2);
      return;
      l.a(this.oRf.oRe.bER, 9, 9, 4, 3, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ac.2.2
 * JD-Core Version:    0.7.0.1
 */