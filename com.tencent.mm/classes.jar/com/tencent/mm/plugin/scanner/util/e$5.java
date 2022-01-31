package com.tencent.mm.plugin.scanner.util;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.h.a.ox;
import com.tencent.mm.h.a.ox.b;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class e$5
  implements Runnable
{
  e$5(e parame, ox paramox, int paramInt) {}
  
  public final void run()
  {
    if (!bk.bl(this.iHR.bYy.aox)) {
      Toast.makeText(this.nOI.getContext(), this.iHR.bYy.aox, 1).show();
    }
    for (;;)
    {
      if (this.nOI.nOF != null) {
        this.nOI.nOF.n(3, null);
      }
      return;
      if (bk.bl(this.iHR.bYy.bYA))
      {
        y.w("MicroMsg.QBarStringHandler", "resp url is null!");
      }
      else if (this.iHR.bYy.actionType == 1)
      {
        h.a(this.nOI.getContext(), 1, this.iHR.bYy.bYA, this.bxT, null);
      }
      else
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", this.iHR.bYy.bYA);
        b.eUR.j(localIntent, this.nOI.getContext());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.e.5
 * JD-Core Version:    0.7.0.1
 */