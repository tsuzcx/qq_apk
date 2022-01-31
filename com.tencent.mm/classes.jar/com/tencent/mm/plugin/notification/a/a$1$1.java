package com.tencent.mm.plugin.notification.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class a$1$1
  implements Runnable
{
  a$1$1(a.1 param1, String paramString) {}
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(23093);
    if (!g.RJ().QU())
    {
      ab.w("MicroMsg.NotificationObserver", "account not init.");
      AppMethodBeat.o(23093);
      return;
    }
    int j = f.Nm();
    aw.aaz();
    ad localad = c.YA().arw(this.pit);
    boolean bool;
    if (localad == null)
    {
      bool = false;
      if (!bool) {
        break label94;
      }
    }
    for (;;)
    {
      al.d(new a.1.1.1(this, j, bool, i));
      AppMethodBeat.o(23093);
      return;
      bool = localad.DP();
      break;
      label94:
      i = f.ly(this.pit);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.a.a.1.1
 * JD-Core Version:    0.7.0.1
 */