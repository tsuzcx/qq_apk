package com.tencent.mm.plugin.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.sdk.platformtools.ac;

public class ExitAccountReceiver
  extends BroadcastReceiver
{
  public void onReceive(final Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(190962);
    com.tencent.mm.kernel.g.agi().a(282, new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(190961);
        paramAnonymousString = u.axw();
        if (ca.hpQ.yB(paramAnonymousString)) {
          ca.hpQ.m(paramAnonymousString, "last_logout_no_pwd_ticket", "");
        }
        ExitAccountReceiver.fY(paramContext);
        AppMethodBeat.o(190961);
      }
    });
    paramContext = new r();
    com.tencent.mm.kernel.g.agi().a(paramContext, 0);
    ac.i("MicroMsg.ExitAccountReceiver", "UATBroadcastReceiver onReceive");
    AppMethodBeat.o(190962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ExitAccountReceiver
 * JD-Core Version:    0.7.0.1
 */