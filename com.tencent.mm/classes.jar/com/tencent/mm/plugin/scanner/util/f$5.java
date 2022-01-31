package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
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

final class f$5
  implements Runnable
{
  f$5(f paramf, pz parampz, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(81397);
    Object localObject;
    if (!bo.isNullOrNil(this.kNV.cGz.errMsg))
    {
      localObject = this.qCz.getContext();
      if (localObject != null) {
        Toast.makeText((Context)localObject, this.kNV.cGz.errMsg, 1).show();
      }
    }
    for (;;)
    {
      if (this.qCz.qCw != null) {
        this.qCz.qCw.q(3, null);
      }
      AppMethodBeat.o(81397);
      return;
      if (bo.isNullOrNil(this.kNV.cGz.cGB))
      {
        ab.w("MicroMsg.QBarStringHandler", "resp url is null!");
      }
      else if (this.kNV.cGz.actionType == 1)
      {
        h.a(this.qCz.getContext(), 1, this.kNV.cGz.cGB, this.bZV, null);
      }
      else
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", this.kNV.cGz.cGB);
        c.gmO.i((Intent)localObject, this.qCz.getContext());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.f.5
 * JD-Core Version:    0.7.0.1
 */