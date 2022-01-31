package com.tencent.mm.plugin.multitalk.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;

final class f$2
  extends BroadcastReceiver
{
  f$2(f paramf) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(53941);
    if (!this.oTN.bSD())
    {
      AppMethodBeat.o(53941);
      return;
    }
    if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
    {
      f.h(this.oTN).removeCallbacksAndMessages(null);
      f.h(this.oTN).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(53938);
          j.a locala1 = j.bTx();
          if (locala1 != f.i(f.2.this.oTN))
          {
            j.a locala2 = f.i(f.2.this.oTN);
            f.a(f.2.this.oTN, locala1);
            ab.i("MicroMsg.MT.MultiTalkManager", "steve: network change: %s -> %s", new Object[] { locala2.name(), f.i(f.2.this.oTN).name() });
            f.2.this.oTN.zF(f.j(f.2.this.oTN));
            if (f.k(f.2.this.oTN) != null) {
              f.k(f.2.this.oTN).a(f.i(f.2.this.oTN));
            }
            AppMethodBeat.o(53938);
            return;
          }
          f.2.this.oTN.zF(f.j(f.2.this.oTN));
          ab.i("MicroMsg.MT.MultiTalkManager", "network not change: %s", new Object[] { f.i(f.2.this.oTN).name() });
          AppMethodBeat.o(53938);
        }
      }, 8000L);
      AppMethodBeat.o(53941);
      return;
    }
    int i = j.x(paramContext, paramIntent);
    ab.i("MicroMsg.MT.MultiTalkManager", "phone state %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      al.d(new f.2.2(this));
      AppMethodBeat.o(53941);
      return;
    }
    al.d(new f.2.3(this));
    AppMethodBeat.o(53941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.f.2
 * JD-Core Version:    0.7.0.1
 */