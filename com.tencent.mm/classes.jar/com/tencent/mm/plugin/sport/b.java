package com.tencent.mm.plugin.sport;

import android.app.Activity;
import android.content.Context;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.model.a;
import com.tencent.mm.plugin.sport.model.a.3;
import com.tencent.mm.plugin.sport.model.e;
import com.tencent.mm.plugin.sport.model.k;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b
  implements com.tencent.mm.plugin.sport.a.b
{
  public final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(149261);
    if (g.aAc())
    {
      paramString1 = new e(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, 1);
      g.azz().a(paramString1, 0);
    }
    AppMethodBeat.o(149261);
  }
  
  public final void fmf()
  {
    AppMethodBeat.i(149260);
    if (((PluginSport)g.ah(PluginSport.class)).getDeviceStepManager() != null) {
      ((PluginSport)g.ah(PluginSport.class)).getDeviceStepManager().fmj();
    }
    AppMethodBeat.o(149260);
  }
  
  public final boolean fmg()
  {
    AppMethodBeat.i(149263);
    boolean bool = k.fmg();
    AppMethodBeat.o(149263);
    return bool;
  }
  
  public final void fmh()
  {
    AppMethodBeat.i(149264);
    if (MMApplicationContext.isMainProcess())
    {
      ((PluginSport)g.ah(PluginSport.class)).getSportFileStorage().reset();
      a locala = ((PluginSport)g.ah(PluginSport.class)).getDeviceStepManager();
      h.RTc.b(new a.3(locala), "Sport.clearConfigToPush");
    }
    AppMethodBeat.o(149264);
  }
  
  public final void fmi()
  {
    AppMethodBeat.i(149266);
    k.dYf();
    AppMethodBeat.o(149266);
  }
  
  public final boolean hg(Context paramContext)
  {
    AppMethodBeat.i(149262);
    boolean bool = k.hg(paramContext);
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
        k.l(paramActivity, paramString);
        AppMethodBeat.o(149259);
      }
    });
    AppMethodBeat.o(149265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.b
 * JD-Core Version:    0.7.0.1
 */