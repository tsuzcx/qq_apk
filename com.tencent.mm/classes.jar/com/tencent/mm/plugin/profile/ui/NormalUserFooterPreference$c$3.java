package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.aw;
import com.tencent.mm.ui.MMActivity;

final class NormalUserFooterPreference$c$3
  implements a.a
{
  NormalUserFooterPreference$c$3(NormalUserFooterPreference.c paramc) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(23701);
    if (paramBoolean1)
    {
      this.pCn.pCe.frK.cy("hide_btn");
      this.pCn.pCe.frK.doNotify();
      NormalUserFooterPreference.v(this.pCn.pCe);
      NormalUserFooterPreference.c.a(this.pCn);
    }
    for (;;)
    {
      if ((paramBoolean1) || (paramBoolean2))
      {
        paramString1 = NormalUserFooterPreference.b(this.pCn.pCe).getIntent();
        int i = paramString1.getIntExtra("search_kvstat_scene", 0);
        int j = paramString1.getIntExtra("search_kvstat_position", 0);
        if ((i > 0) && (j > 0)) {
          h.qsU.e(10991, new Object[] { Integer.valueOf(i), Integer.valueOf(6), Integer.valueOf(j) });
        }
      }
      AppMethodBeat.o(23701);
      return;
      if (paramBoolean2) {
        d.ali().eD(paramString1, 2);
      } else {
        ab.e("MicroMsg.NormalUserFooterPreference", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(paramString1)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c.3
 * JD-Core Version:    0.7.0.1
 */