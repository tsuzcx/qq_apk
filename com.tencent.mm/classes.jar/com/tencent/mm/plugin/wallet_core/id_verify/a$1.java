package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c;

final class a$1
  implements Runnable
{
  a$1(a parama, vf paramvf, Intent paramIntent, Activity paramActivity) {}
  
  public final void run()
  {
    AppMethodBeat.i(46575);
    this.ucv.callback = null;
    a.a(this.ucw);
    vr localvr;
    if ((!bo.isNullOrNil(a.b(this.ucw))) && (!bo.isNullOrNil(a.c(this.ucw))))
    {
      ab.i("MicroMsg.RealNameVerifyProcess", "real name verify process end,jump to " + a.b(this.ucw) + a.c(this.ucw));
      boolean bool = this.ucw.mEJ.getBoolean("process_finish_stay_orgpage", true);
      this.etp.putExtra("key_process_is_end", true);
      this.etp.putExtra("key_process_is_stay", bool);
      if (this.etp.getExtras().getBoolean("is_from_new_cashier"))
      {
        a.a(this.ucw, this.gjR, a.b(this.ucw), a.c(this.ucw), a.d(this.ucw), this.etp, bool);
        if (a.e(this.ucw) != null) {
          a.e(this.ucw).run(this.gjR);
        }
        AppMethodBeat.o(46575);
        return;
      }
      a.b(this.ucw, this.gjR, a.b(this.ucw), a.c(this.ucw), a.d(this.ucw), this.etp, bool);
      if (a.d(this.ucw) == -1)
      {
        localvr = new vr();
        localvr.cMV.result = a.d(this.ucw);
        com.tencent.mm.sdk.b.a.ymk.l(localvr);
      }
      AppMethodBeat.o(46575);
      return;
    }
    this.ucw.aO(this.gjR);
    if (a.d(this.ucw) == -1)
    {
      localvr = new vr();
      localvr.cMV.result = a.d(this.ucw);
      com.tencent.mm.sdk.b.a.ymk.l(localvr);
    }
    AppMethodBeat.o(46575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.a.1
 * JD-Core Version:    0.7.0.1
 */