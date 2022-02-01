package com.tencent.mm.plugin.sport;

import android.app.Activity;
import android.content.Context;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.model.a;
import com.tencent.mm.plugin.sport.model.a.3;
import com.tencent.mm.plugin.sport.model.f;
import com.tencent.mm.plugin.sport.model.j;
import com.tencent.mm.plugin.sport.model.l;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;

public final class b
  implements com.tencent.mm.plugin.sport.a.b
{
  public final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(149261);
    if (g.ajx())
    {
      paramString1 = new f(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, 1);
      g.aiU().a(paramString1, 0);
    }
    AppMethodBeat.o(149261);
  }
  
  public final void efX()
  {
    AppMethodBeat.i(149260);
    if (((PluginSport)g.ad(PluginSport.class)).getDeviceStepManager() != null) {
      ((PluginSport)g.ad(PluginSport.class)).getDeviceStepManager().egb();
    }
    AppMethodBeat.o(149260);
  }
  
  public final boolean efY()
  {
    AppMethodBeat.i(149263);
    boolean bool = l.efY();
    AppMethodBeat.o(149263);
    return bool;
  }
  
  public final void efZ()
  {
    AppMethodBeat.i(149264);
    if (aj.cmR())
    {
      ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().reset();
      a locala = ((PluginSport)g.ad(PluginSport.class)).getDeviceStepManager();
      h.LTJ.f(new a.3(locala), "Sport.clearConfigToPush");
    }
    AppMethodBeat.o(149264);
  }
  
  public final void ega()
  {
    AppMethodBeat.i(149266);
    l.dbE();
    AppMethodBeat.o(149266);
  }
  
  public final void g(final Activity paramActivity, final String paramString)
  {
    AppMethodBeat.i(149265);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(149259);
        l.g(paramActivity, paramString);
        AppMethodBeat.o(149259);
      }
    });
    AppMethodBeat.o(149265);
  }
  
  public final boolean gq(Context paramContext)
  {
    AppMethodBeat.i(149262);
    boolean bool = l.gq(paramContext);
    AppMethodBeat.o(149262);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.b
 * JD-Core Version:    0.7.0.1
 */