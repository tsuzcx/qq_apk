package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.plugin.webview.model.as.e;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;

final class j$10
  implements n.d
{
  j$10(j paramj) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramInt = 0;
    AppMethodBeat.i(153214);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(153214);
      return;
      paramMenuItem = this.vcO.ddt().getIntent().getStringExtra("KPublisherId");
      String str1 = this.vcO.ddt().getIntent().getStringExtra("KAppId");
      String str2 = this.vcO.ddt().getIntent().getStringExtra("srcUsername");
      as.e locale = this.vcO.ddt().uVh.dcp();
      locale.uWQ = new Object[] { this.vcO.ddt().cJr, Integer.valueOf(1), Integer.valueOf(1), paramMenuItem, str1, str2 };
      locale.b(this.vcO.ddt().igU);
      this.vcO.ddt().veA = this.vcO.ddt().igV.ddW().dqx();
      this.vcO.ddt().cnh();
      AppMethodBeat.o(153214);
      return;
      paramMenuItem = this.vcO.ddt().getIntent().getStringExtra("KPublisherId");
      str1 = this.vcO.ddt().getIntent().getStringExtra("KAppId");
      str2 = this.vcO.ddt().getIntent().getStringExtra("srcUsername");
      locale = this.vcO.ddt().uVh.dcp();
      locale.uWQ = new Object[] { this.vcO.ddt().cJr, Integer.valueOf(2), Integer.valueOf(1), paramMenuItem, str1, str2 };
      locale.b(this.vcO.ddt().igU);
      this.vcO.ddt().veA = this.vcO.ddt().igV.ddW().dqx();
      if (this.vcO.vcI.containsKey(this.vcO.ddt().pOd.getUrl())) {
        paramInt = ((Integer)this.vcO.vcI.get(this.vcO.ddt().pOd.getUrl())).intValue();
      }
      j.a(this.vcO, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j.10
 * JD-Core Version:    0.7.0.1
 */