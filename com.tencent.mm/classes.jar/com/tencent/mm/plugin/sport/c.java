package com.tencent.mm.plugin.sport;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sport.a.b;
import com.tencent.mm.plugin.sport.model.a;
import com.tencent.mm.plugin.sport.model.e;
import com.tencent.mm.plugin.sport.model.n;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class c
  implements b
{
  public final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(149261);
    if (h.aHB())
    {
      if (paramInt3 <= 0)
      {
        AppMethodBeat.o(149261);
        return;
      }
      paramString1 = new e(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, 1);
      h.aGY().a(paramString1, 0);
    }
    AppMethodBeat.o(149261);
  }
  
  public final void gaB()
  {
    AppMethodBeat.i(149260);
    if (((PluginSport)h.ag(PluginSport.class)).getDeviceStepManager() != null) {
      ((PluginSport)h.ag(PluginSport.class)).getDeviceStepManager().gaE();
    }
    AppMethodBeat.o(149260);
  }
  
  public final boolean gaC()
  {
    AppMethodBeat.i(149263);
    boolean bool = n.gaC();
    AppMethodBeat.o(149263);
    return bool;
  }
  
  public final void gaD()
  {
    AppMethodBeat.i(149266);
    n.eBD();
    AppMethodBeat.o(149266);
  }
  
  public final boolean ih(Context paramContext)
  {
    AppMethodBeat.i(149262);
    boolean bool = n.ih(paramContext);
    AppMethodBeat.o(149262);
    return bool;
  }
  
  public final void l(final Activity paramActivity, final String paramString)
  {
    AppMethodBeat.i(149265);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(149259);
        n.l(paramActivity, paramString);
        AppMethodBeat.o(149259);
      }
    });
    AppMethodBeat.o(149265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c
 * JD-Core Version:    0.7.0.1
 */