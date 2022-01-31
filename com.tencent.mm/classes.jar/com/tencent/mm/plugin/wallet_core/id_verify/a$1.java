package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.h.a.tk;
import com.tencent.mm.h.a.tv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c;

final class a$1
  implements Runnable
{
  a$1(a parama, tk paramtk, Intent paramIntent, Activity paramActivity) {}
  
  public final void run()
  {
    this.qrw.bFJ = null;
    a.a(this.qrx);
    if ((!bk.bl(a.b(this.qrx))) && (!bk.bl(a.c(this.qrx))))
    {
      y.i("MicroMsg.RealNameVerifyProcess", "real name verify process end,jump to " + a.b(this.qrx) + a.c(this.qrx));
      boolean bool = this.qrx.kke.getBoolean("process_finish_stay_orgpage", true);
      this.dAd.putExtra("key_process_is_end", true);
      this.dAd.putExtra("key_process_is_stay", bool);
      a.a(this.qrx, this.eRW, a.b(this.qrx), a.c(this.qrx), a.d(this.qrx), this.dAd, bool);
      if (a.d(this.qrx) == -1)
      {
        localtv = new tv();
        localtv.ceh.result = a.d(this.qrx);
        com.tencent.mm.sdk.b.a.udP.m(localtv);
      }
    }
    do
    {
      return;
      this.qrx.ak(this.eRW);
    } while (a.d(this.qrx) != -1);
    tv localtv = new tv();
    localtv.ceh.result = a.d(this.qrx);
    com.tencent.mm.sdk.b.a.udP.m(localtv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.a.1
 * JD-Core Version:    0.7.0.1
 */