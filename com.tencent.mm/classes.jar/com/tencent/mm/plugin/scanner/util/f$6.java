package com.tencent.mm.plugin.scanner.util;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.pz.b;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class f$6
  implements Runnable
{
  f$6(f paramf, pz parampz, int paramInt1, String paramString, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(81398);
    if (!bo.isNullOrNil(this.kNV.cGz.errMsg)) {
      Toast.makeText(this.qCz.getContext(), this.kNV.cGz.errMsg, 1).show();
    }
    for (;;)
    {
      if (this.qCz.qCw != null) {
        this.qCz.qCw.q(3, null);
      }
      AppMethodBeat.o(81398);
      return;
      if (bo.isNullOrNil(this.kNV.cGz.cGB))
      {
        ab.w("MicroMsg.QBarStringHandler", "resp url is null!");
      }
      else if (this.kNV.cGz.actionType == 1)
      {
        h.a(this.qCz.getContext(), this.kNV.cGz.cGB, this.bZV, this.qCB, this.fwD);
      }
      else
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", this.kNV.cGz.cGB);
        c.gmO.i(localIntent, this.qCz.getContext());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.f.6
 * JD-Core Version:    0.7.0.1
 */