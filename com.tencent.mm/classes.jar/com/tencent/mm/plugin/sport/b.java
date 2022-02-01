package com.tencent.mm.plugin.sport;

import android.app.Activity;
import android.content.Context;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.model.a;
import com.tencent.mm.plugin.sport.model.a.3;
import com.tencent.mm.plugin.sport.model.f;
import com.tencent.mm.plugin.sport.model.j;
import com.tencent.mm.plugin.sport.model.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;

public final class b
  implements com.tencent.mm.plugin.sport.a.b
{
  public final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(149261);
    if (g.agM())
    {
      paramString1 = new f(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, 1);
      g.agi().a(paramString1, 0);
    }
    AppMethodBeat.o(149261);
  }
  
  public final void dTJ()
  {
    AppMethodBeat.i(149260);
    if (((PluginSport)g.ad(PluginSport.class)).getDeviceStepManager() != null) {
      ((PluginSport)g.ad(PluginSport.class)).getDeviceStepManager().dTN();
    }
    AppMethodBeat.o(149260);
  }
  
  public final boolean dTK()
  {
    AppMethodBeat.i(149263);
    boolean bool = l.dTK();
    AppMethodBeat.o(149263);
    return bool;
  }
  
  public final void dTL()
  {
    AppMethodBeat.i(149264);
    if (ai.cin())
    {
      ((PluginSport)g.ad(PluginSport.class)).getSportFileStorage().reset();
      a locala = ((PluginSport)g.ad(PluginSport.class)).getDeviceStepManager();
      h.JZN.f(new a.3(locala), "Sport.clearConfigToPush");
    }
    AppMethodBeat.o(149264);
  }
  
  public final void dTM()
  {
    AppMethodBeat.i(149266);
    l.cSx();
    AppMethodBeat.o(149266);
  }
  
  public final void g(final Activity paramActivity, final String paramString)
  {
    AppMethodBeat.i(149265);
    ap.f(new Runnable()
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
  
  public final boolean gn(Context paramContext)
  {
    AppMethodBeat.i(149262);
    boolean bool = l.gn(paramContext);
    AppMethodBeat.o(149262);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.b
 * JD-Core Version:    0.7.0.1
 */