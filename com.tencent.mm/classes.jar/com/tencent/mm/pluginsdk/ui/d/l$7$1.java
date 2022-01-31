package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.h.c;

final class l$7$1
  implements h.c
{
  l$7$1(l.7 param7, String paramString) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(28137);
    if (this.wcx.wcs != null) {
      this.wcx.wcs.onDismiss(null);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28137);
      return;
      if (l.dpp())
      {
        Context localContext = this.wcx.val$context;
        String str = this.kyt;
        Intent localIntent = new Intent("android.intent.action.INSERT");
        localIntent.setType("vnd.android.cursor.dir/contact");
        localIntent.putExtra("phone", str);
        localContext.startActivity(localIntent);
        h.qsU.kvStat(10113, "1");
        AppMethodBeat.o(28137);
        return;
      }
      l.bB(this.wcx.val$context, this.kyt);
      h.qsU.kvStat(10114, "1");
      AppMethodBeat.o(28137);
      return;
      l.bB(this.wcx.val$context, this.kyt);
      h.qsU.kvStat(10114, "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l.7.1
 * JD-Core Version:    0.7.0.1
 */