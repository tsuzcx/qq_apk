package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;

final class ag$6
  implements n.d
{
  ag$6(ag paramag) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 0: 
      paramMenuItem = this.oSk;
      paramInt = 9 - paramMenuItem.oSd.oSo.size();
      if (paramInt <= 0)
      {
        y.e("MicroMsg.PicWidget", "has select the max image count");
        return;
      }
      Intent localIntent;
      if (paramInt < 9)
      {
        h.nFQ.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
        localIntent = new Intent();
        l.a(paramMenuItem.bER, 11, localIntent, 2, 2);
      }
      for (;;)
      {
        paramMenuItem.yB(1);
        return;
        h.nFQ.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
        localIntent = new Intent();
        l.a(paramMenuItem.bER, 11, localIntent, 2, 0);
      }
    }
    paramInt = 9 - this.oSk.oSd.oSo.size();
    if (paramInt <= 0)
    {
      y.e("MicroMsg.PicWidget", "has select the max image count");
      return;
    }
    paramMenuItem = this.oSk.bER.getSharedPreferences(ae.cqR(), 0).getString("gallery", "1");
    h.nFQ.f(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
    if (paramMenuItem.equalsIgnoreCase("0")) {
      l.T(this.oSk.bER);
    }
    for (;;)
    {
      this.oSk.yB(2);
      return;
      if (paramInt < 9) {
        l.a(this.oSk.bER, 9, paramInt, 4, 1, false, null);
      } else {
        l.a(this.oSk.bER, 9, paramInt, 4, 3, false, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag.6
 * JD-Core Version:    0.7.0.1
 */